package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.OperationBean;
import cn.edu.bjtu.util.PageUtil;

public interface OperationService {
	
	/**
	 * ��������׼ȷ���б��ܼ�¼��
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public Long getTransportAccuracyListTotalRows(OperationBean operationBean,HttpSession session, PageUtil pageUtil);

	/**
	 * ��������׼ȷ���б�
	 * @param operationBean
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public List getTransportAccuracyList(OperationBean operationBean,HttpSession session, PageUtil pageUtil);
}
