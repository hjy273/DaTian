package cn.edu.bjtu.util;

import java.util.ArrayList;
import java.util.List;

/**
 * JSON���߰�
 * @author RussWest0
 * @date   2015��6��13�� ����5:22:13
 */
public class DataModel {
	
	private Long total = 0L;
	private List rows = new ArrayList();
	
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
	

}
