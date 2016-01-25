package cn.edu.bjtu.controller.sms;

import java.rmi.RemoteException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.b2m.eucp.example.SingletonClient;
/**
 * ���Žӿ���صĿ�����
 * @author iver
 * @date   2016��1��25�� ����2:13:33
 */
@Controller
public class SMSController {
	
	ResourceBundle bundle=PropertyResourceBundle.getBundle("config");
	public final String password=bundle.getString("password");
	/**
	 * ע�����к�
	 */
	@RequestMapping("/regSerialSnAjax")
	@ResponseBody
	public String regSmsSerialNo(){
		try {
			int i = SingletonClient.getClient().registEx(password);
			System.out.println("testTegistEx:" + i);
			return "testTegistEx:" + i;
		} catch (RemoteException e) {
			e.printStackTrace();
			return "error!!!";
		}
	}
	/**
	 * ע����ҵ��Ϣ
	 */
	@RequestMapping("regEnterpriseInfoAjax")
	@ResponseBody
	public String regEnterpriseInfo(){
		try {

			/**
			 * ��ҵ��ϸ��Ϣע�� registDetailInfo(String eName, String linkMan, String
			 * phoneNum,String mobile, String email, String fax, String address,String
			 * postcode)
			 *  1��eName ��ҵ����(���60�ֽ�)
			 *   2��linkMan ��ϵ������(���20�ֽ�) 
			 *   3��phoneNum	 * ��ϵ�绰(���20�ֽ�) 
			 *   4��mobile ��ϵ�ֻ�(���15�ֽ�) 
			 *   5��email �����ʼ�(���60�ֽ�) 
			 *   6��fax	 * ��ϵ����(���20�ֽ�) 
			 * 7��address ��˾��ַ(���60�ֽ�) 
			 * 8��postcode ��������(���6�ֽ�)
			 * 9�����ϲ�����Ϣ��������д��ÿ������������Ϊ��
			 */
			int a = SingletonClient.getClient().registDetailInfo(
					bundle.getString("eName"), 
					bundle.getString("linkMan"),  
					bundle.getString("phoneNum"), 
					bundle.getString("mobile"),  
					bundle.getString("email"),  
					bundle.getString("fax"),  
					bundle.getString("address"),  
					bundle.getString("postcode"));
			System.out.println("testRegistDetailInfo:" + a);
			return "testRegistDetailInfo:" + a;
		} catch (Exception e) {
			e.printStackTrace();
			return "error!!!";
		}
	}
	/**
	 * ���ͼ�ʱ����
	 */
	@RequestMapping("sendSMSAjax")
	@ResponseBody
	public String sendSMS(String phone,String smsContent){
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "�����Ｏ����Դ��Ӧ������ƽ̨��"+smsContent, "",5);// ����չ��
			System.out.println("testSendSMS=====" + i);
			return "testSendSMS=====" + i;
		} catch (Exception e) {
			e.printStackTrace();
			return "error!!!";
		}
	}
	/**
	 * ��ȡ�������
	 */
	@RequestMapping("getSMSBalanceAjax")
	@ResponseBody
	public String getSMSBalance(){
		try {
			Double a = SingletonClient.getClient().getBalance();
			System.out.println("testGetBalance:" + a);
			return  a.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return "error!!!";
		}
	}
	
	/**
	 * ��׿�˻�ȡ��֤��ӿ�
	 */
	@RequestMapping("sendVodeToPhoneAjax")
	public void androidSendSMSByPhoneNum(String phone){
		try {
			int i = SingletonClient.getClient().sendSMS(new String[] { phone }, "�����Ｏ����Դ��Ӧ������ƽ̨�����ã�������֤��ΪXXXX", "",5);// ����չ��
			System.out.println("testSendSMS=====" + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
