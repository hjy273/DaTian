/*package cn.edu.bjtu.util;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

*//**
 * hql������
 * @author RussWest0
 *
 *//*
@Component
@Deprecated
public class HQLTool {
	@Deprecated
	public static HQL_POJO spellHql(HQL_POJO hql) {
		if (hql.flag == false) {
			hql.hql = " where ";
			hql.flag = true;
		} else {
			hql.hql = " and ";

		}
		return hql;
	}
	
	*//**
	 * �����ܼ�¼��
	 * 
	 * @param hql
	 * @return
	 *//*
	@Deprecated
	public int getTotalRows(String hql) {
		int count = 0;
		List list = ht.find("select count(*) " + hql);
		if (list != null)
			count = ((Number) list.get(0)).intValue();
		return count;
	}
	@Deprecated
	public List getQueryList(String hql,int page,int pageSize)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql); // ����hql���
		query.setFirstResult((page - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();
		session.close();
		
		return list;
	}
	@Deprecated
	public List getQueryListSubAccount(String sql)
	{
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(sql); // ����hql���
		List list = query.list();
		session.close();
		
		return list;
	}
	@Deprecated
	public static String spellHql2(String hql,String[] paramList,String[] valueList)
	{
		HQL_POJO hqlobj=new HQL_POJO();
		//hqlobj.hql="from LineCarrierView ";//��仯
		hqlobj.hql=hql;
		for(int i=0;i<paramList.length;i++)
		{
			if(!(valueList[i].equals("All")))//Ҫ�ǵ���all��˵����Ĭ�ϵģ�����д��where�Ӿ�
			{
				hqlobj.hql+= HQLTool.spellHql(hqlobj).hql;
				hqlobj.hql+=paramList[i]+"='"+valueList[i]+ "' ";
			}
		}
		return hqlobj.hql;
	}

	

}
*/