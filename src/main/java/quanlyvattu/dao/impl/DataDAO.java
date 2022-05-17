package quanlyvattu.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDAO extends JdbcDaoSupport {

	@Autowired
	public DataDAO(DataSource dataSource) {
		this.setDataSource(dataSource);
	}

	public List<String> queryPublishers() {
		String sql = "Select ten from nhanvien";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

	public List<String> queryAdvertisers() {
		String sql = "Select ten from nhanvien";

		List<String> list = this.getJdbcTemplate().queryForList(sql, String.class);
		return list;
	}

}