package service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.sql.Date;
import bean.ColorMstBean;
import dao.ColorMstDao;

public class AddColorService {

	public void addColor(String name) throws SQLException {
		Date now = new Date(System.currentTimeMillis());

		ColorMstDao dao = new ColorMstDao();
		Long id = dao.getIdWithName(name);

		if (id != null) {
			throw new InvalidParameterException("이미 등록되어 있는 상품 색상입니다.");
		}
		ColorMstDao dao2 = new ColorMstDao();
		ColorMstBean bean = new ColorMstBean();
		bean.setName(name);
		bean.setUpdated(now);
		bean.setInserted(now);

		dao2.insertColor(bean);
	}
}
