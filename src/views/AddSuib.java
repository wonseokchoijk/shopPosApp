package views;
import java.sql.SQLException;
import java.util.Calendar;

import bean.GoodsListBean;
import com.cloudgarden.resource.SWTResourceManager;
import common.Utilities;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;

import service.AddSuibService;
import service.GoodsListService;

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
public class AddSuib extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Button AddSuibCancelButton;
	private Button AddSuibConfirmButton;
	private Text AddSuibNameValueText;
	private Text AddSuibMemoValueText;
	private Text AddSuibSellPriceValueText;
	private Label AddSuibNameLabel;
	private Label AddSuibMemoLabel;
	private Label AddSuibSellPriceLabel;
	private Label AddSuibBuyPriceWonLabel;
	GoodsListService goodsListService = new GoodsListService();
	AddSuibService AddSuibService = new AddSuibService();

//	ArrayList<GoodsListBean> result = new ArrayList<GoodsListBean>();
	GoodsListBean bean = new GoodsListBean();
	private Label AddSuibInfoLabel;

	Utilities util = new Utilities();
//	DecimalFormat df = new DecimalFormat("#,###");

	boolean result = false;
	private Label goodsListDetailBuyDateLabel;
	private Text buyDateYearText;
	private Label buyDateYearLabel;
	private Text buyDateMonthText;
	private Label BuyDateMonthLabel;
	private Text buyDateDayText;
	private Label buyDateDayLabel;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			AddSuib inst = new AddSuib(shell, SWT.NULL);
//			inst.open(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public AddSuib(Shell parent, int style) {
		super(parent, style);
	}

	public boolean open() throws SQLException {

		Shell parent = getParent();
		dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

		{
			//Register as a resource user - SWTResourceManager will
			//handle the obtaining and disposing of resources
			SWTResourceManager.registerResourceUser(dialogShell);
		}

		dialogShell.setLayout(new FormLayout());
		dialogShell.layout();
		dialogShell.pack();			
		dialogShell.setSize(386, 327);
		dialogShell.setText("수입 정보 추가");

		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, -20);
			composite1LData.width = 386;
			composite1LData.height = 308;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				AddSuibNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddSuibNameLabel.setText("\ud56d\ubaa9\uba85 : ");
				AddSuibNameLabel.setBounds(19, 65, 65, 19);
				AddSuibNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddSuibNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				AddSuibNameValueText.setBounds(92, 68, 281, 42);
				AddSuibNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddSuibNameValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddSuibNameValueText.setTextLimit(255);
			}
			{
				AddSuibMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddSuibMemoLabel.setText("\uba54\ubaa8 : ");
				AddSuibMemoLabel.setBounds(33, 122, 51, 17);
				AddSuibMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddSuibMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				AddSuibMemoValueText.setBounds(92, 123, 279, 57);
				AddSuibMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddSuibMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddSuibMemoValueText.setTextLimit(500);
			}
			{
				AddSuibSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddSuibSellPriceLabel.setText("\uc18c\ub4dd\uc561 : ");
				AddSuibSellPriceLabel.setBounds(17, 192, 83, 17);
				AddSuibSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddSuibSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				AddSuibSellPriceValueText.setBounds(114, 193, 137, 20);
				AddSuibSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddSuibSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddSuibSellPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				AddSuibBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				AddSuibBuyPriceWonLabel.setText("\uc6d0");
				AddSuibBuyPriceWonLabel.setBounds(256, 194, 51, 20);
				AddSuibBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				AddSuibSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddSuibSellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
//				AddSuibSellPriceLabel.setBounds(15, 224, 83, 17);
//				AddSuibSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				AddSuibSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
//				AddSuibSellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
//				AddSuibSellPriceValueText.setBounds(112, 222, 140, 22);
//				AddSuibSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				AddSuibSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//				AddSuibSellPriceValueText.addVerifyListener(new VerifyListener() {
//					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
//							evt.doit = evt.text.matches("[0-9]*");
//						}
//					});
//}
//				{
//					AddSuibSellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
//					AddSuibSellPriceWonLabel.setText("\uc6d0");
//				AddSuibSellPriceWonLabel.setBounds(254, 225, 51, 20);
//				AddSuibSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				AddSuibBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddSuibBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
//				AddSuibBuyDateLabel.setBounds(18, 280, 74, 17);
//				AddSuibBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				AddSuibBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				AddSuibBuyDateValueText.setBounds(110, 279, 261, 20);
//				AddSuibBuyDateValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				AddSuibBuyDateValueText.setEditable(false);
//				AddSuibBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				AddSuibBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddSuibBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				AddSuibBarcodeLabel.setBounds(12, 310, 74, 17);
//				AddSuibBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				AddSuibBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				AddSuibBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				AddSuibBarcodeValueText.setBounds(89, 310, 285, 20);
//				AddSuibBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				AddSuibBarcodeValueText.setEditable(false);
//				AddSuibBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				AddSuibCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				AddSuibCancelButton.setText("\ucde8 \uc18c");
				AddSuibCancelButton.setBounds(14, 258, 67, 37);
				AddSuibCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				AddSuibCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				AddSuibConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				AddSuibConfirmButton.setText("\uc774 \uc218\uc785 \uc815\ubcf4 \ucd94\uac00");
				AddSuibConfirmButton.setBounds(181, 259, 193, 37);
				AddSuibConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							AddSuibConfirmButtonMouseUp();
						}
					}
				});

				AddSuibConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						AddSuibConfirmButtonMouseUp();
					}
				});
//				AddSuibConfirmButton.setFocus();
			}
			{
				AddSuibInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
				AddSuibInfoLabel.setText("\uc218\uc785 \uc815\ubcf4\ub97c \ucd94\uac00\ud569\ub2c8\ub2e4.\n\ud56d\ubaa9\uba85\uacfc \uc18c\ub4dd\uc561\uc740 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				AddSuibInfoLabel.setBounds(9, 23, 345, 41);
			}
			{
				buyDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateDayLabel.setText("\uc77c");
				buyDateDayLabel.setBounds(308, 227, 24, 20);
				buyDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			Calendar oCalendar = Calendar.getInstance( );
			{
				buyDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateDayText.setTextLimit(2);
				buyDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateDayText.setText(String.format("%02d", oCalendar.get(Calendar.DAY_OF_MONTH)));
				buyDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateDayText.setBounds(269, 226, 33, 20);
				buyDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				BuyDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				BuyDateMonthLabel.setText("\uc6d4");
				BuyDateMonthLabel.setBounds(241, 227, 24, 20);
				BuyDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateMonthText.setTextLimit(2);
				buyDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateMonthText.setText(String.format("%02d", oCalendar.get(Calendar.MONTH) + 1));
				buyDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateMonthText.setBounds(200, 226, 37, 20);
				buyDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				buyDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateYearLabel.setText("\ub144");
				buyDateYearLabel.setBounds(177, 228, 23, 20);
				buyDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateYearText.setTextLimit(4);
				buyDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateYearText.setText(String.format("%02d", oCalendar.get(Calendar.YEAR)));
				buyDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateYearText.setBounds(113, 226, 60, 20);
				buyDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				goodsListDetailBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailBuyDateLabel.setText("\uc218\uc785\ub0a0\uc9dc : ");
				goodsListDetailBuyDateLabel.setBounds(12, 226, 85, 17);
				goodsListDetailBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,1,false,false));
			}
		}
		dialogShell.setLocation(getParent().toDisplay(300, 100));
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		return result;
	}

	// 이 상품을 판매리스트에 추가 버튼 클릭시.
	private void AddSuibConfirmButtonMouseUp() {
		if (util.isEmpty(AddSuibNameValueText.getText())) {
			util.showMsg(dialogShell, "항목명을 입력해주십시오.");
			return;
		}
		if (util.isEmpty(AddSuibSellPriceValueText.getText())) {
			util.showMsg(dialogShell, "소득액을 입력해주십시오.");
			return;
		}

		if (util.isEmpty(buyDateYearText.getText()) || util.isEmpty(buyDateMonthText.getText()) || util.isEmpty(buyDateDayText.getText())) {
			util.showMsg(dialogShell, "수입날짜의 연월일을 모두 입력해주십시오.");
			return;
		} else {
			if ( ! util.isCorrectDate(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText())) {
				util.showMsg(dialogShell, "수입날짜의 입력치가 올바른 날짜가 아닙니다.");
				return;
			}
		}
		
		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 수입 정보를 등록하시겠습니까?");

		if (yesOrNo != SWT.YES) {
			return;
		}
		
		try {
			bean.setName(AddSuibNameValueText.getText().trim());
//			bean.setKind(AddSuibKindCombo.getText());
//			bean.setColor(AddSuibColorCombo.getText());
			String memo = AddSuibMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setSellPrice(Long.valueOf(AddSuibSellPriceValueText.getText()));
			bean.setBuyDate(util.getDateFromString(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText()));
//			bean.setSellHopePrice(! util.isEmpty(AddSuibSellHopePriceValueText.getText()) ? Long.valueOf(AddSuibSellHopePriceValueText.getText()) : null);
//			String place = AddSuibPlaceValueText.getText().trim();
//			bean.setPlace(! util.isEmpty(place) ? place : null);

			try {
				AddSuibService.insertSuib(bean);
				result = true;
				dialogShell.dispose();
			} catch (SQLException e) {
				util.showErrorMsg(dialogShell, "수입 정보를 등록하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
			}
		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
		}
	}
}
