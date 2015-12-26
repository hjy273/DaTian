package cn.edu.bjtu.bean.page;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * �������pagebean
 * @author iver
 * @date   2015��12��23�� ����8:51:29
 */
public class FinancialBean {
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date date;//ʱ��yyyy-mm-dd
	private Double transportFee;//�˷�����
	private Double totalInsurance;//���շ�����
	private Double totalFee;//�ϼ�
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date startDate;
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date endDate;
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the transportFee
	 */
	public Double getTransportFee() {
		return transportFee;
	}
	/**
	 * @param transportFee the transportFee to set
	 */
	public void setTransportFee(Double transportFee) {
		this.transportFee = transportFee;
	}
	/**
	 * @return the totalInsurance
	 */
	public Double getTotalInsurance() {
		return totalInsurance;
	}
	/**
	 * @param totalInsurance the totalInsurance to set
	 */
	public void setTotalInsurance(Double totalInsurance) {
		this.totalInsurance = totalInsurance;
	}
	/**
	 * @return the totalFee
	 */
	public Double getTotalFee() {
		return totalFee;
	}
	/**
	 * @param totalFee the totalFee to set
	 */
	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	
}
