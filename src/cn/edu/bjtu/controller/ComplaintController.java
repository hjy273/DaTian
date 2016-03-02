package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.page.ComplaintBean;
import cn.edu.bjtu.service.ComplaintService;
import cn.edu.bjtu.service.OrderService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Complaintform;
import cn.edu.bjtu.vo.Orderform;

import com.alibaba.fastjson.JSONArray;

@Controller
/**
 *  Ͷ�߱������
 * @author RussWest0
 *
 */
public class ComplaintController {

	@Resource(name = "complaintServiceImpl")
	ComplaintService complaintService;
	@Resource
	OrderService orderService;
	
	private Logger logger=Logger.getLogger(ComplaintController.class);

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/mycomplaint")
	public String getUserComplaint() {
		return "mgmt_d_complain";
	}
	/**
	 * ������Ϣ-�ҵ�Ͷ��
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="getUserComplaintAjax",produces="text/html;charset=UTF-8")
	public String getUserComplaint(HttpSession session,PageUtil pageUtil,Complaintform complaint){
		JSONArray jsonArray=complaintService.getUserComplaint(session,pageUtil,complaint);
		
		return jsonArray.toString();
	}
	
	/**
	 * ������Ϣ-�ҵ�Ͷ��-�ܼ�¼����
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("getUserComplaintTotalRowsAjax")
	public Integer getUserComplaintTotalRows(HttpSession session,Complaintform complaint){
		return complaintService.getUserComplaintTotalRows(session,complaint);
	}

	/**
	 * �û���¼-�ҵ�Ͷ��-�鿴����
	 * @param complaintid
	 * @param ordernum
	 * @return
	 */
	@RequestMapping("/complaintdetail")
	public ModelAndView getcomplaintInfo(String complaintid,
			 String ordernum) {
		logger.info("��ʼ�鿴Ͷ������");
		
		Complaintform complaintInfo = complaintService.getComplaintById(complaintid);
		mv.addObject("complaintInfo", complaintInfo);
		//OrderCarrierView orderInfo = orderService.getSendOrderDetail(ordernum);
		Orderform order=orderService.getOrderByOrderNum(ordernum);
		if(order==null){
			mv.addObject("orderNum", "������Ų�����");
		}else{
			mv.addObject("orderNum", order.getOrderNum());
		}
		
		mv.setViewName("mgmt_d_complain3");

		return mv;
	}

	/**
	 * * �����ҵ�Ͷ��
	 * @param type
	 * @param theme
	 * @param content
	 * @param orderNum
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "insertComplaint", method = RequestMethod.POST)
	public String insertComplaint(
			@RequestParam(required = false) MultipartFile file,
			ComplaintBean complaintBean, HttpServletRequest request,
			HttpServletResponse response) {
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		String fileLocation=UploadFile.uploadFile(file, userId, "complaint");
		complaintBean.setRelativeMaterial(fileLocation);
		complaintService.insertComplaint(complaintBean, userId);
		return "redirect:mycomplaint";
	}

	/**
	 * ��̨Ͷ�߹���(����Ա)
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/allcomplaint")
	public ModelAndView getAllUserComplaint(HttpSession session) {
		String userId = (String) session.getAttribute(Constant.USER_ID);
		// add by RussWest0 at 2015��5��30��,����10:40:43
		if (userId == null) {// δ��¼
			mv.setViewName("adminLogin");
			return mv;
		}
		if ((int) session.getAttribute("userKind") != 1) {// �ǹ���Ա
			mv.addObject("msg", "�ǹ���Ա���ܽ���");
			mv.setViewName("index");
			return mv;
		}
		List allCompliantList = complaintService.getAllUserCompliant();
		mv.addObject("allCompliantList", allCompliantList);
		mv.setViewName("mgmt_m_complain");
		return mv;
	}

	@RequestMapping("/getcomplaintdetail")
	public ModelAndView getComplaintDetail(@RequestParam String id,
			@RequestParam String ordernum, @RequestParam int flag,
			HttpServletRequest request, HttpServletResponse response) {
		Complaintform complaintInfo = complaintService.getComplaintById(id);
		mv.addObject("complaintInfo", complaintInfo);
		//OrderCarrierView orderInfo = orderService.getSendOrderDetail(orderNum);
		Orderform orderInfo=orderService.getOrderByOrderNum(ordernum);
		if(orderInfo==null){
			mv.addObject("orderNum", "û�д˶������");
		}else{
			
			mv.addObject("orderNum", orderInfo.getOrderNum());
		}
		if (flag == 0) {

			mv.setViewName("mgmt_m_complain2");
		} else if (flag == 1) {

			mv.setViewName("mgmt_m_complain3");
		}
		return mv;
	}

	@RequestMapping("/doacceptcomplaint")
	/**
	 * ����Ͷ��
	 * @param id
	 * @param feedback
	 * @param request
	 * @param response
	 * @return
	 */
	public String doAcceptComplaint(@RequestParam String id,
			@RequestParam String feedback, HttpServletRequest request,
			HttpServletResponse response) {

		complaintService.doAcceptComplaint(id, feedback);
		return "redirect:allcomplaint";
	}

	@RequestMapping(value = "downloadrelatedmaterial", method = RequestMethod.GET)
	public ModelAndView downloadRelatedMaterial(@RequestParam String id,// GET��ʽ���룬��action��
			HttpServletRequest request, HttpServletResponse response) {
		Complaintform complaintInfo = complaintService.getComplaintById(id);
		String file = complaintInfo.getRelatedMaterial();
		DownloadFile.downloadFile(file,request,response);

		return mv;

	}
	
	/**
	 * ����Ͷ���ļ�             
	 * @param request
	 * @param response
	 * @param complaintid
	 * @return
	 */
	@RequestMapping("downloadComplaintMaterial")
	public ModelAndView downloadComplaintMaterial(HttpServletRequest request,HttpServletResponse response,String complaintid){
		
		Complaintform complaint=complaintService.getComplaintById(complaintid);
		String fileLocation=complaint.getRelatedMaterial();
		DownloadFile.downloadFile(fileLocation, request, response);
		return mv;
	}
	
	/**
	 * ��ȡ�û�Ͷ����
	 * @param session
	 * @return
	 */
	@RequestMapping("getUserComplaintRateAjax")
	@ResponseBody
	public Double getUserComplaintRateAjax(HttpSession session){
		Double rate=complaintService.getUserComplaintRateAjax(session);
		return rate;
		
	}

}
