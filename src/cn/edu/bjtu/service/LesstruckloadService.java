package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Truck;

public interface LesstruckloadService {
	/**
	 * ��ȡ��Դ��ɸѡ�㵣
	 * @param truckbean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedLesstruckloadNew(TruckBean truckBean,PageUtil pageUtil,HttpSession session);
	
	/**
	 * ��ȡ��Դ��-�㵣ɸѡ��¼��������ǰ̨��
	 * @param truckBean
	 * @return
	 */
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean);
	
/*	*//**
	 * �ҵ���Ϣ-������Ϣ-�ܼ�¼����(��̨)
	 * @Title: getUserCarResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����11:12:59
	 *//*
	public Integer getLesstruckloadResourceTotalRows(HttpSession session);
*/
	
	public Truck getLesstruckloadInfo(String truckId);
	
	/**
	 * �ҵ���Ϣ-�ҵ���Դ-�㵣
	 * @param session
	 * @param pageUtil
	 * @return
	 *//*
	public JSONArray getUserLesstruckloadResource(HttpSession session,PageUtil pageUtil);
	
	public boolean insertNewLesstruckload(Truck truck,HttpServletRequest request, MultipartFile file);
	
	public boolean deleteLesstruckload(String id);
	
	public boolean updateLesstruckload(Truck truck,HttpServletRequest request,MultipartFile file);*/
}
