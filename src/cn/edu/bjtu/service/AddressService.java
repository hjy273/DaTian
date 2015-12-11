package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Address;

import com.alibaba.fastjson.JSONArray;


public interface AddressService {

	public List getAddress(String userId);
	public Address getAddressDetail(String id);
	public boolean deleteAddress(String id);
	/**
	 * �������õ�ַ
	 * @param session
	 * @param address
	 * @return
	 */
	public boolean insertAddress(HttpSession session,Address address);
	/**
	 * ���³��õ�ַ
	 * @param session
	 * @param address
	 * @return
	 */
	public boolean updateAddress(HttpSession session,Address address);
	
	/**
	 * �¶���ʱ��ȡ�û��ĳ��õ�ַ�б�
	 * @param session
	 * @return
	 */
	public JSONArray getUserAddress(HttpSession session,Integer kind);
	
	/**
	 * �¶���ʱ��ȡ�û��ĳ����ջ���ַ�б�
	 * @param session
	 * @return
	 */
	/*public JSONArray getUserRecieveAddress(HttpSession session);*/
	
	/**
	 * ���÷�����ַ
	 * @Title: getSendAddress 
	 *  
	 * @param: @param session
	 * @param: @param pageUtil
	 * @param: @return 
	 * @return: String 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��29�� ����11:31:25
	 */
	public String getAddress(HttpSession session,PageUtil pageUtil,Address address);
	
	/**
	 * ���÷�����ַ-�ܼ�¼��
	 * @Title: getSendAddressTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��29�� ����11:32:18
	 */
	public Integer getAddressTotalRows(HttpSession session,Address address);
}
