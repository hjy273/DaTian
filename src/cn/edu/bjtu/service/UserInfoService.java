package cn.edu.bjtu.service;

import java.util.List;

import cn.edu.bjtu.vo.Userinfo;

public interface UserInfoService {
	/**
	 * �����û���ȡȨ��
	 * @param username
	 * @return
	 */
	public List<String> getPermissionsByUserName(String username);
	/**
	 * �����û�����ȡ�û�
	 * @param username
	 * @return
	 */
	public Userinfo getUserByUserName(String username);
}
