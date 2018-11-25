package service;

import java.sql.Date;
import java.sql.SQLException;
import bean.GoodsListBean;
import dao.GoodsListDao;

public class SellGoodsModifyService {
	public GoodsListBean getGoodsDetail(long id) throws SQLException {
		GoodsListBean bean = null;

		GoodsListDao dao = new GoodsListDao();

		bean = dao.getGoodsInfoWithId(id, null, null);

		return bean;
	}

	public void updateSellGoods(GoodsListBean bean) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		bean.setUpdated(updated);
		GoodsListDao dao = new GoodsListDao();
		dao.updateSellGoods(bean);
	}

	public void cancelSellGood(Long id) throws SQLException {
		GoodsListDao dao = new GoodsListDao();
		dao.cancelSellGoods(id);
	}
}
