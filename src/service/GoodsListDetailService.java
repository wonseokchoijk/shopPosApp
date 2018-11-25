package service;

import java.sql.Date;
import java.sql.SQLException;
import dao.ColorMstDao;
import dao.GoodsListDao;
import dao.KindMstDao;
import bean.GoodsListBean;

public class GoodsListDetailService {

	public GoodsListBean getGoodsDetail(long id) throws SQLException {
		GoodsListBean bean = null;

		GoodsListDao dao = new GoodsListDao();

		bean = dao.getGoodsInfoWithId(id, null, null);

		return bean;
	}

	public void updateGoods(GoodsListBean bean) throws SQLException {
		Date now = new Date(System.currentTimeMillis());

		KindMstDao kindDao = new KindMstDao();
		Long kind = kindDao.getIdWithName(bean.getKind());
		ColorMstDao colorDao = new ColorMstDao();
		Long color = colorDao.getIdWithName(bean.getColor());
		bean.setUpdated(now);

		GoodsListDao dao = new GoodsListDao();
		dao.updateGoods(bean, kind, color);
	}

	public void deleteGoods(Long id) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		GoodsListDao dao = new GoodsListDao();
		dao.deleteGoods(id, updated);
	}
}
