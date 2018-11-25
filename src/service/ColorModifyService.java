package service;

import java.sql.Date;
import java.sql.SQLException;
import dao.ColorMstDao;
import dao.GoodsListDao;
import bean.ColorMstBean;

public class ColorModifyService {
	public void updateColor(ColorMstBean bean) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		bean.setUpdated(updated);
		ColorMstDao dao = new ColorMstDao();
		dao.updateColor(bean);
	}

	public void deleteColor(Long id) throws SQLException {
		Date updated = new Date(System.currentTimeMillis());
		GoodsListDao goodsListDao = new GoodsListDao();
		goodsListDao.deleteGoods(id, updated);

		ColorMstDao colorMstDao = new ColorMstDao();
		colorMstDao.deleteColor(id);
	}
}
