package cn.edu.bjtu.service.sms;

public interface SmsService {
	
	/**
	 * ������Ų��������ݿ⣨��־)
	 * @param phone �ֻ���
	 * @param smsContent ���͵Ķ�������
	 * @param type ���Ͷ��ŵ�����
	 * @param terminal ���Ͷ��ŵ���Դ����׿�˻���pc��
	 * @return
	 */
	public boolean log(String phone,String smsContent,String type,String terminal,int status);

}
