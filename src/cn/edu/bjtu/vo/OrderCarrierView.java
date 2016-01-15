package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_carrier_view")
public class OrderCarrierView implements java.io.Serializable {
	@Id	
	private String id;
	private String orderNum;
	private String goodsName;
	private String carrierId;
	//private String contactWaybill;
	private Float expectedPrice;
	private Float actualPrice;
	private Date submitTime;
	private String state;
	private String deliveryAddr;
	private String deliveryName;
	private String deliveryPhone;
	private String recieverAddr;
	private String recieverName;
	private String recieverPhone;
	private String warehouseId;
	private String citylineId;
	private String linetransportId;
	private String remarks;
	private Float insurance;
	private String clientId;
	private Float goodsWeight;
	private Float goodsVolume;
	//private Float freight;
	private String carrierName;
	private String carrierAccount;
	//private String clientName;
	private String contractId;
	
	private String resourceType;
	private String acceptPicture;
	private String explainReason;
	private String carNum;
	private String driver;
	private String commentId;
	
	private float declaredPrice;
	private String hasCarrierContract;
	private String clientName;
	private String cancelReason;

	
	// add by RussWest0 at 2015��5��31��,����11:34:05 
		private String isLinkToClientWayBill;
		private String clientWayBillNum;
		private String resourceName;
		
		
	public String getIsLinkToClientWayBill() {
			return isLinkToClientWayBill;
		}

		public void setIsLinkToClientWayBill(String isLinkToClientWayBill) {
			this.isLinkToClientWayBill = isLinkToClientWayBill;
		}

		public String getClientWayBillNum() {
			return clientWayBillNum;
		}

		public void setClientWayBillNum(String clientWayBillNum) {
			this.clientWayBillNum = clientWayBillNum;
		}

		public String getResourceName() {
			return resourceName;
		}

		public void setResourceName(String resourceName) {
			this.resourceName = resourceName;
		}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public OrderCarrierView() {
	}

	public OrderCarrierView(String id) {
		this.id = id;
	}

	public float getDeclaredPrice() {
		return declaredPrice;
	}

	public void setDeclaredPrice(float declaredPrice) {
		this.declaredPrice = declaredPrice;
	}

	public String getHasCarrierContract() {
		return hasCarrierContract;
	}

	public void setHasCarrierContract(String hasCarrierContract) {
		this.hasCarrierContract = hasCarrierContract;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getResourceType() {
		return resourceType;
	}

	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	public String getAcceptPicture() {
		return acceptPicture;
	}

	public void setAcceptPicture(String acceptPicture) {
		this.acceptPicture = acceptPicture;
	}

	
	public String getExplainReason() {
		return explainReason;
	}

	public void setExplainReason(String explainReason) {
		this.explainReason = explainReason;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	

	public Float getExpectedPrice() {
		return this.expectedPrice;
	}

	public void setExpectedPrice(Float expectedPrice) {
		this.expectedPrice = expectedPrice;
	}

	public Float getActualPrice() {
		return this.actualPrice;
	}

	public void setActualPrice(Float actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Date getSubmitTime() {
		return this.submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDeliveryAddr() {
		return this.deliveryAddr;
	}

	public void setDeliveryAddr(String deliveryAddr) {
		this.deliveryAddr = deliveryAddr;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryPhone() {
		return this.deliveryPhone;
	}

	public void setDeliveryPhone(String deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

	public String getRecieverAddr() {
		return this.recieverAddr;
	}

	public void setRecieverAddr(String recieverAddr) {
		this.recieverAddr = recieverAddr;
	}

	public String getRecieverName() {
		return this.recieverName;
	}

	public void setRecieverName(String recieverName) {
		this.recieverName = recieverName;
	}

	public String getRecieverPhone() {
		return this.recieverPhone;
	}

	public void setRecieverPhone(String recieverPhone) {
		this.recieverPhone = recieverPhone;
	}

	

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getCitylineId() {
		return this.citylineId;
	}

	public void setCitylineId(String citylineId) {
		this.citylineId = citylineId;
	}

	public String getLinetransportId() {
		return this.linetransportId;
	}

	public void setLinetransportId(String linetransportId) {
		this.linetransportId = linetransportId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Float getInsurance() {
		return this.insurance;
	}

	public void setInsurance(Float insurance) {
		this.insurance = insurance;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Float getGoodsWeight() {
		return this.goodsWeight;
	}

	public void setGoodsWeight(Float goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public Float getGoodsVolume() {
		return this.goodsVolume;
	}

	public void setGoodsVolume(Float goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public String getCarrierName() {
		return this.carrierName;
	}

	public void setCarrierName(String carrierName) {
		this.carrierName = carrierName;
	}

	public String getCarrierAccount() {
		return this.carrierAccount;
	}

	public void setCarrierAccount(String carrierAccount) {
		this.carrierAccount = carrierAccount;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}



}
