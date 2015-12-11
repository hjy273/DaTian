package cn.edu.bjtu.dao;

import java.util.List;

import cn.edu.bjtu.vo.Driverinfo;
/**
 * ˾�����Dao
 * @author RussWest0
 * @date   2015��5��24�� ����10:09:02
 */
public interface DriverDao extends BaseDao<Driverinfo>{
	public Driverinfo getDriverInfo(String driverId);
	public List getAllDriverName(String carrierId);
	public List getAllDriver(String carrierId);
	public String getDriverIdByName(String driverName);
}
