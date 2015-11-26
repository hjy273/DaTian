package cn.edu.bjtu.dao.impl;


import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.LinetransportDao;

import cn.edu.bjtu.vo.Linetransport;

@Repository
public class LinetransportDaoImpl extends BaseDaoImpl<Linetransport> implements LinetransportDao {


	/**
	 * ���ؾ��������Ϣ
	 */
	@Override
	public Linetransport getLinetransportInfo(String linetransportid) {
		
		return this.get(Linetransport.class, linetransportid);
	}


}
