package cn.edu.bjtu.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

/**
 * ��¼����
 * 
 * @author RussWest0
 * @date 2015��6��2�� ����8:36:01
 */
public class LoginFilter extends OncePerRequestFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		//System.out.println("���ڹ���login");
		// �����˵�uri
		String[] notFilter = new String[] { "login", "loginForm", "register","adminLogin" ,
				"js" ,"images", "css", "Focus", "focus", 
				"focusNum", "homepage", "linetransport", "footer", "cityline",
				"car", "warehouse", "company", "goodsform", "allcomplaint",
				"city","usercheck","goodsdetail","intro","driverconfirm","showcurrenttask","shownewtask","showfinishedtask","upload/TakeoverNumber","upload/CompleteNumber","upload/Location","location"
		};

		// �����uri
		String uri = request.getRequestURI();
		//�ոս�����ҳ�����
		if(uri.equals("/DaTian/")){
			filterChain.doFilter(request, response);
			return;
		}
		//Ajax������������� add by RussWest0 at 2015��6��12��,����12:00:40 
		if(uri.endsWith("Ajax")){
			filterChain.doFilter(request, response);
			return ;
		}
		
		// �Ƿ����,trueʱ���� false������
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// ���uri�а��������˵�uri���򲻽��й���
				doFilter = false;
				break;
			}
		}
		//δ��½ֱ�ӵ���ҵĹ�ע��Ҫ���� add by russwest at 2015��9��1��,����5:27:52 
		if(uri.indexOf("getallfocus") != -1){
			doFilter=true;
		}
		if (doFilter) {
			// ִ�й���
			// ��session�л�ȡ��¼��ʵ��
//			System.out.println(">>>>" + uri + ">>>>" + doFilter);
			Object obj = request.getSession().getAttribute(Constant.USER_NAME);
			if (null == obj) {
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//��ת����¼ҳ��
				response. sendRedirect("loginForm");
				return;
			} else {
				// ���session�д��ڵ�¼��ʵ�壬�����
				filterChain.doFilter(request, response);
			}
		} else {
			// �����ִ�й��ˣ������
			Object obj = request.getSession().getAttribute(Constant.USER_NAME);
			//System.out.println(request.getQueryString());
			if(request.getQueryString()!=null && request.getQueryString().indexOf("flag=1") != -1 && obj == null)//�û�δ��¼��������ʸ�����Ϣ
			{
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				//��ת����¼ҳ��
				response.sendRedirect("loginForm");
				return;
			}
			filterChain.doFilter(request, response);
		}
	}

}
