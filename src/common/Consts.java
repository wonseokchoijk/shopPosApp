package common;

public class Consts {

	public final static String TITLE = "ELIM Management System 2.0";	// ���α׷� �̸�

	public final static String CONF_PATH = "../conf/";

	public final static String PROPERTIES_FILE = CONF_PATH + "conf.properties";

	public final static String HTML_FILE_FOR_PRINT = CONF_PATH + "print.html";
	// 분류 상품
	public final static int BUNRYU_GOODS = 1;
	// 분류 지출
	public final static int BUNRYU_JICHUL = 2;
	// 분류 수입
	public final static int BUNRYU_SUIB = 3;
	// 현재 연도에서 최소한 이 연도까지 표시.
	public final static int STANDARD_YEAR = 2012;

	public final static String DB_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

//	public final static String SLASH_DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	public final static String SLASH_DATE_FORMAT = "yyyy/MM/dd";

//	public final static String KOREAN_DATE_FORMAT = "yyyy년 MM월 dd일  HH시 mm분 ss초";
	public final static String KOREAN_DATE_FORMAT = "yyyy년 MM월 dd일 ";
}
