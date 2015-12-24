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
	 * �ܼ�¼�� 
	 * @param session
	 * @return
	 */
	@RequestMapping("getFinalcialInfoTotalRowsAjax")
	@ResponseBody
	public Long getFinancialInfoTotalRows(FinancialBean financialBean,PageUtil pageUtil,HttpSession session){
		return financialService.getAccountFinancialInfoTotalRows(financialBean,pageUtil,session);
	}
}
