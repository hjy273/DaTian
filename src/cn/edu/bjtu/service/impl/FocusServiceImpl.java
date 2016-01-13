package cn.edu.bjtu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bjtu.bean.page.FocusBean;
import cn.edu.bjtu.dao.CarDao;
import cn.edu.bjtu.dao.CitylineDao;
import cn.edu.bjtu.dao.CompanyDao;
import cn.edu.bjtu.dao.FocusDao;
import cn.edu.bjtu.dao.GoodsInfoDao;
import cn.edu.bjtu.dao.LinetransportDao;
import cn.edu.bjtu.dao.WarehouseDao;
import cn.edu.bjtu.dao.impl.BaseDaoImpl;
import cn.edu.bjtu.service.FocusService;
import cn.edu.bjtu.util.Constant;
import cn.edu.bjtu.util.IdCreator;
import cn.edu.bjtu.vo.Carinfo;
import cn.edu.bjtu.vo.Carrierinfo;
import cn.edu.bjtu.vo.Cityline;
import cn.edu.bjtu.vo.Focus;
import cn.edu.bjtu.vo.Goodsform;
import cn.edu.bjtu.vo.Linetransport;
import cn.edu.bjtu.vo.Warehouse;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class FocusServiceImpl extends BaseDaoImpl<Focus> implements FocusService {
	
	@Autowired
	FocusDao focous;
	@Autowired
	FocusDao focusDao;
	@Autowired
	LinetransportDao linetransportDao;
	@Autowired
	CitylineDao citylineDao;
	@Autowired
	WarehouseDao warehouseDao;
	@Autowired
	CarDao carDao;
	@Autowired
	GoodsInfoDao goodsinfoDao;
	@Autowired
	CompanyDao companyDao;
	

	@Override
	/**
	  * ��ӹ�ע
	  */
	public boolean insertFocus(String clientId, String foucsType, String foucsId){
		Focus focus=new Focus();
		focus.setId(IdCreator.createFocusId());
		focus.setClientId(clientId);
		focus.setFocusType(foucsType);
		focus.setFocusId(foucsId);
		focus.setStatus("��Ч");
		focusDao.save(focus);
		return true;
	}

	@Override
	/**
	  * �ж�ĳ����Ϣ�Ƿ��ѱ���ע 
	  */
	public List getFocusJudgement(String clientId, String focusType,
			String focusId) {
		
		return focusDao.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
	}

	@Override
	/**
	  * ɾ����ע 
	  */
	public boolean deleteFocus(String id){
		Focus focus = this.get(Focus.class, id);
		 this.delete(focus);
		 return true;
	}
	@Override
	/**
	 * ��ע�б��ȡ
	 */
	public List getFocusList(String clientId,String focusType) {
		
		if(focusType != "")
			return this.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"'");
		else
			return this.find("from Focus where clientId='"+clientId+"'");
	}
	
	
	/**
	 * ������ע
	 */
	@Override
	public JSONArray searchFocus(FocusBean bean, HttpSession session) {
		
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Focus t where t.clientId=:clientId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Focus> focusList=focusDao.find(hql, params);
		List<FocusBean> focusBeanList=new ArrayList<FocusBean>();
		String search_content=bean.getSearch_content();
//		if(!"".equals(search_content) && search_content!=null){
			for(Focus focus:focusList){
				FocusBean focusBean=new FocusBean();
				if("linetransport".equals(focus.getFocusType())){
					Linetransport line=linetransportDao.get(Linetransport.class, focus.getFocusId());
					//if("".equals(search_content) || (!"".equals(search_content) && line.getLineName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setStartPlace(line.getStartPlace());
						focusBean.setEndPlace(line.getEndPlace());
						focusBean.setLineName(line.getLineName());
						focusBean.setRelDate(line.getRelDate());
						focusBean.setResourceId(line.getId());
						focusBean.setCarrierId(line.getCarrierId());
						//����ɸѡ����
						if("".equals(search_content) || (!"".equals(search_content) && 
								focusBean.getStartPlace().contains(search_content) ||
								focusBean.getEndPlace().contains(search_content))){
							focusBeanList.add(focusBean);
						//}
					}
				}else if("cityline".equals(focus.getFocusType())){
					Cityline cityline=citylineDao.get(Cityline.class, focus.getFocusId());
					//if("".equals(search_content) || (!"".equals(search_content) && cityline.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setName(cityline.getName());
						focusBean.setRelDate(cityline.getRelDate());
						focusBean.setResourceId(cityline.getId());
						focusBean.setCarrierId(cityline.getCarrierId());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}
					//}
				}else if("car".equals(focus.getFocusType())){
					Carinfo car=carDao.get(Carinfo.class, focus.getFocusId());
				//	if("".equals(search_content) || (!"".equals(search_content) && car.getCarNum().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setCarNum(car.getCarNum());
						focusBean.setRelDate(car.getRelDate());
						focusBean.setResourceId(car.getId());
						focusBean.setCarrierId(car.getCarrierId());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getCarNum().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}

					//}
				}else if("company".equals(focus.getFocusType())){
					Carrierinfo company=companyDao.get(Carrierinfo.class, focus.getFocusId());
					//if("".equals(search_content) || (!"".equals(search_content) &&company.getCompanyName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setCompanyName(company.getCompanyName());
						focusBean.setRelDate(company.getRelDate());
						focusBean.setResourceId(company.getId());
						focusBean.setCarrierId(company.getId());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getCompanyName().contains(search_content))){
							focusBeanList.add(focusBean);
							
						}
					//}
				}else if("warehouse".equals(focus.getFocusType())){
					Warehouse warehouse=warehouseDao.get(Warehouse.class, focus.getFocusId());
					//if("".equals(search_content) || (!"".equals(search_content) && warehouse.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(warehouse.getRelDate());
						focusBean.setName(warehouse.getName());
						focusBean.setResourceId(warehouse.getId());
						focusBean.setCarrierId(warehouse.getCarrierId());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}
					//}
					
				}else if("goods".equals(focus.getFocusType())){
					Goodsform cargo=goodsinfoDao.get(Goodsform.class, focus.getFocusId());
					//if("".equals(search_content) || (!"".equals(search_content) && cargo.getName().contains(search_content))){
						focusBean.setId(focus.getId());
						focusBean.setStatus(focus.getStatus());
						focusBean.setFocusType(focus.getFocusType());
						focusBean.setRelDate(cargo.getRelDate());
						focusBean.setName(cargo.getName());
						focusBean.setResourceId(cargo.getId());
						
						//FIXME  //û������id
						//focusBean.setCarrierId(line.getCarrierId());
						if("".equals(search_content) || (!"".equals(search_content) && focusBean.getName().contains(search_content))){
							
							focusBeanList.add(focusBean);
						}
					//}
				}
//			}
		}
		
		//ת��jsonarray
		JSONArray jsonArray=new JSONArray();
		for(FocusBean fBean: focusBeanList){
			JSONObject jsonObject=(JSONObject)JSONObject.toJSON(fBean);
			jsonArray.add(jsonObject);
		}
		
		return jsonArray;
		
	}

	/**
	 * �ҵĹ�ע�ܼ�¼��
	 */
	@Override
	public Integer getUserFocusTotalRowsAjax(FocusBean bean,
			HttpSession session) {
		String userId=(String)session.getAttribute(Constant.USER_ID);
		String hql="from Focus t where t.clientId=:clientId ";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("clientId", userId);
		List<Focus> focusList=focusDao.find(hql, params);
		String search_content=bean.getSearch_content();
		
		int count=0;
		
			for(Focus focus:focusList){
				FocusBean focusBean=new FocusBean();
				if("linetransport".equals(focus.getFocusType())){
					Linetransport line=linetransportDao.get(Linetransport.class, focus.getFocusId());
						//����ɸѡ����
						if("".equals(search_content) || (!"".equals(search_content) && 
								line.getStartPlace().contains(search_content) ||
								line.getEndPlace().contains(search_content))){
							count++;
					}
				}else if("cityline".equals(focus.getFocusType())){
					Cityline cityline=citylineDao.get(Cityline.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && cityline.getName().contains(search_content))){
							count++;
						}
				}else if("car".equals(focus.getFocusType())){
					Carinfo car=carDao.get(Carinfo.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && car.getCarNum().contains(search_content))){
							
							count++;
						}
				}else if("company".equals(focus.getFocusType())){
					Carrierinfo company=companyDao.get(Carrierinfo.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && company.getCompanyName().contains(search_content))){
							count++;
							
						}
				}else if("warehouse".equals(focus.getFocusType())){
					Warehouse warehouse=warehouseDao.get(Warehouse.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && warehouse.getName().contains(search_content))){
							count++;
						}
					
				}else if("goods".equals(focus.getFocusType())){
					Goodsform cargo=goodsinfoDao.get(Goodsform.class, focus.getFocusId());
						if("".equals(search_content) || (!"".equals(search_content) && cargo.getName().contains(search_content))){
							count++;
						}
				}
		}
		
	return count;
	}

	/**
	 * ���ù�ע��ϢΪʧЧ״̬��idΪ��Դid
	 */
	@Override
	public boolean setInvalid(String id) {
		String hql="from Focus t where t.focusId=:focusId";
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("focusId", id);
		List<Focus> focusList=focusDao.find(hql, params);
		if(focusList !=null){
			for(Focus focus:focusList){
				/*focus.setStatus("ʧЧ");
				focusDao.update(focus);*/
				/**
				 * Ŀǰ���������
				 * ����Դɾ����ֱ�ӽ���ע���еĶ�Ӧ�ļ�¼Ҳɾ��
				 */
				focusDao.delete(focus);
			}

		}
				
		return true;
	}
	
	
	
	
	
}
