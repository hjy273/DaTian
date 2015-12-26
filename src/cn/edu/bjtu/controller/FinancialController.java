package cn.edu.bjtu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.service.FinancialService;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Orderform;

@Controller
/**
 * ͳ�Ʒ���-����ָ�����
 * @author iver
 * @date   2015��12��23�� ����7:43:31
 */
public class FinancialController {
	
	@Autowired
	FinancialService financialService;
	
	/**
	 * ����ָ��ҳ��
	 * @return
	 */
	@RequestMapping("getFinancialInfoPage")
	public String getFinancialInfoPage(){
		return "mgmt_s_fin";
	}
	
	/**
	 * ����ָ���б�
	 * @param financialBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	@RequestMapping("getFinancialInfoAjax")
	@ResponseBody
	public List<FinancialBean> getFinancialInfo(FinancialBean financialBean,PageUtil pageUtil,HttpSession session){
		List<FinancialBean> list=financialService.getAccountFinancialInfo(financialBean,pageUtil,session);
		
		return list;
	}
	
	/**
	 * ����ָ���ܼ�¼�� 
	 * @param session
	 * @return
	 */
	@RequestMapping("getFinalcialInfoTotalRowsAjax")
	@ResponseBody
	public Long getFinancialInfoTotalRows(FinancialBean financialBean,HttpSession session){
		return financialService.getAccountFinancialInfoTotalRows(financialBean,session);
	}
	
	/**
	 * ��ȡĳһ������ж����б�ҳ��
	 * @param date
	 * @return
	 */
	@RequestMapping("FinancialDetailsPage")
	public String FinancialDetailsPage(){
		return "mgmt_s_fin2";
	}
	
	/**
	 * ����鿴ʱ������ĳһ��Ķ���
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@RequestMapping("viewFinancialDetailsAjax")
	@ResponseBody
	public List<Orderform> viewFinancialDetailsPage(HttpSession session,FinancialBean financialBean,PageUtil pageUtil){
		return financialService.viewFinancialDetails(session, financialBean,pageUtil);
	}
	
	/**
	 * ����ָ�꣬�鿴ҳ����ܼ�¼��
	 * @param session
	 * @param financialBean
	 * @return
	 */
	@RequestMapping("viewFinancialDetailsTotalRowsAjax")
	@ResponseBody
	public Long viewFinancialDetailsTotalRows(HttpSession session,FinancialBean financialBean){
		return financialService.viewFinancialDetailsTotalRows(session, financialBean);
	}
}
