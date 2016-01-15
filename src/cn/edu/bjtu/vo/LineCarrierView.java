package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="line_carrier_view")
public class LineCarrierView {
	private String companyName;
	@Id
	private String id;
	private String startPlace;
	private String endPlace;
	private int onWayTime;
	private Float refPrice;
	private Date relDate;
	private String carrierId;
	private String detailPrice;
	private String remarks;
	private String type;
	private String lineName;
	//focus������ add by RussWest0 at 2015��6��12��,����11:23:15 
	/*private String focusId;
	private String clientId;
	private String focusType;
	private String resourceId;
	private String status;*/
	
	
	
	
	public LineCarrierView() {
	}
	public LineCarrierView(String companyName, String id, String startPlace,
			String endPlace, int onWayTime, Float refPrice, Date relDate,
			String carrierId, String detailPrice, String remarks, String type, String lineName) {
		super();
		this.companyName = companyName;
		this.id = id;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
		this.onWayTime = onWayTime;
		this.refPrice = refPrice;
		this.relDate = relDate;
		this.carrierId = carrierId;
		this.detailPrice = detailPrice;
		this.remarks = remarks;
		this.type = type;
		this.lineName = lineName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStartPlace() {
		return startPlace;
	}
	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}
	public String getEndPlace() {
		return endPlace;
	}
	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	
	public int getOnWayTime() {
		return onWayTime;
	}
	public void setOnWayTime(int onWayTime) {
		this.onWayTime = onWayTime;
	}
	public Float getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(Float refPrice) {
		this.refPrice = refPrice;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getDetailPrice() {
		return detailPrice;
	}
	public void setDetailPrice(String detailPrice) {
		this.detailPrice = detailPrice;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getLineName() {
		return this.lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
}
