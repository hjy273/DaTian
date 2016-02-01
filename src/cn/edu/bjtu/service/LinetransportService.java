package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;

public interface LinetransportService {


	public Linetransport getLinetransportInfo(String linetransportid);

	public boolean insertNewLinetransport(Linetransport line,HttpServletRequest request, MultipartFile file);

	
	public boolean deleteLine(String id);

	
	/**
	 * ��Դ����ȡɸѡ��ĳ���������Դ
	 * @param linetransportbean
	 * @param page
	 * @param session
	 * @return
	 */
	public DataModel getSelectedLineNew(LinetransportSearchBean linetransportbean,
			PageUtil page,HttpSession session);
	
	
	/**
	 * ��Դ��ɸѡ������
	 * @param lineBean
	 * @return
	 */
	public Integer getSelectedLineTotalRows(LinetransportSearchBean lineBean);
	
	/**
	 * �ҵ���Ϣ-�ҵĸ�����Դ
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getUserLinetransportResource(HttpSession session,PageUtil pageUtil);
	/**
	 * �ҵ���Ϣ-������Դ-�ܼ�¼��
	 * @Title: getUserLinetransportResourceTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����9:43:48
	 */
	public Integer getUserLinetransportResourceTotalRows(HttpSession session);
	
	/**
	 * ������Դ�����
	 * @param line
	 * @param request
	 * @return
	 */
	public boolean updateLinetransport(Linetransport line,HttpServletRequest request,MultipartFile file);

	
	/**
	 * ��ȡ��˾������ ������Դ
	 * @param carrierId
	 * @return
	 */
	public String getCompanyLinetransport(String carrierId);
	
}
