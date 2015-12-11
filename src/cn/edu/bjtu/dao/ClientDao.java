package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Businessclient;
import cn.edu.bjtu.vo.Clientinfo;

/**
 * 
 * @author RussWest0
 *
 */
public interface ClientDao extends BaseDao<Clientinfo>{
	public boolean validateUser(String userId,String realName,String phone,String IDCard,
			String sex, String path, String fileName);

}
