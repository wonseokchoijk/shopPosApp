package views;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import service.GoodsListService;
import service.PeriodTotalService;
import service.Properties;
import service.SellGoodsService;
import bean.ColorMstBean;
import bean.GoodsListBean;
import bean.KindMstBean;
import bean.PeriodTotalBean;
import com.cloudgarden.resource.SWTResourceManager;
import common.Consts;
import common.Utilities;
import dao.ColorMstDao;
import dao.GoodsListDao;
import dao.GoodsListSearchKeywordsDto;
import dao.KindMstDao;
import dao.PeriodTotalSearchKeywordDto;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Main extends org.eclipse.swt.widgets.Composite {

	private boolean getup = false; // 첫 기동 성공시 true.실패시 첫 실행 false.에러 발생시 화면 안 띄우도록.

	private Main mainObject = null;
	private Menu menu1;
	private TableColumn goodsListSellHopePriceTableColumn;
	private Label GoodsListSearchInfo;
	private Button goodsListSearchClearButton;
	private Button goodsListSearchButton;
	private Combo goodsListSearchBuyFromDateMonthCombo;
	private Combo goodsListSearchBuyFromDateDayCombo;
	private Label goodsListSearchBuyFromDateYearLabel;
	private Label goodsListSearchBuyFromDateMonthLabel;
	private Label goodsListSearchBuyFromDateDayLabel;
	private Combo goodsListSearchBuyFromDateYearCombo;
	private Label goodsListSearchBuyFromDateTitle;
	private Combo goodsListSearchBuyToDateMonthCombo;
	private Combo goodsListSearchBuyToDateDayCombo;
	private Label goodsListSearchBuyToDateYearLabel;
	private Label goodsListSearchBuyToDateMonthLabel;
	private Label goodsListSearchBuyToDateDayLabel;
	private Combo goodsListSearchBuyToDateYearCombo;
	private Label periodTotalSearchAreaMonthLabel;

	private Text goodsListSearchMemoText;
	private Button periodTotalJichulCheckBox;
	private Button periodTotalSuibCheckBox;
	private Button periodTotalSellGoodsCheckBox;
	private Button periodTotalBunryuBuyGoodsCheckBox;
	private Label periodTotalInfoLabel;
	private Button periodTotalAddJichul;
	private Button periodTotalAddSuib;
	private Button periodTotalAddGoods;
	private Composite periodTotalSearchArea;
	private Button goodsListAddGoodsButton;
	private Label sellGoodsTotalInfoNumValueLabel;
	private Label sellGoodsTotalInfoNumLabel;
	private Label sellGoodsTotalPrice2Label;
	private Composite sellGoodsTotalPriceAreaComposite;
	private Label sellGoodsTotalPriceLabel;
	private Button sellGoodsEraseAllButton;
	private Label sellGoodsInfoLabel;
	private Button sellGoodsConfirmButton;
//	private Button sellGoodsBarcodeButton;
//	private Text sellGoodsBarcodeText;
//	private Label sellGoodsBarcodeLabel;
	private Composite sellGoodsInputAreaComposite;
	private Button sellGoodsNoButton;
	private Text sellGoodsNoText;
	private Label sellGoodsNoLabel;
	private Table sellGoodsTable;
	private Composite sellGoodsComposite;
	private CTabItem sellGoods;
	private Label goodsListSearchMemoTitle;
	private Table periodTotalTable;
	private Composite periodTotalComposite;
	private CTabItem periodTotalTab;
	private Combo goodsListSearchColorCombo;
	private Label goodsListSearchColorTitle;
	private Label goodsListSearchKindTitle;
	private Combo goodsListSearchKindCombo;
	private Label goodsListSearchGoodNameTitle;
	private Text goodsListSearchGoodsNameText;
	private Label goodsListSearchGoodNoTitle;
	private Text goodsListSearchGoodsNoText;
	private Label goodsListSearchAreaTitle;
	private Label goodsInfoModifyInfoText;
	private Label periodTotalFromDateTitle;
	private Combo periodTotalFromDateYearCombo;
	private Label periodTotalFromDateYearLabel;
	private Combo periodTotalFromDateMonthCombo;
	private Label periodTotalFromDateMonthLabel;
	private Combo periodTotalFromDateDayCombo;
	private Label periodTotalFromDateDayLabel;
	private Combo periodTotalToDateYearCombo;
	private Label periodTotalToDateYearLabel;
	private Combo periodTotalToDateMonthCombo;
	private Label periodTotalToDateMonthLabel;
	private Combo periodTotalToDateDayCombo;
	private Label periodTotalToDateDayLabel;
	private TableColumn goodsListBuyDateTableColumn;
	private TableColumn goodsListMemoTableColumn;
	private TableColumn goodsListPlaceTableColumn;
	private TableColumn goodsListBuyPriceTableColumn;
	private TableColumn goodsListColorTableColumn;
	private TableColumn goodsListNoTableColumn;
	private TableColumn goodsListNameTableColumn;
	private TableColumn goodsListKindTableColumn;
	private TableColumn sellGoodsBuyDateTableColumn;
	private TableColumn sellGoodsMemoTableColumn;
	private TableColumn sellGoodsSellHopePriceTableColumn;
	private TableColumn sellGoodsSellPriceTableColumn;
	private TableColumn sellGoodsPlaceTableColumn;
	private TableColumn sellGoodsBuyPriceTableColumn;
	private TableColumn sellGoodsColorTableColumn;
	private TableColumn sellGoodsNoTableColumn;
	private TableColumn sellGoodsNameTableColumn;
	private TableColumn sellGoodsKindTableColumn;
	private TableColumn periodTotalNoTableColumn;
	private TableColumn periodTotalNameTableColumn;
	private TableColumn periodTotalKindTableColumn;
	private TableColumn periodTotalColorTableColumn;
	private TableColumn periodTotalMemoTableColumn;
	private TableColumn periodTotalBuyPriceTableColumn;
	private TableColumn periodTotalSellPriceTableColumn;
	private TableColumn periodTotalPlaceTableColumn;
	private TableColumn periodTotalBuyDateTableColumn;
	private TableColumn periodTotalBunryuTableColumn;
	private TableItem tableItem;
	private Table goodsListTable;
	private Composite goodsListSearchArea;
	private Composite goodListComposite;
	private CTabItem goodListTab;
	private CTabFolder tabList;
	private MenuItem aboutMenuItem;
	private Menu helpMenu;
	private MenuItem helpMenuItem;
	private Label periodTotalSearchGoodNoTitle;
	private Text periodTotalSearchGoodsNoText;
	private Label periodTotalSearchGoodNameTitle;
	private Text periodTotalSearchGoodsNameText;
	private Label periodTotalSearchKindTitle;
	private Button periodTotalPrintButton;
	private Button goodsListOpenBrowserButton;
	private TableColumn sellDateTableColumn;
	private Label periodTotalMagineValueLabel;
	private Label periodTotalMagineLabel;
	private Label periodTotalJichulTotalValueLabel;
	private Label periodTotalJichulTotalLabel;
	private Label periodTotalSuibTotalValueLabel;
	private Label periodTotalSuibTotalLabel;
	private Label goodsListTotalInfoTotalMagineLabel;
	private Label goodsListTotalInfoSellHopePriceTotalValueLabel;
	private Label goodsListTotalInfoSellHopePriceTotalLabel;
	private Label goodsListTotalInfoBuyPriceTotalValueLabel;
	private Label goodsListTotalInfoBuyPriceTotalLabel;
	private Label goodsListTotalInfoGoodsNumValueLabel;
	private Label goodsListTotalInfoGoodsNumLabel;
	private Label goodsListTotalInfoTotalMagineValueLabel;
	private Composite goodsListTotalInfo;
	private Label preferenceKindInfoLabel;
	private Composite preferenceKindComponent;
	private Label preferenceKindLabel;
	private TableColumn preferenceKindTableButtonColumn;
	private Table preferenceKindTable;
	private Composite preferenceComponent;
	private CTabItem preferenceTab;
	private Button periodTotalSearchButton;
	private Button periodTotalSearchEraseAllButton;
	private Combo periodTotalSearchKindCombo;
	private Label periodTotalSearchColorTitle;
	private Combo periodTotalSearchColorCombo;
	private Label periodTotalSearchMemoTitle;
	private Text periodTotalSearchMemoText;
	private Composite preferenceColorComponent;
	private Label preferenceColorLabel;
	private Table preferenceColorTable;
	private TableColumn preferenceColorTableButtonColumn;
	private Label preferenceColorInfoLabel;
	
	
	
	
	private Utilities util = new Utilities();
	GoodsListService goodsListService = new GoodsListService();
	SellGoodsService sellGoodsService = new SellGoodsService();
	PeriodTotalService periodTotalService = new PeriodTotalService();

	GoodsListSearchKeywordsDto goodsListSearchKeywordsDto = new GoodsListSearchKeywordsDto();
	PeriodTotalSearchKeywordDto periodTotalSearchKeywordDto = new PeriodTotalSearchKeywordDto();
	
	private String tab01name = "\uc0c1\ud488\ud310\ub9e4     ";
	private String tab02name = "\ud604\uc7ac \ubcf4\uc720\uc0c1\ud488 \ub9ac\uc2a4\ud2b8";
	private String tab03name = "\uc0c1\ud488, \uc9c0\ucd9c, \uc18c\ub4dd \ub4f1\ub85d \ubc0f \uc5f4\ub78c";


	// 현재 연도
	int thisYear = 0;
	int thisMonth = 1;
	int thisDay = 1;
	int[] aMonthAgoYearMonthDay;
	{
		//Register as a resource user - SWTResourceManager will
		//handle the obtaining and disposing of resources
		SWTResourceManager.registerResourceUser(this);
	}

	public Main(Composite parent, int style) {
		super(parent, style);
		// 설정파일 읽어들임
		Properties.init();

		this.thisYear = util.getThisYear();		// 현재 연도 취득
		this.thisMonth = util.getThisMonth();
		this.thisDay = util.getThisDay();
		this.mainObject = this;
		aMonthAgoYearMonthDay = util.getAMonthAgoYearMonthDay(thisYear, thisMonth, thisDay);

		initGUI();
	}

	/**
	* Initializes the GUI.
	*/
	private void initGUI() {
		try {
			this.setSize(1010, 500);
			this.setBackground(SWTResourceManager.getColor(192, 192, 192));
			this.setLayout(null);
			this.setOrientation(SWT.HORIZONTAL);
			this.setForeground(SWTResourceManager.getColor(176, 191, 148));
			{
				menu1 = new Menu(getShell(), SWT.BAR);
				getShell().setMenuBar(menu1);
//				{
//					fileMenuItem = new MenuItem(menu1, SWT.CASCADE);
//					fileMenuItem.setText("기능");
//					{
//						fileMenu = new Menu(fileMenuItem);
//						{
//							openFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							openFileMenuItem.setText("Open");
//						}
//						{
//							newFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							newFileMenuItem.setText("New");
//						}
//						{
//							saveFileMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							saveFileMenuItem.setText("Save");
//						}
//						{
//							exitMenuItem = new MenuItem(fileMenu, SWT.CASCADE);
//							exitMenuItem.setText("프로그램 닫기");
//						}
//						fileMenuItem.setMenu(fileMenu);
//					}
//				}
				{
					helpMenuItem = new MenuItem(menu1, SWT.CASCADE);
					helpMenuItem.setText("프로그램 정보");
					{
						helpMenu = new Menu(helpMenuItem);
						{
							aboutMenuItem = new MenuItem(helpMenu, SWT.CASCADE);
							aboutMenuItem.setText("이 프로그램에 대해서");
							aboutMenuItem.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
									MessageBox box = new MessageBox(getShell(), SWT.ICON_INFORMATION);
									box.setText(Consts.TITLE);
									box.setMessage(Consts.TITLE + "\n\n제작자: 최원석\n2012년 2월 〜 2012년 4월 제작 Ver1.0\n2013년 1월 17일 Ver1.0b 상품리스트 정렬 에러 버그 수정\n2014년12월  6일 Ver1.5 구입날짜,판매날짜,수입날짜,지출날짜 직접 입력 가능하도록 수정\n" +
											"2014년 12월 9일〜2014년 12월 13일  Ver2.0 재고리스트, 상품지출소득 리스트 브라우저 출력기능 추가, 배경디자인 수정");
									box.open();
								}
							});
						}
						helpMenuItem.setMenu(helpMenu);
					}
				}
			}
			{
				tabList = new CTabFolder(this, SWT.NONE);
				tabList.setBounds(1, 0, 1010, 500);
				// ###################### 상품판매 입력 탭 #########################
				{
					sellGoods = new CTabItem(tabList, SWT.NONE);
					sellGoods.setText("\uc0c1\ud488\ud310\ub9e4      ");
					sellGoods.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
					{
						sellGoodsComposite = new Composite(tabList, SWT.NONE);
						sellGoods.setControl(sellGoodsComposite);
						sellGoodsComposite.setLayout(null);
						sellGoodsComposite.setBackgroundMode( SWT.INHERIT_DEFAULT );
						sellGoodsComposite.setBackgroundImage(SWTResourceManager.getImage("wallpaper.jpg"));
						{
							sellGoodsTable = new Table(sellGoodsComposite, SWT.NONE);
							sellGoodsTable.setBounds(14, 109, 982, 299);
							sellGoodsTable.setHeaderVisible(true);
							sellGoodsTable.setLinesVisible(true);
							sellGoodsTable.addListener(SWT.MouseDoubleClick, new Listener() {	// 상품판매 입력 리스트 더블클릭시 해당 상품 삭제.
								public void handleEvent(Event e) {
									if (e.x > sellGoodsNoTableColumn.getWidth()) {
										return;
									}
									Point pt = new Point(20, e.y);
									TableItem selection = sellGoodsTable.getItem(pt);
									if (selection != null) {
										String selectedId = selection.getText();	// ID취득
							
							
//							sellGoodsTable.addMouseListener(new MouseAdapter() {	// 상품판매 입력 리스트 더블클릭시 해당 상품 삭제.
//								public void mouseDoubleClick(MouseEvent evt) {
//									TableItem[] selection = sellGoodsTable.getSelection();
//									if (selection != null && selection.length > 0) {
//										String selectedId = selection[0].getText();	// ID취득
										sellGoodsService.deleteThisGoods(Long.valueOf(selectedId));
										sellGoodsNoAddDatas();
									}
									sellGoodsNoText.setFocus();
								}
							});
							{
								sellGoodsNoTableColumn = new TableColumn(sellGoodsTable, SWT.RIGHT);
								sellGoodsNoTableColumn.setText("\uc0c1\ud488No.");
								sellGoodsNoTableColumn.setWidth(72);
							}
							{
								sellGoodsNameTableColumn = new TableColumn(sellGoodsTable, SWT.LEFT);
								sellGoodsNameTableColumn.setText("\uc0c1\ud488\uba85");
								sellGoodsNameTableColumn.setWidth(135);
								sellGoodsNameTableColumn.setMoveable(true);
							}
							{
								sellGoodsKindTableColumn = new TableColumn(sellGoodsTable, SWT.LEFT);
								sellGoodsKindTableColumn.setText("\uc0c1\ud488\uc885\ub958");
								sellGoodsKindTableColumn.setWidth(82);
							}
							{
								sellGoodsColorTableColumn = new TableColumn(sellGoodsTable, SWT.CENTER);
								sellGoodsColorTableColumn.setText("\uc0c9\uc0c1");
								sellGoodsColorTableColumn.setWidth(60);
							}
							{
								sellGoodsMemoTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
								sellGoodsMemoTableColumn.setText("\uba54\ubaa8");
								sellGoodsMemoTableColumn.setWidth(113);
							}
							{
								sellGoodsBuyPriceTableColumn = new TableColumn(sellGoodsTable, SWT.RIGHT);
								sellGoodsBuyPriceTableColumn.setText("\uad6c\uc785\uac00");
								sellGoodsBuyPriceTableColumn.setWidth(82);
							}
							{
								sellGoodsSellHopePriceTableColumn = new TableColumn(sellGoodsTable, SWT.RIGHT);
								sellGoodsSellHopePriceTableColumn.setText("\ud310\ub9e4\uc608\uc815\uac00");
								sellGoodsSellHopePriceTableColumn.setWidth(83);
							}
							{
								sellGoodsSellPriceTableColumn = new TableColumn(sellGoodsTable, SWT.RIGHT);
								sellGoodsSellPriceTableColumn.setText("\ud310\ub9e4\uac00");
								sellGoodsSellPriceTableColumn.setWidth(83);
							}
							{
								sellGoodsPlaceTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
								sellGoodsPlaceTableColumn.setText("\uad6c\uc785\ucc98");
								sellGoodsPlaceTableColumn.setWidth(82);
							}
							{
								sellGoodsBuyDateTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
								sellGoodsBuyDateTableColumn.setText("\uad6c\uc785\ub0a0\uc9dc");
								sellGoodsBuyDateTableColumn.setWidth(81);
							}
							{
								sellDateTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
								sellDateTableColumn.setText("\ud310\ub9e4\ub0a0\uc9dc");
								sellDateTableColumn.setWidth(87);
							}
//							{
//								sellGoodsSellDateTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
//								sellGoodsSellDateTableColumn.setText("\ud310\ub9e4\ub0a0\uc9dc");
//								sellGoodsSellDateTableColumn.setWidth(91);
//							}
//							{
//								sellGoodsBarCodeTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
//								sellGoodsBarCodeTableColumn.setText("\ubc14\ucf54\ub4dc");
//								sellGoodsBarCodeTableColumn.setWidth(65);
//							}
						}
						{
							sellGoodsInputAreaComposite = new Composite(sellGoodsComposite, SWT.BORDER);
							sellGoodsInputAreaComposite.setLayout(null);
							sellGoodsInputAreaComposite.setBounds(13, 12, 711, 62);
//							sellGoodsInputAreaComposite.setBackground(SWTResourceManager.getColor(211, 213, 174));
							{
								sellGoodsNoLabel = new Label(sellGoodsInputAreaComposite, SWT.RIGHT);
								sellGoodsNoLabel.setText("\ud310\ub9e4\uc0c1\ud488 No. \uc785\ub825 :");
								sellGoodsNoLabel.setBounds(33, 19, 174, 25);
								sellGoodsNoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 1, false, false));
//								sellGoodsNoLabel.setBackground(sellGoodsInputAreaComposite.getBackground());
								sellGoodsNoLabel.setEnabled(true);
							}
							{
								sellGoodsNoText = new Text(sellGoodsInputAreaComposite, SWT.NONE);
								sellGoodsNoText.setBounds(219, 15, 203, 30);
								sellGoodsNoText.setFont(SWTResourceManager.getFont("Lucida Grande", 22, 0, false, false));
								sellGoodsNoText.setFocus();
								sellGoodsNoText.addVerifyListener(new VerifyListener() {
									public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
										evt.doit = evt.text.matches("[0-9]*");
									}
								});
								sellGoodsNoText.addListener(SWT.DefaultSelection, new Listener() {
									public void handleEvent(Event e) {
										sellGoodsNoButtonMouseUp();
										sellGoodsNoText.setFocus();
									}
								});
							}
							{
								sellGoodsNoButton = new Button(sellGoodsInputAreaComposite, SWT.PUSH | SWT.CENTER);
								sellGoodsNoButton.setText("\uc774 No.\uc0c1\ud488 \ud310\ub9e4");
								sellGoodsNoButton.setBounds(429, 9, 178, 41);
								sellGoodsNoButton.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
								sellGoodsNoButton.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										sellGoodsNoButtonMouseUp();
										sellGoodsNoText.setFocus();
									}
								});
							}
//							{
//								sellGoodsBarcodeLabel = new Label(sellGoodsInputAreaComposite, SWT.RIGHT);
//								sellGoodsBarcodeLabel.setText("\ud310\ub9e4\uc0c1\ud488 \ubc14\ucf54\ub4dc \uc785\ub825 : ");
//								sellGoodsBarcodeLabel.setBounds(23, 77, 203, 26);
//								sellGoodsBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 18, 0, false, false));
//							}
//							{
//								sellGoodsBarcodeText = new Text(sellGoodsInputAreaComposite, SWT.NONE);
//								sellGoodsBarcodeText.setBounds(238, 75, 262, 30);
//								sellGoodsBarcodeText.setFont(SWTResourceManager.getFont("Lucida Grande", 26, 0, false, false));
//							}
//							{
//								sellGoodsBarcodeButton = new Button(sellGoodsInputAreaComposite, SWT.PUSH | SWT.CENTER);
//								sellGoodsBarcodeButton.setText("\uc774 \ubc14\ucf54\ub4dc \uc0c1\ud488 \ud310\ub9e4");
//								sellGoodsBarcodeButton.setBounds(506, 70, 178, 41);
//								sellGoodsBarcodeButton.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//							}
						}
						{
							sellGoodsConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
							sellGoodsConfirmButton.setText("\uc774 \ud310\ub9e4 \ub9ac\uc2a4\ud2b8 \ud655\uc815");
							sellGoodsConfirmButton.setBounds(772, 13, 213, 44);
							sellGoodsConfirmButton.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
							sellGoodsConfirmButton.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									sellGoodsConfirmButtonMouseUp(evt);
								}
							});
						}
						{
							sellGoodsInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
							sellGoodsInfoLabel.setText("\uc544\ub798 \ub9ac\uc2a4\ud2b8\uc5d0 \ucd94\uac00\ub41c \uc0c1\ud488 \ud55c\uac00\uc9c0\ub9cc\uc744 \uc0ad\uc81c\ud558\uace0 \uc2f6\uc744 \ub54c\uc5d0\ub294 \ud574\ub2f9 \uc0c1\ud488\uc758 No.\uc744 \ub354\ube14\ud074\ub9ad\ud558\uc2ed\uc2dc\uc624.");
							sellGoodsInfoLabel.setBounds(12, 86, 638, 20);
						}
						{
							sellGoodsEraseAllButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
							sellGoodsEraseAllButton.setText("\uc704 \ub9ac\uc2a4\ud2b8 \uc804\ubd80 \uc0ad\uc81c");
							sellGoodsEraseAllButton.setBounds(14, 415, 169, 30);
							sellGoodsEraseAllButton.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									if (sellGoodsService.getSellGoodsList().size() < 1) {
										util.showMsg(getShell(), "판매리스트에 등록된 상품이 없습니다.");
									} else {
										int response = util.showYesOrNoMsgBox(getShell(), "이 판매리스트를 전부 삭제하시겠습니까?");
										if (response == SWT.YES) {
											sellGoodsService.deleteAllThisGoods();
											sellGoodsNoAddDatas();
										}
									}
									sellGoodsNoText.setFocus();
								}
							});
						}
						{
							sellGoodsTotalInfoNumLabel = new Label(sellGoodsComposite, SWT.NONE);
							sellGoodsTotalInfoNumLabel.setText("\ucd1d \uc0c1\ud488\uac2f\uc218 : ");
							sellGoodsTotalInfoNumLabel.setBounds(313, 420, 85, 20);
						}
						{
							sellGoodsTotalInfoNumValueLabel = new Label(sellGoodsComposite, SWT.RIGHT);
							sellGoodsTotalInfoNumValueLabel.setText("0 \uac1c");
							sellGoodsTotalInfoNumValueLabel.setBounds(404, 420, 60, 20);
						}
						{
							sellGoodsTotalPriceAreaComposite = new Composite(sellGoodsComposite, SWT.BORDER);
							sellGoodsTotalPriceAreaComposite.setLayout(null);
							sellGoodsTotalPriceAreaComposite.setBounds(594, 420, 403, 38);
							sellGoodsTotalPriceAreaComposite.setBackground(SWTResourceManager.getColor(255, 216, 213));
							sellGoodsTotalPriceAreaComposite.setEnabled(false);
							{
								sellGoodsTotalPriceLabel = new Label(sellGoodsTotalPriceAreaComposite, SWT.NONE);
								sellGoodsTotalPriceLabel.setText("\ud310\ub9e4\uac00\uaca9  \ud569\uacc4 :");
								sellGoodsTotalPriceLabel.setBounds(12, 5, 165, 30);
								sellGoodsTotalPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 1, false, false));
								sellGoodsTotalPriceLabel.setBackground(SWTResourceManager.getColor(255, 216, 213));
							}
							{
								sellGoodsTotalPrice2Label = new Label(sellGoodsTotalPriceAreaComposite, SWT.RIGHT);
								sellGoodsTotalPrice2Label.setBounds(140, 5, 235, 30);
								sellGoodsTotalPrice2Label.setText("0 \uc6d0");
								sellGoodsTotalPrice2Label.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 1, false, false));
								sellGoodsTotalPrice2Label.setBackground(SWTResourceManager.getColor(255, 216, 213));
							}
						}
					}
				}
				// ####################### 현재 보유상품 리스트 탭 ###########################
				{
					goodListTab = new CTabItem(tabList, SWT.NONE);
					goodListTab.setText("\uc7ac\uace0 \ub9ac\uc2a4\ud2b8    ");
					goodListTab.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
					{
						goodListComposite = new Composite(tabList, SWT.NONE);
						goodListComposite.setBackgroundMode( SWT.INHERIT_DEFAULT );
						goodListTab.setControl(goodListComposite);
						goodListComposite.setLayout(null);
						goodListComposite.setBackgroundImage(SWTResourceManager.getImage("wallpaper.jpg"));
						{
							goodsListSearchArea = new Composite(goodListComposite, SWT.BORDER);
							goodsListSearchArea.setLayout(null);
							goodsListSearchArea.setBounds(13, 10, 986, 116);
//							goodsListSearchArea.setBackground(SWTResourceManager.getColor(211, 213, 174));
							{
								goodsListSearchAreaTitle = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchAreaTitle.setText("\ud604\uc7ac \ubcf4\uc720 \uc0c1\ud488 \uac80\uc0c9");
								goodsListSearchAreaTitle.setBounds(1, 2, 259, 22);
								goodsListSearchAreaTitle.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//								goodsListSearchAreaTitle.setBackground(goodsListSearchArea.getBackground());
							}
							// ----------------------------------------------------- No. 검색폼
							{
								goodsListSearchGoodNoTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchGoodNoTitle.setText("\uc0c1\ud488No.");
								goodsListSearchGoodNoTitle.setBounds(11, 25, 55, 18);
								goodsListSearchGoodNoTitle.setOrientation(SWT.HORIZONTAL);
								goodsListSearchGoodNoTitle.setToolTipText("No.\ub85c \uac80\uc0c9. \uc22b\uc790\ub9cc \uc785\ub825\uac00\ub2a5\ud569\ub2c8\ub2e4.");
//								goodsListSearchGoodNoTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchGoodsNoText = new Text(goodsListSearchArea, SWT.NONE);
								goodsListSearchGoodsNoText.setBounds(70, 22, 111, 19);
								goodsListSearchGoodsNoText.setToolTipText("No.\ub85c \uac80\uc0c9. \uc22b\uc790\ub9cc \uc785\ub825\uac00\ub2a5\ud569\ub2c8\ub2e4.");
								goodsListSearchGoodsNoText.setTextLimit(19);
								goodsListSearchGoodsNoText.addVerifyListener(new VerifyListener() {
									public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
										evt.doit = evt.text.matches("[0-9]*");
									}
								});
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 상품명 검색폼
							{
								goodsListSearchGoodNameTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchGoodNameTitle.setText("\uc0c1\ud488\uba85");
								goodsListSearchGoodNameTitle.setBounds(19, 50, 44, 17);
								goodsListSearchGoodNameTitle.setOrientation(SWT.HORIZONTAL);
								goodsListSearchGoodNameTitle.setToolTipText("\uc77c\ubd80 \ub2e8\uc5b4\ub85c\ub3c4 \uac80\uc0c9 \uac00\ub2a5. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ub2e8\uc5b4\uac00 \ubaa8\ub450 \ub4e4\uc5b4\uac00\uc788\ub294 \uc0c1\ud488\uba85\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
//								goodsListSearchGoodNameTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchGoodsNameText = new Text(goodsListSearchArea, SWT.NONE);
								goodsListSearchGoodsNameText.setBounds(70, 48, 233, 19);
								goodsListSearchGoodsNameText.setToolTipText("\uc77c\ubd80 \ub2e8\uc5b4\ub85c\ub3c4 \uac80\uc0c9 \uac00\ub2a5. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ub2e8\uc5b4\uac00 \ubaa8\ub450 \ub4e4\uc5b4\uc788\ub294 \uc0c1\ud488\uba85\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
								goodsListSearchGoodsNameText.setTextLimit(255);
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 상품종류 드롭다운
							{
								goodsListSearchKindTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchKindTitle.setText("\uc0c1\ud488\uc885\ub958");
								goodsListSearchKindTitle.setBounds(10, 74, 54, 17);
								goodsListSearchKindTitle.setToolTipText("\uc0c1\ud488\uc885\ub958\ub85c \uac80\uc0c9");
//								goodsListSearchKindTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchKindCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchKindCombo.setBounds(70, 71, 233, 25);
								goodsListSearchKindCombo.setToolTipText("\uc0c1\ud488\uc885\ub958\ub85c \uac80\uc0c9");
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 색상 드롭다운
							{
								goodsListSearchColorTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchColorTitle.setText("\uc0c9\uc0c1");
								goodsListSearchColorTitle.setBounds(343, 13, 32, 19);
								goodsListSearchColorTitle.setToolTipText("\uc0c1\ud488 \uc0c9\uc0c1\uc73c\ub85c \uac80\uc0c9");
//								goodsListSearchColorTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchColorCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchColorCombo.setBounds(381, 9, 231, 25);
								goodsListSearchColorCombo.setToolTipText("\uc0c1\ud488 \uc0c9\uc0c1\uc73c\ub85c \uac80\uc0c9");
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 메모
							{
								goodsListSearchMemoTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchMemoTitle.setText("\uba54\ubaa8");
								goodsListSearchMemoTitle.setBounds(667, 13, 32, 19);
								goodsListSearchMemoTitle.setToolTipText("\uba54\ubaa8\uc758 \uc77c\ubd80 \ub2e8\uc5b4\ub85c \uac80\uc0c9. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ubaa8\ub4e0 \ub2e8\uc5b4\ub97c \ud3ec\ud568\ud558\ub294 \uba54\ubaa8\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
//								goodsListSearchMemoTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchMemoText = new Text(goodsListSearchArea, SWT.NONE);
								goodsListSearchMemoText.setBounds(711, 12, 263, 19);
								goodsListSearchMemoText.setToolTipText("\uba54\ubaa8\uc758 \uc77c\ubd80 \ub2e8\uc5b4\ub85c \uac80\uc0c9. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ubaa8\ub4e0 \ub2e8\uc5b4\ub97c \ud3ec\ud568\ud558\ub294 \uba54\ubaa8\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
								goodsListSearchMemoText.setTextLimit(500);
							}
							// ----------------------------------------------------------------
							// ------------------------------------------------------ 구입날짜from
							{
								goodsListSearchBuyFromDateTitle = new Label(goodsListSearchArea, SWT.RIGHT);
								goodsListSearchBuyFromDateTitle.setText("\uad6c\uc785\ub0a0\uc9dc");
								goodsListSearchBuyFromDateTitle.setBounds(322, 43, 53, 19);
								goodsListSearchBuyFromDateTitle.setToolTipText("\uac80\uc0c9\ud558\uace0 \uc2f6\uc740 \uad6c\uc785\ub0a0\uc9dc \ubc94\uc704\ub97c \uc9c0\uc815. '\ubd80\ud130'\ub97c \uc9c0\uc815 \uc548\ud558\uba74 \ucd5c\ucd08\uc758 \ub0a0\uc9dc\ubd80\ud130. '\uae4c\uc9c0'\ub97c \uc9c0\uc815 \uc548\ud558\uba74 \ub9c8\uc9c0\ub9c9 \ub0a0\uc9dc\uae4c\uc9c0\ub97c \uac80\uc0c9.");
//								goodsListSearchBuyFromDateTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchBuyFromDateYearCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyFromDateYearCombo.setBounds(382, 41, 71, 22);
								goodsListSearchBuyFromDateYearCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(goodsListSearchBuyFromDateYearCombo, goodsListSearchBuyFromDateMonthCombo, goodsListSearchBuyFromDateDayCombo, true);
									}
								});
								goodsListSearchBuyFromDateYearCombo.add("");

								// 현재 연도에서 2012까지 표시
								for (int i = this.thisYear + 1; i >= Consts.STANDARD_YEAR; i--) {
									goodsListSearchBuyFromDateYearCombo.add(String.valueOf(i));
								}
							}
							{
								goodsListSearchBuyFromDateYearLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyFromDateYearLabel.setText("\ub144");
								goodsListSearchBuyFromDateYearLabel.setBounds(455, 43, 21, 18);
//								goodsListSearchBuyFromDateYearLabel.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchBuyFromDateMonthCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyFromDateMonthCombo.setBounds(476, 41, 54, 22);
								goodsListSearchBuyFromDateMonthCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(goodsListSearchBuyFromDateYearCombo, goodsListSearchBuyFromDateMonthCombo, goodsListSearchBuyFromDateDayCombo, true);
									}
								});
								goodsListSearchBuyFromDateMonthCombo.add("");
							}
							{
								goodsListSearchBuyFromDateMonthLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyFromDateMonthLabel.setText("\uc6d4");
								goodsListSearchBuyFromDateMonthLabel.setBounds(533, 43, 21, 18);
//								goodsListSearchBuyFromDateMonthLabel.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchBuyFromDateDayCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyFromDateDayCombo.setBounds(554, 41, 54, 22);
								goodsListSearchBuyFromDateDayCombo.setToolTipText("\uc77c\uc790\uac00 \ud45c\uc2dc\ub418\uc9c0 \uc54a\uc744 \ub54c\uc5d0\ub294 \uc5f0\ub3c4\uc640 \uc6d4\uc744 \uba3c\uc800 \uc120\ud0dd\ud558\uc2ed\uc2dc\uc624.");
								goodsListSearchBuyFromDateDayCombo.add("");
							}
							{
								goodsListSearchBuyFromDateDayLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyFromDateDayLabel.setText("\uc77c   \uc5d0\uc11c");
								goodsListSearchBuyFromDateDayLabel.setBounds(610, 43, 57, 18);
//								goodsListSearchBuyFromDateDayLabel.setBackground(goodsListSearchArea.getBackground());
							}
							// ----------------------------------------------------------------
							// ------------------------------------------------------ 구입날짜To
							{
								goodsListSearchBuyToDateYearCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyToDateYearCombo.setBounds(671, 41, 71, 22);
								goodsListSearchBuyToDateYearCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(goodsListSearchBuyToDateYearCombo, goodsListSearchBuyToDateMonthCombo, goodsListSearchBuyToDateDayCombo, true);
									}
								});
								goodsListSearchBuyToDateYearCombo.add("");
								// 현재 연도에서 2012까지 표시
								for (int i = this.thisYear + 1; i >= Consts.STANDARD_YEAR; i--) {
									goodsListSearchBuyToDateYearCombo.add(String.valueOf(i));
								}
							}
							{
								goodsListSearchBuyToDateYearLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyToDateYearLabel.setText("\ub144");
								goodsListSearchBuyToDateYearLabel.setBounds(745, 43, 21, 18);
//								goodsListSearchBuyToDateYearLabel.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchBuyToDateMonthCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyToDateMonthCombo.setBounds(766, 41, 54, 22);
								goodsListSearchBuyToDateMonthCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(goodsListSearchBuyToDateYearCombo, goodsListSearchBuyToDateMonthCombo, goodsListSearchBuyToDateDayCombo, true);
									}
								});
								goodsListSearchBuyToDateMonthCombo.add("");
							}
							{
								goodsListSearchBuyToDateMonthLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyToDateMonthLabel.setText("\uc6d4");
								goodsListSearchBuyToDateMonthLabel.setBounds(823, 43, 18, 18);
//								goodsListSearchBuyToDateMonthLabel.setBackground(goodsListSearchArea.getBackground());
							}
							{
								goodsListSearchBuyToDateDayCombo = new Combo(goodsListSearchArea, SWT.READ_ONLY);
								goodsListSearchBuyToDateDayCombo.setBounds(843, 41, 54, 22);
								goodsListSearchBuyToDateDayCombo.setToolTipText("\uc77c\uc790\uac00 \ud45c\uc2dc\ub418\uc9c0 \uc54a\uc744 \ub54c\uc5d0\ub294 \uc5f0\ub3c4\uc640 \uc6d4\uc744 \uba3c\uc800 \uc120\ud0dd\ud558\uc2ed\uc2dc\uc624.");
								goodsListSearchBuyToDateDayCombo.add("");
							}
							{
								goodsListSearchBuyToDateDayLabel = new Label(goodsListSearchArea, SWT.NONE);
								goodsListSearchBuyToDateDayLabel.setText("\uc77c   \uae4c\uc9c0");
								goodsListSearchBuyToDateDayLabel.setBounds(900, 43, 74, 18);
//								goodsListSearchBuyToDateDayLabel.setBackground(goodsListSearchArea.getBackground());
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 이 조건으로 검색 버튼
							{
								goodsListSearchButton = new Button(goodsListSearchArea, SWT.PUSH | SWT.CENTER);
								goodsListSearchButton.setText("\uc774 \uc870\uac74\uc73c\ub85c \uac80\uc0c9");
								goodsListSearchButton.setBounds(809, 71, 165, 37);
								goodsListSearchButton.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										goodsListSearchButtonMouseUp();
									}
								});

							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 검색조건 클리어 버튼
							{
								goodsListSearchClearButton = new Button(goodsListSearchArea, SWT.PUSH | SWT.CENTER);
								goodsListSearchClearButton.setText("\uac80\uc0c9\uc870\uac74 \ubaa8\ub450 \ud574\uc81c");
								goodsListSearchClearButton.setBounds(493, 79, 149, 29);
								goodsListSearchClearButton.setToolTipText("\uc9c0\uc815\ud55c \uac80\uc0c9\uc870\uac74\uc744 \ubaa8\ub450 \ud574\uc81c\ud569\ub2c8\ub2e4.");
								goodsListSearchClearButton.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										goodsListSearchGoodsNoText.setText("");
										goodsListSearchGoodsNameText.setText("");
										goodsListSearchKindCombo.setText("");
										goodsListSearchColorCombo.setText("");
										goodsListSearchMemoText.setText("");
										goodsListSearchBuyFromDateYearCombo.setText("");
										goodsListSearchBuyFromDateMonthCombo.setText("");
										goodsListSearchBuyFromDateDayCombo.setText("");
										goodsListSearchBuyToDateYearCombo.setText("");
										goodsListSearchBuyToDateMonthCombo.setText("");
										goodsListSearchBuyToDateDayCombo.setText("");
									}
								});
							}
							// ----------------------------------------------------------------
							// ----------------------------------------------------- 바코드로 검색 버튼
//							{
//								goodsListSearchBarcodeButton = new Button(goodsListSearchArea, SWT.PUSH | SWT.CENTER);
//								goodsListSearchBarcodeButton.setText("\ubc14\ucf54\ub4dc\ub85c \uac80\uc0c9");
//								goodsListSearchBarcodeButton.setBounds(645, 74, 152, 37);
//							}
							{
								GoodsListSearchInfo = new Label(goodsListSearchArea, SWT.NONE);
								GoodsListSearchInfo.setText("\u203b \uc544\ubb34 \uac80\uc0c9 \uc870\uac74\ub3c4 \uc9c0\uc815\ud558\uc9c0 \uc54a\uc558\uc744 \uc2dc\uc5d0\ub294 \ud604\uc7ac \ubcf4\uc720 \uc911\uc778 \ubaa8\ub4e0 \uc0c1\ud488\uc744 \ud45c\uc2dc\ud569\ub2c8\ub2e4.");
								GoodsListSearchInfo.setBounds(13, 98, 468, 17);
								GoodsListSearchInfo.setFont(SWTResourceManager.getFont("Lucida Grande", 7, 0, false, false));
//								GoodsListSearchInfo.setBackground(goodsListSearchArea.getBackground());
							}
							// ----------------------------------------------------------------
						}
						{
							goodsListTable = new Table(goodListComposite, SWT.NONE);
							goodsListTable.setBounds(12, 155, 987, 266);
							goodsListTable.setDragDetect(false);
							goodsListTable.setOrientation(SWT.HORIZONTAL);
							goodsListTable.setLinesVisible(true);
							goodsListTable.setHeaderVisible(true);
							goodsListTable.setFont(SWTResourceManager.getFont("Lucida Grande", 9, 0, false, false));

							// 테이블 더블클릭
							goodsListTable.addListener(SWT.MouseDoubleClick, new Listener() {
								public void handleEvent(Event e) {
									if (e.x > goodsListNoTableColumn.getWidth()) {
										return;
									}
									Point pt = new Point(20, e.y);
									TableItem selection = goodsListTable.getItem(pt);
									if (selection != null) {
										String selectedId = selection.getText();	// ID취득
										GoodsListDetail inst = new GoodsListDetail(getShell(), SWT.NULL);
										try {
											GoodsListBean resultBean = inst.open(mainObject, Long.valueOf(selectedId).longValue());
											// 데이터 갱신시 화면 테이블 속 표시 해당데이터 고치기.
											if (resultBean != null) {
												updateTableTopIndex();	// 원래 표시하던 TopIndex부터 테이블 표시하기.
											}
										} catch (NumberFormatException e1) {
											util.showMsg(getShell(), "숫자 변환 에러");
										} catch (SQLException e2) {
											util.showMsg(getShell(), "아이템 취득 DB 에러입니다.\n" + e2.getMessage());
										}
									}
								}
							});
							// 테이블 데이터 클릭
							goodsListTable.addSelectionListener(new SelectionAdapter() {
								public void widgetSelected(SelectionEvent evt) {
								}
							});
							{
								goodsListNoTableColumn = new TableColumn(goodsListTable, SWT.RIGHT);
								goodsListNoTableColumn.setText("\uc0c1\ud488No.");
								goodsListNoTableColumn.setWidth(73);
							}
							{
								goodsListNameTableColumn = new TableColumn(goodsListTable, SWT.LEFT);
								goodsListNameTableColumn.setText("\uc0c1\ud488\uba85");
								goodsListNameTableColumn.setWidth(183);
								goodsListNameTableColumn.setMoveable(true);
							}
							{
								goodsListKindTableColumn = new TableColumn(goodsListTable, SWT.LEFT);
								goodsListKindTableColumn.setText("\uc0c1\ud488\uc885\ub958");
								goodsListKindTableColumn.setWidth(82);
							}
							{
								goodsListColorTableColumn = new TableColumn(goodsListTable, SWT.CENTER);
								goodsListColorTableColumn.setText("\uc0c9\uc0c1");
								goodsListColorTableColumn.setWidth(71);
							}
							{
								goodsListMemoTableColumn = new TableColumn(goodsListTable, SWT.NONE);
								goodsListMemoTableColumn.setText("\uba54\ubaa8");
								goodsListMemoTableColumn.setWidth(179);
							}
							{
								goodsListBuyPriceTableColumn = new TableColumn(goodsListTable, SWT.RIGHT);
								goodsListBuyPriceTableColumn.setText("\uad6c\uc785\uac00");
								goodsListBuyPriceTableColumn.setWidth(82);
							}
							{
								goodsListSellHopePriceTableColumn = new TableColumn(goodsListTable, SWT.RIGHT);
								goodsListSellHopePriceTableColumn.setText("\ud310\ub9e4\uc608\uc815\uac00");
								goodsListSellHopePriceTableColumn.setWidth(83);
							}
							{
								goodsListPlaceTableColumn = new TableColumn(goodsListTable, SWT.NONE);
								goodsListPlaceTableColumn.setText("\uad6c\uc785\ucc98");
								goodsListPlaceTableColumn.setWidth(82);
							}
							{
								goodsListBuyDateTableColumn = new TableColumn(goodsListTable, SWT.NONE);
								goodsListBuyDateTableColumn.setText("\uad6c\uc785\ub0a0\uc9dc");
								goodsListBuyDateTableColumn.setWidth(132);
							}
//							{
//								goodsListSellDateTableColumn = new TableColumn(goodsListTable, SWT.NONE);
//								goodsListSellDateTableColumn.setText("\ud310\ub9e4\ub0a0\uc9dc");
//								goodsListSellDateTableColumn.setWidth(91);
//							}
//							{
//								goodsListBarCodeTableColumn = new TableColumn(goodsListTable, SWT.NONE);
//								goodsListBarCodeTableColumn.setText("\ubc14\ucf54\ub4dc");
//								goodsListBarCodeTableColumn.setWidth(131);
//							}

							
//goodsListTable.setTopIndex(2);

//System.out.println(goodsListTable.getTopIndex());
						}
						{
							goodsInfoModifyInfoText = new Label(goodListComposite, SWT.NONE);
							goodsInfoModifyInfoText.setText("\u203b \uc0c1\ud488 \ud310\ub9e4\uc2dc \ud639\uc740 \uc0c1\ud488 \uc815\ubcf4 \uc218\uc815\uc2dc\uc5d0\ub294 \uc544\ub798 \ud45c\uc5d0\uc11c \ud574\ub2f9 \uc0c1\ud488\uc758 No.\ub97c \ub354\ube14 \ud074\ub9ad\ud574\uc8fc\uc2ed\uc2dc\uc624.");
							goodsInfoModifyInfoText.setBounds(12, 134, 606, 16);
							goodsInfoModifyInfoText.setFont(SWTResourceManager.getFont("Lucida Grande", 10, 0, false, false));
						}
						{
							goodsListAddGoodsButton = new Button(goodListComposite, SWT.PUSH | SWT.CENTER);
							goodsListAddGoodsButton.setText("\uad6c\uc785\uc0c1\ud488 \ucd94\uac00");
							goodsListAddGoodsButton.setBounds(872, 431, 122, 35);
							goodsListAddGoodsButton.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									periodTotalAddGoodsButtonMouseUp();
								}
							});
						}
						{
							goodsListTotalInfo = new Composite(goodListComposite, SWT.NONE);
							goodsListTotalInfo.setLayout(null);
							goodsListTotalInfo.setBounds(12, 427, 751, 45);
							{
								goodsListTotalInfoGoodsNumLabel = new Label(goodsListTotalInfo, SWT.RIGHT);
								goodsListTotalInfoGoodsNumLabel.setText("\ud45c\uc2dc \uc0c1\ud488\uac2f\uc218 :");
								goodsListTotalInfoGoodsNumLabel.setBounds(-7, 0, 93, 18);
							}
							{
								goodsListTotalInfoGoodsNumValueLabel = new Label(goodsListTotalInfo, SWT.LEFT);
								goodsListTotalInfoGoodsNumValueLabel.setText("");
								goodsListTotalInfoGoodsNumValueLabel.setBounds(91, 0, 77, 18);
							}
							{
								goodsListTotalInfoBuyPriceTotalLabel = new Label(goodsListTotalInfo, SWT.RIGHT);
								goodsListTotalInfoBuyPriceTotalLabel.setText("\uad6c\uc785\uac00 \ud569\uacc4 :");
								goodsListTotalInfoBuyPriceTotalLabel.setBounds(194, 0, 104, 18);
							}
							{
								goodsListTotalInfoBuyPriceTotalValueLabel = new Label(goodsListTotalInfo, SWT.LEFT);
								goodsListTotalInfoBuyPriceTotalValueLabel.setBounds(303, 0, 137, 18);
							}
							{
								goodsListTotalInfoSellHopePriceTotalLabel = new Label(goodsListTotalInfo, SWT.RIGHT);
								goodsListTotalInfoSellHopePriceTotalLabel.setText("\ud310\ub9e4\uc608\uc815\uac00 \ud569\uacc4 :");
								goodsListTotalInfoSellHopePriceTotalLabel.setBounds(470, 0, 114, 18);
							}
							{
								goodsListTotalInfoSellHopePriceTotalValueLabel = new Label(goodsListTotalInfo, SWT.LEFT);
								goodsListTotalInfoSellHopePriceTotalValueLabel.setBounds(588, 0, 146, 18);
							}
							{
								goodsListTotalInfoTotalMagineLabel = new Label(goodsListTotalInfo, SWT.RIGHT);
								goodsListTotalInfoTotalMagineLabel.setText("\uc608\uc815\uac00 \uc774\uc724 (\ud310\ub9e4\uc608\uc815\uac00 \ud569\uacc4 - \uad6c\uc785\uac00 \ud569\uacc4) :");
								goodsListTotalInfoTotalMagineLabel.setBounds(310, 24, 274, 20);
							}
							{
								goodsListTotalInfoTotalMagineValueLabel = new Label(goodsListTotalInfo, SWT.LEFT);
								goodsListTotalInfoTotalMagineValueLabel.setBounds(588, 24, 146, 21);
							}
						}
						{
							goodsListOpenBrowserButton = new Button(goodListComposite, SWT.PUSH | SWT.CENTER);
							goodsListOpenBrowserButton.setText("\uc778\uc1c4\uc6a9\uc73c\ub85c \uc544\ub798 \uc7ac\uace0\ub9ac\uc2a4\ud2b8 \ud45c \ub0b4\uc6a9\uc744 \uc6f9\ube0c\ub77c\uc6b0\uc800\uc5d0\uc11c \uc5f4\uae30");
							goodsListOpenBrowserButton.setBounds(641, 128, 357, 23);
							goodsListOpenBrowserButton.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									if (goodsListTable != null && goodsListTable.getItemCount() != 0) {
										util.outputGoodsListHtmlFile(goodsListSearchKeywordsDto, goodsListTotalInfoBuyPriceTotalValueLabel.getText(), goodsListTotalInfoSellHopePriceTotalValueLabel.getText(), goodsListTotalInfoTotalMagineValueLabel.getText(), goodsListTable);

										try {
											util.openHtmlFile();
										} catch (Exception e) {
											util.showMsg(getShell(), e.getMessage());
										}
									} else {
										util.showMsg(getShell(), "인쇄 대상 데이터를 검색해주십시오.");
									}
								}
							});
						}
					}
				}
				// ####################### 상품, 지출, 소득 등록 및 열람 #######################
				{
					periodTotalTab = new CTabItem(tabList, SWT.NONE);
					periodTotalTab.setText(tab03name);
					periodTotalTab.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
					{
						periodTotalComposite = new Composite(tabList, SWT.NONE);
						periodTotalComposite.setLayout(null);
						periodTotalComposite.setBackgroundMode( SWT.INHERIT_DEFAULT );
						periodTotalTab.setControl(periodTotalComposite);
						periodTotalComposite.setBackgroundImage(SWTResourceManager.getImage("wallpaper.jpg"));
						{
							periodTotalSearchAreaMonthLabel = new Label(periodTotalComposite, SWT.LEFT);
							periodTotalSearchAreaMonthLabel.setBounds(7, 126, 566, 20);
							periodTotalSearchAreaMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 1, false, false));
							
						}
						{
							periodTotalSearchArea = new Composite(periodTotalComposite, SWT.BORDER);
							periodTotalSearchArea.setLayout(null);
							periodTotalSearchArea.setBounds(7, 6, 995, 110);
//							periodTotalSearchArea.setBackground(SWTResourceManager.getColor(205, 214, 243));
							{
								periodTotalFromDateTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalFromDateTitle.setText("\uad6c\uc785\ub0a0\uc9dc");
								periodTotalFromDateTitle.setBounds(94, 12, 53, 19);
								periodTotalFromDateTitle.setToolTipText("\uac80\uc0c9\ud558\uace0 \uc2f6\uc740 \uad6c\uc785\ub0a0\uc9dc \ubc94\uc704\ub97c \uc9c0\uc815. '\ubd80\ud130'\ub97c \uc9c0\uc815 \uc548\ud558\uba74 \ucd5c\ucd08\uc758 \ub0a0\uc9dc\ubd80\ud130. '\uae4c\uc9c0'\ub97c \uc9c0\uc815 \uc548\ud558\uba74 \ub9c8\uc9c0\ub9c9 \ub0a0\uc9dc\uae4c\uc9c0\ub97c \uac80\uc0c9.");
//								periodTotalFromDateTitle.setBackground(periodTotalSearchArea.getBackground());
							}

							{
								periodTotalFromDateYearCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalFromDateYearCombo.setBounds(154, 10, 71, 22);
								periodTotalFromDateYearCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(periodTotalFromDateYearCombo, periodTotalFromDateMonthCombo, periodTotalFromDateDayCombo, false);
										periodTotalFromDateMonthCombo.select(0);
									}
								});
//								periodTotalFromDateYearCombo.add("");

								// 현재 연도에서 2012까지 표시
								for (int i = this.thisYear + 1; i >= Consts.STANDARD_YEAR; i--) {
									periodTotalFromDateYearCombo.add(String.valueOf(i));
								}
								for (int j = 0; j < periodTotalFromDateYearCombo.getItemCount(); j++) {
									if (periodTotalFromDateYearCombo.getItem(j).equals(String.valueOf(aMonthAgoYearMonthDay[0]))) {
										periodTotalFromDateYearCombo.select(j);
									}
								}
//								periodTotalFromDateYearCombo.select(0);
							}
							{
								periodTotalFromDateYearLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalFromDateYearLabel.setText("\ub144");
								periodTotalFromDateYearLabel.setBounds(227, 12, 21, 18);
//								periodTotalFromDateYearLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalFromDateMonthCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalFromDateMonthCombo.setBounds(248, 10, 54, 22);
								for (int i = 1; i <= 12; i++) {
									periodTotalFromDateMonthCombo.add(String.format("%02d", i));
								}
								
								periodTotalFromDateMonthCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(periodTotalFromDateYearCombo, periodTotalFromDateMonthCombo, periodTotalFromDateDayCombo, false);
									}
								});
//System.out.println(String.valueOf(aMonthAgoYearMonthDay[1]));
//								for (int j = 0; j < periodTotalFromDateMonthCombo.getItemCount(); j++) {
//									if (periodTotalFromDateMonthCombo.getItem(j).equals(String.format("%02d", aMonthAgoYearMonthDay[1]))) {
										periodTotalFromDateMonthCombo.select(aMonthAgoYearMonthDay[1] -1);
//									}
//								}
//								periodTotalFromDateMonthCombo.select(util.getThisMonth() -1);
							}
							{
								periodTotalFromDateMonthLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalFromDateMonthLabel.setText("\uc6d4");
								periodTotalFromDateMonthLabel.setBounds(305, 12, 21, 18);
//								periodTotalFromDateMonthLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalFromDateDayCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalFromDateDayCombo.setBounds(326, 10, 54, 22);
								periodTotalFromDateDayCombo.setToolTipText("\uc77c\uc790\uac00 \ud45c\uc2dc\ub418\uc9c0 \uc54a\uc744 \ub54c\uc5d0\ub294 \uc5f0\ub3c4\uc640 \uc6d4\uc744 \uba3c\uc800 \uc120\ud0dd\ud558\uc2ed\uc2dc\uc624.");
								util.getLastDayWhenYearAndMonthChoosed(periodTotalFromDateYearCombo, periodTotalFromDateMonthCombo, periodTotalFromDateDayCombo, false);
//								periodTotalFromDateDayCombo.select(0);
//								for (int j = 0; j < periodTotalFromDateDayCombo.getItemCount(); j++) {
//									if (periodTotalFromDateDayCombo.getItem(j).equals(String.format("%02d", aMonthAgoYearMonthDay[2]))) {
										periodTotalFromDateDayCombo.select(aMonthAgoYearMonthDay[2] -1);
//									}
//								}
							}
							{
								periodTotalFromDateDayLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalFromDateDayLabel.setText("\uc77c   \uc5d0\uc11c");
								periodTotalFromDateDayLabel.setBounds(382, 13, 57, 18);
//								periodTotalFromDateDayLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							// ----------------------------------------------------------------
							// ------------------------------------------------------ 구입날짜To
							{
								periodTotalToDateYearCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalToDateYearCombo.setBounds(443, 10, 71, 22);
								periodTotalToDateYearCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(periodTotalToDateYearCombo, periodTotalToDateMonthCombo, periodTotalToDateDayCombo, false);
										periodTotalToDateMonthCombo.select(0);
									}
								});
								// 현재 연도에서 2012까지 표시
								for (int i = this.thisYear + 1; i >= Consts.STANDARD_YEAR; i--) {
									periodTotalToDateYearCombo.add(String.valueOf(i));
								}
								periodTotalToDateYearCombo.select(1);
							}
							{
								periodTotalToDateYearLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalToDateYearLabel.setText("\ub144");
								periodTotalToDateYearLabel.setBounds(517, 12, 21, 18);
//								periodTotalToDateYearLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalToDateMonthCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalToDateMonthCombo.setBounds(538, 10, 54, 22);
								for (int i = 1; i <= 12; i++) {
									periodTotalToDateMonthCombo.add(String.format("%02d", i));
								}
								
								periodTotalToDateMonthCombo.addSelectionListener(new SelectionAdapter() {
									public void widgetSelected(SelectionEvent evt) {
										util.getLastDayWhenYearAndMonthChoosed(periodTotalToDateYearCombo, periodTotalToDateMonthCombo, periodTotalToDateDayCombo, false);
									}
								});
								periodTotalToDateMonthCombo.select(thisMonth -1);
							}
							{
								periodTotalToDateMonthLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalToDateMonthLabel.setText("\uc6d4");
								periodTotalToDateMonthLabel.setBounds(595, 12, 18, 18);
//								periodTotalToDateMonthLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalToDateDayCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalToDateDayCombo.setBounds(615, 10, 54, 22);
								periodTotalToDateDayCombo.setToolTipText("\uc77c\uc790\uac00 \ud45c\uc2dc\ub418\uc9c0 \uc54a\uc744 \ub54c\uc5d0\ub294 \uc5f0\ub3c4\uc640 \uc6d4\uc744 \uba3c\uc800 \uc120\ud0dd\ud558\uc2ed\uc2dc\uc624.");
								util.getLastDayWhenYearAndMonthChoosed(periodTotalToDateYearCombo, periodTotalToDateMonthCombo, periodTotalToDateDayCombo, false);
//								periodTotalToDateDayCombo.select(util.getLastDay(util.getThisYear(), util.getThisMonth()) -1);
								periodTotalToDateDayCombo.select(thisDay -1);
							}
							{
								periodTotalToDateDayLabel = new Label(periodTotalSearchArea, SWT.NONE);
								periodTotalToDateDayLabel.setText("\uc77c   \uae4c\uc9c0");
								periodTotalToDateDayLabel.setBounds(672, 12, 74, 18);
//								periodTotalToDateDayLabel.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalSearchGoodNoTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalSearchGoodNoTitle.setText("\uc0c1\ud488No.");
								periodTotalSearchGoodNoTitle.setBounds(8, 45, 44, 18);
								periodTotalSearchGoodNoTitle.setOrientation(SWT.HORIZONTAL);
								periodTotalSearchGoodNoTitle.setToolTipText("No.\ub85c \uac80\uc0c9. \uc22b\uc790\ub9cc \uc785\ub825\uac00\ub2a5\ud569\ub2c8\ub2e4.");
//								periodTotalSearchGoodNoTitle.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalSearchGoodsNoText = new Text(periodTotalSearchArea, SWT.NONE);
								periodTotalSearchGoodsNoText.setBounds(57, 44, 111, 19);
								periodTotalSearchGoodsNoText.setToolTipText("No.\ub85c \uac80\uc0c9. \uc22b\uc790\ub9cc \uc785\ub825\uac00\ub2a5\ud569\ub2c8\ub2e4.");
								periodTotalSearchGoodsNoText.setTextLimit(19);
								periodTotalSearchGoodsNoText.addVerifyListener(new VerifyListener() {
									public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
										evt.doit = evt.text.matches("[0-9]*");
									}
								});
							}
							{
								periodTotalSearchGoodNameTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalSearchGoodNameTitle.setText("\ud56d\ubaa9\uba85");
								periodTotalSearchGoodNameTitle.setBounds(6, 76, 44, 17);
								periodTotalSearchGoodNameTitle.setOrientation(SWT.HORIZONTAL);periodTotalSearchGoodNameTitle.setToolTipText("\uc77c\ubd80 \ub2e8\uc5b4\ub85c\ub3c4 \uac80\uc0c9 \uac00\ub2a5. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ub2e8\uc5b4\uac00 \ubaa8\ub450 \ub4e4\uc5b4\uac00\uc788\ub294 \uc0c1\ud488\uba85\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
//								periodTotalSearchGoodNameTitle.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalSearchGoodsNameText = new Text(periodTotalSearchArea, SWT.NONE);
								periodTotalSearchGoodsNameText.setBounds(57, 77, 184, 19);
								periodTotalSearchGoodsNameText.setToolTipText("\uc77c\ubd80 \ub2e8\uc5b4\ub85c\ub3c4 \uac80\uc0c9 \uac00\ub2a5. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ub2e8\uc5b4\uac00 \ubaa8\ub450 \ub4e4\uc5b4\uc788\ub294 \uc0c1\ud488\uba85\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
								periodTotalSearchGoodsNameText.setTextLimit(255);
							}
							{
								periodTotalSearchKindTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalSearchKindTitle.setText("\uc0c1\ud488\uc885\ub958");
								periodTotalSearchKindTitle.setBounds(247, 44, 54, 17);
								periodTotalSearchKindTitle.setToolTipText("\uc0c1\ud488\uc885\ub958\ub85c \uac80\uc0c9");
//								periodTotalSearchKindTitle.setBackground(goodsListSearchArea.getBackground());
							}
							{
								periodTotalSearchKindCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalSearchKindCombo.setBounds(307, 42, 233, 25);
								periodTotalSearchKindCombo.setToolTipText("\uc0c1\ud488\uc885\ub958\ub85c \uac80\uc0c9");
							}
							{
								periodTotalSearchColorTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalSearchColorTitle.setText("\uc0c9\uc0c1");
								periodTotalSearchColorTitle.setBounds(268, 77, 32, 19);
								periodTotalSearchColorTitle.setToolTipText("\uc0c1\ud488 \uc0c9\uc0c1\uc73c\ub85c \uac80\uc0c9");
//								periodTotalSearchColorTitle.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalSearchColorCombo = new Combo(periodTotalSearchArea, SWT.READ_ONLY);
								periodTotalSearchColorCombo.setBounds(307, 73, 233, 25);
								periodTotalSearchColorCombo.setToolTipText("\uc0c1\ud488 \uc0c9\uc0c1\uc73c\ub85c \uac80\uc0c9");
							}
							{
								periodTotalSearchMemoTitle = new Label(periodTotalSearchArea, SWT.RIGHT);
								periodTotalSearchMemoTitle.setText("\uba54\ubaa8");
								periodTotalSearchMemoTitle.setBounds(559, 46, 32, 19);
								periodTotalSearchMemoTitle.setToolTipText("\uba54\ubaa8\uc758 \uc77c\ubd80 \ub2e8\uc5b4\ub85c \uac80\uc0c9. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ubaa8\ub4e0 \ub2e8\uc5b4\ub97c \ud3ec\ud568\ud558\ub294 \uba54\ubaa8\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
//								periodTotalSearchMemoTitle.setBackground(periodTotalSearchArea.getBackground());
							}
							{
								periodTotalSearchMemoText = new Text(periodTotalSearchArea, SWT.NONE);
								periodTotalSearchMemoText.setBounds(603, 45, 217, 19);
								periodTotalSearchMemoText.setToolTipText("\uba54\ubaa8\uc758 \uc77c\ubd80 \ub2e8\uc5b4\ub85c \uac80\uc0c9. 2\uac1c \uc774\uc0c1\uc758 \ub2e8\uc5b4\ub97c \ub744\uc5b4\uc4f0\uba74 \uadf8 \ubaa8\ub4e0 \ub2e8\uc5b4\ub97c \ud3ec\ud568\ud558\ub294 \uba54\ubaa8\uc758 \uc0c1\ud488\uc744 \uac80\uc0c9\ud569\ub2c8\ub2e4.");
								periodTotalSearchMemoText.setTextLimit(500);
							}
							{
								periodTotalBunryuBuyGoodsCheckBox = new Button(periodTotalSearchArea, SWT.CHECK | SWT.LEFT);
								periodTotalBunryuBuyGoodsCheckBox.setText("\uc0c1\ud488\uad6c\uc785");
								periodTotalBunryuBuyGoodsCheckBox.setBounds(559, 73, 74, 30);
//								periodTotalBunryuBuyGoodsCheckBox.setBackground(periodTotalSearchArea.getBackground());
								periodTotalBunryuBuyGoodsCheckBox.setSelection(true);
							}
							{
								periodTotalSellGoodsCheckBox = new Button(periodTotalSearchArea, SWT.CHECK | SWT.LEFT);
								periodTotalSellGoodsCheckBox.setText("\uc0c1\ud488\ud310\ub9e4");
								periodTotalSellGoodsCheckBox.setBounds(635, 73, 76, 30);
//								periodTotalSellGoodsCheckBox.setBackground(periodTotalSearchArea.getBackground());
								periodTotalSellGoodsCheckBox.setSelection(true);
							}
							{
								periodTotalSuibCheckBox = new Button(periodTotalSearchArea, SWT.CHECK | SWT.LEFT);
								periodTotalSuibCheckBox.setText("\uc218\uc785");
								periodTotalSuibCheckBox.setBounds(714, 73, 59, 30);
//								periodTotalSuibCheckBox.setBackground(periodTotalSearchArea.getBackground());
								periodTotalSuibCheckBox.setSelection(true);
							}
							{
								periodTotalJichulCheckBox = new Button(periodTotalSearchArea, SWT.CHECK | SWT.LEFT);
								periodTotalJichulCheckBox.setText("\uc9c0\ucd9c");
								periodTotalJichulCheckBox.setBounds(773, 73, 60, 30);
//								periodTotalJichulCheckBox.setBackground(periodTotalSearchArea.getBackground());
								periodTotalJichulCheckBox.setSelection(true);
							}
							{
								periodTotalSearchEraseAllButton = new Button(periodTotalSearchArea, SWT.PUSH | SWT.CENTER);
								periodTotalSearchEraseAllButton.setText("\ud55c\ub2ec \uc804\ubd80\ud130\uc758 \ubaa8\ub4e0 \ub0b4\uc5ed\ubcf4\uae30");
								periodTotalSearchEraseAllButton.setBounds(773, 8, 210, 25);
								periodTotalSearchEraseAllButton.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										periodTotalSearchEraseAllButtonMouseUp(evt);
									}
								});
							}
							{
								periodTotalSearchButton = new Button(periodTotalSearchArea, SWT.PUSH | SWT.CENTER);
								periodTotalSearchButton.setText("\uc774 \uc870\uac74\uc73c\ub85c \uac80\uc0c9");
								periodTotalSearchButton.setBounds(839, 61, 144, 37);
								periodTotalSearchButton.addMouseListener(new MouseAdapter() {
									public void mouseUp(MouseEvent evt) {
										periodTotalSearchButtonMouseUp();
									}
								});
							}
						}
						{
							periodTotalTable = new Table(periodTotalComposite, SWT.NONE);
							periodTotalTable.setBounds(6, 180, 994, 264);
							periodTotalTable.setLinesVisible(true);
							periodTotalTable.setHeaderVisible(true);
							periodTotalTable.setFont(SWTResourceManager.getFont("Lucida Grande", 9, 0, false, false));
							periodTotalTable.addListener(SWT.MouseDoubleClick, new Listener() {	// 상품판매 입력 리스트 더블클릭시 해당 상품 삭제.
								public void handleEvent(Event e) {
									periodTotalTableMouseDoubleClick(e);
								}
							});
							{
								periodTotalNoTableColumn = new TableColumn(periodTotalTable, SWT.RIGHT);
								periodTotalNoTableColumn.setText("\uc0c1\ud488No.");
								periodTotalNoTableColumn.setWidth(72);
							}
							{
								periodTotalBunryuTableColumn = new TableColumn(periodTotalTable, SWT.LEFT);
								periodTotalBunryuTableColumn.setText("\ubd84\ub958");
								periodTotalBunryuTableColumn.setWidth(67);
								periodTotalBunryuTableColumn.setMoveable(true);
							}
							{
								periodTotalNameTableColumn = new TableColumn(periodTotalTable, SWT.LEFT);
								periodTotalNameTableColumn.setText("\ud56d\ubaa9\uba85");
								periodTotalNameTableColumn.setWidth(123);
								periodTotalNameTableColumn.setMoveable(true);
							}
							{
								periodTotalKindTableColumn = new TableColumn(periodTotalTable, SWT.LEFT);
								periodTotalKindTableColumn.setText("\uc0c1\ud488\uc885\ub958");
								periodTotalKindTableColumn.setWidth(82);
							}
							{
								periodTotalColorTableColumn = new TableColumn(periodTotalTable, SWT.CENTER);
								periodTotalColorTableColumn.setText("\uc0c9\uc0c1");
								periodTotalColorTableColumn.setWidth(60);
							}
							{
								periodTotalMemoTableColumn = new TableColumn(periodTotalTable, SWT.NONE);
								periodTotalMemoTableColumn.setText("\uba54\ubaa8");
								periodTotalMemoTableColumn.setWidth(141);
							}
							{
								periodTotalBuyPriceTableColumn = new TableColumn(periodTotalTable, SWT.RIGHT);
								periodTotalBuyPriceTableColumn.setText("\uad6c\uc785\uac00/\uc9c0\ucd9c\uc561(-)");
								periodTotalBuyPriceTableColumn.setWidth(120);
								periodTotalBuyPriceTableColumn.setToolTipText("\uad6c\uc785\uac00/\uc9c0\ucd9c\uc561(-)");
							}
//							{
//								periodTotalSellHopePriceTableColumn = new TableColumn(periodTotalTable, SWT.RIGHT);
//								periodTotalSellHopePriceTableColumn.setText("\ud310\ub9e4\uc608\uc815\uac00");
//								periodTotalSellHopePriceTableColumn.setWidth(83);
//							}
							{
								periodTotalSellPriceTableColumn = new TableColumn(periodTotalTable, SWT.RIGHT);
								periodTotalSellPriceTableColumn.setText("\ud310\ub9e4\uac00/\uc18c\ub4dd\uc561(+)");
								periodTotalSellPriceTableColumn.setWidth(121);
								periodTotalSellPriceTableColumn.setToolTipText("\ud310\ub9e4\uac00/\uc18c\ub4dd\uc561(+)");
							}
							{
								periodTotalPlaceTableColumn = new TableColumn(periodTotalTable, SWT.NONE);
								periodTotalPlaceTableColumn.setText("\uad6c\uc785\ucc98");
								periodTotalPlaceTableColumn.setWidth(82);
							}
							{
								periodTotalBuyDateTableColumn = new TableColumn(periodTotalTable, SWT.NONE);
								periodTotalBuyDateTableColumn.setText("\ub4f1\ub85d\ub0a0\uc9dc");
								periodTotalBuyDateTableColumn.setWidth(124);
							}
						}
						{
							periodTotalAddGoods = new Button(periodTotalComposite, SWT.PUSH | SWT.CENTER);
							periodTotalAddGoods.setText("\uad6c\uc785\uc0c1\ud488 \ucd94\uac00");
							periodTotalAddGoods.setBounds(585, 119, 147, 30);
							periodTotalAddGoods.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									periodTotalAddGoodsMouseUp(evt);
								}
							});
						}
						{
							periodTotalAddSuib = new Button(periodTotalComposite, SWT.PUSH | SWT.CENTER);
							periodTotalAddSuib.setText("\uc218\uc785 \ucd94\uac00");
							periodTotalAddSuib.setBounds(744, 119, 117, 30);
							periodTotalAddSuib.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									periodTotalAddSuibMouseUp(evt);
								}
							});
						}
						{
							periodTotalAddJichul = new Button(periodTotalComposite, SWT.PUSH | SWT.CENTER);
							periodTotalAddJichul.setText("\uc9c0\ucd9c \ucd94\uac00");
							periodTotalAddJichul.setBounds(873, 119, 121, 30);
							periodTotalAddJichul.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									periodTotalAddJichulMouseUp(evt);
								}
							});
						}
						{
							periodTotalInfoLabel = new Label(periodTotalComposite, SWT.NONE);
							periodTotalInfoLabel.setText("\uc815\ubcf4\ub97c \uc218\uc815\ud558\uac70\ub098 \uc0ad\uc81c\ud558\uace0 \uc2f6\uc744 \ub54c\uc5d0\ub294 \ud574\ub2f9 \ud56d\ubaa9\uc758 No.\ub97c \ub354\ube14\ud074\ub9ad\ud574\uc8fc\uc2ed\uc2dc\uc624.");
							periodTotalInfoLabel.setBounds(7, 152, 496, 20);
						}
						{
							periodTotalSuibTotalLabel = new Label(periodTotalComposite, SWT.RIGHT);
							periodTotalSuibTotalLabel.setText("\uc774\ub4dd (\ud310\ub9e4/\uc218\uc785 \ud569\uacc4) :");
							periodTotalSuibTotalLabel.setBounds(7, 454, 142, 22);
						}
						{
							periodTotalSuibTotalValueLabel = new Label(periodTotalComposite, SWT.LEFT);
							periodTotalSuibTotalValueLabel.setBounds(155, 454, 146, 22);
						}
						{
							periodTotalJichulTotalLabel = new Label(periodTotalComposite, SWT.RIGHT);
							periodTotalJichulTotalLabel.setText("\uc9c0\ucd9c (\uad6c\uc785/\uc9c0\ucd9c \ud569\uacc4) :");
							periodTotalJichulTotalLabel.setBounds(352, 454, 145, 22);
						}
						{
							periodTotalJichulTotalValueLabel = new Label(periodTotalComposite, SWT.NONE);
							periodTotalJichulTotalValueLabel.setBounds(503, 454, 150, 22);
						}
						{
							periodTotalMagineLabel = new Label(periodTotalComposite, SWT.RIGHT);
							periodTotalMagineLabel.setText("\uc774\uc724 (\uc774\ub4dd - \uc9c0\ucd9c) :");
							periodTotalMagineLabel.setBounds(659, 454, 152, 22);
						}
						{
							periodTotalMagineValueLabel = new Label(periodTotalComposite, SWT.LEFT);
							periodTotalMagineValueLabel.setBounds(816, 454, 184, 22);
						}
						{
							periodTotalPrintButton = new Button(periodTotalComposite, SWT.PUSH | SWT.CENTER);
							periodTotalPrintButton.setText("\uc778\uc1c4\uc6a9\uc73c\ub85c \uc544\ub798 \ub9ac\uc2a4\ud2b8 \ud45c \ub0b4\uc6a9\uc744 \uc6f9\ube0c\ub77c\uc6b0\uc800\uc5d0\uc11c \uc5f4\uae30");
							periodTotalPrintButton.setBounds(645, 152, 349, 22);
							periodTotalPrintButton.addMouseListener(new MouseAdapter() {
								public void mouseUp(MouseEvent evt) {
									if (periodTotalTable != null && periodTotalTable.getItemCount() != 0) {
										util.outputPeriodTotalHtmlFile(periodTotalSearchKeywordDto, periodTotalSuibTotalValueLabel.getText(), periodTotalJichulTotalValueLabel.getText(), periodTotalMagineValueLabel.getText(), periodTotalTable);
										try {
											util.openHtmlFile();
										} catch (Exception e) {
											util.showMsg(getShell(), e.getMessage());
										}
									} else {
										util.showMsg(getShell(), "인쇄 대상 데이터를 검색해주십시오.");
									}
								}
							});
							
						}
					}
				}
				{
					preferenceTab = new CTabItem(tabList, SWT.NONE);
					preferenceTab.setText("\uad00\ub9ac            ");
					{
						preferenceComponent = new Composite(tabList, SWT.NONE);
						preferenceComponent.setBackgroundMode( SWT.INHERIT_DEFAULT );
						preferenceComponent.setLayout(null);
						preferenceTab.setControl(preferenceComponent);
						preferenceComponent.setBackgroundImage(SWTResourceManager.getImage("wallpaper.jpg"));
						{
							preferenceKindComponent = new Composite(preferenceComponent, SWT.BORDER);
							preferenceKindComponent.setLayout(null);
							preferenceKindComponent.setBounds(8, 8, 273, 455);
							{
								preferenceKindLabel = new Label(preferenceKindComponent, SWT.NONE);
								preferenceKindLabel.setText("\uc0c1\ud488\uc885\ub958 \uad00\ub9ac");
								preferenceKindLabel.setBounds(12, 8, 222, 22);
								preferenceKindLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 1, false, false));
							}
							{
								preferenceKindTable = new Table(preferenceKindComponent, SWT.NONE);
								preferenceKindTable.setBounds(12, 74, 249, 369);
								preferenceKindTable.setLinesVisible(true);
								preferenceKindTable.addListener(SWT.MouseDoubleClick, new Listener() {	// 상품판매 입력 리스트 더블클릭시 해당 상품 삭제.
									public void handleEvent(Event e) {
										preferenceKindTableMouseDoubleClick(e);
									}
								});
								{
									preferenceKindTableButtonColumn = new TableColumn(preferenceKindTable, SWT.NONE);
									preferenceKindTableButtonColumn.setText("tableColumn1");
									preferenceKindTableButtonColumn.setWidth(225);
								}
							}
							{
								preferenceKindInfoLabel = new Label(preferenceKindComponent, SWT.NONE);
								preferenceKindInfoLabel.setText("\uc218\uc815 \ub610\ub294 \uc0ad\uc81c \ud558\uace0 \uc2f6\uc740 \uc0c1\ud488 \uc885\ub958\ub97c\n\ub354\ube14\ud074\ub9ad \ud558\uc2ed\uc2dc\uc624.");
								preferenceKindInfoLabel.setBounds(12, 36, 249, 47);
							}
							
							preferenceColorComponent = new Composite(preferenceComponent, SWT.BORDER);
							preferenceColorComponent.setLayout(null);
							preferenceColorComponent.setBounds(293, 8, 273, 455);
							{
								preferenceColorLabel = new Label(preferenceColorComponent, SWT.NONE);
								preferenceColorLabel.setText("\uc0c9\uc0c1 \uad00\ub9ac");
								preferenceColorLabel.setBounds(12, 8, 222, 22);
								preferenceColorLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 1, false, false));
							}
							{
								preferenceColorTable = new Table(preferenceColorComponent, SWT.NONE);
								preferenceColorTable.setBounds(12, 74, 249, 369);
								preferenceColorTable.setLinesVisible(true);
								preferenceColorTable.addListener(SWT.MouseDoubleClick, new Listener() {	// 상품판매 입력 리스트 더블클릭시 해당 상품 삭제.
									public void handleEvent(Event e) {
										preferenceColorTableMouseDoubleClick(e);
									}
								});
								{
									preferenceColorTableButtonColumn = new TableColumn(preferenceColorTable, SWT.NONE);
									preferenceColorTableButtonColumn.setText("tableColumn1");
									preferenceColorTableButtonColumn.setWidth(225);
								}
							}
							{
								preferenceColorInfoLabel = new Label(preferenceColorComponent, SWT.NONE);
								preferenceColorInfoLabel.setText("\uc218\uc815 \ub610\ub294 \uc0ad\uc81c \ud558\uace0 \uc2f6\uc740 \uc0c9\uc0c1\uc744\n\ub354\ube14\ud074\ub9ad \ud558\uc2ed\uc2dc\uc624.");
								preferenceColorInfoLabel.setBounds(12, 36, 249, 47);
							}
						}
					}
				}
				tabList.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
				tabList.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						sellGoodsNoText.setFocus();
					}
				});
				tabList.setSelection(0);
				tabList.setBackground(SWTResourceManager.getColor(208, 222, 164));
			}
			{
				// 상품 리스트 테이블 아이템 추가
				List<GoodsListBean> goodsList = goodsListService.getGoodsList(Consts.BUNRYU_GOODS, '0', "", "", "", "", "", "", "", "", "", "", "");
				this.goodsListTableAddDatas(goodsList);
			}
			this.periodTotalSearchButtonMouseUp();
			updateKindCombo();
			updateColorCombo();
			showPreferenceKindCombos();
			showPreferenceColorCombos();
			this.layout();
			this.getup = true; // 기동 성공

		} catch (Exception e) {
			e.printStackTrace();
			util.showErrorMsg(getShell(), e.getMessage());
		}
	}

	// 현재 보유상품 리스트 테이블에 데이터 추가.
	private void goodsListTableAddDatas(List<GoodsListBean> goodsList) {
		this.goodsListTable.removeAll();

		Long totalBuyPrice = 0l;
		Long totalSellHopePrice = 0l;

		if (goodsList != null) {

			for (int i = goodsList.size() -1; i >= 0; i--) {
				GoodsListBean bean = goodsList.get(i);

				tableItem = new TableItem(goodsListTable, SWT.NONE);
				tableItem.setText(
								new String[] {
										String.valueOf(bean.getId()),
										bean.getName() != null ? bean.getName().replace(SWT.LF, ' ') : "",
										bean.getKind(),
										bean.getColor(),
										bean.getMemo() != null ? bean.getMemo().replace(SWT.LF, ' ') : "",
										util.addCommaForPrice(bean.getBuyPrice()),
										util.addCommaForPrice(bean.getSellHopePrice()),
										bean.getPlace(),
										util.applyDateFormat(bean.getBuyDate(), Consts.SLASH_DATE_FORMAT)
//										bean.getSellDate() != null ? bean.getSellDate().toString() : "",
//										bean.getBarcode()
								}
								);
				if (bean != null) {
					if (bean.getBuyPrice() != null) {
						totalBuyPrice += bean.getBuyPrice();
					}
					if (bean.getSellHopePrice() != null) {
						totalSellHopePrice += bean.getSellHopePrice();
					}
				}
			}
//System.out.println(goodsList);
			goodsListTotalInfoGoodsNumValueLabel.setText(goodsList.size() + " 개");
		} else {
			goodsListTotalInfoGoodsNumValueLabel.setText("0 개");
		}
		goodsListTotalInfoBuyPriceTotalValueLabel.setText(util.addCommaForPrice(totalBuyPrice));
		goodsListTotalInfoSellHopePriceTotalValueLabel.setText(util.addCommaForPrice(totalSellHopePrice));
		goodsListTotalInfoTotalMagineValueLabel.setText(util.addCommaForPrice(totalSellHopePrice - totalBuyPrice));
	}

	// 상품판매 입력 이 No.상품 판매 버튼 클릭시.
	private void sellGoodsNoAddDatas() {
		this.sellGoodsTable.removeAll();
		long totalPrice = 0;
		ArrayList<GoodsListBean> sellGoodsList = sellGoodsService.getSellGoodsList();
		if (sellGoodsList != null) {
			for (int i = sellGoodsList.size() -1; i >= 0; i--) {

				GoodsListBean bean = sellGoodsList.get(i);
				tableItem = new TableItem(sellGoodsTable, SWT.NONE);
				tableItem.setText(
								new String[] {
										String.valueOf(bean.getId()),
										bean.getName() != null ? bean.getName().replace(SWT.LF, ' ') : "",
										bean.getKind(),
										bean.getColor(),
										bean.getMemo() != null ? bean.getMemo().replace(SWT.LF, ' ') : "",
										util.addCommaForPrice(bean.getBuyPrice()),
										util.addCommaForPrice(bean.getSellHopePrice()),
										util.addCommaForPrice(bean.getSellPrice()),
										bean.getPlace(),
										util.applyDateFormat(bean.getBuyDate(), Consts.SLASH_DATE_FORMAT),
										bean.getSellDate() != null ? util.applyDateFormat(bean.getSellDate(), Consts.SLASH_DATE_FORMAT) : ""
//											bean.getSellDate() != null ? bean.getSellDate().toString() : "",
//										bean.getBarcode()
								}
								);
				if (bean.getSellPrice() != null) {
					totalPrice += bean.getSellPrice();
				}
			}
			sellGoodsTotalPrice2Label.setText(util.addCommaForPrice(totalPrice));
			sellGoodsTotalInfoNumValueLabel.setText(sellGoodsList.size() + " \uac1c");
			sellGoodsNoText.setText("");
//			sellGoodsBarcodeText.setText("");
		}
	}

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Composite inside a new Shell.
	*/
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell(display, SWT.CLOSE|SWT.MIN);	// 최소화와 닫기만 가능.
		
		Main inst = new Main(shell, SWT.NULL);
		shell.setText(Consts.TITLE);
		shell.setLocation(0, 0);

		if (inst.getup == true) {	// 기동 성공시 다음을 실행. 실패시 에러 메세지 출력후 프로그램 종료.
			Point size = inst.getSize();
			shell.setLayout(new FillLayout());
			shell.layout();
			if(size.x == 0 && size.y == 0) {
				inst.pack();
				shell.pack();
			} else {
				Rectangle shellBounds = shell.computeTrim(0, 0, size.x, size.y);
				shell.setSize(shellBounds.width, shellBounds.height);
			}
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		}
	}

	// 현재 보유상품 리스트 '이 조건으로 검색' 버튼 클릭시 이벤트.
	private void goodsListSearchButtonMouseUp() {
		try {
			List<GoodsListBean> goodsList = goodsListService.getGoodsList(
					Consts.BUNRYU_GOODS, '0',
					goodsListSearchGoodsNoText.getText(), goodsListSearchGoodsNameText.getText(),
					goodsListSearchKindCombo.getText(), goodsListSearchColorCombo.getText(), goodsListSearchMemoText.getText(),
					goodsListSearchBuyFromDateYearCombo.getText(), goodsListSearchBuyFromDateMonthCombo.getText(), goodsListSearchBuyFromDateDayCombo.getText(),
					goodsListSearchBuyToDateYearCombo.getText(), goodsListSearchBuyToDateMonthCombo.getText(), goodsListSearchBuyToDateDayCombo.getText()
					);
			this.goodsListTableAddDatas(goodsList);
			
			goodsListSearchKeywordsDto.setGoodsNo(goodsListSearchGoodsNoText.getText());
			goodsListSearchKeywordsDto.setColor(goodsListSearchColorCombo.getText());
			goodsListSearchKeywordsDto.setMemo(goodsListSearchMemoText.getText());
			goodsListSearchKeywordsDto.setGoodsName(goodsListSearchGoodsNameText.getText());
			goodsListSearchKeywordsDto.setFromYear(goodsListSearchBuyFromDateYearCombo.getText());
			goodsListSearchKeywordsDto.setFromMonth(goodsListSearchBuyFromDateMonthCombo.getText());
			goodsListSearchKeywordsDto.setFromDay(goodsListSearchBuyFromDateDayCombo.getText());
			goodsListSearchKeywordsDto.setToYear(goodsListSearchBuyToDateYearCombo.getText());
			goodsListSearchKeywordsDto.setToMonth(goodsListSearchBuyToDateMonthCombo.getText());
			goodsListSearchKeywordsDto.setToDay(goodsListSearchBuyToDateDayCombo.getText());
			goodsListSearchKeywordsDto.setKind(goodsListSearchKindCombo.getText());
		} catch (SQLException e) {
			e.printStackTrace();
			util.showErrorMsg(getShell(), e.getMessage());
		}
	}

	// 상품판매 입력 탭, 이 No.상품 판매 버튼 클릭시
	private void sellGoodsNoButtonMouseUp() {

		if (util.isEmpty(sellGoodsNoText.getText())) {
			util.showMsg(getShell(), "왼쪽 「판매상품 No.입력」란에 판매상품 No.을 입력하신 후 버튼을 눌러주십시오.");
		} else {
			try {
				Long id = Long.valueOf(sellGoodsNoText.getText());
				if (sellGoodsService.hasThisGoods(id)) {
					util.showMsg(getShell(), "같은 상품은 여러번 추가할 수 없습니다.");
					sellGoodsNoText.setText("");
				} else {
					GoodsListBean sellGoodsData = sellGoodsService.getSellGoodsData(id);
					SellGoodsDetail inst = new SellGoodsDetail(getShell(), SWT.NULL);
					GoodsListBean sellGoodsDataModified = inst.open(sellGoodsData);
					if (sellGoodsDataModified != null) {
						sellGoodsService.addSellGoodsData(sellGoodsDataModified);
						this.sellGoodsNoAddDatas();
					}
				}
			} catch (InvalidParameterException e) {
				util.showMsg(getShell(), e.getMessage());
				sellGoodsNoText.setText("");
			} catch (SQLException e) {
				e.printStackTrace();
				util.showErrorMsg(getShell(), e.getMessage());
			} catch (NumberFormatException e) {
				util.showMsg(getShell(), "올바르지 않은 상품No.입니다.");
				sellGoodsNoText.setText("");
			}
		}
	}
	
	// 상품판매 입력 '이 판매 리스트 확정' 버튼 클릭시.
	private void sellGoodsConfirmButtonMouseUp(MouseEvent evt) {
		ArrayList<GoodsListBean> sellGoodsList = sellGoodsService.getSellGoodsList();
		if (sellGoodsList.size() < 1) {
			util.showMsg(getShell(), "판매할 상품을 추가해주십시오.");
			return;
		}
		SellGoodsConfirm sellGoodsConfirm = new SellGoodsConfirm(getShell(), SWT.NONE);
		int response = sellGoodsConfirm.open(sellGoodsService);
		if (response == SWT.YES) {
			try {
				int errorNum = sellGoodsService.confirmSellGoods();
				if (errorNum == 0) {
					sellGoodsService.deleteAllThisGoods();
					sellGoodsNoAddDatas();
					updateTableTopIndex();
					util.showMsg(getShell(), "상품들을 판매 완료로 변경하였습니다.\n판매 완료된 상품들은 '상품, 지출, 소득 등록 및 열람'에서 조회・변경 가능합니다.");
				} else {
					StringBuffer errMsg = new StringBuffer();
					sellGoodsNoAddDatas();
					errMsg.append("다음 상품들의 판매 완료 갱신에 실패하였습니다.\n");
					errMsg.append("실패 상품No. : ");
					for (GoodsListBean bean : sellGoodsService.getSellGoodsList()) {
						errMsg.append(bean.getId());
						errMsg.append(" ");
					}
					util.showErrorMsg(getShell(), errMsg.toString());
				}
			} catch (SQLException e) {
				util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
			} finally {
				goodsListSearchButtonMouseUp();		// 현재 보유상품리스트 초기화
			}
		}
	}

	// 현재 보유상품 리스트 '보유상품 추가' 버튼 클릭시.
	private void periodTotalAddGoodsButtonMouseUp() {
		AddGoods inst = new AddGoods(getShell(), SWT.NULL);
		boolean result = inst.open(mainObject);
		if (result) {
			updateTableTopIndex();
		}
	}

	// 상품, 지출, 소득 등록 및 열람 '구입상품 추가' 버튼 클릭시.
	private void periodTotalAddGoodsMouseUp(MouseEvent evt) {
		this.periodTotalAddGoodsButtonMouseUp();
	}

	// 상품 지출, 소득 등록 및 열람 '이 조건으로 검색' 버튼 클릭시.
	private void periodTotalSearchButtonMouseUp() {
		ArrayList<Integer> bunryuList = new ArrayList<Integer>();
		Character sellFlg = null;

		if (periodTotalBunryuBuyGoodsCheckBox.getSelection() || periodTotalSellGoodsCheckBox.getSelection()) {
			bunryuList.add(Consts.BUNRYU_GOODS);
			if (periodTotalBunryuBuyGoodsCheckBox.getSelection() && ! periodTotalSellGoodsCheckBox.getSelection()) {
				sellFlg = '0';
			}
			if (! periodTotalBunryuBuyGoodsCheckBox.getSelection() && periodTotalSellGoodsCheckBox.getSelection()) {
				sellFlg = '1';
			}
		}

		if (periodTotalSuibCheckBox.getSelection()) {
			bunryuList.add(Consts.BUNRYU_SUIB);
		}

		if (periodTotalJichulCheckBox.getSelection()) {
			bunryuList.add(Consts.BUNRYU_JICHUL);
		}
		try {
			List<PeriodTotalBean> goodsList = null;
			if (bunryuList != null && ! bunryuList.isEmpty()) {
				goodsList = periodTotalService.getPeriodTotalList(
					bunryuList, sellFlg,		// 모든 분류, 판매된 상품, 판매안된 상품 모두다.
					periodTotalSearchGoodsNoText.getText(), periodTotalSearchGoodsNameText.getText(),
					periodTotalSearchKindCombo.getText(), periodTotalSearchColorCombo.getText(), periodTotalSearchMemoText.getText(),
					periodTotalFromDateYearCombo.getText(), periodTotalFromDateMonthCombo.getText(), periodTotalFromDateDayCombo.getText(),
					periodTotalToDateYearCombo.getText(), periodTotalToDateMonthCombo.getText(), periodTotalToDateDayCombo.getText()
					);
			}
			this.periodTotalTableAddDatas(goodsList);

			if (periodTotalFromDateYearCombo.getText().equals(periodTotalToDateYearCombo.getText()) &&
					periodTotalFromDateMonthCombo.getText().equals(periodTotalToDateMonthCombo.getText()) &&
					periodTotalFromDateDayCombo.getText().equals("01") &&
					periodTotalToDateDayCombo.getText().equals(String.valueOf(util.getLastDay(Integer.valueOf(periodTotalToDateYearCombo.getText()), Integer.valueOf(periodTotalToDateMonthCombo.getText()))))
					) {
				periodTotalSearchAreaMonthLabel.setText(periodTotalToDateYearCombo.getText() + "년 " + periodTotalToDateMonthCombo.getText() + "월 한달 간의 거래내역입니다.");
			} else if (
					periodTotalFromDateYearCombo.getText().equals(String.valueOf(aMonthAgoYearMonthDay[0])) &&
					periodTotalFromDateMonthCombo.getText().equals(String.format("%02d", aMonthAgoYearMonthDay[1])) &&
					periodTotalFromDateDayCombo.getText().equals(String.format("%02d", aMonthAgoYearMonthDay[2])) &&
					periodTotalToDateYearCombo.getText().equals(String.valueOf(thisYear)) &&
					periodTotalToDateMonthCombo.getText().equals(String.format("%02d", thisMonth)) &&
					periodTotalToDateDayCombo.getText().equals(String.format("%02d", thisDay))
					) {
				periodTotalSearchAreaMonthLabel.setText("현재로부터 한달 전까지의 거래내역입니다.");
			} else {
				periodTotalSearchAreaMonthLabel.setText(periodTotalFromDateYearCombo.getText() + "년 " + periodTotalFromDateMonthCombo.getText() + "월 " +
						periodTotalFromDateDayCombo.getText() + "일부터 " + periodTotalToDateYearCombo.getText() + "년 " + periodTotalToDateMonthCombo.getText() + "월 " +
						periodTotalToDateDayCombo.getText() + "일까지의 거래내역입니다."
						);
			}
			
			periodTotalSearchKeywordDto.setBuyDateFromYear(periodTotalFromDateYearCombo.getText());
			periodTotalSearchKeywordDto.setBuyDateFromMonth(periodTotalFromDateMonthCombo.getText());
			periodTotalSearchKeywordDto.setBuyDateFromDay(periodTotalFromDateDayCombo.getText());
			periodTotalSearchKeywordDto.setBuyDateToYear(periodTotalToDateYearCombo.getText());
			periodTotalSearchKeywordDto.setBuyDateToMonth(periodTotalToDateMonthCombo.getText());
			periodTotalSearchKeywordDto.setBuyDateToDay(periodTotalToDateDayCombo.getText());
			periodTotalSearchKeywordDto.setGoodsNo(periodTotalSearchGoodsNoText.getText());
			periodTotalSearchKeywordDto.setKind(periodTotalSearchKindCombo.getText());
			periodTotalSearchKeywordDto.setMemo(periodTotalSearchMemoText.getText());
			periodTotalSearchKeywordDto.setGoodsName(periodTotalSearchGoodsNameText.getText());
			periodTotalSearchKeywordDto.setColor(periodTotalSearchColorCombo.getText());
			periodTotalSearchKeywordDto.setBuyFlag(periodTotalBunryuBuyGoodsCheckBox.getSelection());
			periodTotalSearchKeywordDto.setSellFlag(periodTotalSellGoodsCheckBox.getSelection());
			periodTotalSearchKeywordDto.setInFlag(periodTotalSuibCheckBox.getSelection());
			periodTotalSearchKeywordDto.setOutFlag(periodTotalJichulCheckBox.getSelection());
		} catch (SQLException e) {
			e.printStackTrace();
			util.showErrorMsg(getShell(), e.getMessage());
		}
	}

	// 상품, 지출, 소득 등록 및 열람 테이블 갱신.
	private void periodTotalTableAddDatas(List<PeriodTotalBean> goodsList) {
		this.periodTotalTable.removeAll();

		Long suibTotal = 0l;
		Long jichulTotal = 0l;

		if (goodsList != null) {

			for (PeriodTotalBean bean:goodsList) {
				tableItem = new TableItem(periodTotalTable, SWT.NONE);

				String bunryu = bean.getBunryu() != null ? String.valueOf(bean.getBunryu()) : "";
				if (bean.getBunryu() != null) {
					if (bean.getBunryu() == Consts.BUNRYU_GOODS && bean.getSellFlg() == '0') {
						bunryu = "상품구입";
						tableItem.setBackground(SWTResourceManager.getColor(140, 235, 180));
					} else if (bean.getBunryu() == Consts.BUNRYU_GOODS && bean.getSellFlg() == '1') {
						bunryu = "상품판매";
						tableItem.setBackground(SWTResourceManager.getColor(255, 255, 180));
					} else if (bean.getBunryu() == Consts.BUNRYU_SUIB) {
						bunryu = "수입";
						tableItem.setBackground(SWTResourceManager.getColor(180, 180, 255));
					} else if (bean.getBunryu() == Consts.BUNRYU_JICHUL) {
						bunryu = "지출";
						tableItem.setBackground(SWTResourceManager.getColor(255, 150, 150));
					}
				} 
				
				tableItem.setText(
								new String[] {
										String.valueOf(bean.getNo()),
										bunryu,
										bean.getName() != null ? bean.getName().replace(SWT.LF, ' ') : "",
										bean.getKind(),
										bean.getColor(),
										bean.getMemo() != null ? bean.getMemo().replace(SWT.LF, ' ') : "",
										util.addCommaForPrice(bean.getBuyPrice()),
//										util.addCommaForPrice(bean.getSellHopePrice()),
										util.addCommaForPrice(bean.getSellPrice()),
										bean.getPlace(),
										util.applyDateFormat(bean.getDate(), Consts.SLASH_DATE_FORMAT)
//										bean.getSellDate() != null ? bean.getSellDate().toString() : "",
//										bean.getBarcode()
								}
								);
				if (bean != null) {
					if (bean.getSellPrice() != null) {
						suibTotal += bean.getSellPrice();
					}
					if (bean.getBuyPrice() != null) {
						jichulTotal += bean.getBuyPrice();
					}
				}
			}
			periodTotalSuibTotalValueLabel.setText(util.addCommaForPrice(suibTotal));
			periodTotalJichulTotalValueLabel.setText(util.addCommaForPrice(jichulTotal));
			periodTotalMagineValueLabel.setText(util.addCommaForPrice(suibTotal - jichulTotal));
		}
	}

	// 상품, 지출, 소득 등록 및 열람 한달 전부터의 모든 내역보기 눌렀을 때.
	private void periodTotalSearchEraseAllButtonMouseUp(MouseEvent evt) {

		for (int i = 0; i < periodTotalFromDateYearCombo.getItemCount(); i++) {
			if (periodTotalFromDateYearCombo.getItem(i).equals(String.valueOf(aMonthAgoYearMonthDay[0]))) {
				periodTotalFromDateYearCombo.select(i);
			}
		}
		periodTotalFromDateMonthCombo.select(aMonthAgoYearMonthDay[1] -1);
		util.getLastDayWhenYearAndMonthChoosed(periodTotalFromDateYearCombo, periodTotalFromDateMonthCombo, periodTotalFromDateDayCombo, false);
		periodTotalFromDateDayCombo.select(aMonthAgoYearMonthDay[2] -1);

		periodTotalToDateYearCombo.select(1);
		periodTotalToDateMonthCombo.select(thisMonth -1);
		util.getLastDayWhenYearAndMonthChoosed(periodTotalToDateYearCombo, periodTotalToDateMonthCombo, periodTotalToDateDayCombo, false);
		periodTotalToDateDayCombo.select(thisDay -1);


		periodTotalSearchGoodsNoText.setText("");
		periodTotalSearchGoodsNameText.setText("");
		periodTotalSearchKindCombo.setText("");
		periodTotalSearchColorCombo.setText("");
		periodTotalSearchMemoText.setText("");
		periodTotalBunryuBuyGoodsCheckBox.setSelection(true);
		periodTotalSellGoodsCheckBox.setSelection(true);
		periodTotalSuibCheckBox.setSelection(true);
		periodTotalJichulCheckBox.setSelection(true);

		periodTotalSearchButtonMouseUp();
	}

	// 상품, 지출, 소득 등록 및 열람의 테이블 아이템 더블 클릭 했을 때.
	private void periodTotalTableMouseDoubleClick(Event e) {
		if (e.x > periodTotalNoTableColumn.getWidth()) {
			return;
		}

		Point pt = new Point(20, e.y);
		TableItem selection = periodTotalTable.getItem(pt);
		if (selection != null) {
			String selectedId = selection.getText();	// ID취득

			GoodsListBean bean = null;
			Integer bunryu = null;
			Character sellFlg = null;
			try {
				GoodsListDao dao = new GoodsListDao();
				// 아이템 분류 (상품, 소비, 지출) 취득
				bean = dao.getGoodsInfoWithId(Long.valueOf(selectedId), null, null);
				bunryu = bean.getBunryu();
				sellFlg = bean.getSellFlg();

				if (bunryu == Consts.BUNRYU_GOODS) {
					if (sellFlg == '0') {			// 구입상품 (미판매)
						GoodsListDetail inst = new GoodsListDetail(getShell(), SWT.NULL);
						GoodsListBean resultBean = inst.open(mainObject, Long.valueOf(selectedId).longValue());
						// 데이터 갱신시 화면 테이블 속 표시 해당데이터 고치기.
						if (resultBean != null) {
							this.updateTableTopIndex();
						}
					} else if (sellFlg == '1') {		// 이미 판매상품.
						SellGoodsModify inst = new SellGoodsModify(getShell(), SWT.NULL);
						GoodsListBean resultBean = inst.open(Long.valueOf(selectedId).longValue());
						// 데이터 갱신시 화면 테이블 속 표시 해당데이터 고치기.
						if (resultBean != null) {
							this.updateTableTopIndex();
						}
					}
				} else if (bunryu == Consts.BUNRYU_JICHUL) {	// 지출
					JichulModify inst = new JichulModify(getShell(), SWT.NULL);
					GoodsListBean resultBean = inst.open(Long.valueOf(selectedId).longValue());
					if (resultBean != null) {
						this.updatePeriodTotalTableTopIndex();
					}
				} else if (bunryu == Consts.BUNRYU_SUIB) {	// 수입
					SuibModify inst = new SuibModify(getShell(), SWT.NULL);
					GoodsListBean resultBean = inst.open(Long.valueOf(selectedId).longValue());
					if (resultBean != null) {
						this.updatePeriodTotalTableTopIndex();
					}
				}
			} catch (NumberFormatException e3) {
				util.showMsg(getShell(), "숫자 변환 에러");
			} catch (SQLException e4) {
				util.showMsg(getShell(), "아이템 취득 DB 에러입니다.\n" + e4.getMessage());
			}
//			GoodsListDetail inst = new GoodsListDetail(getShell(), SWT.NULL);
//			inst.open(Long.valueOf(selectedId).longValue());
//			goodsListTable.redraw();	// TODO: 테이블 다시 그리기 처리. DB내용 바뀌었을 때 재출력 처리할 것.
//			goodsListTable.deselectAll();	// 다음 클릭시 빈칸을 클릭해도 예전 레코드가 선택되지 않도록 전 선택 해제
		}
	}

	// 상품 정보 등 수정시, 현재 보유상품 리스트 테이블과 상품,지출,소득 등록 및 열람 테이블 갱신 후 원래 있던 TopIndex로 돌아가기. (원래 표시하던 부분 표시)
	public void updateTableTopIndex() {
		// 데이터 갱신시 화면 테이블 속 표시 해당데이터 고치기.
		int goodsListTableTopIndex = goodsListTable.getTopIndex();
		int periodTotalTableTopIndex = periodTotalTable.getTopIndex();
		goodsListSearchButtonMouseUp();
		periodTotalSearchButtonMouseUp();
		goodsListTable.setTopIndex(goodsListTableTopIndex);
		periodTotalTable.setTopIndex(periodTotalTableTopIndex);
	}

	public void updatePeriodTotalTableTopIndex() {
		int periodTotalTableTopIndex = periodTotalTable.getTopIndex();
		periodTotalSearchButtonMouseUp();
		periodTotalTable.setTopIndex(periodTotalTableTopIndex);
	}
//
//	private void updateGoodsListTableTopIndex() {
//		int goodsListTableTopIndex = goodsListTable.getTopIndex();
//		goodsListSearchButtonMouseUp();
//		goodsListTable.setTopIndex(goodsListTableTopIndex);
//	}

	// 현재 보유상품, 상품,지출,소득 등록 및 열람 검색에리어 상품종류 콤보 업데이트.
	public void updateKindCombo() {
		List<KindMstBean> goodListKindMstList = new ArrayList<KindMstBean>();
		try {
			goodListKindMstList = goodsListService.getKindMst();
		} catch (SQLException e) {
		}
		goodsListSearchKindCombo.removeAll();
		goodsListSearchKindCombo.add("");
		for (KindMstBean kindMstBean : goodListKindMstList) {
			goodsListSearchKindCombo.add(kindMstBean.getName());
		}

		List<KindMstBean> periodTotalKindMstList = new ArrayList<KindMstBean>();
		try {
			periodTotalKindMstList = goodsListService.getKindMst();
		} catch (SQLException e) {
		}
		periodTotalSearchKindCombo.removeAll();
		periodTotalSearchKindCombo.add("");
		for (KindMstBean kindMstBean : periodTotalKindMstList) {
			periodTotalSearchKindCombo.add(kindMstBean.getName());
		}
	}

	public void updateColorCombo() {
		List<ColorMstBean> goodListColorMstList = new ArrayList<ColorMstBean>();
		try {
			goodListColorMstList = goodsListService.getColorMst();
		} catch (SQLException e) {
		}
		goodsListSearchColorCombo.removeAll();
		goodsListSearchColorCombo.add("");
		for (ColorMstBean colorMstBean : goodListColorMstList) {
			goodsListSearchColorCombo.add(colorMstBean.getName());
		}

		List<ColorMstBean> periodTotalColorMstList = new ArrayList<ColorMstBean>();
		try {
			periodTotalColorMstList = goodsListService.getColorMst();
		} catch (SQLException e) {
		}
		periodTotalSearchColorCombo.removeAll();
		periodTotalSearchColorCombo.add("");
		for (ColorMstBean colorMstBean : periodTotalColorMstList) {
			periodTotalSearchColorCombo.add(colorMstBean.getName());
		}

	}
	
	// 상품, 지출, 소득 등록 및 열람  수입추가 버튼 눌렀을 때.
	private void periodTotalAddSuibMouseUp(MouseEvent evt) {
		AddSuib inst = new AddSuib(getShell(), SWT.NULL);
		boolean result = false;
		try {
			result = inst.open();
		} catch (SQLException e) {
			util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
		}
		if (result) {
			updatePeriodTotalTableTopIndex();
		}
	}

	// 상품, 지출, 소득 등록 및 열람 지출 추가 버튼.
	private void periodTotalAddJichulMouseUp(MouseEvent evt) {
		AddJichul inst = new AddJichul(getShell(), SWT.NULL);
		boolean result = false;
		try {
			result = inst.open();
		} catch (SQLException e) {
			util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
		}
		if (result) {
			updatePeriodTotalTableTopIndex();
		}
	}

	// 관리 메뉴의 상품종류 리스트 취득, 화면에 표시.
//	public void showPreferenceKindCombos() {
//		
////		preferenceKindTable = new Table(preferenceKindComponent, SWT.NONE);
////		preferenceKindTable.setBounds(12, 46, 242, 160);
////		preferenceKindTable.setLinesVisible(true);
////		{
////			preferenceKindTableButtonColumn = new TableColumn(preferenceKindTable, SWT.NONE);
////			preferenceKindTableButtonColumn.setText("tableColumn1");
////			preferenceKindTableButtonColumn.setWidth(108);
////		}
////		{
////			preferenceKindTableNameColumn = new TableColumn(preferenceKindTable, SWT.NONE);
////			preferenceKindTableNameColumn.setText("tableColumn1");
////			preferenceKindTableNameColumn.setWidth(117);
////		}
//		
//		
//		
//		
//		int index = preferenceKindTable.getTopIndex();
//		preferenceKindTable.clearAll();
//		preferenceKindTable.removeAll();
//
//		try {
//			KindMstDao kindMstDao = new KindMstDao();
//			ArrayList<KindMstBean> unusedKindList = kindMstDao.getUnusedKind();
//
//			for (KindMstBean bean : unusedKindList) {
//				final TableItem item = new TableItem(preferenceKindTable, SWT.NONE);
//				item.setText(
//						new String[] {
//								bean.getName(), ""
//						});
//
//				TableEditor editor = new TableEditor (preferenceKindTable);
//
//				final Button testButton = new Button(preferenceKindTable, SWT.PUSH | SWT.CENTER);
//				testButton.pack();
//				testButton.setSize(85, 15);
//				testButton.setText("수정 및 삭제");
//				testButton.setData(bean);
//				testButton.addMouseListener(new MouseAdapter() {	public void mouseUp(MouseEvent evt) {
//
//						KindModify inst = new KindModify(getShell(), SWT.NONE);
////						boolean rst = inst.open(mainObject, (KindMstBean)((Button)evt.getSource()).getData());
//						boolean rst = inst.open(mainObject, (KindMstBean)(testButton.getData()));
//						if (rst) {
////							preferenceKindTable.clearAll();
////							preferenceKindTable.removeAll();
////							preferenceKindTable.redraw();
////							preferenceKindTable.remove(2);
//							preferenceKindTable.removeAll();
//							item.dispose();
//							testButton.dispose();
//							
////							preferenceKindTable.layout();
//							preferenceKindTable.redraw();
////							preferenceKindTable.clear(preferenceKindTable.indexOf(item));
////							preferenceKindTable.remove(preferenceKindTable.indexOf(item));
//						}
////System.out.println(rst);
//					}
//				});
//				editor.minimumWidth = testButton.getSize().x;
//				editor.horizontalAlignment = SWT.CENTER;
//				editor.setEditor(testButton, item, 1);
//			}
//			preferenceKindTable.setTopIndex(index);
//		} catch (SQLException e) {
//			util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
//		}
//	}
	public void showPreferenceKindCombos() {
		
		int index = preferenceKindTable.getTopIndex();
		preferenceKindTable.clearAll();
		preferenceKindTable.removeAll();

		try {
			KindMstDao kindMstDao = new KindMstDao();
			ArrayList<KindMstBean> unusedKindList = kindMstDao.getUnusedKind();

			for (KindMstBean bean : unusedKindList) {
				TableItem item = new TableItem(preferenceKindTable, SWT.NONE);
				item.setText(
						new String[] {
								bean.getName()
						});
				item.setData(bean);
			}
			preferenceKindTable.setTopIndex(index);
		} catch (SQLException e) {
			util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
		}
	}
	
	private void preferenceKindTableMouseDoubleClick(Event evt) {

		if (evt.x > preferenceKindTableButtonColumn.getWidth()) {
			return;
		}

		Point pt = new Point(20, evt.y);
		TableItem selection = preferenceKindTable.getItem(pt);
		if (selection != null) {
			KindMstBean bean = (KindMstBean)selection.getData();
			KindModify inst = new KindModify(getShell(), SWT.NONE);

			inst.open(mainObject, bean);
		}
	}

	public void showPreferenceColorCombos() {
		
		int index = preferenceColorTable.getTopIndex();
		preferenceColorTable.clearAll();
		preferenceColorTable.removeAll();

		try {
			ColorMstDao colorMstDao = new ColorMstDao();
			ArrayList<ColorMstBean> unusedColorList = colorMstDao.getUnusedColor();

			for (ColorMstBean bean : unusedColorList) {
				TableItem item = new TableItem(preferenceColorTable, SWT.NONE);
				item.setText(
						new String[] {
								bean.getName()
						});
				item.setData(bean);
			}
			preferenceColorTable.setTopIndex(index);
		} catch (SQLException e) {
			util.showErrorMsg(getShell(), "데이터베이스 에러\n\n" + e.getMessage());
		}
	}
	
	private void preferenceColorTableMouseDoubleClick(Event evt) {

		if (evt.x > preferenceColorTableButtonColumn.getWidth()) {
			return;
		}

		Point pt = new Point(20, evt.y);
		TableItem selection = preferenceColorTable.getItem(pt);
		if (selection != null) {
			ColorMstBean bean = (ColorMstBean)selection.getData();
			ColorModify inst = new ColorModify(getShell(), SWT.NONE);

			inst.open(mainObject, bean);
//			if (rst) {
//				showPreferenceColorCombos();
//			}
		}
	}
}
