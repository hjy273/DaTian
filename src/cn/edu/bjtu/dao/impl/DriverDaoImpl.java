package cn.edu.bjtu.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.DriverDao;
import cn.edu.bjtu.vo.Driverinfo;
@Repository
public class DriverDaoImpl extends BaseDaoImpl<Driverinfo> implements DriverDao{

	@Override
	public Driverinfo getDriverInfo(String driverId) {
		
		return this.get(Driverinfo.class,driverId);
	}
	@Override
	/**
	 * ��ȡĳ��˾������˾������ 
	 */
	public List getAllDriverName(String carrierId) {
		
		return this.find("select driverName from Driverinfo where carrierId='"+carrierId+"'");
	}

	@Override
	/**
	 * ��ȡĳ��˾������˾����Ϣ 
	 */
	public List getAllDriver(String carrierId) {
		
		
		return this.find("from Driverinfo where carrierId='"+carrierId+"'");
	}
	

	@Override
	public String getDriverIdByName(String driverName) {
		
		return "";
	}


}
