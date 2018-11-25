package service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import common.Consts;

import dao.GoodsListDao;
import bean.GoodsListBean;

public class SellGoodsService {

	private ArrayList<GoodsListBean> sellGoodsList = new ArrayList<GoodsListBean>();

	public GoodsListBean getSellGoodsData(long id) throws SQLException {
		GoodsListDao dao = new GoodsListDao();
		GoodsListBean bean = dao.getGoodsInfoWithId(id, false, Consts.BUNRYU_GOODS);
		if (bean == null || bean.getId() == null) {
			throw new InvalidParameterException("해당 No.의 등록된 판매 상품이 없습니다.");
		}
		return bean;
	}

	public ArrayList<GoodsListBean> getSellGoodsList() {
		return this.sellGoodsList;
	}

	public void addSellGoodsData(GoodsListBean bean) {
		sellGoodsList.add(bean);
	}

	public boolean hasThisGoods(Long id) {
		for (GoodsListBean bean : sellGoodsList) {
			if (bean.getId().longValue() == id.longValue()) {
				return true;
			}
		}
		return false;
	}

	public void deleteThisGoods(Long id) {
		for (int i = 0 ; i < sellGoodsList.size(); i++) {
			GoodsListBean bean = sellGoodsList.get(i);
			if (bean.getId().longValue() == id.longValue()) {
				sellGoodsList.remove(i);
				return;
			}
		}
	}

	public void deleteAllThisGoods() {
		this.sellGoodsList.clear();
	}

	public int confirmSellGoods() throws SQLException {
		Date now = new Date(System.currentTimeMillis());
		// 갱신 후에 남을 데이터.
		ArrayList<GoodsListBean> afterConfirmList = new ArrayList<GoodsListBean>();

		for (GoodsListBean bean : this.sellGoodsList) {
			GoodsListDao dao = new GoodsListDao();
			if (bean.getSellDate() == null) {
				bean.setSellDate(now);
			}
			bean.setUpdated(now);
			try {
				dao.confirmSellGoods(bean);
			} catch(SQLException e) {
				afterConfirmList.add(bean);
			}
		}
		// 실패한 경우는 실패한 상품 정보들이 리스트에 남고, 성공하면 리스트에 하나도 안 남는다.
		this.sellGoodsList = afterConfirmList;
		// 실패건수를 반환.
		return afterConfirmList.size();
	}

	public long getTotalPrice() {
		long result = 0;
		for (GoodsListBean bean : this.sellGoodsList) {
			if (bean.getSellPrice() != null) {
				result += bean.getSellPrice();
			}
		}
		return result;
	}
}
