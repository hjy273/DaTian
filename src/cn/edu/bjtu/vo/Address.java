package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	@Id
	private String id;
	private String name;
	private String address;
	private String phone;
	private Date relDate;
	private String clientId;
	private int frequency;
	
	private Integer kind;//1��������ַ2��ʾ�ջ���ַ
	
	
	/**
	 * @return the kind
	 */
	public Integer getKind() {
		return kind;
	}
	/**
	 * @param kind the kind to set
	 */
	public void setKind(Integer kind) {
		this.kind = kind;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getRelDate() {
		return relDate;
	}
	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
