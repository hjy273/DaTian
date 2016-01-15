package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attention generated by hbm2java
 */
@Entity
@Table(name="track")
public class Track implements java.io.Serializable {
	@Id
	private String id;
	private String orderId;
	private String carNum;
	private Double locLongitude;//经度
	private Double locLatitude;//纬度
	//add by solitudeycq at 2015-12-21 19:50 增加时间
	private String time;
	
	private String address;
	private String orderNum;

	/**
	 * @return orderNum
	 */
	public String getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum 要设置的 orderNum
	 */
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address 要设置的 address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public Track() {
	}

	public Track(String id) {
		this.id = id;
	}

	public Track(String id, String orderId, String orderNum,String carNum,
			Double locLongitude, Double locLatitude,String time,String address) {
		this.id = id;
		this.orderId = orderId;
		this.carNum = carNum;
		this.locLongitude = locLongitude;
		this.locLatitude = locLatitude;
		this.orderNum = orderNum;
		this.time = time;
		this.address = address;
	}

	/**
	 * @return time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time 要设置的 time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}


	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}


	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public Double getLocLongitude() {
		return this.locLongitude;
	}

	public void setLocLongitude(Double locLongitude) {
		this.locLongitude = locLongitude;
	}

	public Double getLocLatitude() {
		return this.locLatitude;
	}

	public void setLocLatitude(Double locLatitude) {
		this.locLatitude = locLatitude;
	}

}
