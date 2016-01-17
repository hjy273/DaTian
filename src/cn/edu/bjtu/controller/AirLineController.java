package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.AirLineSearchBean;
import cn.edu.bjtu.service.AirLineService;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.AirLine;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Comment;
import cn.edu.bjtu.vo.Truck;

/**
 * @author solitudeycq
 *
 */
@Controller
public class AirLineController {
	
	@Autowired
    AirLineService airlineService;
	@Autowired
	FocusService focusService;
	@Resource
	CompanyService companyService;
	@Autowired
	CommentService commentService;
	
	ModelAndView mv = new ModelAndView();
	/**
     * ��Դ�����п�����Ϣ
     * @return
     */
	@RequestMapping(value="/airline",params="flag=0")
	public String getallAirLine(){
		return "resource_list7";
		
	}
	
	/**
	 * ��Դ������ɸѡ
	 * @return
	 */
	@RequestMapping(value="airlineAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String sirlineAjax(AirLineSearchBean airlineBean,
			PageUtil page, HttpSession session, HttpServletResponse response,
			Model model){
		JSONArray airlineArray = airlineService.getSelectedAirLineNew(airlineBean, page, session);
		return airlineArray.toString();	
	}
	
	/**
	 * ��ȡ���ڿ�����Դ����
	 * @param truckId
	 * @param carrierId
	 * @param flag
	 * @return
	 */
	@RequestMapping(value="/airlinedetail",method = RequestMethod.GET)
	public ModelAndView getFullTruckLoadInfo(
			@RequestParam("airlineId") String airlineId,
			@RequestParam("carrierId") String carrierId,
			@RequestParam("flag") int flag,
			HttpServletRequest request){
		AirLine airlineInfo = airlineService.getAirLineInfo(airlineId);
		if(airlineInfo.getExtraService()==null){
			airlineInfo.setExtraService("û��");	
		} else if(airlineInfo.getExtraService().equals("")){
			airlineInfo.setExtraService("û��");
		}
		String clientId = (String) request.getSession().getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"airline");
		mv.addObject("focusList", focusList);
		mv.addObject("airlineInfo", airlineInfo);
		if (flag == 0) {
			Carrierinfo carrierInfo = companyService.getCompanyById(carrierId);
			List<Comment> commentList=commentService.getCompanyComment(carrierId);
			mv.addObject("commentList",commentList);
			mv.addObject("carrierInfo", carrierInfo);
			//��Ҫ��ȡ��Դ��Ӧ�Ĺ�˾������ƽ����bean
			Comment comment=commentService.getCompanyAverageCommentRate(carrierId);
			mv.addObject("avgComment", comment);
			mv.setViewName("resource_detail7");// ��Դ����������ҳ��
		} else if (flag == 1) {// ����
			mv.setViewName("mgmt_r_airline4");
		} else if (flag == 2) {// ����
			mv.setViewName("mgmt_r_airline3");
			}
		return mv;
	}

}
