package cn.edu.bjtu.util;

import java.util.List;

/**
 * ��ҳ�����
 * @author RussWest0
 * @date   2015��5��27�� ����11:20:07
 */
public class PageUtil {
	//public static final int NUMBERS_PER_PAGE = 10;
	
	
	private int display;//ÿҳ��Ŀ
	private int totalRows;//�ܼ�¼��
	private int totalPages;//��ҳ��
	private int currentPage;//��ǰҳ
	private int startIndex;//��¼��ʼ
	private int lastIndex;//��¼����
	
	
	public int getDisplay() {
		return display;
	}
	public void setDisplay(int display) {
		this.display = display;
	}
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getLastIndex() {
		return lastIndex;
	}
	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
	
	
}
