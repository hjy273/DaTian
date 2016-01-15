package cn.edu.bjtu.vo;

// Generated 2015-2-14 19:50:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="goods_client_view")
public class GoodsClientView implements java.io.Serializable {
	@Id
	private String id;
	private String name;
	private String type;
	private String transportType;
	private Float weight;
	//private Float volume;
	private String startPlace;
	private String endPlace;
	private Date relDate;
	private Date limitDate;
	//private String declaredValue;
	private String transportReq;
	private String damageReq;
	@Column(name="VIPService")
	private String vipservice;
	private String oriented;
	//private int feedbackQuantity;
	private String invoice;
	private String relatedMaterial;
	private String state;//货物状态
	private String clientId;
	private String remarks;
	private String realName;
	private String carrierId;
	private String phone;
	@Column(name="VIPServiceDetail")
	private String vipServiceDetail;//add by RussWest0 at 2015年6月9日,下午8:51:25 

	
	public String getVipServiceDetail() {
		return vipServiceDetail;
	}

	public void setVipServiceDetail(String vipServiceDetail) {
		this.vipServiceDetail = vipServiceDetail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public GoodsClientView() {
	}

	public GoodsClientView(String id) {
		this.id = id;
	}

	

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTransportType() {
		return this.transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public String getStartPlace() {
		return this.startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return this.endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public Date getLimitDate() {
		return this.limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getTransportReq() {
		return this.transportReq;
	}

	public void setTransportReq(String transportReq) {
		this.transportReq = transportReq;
	}

	public String getDamageReq() {
		return this.damageReq;
	}

	public void setDamageReq(String damageReq) {
		this.damageReq = damageReq;
	}

	public String getVipservice() {
		return this.vipservice;
	}

	public void setVipservice(String vipservice) {
		this.vipservice = vipservice;
	}

	public String getOriented() {
		return this.oriented;
	}

	public void setOriented(String oriented) {
		this.oriented = oriented;
	}
	
	/*public int getFeedbackQuantity() {
		return this.feedbackQuantity;
	}

	public void setFeedbackQuantity(int feedbackQuantity) {
		this.feedbackQuantity = feedbackQuantity;
	}*/

	public String getInvoice() {
		return this.invoice;
	}

	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}

	public String getRelatedMaterial() {
		return this.relatedMaterial;
	}

	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRealName() {
		return this.realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}


}
