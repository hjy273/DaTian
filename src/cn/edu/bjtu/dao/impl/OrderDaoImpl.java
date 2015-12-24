package cn.edu.bjtu.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.HibernateIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.OrderCarrierViewDao;
import cn.edu.bjtu.dao.OrderDao;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.OrderCarrierView;
import cn.edu.bjtu.vo.Orderform;

@Repository
public class OrderDaoImpl extends BaseDaoImpl<Orderform> implements OrderDao {

	@Autowired
	OrderCarrierViewDao orderCarrierViewDao;
	
	@Override
	public OrderCarrierView getSendOrderDetail(String id) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, id);
	}

	@Override
	public Orderform getRecieveOrderDetail(String id) {
		
		return this.get(Orderform.class, id);
	}
	

	@Override
	/**
	 * ͨ��������Ż�ȡĳ����id
	 */
	public Orderform getOrderByOrderNum(String orderNum) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("orderNum", orderNum);
		return this.get("from Orderform where orderNum=:orderNum",params);
	}

	@Override
	public OrderCarrierView getOrderByOrderId(String orderId) {
		
		return orderCarrierViewDao.get(OrderCarrierView.class, orderId);
	}

	@Override
	/**
	 * ���˷��޸Ķ���״̬Ϊ���ջ�
	 */
	public boolean acceptOrder(String orderId) {
		
		String t = "true";
		Orderform order = this.get(Orderform.class, orderId);
		if(t.equals(order.getConfirm())){
		order.setState("���ջ�");// �޸�״̬
		}else{
			order.setState("������");
		}
		this.update(order);
		return true;

	}
	
	@Override
	/**
	 * Ϊ��������˾��
	 */
	public boolean setDriver(String orderId,String driver){
		Orderform order = this.get(Orderform.class, orderId);
		order.setDriver(driver);
		
		this.update(order);
		return true;
	}
	
	@Override
	public boolean setcarNum(String orderId, String carNum) {
		// TODO �Զ����ɵķ������
		Orderform order = this.get(Orderform.class, orderId);
		order.setCarNum(carNum);
		
		this.update(order);
		return true;
	}	
	
	@Override
	public boolean settakeoverNumber(String orderId, String takeoverNumber) {
		// TODO �Զ����ɵķ������
		Orderform order = this.get(Orderform.class, orderId);
		order.setTakeoverNumber(takeoverNumber);
		
		this.update(order);
		return true;
	}
	
	@Override
	public boolean setcompleteNumber(String orderId, String completeNumber, Float price) {
		// TODO �Զ����ɵķ������
		Orderform order = this.get(Orderform.class, orderId);
		order.setActualPrice(price);
		order.setCompleteNumber(completeNumber);
		order.setState("�����");
		
		this.update(order);
		return true;
	}

	@Override
	/**
	 * ˾��ȷ��
	 */
	public boolean setConfirm(String orderId) {
		String t = "true";
		Orderform order = this.get(Orderform.class, orderId);
		order.setConfirm(t);
		
		this.update(order);
		return true;
	}
	

	@Override
	public float getExpectedMoney(String orderId) {
		
		List list = this.find("select expectedPrice from Orderform where id='" + orderId + "'");
		if (list != null)
		{
			//Orderform order=(Float)list.get(0);
			return ((Float)list.get(0)).floatValue();
		}
		else
			return 0.0f;
	}


	@Override
	/**
	 * ���ض�������Ϣ
	 */
	public Orderform getOrderInfo(String orderId) {
		
		return this.get(Orderform.class, orderId);
	}

	@Override
	/**
	 * ȷ���ջ�����
	 */
	public boolean confirmCargo(String orderId) {
		
		Orderform order=this.get(Orderform.class, orderId);
		order.setState("������");
		
		this.update(order);
		return true;
	}
	
	@Override
	/**
	 * ȡ����������
	 */
	public boolean cancel(String cancelReason, String orderId) {
		
		Orderform order=this.get(Orderform.class, orderId);
		order.setCancelReason(cancelReason);
		order.setState("��ȡ��");
		
		this.update(order);
		return true;
	}
	
	@Override
	/**
	 * ���˷����´�ȷ�϶���
	 */
	public boolean DoGetOrderWaitToConfirmUpdate(String orderId,float actualPrice,String explainReason) {
		
		Orderform order = this.get(Orderform.class, orderId);
		order.setActualPrice(actualPrice);
		order.setExplainReason(explainReason);
		this.update(order);
		return true;
	}

	@Override
	public boolean createNewOrder(String userId, String hasCarrierContract,
			String remarks, String goodsName, float goodsVolume,
			float goodsWeight, float expectedPrice, float declaredPrice,
			float insurance, String contractId, String deliveryName,
			String deliveryPhone, String deliveryAddr, String receiverName,
			String receiverPhone, String receiverAddr, String carrierId,
			String isLinkToClientWayBill, String clientWayBillNum,
			String resourceName, String resourceType, String companyName,String clientName) {
		
		Orderform order=new Orderform();
		order.setClientId(userId);
		order.setHasCarrierContract(hasCarrierContract);
		order.setRemarks(remarks);
		order.setGoodsName(goodsName);
		order.setGoodsVolume(goodsVolume);
		order.setGoodsWeight(goodsWeight);
		order.setExpectedPrice(expectedPrice);
		order.setDeclaredPrice(declaredPrice);
		order.setInsurance(insurance);
		order.setContractId(contractId);
		order.setDeliveryAddr(deliveryAddr);
		order.setDeliveryName(deliveryName);
		order.setDeliveryPhone(deliveryPhone);
		order.setRecieverAddr(receiverAddr);
		order.setRecieverName(receiverName);
		order.setRecieverPhone(receiverPhone);
		// add by RussWest0 at 2015��6��1��,����12:46:08 
		order.setIsLinkToClientWayBill(isLinkToClientWayBill);
		order.setClientWayBillNum(clientWayBillNum);
		order.setResourceName(resourceName);
		order.setResourceType(resourceType);
		
		
		order.setSubmitTime(new Date());
		order.setId(IdCreator.createOrderId());
		order.setOrderNum(IdCreator.createOrderNum());
		order.setCarrierId(carrierId);
		order.setSettlementState("δ����");// add by RussWest0 at 2015��6��4��,����8:40:27 
		order.setClientName(clientName);
		//order.setResourceType(resourceType);
		order.setState("������");//����״̬
		order.setCompanyName(companyName);
		
		this.save(order);
		return true;
		
	}

	@Override
	public List<Orderform> getOrderByDriverName(String driver) {
		String hql="from Orderform where driver=:driver";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("driver", driver);
		return this.find(hql, params);
		
	}

	
}
