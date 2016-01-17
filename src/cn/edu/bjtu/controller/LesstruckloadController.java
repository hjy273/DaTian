package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Truck;

@Controller
public class LesstruckloadController {
	@Autowired
	CommentService commentService;
	@Autowired
	LesstruckloadService LesstruckloadService;
	@Resource
	CompanyService companyService;
	
	@Autowired
	FocusService focusService;

	ModelAndView mv = new ModelAndView();

	/**
	 * 资源栏-零担信息
	 * @return
	 */
	@RequestMapping(value="/lesstruckload",params="flag=0")
	public String getAllTruck() {
		return "resource_list3";
	}
	
	
	
	/**
	 * 资源栏获取筛选后的零担信息
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedLesstruckloadAjax(TruckBean truckBean,PageUtil pageUtil,HttpSession session){
		
		
		JSONArray jsonArray = LesstruckloadService.getSelectedLesstruckloadNew(truckBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * 返回资源-零担信息筛选记录总条数，未实现
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean){
		Integer count=LesstruckloadService.getSelectedLesstruckloadTotalRows(truckBean);
		return count;
	}
	
	/**
	 * 获取零担资源详情detail
	 * @param truckId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/lesstruckloaddetail",method = RequestMethod.GET)
	public ModelAndView getLessTruckLoadInfo(
			@RequestParam("truckId") String truckId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request){
		Truck truckInfo = LesstruckloadService.getLesstruckloadInfo(truckId);
		if(truckInfo.getExtraService()==null){
			truckInfo.setExtraService("没有");	
		} else if(truckInfo.getExtraService().equals("")){
			truckInfo.setExtraService("没有");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"lesstruckload");
		mv.addObject("focusList", focusList);
		mv.addObject("truckInfo", truckInfo);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//需要获取资源对应的公司的评价平均数bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail3");// 资源栏点击详情的页面
		} else if (flag == 1) {// 详情
			mv.setViewName("mgmt_r_line4");
		} else if (flag == 2) {// 更新
			mv.setViewName("mgmt_r_line3");
			}
		return mv;
	}
	/*
	*//**
	 * 我的信息-整车资源
	 * @param flag
	 * @param page
	 * @param session
	 * @return
	 *//*
	@RequestMapping(value="/lesstruckload",params="flag=1")
	public String getAllLessTruckLoad(@RequestParam int flag,
			PageUtil page, HttpSession session) {
		return "mgmt_r_line";
	}
	
	*//**
	 * 我的信息-整车资源 
	 * @param session
	 * @param lineBean
	 * @param pageUtil
	 * @return
	 *//*
	@RequestMapping(value="getUserFullTruckLoadResourceAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getUserFullTruckLoadResource(HttpSession session,PageUtil pageUtil) {
		
		JSONArray jsonArray=LesstruckloadService.getUserLesstruckloadResource(session,pageUtil);
		
		return jsonArray.toString();
	}
	
	*//**
	 * 新增整车资源
	 * @param line
	 * @param file
	 * @param request
	 * @return
	 *//*
	@RequestMapping(value = "insertfulltruckload", method = RequestMethod.POST)
	public String insertNewLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
		boolean flag=LesstruckloadService.insertNewLesstruckload(truck,request,file);
		return "redirect:fulltruckload?flag=1";
	}
	
	*//**
	 * 删除整车资源
	 *//*
	@RequestMapping(value = "lesstruckloaddelete", method = RequestMethod.GET)
	public String deleteLine(@RequestParam String id,// GET方式传入，在action中
			HttpServletRequest request, HttpServletResponse response) {
		LesstruckloadService.deleteLesstruckload(id);
		return "redirect:fulltruckload?flag=1";

	}
	
	*//**
	 * 更新整车资源信息
	 * @param line
	 * @param request
	 * @param response
	 *//*
	@RequestMapping(value="updatefulltruckload",method=RequestMethod.POST)
	public String updateLinetransport(Truck truck,MultipartFile file,
			HttpServletRequest request) {
		boolean flag = LesstruckloadService.updateLesstruckload(truck,request,file);
		return "redirect:fulltruckload?flag=1";
	}
*/

}



