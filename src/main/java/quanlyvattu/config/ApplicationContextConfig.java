package quanlyvattu.config;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import quanlyvattu.routing.MyRoutingDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("quanlyvattu.*")

@EnableTransactionManagement

// Load to Environment.
@PropertySources({ @PropertySource("classpath:ds/datasource-cfg.properties") })

public class ApplicationContextConfig {

	// Lưu trữ các giá thuộc tính load bởi @PropertySource.
	@Autowired
	private Environment env;

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/spring-views/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	// Returns Routing DataSource (MyRoutingDataSource)
	@Autowired
	@Bean(name = "dataSource")
	public DataSource getDataSource() {

		System.out.println("## Create DataSource from dataSource1 & dataSource2");

		MyRoutingDataSource dataSource = new MyRoutingDataSource();

		Map<Object, Object> dsMap = new HashMap<Object, Object>();
		/*dsMap.put("PUBLISHER_DS", dataSource1);
		dsMap.put("ADVERTISER_DS", dataSource2);*/
		
		
		try {
			dsMap.put("CN1_CN_DS", getDataSource1());
			dsMap.put("CN1_CT_DS", getDataSource2());
			dsMap.put("CN1_U_DS",getDataSource3());
			dsMap.put("CN2_CN_DS", getDataSource4());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("## loi put ds");
		}
		
		dataSource.setTargetDataSources(dsMap);

		return dataSource;
	}

	@Bean(name = "dataSource1")
	public DataSource getDataSource1() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver1"));
		dataSource.setUrl(env.getProperty("ds.url1"));
		dataSource.setUsername(env.getProperty("ds.username1"));
		dataSource.setPassword(env.getProperty("ds.password1"));

		System.out.println("## getDataSource1: " + dataSource);
		return dataSource;
	}

	@Bean(name = "dataSource2")
	public DataSource getDataSource2() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver2"));
		dataSource.setUrl(env.getProperty("ds.url2"));
		dataSource.setUsername(env.getProperty("ds.username2"));
		dataSource.setPassword(env.getProperty("ds.password2"));

		System.out.println("## getDataSource2: " + dataSource);

		return dataSource;
	}
	
	@Bean(name = "dataSource3")
	public DataSource getDataSource3() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver3"));
		dataSource.setUrl(env.getProperty("ds.url3"));
		dataSource.setUsername(env.getProperty("ds.username3"));
		dataSource.setPassword(env.getProperty("ds.password3"));

		System.out.println("## getDataSource3: " + dataSource);

		return dataSource;
	}

	@Bean(name = "dataSource4")
	public DataSource getDataSource4() throws SQLException {
		BasicDataSource dataSource = new BasicDataSource();

		// See: datasouce-cfg.properties
		dataSource.setDriverClassName(env.getProperty("ds.database-driver4"));
		dataSource.setUrl(env.getProperty("ds.url4"));
		dataSource.setUsername(env.getProperty("ds.username4"));
		dataSource.setPassword(env.getProperty("ds.password4"));

		System.out.println("## getDataSource4: " + dataSource);

		return dataSource;
	}
	@Autowired
	@Bean(name = "transactionManager")
	public DataSourceTransactionManager getTransactionManager(DataSource dataSource) {
		DataSourceTransactionManager txManager = new DataSourceTransactionManager();

		txManager.setDataSource(dataSource);

		return txManager;
	}

}