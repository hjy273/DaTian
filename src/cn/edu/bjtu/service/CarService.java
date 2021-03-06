package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.CarSearchBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carteam;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

public interface CarService {
	
	public Carinfo getCarInfo(String carid);
	
	public boolean setcarState(String carNum,String carState);

	public boolean insertNewCar(Carinfo car,HttpServletRequest request);
	public boolean updateNewCar(Carinfo car,HttpServletRequest request);
	
	public boolean deleteCar(String id);
	
	/**
	 * 获取资源栏筛选car
	 * @param carbean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedCarNew(CarSearchBean carbean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * 获取资源栏-车辆筛选记录总条数
	 * @param carBean
	 * @return
	 */
	public Integer getSelectedCarTotalRows(CarSearchBean carBean);
	
	/**
	 * 获取公司车队姓名列表
	 * @Title: getCompanyCarteamList 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年6月29日 下午5:35:42
	 */
	public List<Carteam> getCompanyCarteamList(HttpSession session);
	
	/**
	 * 我的信息-车辆信息-总记录条数
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:12:59
	 */
	public Integer getUserCarResourceTotalRows(HttpSession session);
	
	/**
	 * 我的信息-车辆信息
	 * @Title: getUserCarResource 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONArray 
	 * @throws: 异常 
	 * @author: chendonghao 
	 * @date: 2015年7月3日 上午11:13:42
	 */
	public JSONArray getUserCarResource(HttpSession session,PageUtil pageUtil);
	
	/**
	 * 获取公司车辆字眼 
	 * @param carrierId
	 * @return
	 */
	public String getCompanyCarAjax(String carrierId);
	
	//add by solitudeycq at 2015-12-24 at 0:49
	/**
	 * 获取公司车辆车牌号
	 * @param carrierId
	 * @return
	 */
	public List<Carinfo> getAllcarNum(String carrierId);
}
