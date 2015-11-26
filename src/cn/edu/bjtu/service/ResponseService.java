package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Response;

import com.alibaba.fastjson.JSONArray;

/**
 * ������ص�serivce
 * @author RussWest0
 * @date   2015��6��2�� ����11:06:13
 */
public interface ResponseService{

	/**
	 * ����id�õ���ͼʵ��,�����ҵķ���ҳ���ϵ��
	 * @param responseId
	 * @return
	 */
//	public Response getResponseById(String responseId);
	
	/**
	 * ���ݻ���id�õ����ﷴ����Ϣ
	 * @param goodsId
	 * @return
	 */
	public List<Response> getResponseListByGoodsId(String goodsId);
	
	/**
	 * ����id�õ�����������Ϣ
	 * @param responseId
	 * @return
	 */
	public Response getResponseById(String responseId);
	
	/**
	 * ȷ�Ϸ������޸�״̬
	 * @param responseId
	 * @return
	 */
	public boolean confirmResponse(String responseId,String carrierId,String goodsId);
	
	/**
	 * ��ȡ�û������з���
	 * @param session
	 * @return
	 */
	public JSONArray getUserResponse(HttpSession session,PageUtil pageUtil);
	
	/*
	 * �ҵķ���-������
	 */
	public Integer getUserResponseTotalRows(HttpSession session);
}
