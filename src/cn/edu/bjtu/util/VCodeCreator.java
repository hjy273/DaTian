package cn.edu.bjtu.util;
/**
 * ��֤�����ɹ���
 * @author iver
 * @date   2016��1��26�� ����11:56:09
 */
public class VCodeCreator {

	/**
	 * �������һ��4λ������֤��
	 * @return
	 */
	public static String getVCode(){
		int vcode=(int)(Math.random() * 10000);
		
		//��֤������λ�����
		return vcode<1000?vcode+1000+"":vcode+"";
	}
	
}
