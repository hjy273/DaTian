package cn.edu.bjtu.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.CompanycertificateDao;
import cn.edu.bjtu.dao.RegisterDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.service.RegisterService;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Companycertificate;
import cn.edu.bjtu.vo.Userinfo;
@Service("registerServiceImpl")
@Transactional
/**
 * 
 * @author RussWest0
 *
 */
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	UserinfoDao userinfoDao;
	@Autowired
	ClientDao clientDao;
	@Autowired
	CompanyDao companyDao;	
	@Autowired
	CompanycertificateDao companyCertificateDao;
	@Resource
	Carrierinfo carrierinfo;
	@Autowired
	Companycertificate companyCertificate;
	
	@Resource
	Clientinfo clientInfo;
	@Resource
	RegisterDao registerDao;
	@Override
	public String register(String username, String password, String phone,int userKind) {
		
		Userinfo userInfo=new Userinfo();
		userInfo.setUsername(username);
		userInfo.setPhone(phone);
		userInfo.setId(IdCreator.createClientId());
		userInfo.setPassword(password);//δ����
		userInfo.setStatus("δ��֤");
		userInfo.setEmailStatus("δ��");
		userInfo.setPhoneStatus("�Ѱ�");
		userInfo.setSecurityQuestionStatus("δ����");
		//userInfo.setPrivilege(privilege);
		userInfo.setStatus("δ��֤");
		userInfo.setUserKind(userKind);
		userInfo.setHeadIcon("δ����");// add by RussWest0 at 2015��6��2��,����11:56:49 
		userinfoDao.save(userInfo);//����ʵ��
		
		if(userKind == 2){//�����û�
		clientInfo.setId(userInfo.getId());//ͬʱ����Ϣ���б���ʵ��
		//clientInfo.setCarrierId(carrierId);
		clientInfo.setCreateDate(new Date());
		clientInfo.setPhone(phone);
		//clientInfo.setHeadIcon("δ����");// add by RussWest0 at 2015��5��31��,����10:47:42 
		clientDao.save(clientInfo);//����clientinfoʵ��
		}
		else //��ҵ�û���Ŀǰά��������˾���Ժ��ع���һ��
		{
			companyCertificate.setId(userInfo.getId());
			companyCertificate.setPhone(phone);
			companyCertificateDao.save(companyCertificate);
			
			
			carrierinfo.setPhone(phone);
			carrierinfo.setId(userInfo.getId());
			carrierinfo.setStatus("δ��֤");
			companyDao.save(carrierinfo);
		}
		
		return userInfo.getId();
	}
	@Override
	/**
	 * ����û���
	 */
	public List getUserCheck(String username) {
		
		return registerDao.getUserCheck(username);
	}
	
	
	

}
