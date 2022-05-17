package quanlyvattu.routing;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

// Đây là một DataSource.
public class MyRoutingDataSource extends AbstractRoutingDataSource {
	
	@Autowired
	ServletContext session;
	@Override
	protected Object determineCurrentLookupKey() {

		
		String keyDS = (String) session.getAttribute("keyDS");

		System.out.println("KeyDS=" + keyDS);

		if (keyDS == null) {
			System.out.print("khong hop le");
			keyDS = "CN1_CN_DS";
			
		}

		return keyDS;
	}

}