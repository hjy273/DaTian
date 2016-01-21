package cn.edu.bjtu.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		// �ڽ���DAO����ǰ��ͨ�������Ļ����������������Դ������  
		  return DataSourceContextHolder.getDataSourceType(); 
	}

}
