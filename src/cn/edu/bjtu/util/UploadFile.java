package cn.edu.bjtu.util;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

/**
 * �ļ��ϴ�
 * @author RussWest0
 * @date   2015��7��5�� ����2:51:20
 */
public class UploadFile {
	
	/**
	 * �����ļ��������ļ��ľ���·��
	 * @param file �ļ�
	 * @param userId �û�id
	 * @param fileType �ļ�����
	 * @return
	 */
	public static String uploadFile(MultipartFile file,String userId,String fileType){
		String path = "";
		String fileName = "";
		String fileLocation ="";
		
		if ("linetransport".equals(fileType)) {
			path = UploadPath.getLinetransportPath();
		} else if ("cityline".equals(fileType)) {
			path = UploadPath.getCitylinePath();
		} else if ("cargo".equals(fileType)) {
			path = UploadPath.getGoodsPath();
		} else if ("warehouse".equals(fileType)) {
			path = UploadPath.getWarehousePath();
		} else if ("businessClient".equals(fileType)) {
			path = UploadPath.getClientPath();
		} else if ("contract".equals(fileType)) {
			path = UploadPath.getContractPath();
		} else if ("driver".equals(fileType)) {
			path = UploadPath.getDriverPath();
		} else if ("companyCertificate".equals(fileType)) {
			path = UploadPath.getCompanyCertificatePath();
		} else if ("signBill".equals(fileType)) {
			path = UploadPath.getSignBillPath();
		} else if ("response".equals(fileType)) {
			path = UploadPath.getResponsePath();
		} else if ("complaint".equals(fileType)) {
			path = UploadPath.getComplaintPath();
		} else if("fulltruckload".equals(fileType)){
			path = UploadPath.getFullTruckLoadPath();
		} else if("airline".equals(fileType)){
			path = UploadPath.getAirLinePath();
		}
		
		if (file.getSize() != 0)// ���ϴ��ļ������
		{
			fileName = file.getOriginalFilename();
			fileName = userId + "_" + fileName;// �ļ���
			File targetFile = new File(path, fileName);
			try { // ���� �ļ�
				file.transferTo(targetFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
			fileLocation = path + "//" + fileName;
			if ("signBill".equals(fileType)){
				return fileName;
			}else
				return fileLocation;
		
	}

}
