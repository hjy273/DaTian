package cn.edu.bjtu.bean.search;

import java.util.Date;

/**
 * ��Դ����������ɸѡpagebean
 * @author RussWest0
 * @date   2015��6��13�� ����1:34:38
 */
public class CityLineSearchBean {

	private String id;
	private String cityName;//��������
	private String refPrice;
	private String companyName;
	private String VIPService;//��ֵ����
	private Integer creditRate;//���õȼ�
	private Date relDate;
	private String status;//��ע״̬
	private String name;//��Դ����
	private String carrierId;//���˷�id
	
	public String getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getRefPrice() {
		return refPrice;
	}
	public void setRefPrice(String refPrice) {
		this.refPrice = refPrice;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getVIPService() {
		return VIPService;
	}
	public void setVIPService(String vIPService) {
		VIPService = vIPService;
	}
	
	public Integer getCreditRate() {
		return creditRate;
	}
	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
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
	
	
}
