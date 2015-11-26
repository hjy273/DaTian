package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.vo.Comment;

/**
 * �������ҵ���߼�
 * @author RussWest0
 * @date   2015��5��23�� ����5:09:32
 */
public interface CommentService {
	/**
	 * �ύ����
	 * @param rate1
	 * @param rate2
	 * @param rate3
	 * @param rate4
	 * @param remarks
	 * @param userId
	 * @return
	 */
	public boolean commitComment(String rate1,String rate2,String rate3,String rate4,String remarks,String userId,String orderid);

	/**
	 * ����carrierid�õ���˾��������
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getLinetransportCommentById(String linetransportId,String userId);
	*//**
	 * ����carrierid�õ�������������
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getCitylineCommentById(String citylineId,String userId);
	*//**
	 * ����carrierid�õ���������
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getCarCommentById(String carId,String userId);
	*//**
	 * ����carrierid�õ��ֿ�����
	 * @param userId
	 * @return
	 *//*
	public List<Comment> getWarehouseCommentById(String warehouseid,String userId);
	*/
	
	/**
	 * ���ݶ����ŵõ���������
	 * @param orderId
	 * @return
	 */
	public Comment getCommentByOrderId(String orderId);
	
	/**
	 * �����û��ĺ�����
	 * @param session
	 * @return
	 */
	public Double getUserGoodCommentRateAjax(HttpSession session);
	
	/**
	 * ��ȡ��˾����
	 * @param carrierId
	 * @return
	 */
	public List<Comment> getCompanyComment(String carrierId);
	
	/**
	 * ��ȡ��˾���۵�ƽ������
	 * @param carrierId
	 * @return
	 */
	public Comment getCompanyAverageCommentRate(String carrierId);
	
	
}
