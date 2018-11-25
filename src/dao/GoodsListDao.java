package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import common.Consts;
import common.Utilities;
import bean.GoodsListBean;
import bean.PeriodTotalBean;

public class GoodsListDao extends AbstractDao {

	public GoodsListDao() throws SQLException {
		super();
	}

	/**
	 * ���� ������ǰ ����Ʈ �˻�
	 * @return ��ǰ ��������Ʈ
	 * @throws SQLException
	 */
	public ArrayList<GoodsListBean> getGoodsList(Integer bunryu, Character sellFlag, 
				String id, String[] nameArray, String kind, String color, String[] memoArray,
				String fromDateYear, String fromDateMonth, String fromDateDay,
				String toDateYear, String toDateMonth, String toDateDay
			) throws SQLException {

		Utilities util = new Utilities();
		ArrayList<GoodsListBean> result = new ArrayList<GoodsListBean>();

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT ");
			query.append("G.ID, ");
			query.append("G.BUNRYU, ");
			query.append("G.NAME AS NAME, ");
			query.append("K.NAME AS KIND, ");
			query.append("C.NAME AS COLOR, ");
			query.append("G.BUY_PRICE, ");
			query.append("G.SELL_HOPE_PRICE, ");
			query.append("G.SELL_PRICE, ");
			query.append("G.PLACE, ");
			query.append("G.BARCODE, ");
			query.append("G.MEMO, ");
			query.append("G.SELL_FLG, ");
			query.append("G.DEL_FLG, ");
			query.append("G.BUY_DATE, ");
			query.append("G.SELL_DATE, ");
			query.append("G.UPDATED, ");
			query.append("G.INSERTED ");
			query.append("FROM GOODS_LIST AS G ");
			query.append("LEFT JOIN ");
			query.append("COLOR_MST AS C ");
			query.append("ON ");
			query.append("G.COLOR = C.ID ");
			query.append("LEFT JOIN ");
			query.append("KIND_MST AS K ");
			query.append("ON ");
			query.append("G.KIND = K.ID ");
			query.append("WHERE ");
			query.append("G.DEL_FLG = '0' ");	// ���� �� �� ��.
			if (bunryu != null) {
				query.append("AND ");
				query.append("G.BUNRYU = " + bunryu + " ");	// �з� 1(��ǰ)�� ��츸 �˻�.
			}

			if (sellFlag != null) {
				query.append("AND ");
				query.append("G.SELL_FLG = '" + sellFlag +"' ");
			}
			
			if (! util.isEmpty(id)) {	// ID지정시 조건에 추가.
				query.append("AND ");
				query.append("G.ID = " + id + " ");
			}
			if (nameArray != null && nameArray.length > 0) {	// 상품명 지정시 조건에 추가.
				for (String name : nameArray) {
					query.append("AND ");
					query.append("G.NAME LIKE '%" + name + "%' ");
				}
			}
			if (! util.isEmpty(kind)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("K.NAME = '" + kind + "' ");
			}
			if (! util.isEmpty(color)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("C.NAME = '" + color + "' ");
			}
			if (memoArray !=null && memoArray.length > 0) {
				for (String memo : memoArray) {
					query.append("AND ");
					query.append("G.MEMO LIKE '%" + memo + "%' ");
				}
			}

			if (! util.isEmpty(fromDateYear) && ! util.isEmpty(fromDateMonth) && ! util.isEmpty(fromDateDay)) {
				query.append("AND ");
				query.append("G.BUY_DATE >= '" + fromDateYear + "-" + fromDateMonth + "-" + fromDateDay + " 00:00:00' ");
			}

			if (! util.isEmpty(toDateYear) && ! util.isEmpty(toDateMonth) && ! util.isEmpty(toDateDay)) {
				query.append("AND ");
				query.append("G.BUY_DATE <= '" + toDateYear + "-" + toDateMonth + "-" + toDateDay + " 23:59:59.99' ");
			}
			
			
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				GoodsListBean bean = new GoodsListBean();

				bean.setId(rs.getLong("ID"));
				bean.setBunryu(rs.getInt("BUNRYU"));
				bean.setName(rs.getString("NAME"));
				bean.setKind(rs.getString("KIND"));
				bean.setColor(rs.getString("COLOR"));

				if (rs.getObject("BUY_PRICE") != null) {
					bean.setBuyPrice(rs.getLong("BUY_PRICE"));
				}

				if (rs.getObject("SELL_HOPE_PRICE") != null) {
					bean.setSellHopePrice(rs.getLong("SELL_HOPE_PRICE"));
				}

				if (rs.getObject("SELL_PRICE") != null) {
					bean.setSellPrice(rs.getLong("SELL_PRICE"));
				}

				bean.setPlace(rs.getString("PLACE"));
				bean.setBarcode(rs.getString("BARCODE"));

				bean.setMemo(rs.getString("MEMO"));
				bean.setSellFlg(rs.getString("SELL_FLG").charAt(0));
				bean.setDelFlg(rs.getString("DEL_FLG").charAt(0));
				bean.setBuyDate(rs.getTimestamp("BUY_DATE") != null ? new Date(rs.getTimestamp("BUY_DATE").getTime()) : null);
				bean.setSellDate(rs.getTimestamp("SELL_DATE") != null ? new Date(rs.getTimestamp("SELL_DATE").getTime()) : null);
				bean.setUpdated(rs.getTimestamp("UPDATED") != null ? new Date(rs.getTimestamp("UPDATED").getTime()) : null);
				bean.setInserted(rs.getTimestamp("INSERTED") != null ? new Date(rs.getTimestamp("INSERTED").getTime()) : null);

				result.add(bean);
			}
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}

		return result;
	}

	// 이미 판매된 상품의 경우 sold가 true, 아직 판매 안된 상품의 경우 false
	public GoodsListBean getGoodsInfoWithId(long id, Boolean sold, Integer bunryu) throws SQLException {
		GoodsListBean bean = new GoodsListBean();

		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("G.ID, ");
		query.append("G.BUNRYU, ");
		query.append("G.NAME AS NAME, ");
		query.append("K.NAME AS KIND, ");
		query.append("C.NAME AS COLOR, ");
		query.append("G.BUY_PRICE, ");
		query.append("G.SELL_HOPE_PRICE, ");
		query.append("G.SELL_PRICE, ");
		query.append("G.PLACE, ");
		query.append("G.BARCODE, ");
		query.append("G.MEMO, ");
		query.append("G.SELL_FLG, ");
		query.append("G.DEL_FLG, ");
		query.append("G.BUY_DATE, ");
		query.append("G.SELL_DATE, ");
		query.append("G.UPDATED, ");
		query.append("G.INSERTED ");
		query.append("FROM GOODS_LIST AS G ");
		query.append("LEFT JOIN ");
		query.append("COLOR_MST AS C ");
		query.append("ON ");
		query.append("G.COLOR = C.ID ");
		query.append("LEFT JOIN ");
		query.append("KIND_MST AS K ");
		query.append("ON ");
		query.append("G.KIND = K.ID ");
		query.append("WHERE ");
		query.append("G.ID = " + id);
		query.append("AND ");
		query.append("G.DEL_FLG = '0'");
		
		if (bunryu != null) {
			query.append("AND ");
			query.append("G.BUNRYU = " + bunryu + " ");
		}
		if (sold == null) {
		} else if (sold) {  // 판매된 상품의 경우
			query.append("AND ");
			query.append("G.SELL_FLG = '1' ");
		} else {	// 아직 미판매된 상품의 경우
			query.append("AND ");
			query.append("G.SELL_FLG = '0' ");
		}

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {

				bean.setId(rs.getLong("ID"));
				bean.setBunryu(rs.getInt("BUNRYU"));
				bean.setName(rs.getString("NAME"));
				bean.setKind(rs.getString("KIND"));
				bean.setColor(rs.getString("COLOR"));

				if (rs.getObject("BUY_PRICE") != null) {
					bean.setBuyPrice(rs.getLong("BUY_PRICE"));
				}

				if (rs.getObject("SELL_HOPE_PRICE") != null) {
					bean.setSellHopePrice(rs.getLong("SELL_HOPE_PRICE"));
				}

				if (rs.getObject("SELL_PRICE") != null) {
					bean.setSellPrice(rs.getLong("SELL_PRICE"));
				}

				bean.setPlace(rs.getString("PLACE"));
				bean.setBarcode(rs.getString("BARCODE"));

				bean.setMemo(rs.getString("MEMO"));
				bean.setSellFlg(rs.getString("SELL_FLG").charAt(0));
				bean.setDelFlg(rs.getString("DEL_FLG").charAt(0));
				
				bean.setBuyDate(rs.getTimestamp("BUY_DATE") != null ? new Date(rs.getTimestamp("BUY_DATE").getTime()) : null);
				bean.setSellDate(rs.getTimestamp("SELL_DATE") != null ? new Date(rs.getTimestamp("SELL_DATE").getTime()) : null);
				bean.setUpdated(rs.getTimestamp("UPDATED") != null ? new Date(rs.getTimestamp("UPDATED").getTime()) : null);
				bean.setInserted(rs.getTimestamp("INSERTED") != null ? new Date(rs.getTimestamp("INSERTED").getTime()) : null);
			}
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
		
		return bean;
	}

	// 상품들을 판매완료로 UPDATE
	public void confirmSellGoods(GoodsListBean bean) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("SELL_FLG = '1' ");
		query.append(", ");
		query.append("SELL_PRICE = " + bean.getSellPrice());
		query.append(", ");
		query.append("MEMO = '" + bean.getMemo() + "' ");
		query.append(", ");
		query.append("SELL_DATE = '" + util.applyDateFormat(bean.getSellDate(), Consts.DB_DATE_FORMAT) +"' ");
		query.append(", ");
		query.append("UPDATED = '" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE id = " + bean.getId());

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	public void insertData(GoodsListBean bean, int bunryu, Long kind, Long color) throws SQLException {

		String kindStr = kind == null ? "null" : String.valueOf(kind);
		String colorStr = color == null ? "null" : String.valueOf(color);

		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();

		query.append("INSERT INTO ");
		query.append("GOODS_LIST ");
		query.append("(");
		query.append("ID, ");
		query.append("BUNRYU, ");
		query.append("NAME, ");
		query.append("KIND, ");
		query.append("COLOR, ");
		query.append("BUY_PRICE, ");
		query.append("SELL_HOPE_PRICE, ");
		query.append("SELL_PRICE, ");
		query.append("PLACE, ");
		query.append("MEMO, ");
		query.append("SELL_FLG, ");
		query.append("DEL_FLG, ");
		query.append("BUY_DATE, ");
		query.append("SELL_DATE, ");
		query.append("UPDATED, ");
		query.append("INSERTED ");
		query.append(")");
		query.append("VALUES (");
		query.append(bean.getId());
		query.append(", ");
		query.append(bunryu);
		query.append(", ");
		query.append(bean.getName() != null ? "'" + bean.getName() + "'" : "null");
		query.append(", ");
		query.append(kindStr);
		query.append(", ");
		query.append(colorStr);
		query.append(", ");
		query.append(bean.getBuyPrice() != null ? bean.getBuyPrice() : "null");
		query.append(", ");
		query.append(bean.getSellHopePrice() != null ? bean.getSellHopePrice() : "null");
		query.append(", ");
		query.append(bean.getSellPrice() != null ? bean.getSellPrice() : "null");
		query.append(", ");
		query.append(bean.getPlace() != null ? "'" + bean.getPlace() + "'" : "null");
		query.append(", ");
		query.append(bean.getMemo() != null ? "'" + bean.getMemo() + "'" : "null");
		query.append(", ");
		query.append("'" + bean.getSellFlg() + "'");
		query.append(", ");
		query.append("'" + bean.getDelFlg() + "'");
		query.append(", ");
		query.append(bean.getBuyDate() != null ? "'" + util.applyDateFormat(bean.getBuyDate(), Consts.DB_DATE_FORMAT) + "'" : "null");
		query.append(", ");
		query.append(bean.getSellDate() != null ? "'" + util.applyDateFormat(bean.getSellDate(), Consts.DB_DATE_FORMAT) + "'" : "null");
		query.append(", ");
		query.append("'" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "'");
		query.append(", ");
		query.append("'" + util.applyDateFormat(bean.getInserted(), Consts.DB_DATE_FORMAT) + "'");
		query.append(")");

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	public Long getMaxId() throws SQLException {
		Long result = null;

		String sql = "SELECT MAX(ID) AS ID FROM GOODS_LIST";

		try {
			PreparedStatement ps = this.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				result = rs.getLong("ID");
			}
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}

		return result;
	}

	public ArrayList<PeriodTotalBean> getGoodsHistoryExceptSellGoods(ArrayList<Integer> bunryuList, Character sellFlag, 
			String id, String[] nameArray, String kind, String color, String[] memoArray,
			String fromDateYear, String fromDateMonth, String fromDateDay,
			String toDateYear, String toDateMonth, String toDateDay
		) throws SQLException {

		Utilities util = new Utilities();
		ArrayList<PeriodTotalBean> result = new ArrayList<PeriodTotalBean>();
	
	
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT ");
			query.append("G.ID, ");
			query.append("G.BUNRYU, ");
			query.append("G.NAME AS NAME, ");
			query.append("K.NAME AS KIND, ");
			query.append("C.NAME AS COLOR, ");
			query.append("G.BUY_PRICE, ");
			query.append("G.SELL_HOPE_PRICE, ");
			query.append("G.SELL_PRICE, ");
			query.append("G.PLACE, ");
			query.append("G.BARCODE, ");
			query.append("G.MEMO, ");
			query.append("G.SELL_FLG, ");
			query.append("G.DEL_FLG, ");
			query.append("G.BUY_DATE, ");
			query.append("G.SELL_DATE, ");
			query.append("G.UPDATED, ");
			query.append("G.INSERTED ");
			query.append("FROM GOODS_LIST AS G ");
			query.append("LEFT JOIN ");
			query.append("COLOR_MST AS C ");
			query.append("ON ");
			query.append("G.COLOR = C.ID ");
			query.append("LEFT JOIN ");
			query.append("KIND_MST AS K ");
			query.append("ON ");
			query.append("G.KIND = K.ID ");
			query.append("WHERE ");
			query.append("G.DEL_FLG = '0' ");	// ���� �� �� ��.
			if (bunryuList != null && ! bunryuList.isEmpty()) {
				
				query.append("AND ");
				query.append("(");
				for (int i = 0; i < bunryuList.size(); i++) {
					if (i != 0) {
						query.append("OR ");
					}
					query.append("G.BUNRYU = " + bunryuList.get(i) + " ");	// �з� 1(��ǰ)�� ��츸 �˻�.
				}
				query.append(") ");
				
			}
	
			if (sellFlag != null) {
				query.append("AND ");
				query.append("G.SELL_FLG = '" + sellFlag +"' ");
			}
			
			if (! util.isEmpty(id)) {	// ID지정시 조건에 추가.
				query.append("AND ");
				query.append("G.ID = " + id + " ");
			}
			if (nameArray != null && nameArray.length > 0) {	// 상품명 지정시 조건에 추가.
				for (String name : nameArray) {
					query.append("AND ");
					query.append("G.NAME LIKE '%" + name + "%' ");
				}
			}
			if (! util.isEmpty(kind)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("K.NAME = '" + kind + "' ");
			}
			if (! util.isEmpty(color)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("C.NAME = '" + color + "' ");
			}
			if (memoArray !=null && memoArray.length > 0) {
				for (String memo : memoArray) {
					query.append("AND ");
					query.append("G.MEMO LIKE '%" + memo + "%' ");
				}
			}
	
			if (! util.isEmpty(fromDateYear) && ! util.isEmpty(fromDateMonth) && ! util.isEmpty(fromDateDay)) {
				query.append("AND ");
				query.append("G.BUY_DATE >= '" + fromDateYear + "-" + fromDateMonth + "-" + fromDateDay + " 00:00:00' ");
			}
	
			if (! util.isEmpty(toDateYear) && ! util.isEmpty(toDateMonth) && ! util.isEmpty(toDateDay)) {
				query.append("AND ");
				query.append("G.BUY_DATE <= '" + toDateYear + "-" + toDateMonth + "-" + toDateDay + " 23:59:59.99' ");
			}
//System.out.println(query.toString());
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
	
				PeriodTotalBean bean = new PeriodTotalBean();
	
				bean.setNo(rs.getLong("ID"));
	
				Integer bunryuOutput = rs.getInt("BUNRYU");
				bean.setBunryu(bunryuOutput);
				bean.setName(rs.getString("NAME"));
				bean.setKind(rs.getString("KIND"));
				bean.setColor(rs.getString("COLOR"));
	
				if (rs.getObject("BUY_PRICE") != null) {
					bean.setBuyPrice(rs.getLong("BUY_PRICE"));
				}
	
				if (rs.getObject("SELL_HOPE_PRICE") != null) {
					bean.setSellHopePrice(rs.getLong("SELL_HOPE_PRICE"));
				}
	
				Character sellFlgOutput = rs.getString("SELL_FLG").charAt(0);
				bean.setSellFlg(sellFlgOutput);
	
	
				if (rs.getObject("SELL_PRICE") != null) {
					bean.setSellPrice(rs.getLong("SELL_PRICE"));
				}
	
				bean.setPlace(rs.getString("PLACE"));
	//			bean.setBarcode(rs.getString("BARCODE"));
	
				bean.setMemo(rs.getString("MEMO"));
				
				bean.setDate(rs.getTimestamp("BUY_DATE") != null ? new Date(rs.getTimestamp("BUY_DATE").getTime()) : null);

				if (bunryuOutput == Consts.BUNRYU_GOODS && sellFlgOutput == '1') {	// 분류:상품, 상태: 판매의 경우, 구입시 상품과 판매시 상품을 따로 등록.
					bean.setSellPrice(null);
					bean.setSellFlg('0');
				}

				result.add(bean);
			}
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	
		return result;
	}

	public ArrayList<PeriodTotalBean> getSellGoodsHistory(
			String id, String[] nameArray, String kind, String color, String[] memoArray,
			String fromDateYear, String fromDateMonth, String fromDateDay,
			String toDateYear, String toDateMonth, String toDateDay
		) throws SQLException {

		Utilities util = new Utilities();
		ArrayList<PeriodTotalBean> result = new ArrayList<PeriodTotalBean>();
	
	
		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT ");
			query.append("G.ID, ");
			query.append("G.BUNRYU, ");
			query.append("G.NAME AS NAME, ");
			query.append("K.NAME AS KIND, ");
			query.append("C.NAME AS COLOR, ");
			query.append("G.BUY_PRICE, ");
			query.append("G.SELL_HOPE_PRICE, ");
			query.append("G.SELL_PRICE, ");
			query.append("G.PLACE, ");
			query.append("G.BARCODE, ");
			query.append("G.MEMO, ");
			query.append("G.SELL_FLG, ");
			query.append("G.DEL_FLG, ");
			query.append("G.BUY_DATE, ");
			query.append("G.SELL_DATE, ");
			query.append("G.UPDATED, ");
			query.append("G.INSERTED ");
			query.append("FROM GOODS_LIST AS G ");
			query.append("LEFT JOIN ");
			query.append("COLOR_MST AS C ");
			query.append("ON ");
			query.append("G.COLOR = C.ID ");
			query.append("LEFT JOIN ");
			query.append("KIND_MST AS K ");
			query.append("ON ");
			query.append("G.KIND = K.ID ");
			query.append("WHERE ");
			query.append("G.DEL_FLG = '0' ");	// ���� �� �� ��.

			query.append("AND ");
			query.append("G.BUNRYU = " + Consts.BUNRYU_GOODS + " ");	// �з� 1(��ǰ)�� ��츸 �˻�.
	
			query.append("AND ");
			query.append("G.SELL_FLG = '1' ");

			if (! util.isEmpty(id)) {	// ID지정시 조건에 추가.
				query.append("AND ");
				query.append("G.ID = " + id + " ");
			}
			if (nameArray != null && nameArray.length > 0) {	// 상품명 지정시 조건에 추가.
				for (String name : nameArray) {
					query.append("AND ");
					query.append("G.NAME LIKE '%" + name + "%' ");
				}
			}
			if (! util.isEmpty(kind)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("K.NAME = '" + kind + "' ");
			}
			if (! util.isEmpty(color)) {	// 상품명 지정시 조건에 추가.
				query.append("AND ");
				query.append("C.NAME = '" + color + "' ");
			}
			if (memoArray !=null && memoArray.length > 0) {
				for (String memo : memoArray) {
					query.append("AND ");
					query.append("G.MEMO LIKE '%" + memo + "%' ");
				}
			}
	
			if (! util.isEmpty(fromDateYear) && ! util.isEmpty(fromDateMonth) && ! util.isEmpty(fromDateDay)) {
				query.append("AND ");
				query.append("G.SELL_DATE >= '" + fromDateYear + "-" + fromDateMonth + "-" + fromDateDay + " 00:00:00' ");
			}
	
			if (! util.isEmpty(toDateYear) && ! util.isEmpty(toDateMonth) && ! util.isEmpty(toDateDay)) {
				query.append("AND ");
				query.append("G.SELL_DATE <= '" + toDateYear + "-" + toDateMonth + "-" + toDateDay + " 23:59:59.99' ");
			}
			
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();
	
			while(rs.next()) {
	
				PeriodTotalBean bean = new PeriodTotalBean();
	

				bean.setNo(rs.getLong("ID"));
				
				bean.setBunryu(rs.getInt("BUNRYU"));
				bean.setName(rs.getString("NAME"));
				bean.setKind(rs.getString("KIND"));
				bean.setColor(rs.getString("COLOR"));
				bean.setSellFlg(rs.getString("SELL_FLG").charAt(0));


				if (rs.getObject("SELL_PRICE") != null) {
					bean.setSellPrice(rs.getLong("SELL_PRICE"));
				}

				bean.setPlace(rs.getString("PLACE"));

				bean.setMemo(rs.getString("MEMO"));
				
				bean.setDate(rs.getTimestamp("SELL_DATE") != null ? new Date(rs.getTimestamp("SELL_DATE").getTime()) : null);
				
				result.add(bean);
	
			}
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	
		return result;
	}

	public void deleteGoods(Long id, Date updated) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("DEL_FLG = '1' ");

		if (updated != null) {
			query.append(", ");
			query.append("UPDATED = ");
			query.append("'" + util.applyDateFormat(updated, Consts.DB_DATE_FORMAT) + "' ");
		}

		query.append("WHERE id = " + id);

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	public void updateGoods(GoodsListBean bean, Long kind, Long color) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		if (! util.isEmpty(bean.getName())) {
			query.append("NAME = ");
			query.append("'" + bean.getName() + "'");
			query.append(", ");
		}

		query.append("KIND = ");
		if (kind != null) {
			query.append(kind);
		} else {
			query.append("null");
		}
		query.append(", ");

		query.append("COLOR = ");
		if (color != null) {
			query.append(color);
		} else {
			query.append("null");
		}
		query.append(", ");

		query.append("MEMO = ");
		if (! util.isEmpty(bean.getMemo())) {
			query.append("'" + bean.getMemo() + "'");
		} else {
			query.append("null");
		}
		query.append(", ");

		query.append("BUY_PRICE = ");
		if (bean.getBuyPrice() != null) {
			query.append(bean.getBuyPrice());
		} else {
			query.append("null");
		}
		query.append(", ");

		query.append("SELL_HOPE_PRICE = ");
		if (bean.getSellHopePrice() != null) {
			query.append(bean.getSellHopePrice());
		} else {
			query.append("null");
		}
		query.append(", ");

		query.append("PLACE = ");
		if (! util.isEmpty(bean.getPlace())) {
			query.append("'" + bean.getPlace() + "' ");
		} else {
			query.append("null ");
		}
		
		
		query.append(", ");

		query.append("BUY_DATE = ");
		if (bean.getBuyDate() != null) {
			query.append("'" + util.applyDateFormat(bean.getBuyDate(), Consts.DB_DATE_FORMAT) + "'");
		}
		

		if (bean.getUpdated() != null) {
			query.append(", ");
			query.append("UPDATED = ");
			query.append("'" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "' ");
		}

		query.append("WHERE id = " + bean.getId());

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 판매상품 정보 수정
	public void updateSellGoods(GoodsListBean bean) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("SELL_PRICE = " + bean.getSellPrice());
		query.append(", ");
		String memo = bean.getMemo() == null ? "null" : "'" + bean.getMemo() + "'";
		query.append("MEMO = " + memo + " ");
		query.append(", ");
		query.append("SELL_DATE = '" + util.applyDateFormat(bean.getSellDate(), Consts.DB_DATE_FORMAT) + "'");
		query.append(", ");
		query.append("UPDATED = '" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE id = " + bean.getId());

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 판매 상품을 미판매 상태로 되돌린다.
	public void cancelSellGoods(Long id) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("SELL_FLG = 0 ");
		query.append(", ");
		query.append("SELL_PRICE = NULL ");
		query.append(", ");
		query.append("SELL_DATE = NULL ");
		query.append(", ");
		query.append("UPDATED = '" + util.applyDateFormat(new Date(System.currentTimeMillis()), Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE id = " + id);
		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 수입 정보 수정.
	public void updateSuib(GoodsListBean bean) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("NAME = '" + bean.getName() + "'");
		query.append(", ");
		query.append("SELL_PRICE = " + bean.getSellPrice());
		query.append(", ");
		String memo = bean.getMemo() == null ? "null" : "'" + bean.getMemo() + "'";
		query.append("MEMO = " + memo + " ");
		query.append(", ");
		query.append("BUY_DATE = '" + util.applyDateFormat(bean.getBuyDate(), Consts.DB_DATE_FORMAT) + "'");
		query.append(", ");
		query.append("UPDATED = '" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE id = " + bean.getId());

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 지출 정보 수정.
	public void updateJichul(GoodsListBean bean) throws SQLException {
		Utilities util = new Utilities();

		StringBuffer query = new StringBuffer();
		query.append("UPDATE ");
		query.append("GOODS_LIST ");
		query.append("SET ");
		query.append("NAME = '" + bean.getName() + "'");
		query.append(", ");
		query.append("BUY_PRICE = " + bean.getBuyPrice());
		query.append(", ");
		String memo = bean.getMemo() == null ? "null" : "'" + bean.getMemo() + "'";
		query.append("MEMO = " + memo + " ");
		query.append(", ");
		query.append("BUY_DATE = '" + util.applyDateFormat(bean.getBuyDate(), Consts.DB_DATE_FORMAT) + "'");
		query.append(", ");
		query.append("UPDATED = '" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE id = " + bean.getId());

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 특정 상품 종류의 상품들을 상품 종류 미지정 상태로 수정함.
	public void makeKindNull(Long kind, Date now) throws SQLException {
		Utilities util = new Utilities();
		StringBuffer query = new StringBuffer();
		query.append("UPDATE GOODS_LIST SET KIND = NULL, ");
		query.append("UPDATED = '" + util.applyDateFormat(now, Consts.DB_DATE_FORMAT) + "' ");
		query.append("WHERE KIND = " + kind);

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}
}
