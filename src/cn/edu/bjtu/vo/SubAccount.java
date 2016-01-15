package cn.edu.bjtu.vo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author RussWest0
 *
 */
@Entity
@Table(name="subaccount")
public class SubAccount {
	@Id
	private String id;
	private String username;
	private String password;
	@Deprecated
	private String phone;//�ϳ�
	@Deprecated
	private String email;//�ϳ�
	private String hostAccountId;
	private String hostAccountName;
	private String status;
	private String  resourceManagement;
	private String  transactionManagement;
	private String  schemaManagement;
	private String statisticsManagement;
	private Date relDate;
	private String remarks;
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHostAccountId() {
		return hostAccountId;
	}
	public void setHostAccountId(String hostAccountId) {
		this.hostAccountId = hostAccountId;
	}
	public String getHostAccountName() {
		return hostAccountName;
	}
	public void setHostAccountName(String hostAccountName) {
		this.hostAccountName = hostAccountName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getResourceManagement() {
		return resourceManagement;
	}
	public void setResourceManagement(String resourceManagement) {
		this.resourceManagement = resourceManagement;
	}
	public String getTransactionManagement() {
		return transactionManagement;
	}
	public void setTransactionManagement(String transactionManagement) {
		this.transactionManagement = transactionManagement;
	}
	public String getSchemaManagement() {
		return schemaManagement;
	}
	public void setSchemaManagement(String schemaManagement) {
		this.schemaManagement = schemaManagement;
	}
	public String getStatisticsManagement() {
		return statisticsManagement;
	}
	public void setStatisticsManagement(String statisticsManagement) {
		this.statisticsManagement = statisticsManagement;
	}
	
	

}
