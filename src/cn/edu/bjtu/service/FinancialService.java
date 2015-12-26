package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.FinancialBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Orderform;

public interface FinancialService {
	/**
	 * ��ȡ�˻������������
	 * @param session
	 * @return
	 */
	public List<FinancialBean> getAccountFinancialInfo(FinancialBean financialBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * �������ָ���м�¼��
	 * @param session
	 * @return
	 */
	public Long getAccountFinancialInfoTotalRows(FinancialBean financialBean,HttpSession session);
	
	/**
	 * ��ȡĳһ������ж���
	 * @param date
	 * @return
	 */
	public List<Orderform> viewFinancialDetails(HttpSession session,FinancialBean financialBean,PageUtil pageUtil);
	
	/**
	 * ��ȡĪһ������ж������ܼ�¼��
	 * @param session
	 * @param financialBean
	 * @param pageUtil
	 * @return
	 */
	public Long viewFinancialDetailsTotalRows(HttpSession session,FinancialBean financialBean);
}
