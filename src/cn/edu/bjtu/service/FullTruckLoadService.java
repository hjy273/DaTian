/**
 * 
 */
package cn.edu.bjtu.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONArray;

import cn.edu.bjtu.bean.search.CityLineSearchBean;
import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Truck;

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
	
	public Truck getfulltruckloadInfo(String truckId);
	
	/**
	 * �ҵ���Ϣ-�ҵ�������Դ
	 * @param session
	 * @param pageUtil
	 * @return
	 */
	public JSONArray getUserFullTruckLoadResource(HttpSession session,PageUtil pageUtil);
	
	public boolean insertNewFullTruckLoad(Truck truck,HttpServletRequest request, MultipartFile file);
	
	public boolean deletefulltruckLoad(String id);
	
	public boolean updateFullTruckLoad(Truck truck,HttpServletRequest request,MultipartFile file);

}
