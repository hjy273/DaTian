package cn.edu.bjtu.vo;

// Generated 2015-1-31 22:44:34 by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Attention generated by hbm2java
 */
@Entity
@Table(name="attention")
public class Attention implements java.io.Serializable {
	@Id
	private String id;
	private Integer type;
	private Date relDate;
	private String clientId;
	private String state;
	private String typeId;

	public Attention() {
	}

	public Attention(String id) {
		this.id = id;
	}

	public Attention(String id, Integer type, Date relDate, String clientId,
			String state, String typeId) {
		this.id = id;
		this.type = type;
		this.relDate = relDate;
		this.clientId = clientId;
		this.state = state;
		this.typeId = typeId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Date getRelDate() {
		return this.relDate;
	}

	public void setRelDate(Date relDate) {
		this.relDate = relDate;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

}
