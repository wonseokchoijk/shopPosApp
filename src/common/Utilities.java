package common;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Date;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;



import dao.GoodsListSearchKeywordsDto;
import dao.PeriodTotalSearchKeywordDto;


public class Utilities {

	private final DecimalFormat PRICE_FORMAT = new DecimalFormat("#,###");
	private SimpleDateFormat dateFormat = new SimpleDateFormat(); 

	// 일정 일로부터 한달 전을 취득.
	public int[] getAMonthAgoYearMonthDay(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		cal.add(Calendar.MONTH, -1);

		int[] yearMonthDay = {cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DATE)};
		return yearMonthDay;
	}

	// 그 연도 그 달의 마지막 날 취득.
	public int getLastDay(int year, int month) {
		Calendar now = Calendar.getInstance();
		now.set(year, month-1, 1);
		return now.getActualMaximum(Calendar.DATE);
	}

	// 올해 연도 취득
	public int getThisYear() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR);
	}

	public int getThisMonth() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.MONTH) + 1;
	}

	public int getThisDay() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.DATE);
	}

	public boolean isEmpty(String str) {
		if (str == null || str.isEmpty()) {
			return true;
		}
		return false;
	}

	public String addCommaForPrice(Long price) {
		if (price == null) {
			return "";
		}
		
		return PRICE_FORMAT.format(price) + " 원";
	}

	public String applyDateFormat(Date date, String format) {
		if (date == null) {
			return "";
		}
		this.dateFormat.applyPattern(format);
		return dateFormat.format(date.getTime());
	}

	// TODO:현재 쓰이는 곳 없음. 쓸 경우 이 코멘트 삭제
//	public boolean isNumeric(String str){ 
//		return Pattern.matches("[0-9]+", str); 
//		}

	// 연도와 월 콤보가 결정되면 일 콤보에도 그 달의 마지막 날까지 추가.
	public void getLastDayWhenYearAndMonthChoosed(Combo year, Combo month, Combo day, boolean addEmptyItem) {
		if (! this.isEmpty(year.getText()) && ! this.isEmpty(month.getText())) {

			int lastDay = this.getLastDay(Integer.valueOf(year.getText()), Integer.valueOf(month.getText()));
			day.removeAll();
			
			if (addEmptyItem) {
				day.add("");
			}
			for (int i = 1; i <= lastDay; i++) {
				day.add(String.format("%02d", i));
			}
			if (! addEmptyItem) {
				day.select(0);
			}
		} else {
			day.removeAll();
			if (addEmptyItem) {
				day.add("");
			}
		}

		// 연도가 없이 월 입력 불가능하게.
		if (! this.isEmpty(year.getText())) {
			if (month.getItemCount() < 2) {
				month.removeAll();
				if (addEmptyItem) {
					month.add("");
				}
				for (int i = 1; i <= 12; i++) {
					month.add(String.format("%02d", i));
				}
			}
		} else {
			month.removeAll();
			if (addEmptyItem) {
				month.add("");
			}
		}
	}

	public void showErrorMsg(Shell shell, String exceptionMessage) {
		MessageBox box = new MessageBox(shell, SWT.ICON_ERROR);
		box.setText("에러 발생");
		box.setMessage("에러가 발생하였습니다.\n\n" + exceptionMessage);
		box.open();
	}

	public void showMsg(Shell shell, String message) {
		MessageBox box = new MessageBox(shell, SWT.ICON_INFORMATION);
		box.setText("알림");
		box.setMessage(message);
		box.open();
	}

	public int showYesOrNoMsgBox(Shell shell, String message) {
		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		messageBox.setMessage(message);
		messageBox.setText("확인");
		return messageBox.open();
	}
	
	/**
	 * 문자열 연월일이 올바른 날짜인지 체크
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isCorrectDate(String year, String month, String day) {
		boolean result = false;
		
		String monthValue = String.format("%02d", Integer.valueOf(month));
		String dayValue = String.format("%02d", Integer.valueOf(day));
		
		String date = year + monthValue + dayValue + "000000";

		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss",Locale.KOREA); 
		df.setLenient(false);
		
		try {
			df.parse(date);
			result = true;
		} catch(ParseException pe){
		} catch(IllegalArgumentException ae){
		}
		
		return result;
	}
	
	public Date getDateFromString(String year, String month, String day) {
		String monthValue = String.format("%02d", Integer.valueOf(month));
		String dayValue = String.format("%02d", Integer.valueOf(day));

		// 시분초는 현재 시분초로.
		Calendar oCalendar = Calendar.getInstance( );
		String currentHour = String.format("%02d", oCalendar.get(Calendar.HOUR_OF_DAY));
		String currentMinute = String.format("%02d", oCalendar.get(Calendar.MINUTE));
		String currentSecond = String.format("%02d", oCalendar.get(Calendar.SECOND));
		
		String date = year + monthValue + dayValue + currentHour + currentMinute + currentSecond;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss",Locale.KOREA); 
		df.setLenient(false);
		java.util.Date result = null;
		try {
			result = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(result.getTime());
	}

	/**
	 * 재고리스트 인쇄용 브라우저 출력
	 * @param goodsListSearchKeywordsDto
	 * @param buyPrice
	 * @param expectedSellPrice
	 * @param totalPrice
	 * @param items
	 * @return
	 */
	private String makeGoodsListHtml(GoodsListSearchKeywordsDto goodsListSearchKeywordsDto, String buyPrice, String expectedSellPrice, String totalPrice, TableItem[] items) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy년MM월dd일 HH시 mm분 ss초",Locale.KOREA);
		
		StringBuffer strBfr = new StringBuffer();
		strBfr.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		strBfr.append("<html>");
		strBfr.append("	<head>");
		strBfr.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		strBfr.append("		<style>");
		strBfr.append("			h1 { font-size: 25px; }");
		strBfr.append("			table { border: 1px solid #000000; border-spacing: 0; border-collapse: collapse; }");
		strBfr.append("			tr { border: 1px solid #000000; }");
		strBfr.append("			th, td {  border: 1px solid #000000; font-size: 11px; padding: 3px 5px 3px 5px; word-break: break-all; }");
		strBfr.append("			th { background-color: #cccccc; }");
		strBfr.append("			td {  }");
		strBfr.append("		</style>");
		strBfr.append("	</head>");
		strBfr.append("	<body>");
		strBfr.append("		<div style='font-size: 10px;text-align: left;'>일시 : " + df.format(new java.util.Date()) + "</div>");
		strBfr.append("		<h1 style='text-align: center;'>재고 리스트</h1>");
		strBfr.append("		<table>");
		strBfr.append("			<tr style='border-top: hidden; border-left: hidden; border-right: hidden;'>");
		strBfr.append("				<td colspan='9' style='border-top: hidden; border-left: hidden; border-right: hidden;'>");
		strBfr.append("					<div style='text-align: right;'>");
		strBfr.append("						표시 상품갯수 : " + items.length + " 개<br />");
		strBfr.append("						구입가 합계 : " + buyPrice + "<br />");
		strBfr.append("						판매예정가 합계 : " + expectedSellPrice + "<br />");
		strBfr.append("						예정가 이윤 (판매예정가 합계 - 구입가 합계) : " + totalPrice + "<br />");
		strBfr.append("					</div>");
		strBfr.append("				</td>");
		strBfr.append("			</tr>");
		strBfr.append("			<tr>");
		strBfr.append("				<th style='width: 50px;'>");
		strBfr.append("					No.");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 90px;'>");
		strBfr.append("					상품명");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 100px;'>");
		strBfr.append("					상품종류");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 70px;'>");
		strBfr.append("					색상");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 120px;'>");
		strBfr.append("					메모");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					구입가");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					판매예정가");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					구입처");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					구입날짜");
		strBfr.append("				</th>");
		strBfr.append("			</tr>");
		for (TableItem item : items) {
			strBfr.append("			<tr>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(0)); // No.
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(1)); // 상품명
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(2)); // 상품종류
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(3)); // 색상
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(4)); // 메모
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(5)); // 구입가
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(6)); // 판몌예정가
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(7)); // 구입처
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: center;'>");
			strBfr.append(item.getText(8)); // 구입날짜
			strBfr.append("				</td>");
			strBfr.append("			</tr>");
		}
		strBfr.append("		</table>");
		strBfr.append("		<br />");
		strBfr.append("		<div style='font-size: 10px;text-align: left;'>");
		strBfr.append("			검색어<br />");
		strBfr.append("			상품No: " + goodsListSearchKeywordsDto.getGoodsNo() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			색상: " + goodsListSearchKeywordsDto.getColor() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			메모: " + goodsListSearchKeywordsDto.getMemo() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			상품명: " + goodsListSearchKeywordsDto.getGoodsName() + "<br />");
		strBfr.append("			구입날짜(From): " + goodsListSearchKeywordsDto.getFromYear() + "년 ");
		strBfr.append(				goodsListSearchKeywordsDto.getFromMonth() + "월 ");
		strBfr.append(				goodsListSearchKeywordsDto.getFromDay() + "일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
		strBfr.append("			구입날짜(To): " + goodsListSearchKeywordsDto.getToYear() + "년 ");
		strBfr.append(				goodsListSearchKeywordsDto.getToMonth() + "월 ");
		strBfr.append(				goodsListSearchKeywordsDto.getToDay() + "일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
		strBfr.append("			상품종류: " + goodsListSearchKeywordsDto.getKind() + "<br />");
		strBfr.append("		</div>");
		strBfr.append("	</body>");
		strBfr.append("</html>");
		
		return strBfr.toString();
	}
	
	private String makePeriodTotalHtml(PeriodTotalSearchKeywordDto periodTotalSearchKeywordDto, String inPrice, String outPrice, String totalPrice, TableItem[] items) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy년MM월dd일 HH시 mm분 ss초",Locale.KOREA);
		
		StringBuffer strBfr = new StringBuffer();
		strBfr.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		strBfr.append("<html>");
		strBfr.append("	<head>");
		strBfr.append("		<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		strBfr.append("		<style>");
		strBfr.append("			h1 { font-size: 25px; }");
		strBfr.append("			table { border: 1px solid #000000; border-spacing: 0; border-collapse: collapse; }");
		strBfr.append("			tr { border: 1px solid #000000; }");
		strBfr.append("			th, td {  border: 1px solid #000000; font-size: 11px; padding: 3px 5px 3px 5px; word-break: break-all; }");
		strBfr.append("			th { background-color: #cccccc; }");
		strBfr.append("			td {  }");
		strBfr.append("		</style>");
		strBfr.append("	</head>");
		strBfr.append("	<body>");
		strBfr.append("		<div style='font-size: 10px;text-align: left;'>일시 : " + df.format(new java.util.Date()) + "</div>");
		strBfr.append("		<h1 style='text-align: center;'>상품 지출 소득 리스트</h1>");
		strBfr.append("		<div style='text-align: center; font-size: 12px;'>");
		strBfr.append(			periodTotalSearchKeywordDto.getBuyDateFromYear() + "년 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateFromMonth() + "월 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateFromDay() + "일에서 ");
		strBfr.append(			periodTotalSearchKeywordDto.getBuyDateToYear() + "년 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateToMonth() + "월 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateToDay() + "일까지의 입출기록 리스트");
		strBfr.append("		</div><br />");
		strBfr.append("		<table>");
		strBfr.append("			<tr style='border-top: hidden; border-left: hidden; border-right: hidden;'>");
		strBfr.append("				<td colspan='10' style='border-top: hidden; border-left: hidden; border-right: hidden;'>");
		strBfr.append("					<div style='text-align: right; font-size: 12px;'>");
		strBfr.append("						이득 (판매/수입 합계) : " + inPrice + "<br />");
		strBfr.append("						지출 (구입/지출 합계) : " + outPrice + "<br />");
		strBfr.append("						이윤 (이득 - 지출) : " + totalPrice + "<br />");
		strBfr.append("					</div>");
		strBfr.append("				</td>");
		strBfr.append("			</tr>");
		strBfr.append("			<tr>");
		strBfr.append("				<th style='width: 50px;'>");
		strBfr.append("					No.");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					분류");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 90px;'>");
		strBfr.append("					상품명");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 100px;'>");
		strBfr.append("					상품종류");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 70px;'>");
		strBfr.append("					색상");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 120px;'>");
		strBfr.append("					메모");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					구입가/<br />지출액(-)");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					판매가/<br />소득액(+)");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 80px;'>");
		strBfr.append("					구입처");
		strBfr.append("				</th>");
		strBfr.append("				<th style='width: 90px;'>");
		strBfr.append("					등록날짜");
		strBfr.append("				</th>");
		strBfr.append("			</tr>");
		for (TableItem item : items) {
			strBfr.append("			<tr>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(0)); // No.
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(1)); // 분류
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(2)); // 상품명
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(3)); // 상품종류
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(4)); // 색상
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(5)); // 메모
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(6)); // 구입가/지출액(-)
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: right;'>");
			strBfr.append(item.getText(7)); // 판매가/소득액(+)
			strBfr.append("				</td>");
			strBfr.append("				<td>");
			strBfr.append(item.getText(8)); // 구입처
			strBfr.append("				</td>");
			strBfr.append("				<td style='text-align: center;'>");
			strBfr.append(item.getText(9)); // 등록날짜
			strBfr.append("				</td>");
			strBfr.append("			</tr>");
		}
		
		
		strBfr.append("		</table>");
		strBfr.append("		<br />");
		strBfr.append("		<div style='font-size: 10px;text-align: left;'>");
		strBfr.append("		<div style='font-size: 10px;text-align: left;'>");
		strBfr.append("			검색어<br />");
//		periodTotalSearchKeywordDto
		strBfr.append("			구입날짜(From): " + periodTotalSearchKeywordDto.getBuyDateFromYear() + "년 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateFromMonth() + "월 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateFromDay() + "일&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ");
		strBfr.append("			구입날짜(To): " + periodTotalSearchKeywordDto.getBuyDateToYear() + "년 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateToMonth() + "월 ");
		strBfr.append(				periodTotalSearchKeywordDto.getBuyDateToDay() + "일<br />");
		strBfr.append("			상품No: " + periodTotalSearchKeywordDto.getGoodsNo() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			상품종류: " + periodTotalSearchKeywordDto.getKind() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			메모: " + periodTotalSearchKeywordDto.getMemo() + "<br />");
		strBfr.append("			항목명: " + periodTotalSearchKeywordDto.getGoodsName() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		strBfr.append("			색상: " + periodTotalSearchKeywordDto.getColor() + "<br />");
		String buyFlag = periodTotalSearchKeywordDto.isBuyFlag() ? "○" : "×";
		strBfr.append("			상품구입: " + buyFlag + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		String sellFlag = periodTotalSearchKeywordDto.isSellFlag() ? "○" : "×";
		strBfr.append("			상품판매: " + sellFlag + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		String inFlag = periodTotalSearchKeywordDto.isInFlag() ? "○" : "×";
		strBfr.append("			수입: " + inFlag + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		String outFlag = periodTotalSearchKeywordDto.isOutFlag() ? "○" : "×";
		strBfr.append("			지출: " + outFlag + "<br />");
		strBfr.append("		</div>");
		
		strBfr.append("	</body>");
		strBfr.append("</html>");
		
		return strBfr.toString();
	}
	
	public void outputGoodsListHtmlFile(GoodsListSearchKeywordsDto goodsListSearchKeywordsDto, String buyPrice, String expectedSellPrice, String totalPrice, Table goodsListTable) {
		 try {
			 TableItem[] tableItems = goodsListTable.getItems();

			 String str = this.makeGoodsListHtml(goodsListSearchKeywordsDto, buyPrice, expectedSellPrice, totalPrice, tableItems);

		      BufferedWriter out = new BufferedWriter
		    		    (new OutputStreamWriter(new FileOutputStream(Consts.HTML_FILE_FOR_PRINT),"UTF-8"));

		      out.write(str); out.newLine();

		      out.close();

		    } catch (IOException e) {
		    	System.out.println("no conf directory exists.");
		    }
	}
	
	public void outputPeriodTotalHtmlFile(PeriodTotalSearchKeywordDto periodTotalSearchKeywordDto, String inPrice, String outPrice, String totalPrice, Table periodTotalTable) {
		 try {
			 TableItem[] tableItems = periodTotalTable.getItems();

			 String str = this.makePeriodTotalHtml(periodTotalSearchKeywordDto, inPrice, outPrice, totalPrice, tableItems);

		      BufferedWriter out = new BufferedWriter
		    		    (new OutputStreamWriter(new FileOutputStream(Consts.HTML_FILE_FOR_PRINT),"UTF-8"));

		      out.write(str); out.newLine();

		      out.close();

		    } catch (IOException e) {
		    	System.out.println("no conf directory exists.");
		    }
	}
	
	
	public void openHtmlFile() throws Exception {

//		File htmlFile = new File(Consts.HTML_FILE_FOR_PRINT);
//
//		try {
//			if (htmlFile.exists()) {
//				Desktop.getDesktop().open(htmlFile);
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		try {
			// 파일 열기
			File htmlFile = new File(Consts.HTML_FILE_FOR_PRINT);
System.out.println(htmlFile.getAbsolutePath());
			new ProcessBuilder("cmd", "/c", htmlFile.getAbsolutePath()).start();
		} catch (IOException e1) {
			throw new Exception(e1.getMessage());
//			Utilities.showErrorMsg(getShell(), e1.getMessage());
		}
		
//		try {
//			Runtime.getRuntime().exec("ie.exe ../conf/print.html");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			// 파일 열기
//			new ProcessBuilder("cmd", "/c", "../conf/print.html").start();
//		} catch (IOException e1) {
//			e1.printStackTrace();
//		}
	}
//	public boolean isStringLong(String s) {
//	    try {
//	        Long.parseLong(s);
//	        return true;
//	    } catch (NumberFormatException e) {
//	        return false;
//	    }
//	  }
}
