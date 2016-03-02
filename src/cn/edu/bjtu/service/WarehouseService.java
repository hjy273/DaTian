package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;

public interface WarehouseService {

	
	public Warehouse getWarehouseInfo(String warehouseid);
	public boolean insertNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file);
	public boolean updateNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file);
	
	
	public boolean deleteWarehouse(String id);
	
	/**
	 * ��Դ��-�ֿ�ɸѡ
	 * @param warehouseBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedWarehouseNew(WarehouseSearchBean warehouseBean,PageUtil pageUtil,HttpSession session);

	/**
	 * ��Դ��-�ֿ�ɸѡ������
	 * @param warehouseBean
	 * @return
	 */
	public Integer getSelectedWarehouseTotalRows(WarehouseSearchBean warehouseBean);
	
	/**
	 * �ҵ���Ϣ-�ҵĻ���
	 * @Title: getUserWarehouseResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:29:35
	 */
	public JSONArray getUserWarehouseResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * �ҵ���Ϣ-�ҵĻ���-�ܼ�¼����
	 * @Title: getUserWarehouseResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:30:06
	 */
	public Integer getUserWarehouseResourceTotalRows(HttpSession session);

}
