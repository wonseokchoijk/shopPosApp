package service;

import java.sql.Date;
import java.sql.SQLException;

import bean.GoodsListBean;
import dao.GoodsListDao;

public class SuibModifyService {
	public GoodsListBean getGoodsDetail(long id) throws SQLException {
		GoodsListBean bean = null;

		GoodsListDao dao = new GoodsListDao();

		bean = dao.getGoodsInfoWithId(id, null, null);

		return bean;
	}

	public void updateSuib(GoodsListBean bean) throws SQLException {
		Date now = new Date(System.currentTimeMillis());
		GoodsListDao dao = new GoodsListDao();
		bean.setUpdated(now);
		dao.updateSuib(bean);
	}

	public void deleteGoods(Long id) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		GoodsListDao dao = new GoodsListDao();
		dao.deleteGoods(id, updated);
	}
}
