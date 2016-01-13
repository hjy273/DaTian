package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.bjtu.bean.page.LinetransportBean;
import cn.edu.bjtu.bean.search.LinetransportSearchBean;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LinetransportService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.DataModel;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.util.PageUtil;
import cn.edu.bjtu.util.UploadFile;
import cn.edu.bjtu.vo.Focus;
import cn.edu.bjtu.vo.Linetransport;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Transactional
@Service
/**
 * 
 * @author RussWest0
 *
 */
public class LinetransportServiceImpl implements LinetransportService {

	@Resource
	LinetransportDao linetransportDao;
	@Autowired
	FocusService focusService;
	
	private Logger logger=Logger.getLogger(LinetransportServiceImpl.class);

	@Override
	/**
	 * ���ظ�����Ϣ
	 */
	public Linetransport getLinetransportInfo(String linetransportid) {
		
		return linetransportDao.get(Linetransport.class, linetransportid);
	}


	@Override
	/**
	 * ��������
	 */
	public boolean insertNewLinetransport(Linetransport line,HttpServletRequest request, MultipartFile file){
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "linetransport");
		
		line.setRelDate(new Date());
		line.setCarrierId(carrierId);
		line.setId(IdCreator.createlineTransportId());
		
		//�����ļ�λ�� 
		line.setDetailPrice(fileLocation);
		linetransportDao.save(line);// ����ʵ��
		return true;
	}
	@Override
	// δʵ��
	public String getLinetransportIdByCity(String startPlace, String endPlace) {
		//FIXME 
		return "";
	}


	@Override
	/**
	 * ɾ������
	 */
	public boolean deleteLine(String id) {
		Linetransport linetransport = getLinetransportInfo(id);// ����id���ҵ�������Ϣ

		linetransportDao.delete(linetransport);
		
		//�Ѵ˹�ע���еĴ˸�����Ϣ����ΪʧЧ
		
		focusService.setInvalid(id);
		
		return true;
	}
	
	
	/**
	 * ������ɸѡ����
	 */
	@Override
	public DataModel getSelectedLineNew(LinetransportSearchBean linetransportbean,
			PageUtil pageUtil,HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String sql = "select t1.id,"
				+ "t1.carrierId,"
				+ "t1.lineName,"
				+ "t1.startPlace,"
				+ "t1.endPlace,"
				+ "t1.refPrice,"
				+ "t1.relDate,"
				+ "t1.type,"
				+ "t1.onWayTime,"
				+ "t1.companyName,"
				+ "t3.status "
				+ " from line_carrier_view t1 "
				+ "left join ("
				+ "select * from focus t2 ";
				
		if(userId!=null){//�����ǰ���û���¼�������м����û���Ϣ
			sql+=" where t2.focusType='linetransport' and t2.clientId=:clientId ";
			params.put("clientId", userId);
		}else{
			sql+=" where t2.focusType='linetransport' and t2.clientId='' ";
		}
		sql+=") t3 on t1.id=t3.focusId ";
		String wheresql=whereSql(linetransportbean,params);
		sql+=wheresql+" order by t1.relDate desc";
		
		//JSONArray jsonArray = new JSONArray();
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Object[]> objectList=linetransportDao.findBySql(sql, params,page,display);
		
		List<LinetransportSearchBean> lineList=new ArrayList<LinetransportSearchBean>();
		for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
			LinetransportSearchBean lineBean=new LinetransportSearchBean();
			
			Object[] obj=it.next();
			lineBean.setId((String)obj[0]);
			lineBean.setCarrierId((String)obj[1]);
			lineBean.setLineName((String)obj[2]);
			lineBean.setStartPlace((String)obj[3]);
			lineBean.setEndPlace((String)obj[4]);
			lineBean.setRefPrice(((Float)obj[5])+"");
			lineBean.setRelDate((Date)obj[6]);
			lineBean.setTransportType((String)obj[7]);
			lineBean.setOnWayTime((Integer)obj[8]);
			lineBean.setCompanyName((String)obj[9]);
			lineBean.setStatus((String)obj[10]);
			lineList.add(lineBean);
		}
		//����������
		DataModel dataModel=new DataModel();
		/*String countsql="select count(t1.id) from line_carrier_view t1"+whereSql(linetransportbean,params);
		//Long count=linetransportDao.countBySql(countsql, params);
		Long count=linetransportDao.countBySql("select count(*) from linetransport");
		dataModel.setTotal(count);*/
		dataModel.setRows(lineList);
		return dataModel;
	}
	
	/**
	 * ƴ��where
	 * @param linetransportBean
	 * @param page
	 * @param params
	 * @return
	 */
	private String whereSql(LinetransportSearchBean linetransportBean,Map<String,Object> params){
		
		String wheresql=" where 1=1 ";
		if(linetransportBean.getStartPlace()!=null && !linetransportBean.getStartPlace().trim().equals("���Ļ�ƴ��")&&
				!linetransportBean.getStartPlace().trim().equals("ȫ��") && !linetransportBean.getStartPlace().trim().equals("")
				&& !linetransportBean.getStartPlace().trim().equals("All")){
			wheresql+=" and t1.startPlace=:startPlace";
			params.put("startPlace", linetransportBean.getStartPlace());
		}
		if(linetransportBean.getEndPlace()!=null && !linetransportBean.getEndPlace().trim().equals("���Ļ�ƴ��")&&
				!linetransportBean.getEndPlace().trim().equals("ȫ��") && !linetransportBean.getEndPlace().trim().equals("")
				&& !linetransportBean.getEndPlace().trim().equals("All")){
			wheresql+=" and t1.endPlace=:endPlace";
			params.put("endPlace", linetransportBean.getEndPlace());
		}
		if(linetransportBean.getRefPrice()!=null && !linetransportBean.getRefPrice().trim().equals("All") && !linetransportBean.getRefPrice().trim().equals("")){
			String refPrice=linetransportBean.getRefPrice().trim();
			if(refPrice.equals("����2Ԫ/kg")){
				wheresql+=" and t1.refPrice >= 2 ";
			}
			if(refPrice.equals("1��2Ԫ/kg")){
				wheresql+=" and t1.refPrice >= 1 and t1.refPrice <= 1 ";
			}
			if(refPrice.equals("С��1Ԫ/kg")){
				wheresql+=" and t1.refPrice <=1 ";
			}
		}
		if(linetransportBean.getTransportType()!=null && !linetransportBean.getTransportType().trim().equals("All") && !linetransportBean.getTransportType().trim().equals("")){
			wheresql+=" and t1.type=:transportType ";
			params.put("transportType", linetransportBean.getTransportType());
		}
		//ʼ�������Ȳ�ʵ��
		/*if(linetransportBean.getFromPlace() != null && linetr linetransportBean.getFromPlace().trim().equals("All")){
			
		}*/
		
		return wheresql;
		
	}
	/**
	 * ����ɸѡ������
	 */
	@Override
	public Integer getSelectedLineTotalRows(LinetransportSearchBean lineBean) {
		
		Map<String,Object> params=new HashMap<String,Object>();
		//String countsql="select count(t1.id) from line_carrier_view t1"+whereSql(lineBean,params);
		String hql="select count(*) from LineCarrierView t1"+whereSql(lineBean, params);
		Long count=linetransportDao.count(hql, params);
		
		return count.intValue();
		
	}


	/**
	 * �ҵ���Ϣ-������Դ
	 */
	@Override
	public JSONArray getUserLinetransportResource(HttpSession session,
			PageUtil pageUtil) {
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Linetransport t where t.carrierId=:carrierId order by t.relDate desc";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("carrierId", carrierId);
		int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
		int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
		List<Linetransport> list=linetransportDao.find(hql, params,page,display);
		
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<list.size();i++){
			LinetransportBean lineBean=new LinetransportBean();
			BeanUtils.copyProperties(list.get(i), lineBean);
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lineBean);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
	}
	
	/**
	 * �ҵ���Ϣ-������Դ-�ܼ�¼����
	 */
	@Override
	public Integer getUserLinetransportResourceTotalRows(HttpSession session) {
		
		String carrierId=(String)session.getAttribute(Constant.USER_ID);
		Map<String,Object> params=new HashMap<String,Object>();
		String hql="select count(*) from Linetransport t where t.carrierId=:carrierId";
		params.put("carrierId", carrierId);
		
		Long count=linetransportDao.count(hql, params);
		
		return count.intValue();
	}


	/**
	 * ������Դ��ϸ 
	 */
	@Override
	public boolean updateLinetransport(Linetransport line,
			HttpServletRequest request,MultipartFile file) {
		
		String carrierId = (String) request.getSession().getAttribute(Constant.USER_ID);
		//�����ļ�
		String fileLocation=UploadFile.uploadFile(file, carrierId, "linetransport");

		Linetransport lineInstance = linetransportDao.get(Linetransport.class,line.getId());
		lineInstance.setLineName(line.getLineName());
		lineInstance.setStartPlace(line.getStartPlace());
		lineInstance.setEndPlace(line.getEndPlace());
		lineInstance.setOnWayTime(line.getOnWayTime());
		lineInstance.setType(line.getType());
		lineInstance.setRefPrice(line.getRefPrice());
		lineInstance.setRemarks(line.getRemarks());
		//�����ļ�λ�� 
		lineInstance.setDetailPrice(fileLocation);

		//����
		linetransportDao.update(lineInstance);
		return true;
		
		
	}


	/**
	 * ��ȡ��˾������Դ 
	 */
	@Override
	public String getCompanyLinetransport(String carrierId) {
		
		String hql="from Linetransport t where t.carrierId=:carrierId order by t.relDate desc";
		
		Map<String,Object> params=new HashMap<String,Object>();
		
		params.put("carrierId", carrierId);
		
		List<Linetransport> lineList=linetransportDao.find(hql, params);
		
		JSONArray jsonArray=new JSONArray();
		
		for(Linetransport line:lineList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(line);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray.toString();
	}
		
	
	
	

}
