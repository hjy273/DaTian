package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Cityline;
import com.alibaba.fastjson.JSONArray;

public interface CitylineService {
	
	public Cityline getCitylineInfo(String citylineid);
	public boolean insertNewCityline(Cityline cityline,
			HttpServletRequest request, MultipartFile file);
	public boolean updateNewCityline(Cityline cityline,HttpServletRequest request,MultipartFile file);
	
	public boolean deleteCityline(String id);
	
	/**
	 * ��Դ����ȡɸѡ��������
	 * @param citiLineBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedLineNew(CityLineSearchBean citiLineBean,PageUtil pageUtil,HttpSession session);	

	/**
	 * ���س�������ɸѡ������
	 * @param citylineBean
	 * @return
	 */
	public Integer getSelectedCityLineTotalRows(CityLineSearchBean citylineBean);
	
	/**
	 * �ҵ���Ϣ-��������-�ܼ�¼�� 
	 * @Title: getUserCitylineResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����9:56:06
	 */
	public Integer getUserCitylineResourceTotalRows(HttpSession session);
	
	/**
	 * �ҵ���Ϣ-��������
	 * @Title: getUserCitylineResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����9:57:01
	 */
	public JSONArray getUserCitylineResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * ��ȡ�û�����������Դ
	 * @param carrierId
	 * @return
	 */
	public String getCompanyCitylineResource(String carrierId);
		
	
}
