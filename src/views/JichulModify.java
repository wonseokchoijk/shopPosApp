package views;
import java.sql.SQLException;
import bean.GoodsListBean;
import com.cloudgarden.resource.SWTResourceManager;

import common.Consts;
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
import service.GoodsListService;
import service.JichulModifyService;

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
public class JichulModify extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Button AddJichulCancelButton;
	private Text buyDateYearText;
	private Label buyDateYearLabel;
	private Text buyDateMonthText;
	private Label BuyDateMonthLabel;
	private Text buyDateDayText;
	private Label buyDateDayLabel;
	private Button AddJichulConfirmButton;
	private Text AddJichulNameValueText;
	private Text AddJichulMemoValueText;
	private Text AddJichulBuyPriceValueText;
	private Label AddJichulNameLabel;
	private Button AddJichul;
	private Label AddJichulMemoLabel;
	private Label AddJichulBuyPriceLabel;
	private Label AddJichulBuyPriceWonLabel;
	private Label AddJichulNoLabel;
	private Label AddJichulNoValueLabel;
	private Label AddJichulBuyDateLabel;
	GoodsListService goodsListService = new GoodsListService();
	JichulModifyService jichulModifyService = new JichulModifyService();

	Long id = null;

	GoodsListBean bean = new GoodsListBean();
	private Label AddJichulInfoLabel;

	Utilities util = new Utilities();

	boolean returnOk = false;

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

	public JichulModify(Shell parent, int style) {
		super(parent, style);
	}

	public GoodsListBean open(Long goodsId) throws SQLException {

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
		dialogShell.setSize(386, 345);
		dialogShell.setText("지출 정보 수정");

		this.id = goodsId; 
		GoodsListBean dbData = jichulModifyService.getGoodsDetail(this.id);
		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, -20);
			composite1LData.width = 386;
			composite1LData.height = 343;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				AddJichulNoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulNoLabel.setText("No : ");
				AddJichulNoLabel.setBounds(19, 65, 65, 19);
				AddJichulNoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulNoValueLabel = new Label(sellGoodsComposite, SWT.LEFT);
				AddJichulNoValueLabel.setText(String.valueOf(this.id));
				AddJichulNoValueLabel.setBounds(92, 66, 106, 19);
			}
			{
				AddJichulNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulNameLabel.setText("\ud56d\ubaa9\uba85 : ");
				AddJichulNameLabel.setBounds(19, 93, 65, 19);
				AddJichulNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				AddJichulNameValueText.setBounds(92, 96, 281, 42);
				AddJichulNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulNameValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulNameValueText.setText(dbData.getName() != null ? dbData.getName() : "");
				AddJichulNameValueText.setTextLimit(255);
			}
			{
				AddJichulMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulMemoLabel.setText("\uba54\ubaa8 : ");
				AddJichulMemoLabel.setBounds(33, 150, 51, 17);
				AddJichulMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				AddJichulMemoValueText.setBounds(92, 151, 279, 57);
				AddJichulMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulMemoValueText.setText(dbData.getMemo() != null ? dbData.getMemo() : "");
				AddJichulMemoValueText.setTextLimit(500);
			}
			{
				AddJichulBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulBuyPriceLabel.setText("\uc9c0\ucd9c\uc561 : ");
				AddJichulBuyPriceLabel.setBounds(17, 220, 83, 17);
				AddJichulBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				AddJichulBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				AddJichulBuyPriceValueText.setBounds(114, 221, 137, 20);
				AddJichulBuyPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				AddJichulBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				AddJichulBuyPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
				AddJichulBuyPriceValueText.setText(dbData.getBuyPrice() != null ? String.valueOf(dbData.getBuyPrice()) : "");
			}
			{
				AddJichulBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				AddJichulBuyPriceWonLabel.setText("\uc6d0");
				AddJichulBuyPriceWonLabel.setBounds(256, 222, 51, 20);
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
			{
				AddJichulBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				AddJichulBuyDateLabel.setText("\uc9c0\ucd9c\ub0a0\uc9dc : ");
				AddJichulBuyDateLabel.setBounds(13, 254, 85, 17);
				AddJichulBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
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
				AddJichulCancelButton.setBounds(14, 290, 67, 37);
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
				AddJichulConfirmButton.setText("\uc704 \ub0b4\uc6a9\ub300\ub85c \uc9c0\ucd9c \uc815\ubcf4 \uc218\uc815");
				AddJichulConfirmButton.setBounds(181, 291, 193, 37);
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
				AddJichulInfoLabel.setText("\uacfc\uac70 \uc9c0\ucd9c \uc815\ubcf4\uc785\ub2c8\ub2e4.\n\ud56d\ubaa9\uba85\uacfc \uc9c0\ucd9c\uc561\uc740 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				AddJichulInfoLabel.setBounds(9, 23, 345, 41);
			}
			{
				AddJichul = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				AddJichul.setText("\uc0ad\uc81c");
				AddJichul.setBounds(99, 297, 65, 24);
				AddJichul.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						int selected = util.showYesOrNoMsgBox(dialogShell, "이 지출 정보를 정말로 삭제하시겠습니까?");
						if (selected == SWT.YES) {
							try {
								jichulModifyService.deleteGoods(id);
								returnOk = true;
								dialogShell.dispose();
							} catch (SQLException e) {
								util.showErrorMsg(dialogShell, "지출 정보를 삭제하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
							}
						}
					}
				});
			}
			{
				buyDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateDayLabel.setText("\uc77c");
				buyDateDayLabel.setBounds(309, 255, 24, 20);
				buyDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateDayText.setTextLimit(2);
				buyDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateDayText.setText(util.applyDateFormat(dbData.getBuyDate(), "dd"));
				buyDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateDayText.setBounds(270, 254, 33, 20);
				buyDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				BuyDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				BuyDateMonthLabel.setText("\uc6d4");
				BuyDateMonthLabel.setBounds(242, 255, 24, 20);
				BuyDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateMonthText.setTextLimit(2);
				buyDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateMonthText.setText(util.applyDateFormat(dbData.getBuyDate(), "MM"));
				buyDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateMonthText.setBounds(201, 254, 37, 20);
				buyDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				buyDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateYearLabel.setText("\ub144");
				buyDateYearLabel.setBounds(178, 256, 23, 20);
				buyDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateYearText.setTextLimit(4);
				buyDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateYearText.setText(util.applyDateFormat(dbData.getBuyDate(), "yyyy"));
				buyDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateYearText.setBounds(114, 254, 60, 20);
				buyDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
		}
		dialogShell.setLocation(getParent().toDisplay(300, 30));
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		if (returnOk) {
			return bean;
		} else {
			return null;
		}
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
		
		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 지출 정보를 수정하시겠습니까?");

		if (yesOrNo != SWT.YES) {
			return;
		}
		
		try {
			bean.setId(this.id);
			bean.setName(AddJichulNameValueText.getText().trim());
			String memo = AddJichulMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setBuyPrice(Long.valueOf(AddJichulBuyPriceValueText.getText()));
			bean.setBuyDate(util.getDateFromString(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText()));

			try {
				jichulModifyService.updateJichul(bean);
			} catch (SQLException e) {
				util.showErrorMsg(dialogShell, "지출 정보를 갱신하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
			}
			returnOk = true;
			dialogShell.dispose();

		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
		}
	}
}
