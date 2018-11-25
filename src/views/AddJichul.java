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
import service.AddJichulService;
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
public class AddJichul extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Button AddJichulCancelButton;
	private Button AddJichulConfirmButton;
	private Text AddJichulNameValueText;
	private Text AddJichulMemoValueText;
	private Text AddJichulBuyPriceValueText;
	private Label AddJichulNameLabel;
	private Label AddJichulMemoLabel;
	private Label AddJichulBuyPriceLabel;
	private Label AddJichulBuyPriceWonLabel;
	GoodsListService goodsListService = new GoodsListService();
	AddJichulService AddJichulService = new AddJichulService();

	GoodsListBean bean = new GoodsListBean();
	private Label AddJichulInfoLabel;

	Utilities util = new Utilities();

	boolean result = false;
	private Label sellDateDayLabel;
	private Label sellDateLabel;
	private Text buyDateYearText;
	private Label sellDateYearLabel;
	private Text buyDateMonthText;
	private Label sellDateMonthLabel;
	private Text buyDateDayText;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			AddJichul inst = new AddJichul(shell, SWT.NULL);
//			inst.open(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public AddJichul(Shell parent, int style) {
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
		dialogShell.setSize(386, 336);
		dialogShell.setText("지출 정보 추가");

		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, -20);
			composite1LData.width = 386;
			composite1LData.height = 317;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				AddJichulNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulNameLabel.setText("\ud56d\ubaa9\uba85 : ");
				AddJichulNameLabel.setBounds(19, 65, 65, 19);
				AddJichulNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				AddJichulNameValueText.setBounds(92, 68, 281, 42);
				AddJichulNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulNameValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulNameValueText.setTextLimit(255);
			}
			{
				AddJichulMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulMemoLabel.setText("\uba54\ubaa8 : ");
				AddJichulMemoLabel.setBounds(33, 122, 51, 17);
				AddJichulMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				AddJichulMemoValueText.setBounds(92, 123, 279, 57);
				AddJichulMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulMemoValueText.setTextLimit(500);
			}
			{
				AddJichulBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulBuyPriceLabel.setText("\uc9c0\ucd9c\uc561 : ");
				AddJichulBuyPriceLabel.setBounds(12, 192, 71, 17);
				AddJichulBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				AddJichulBuyPriceValueText.setBounds(97, 193, 137, 20);
				AddJichulBuyPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulBuyPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				AddJichulBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				AddJichulBuyPriceWonLabel.setText("\uc6d0");
				AddJichulBuyPriceWonLabel.setBounds(239, 194, 51, 20);
				AddJichulBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				AddJichulSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddJichulSellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
//				AddJichulSellPriceLabel.setBounds(15, 224, 83, 17);
//				AddJichulSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				AddJichulSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
//				AddJichulSellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
//				AddJichulSellPriceValueText.setBounds(112, 222, 140, 22);
//				AddJichulSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				AddJichulSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//				AddJichulSellPriceValueText.addVerifyListener(new VerifyListener() {
//					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
//							evt.doit = evt.text.matches("[0-9]*");
//						}
//					});
//}
//				{
//					AddJichulSellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
//					AddJichulSellPriceWonLabel.setText("\uc6d0");
//				AddJichulSellPriceWonLabel.setBounds(254, 225, 51, 20);
//				AddJichulSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				AddJichulBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddJichulBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
//				AddJichulBuyDateLabel.setBounds(18, 280, 74, 17);
//				AddJichulBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				AddJichulBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				AddJichulBuyDateValueText.setBounds(110, 279, 261, 20);
//				AddJichulBuyDateValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				AddJichulBuyDateValueText.setEditable(false);
//				AddJichulBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				AddJichulBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				AddJichulBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				AddJichulBarcodeLabel.setBounds(12, 310, 74, 17);
//				AddJichulBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				AddJichulBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				AddJichulBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				AddJichulBarcodeValueText.setBounds(89, 310, 285, 20);
//				AddJichulBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				AddJichulBarcodeValueText.setEditable(false);
//				AddJichulBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				AddJichulCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				AddJichulCancelButton.setText("\ucde8 \uc18c");
				AddJichulCancelButton.setBounds(14, 267, 67, 37);
				AddJichulCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				AddJichulCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				AddJichulConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				AddJichulConfirmButton.setText("\uc774 \uc9c0\ucd9c \uc815\ubcf4 \ucd94\uac00");
				AddJichulConfirmButton.setBounds(181, 268, 193, 37);
				AddJichulConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							AddJichulConfirmButtonMouseUp();
						}
					}
				});

				AddJichulConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						AddJichulConfirmButtonMouseUp();
					}
				});
//				AddJichulConfirmButton.setFocus();
			}
			{
				AddJichulInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
				AddJichulInfoLabel.setText("\uc9c0\ucd9c \uc815\ubcf4\ub97c \ucd94\uac00\ud569\ub2c8\ub2e4.\n\ud56d\ubaa9\uba85\uacfc \uc9c0\ucd9c\uc561\uc740 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				AddJichulInfoLabel.setBounds(9, 23, 345, 41);
			}
			{
				sellDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateDayLabel.setText("\uc77c");
				sellDateDayLabel.setBounds(293, 227, 27, 20);
				sellDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			Calendar oCalendar = Calendar.getInstance( );
			{
				buyDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				buyDateDayText.setTextLimit(2);
				buyDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateDayText.setText(String.format("%02d", oCalendar.get(Calendar.DAY_OF_MONTH)));
				buyDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateDayText.setBounds(254, 226, 33, 21);
				buyDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateMonthLabel.setText("\uc6d4");
				sellDateMonthLabel.setBounds(226, 227, 22, 20);
				sellDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				buyDateMonthText.setTextLimit(2);
				buyDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateMonthText.setText(String.format("%02d", oCalendar.get(Calendar.MONTH) + 1));
				buyDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateMonthText.setBounds(185, 226, 36, 21);
				buyDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateYearLabel.setText("\ub144");
				sellDateYearLabel.setBounds(162, 228, 25, 19);
				sellDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				buyDateYearText.setTextLimit(4);
				buyDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateYearText.setText(String.format("%02d", oCalendar.get(Calendar.YEAR)));
				buyDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateYearText.setBounds(98, 226, 60, 21);
				buyDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellDateLabel.setText("\uc9c0\ucd9c\ub0a0\uc9dc : ");
				sellDateLabel.setBounds(23, 226, 60, 21);
				sellDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,1,false,false));
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
	private void AddJichulConfirmButtonMouseUp() {
		if (util.isEmpty(AddJichulNameValueText.getText())) {
			util.showMsg(dialogShell, "항목명을 입력해주십시오.");
			return;
		}
		if (util.isEmpty(AddJichulBuyPriceValueText.getText())) {
			util.showMsg(dialogShell, "지출액을 입력해주십시오.");
			return;
		}
		
		if (util.isEmpty(buyDateYearText.getText()) || util.isEmpty(buyDateMonthText.getText()) || util.isEmpty(buyDateDayText.getText())) {
			util.showMsg(dialogShell, "지출날짜의 연월일을 모두 입력해주십시오.");
			return;
		} else {
			if ( ! util.isCorrectDate(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText())) {
				util.showMsg(dialogShell, "지출날짜의 입력치가 올바른 날짜가 아닙니다.");
				return;
			}
		}

		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 지출 정보를 등록하시겠습니까?");

		if (yesOrNo != SWT.YES) {
			return;
		}
		
		try {
			bean.setName(AddJichulNameValueText.getText().trim());
//			bean.setKind(AddJichulKindCombo.getText());
//			bean.setColor(AddJichulColorCombo.getText());
			String memo = AddJichulMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setBuyPrice(Long.valueOf(AddJichulBuyPriceValueText.getText()));
			bean.setBuyDate(util.getDateFromString(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText()));
//			bean.setSellHopePrice(! util.isEmpty(AddJichulSellHopePriceValueText.getText()) ? Long.valueOf(AddJichulSellHopePriceValueText.getText()) : null);
//			String place = AddJichulPlaceValueText.getText().trim();
//			bean.setPlace(! util.isEmpty(place) ? place : null);

			try {
				AddJichulService.insertJichul(bean);
				result = true;
				dialogShell.dispose();
			} catch (SQLException e) {
				util.showErrorMsg(dialogShell, "지출 정보를 등록하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
			}
		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
		}
	}
}
