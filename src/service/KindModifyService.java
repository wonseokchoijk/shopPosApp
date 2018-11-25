package service;

import java.sql.Date;
import java.sql.SQLException;

import dao.GoodsListDao;
import dao.KindMstDao;

import bean.KindMstBean;

public class KindModifyService {
	public void updateKind(KindMstBean bean) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		bean.setUpdated(updated);
		KindMstDao dao = new KindMstDao();
		dao.updateKind(bean);
	}

	public void deleteKind(Long id) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		GoodsListDao goodsListDao = new GoodsListDao();
		goodsListDao.deleteGoods(id, updated);

		KindMstDao kindMstDao = new KindMstDao();
		kindMstDao.deleteKind(id);
	}
}
