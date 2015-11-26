package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.SubAccountBean;
import cn.edu.bjtu.dao.SubAccountDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.SubAccountService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.Encrypt;

import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.SubAccount;
import cn.edu.bjtu.vo.Userinfo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@Transactional
@Service("subAccountServiceImpl")
/**
 * ���˻������ʵ�� 
 * 
 *
 */
public class SubAccountServiceImpl implements SubAccountService{
	
	@Resource 
	SubAccountDao subAccountDao;
	@Resource
	SubAccount subAccount;
	@Autowired
	UserinfoDao userinfoDao;
	
	@Override
	/**
	 * ��ȡ���˻��б�
	 */
	public List getSubAccount(String userId) {
		
		
		return subAccountDao.getSubAccount(userId);
	}
	
	
	
	@Override
	public boolean changeStatus(String id){
		return subAccountDao.changeStatus(id);
	}
	
	/**
	 * ɾ����˾���˻�
	 */
	@Override
	public boolean deleteSubAccount(String id){
		subAccountDao.deleteSubAccount(id);
		//ɾ��userinfo��
		Userinfo user=userinfoDao.get(Userinfo.class, id);
		
		userinfoDao.delete(user);
		
		return true;
		
	}
	
	
	@Override
	public boolean updateSubAccount(SubAccountBean subAccountBean,HttpSession session){
		
		SubAccount sub_account=subAccountDao.get(SubAccount.class, subAccountBean.getId());
		sub_account.setPassword(Encrypt.MD5(subAccountBean.getPassword()));
		sub_account.setRemarks(subAccountBean.getRemarks());
		sub_account.setResourceManagement(subAccountBean.getResourceManagement());
		sub_account.setSchemaManagement(subAccountBean.getSchemaManagement());
		sub_account.setStatisticsManagement(subAccountBean.getStatisticsManagement());
		sub_account.setTransactionManagement(subAccountBean.getTransactionManagement());
		//�˻�Ϊ��username-��username��ʽ
		sub_account.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		
		subAccountDao.update(sub_account);
		
		//����userinfo��
		Userinfo user=userinfoDao.get(Userinfo.class, subAccountBean.getId());
		user.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		user.setPassword(Encrypt.MD5(subAccountBean.getPassword()));//δ����
		return true;
	}

	/**
	 * ��������ׯ��
	 */
	@Override
	public boolean addNewSubAccount(SubAccountBean subAccountBean,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		SubAccount sub_account=new SubAccount();
		BeanUtils.copyProperties(subAccountBean, sub_account);
		sub_account.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		sub_account.setPassword(Encrypt.MD5(subAccountBean.getPassword()));
		sub_account.setId(IdCreator.createSubAccountId());
		sub_account.setHostAccountId(userId);
		sub_account.setRelDate(new Date());
		sub_account.setStatus("����");
		subAccountDao.save(sub_account);
		
		//����userinfo��
		Userinfo userInfo=new Userinfo();
		userInfo.setUsername(subAccountBean.getHostAccountName().trim()+"-"+subAccountBean.getUsername());
		//userInfo.setPhone(phone);
		userInfo.setId(sub_account.getId());
		userInfo.setPassword(Encrypt.MD5(subAccountBean.getPassword()));//δ����
		userInfo.setStatus("δ��֤");
		userInfo.setEmailStatus("δ��");
		userInfo.setPhoneStatus("�Ѱ�");
		userInfo.setSecurityQuestionStatus("δ����");
		//userInfo.setPrivilege(privilege);
		userInfo.setStatus("δ��֤");
		userInfo.setUserKind(3);//Ĭ����Ϊ��ҵ�û�
		userInfo.setHeadIcon("δ����");// add by RussWest0 at 2015��6��2��,����11:56:49 
		userinfoDao.save(userInfo);//����ʵ��
		return true;
	}

	/**
	 * ��ȡ�����˻�
	 */
	@Override
	public SubAccount getSubAccountDetail(String id) {
		
		return subAccountDao.get(SubAccount.class, id);
	}
	
	/**
	 * �����˻�
	 */
	@Override
	public String getSubAccountList(HttpSession session,SubAccount subAccount,PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="from SubAccount t "+whereHql(subAccount,params);
		hql+=" and t.hostAccountId=:hostAccountId ";
		params.put("hostAccountId", carrierId);
		List<SubAccount> subAccountList=subAccountDao.find(hql, params);
		JSONArray jsonArray=new JSONArray();
		for(SubAccount sub:subAccountList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(sub);
			jsonArray.add(jsonObject);
		}
		return jsonArray.toString();
	}

	/**
	 * �����˻�-�ܼ�¼��
	 */
	@Override
	public Integer getSubAccountTotalRows(HttpSession session,SubAccount subAccount) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="select count(*) from SubAccount t where t.hostAccountId=:hostAccountId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("hostAccountId", carrierId);
		Long count=subAccountDao.count(hql, params);
		
		return count.intValue();
		
	}
	
	/**
	 * where hql
	 * @param subAccount
	 * @param params
	 * @return
	 */
	private String whereHql(SubAccount subAccount,Map<String,Object> params){
		String hql="where 1=1 ";
		if(subAccount !=null){
			if(!"".equals(subAccount.getUsername()) && subAccount.getUsername()!=null){
				hql+=" and t.username like '%"+subAccount.getUsername()+"%'";
			}
		}
		
		return hql;
	}

	
	/**
	 * ��鸽���˻��Ƿ����
	 */
	@Override
	public boolean checkSubAccountUsername(String username) {
		String hql="select count(*) from SubAccount t where t.username=:username";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("username", username);
		
		Long count=subAccountDao.count(hql, params);
		if(count ==0){//������
			return false;
		}else
			return true;
		
	}
	
	
	
}
