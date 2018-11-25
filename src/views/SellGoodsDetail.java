package views;

import java.util.Calendar;

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
public class SellGoodsDetail extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Label sellDateLabel;
	private Text sellDateYearText;
	private Label sellDateYearLabel;
	private Text sellDateMonthText;
	private Label sellDateMonthLabel;
	private Text sellDateDayText;
	private Label sellDateDayLabel;
	private Button sellGoodsDetailCancelButton;
	private Button sellGoodsDetailConfirmButton;
	private Text sellGoodsDetailNameValueText;
	private Text sellGoodsDetailNoValueText;
	private Text sellGoodsDetailKindValueText;
	private Text sellGoodsDetailColorValueText;
	private Text sellGoodsDetailMemoValueText;
	private Text sellGoodsDetailBuyPriceValueText;
	private Text sellGoodsDetailSellHopePriceValueText;
	private Text sellGoodsDetailSellPriceValueText;
	private Text sellGoodsDetailPlaceValueText;
	private Text sellGoodsDetailBuyDateValueText;
	private Label sellGoodsDetailNoLabel;
	private Label sellGoodsDetailNameLabel;
	private Label sellGoodsDetailKindLabel;
	private Label sellGoodsDetailColorLabel;
	private Label sellGoodsDetailMemoLabel;
	private Label sellGoodsDetailBuyPriceLabel;
	private Label sellGoodsDetailBuyPriceWonLabel;
	private Label sellGoodsDetailSellHopePriceLabel;
	private Label sellGoodsDetailSellHopePriceWonLabel;
	private Label sellGoodsDetailSellPriceLabel;
	private Label sellGoodsDetailSellPriceWonLabel;
	private Label sellGoodsDetailPlaceLabel;
	private Label sellGoodsDetailBuyDateLabel;

	boolean returnOk = false;

	Utilities util = new Utilities();
//	DecimalFormat df = new DecimalFormat("#,###");
	GoodsListBean sellGoodsData = null;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			sellGoodsDetail inst = new sellGoodsDetail(shell, SWT.NULL);
//			inst.open(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public SellGoodsDetail(Shell parent, int style) {
		super(parent, style);
	}

	public GoodsListBean open(GoodsListBean param) {
		this.sellGoodsData = param;
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
		dialogShell.setSize(386, 467);
		dialogShell.setText("상품 정보");
		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, 0);
			composite1LData.width = 386;
			composite1LData.height = 428;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				sellGoodsDetailNoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailNoLabel.setText("No : ");
				sellGoodsDetailNoLabel.setBounds(32, 4, 51, 17);
				sellGoodsDetailNoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailNoValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsDetailNoValueText.setText(String.valueOf(this.sellGoodsData.getId()));
				sellGoodsDetailNoValueText.setBounds(95, 6, 277, 20);
				sellGoodsDetailNoValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailNoValueText.setEditable(false);
				sellGoodsDetailNoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailNameLabel.setText("\uc0c1\ud488\uba85 : ");
				sellGoodsDetailNameLabel.setBounds(18, 28, 65, 19);
				sellGoodsDetailNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				sellGoodsDetailNameValueText.setText(util.isEmpty(this.sellGoodsData.getName()) ? "" : this.sellGoodsData.getName());
				sellGoodsDetailNameValueText.setBounds(91, 30, 281, 42);
				sellGoodsDetailNameValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailNameValueText.setEditable(false);
				sellGoodsDetailNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailKindLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailKindLabel.setText("\uc0c1\ud488\uc885\ub958 :");
				sellGoodsDetailKindLabel.setBounds(6, 78, 73, 17);
				sellGoodsDetailKindLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailKindValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsDetailKindValueText.setText(util.isEmpty(this.sellGoodsData.getKind()) ? "" : this.sellGoodsData.getKind());
				sellGoodsDetailKindValueText.setBounds(91, 78, 281, 20);
				sellGoodsDetailKindValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailKindValueText.setEditable(false);
				sellGoodsDetailKindValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailColorLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailColorLabel.setText("\uc0c9\uc0c1 :");
				sellGoodsDetailColorLabel.setBounds(16, 99, 63, 17);
				sellGoodsDetailColorLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailColorValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsDetailColorValueText.setText(util.isEmpty(this.sellGoodsData.getColor()) ? "" : this.sellGoodsData.getColor());
				sellGoodsDetailColorValueText.setBounds(91, 101, 281, 20);
				sellGoodsDetailColorValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailColorValueText.setEditable(false);
				sellGoodsDetailColorValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailMemoLabel.setText("\uba54\ubaa8 : ");
				sellGoodsDetailMemoLabel.setBounds(32, 130, 51, 17);
				sellGoodsDetailMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				sellGoodsDetailMemoValueText.setText(util.isEmpty(this.sellGoodsData.getMemo()) ? "" : this.sellGoodsData.getMemo());
				sellGoodsDetailMemoValueText.setBounds(89, 129, 279, 57);
				sellGoodsDetailMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				sellGoodsDetailMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsDetailMemoValueText.setTextLimit(500);
			}
			{
				sellGoodsDetailBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailBuyPriceLabel.setText("\uad6c\uc785\uac00 : ");
				sellGoodsDetailBuyPriceLabel.setBounds(16, 190, 83, 17);
				sellGoodsDetailBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellGoodsDetailBuyPriceValueText.setText(this.sellGoodsData.getBuyPrice() != null ? String.valueOf(this.sellGoodsData.getBuyPrice()) : "");
				sellGoodsDetailBuyPriceValueText.setBounds(113, 193, 137, 20);
				sellGoodsDetailBuyPriceValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailBuyPriceValueText.setEditable(false);
				sellGoodsDetailBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsDetailBuyPriceWonLabel.setText("\uc6d0");
				sellGoodsDetailBuyPriceWonLabel.setBounds(255, 192, 51, 20);
				sellGoodsDetailBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailSellHopePriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailSellHopePriceLabel.setText("\ud310\ub9e4\uc608\uc815\uac00 : ");
				sellGoodsDetailSellHopePriceLabel.setBounds(5, 214, 90, 18);
				sellGoodsDetailSellHopePriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailSellHopePriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellGoodsDetailSellHopePriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
				sellGoodsDetailSellHopePriceValueText.setBounds(113, 216, 137, 20);
				sellGoodsDetailSellHopePriceValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailSellHopePriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsDetailSellHopePriceValueText.setEditable(false);
			}
			{
				sellGoodsDetailSellHopePriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsDetailSellHopePriceWonLabel.setText("\uc6d0");
				sellGoodsDetailSellHopePriceWonLabel.setBounds(255, 216, 51, 20);
				sellGoodsDetailSellHopePriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailSellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
				sellGoodsDetailSellPriceLabel.setBounds(16, 244, 83, 17);
				sellGoodsDetailSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				sellGoodsDetailSellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
				sellGoodsDetailSellPriceValueText.setBounds(113, 242, 140, 22);
				sellGoodsDetailSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				sellGoodsDetailSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsDetailSellPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
							evt.doit = evt.text.matches("[0-9]*");
						}
					});
			}
				{
					sellGoodsDetailSellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
					sellGoodsDetailSellPriceWonLabel.setText("\uc6d0");
				sellGoodsDetailSellPriceWonLabel.setBounds(255, 245, 51, 20);
				sellGoodsDetailSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailPlaceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailPlaceLabel.setText("\uad6c\uc785\ucc98 : ");
				sellGoodsDetailPlaceLabel.setBounds(29, 270, 70, 17);
				sellGoodsDetailPlaceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailPlaceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsDetailPlaceValueText.setText(util.isEmpty(this.sellGoodsData.getPlace()) ? "" : this.sellGoodsData.getPlace());
				sellGoodsDetailPlaceValueText.setBounds(113, 272, 261, 20);
				sellGoodsDetailPlaceValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailPlaceValueText.setEditable(false);
				sellGoodsDetailPlaceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsDetailBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsDetailBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
				sellGoodsDetailBuyDateLabel.setBounds(21, 300, 74, 17);
				sellGoodsDetailBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsDetailBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsDetailBuyDateValueText.setText(util.applyDateFormat(this.sellGoodsData.getBuyDate(), Consts.KOREAN_DATE_FORMAT));
				sellGoodsDetailBuyDateValueText.setBounds(113, 299, 261, 20);
				sellGoodsDetailBuyDateValueText.setBackground(dialogShell.getBackground());
				sellGoodsDetailBuyDateValueText.setEditable(false);
				sellGoodsDetailBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				sellGoodsDetailBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				sellGoodsDetailBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				sellGoodsDetailBarcodeLabel.setBounds(12, 310, 74, 17);
//				sellGoodsDetailBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				sellGoodsDetailBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				sellGoodsDetailBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				sellGoodsDetailBarcodeValueText.setBounds(89, 310, 285, 20);
//				sellGoodsDetailBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				sellGoodsDetailBarcodeValueText.setEditable(false);
//				sellGoodsDetailBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				sellGoodsDetailCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				sellGoodsDetailCancelButton.setText("\ucde8 \uc18c");
				sellGoodsDetailCancelButton.setBounds(12, 379, 67, 37);
				sellGoodsDetailCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				sellGoodsDetailCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				sellGoodsDetailConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				sellGoodsDetailConfirmButton.setText("\uc774 \uc0c1\ud488\uc744 \ud310\ub9e4\ub9ac\uc2a4\ud2b8\uc5d0 \ucd94\uac00");
				sellGoodsDetailConfirmButton.setBounds(179, 379, 193, 37);
				sellGoodsDetailConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							sellGoodsDetailConfirmButtonMouseUp();
						}
					}
				});

				sellGoodsDetailConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						sellGoodsDetailConfirmButtonMouseUp();
					}
				});
				sellGoodsDetailConfirmButton.setFocus();
			}
			{
				sellDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateDayLabel.setText("\uc77c");
				sellDateDayLabel.setBounds(308, 332, 24, 20);
				sellDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			Calendar oCalendar = Calendar.getInstance( );
			{
				sellDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				sellDateDayText.setTextLimit(2);
				sellDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateDayText.setText(String.format("%02d", oCalendar.get(Calendar.DAY_OF_MONTH)));
				sellDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateDayText.setBounds(269, 331, 33, 20);
				sellDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateMonthLabel.setText("\uc6d4");
				sellDateMonthLabel.setBounds(241, 332, 24, 20);
				sellDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				sellDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				sellDateMonthText.setTextLimit(2);
				sellDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateMonthText.setText(String.format("%02d", oCalendar.get(Calendar.MONTH) + 1));
				sellDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateMonthText.setBounds(200, 331, 37, 20);
				sellDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateYearLabel.setText("\ub144");
				sellDateYearLabel.setBounds(177, 333, 23, 20);
				sellDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				sellDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
				sellDateYearText.setTextLimit(4);
				sellDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateYearText.setText(String.format("%02d", oCalendar.get(Calendar.YEAR)));
				sellDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateYearText.setBounds(113, 331, 60, 20);
				sellDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellDateLabel.setText("\ud310\ub9e4\ub0a0\uc9dc : ");
				sellDateLabel.setBounds(21, 331, 74, 17);
				sellDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,1,false,false));
			}
		}
		dialogShell.setLocation(getParent().toDisplay(300, 35));
		dialogShell.open();
		Display display = dialogShell.getDisplay();
		while (!dialogShell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
		if (this.returnOk) {
			return this.sellGoodsData;
		} else {
			return null;
		}
	}

	// 이 상품을 판매리스트에 추가 버튼 클릭시.
	private void sellGoodsDetailConfirmButtonMouseUp() {
		if (util.isEmpty(sellGoodsDetailSellPriceValueText.getText())) {
			util.showMsg(dialogShell, "판매가를 입력해주십시오.");
			return;
		}
		
		if (util.isEmpty(sellDateYearText.getText()) || util.isEmpty(sellDateMonthText.getText()) || util.isEmpty(sellDateDayText.getText())) {
			util.showMsg(dialogShell, "판매날짜의 연월일을 모두 입력해주십시오.");
			return;
		} else {
			if ( ! util.isCorrectDate(sellDateYearText.getText(), sellDateMonthText.getText(), sellDateDayText.getText())) {
				util.showMsg(dialogShell, "판매날짜의 입력치가 올바른 날짜가 아닙니다.");
				return;
			}
		}
		
		try {
			this.sellGoodsData.setMemo(sellGoodsDetailMemoValueText.getText());
			this.sellGoodsData.setSellPrice(Long.valueOf(sellGoodsDetailSellPriceValueText.getText()));
			this.sellGoodsData.setSellDate(util.getDateFromString(sellDateYearText.getText(), sellDateMonthText.getText(), sellDateDayText.getText()));
			this.returnOk = true;
			dialogShell.dispose();
		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "판매가의 숫자가 올바르지 않습니다.");
			sellGoodsDetailSellPriceValueText.setText("");
		}
	}

}
