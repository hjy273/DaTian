package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.WarehouseSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;

public interface WarehouseService {

	
	public Warehouse getWarehouseInfo(String warehouseid);
	public boolean insertNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file);
	public boolean updateNewWarehouse(Warehouse warehouse,HttpServletRequest request,MultipartFile file);
	
	
	public boolean deleteWarehouse(String id);
	
	/**
	 * 资源栏-仓库筛选
	 * @param warehouseBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedWarehouseNew(WarehouseSearchBean warehouseBean,PageUtil pageUtil,HttpSession session);

	/**
	 * 资源栏-仓库筛选总条数
	 * @param warehouseBean
	 * @return
	 */
	public Integer getSelectedWarehouseTotalRows(WarehouseSearchBean warehouseBean);
	
	/**
	 * 我的信息-我的货物
	 * @Title: getUserWarehouseResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:29:35
	 */
	public JSONArray getUserWarehouseResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * 我的信息-我的货物-总记录条数
	 * @Title: getUserWarehouseResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:30:06
	 */
	public Integer getUserWarehouseResourceTotalRows(HttpSession session);

}
