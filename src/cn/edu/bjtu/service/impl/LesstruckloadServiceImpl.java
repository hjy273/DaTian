package cn.edu.bjtu.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.bjtu.bean.search.TruckBean;
import cn.edu.bjtu.dao.TruckDao;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.service.LesstruckloadService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.PageUtil;

@Transactional
@Service("LesstruckloadServiceImpl")
public class LesstruckloadServiceImpl implements LesstruckloadService {
		@Autowired
		TruckDao truckDao;	
		@Autowired
		FocusService focusService;
	
		/**
		 * ������Դ��ɸѡ�㵣
		 */
		@Override
		public JSONArray getSelectedLesstruckloadNew(TruckBean truckBean,PageUtil pageUtil, HttpSession session) {
			String userId=(String)session.getAttribute(Constant.USER_ID);
			Map<String,Object> params=new HashMap<String,Object>();
				String sql = "select t1.id,"
					+ "t1.startCity,"
					+ "t1.endCity,"
					+ "t1.carrierId,"
					+ "t1.onwayTime,"
					+ "t1.offerReturn,"
					+ "t1.stanPrice1,"
					+ "t1.stanPrice2,"
					+ "t1.relDate,"
					+ "t3.status "
					+ " from truck t1 "
					+ "left join ("
					+ "select * from focus t2 ";
					
			if(userId!=null){//�����ǰ���û���¼�������м����û���Ϣ
				sql+=" where t2.focusType='lesstruckload' and t2.clientId=:clientId ";
				params.put("clientId", userId);
			}else{
				sql+=" where t2.focusType='lesstruckload' and t2.clientId='' ";
			}
			sql+=") t3 on t1.id=t3.focusId ";
			String wheresql=whereSql(truckBean,params);
			sql+=wheresql+" order by t1.relDate desc";
			
			JSONArray jsonArray = new JSONArray();
			int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
			List<Object[]> objectList=truckDao.findBySql(sql, params,page,display);
			
			List<TruckBean> lesstruckloadList=new ArrayList<TruckBean>();
			for(Iterator<Object[]> it=objectList.iterator();it.hasNext();){
				TruckBean truckbean1=new TruckBean();
				Object[] obj=it.next();
				truckbean1.setId((String)obj[0]);
				truckbean1.setStartCity((String)obj[1]);
				truckbean1.setEndCity((String)obj[2]);
				truckbean1.setCarrierId((String)obj[3]);
				truckbean1.setOnwayTime((String)obj[4]);
				truckbean1.setOfferReturn((String)obj[5]);
				truckbean1.setStanPrice1((Float)obj[6]);
				truckbean1.setStanPrice2((Float)obj[7]);
				truckbean1.setRelDate((Date)obj[8]);
				truckbean1.setResourceType((String)obj[9]);
				if((truckbean1.getResourceType()).equals("�㵣")){
				     lesstruckloadList.add(truckbean1);
				}
			}
			
			for(int i=0;i<lesstruckloadList.size();i++){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(lesstruckloadList.get(i));
				jsonArray.add(jsonObject);
			}
			return jsonArray;
		}

		/**
		 * where sql
		 * @param truckBean
		 * @param params
		 * @return
		 */
		private String whereSql(TruckBean truckBean,Map<String,Object> params){
			String wheresql=" where 1=1 ";
			if(truckBean.getStartCity()!=null && !truckBean.getStartCity().trim().equals("���Ļ�ƴ��")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("ȫ��")){
				wheresql+=" and t1.startCity=:startCity ";
				params.put("startCity", truckBean.getStartCity());
			}
			if(truckBean.getEndCity()!=null && !truckBean.getEndCity().trim().equals("���Ļ�ƴ��")&&!truckBean.getStartCity().trim().equals("")&&!truckBean.getStartCity().trim().equals("ȫ��")){
				wheresql+=" and t1.endPlace=:endCity ";
				params.put("endPlace", truckBean.getEndCity());
			}
/*			if(carBean.getCarBase()!=null && !carBean.getCarBase().equals("") && !carBean.getCarBase().equals("All")){
				wheresql+=" and t1.carBase=:carBase ";
				params.put("carBase", carBean.getCarBase());
			}*/
			if(truckBean.getOnwayTime()!=null && !truckBean.getOnwayTime().trim().equals("All") && !truckBean.getOnwayTime().trim().equals("")){
				String onwayTime=truckBean.getOnwayTime();
				if (onwayTime.equals("24Сʱ����")) {
					wheresql+=" and t1.onwayTime <= 24";
				}
				if (onwayTime.equals("48Сʱ����")) {
					wheresql+="  and t1.onwayTime >= 24 and t1.onwayTime <= 48 ";
				}
				if (onwayTime.equals("72Сʱ����")) {
					wheresql+=" and t1.onwayTime >=48 and t1.onwayTime <= 72";
				}
			}
			if(truckBean.getOfferReturn()!=null && !truckBean.getOfferReturn().trim().equals("All")&& !truckBean.getOfferReturn().trim().equals("")){
				
				String offerReturn=truckBean.getOfferReturn();
				if (offerReturn.equals("�ṩ�س�")) {
					wheresql+=" and t1.offerReturn= '��'";
				}
				if (offerReturn.equals("���ṩ�س�")) {
					wheresql+=" and t1.offerReturn='��' ";
				}
			}
			
			return wheresql;
		}
		
		
		
	
		/**
		 * �ַ���תΪ��������
		 * @param str
		 * @return
		 */
		private static Date stringToDate(String str) {  
	        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
	        Date date = null;  
	        try {  
	            // Fri Feb 24 00:00:00 CST 2012  
	            date = format.parse(str);   
	        } catch (ParseException e) {  
	            e.printStackTrace();  
	        }  
	        // 2012-02-24  
	        date = java.sql.Date.valueOf(str);  
	                                              
	        return date;  
			} 
		

		/**
		 * ������Դ��-�㵣ɸѡ��¼������
		 */
		@Override
		public Integer getSelectedLesstruckloadTotalRows(TruckBean truckBean) {
			
			Map<String,Object> params=new HashMap<String,Object>();
			String hql="select count(*) from CarCarrierView t1"+whereSql(truckBean, params);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
		}


		
		/**
		 * �ҵ���Ϣ-�㵣��Ϣ-�ܼ�¼����(��̨��δ�޸�)
		 *//*
		@Override
		public Integer getLesstruckloadResourceTotalRows(HttpSession session) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			String hql="select count(*) from Carinfo t where t.carrierId=:carrierId";
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			Long count=truckDao.count(hql, params);
			
			return count.intValue();
			
		}

		*//**
		 * �ҵ���Ϣ-�㵣��Ϣ����̨��δ�޸ģ�
		 *//*
		@Override
		public JSONArray getUserCarResource(HttpSession session,PageUtil pageUtil) {
			String carrierId=(String)session.getAttribute(Constant.USER_ID);
			String hql="from Carinfo t where t.carrierId=:carrierId order by t.relDate desc";
			Map<String,Object> params=new HashMap<String,Object>();
			params.put("carrierId", carrierId);
			int page=pageUtil.getCurrentPage()==0?1:pageUtil.getCurrentPage();
			int display=pageUtil.getDisplay()==0?10:pageUtil.getDisplay();
			List<Carinfo> carList=carDao.find(hql, params,page,display);
			JSONArray jsonArray=new JSONArray();
			for(Carinfo car:carList){
				JSONObject jsonObject=(JSONObject)JSONObject.toJSON(car);
				jsonArray.add(jsonObject);
			}
			
			return jsonArray;
		}
*/
/*		
		 * ��ȡ��˾���� ��Դ
		 * @see cn.edu.bjtu.service.CarService#getCompanyCarAjax(java.lang.String)
		 
		@Override
		public String getCompanyCarAjax(String carrierId) {
			String hql = "from Carinfo t where t.carrierId=:carrierId order by t.relDate desc";

			Map<String, Object> params = new HashMap<String, Object>();

			params.put("carrierId", carrierId);

			List<Carinfo> carList = carDao.find(hql, params);

			JSONArray jsonArray = new JSONArray();

			for (Carinfo car : carList) {
				JSONObject jsonObject = (JSONObject) JSONObject.toJSON(car);
				jsonArray.add(jsonObject);
			}

			return jsonArray.toString();
		}*/

	}



		
