package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.SubAccountDao;

import cn.edu.bjtu.vo.SubAccount;


@Repository

/**
 * ���˻�dao��ʵ��
 *
 */
public class SubAccountDaoImpl extends BaseDaoImpl<SubAccount> implements SubAccountDao{

	
	@Override
	public List getSubAccount(String userId) {
		
		return this.find("from SubAccount where hostAccountId='"+userId+"'");
	}
	
	@Override
	public boolean changeStatus(String id){
		
		SubAccount subAccount = this.get(SubAccount.class, id);
		String temp="";
		temp=subAccount.getStatus();
		if(temp.equals("��ͣ��")){
			subAccount.setStatus("����");// �޸�״̬
		}
		else if(temp.equals("����")){
			subAccount.setStatus("��ͣ��");// �޸�״̬
		}

		//return baseDao.update(subAccount);
		this.save(subAccount);
		return true;
	}
	
	@Override
	public boolean deleteSubAccount(String id){
		
		SubAccount subAccount =this.get(SubAccount.class, id);
		this.delete(subAccount);
		 return true;
	}
}
