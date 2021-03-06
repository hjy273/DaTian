package cn.edu.bjtu.vo;

// Generated 2015-2-25 11:46:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

/**
 * Contract generated by hbm2java
 */@Component
public class Contract implements java.io.Serializable {

	private String id;
	private String name;
	private String carrierAccount;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date startDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date endDate;
	private Integer time;
	private String caculateType;
	private String contact;
	private String phone;
	private String relatedMaterial;
	private String remarks;
	private String carrierId;
	private String state;
	private String reason;
	private String monthlyStatementDays;
	private String clientId;
	//add by RussWest0 at 2015年7月29日,下午9:28:07 
	private Date createTime;//创建时间

	
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	
	public String getMonthlyStatementDays() {
		return monthlyStatementDays;
	}

	public void setMonthlyStatementDays(String monthlyStatementDays) {
		this.monthlyStatementDays = monthlyStatementDays;
	}
	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Contract() {
	}

	public Contract(String id) {
		this.id = id;
	}

	
	

	public Contract(String id, String name, String carrierAccount,
			Date startDate, Date endDate, Integer time, String caculateType,
			String contact, String phone, String relatedMaterial,
			String remarks, String carrierId, String state, String reason,
			String monthlyStatementDays, String clientId) {
		super();
		this.id = id;
		this.name = name;
		this.carrierAccount = carrierAccount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.time = time;
		this.caculateType = caculateType;
		this.contact = contact;
		this.phone = phone;
		this.relatedMaterial = relatedMaterial;
		this.remarks = remarks;
		this.carrierId = carrierId;
		this.state = state;
		this.reason = reason;
		this.monthlyStatementDays = monthlyStatementDays;
		this.clientId = clientId;
		
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

	public String getCarrierAccount() {
		return this.carrierAccount;
	}

	public void setCarrierAccount(String carrierAccount) {
		this.carrierAccount = carrierAccount;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getCaculateType() {
		return this.caculateType;
	}

	public void setCaculateType(String caculateType) {
		this.caculateType = caculateType;
	}

	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getRelatedMaterial() {
		return relatedMaterial;
	}

	public void setRelatedMaterial(String relatedMaterial) {
		this.relatedMaterial = relatedMaterial;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCarrierId() {
		return this.carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
