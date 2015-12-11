package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.SubAccount;

public interface SubAccountService {

	public List getSubAccount(String userId);
	public boolean changeStatus(String id);
	public boolean deleteSubAccount(String id);
	
	/**
	 * ���¸����˻�
	 * @param subAccountBean
	 * @param session
	 * @return
	 */
	public boolean updateSubAccount(SubAccountBean subAccountBean,HttpSession session);
	
	/*
	 * ��Ӹ����˻�
	 */
	public boolean addNewSubAccount(SubAccountBean subAccountBean,HttpSession session);
	
	/**
	 * ��ȡ�����˻�
	 * @param id
	 * @return
	 */
	public SubAccount getSubAccountDetail(String id);
	
	/**
	 * �����˻�-�б�
	 * @Title: getSubAccountList 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��27�� ����4:07:01
	 */
	public String getSubAccountList(HttpSession session,SubAccount subAccount,PageUtil pageUtil);
	
	/**
	 * �����˻�-�ܼ�¼��
	 * @Title: getSubAccountTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��27�� ����4:07:28
	 */
	public Integer getSubAccountTotalRows(HttpSession session,SubAccount subAccount);
	
	/**
	 * ��鸽���˻��Ƿ����
	 * @param username
	 * @return
	 */
	public boolean checkSubAccountUsername(String username);
}
