package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

public interface SettlementService {
	


	public List getOrderStatement(String orderNum);
	
	/**
	 * �����û� �ѽ�����/��������flag=0�ѽ���  flag=1������
	 * @param session
	 */
	public  Float getUserSettlementMoney(HttpSession session,int flag);
	
	
	
	
}
