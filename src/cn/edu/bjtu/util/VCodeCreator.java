package cn.edu.bjtu.util;
/**
 * ��֤�����ɹ���
 * @author iver
 * @date   2016��1��26�� ����11:56:09
 */
public class VCodeCreator {

	/**
	 * �������һ����֤��
	 * @return
	 */
	public static String getVCode(){
		return (int)(Math.random() * 10000)+"";
	}
	
}
