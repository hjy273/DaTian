package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * ����������bean
 * @author RussWest0
 * @date   2015��6��9�� ����10:49:10
 */
public class LinetransportSearchBean {

	private String startPlace;//��ֹ����
	private String endPlace;//��ֹ����
	private String transportType;//��������
	private String refPrice;//�ο�����
	private String id;//����id
	private String fromPlace;//��Ӧʼ�����У�������startPlace�ظ����ȱ���
	private Date relDate;
	private String status;//��ע״̬
	private String companyName;//��˾����
	private Integer onWayTime;//ʱ�� 
	private String lineName;//��Դ����
	private String carrierId;//���˷�id
	/* "select t1.id,"
		+ "t1.carrierId,"
		+ "t1.lineName,"
		+ "t1.startPlace,"
		+ "t1.endPlace,"
		+ "t1.refPrice,"
		+ "t1.relDate,"
		+ "t1.type,"
		+ "t1.onWayTime,"
		+ "t3.status "
		+ " from line_carrier_view t1 "*/
	
	
	
	public String getStartPlace() {
		return startPlace;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	

	public Integer getOnWayTime() {
		return onWayTime;
	}

	public void setOnWayTime(Integer onWayTime) {
		this.onWayTime = onWayTime;
	}

	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
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

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getRefPrice() {
		return refPrice;
	}

	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}
	
	
	
}
