package cn.edu.bjtu.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * @author RussWest0
 *
 */
public interface ContractService {

	public Contract getContractInfo(String contractId);
	public boolean insertNewContract(Contract contract,HttpServletRequest request,MultipartFile file);
	public boolean shutdownContract(String contractId,String reason);

	public boolean changeStatus(String id);

	public List<Contract> getContractByClientId(String clientId);
	
	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ
	 * @Title: getUserContract 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: JSONObject 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����5:44:24
	 */
	public JSONArray getUserContract(HttpSession session,PageUtil pageUtil,Contract contract);
	
	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ-�ܼ�¼��
	 * @Title: getUserContractTotalRows 
	 *  
	 * @param: @param session
	 * @param: @return 
	 * @return: Integer 
	 * @throws: �쳣 
	 * @author: chendonghao 
	 * @date: 2015��7��3�� ����5:46:09
	 */
	public Integer getUserContractTotalRows(HttpSession session,Contract contract);
	
	

}
