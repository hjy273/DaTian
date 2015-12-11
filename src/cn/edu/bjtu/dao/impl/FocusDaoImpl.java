package cn.edu.bjtu.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import cn.edu.bjtu.dao.BaseDao;
import cn.edu.bjtu.dao.FocusDao;

import cn.edu.bjtu.vo.Address;
import cn.edu.bjtu.vo.Focus;
@Repository
public class FocusDaoImpl extends BaseDaoImpl<Focus> implements FocusDao{
	
	/**
	 * �����Ƿ��ȡ����ע
	 */
	@Override
	public List getFocusJudgement(String clientId, String focusType, String focusId) {
		
		return this.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"' and focusId='"+focusId+"'");
	}

	@Override
	/**
	 * ɾ����ע��Ϣ
	 */
	public boolean deleteFocus(String id) {
		
		Focus focus = this.get(Focus.class, id);
		 this.delete(focus);
		 return true;
	}
	
	@Override
	public List getFocusList(String clientId,String focusType) {
		
		if(focusType != "")
			return this.find("from Focus where clientId='"+clientId+"' and focusType='"+focusType+"'");
		else
			return this.find("from Focus where clientId='"+clientId+"'");
	}
	

}
