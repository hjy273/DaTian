package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.service.CommentService;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.PageUtil;

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
	 * ��Դ��-�㵣��Ϣ
	 * @return
	 */
	@RequestMapping(value="/lesstruckload",params="flag=0")
	public String getAllTruck() {
		return "resource_list3";
	}
	
	
	
	/**
	 * ��Դ����ȡɸѡ����㵣��Ϣ
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadAjax",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedLesstruckloadAjax(TruckBean truckBean,PageUtil pageUtil,HttpSession session){
		
		System.out.println("����������");
		
		JSONArray jsonArray = LesstruckloadService.getSelectedLesstruckloadNew(truckBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * ������Դ-�㵣��Ϣɸѡ��¼������
	 * @return
	 */
	@RequestMapping(value="getSelectedLesstruckloadTotalRowsAjax",method = RequestMethod.POST)
	@ResponseBody
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean){
		Integer count=LesstruckloadService.getSelectedLesstruckloadTotalRows(truckBean);
		return count;
	}
}



