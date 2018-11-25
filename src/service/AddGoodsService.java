package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import common.Consts;

import dao.ColorMstDao;
import dao.GoodsListDao;
import dao.KindMstDao;
import bean.GoodsListBean;

public class AddGoodsService {
	private ArrayList<GoodsListBean> addList = new ArrayList<GoodsListBean>();

	public void addAllList(ArrayList<GoodsListBean> list) {
		addList.addAll(list);
	}

	public void add(GoodsListBean bean) {
		addList.add(bean);
	}

	public ArrayList<GoodsListBean> getList() {
		return this.addList;
	}

	public void insertGoodsToDB() throws SQLException {

		Date now = new Date(System.currentTimeMillis());
		for (GoodsListBean bean : this.addList) {

			KindMstDao kindDao = new KindMstDao();
			Long kind = kindDao.getIdWithName(bean.getKind());
			ColorMstDao colorDao = new ColorMstDao();
			Long color = colorDao.getIdWithName(bean.getColor());

			bean.setSellFlg('0');
			bean.setDelFlg('0');
			if (bean.getBuyDate() == null) {
				bean.setBuyDate(now);
			}
			bean.setUpdated(now);
			bean.setInserted(now);

			GoodsListDao dao = new GoodsListDao();
			dao.insertData(bean, Consts.BUNRYU_GOODS, kind, color);
		}
	}
}
