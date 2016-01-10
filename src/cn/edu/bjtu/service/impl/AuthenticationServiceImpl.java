package cn.edu.bjtu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.AuthenticationService;

import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Transactional
@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService{
	
	@Autowired
	AuthenticationDao authenticationDao;
	@Autowired
	UserinfoDao userinfoDao;	
	
	@Override
	/**
	 * ��ȡ������֤��Ϣ
	 */
	public List<Userinfo> getAllAuthentication() {
		
		return authenticationDao.getAllAuthentication();
	}
	@Override
	/**
	 * ��ȡ������Ϣ
	 * @param clientId
	 * return
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		return authenticationDao.getMyUserDetail(clientId);
	}
	@Override
	/**
	 * ��ȡ������Ϣ
	 * @param clientId
	 * return
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return authenticationDao.getAuthenticationInfo(clientId);
	}
	
	 @Override
	 /**
	  * ������֤״̬
	  * @param clientId
	  * @param status
	  */
	public boolean updateAuthenticStatus(String feedback, String clientId,String status) {
			
		Userinfo userinfo = getMyUserDetail(clientId);
		userinfo.setFeedback(feedback);
		userinfo.setStatus(status);
		authenticationDao.update(userinfo);//����ʵ��
		 return true;
	}
	@Override
	public List getFindUser(String username) {
		
		return authenticationDao.getFindUser(username);
	}
	
	/**
	 * �����û���˾ܾ�
	 */
	@Override
	public boolean authenUserDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("δ��֤");
		userinfo.setFeedback(feedback);
		
		userinfoDao.update(userinfo);
		return true;
	}
	
	/**
	 * �����û����ͨ��
	 */
	@Override
	public boolean authenUserPass(String feedback, String user_id) {
		
		Userinfo userinfo = userinfoDao.get(Userinfo.class, user_id);

		userinfo.setStatus("�����");
		userinfo.setFeedback(feedback);

		userinfoDao.update(userinfo);
		return true;
	}
	/**
	 * ��˾�û���֤�ܾ�
	 */
	@Override
	public boolean authenCompanyDeny(String feedback, String user_id) {
		
		Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("δ��֤");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
		
	}
	
	/**
	 * ��˾�û���֤ͨ��
	 */
	@Override
	public boolean authenCompanyPass(String feedback, String user_id) {

Userinfo userinfo=userinfoDao.get(Userinfo.class, user_id);
		
		userinfo.setStatus("�����");
		userinfo.setFeedback(feedback);
		userinfoDao.update(userinfo);
		
		return true;
	
	}
	
	
	
}
