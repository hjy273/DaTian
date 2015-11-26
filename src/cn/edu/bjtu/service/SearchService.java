package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;

import com.alibaba.fastjson.JSONArray;

/**
 * �������
 * @author RussWest0
 *
 */
public interface SearchService {
	
	/**
	 * �ڳ�����������������Դ���
	 * @param cityName
	 * @return
	 */
	public JSONArray getLineResourceByCityName(String cityName,PageUtil pageUtil,HttpSession session);
	/**
	 * �������������������ͽ��
	 * @param name
	 * @return
	 */
	public JSONArray getCitylineResourceByName(String name,PageUtil pageUtil,HttpSession session);
	/**
	 * ���ݻ�����������ȡ���
	 * @param name
	 * @return
	 */
	public JSONArray getGoodsResourceByName(String name,PageUtil pageUtil,HttpSession session);
	/**
	 * ���ݹ�˾��������ȡ���
	 * @param name
	 * @return
	 */
	public JSONArray getCompanyResourceByCompanyName(String companyName,PageUtil pageUtil,HttpSession session);
	/**
	 * ���ݳ���������������ȡ���
	 * @param name
	 * @return
	 */
	public JSONArray getCarResourceByCarNum(String carNum,PageUtil pageUtil,HttpSession session);
	/**
	 * ���ݲֿ���������ȡ���
	 * @param name
	 * @return
	 */
	public JSONArray getWarehouseResourceByName(String name,PageUtil pageUtil,HttpSession session);
	
	/**
	 * �������ܹ����ܼ�·��
	 * @param resource_kind
	 * @param search_content
	 * @return
	 */
	public Integer searchLinetransportTotalRows(String resource_kind,String search_content);
}
