package cn.edu.bjtu.vo.safety;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * ��ɫ��
 * @author iver
 * @date   2016��1��22�� ����4:56:47
 */
@Entity
@Table(name="t_role")
public class Role {
	@Id
	private Integer id;
	private String name;//��ɫ����
	private String description;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
