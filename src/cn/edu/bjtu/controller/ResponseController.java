
package cn.edu.bjtu.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.GoodsInfoService;
import cn.edu.bjtu.service.ResponseService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DownloadFile;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadPath;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Response;

import com.alibaba.fastjson.JSONArray;

@Controller
/**
 * ������ؿ�����
 * @author RussWest0
 * @date   2015��6��2�� ����11:04:13
 */
public class ResponseController {
	
	@Autowired
	ResponseService responseService;
	@Autowired
	GoodsInfoService goodsInfoService;
	
	@Autowired
	CompanyService companyService;
	
	ModelAndView mv=new ModelAndView();
	
	/**
	 * �ҵĻ���-�鿴��������(δȷ��ǰ)
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetail")
	public ModelAndView viewResponseDetail(String goodsid){
		List<Response> respList=responseService.getResponseListByGoodsId(goodsid);
		
		mv.addObject("respList", respList);
		mv.setViewName("mgmt_r_cargo5a");
		return mv;
		
	}
	
	/**
	 * �ҵĻ���-�鿴��������(ȷ�Ϻ�)
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetailAfter")
	public ModelAndView viewResponseDetail2(String goodsid){
		List<Response> respList=responseService.getResponseListByGoodsId(goodsid);
		
		mv.addObject("respList", respList);
		mv.setViewName("mgmt_r_cargo5b");
		return mv;
		
	}
	
	/**
	 * �ҵĻ���-�鿴��������ȷ�ϣ�-�鿴
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseDetailInfo")
	public ModelAndView viewResponseDetailInfo(String responseid){
		
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("response", response);
		mv.setViewName("mgmt_r_cargo6b");
		
		return mv;
		
		
	}
	
	/**
	 * �ҵķ���-�鿴����
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("viewResponseInfo")
	public ModelAndView viewResponse(String responseid){
		
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("response", response);
		mv.setViewName("mgmt_d_response3");
		
		return mv;
		
	}
	/**
	 * ��ȡ����ȷ�ϱ� 
	 * @param goodsid
	 * @param carrrierid
	 * @return
	 */
	@RequestMapping("getConfirmResponseForm")
	public ModelAndView getConfirmResponseForm(String goodsid,String carrrierid,String responseid){
		//��Ҫ׼�������������ļ���˵��
		Response response=responseService.getResponseById(responseid);
		
		mv.addObject("responseinfo", response);
		
		mv.setViewName("mgmt_r_cargo6a");
		return mv;
	}
	
	
	/**
	 * ȷ�Ϸ�����������ת������ҳ��
	 * @param responseid
	 * @param carrierid
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("confirmResponse")
	public ModelAndView confirmResponse(String responseid,String carrierid,String goodsid){
		
		Carrierinfo carrierinfo=companyService.getCompanyById(carrierid);
		//ҳ������Ҫ���˷�id
		mv.addObject("carrierInfo", carrierinfo);
		mv.addObject("responseId", responseid);
		mv.addObject("carrierId", carrierid);
		mv.addObject("goodsId", goodsid);
		
		mv.setViewName("mgmt_d_order_s2a");
		return mv;
	}
	
	/**
	 *  ���ط����ļ�
	 * @return
	 */
	@RequestMapping("downloadResponseMaterial")
	public ModelAndView downloadResponseFile(String responseid,HttpServletRequest request,HttpServletResponse response){
		
		Response resp=responseService.getResponseById(responseid);
		String fileLocation=resp.getRelatedMaterial();
		DownloadFile.downloadFile(fileLocation, request, response);
		return mv;
	}
	
	/**
	 * ��ȡ���з���
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("getallresponse")
	public String getAllResponse() {
		return "mgmt_d_response";
	}
	
	/**
	 * ��ȡ�û������з���
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getUserResponseAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserResponse(HttpSession session,PageUtil pageUtil){
		JSONArray jsonArray=responseService.getUserResponse(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	/**
	 * �ҵķ���-������
	 * @param session
	 * @return
	 */
	@RequestMapping("getUserResponseTotalRowsAjax")
	@ResponseBody
	public Integer getUserResponseTotalRows(HttpSession session){
		return responseService.getUserResponseTotalRows(session);
		
	}

	/**
	 * ��ȡ����������
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("getresponseform")
	public ModelAndView getResponseForm(String goodsid) {
		mv.addObject("goodsId", goodsid);

		mv.setViewName("mgmt_d_response2");

		return mv;
	}

	/**
	 * ��������
	 * @param goodsid
	 * @return
	 */
	@RequestMapping("commitresponse")
	public ModelAndView commitResponse(MultipartFile file,String goodsid, String remarks,
			HttpServletRequest request, HttpServletResponse response) {

		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		String path = null;
		String fileName = null;
		if (file.getSize() != 0)// ���ϴ��ļ������
		{
			path = UploadPath.getResponsePath();// ��ͬ�ĵط�ȡ��ͬ���ϴ�·��
			fileName = file.getOriginalFilename();
			fileName = carrierId + "_" + fileName;// �ļ���
			File targetFile = new File(path, fileName);
			try { // ���� �ļ�
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		//û���ϴ��ļ������path �� filenNameĬ��Ϊnull
		boolean flag = goodsInfoService.commitResponse(goodsid, remarks,
				carrierId,path,fileName);
		if (flag == true) {
			try {
				response.sendRedirect("getallresponse");
			} catch (IOException e) {
				// 
				e.printStackTrace();
			}
		}

		return mv;
	}
	/*@RequestMapping("downloadMyResponseMaterial")
	public ModelAndView downMyResponseMaterial(String responseid){
		public ModelAndView downloadResponseFile(String responseid,HttpServletRequest request,HttpServletResponse response){
			
			Response resp=responseService.getResponseById(responseid);
			String fileLocation=resp.getRelatedMaterial();
			DownloadFile.downloadFile(fileLocation, request, response);
			return mv;
		
		return mv;
	}*/

}
