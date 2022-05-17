package quanlyvattu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DataSourceIntercetor extends HandlerInterceptorAdapter {

	// Request:

	// /publisher/list
	// /advertiser/list
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String contextPath = request.getContextPath();

		// /SpringMVCMultiDS/publisher
		String prefixCN1 = contextPath + "/chinhanh";

		// /SpringMVCMultiDS/advertiser
		String prefixCT1 = contextPath + "/congty";

		String prefixU1 = contextPath + "/user";
		
		
		// /SpringMVCMultiDS/publisher/dashboard
		// /SpringMVCMultiDS/advertiser/dashboard

		String uri = request.getRequestURI();
		System.out.println("URI:" + uri);

		if (uri.indexOf(prefixCN1)!=-1) {
			request.setAttribute("keyDS", "CN1_CN_DS");
		}

		else if (uri.indexOf(prefixCT1)!=-1) {
			request.setAttribute("keyDS", "CN1_CT_DS");
		}

		else if (uri.indexOf(prefixU1)!=-1) {
			request.setAttribute("keyDS", "CN1_U_DS");
		}
		return true;
	}

}