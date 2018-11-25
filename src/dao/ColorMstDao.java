package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.Consts;
import common.Utilities;
import bean.ColorMstBean;

public class ColorMstDao extends AbstractDao {

	public ColorMstDao() throws SQLException {
		super();
	}

	public ArrayList<ColorMstBean> getColorMst() throws SQLException {

		ArrayList<ColorMstBean> result = new ArrayList<ColorMstBean>();

		try {
			StringBuffer query = new StringBuffer();
			query.append("SELECT ");
			query.append("ID, ");
			query.append("NAME ");
			query.append("FROM ");
			query.append("COLOR_MST ");
			query.append("ORDER BY ID ASC ");

			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ColorMstBean bean = new ColorMstBean();

				bean.setId(rs.getLong("ID"));
				bean.setName(rs.getString("NAME"));
				result.add(bean);
			}

		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}

		return result;
	}

	public Long getIdWithName(String name) throws SQLException {
		Long result = null;

		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("ID ");
		query.append("FROM ");
		query.append("COLOR_MST ");
		query.append("WHERE ");
		query.append("NAME = ");
		query.append("'" + name + "'");

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
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

	public void insertColor(ColorMstBean bean) throws SQLException {
		Utilities util = new Utilities();
		StringBuffer query = new StringBuffer();
		query.append("INSERT ");
		query.append("INTO ");
		query.append("COLOR_MST ");
		query.append("(");
		query.append("NAME, ");
		query.append("UPDATED, ");
		query.append("INSERTED ");
		query.append(") ");
		query.append("VALUES ");
		query.append("(");
		query.append("'" + bean.getName() + "'");
		query.append(", ");
		query.append("'" + util.applyDateFormat(bean.getUpdated(), Consts.DB_DATE_FORMAT) + "'");
		query.append(", ");
		query.append("'" + util.applyDateFormat(bean.getInserted(), Consts.DB_DATE_FORMAT) + "'");
		query.append(") ");

		try {
			PreparedStatement ps = this.con.prepareStatement(query.toString());
			ps.execute();
		} finally {
			if (!this.con.isClosed()) {
				this.con.close();
			}
		}
	}

	// 삭제를 위해 미사용 중인 종류를 취득한다.
		public ArrayList<ColorMstBean> getUnusedColor() throws SQLException {
			ArrayList<ColorMstBean> result = new ArrayList<ColorMstBean>();

			StringBuffer query = new StringBuffer();
//			query.append("SELECT ID, NAME, GOODSCOUNT FROM (");
			query.append("SELECT K.ID, K.NAME, COUNT(G.ID) AS GOODSCOUNT FROM COLOR_MST AS K LEFT JOIN GOODS_LIST AS G ON K.ID = G.Color GROUP BY K.ID");
//			query.append(")");
//			query.append(" WHERE GOODSCOUNT = 0");

			try {
				PreparedStatement ps = this.con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					ColorMstBean bean = new ColorMstBean();

					bean.setId(rs.getLong("ID"));
					bean.setName(rs.getString("NAME"));
					result.add(bean);
				}

			} finally {
				if (!this.con.isClosed()) {
					this.con.close();
				}
			}

			return result;
		}

		public void updateColor(ColorMstBean bean) throws SQLException {
			Utilities util = new Utilities();
			StringBuffer query = new StringBuffer();
			query.append("UPDATE COLOR_MST SET ");
			query.append("NAME = ");
			if (bean.getName() == null) {
				query.append("null ");
			} else {
				query.append("'" + bean.getName() + "' ");
			}
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

		// 상품종류 삭제.
		public void deleteColor(Long id) throws SQLException {
			String query = "DELETE FROM COLOR_MST WHERE id = " + id;
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
