package service;

import java.sql.Date;
import java.sql.SQLException;

import bean.GoodsListBean;
import dao.GoodsListDao;

public class AddJichulService {
	public void insertJichul(GoodsListBean bean) throws SQLException {
		Date now = new Date(System.currentTimeMillis());

		bean.setSellFlg('0');
		bean.setDelFlg('0');
		if (bean.getBuyDate() == null) {
			bean.setBuyDate(now);
		}
		bean.setUpdated(now);
		bean.setInserted(now);

		GoodsListDao dao = new GoodsListDao();
		dao.insertData(bean, 2, null, null);
	}
}
