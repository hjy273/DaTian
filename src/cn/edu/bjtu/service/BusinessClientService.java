package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

/**
 *  �����ͻ����
 * @author RussWest0
 * @date   2015��6��22�� ����7:27:09
 */
public interface BusinessClientService {

	/**
	 * ��ȡ�û��������ͻ�
	 * @return
	 */
	public JSONArray getUserBusinessClient(HttpSession session);
	
	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getUserBusinessClient(HttpSession session,PageUtil pageUtil);
	
	/**
	 * �ҵ���Ϣ-�ͻ���Ϣ-�ܼ�¼��
	 * @Title: getUserBusinessClientTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����4:33:16
	 */
	public Integer getUserBusinessClientTotalRows(HttpSession session);
	
	public boolean insertNewClient(Businessclient client,MultipartFile file,HttpServletRequest request);
	public boolean updateNewClient(Businessclient client,MultipartFile file,HttpServletRequest request);
}
