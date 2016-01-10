package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.ContractDao;

import cn.edu.bjtu.vo.Contract;
@Repository
/**
 * ��ͬdao��ʵ��
 * @author RussWest0
 *
 */
public class ContractDaoImpl extends BaseDaoImpl<Contract> implements ContractDao{

	
	@Override
	/**
	 * ���ع�˾��ͬ
	 */
	public List getCompanyContract(String carrierId) {
		
		return this.find("from Contract where carrierId='"+carrierId+"'");
	}
	
	/*@Override
	public List getCompanyContractForUser(String clientId) {
		
		return this.find("from Contract where clientId='"+clientId+"'");
	}*/
	
	@Override
	/**
	 * ���غ�ͬ��Ϣ
	 */
	public Contract getContractInfo(String contractId) {
		
		return this.get(Contract.class, contractId);
	}
	@Override
	/**
	 * ��ֹ��ͬ
	 */
	public boolean shutdownContract(String contractId, String reason) {
		
		Contract contract=this.get(Contract.class, contractId);
		contract.setState("����ֹ");//����״̬
		contract.setReason(reason);
		/*baseDao.update(contract);		*/
		this.update(contract);
		return true;
	}
	
	
	@Override
	public boolean changeStatus(String id) {
		
		Contract contract = this.get(Contract.class, id);
		String temp="";
		temp=contract.getState();
		if(temp.equals("��ȷ��")){
			contract.setState("��Ч");// �޸�״̬
		}

		//return baseDao.update(subAccount);
		this.update(contract);
		return true;
	}
	
}
