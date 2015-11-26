package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.ContractDao;
import cn.edu.bjtu.service.ContractService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.ParseDate;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Contract;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
@Transactional
@Service("contractServiceImpl")
/**
 * ��ͬ�����ʵ�� 
 * @author RussWest0
 *
 */
public class ContractServiceImpl implements ContractService{

	@Resource
	ContractDao contractDao;
	@Resource 
	Contract contract;
	@Autowired
	CompanyDao companyDao;

	
	
	@Override
	public List<Contract> getContractByClientId(String clientId) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", clientId);
		String hql="from Contract where clientId=:clientId";
		return contractDao.find(hql,params);
	}

	@Override
	/**
	 * ��ȡ��ͬ��Ϣ
	 */
	public Contract getContractInfo(String contractId) {
		
		return contractDao.getContractInfo(contractId);
	}
	/**
	 * ������ͬ
	 */
	@Override
	public boolean insertNewContract(Contract contract,HttpServletRequest request,MultipartFile file){
		String userId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, userId, "contract");
		contract.setCarrierId(contract.getCarrierId());
		contract.setClientId(userId);
		contract.setState("��ȷ��");//�½���ͬ�ĳ�ʼ״̬Ϊ��ȷ��  
		contract.setCreateTime(new Date());//���ô�����ͬʱ��  add by russwest at 2015��8��29��,����11:30:29 
		Carrierinfo company=companyDao.get(Carrierinfo.class, contract.getCarrierId());
		contract.setCarrierAccount(company.getCompanyName());
		
		//�����ļ�λ�� 
		contract.setRelatedMaterial(fileLocation);
		contractDao.save(contract);// ����ʵ��
		return true;
	}
	
	@Override
	/**
	 * ��ֹ��ͬ
	 */
	public boolean shutdownContract(String contractId, String reason) {
		
		return contractDao.shutdownContract(contractId,reason);
	}
	
	@Override
	public boolean changeStatus(String id) {
		
		return contractDao.changeStatus(id);
	}
	
	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ
	 */
	@Override
	public JSONArray getUserContract(HttpSession session,PageUtil pageUtil,Contract contract) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from Contract t "+whereHql(contract,params);
		if(userKind == 2){//�����û�
			hql+=" and t.clientId=:userId";
		}else if(userKind == 3){//��ҵ�û�
			hql+=" and t.carrierId=:userId";
		}
		hql+=" order by t.createTime desc";
		params.put("userId", userId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Contract> contractList = contractDao.find(hql, params,page,display);
		JSONArray jsonArray = new JSONArray();
		for (Contract contractIns : contractList) {
			JSONObject jsonObject = (JSONObject) JSONObject.toJSON(contractIns);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;

	}
	
	/**
	 * where hql
	 * @param contract
	 * @return
	 */
	private String whereHql(Contract contract,Map<String,Object> params){
		String hql=" where 1=1 ";
		String startDate=contract.getStartDate()==null?"1970-01-01":ParseDate.DateToString(contract.getStartDate());
		String endDate=contract.getEndDate()==null?"1970-01-01":ParseDate.DateToString(contract.getEndDate());
		if(!"1970-01-01".equals(startDate)){
			hql+="and t.startDate >=:startDate ";
			params.put("startDate", contract.getStartDate());
		}
		if(!"1970-01-01".equals(endDate)){
			hql+=" and t.endDate <=:endDate ";
			params.put("endDate", contract.getEndDate());
		}
		if(!"".equals(contract.getName()) && contract.getName()!=null){
			hql+=" and t.name like '%"+contract.getName()+"%' ";
//			params.put("name", contract.getName());
		}
		return hql;
	}

	/**
	 * �ҵ���Ϣ-��ͬ��Ϣ-�ܼ�¼��
	 */
	@Override
	public Integer getUserContractTotalRows(HttpSession session,Contract contract) {
		Map<String,Object> params=new HashMap<String,Object>();
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Integer userKind=(Integer)session.getAttribute(Constant.USER_KIND);
		String hql="select count(*) from Contract t "+whereHql(contract,params);
		if(userKind == 2){//�����û�
			hql+=" and t.clientId=:userId";
		}else if(userKind == 3){//��ҵ�û�
			hql+=" and t.carrierId=:userId";
		}
		params.put("userId", userId);
		
		Long count=contractDao.count(hql, params);
		return count.intValue();
	}

}
