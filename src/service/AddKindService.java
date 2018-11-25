package service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.sql.Date;
import dao.KindMstDao;
import bean.KindMstBean;

public class AddKindService {

	public void addKind(String name) throws SQLException {
		Date now = new Date(System.currentTimeMillis());

		KindMstDao dao = new KindMstDao();
		Long id = dao.getIdWithName(name);

		if (id != null) {
			throw new InvalidParameterException("이미 등록되어 있는 상품 종류입니다.");
		}
		KindMstDao dao2 = new KindMstDao();
		KindMstBean bean = new KindMstBean();
		bean.setName(name);
		bean.setUpdated(now);
		bean.setInserted(now);

		dao2.insertKind(bean);
	}
}
