/**
 * 
 */
package cn.edu.bjtu.service;

import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.util.PageUtil;

/**
 * @author solitudeycq
 *
 */
public interface FullTruckLoadService {
	
	/**
	 * ��Դ����ȡɸѡ������Դ
	 * @param truckBean
	 * @param pageUtil
	 * @param session
	 * @return
	 */
	public JSONArray getSelectedFullTruckLoadNew(TruckBean truckBean,PageUtil pageUtil,HttpSession session);

}
