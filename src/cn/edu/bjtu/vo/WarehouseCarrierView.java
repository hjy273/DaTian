package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="warehouse_carrier_view")
public class WarehouseCarrierView implements java.io.Serializable {
	@Id
	private String id;
	private String name;
	private String city;
	private String address;
	private String type;
	private String kind;
	private Float houseArea;
	private Float yardArea;
	private Float height;
	private String fireRate;
	private String storageForm;
	private String fireSecurity;
	private String environment;
	private String serviceContent;
	private String contact;
	private String phone;
	private String detailPrice;
	private String remarks;
	private String carrierId;
	private Date relDate;
	private String companyName;
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKind() {
		return this.kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Float getHouseArea() {
		return this.houseArea;
	}

	public void setHouseArea(Float houseArea) {
		this.houseArea = houseArea;
	}

	public Float getYardArea() {
		return this.yardArea;
	}

	public void setYardArea(Float yardArea) {
		this.yardArea = yardArea;
	}

	public Float getHeight() {
		return this.height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}

	public String getFireRate() {
		return this.fireRate;
	}

	public void setFireRate(String fireRate) {
		this.fireRate = fireRate;
	}

	public String getStorageForm() {
		return this.storageForm;
	}

	public void setStorageForm(String storageForm) {
		this.storageForm = storageForm;
	}

	public String getFireSecurity() {
		return this.fireSecurity;
	}

	public void setFireSecurity(String fireSecurity) {
		this.fireSecurity = fireSecurity;
	}

	public String getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
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

	public String getDetailPrice() {
		return this.detailPrice;
	}

	public void setDetailPrice(String detailPrice) {
		this.detailPrice = detailPrice;
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

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

}
