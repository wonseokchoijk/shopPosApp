package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import bean.PeriodTotalBean;
import common.Consts;
import common.Utilities;
import dao.GoodsListDao;

public class PeriodTotalService {
	public List<PeriodTotalBean> getPeriodTotalList(ArrayList<Integer> bunryuList, Character sellFlg,
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

		// 구입데이터와 수입, 지출 데이터 취득.
		// 분류에 상품이 들어있고 sellFlg가 null이면 그대로.
		// 분류에 상품이 들어있고 sellFlg가 0이면 dao측에 건네주는 sellFlg에 null을 지정. (판매, 미판매 다 검색)
		// 분류에 상품이 들어있고 sellFlg가 1이면 분류:상품은 뺀다.
		// 상품이 없는 경우는 분류는 그대로. sellFlg는 null을 지정.

		boolean goodsExist = false;		// 인수로 받은 분류 배열에 상품이 있는지 검사.
		int goodsIndex = -1;


//		if (bunryuList == null || bunryuList.isEmpty()) {
//			goodsExist = true;
//		} else{
		if (bunryuList != null && ! bunryuList.isEmpty()) {
			goodsIndex = bunryuList.indexOf(Consts.BUNRYU_GOODS);
			if (goodsIndex != -1) {
				goodsExist = true;
			}
		}

//		Character buySellFlg = null;

		boolean executeFlag = true;

		if (goodsExist) {
			if (sellFlg != null && sellFlg == '1') {
				if ( bunryuList.size() == 1) {
					executeFlag = false;
				} else {
					bunryuList.remove(goodsIndex);
				}
			}
		}

		List<PeriodTotalBean> periodTotalList = new ArrayList<PeriodTotalBean>();
		if(executeFlag) {
			// 판매데이터 이외 취득.
			periodTotalList = dao.getGoodsHistoryExceptSellGoods(bunryuList, null, id, nameArray, kind, color, memoArray, fromDateYear, fromDateMonth, fromDateDay, toDateYear, toDateMonth, toDateDay);
		}
		
		// 분류어레이가 null 또는 상품일 때. && sellFlg가 null 또는 1일 때.
		boolean sellGoodsExist = false;
		if ((sellFlg == null || sellFlg == '1')) {
			if (goodsExist) {
				sellGoodsExist = true;
			}
		}
		// 판매데이터 취득.
		if (sellGoodsExist) {
			GoodsListDao dao2 = new GoodsListDao();
			periodTotalList.addAll(dao2.getSellGoodsHistory(id, nameArray, kind, color, memoArray, fromDateYear, fromDateMonth, fromDateDay, toDateYear, toDateMonth, toDateDay));
		}
		// 셀렉트문 2번 실행하지말고 한번만 한 후, 판매데이터만 따로 다른 리스트에 넣어놨다가 나중에 합쳐서 소트 하기.
		////판매와 구입을 동시에 취득할 때에는...판매 데이터는 따로 얻어와서 합치기.

		if (periodTotalList != null) {
			Collections.sort(periodTotalList, new Comparator<PeriodTotalBean>() {

				@Override
				public int compare(PeriodTotalBean o1, PeriodTotalBean o2) {
					if (o1.getDate() == null || o2.getDate() == null) {
						return 0;
					}
					int returnValue = Long.compare(o1.getDate().getTime(), o2.getDate().getTime());
					if (returnValue < 0) {
						return 1;
					} else if (returnValue > 0) {
						return -1;
					} else {
						return 0;
					}
				}
				
			});
		}

		return periodTotalList;
	}
}
