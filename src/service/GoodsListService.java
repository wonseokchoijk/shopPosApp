package service;

import java.sql.SQLException;
import java.util.List;
import common.Utilities;
import bean.ColorMstBean;
import bean.GoodsListBean;
import bean.KindMstBean;
import dao.ColorMstDao;
import dao.GoodsListDao;
import dao.KindMstDao;

public class GoodsListService {
//	private List<GoodsListBean> goodsList = new List<GoodsListBean>();

	public List<GoodsListBean> getGoodsList(Integer bunryu, Character sellFlg,
											String id, String name, String kind, String color, String memo,
											String fromDateYear, String fromDateMonth, String fromDateDay,
											String toDateYear, String toDateMonth, String toDateDay) throws SQLException {


		Utilities util = new Utilities();

		String[] memoArray = null;
		String[] nameArray = null;

		if (! util.isEmpty(id)) {
			id = id.trim();
		}
		if (! util.isEmpty(name)) {
			name = name.trim();
		}
		if (! util.isEmpty(name)) {
			name = name.trim();
			nameArray = name.split(" ");
		}
		if (! util.isEmpty(kind)) {
			kind = kind.trim();
		}
		if (! util.isEmpty(color)) {
			color = color.trim();
		}
		if (! util.isEmpty(memo)) {
			memo = memo.trim();
			memoArray = memo.split(" ");
		}
		if (! util.isEmpty(fromDateYear)) {
			fromDateYear = fromDateYear.trim();
		}
		if (! util.isEmpty(fromDateMonth)) {
			fromDateMonth = fromDateMonth.trim();
		}
		if (! util.isEmpty(fromDateDay)) {
			fromDateDay = fromDateDay.trim();
		}
		if (! util.isEmpty(toDateYear)) {
			toDateYear = toDateYear.trim();
		}
		if (! util.isEmpty(toDateMonth)) {
			toDateMonth = toDateMonth.trim();
		}
		if (! util.isEmpty(toDateDay)) {
			toDateDay = toDateDay.trim();
		}

		if (! util.isEmpty(fromDateYear) && util.isEmpty(fromDateMonth)) { // from 날짜. 연도만 있고 월이 없으면 1월 1일 설정.
			fromDateMonth = "01";
			fromDateDay = "01";
		}
		if (! util.isEmpty(fromDateYear) && ! util.isEmpty(fromDateMonth) && util.isEmpty(fromDateDay)) {	// from 날짜. 연도, 월 있고 일만 없을 때 1일 설정
			fromDateDay = "01";
		}

		if (! util.isEmpty(toDateYear) && util.isEmpty(toDateMonth)) { // to 날짜. 연도만 있고 월이 없으면 12월 31일 설정.
			toDateMonth = "12";
			toDateDay = "31";
		}
		if (! util.isEmpty(toDateYear) && ! util.isEmpty(toDateMonth) && util.isEmpty(toDateDay)) {	// to 날짜. 연도, 월 있고 일만 없을 때 그 달의 마지막날 설정
			toDateDay = String.format("%02d", util.getLastDay(Integer.valueOf(toDateYear).intValue(), Integer.valueOf(toDateMonth).intValue()));
		}

		GoodsListDao dao = new GoodsListDao();
		List<GoodsListBean> dbGoodsList = dao.getGoodsList(bunryu, sellFlg, id, nameArray, kind, color, memoArray, fromDateYear, fromDateMonth, fromDateDay, toDateYear, toDateMonth, toDateDay);

		// 셀렉트문 2번 실행하지말고 한번만 한 후, 판매데이터만 따로 다른 리스트에 넣어놨다가 나중에 합쳐서 소트 하기.
//// 판매와 구입을 동시에 취득할 때에는...판매 데이터는 따로 얻어와서 합치기.
//if ((bunryu == null || bunryu == Consts.BUNRYU_GOODS) && sellFlg == null) {
//	GoodsListDao dao2 = new GoodsListDao();
//	List<GoodsListBean> dbSellList = dao2.getGoodsList(Consts.BUNRYU_GOODS, '1', id, nameArray, kind, color, memoArray, fromDateYear, fromDateMonth, fromDateDay, toDateYear, toDateMonth, toDateDay);
//}
		return dbGoodsList;
	}

	public List<ColorMstBean> getColorMst() throws SQLException {

		ColorMstDao dao = new ColorMstDao();
		List<ColorMstBean> dbColorMst = dao.getColorMst();

		return dbColorMst;
	}

	public List<KindMstBean> getKindMst() throws SQLException {

		KindMstDao dao = new KindMstDao();
		List<KindMstBean> dbColorMst = dao.getKindMst();

		return dbColorMst;
	}
}
