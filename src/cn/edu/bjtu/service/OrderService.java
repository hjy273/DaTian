package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.bean.page.OrderBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

import com.alibaba.fastjson.JSONArray;

public interface OrderService {

	public OrderCarrierView getSendOrderDetail(String id);

	public Orderform getRecieveOrderDetail(String id);
	
	//add by solitudeycq at 2015-12-19 17:21
	//��ȡ����
	public List<Orderform> getOrderByDriverName(String driver);

	public Orderform getOrderByOrderNum(String orderNum);

	public OrderCarrierView getOrderByOrderId(String orderId);

	public boolean acceptOrder(String orderId);
	
	//add by solitudeycq at 2015-12-18 22:21 Ϊ��������˾��
	public boolean setDriver(String orderId,String driver);
	//add by solitudeycq at 2015-12-24 1:52 Ϊ�������䳵�ƺ�
	public boolean setcarNum(String orderId,String carNum);
	
	//add by solitudeycq at 2015-12-23 14:12˾��ȷ��
	public boolean setConfirm(String orderId);

	public float getExpectedMoney(String orderId);

	public boolean signBill(String orderId, float actualPrice,
			String explainReason,String fileLocation);

	public Orderform getOrderInfo(String orderId);

	public boolean confirmCargo(String orderId);

	public boolean cancel(String cancelReason, String orderId);
	public boolean updateSignBill(String orderId,
			float actualPrice, String explainReason,String fileLocation);
	

	
	/**
	 * �����û�����������
	 * @param session
	 * @return
	 */
	public Long getUserWaitToAcceptNum(HttpSession session);
	
	/**
	 * �����û����ջ�������
	 * @param session
	 * @return
	 */
	public Long getUserWaitToReceiveNum(HttpSession session);
	
	/**
	 * �����û���������Ŀ 
	 * @param session
	 * @return
	 */
	public Long getUserWaitToSettleNum(HttpSession session);
	
	/**
	 * �����û�����ɶ�����
	 * @param session
	 * @return
	 */
	public Long finishedNum(HttpSession session);
	
	/**
	 * �½�����
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean createOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * ���¶���
	 * @param session
	 * @param orderBean
	 * @return
	 */
	public boolean updateOrder(HttpSession session,OrderBean orderBean);
	
	/**
	 * ���ύ�Ķ���-�ܼ�¼��
	 * @param session
	 * @return
	 */
	public Integer getUserSendOrderTotalRows(HttpSession session,Orderform order);
	
	/**
	 *  ����еĶ���
	 * @param session
	 * @return
	 */
	public JSONArray getUserSendOrder(HttpSession session,PageUtil pageUtil,Orderform order);

	/**
	 * ���յ��Ķ���
	 * @param session
	 * @return
	 */
	public JSONArray getUserRecieveOrder(HttpSession session,PageUtil pageUtil,Orderform order);
	
	/**
	 * ���յ��Ķ���-�ܼ�¼��
	 * @param session
	 * @return
	 */
	public Integer getUserRecieveOrderTotalRows(HttpSession session,Orderform order);

}
