package cn.edu.bjtu.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFile {
	/**
	 * �����ļ�,file Ϊ�ļ�λ��
	 */
	public static void downloadFile(String file, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			File tempFile = new File(file.trim());
			String fileName = tempFile.getName();
			InputStream is = new FileInputStream(file);
			response.reset(); // ��Ҫ�����response�еĻ�����Ϣ
			response.setHeader("Content-Disposition", "attachment; filename="
					+ java.net.URLEncoder.encode(fileName, "UTF-8"));
			javax.servlet.ServletOutputStream out = response.getOutputStream();
			byte[] content = new byte[1024];
			int length = 0;
			while ((length = is.read(content)) != -1) {
				out.write(content, 0, length);
			}
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
