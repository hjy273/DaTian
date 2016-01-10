package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.AuthenticationDao;
import cn.edu.bjtu.dao.ClientDao;
import cn.edu.bjtu.dao.UserinfoDao;
import cn.edu.bjtu.vo.Clientinfo;
import cn.edu.bjtu.vo.Userinfo;
@Repository
/**
 * ��ͬdao��ʵ��
 * @author RussWest0
 *
 */
public class AuthenticationDaoImpl extends BaseDaoImpl<Userinfo> implements AuthenticationDao{

	@Autowired
	ClientDao clientInfoDao;
	@Autowired
	UserinfoDao userinfoDao;
	@Override
	/**
	 * ������֤�б�
	 */
	public List<Userinfo> getAllAuthentication() {
		
		return this.find("from Userinfo where status = '�����' or status = '�����'");
	}
	
	@Override
	/**
	 * ������֤��Ϣ
	 */
	public Clientinfo getAuthenticationInfo(String clientId) {
		
		return clientInfoDao.get(Clientinfo.class, clientId);
	}

	@Override
	/**
	 * ���ظ�����Ϣ
	 * @param clientId
	 */
	public Userinfo getMyUserDetail(String clientId) {
		
		
		return userinfoDao.get(Userinfo.class,clientId);
		
	}

	@Override
	public List getFindUser(String username) {
		
		String sql = "from Userinfo where (status = '�����' or status = '�����') ";
			if (username.equals("�û���")) {
				// ����ʱ�������û���
			} else
				sql += "and username like '%" + username + "%'";
		return userinfoDao.find(sql);
	}

	
}