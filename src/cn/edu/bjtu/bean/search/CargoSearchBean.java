package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * ����ɸѡpagebean
 * @author RussWest0
 * @date   2015��6��14�� ����11:07:43
 */
public class CargoSearchBean {
	private String id;//����id
	
	private String startPlace;
	private String endPlace;
	private String weight;//����
	private String transportType;//��������
	private String transportReq;//��Ӧҳ���ϵĳ���Ҫ���ڴ��ֶν���ģ����ѯ����������ʽ��ƽ��
	
	private String name;//��������
	private Date relDate;
	private Date limitDate;
	
	private String status;//��ע״̬

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

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getTransportReq() {
		return transportReq;
	}

	public void setTransportReq(String transportReq) {
		this.transportReq = transportReq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRelDate() {
		return relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
