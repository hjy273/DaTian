package cn.edu.bjtu.service;


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
	 * ��ȡ��Դ��-�㵣ɸѡ��¼������
	 * @param truckBean
	 * @return
	 */
	public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean);
	
	/**
	 * �ҵ���Ϣ-�㵣��Ϣ-�ܼ�¼����
	 * 
	 */
	public Integer getSelectedLesstruckloadresourceTotalRows(HttpSession session);
	
	
	/**
	 * �ҵ���Ϣ-�㵣��Դ-��ʾ��Դ
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getSelectedLesstruckloadresourceloadNew(HttpSession session,PageUtil pageUtil);

	
	public Truck getLesstruckloadInfo(String truckId);

	
	public boolean insertNewLesstruckload(Truck truck,HttpServletRequest request, MultipartFile file);
	
	public boolean deleteLesstruckload(String id);
	
	public boolean updateLesstruckload(Truck truck,HttpServletRequest request,MultipartFile file);
}
