package cn.edu.bjtu.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.bjtu.bean.search.CompanySearchBean;
import cn.edu.bjtu.service.CompanyService;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carrierinfo;

import com.alibaba.fastjson.JSONArray;
/**
 * ��˾��ؿ�����
 * @author RussWest0
 *
 */
@Controller
public class CompanyController {
	
	@Resource
	CompanyService companyService;
	@Autowired
	FocusService focusService;
	ModelAndView mv=new ModelAndView();
	
	/**
	 * �������й�˾��Ϣ
	 * @return
	 */
	@RequestMapping("/company")
	public String getAllCompany(HttpSession session)
	{	
		return "resource_list5";
	}
	/**
	 * ��Դ��-��˾ɸѡ
	 * @param companyBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getSelectedCompanyAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getSelectedCompanyAjax(CompanySearchBean companyBean,PageUtil pageUtil,HttpSession session){
		JSONArray jsonArray = companyService.getSelectedCompanyNew(companyBean, pageUtil,
				session);
		
		return jsonArray.toString();
	}
	
	/**
	 * ��Դ��-��˾ɸѡ-�ܼ�¼����
	 * @param companyBean
	 * @return
	 */
	@RequestMapping("getSelectedCompanyTotalRowsAjax")
	@ResponseBody
	public Integer getSelectedCompanyTotalRowsAjax(CompanySearchBean companyBean){
		Integer count=companyService.getSelectedCompanyTotalRows(companyBean);
		return count;
	}
	

	/**
	 * ���ع�˾�ľ�����Ϣ
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/companyDetail",method=RequestMethod.GET)
	public ModelAndView companyDetail(@RequestParam String id,HttpSession session)
	{
		Carrierinfo carrierinfo=companyService.getCompanyById(id);
		
		//��˾��صĸ�����Ϣ������������Ϣ�Լ��ֿ���Ϣ
		List linetransportList = companyService.getLinetransportByCarrierId(id);
		List citylineList = companyService.getCitylineByCarrierId(id);
		List warehouseList = companyService.getwarehouseByCarrierId(id);
		String clientId = (String) session.getAttribute(Constant.USER_ID);
		List focusList = focusService.getFocusList(clientId,"company");
		mv.addObject("carrierinfo", carrierinfo);
		mv.addObject("linetransportList", linetransportList);
		mv.addObject("citylineList", citylineList);
		mv.addObject("focusList", focusList);
		mv.addObject("warehouseList", warehouseList);
		mv.setViewName("resource_detail5");
		return mv;
	}
	
	
	/**
	 * ��ȡ�Ѿ�ͨ����֤�Ĺ�˾
	 * @param session
	 * @return
	 */
	@RequestMapping(value="getCertificatedCompanyAjax",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCertificatedCompany(HttpSession session){
		JSONArray jsonArray=companyService.getCertificatedCompany(session);
		
		return jsonArray.toString();
	}

}
