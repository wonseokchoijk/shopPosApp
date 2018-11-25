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

//import service.sellGoodsModifyService;
import service.GoodsListService;
import service.SellGoodsModifyService;

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
public class SellGoodsModify extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Text sellDateYearText;
	private Label sellDateYearLabel;
	private Text sellDateMonthText;
	private Label sellDateMonthLabel;
	private Text sellDateDayText;
	private Label sellDateDayLabel;
	private Button sellGoodsModifyCancelButton;
	private Button sellGoodsModifyConfirmButton;
	private Text sellGoodsModifyNameValueText;
	private Text sellGoodsModifyMemoValueText;
	private Text sellGoodsModifyBuyPriceValueText;
	private Text sellGoodsModifySellHopePriceValueText;
	private Text sellGoodsModifyPlaceValueText;
	private Label sellGoodsModifyNameLabel;
//	private Button sellGoodsModifyAddKindButton;
//	private Button sellGoodsModifyAddColorButton;
//	private Combo sellGoodsModifyKindCombo;
	private Text sellGoodsModifyKindText;
	private Text sellGoodsModifyColorText;
//	private Combo sellGoodsModifyColorCombo;
	private Label sellGoodsModifyKindLabel;
	private Button sellGoodsModify;
	private Label sellGoodsModifyColorLabel;
	private Label sellGoodsModifyMemoLabel;
	private Label sellGoodsModifyBuyPriceLabel;
	private Label sellGoodsModifyBuyPriceWonLabel;
	private Label sellGoodsModifySellHopePriceLabel;
	private Label sellGoodsModifySellHopePriceWonLabel;
	private Label sellGoodsModifySellPriceLabel;
	private Text sellGoodsModifySellPriceValueText;
	private Label sellGoodsModifySellPriceWonLabel;
	private Label sellGoodsModifyPlaceLabel;
	private Label sellGoodsModifyNoLabel;
	private Label sellGoodsModifyNoValueLabel;
	private Label sellGoodsModifyBuyDateLabel;
	private Text sellGoodsModifyBuyDateValueText;
	private Label sellGoodsModifySellDateLabel;
	GoodsListService goodsListService = new GoodsListService();
	SellGoodsModifyService sellGoodsModifyService = new SellGoodsModifyService();

	Long id = null;
//	ArrayList<GoodsListBean> result = new ArrayList<GoodsListBean>();
	GoodsListBean bean = new GoodsListBean();
	private Label sellGoodsModifyInfoLabel;

	Utilities util = new Utilities();
//	DecimalFormat df = new DecimalFormat("#,###");

	boolean returnOk = false;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			sellGoodsModify inst = new sellGoodsModify(shell, SWT.NULL);
//			inst.open(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public SellGoodsModify(Shell parent, int style) {
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
		dialogShell.setSize(386, 500);
		dialogShell.setText("상품 정보 수정");

		this.id = goodsId; 
		GoodsListBean dbData = sellGoodsModifyService.getGoodsDetail(this.id);
		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, -20);
			composite1LData.width = 386;
			composite1LData.height = 498;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				sellGoodsModifyNoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyNoLabel.setText("\uc0c1\ud488No : ");
				sellGoodsModifyNoLabel.setBounds(19, 65, 65, 19);
				sellGoodsModifyNoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyNoValueLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsModifyNoValueLabel.setText(String.valueOf(this.id));
				sellGoodsModifyNoValueLabel.setBounds(92, 66, 106, 19);
			}
			{
				sellGoodsModifyNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyNameLabel.setText("\uc0c1\ud488\uba85 : ");
				sellGoodsModifyNameLabel.setBounds(19, 90, 65, 19);
				sellGoodsModifyNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				sellGoodsModifyNameValueText.setBounds(92, 92, 281, 42);
				sellGoodsModifyNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifyNameValueText.setText(dbData.getName() != null ? dbData.getName() : "");
				sellGoodsModifyNameValueText.setBackground(dialogShell.getBackground());
				sellGoodsModifyNameValueText.setEditable(false);
			}
			{
				sellGoodsModifyKindLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyKindLabel.setText("\uc0c1\ud488\uc885\ub958 :");
				sellGoodsModifyKindLabel.setBounds(7, 143, 73, 17);
				sellGoodsModifyKindLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyKindText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsModifyKindText.setText(dbData.getKind() != null ? dbData.getKind() : "");
				sellGoodsModifyKindText.setBounds(92, 143, 282, 20);
				sellGoodsModifyKindText.setBackground(dialogShell.getBackground());
				sellGoodsModifyKindText.setEditable(false);
				sellGoodsModifyKindText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsModifyColorLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyColorLabel.setText("\uc0c9\uc0c1 :");
				sellGoodsModifyColorLabel.setBounds(17, 172, 63, 17);
				sellGoodsModifyColorLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyColorText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsModifyColorText.setText(dbData.getColor() != null ? dbData.getColor() : "");
				sellGoodsModifyColorText.setBounds(92, 172, 282, 20);
				sellGoodsModifyColorText.setBackground(dialogShell.getBackground());
				sellGoodsModifyColorText.setEditable(false);
				sellGoodsModifyColorText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsModifyMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyMemoLabel.setText("\uba54\ubaa8 : ");
				sellGoodsModifyMemoLabel.setBounds(33, 200, 51, 17);
				sellGoodsModifyMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				sellGoodsModifyMemoValueText.setBounds(92, 201, 279, 57);
				sellGoodsModifyMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				sellGoodsModifyMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifyMemoValueText.setText(dbData.getMemo() != null ? dbData.getMemo() : "");
				sellGoodsModifyMemoValueText.setTextLimit(500);
			}
			{
				sellGoodsModifyBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyBuyPriceLabel.setText("\uad6c\uc785\uac00 : ");
				sellGoodsModifyBuyPriceLabel.setBounds(17, 267, 83, 17);
				sellGoodsModifyBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellGoodsModifyBuyPriceValueText.setBounds(114, 270, 137, 20);
				sellGoodsModifyBuyPriceValueText.setBackground(dialogShell.getBackground());
				sellGoodsModifyBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifyBuyPriceValueText.setText(dbData.getBuyPrice() != null ? String.valueOf(dbData.getBuyPrice()) : "");
				sellGoodsModifyBuyPriceValueText.setEditable(false);
			}
			{
				sellGoodsModifyBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsModifyBuyPriceWonLabel.setText("\uc6d0");
				sellGoodsModifyBuyPriceWonLabel.setBounds(256, 269, 51, 20);
				sellGoodsModifyBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsModifySellHopePriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifySellHopePriceLabel.setText("\ud310\ub9e4\uc608\uc815\uac00 : ");
				sellGoodsModifySellHopePriceLabel.setBounds(6, 298, 90, 18);
				sellGoodsModifySellHopePriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifySellHopePriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellGoodsModifySellHopePriceValueText.setBounds(114, 300, 137, 20);
				sellGoodsModifySellHopePriceValueText.setBackground(dialogShell.getBackground());
				sellGoodsModifySellHopePriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifySellHopePriceValueText.setText(dbData.getSellHopePrice() != null ? String.valueOf(dbData.getSellHopePrice()) : "");
				sellGoodsModifySellHopePriceValueText.setEditable(false);
			}
			{
				sellGoodsModifySellHopePriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsModifySellHopePriceWonLabel.setText("\uc6d0");
				sellGoodsModifySellHopePriceWonLabel.setBounds(256, 300, 51, 20);
				sellGoodsModifySellHopePriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsModifySellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifySellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
				sellGoodsModifySellPriceLabel.setBounds(9, 328, 90, 18);
				sellGoodsModifySellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifySellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellGoodsModifySellPriceValueText.setBounds(114, 330, 137, 20);
				sellGoodsModifySellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				sellGoodsModifySellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifySellPriceValueText.setText(dbData.getSellPrice() != null ? String.valueOf(dbData.getSellPrice()) : "");
				sellGoodsModifySellPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
							evt.doit = evt.text.matches("[0-9]*");
						}
					});
//				sellGoodsModifySellPriceValueText.setTextLimit(500);
			}
			{
				sellGoodsModifySellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellGoodsModifySellPriceWonLabel.setText("\uc6d0");
				sellGoodsModifySellPriceWonLabel.setBounds(256, 330, 51, 20);
				sellGoodsModifySellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				sellGoodsModifySellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				sellGoodsModifySellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
//				sellGoodsModifySellPriceLabel.setBounds(15, 224, 83, 17);
//				sellGoodsModifySellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				sellGoodsModifySellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
//				sellGoodsModifySellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
//				sellGoodsModifySellPriceValueText.setBounds(112, 222, 140, 22);
//				sellGoodsModifySellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				sellGoodsModifySellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//				sellGoodsModifySellPriceValueText.addVerifyListener(new VerifyListener() {
//					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
//							evt.doit = evt.text.matches("[0-9]*");
//						}
//					});
//}
//				{
//					sellGoodsModifySellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
//					sellGoodsModifySellPriceWonLabel.setText("\uc6d0");
//				sellGoodsModifySellPriceWonLabel.setBounds(254, 225, 51, 20);
//				sellGoodsModifySellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
			{
				sellGoodsModifyPlaceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyPlaceLabel.setText("\uad6c\uc785\ucc98 : ");
				sellGoodsModifyPlaceLabel.setBounds(29, 355, 70, 17);
				sellGoodsModifyPlaceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyPlaceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsModifyPlaceValueText.setBounds(113, 357, 261, 20);
				sellGoodsModifyPlaceValueText.setBackground(dialogShell.getBackground());
				sellGoodsModifyPlaceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				sellGoodsModifyPlaceValueText.setEditable(false);
				sellGoodsModifyPlaceValueText.setText(dbData.getPlace() != null ? dbData.getPlace() : "");
			}
			{
				sellGoodsModifyBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifyBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
				sellGoodsModifyBuyDateLabel.setBounds(14, 381, 85, 17);
				sellGoodsModifyBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				sellGoodsModifyBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				sellGoodsModifyBuyDateValueText.setText(util.applyDateFormat(dbData.getBuyDate(), Consts.KOREAN_DATE_FORMAT));
				sellGoodsModifyBuyDateValueText.setBounds(113, 384, 261, 20);
				sellGoodsModifyBuyDateValueText.setBackground(dialogShell.getBackground());
				sellGoodsModifyBuyDateValueText.setEditable(false);
				sellGoodsModifyBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				sellGoodsModifySellDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				sellGoodsModifySellDateLabel.setText("\ud310\ub9e4\ub0a0\uc9dc : ");
				sellGoodsModifySellDateLabel.setBounds(14, 409, 85, 17);
				sellGoodsModifySellDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
//			{
//				sellGoodsModifyBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				sellGoodsModifyBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
//				sellGoodsModifyBuyDateLabel.setBounds(18, 280, 74, 17);
//				sellGoodsModifyBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				sellGoodsModifyBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				sellGoodsModifyBuyDateValueText.setBounds(110, 279, 261, 20);
//				sellGoodsModifyBuyDateValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				sellGoodsModifyBuyDateValueText.setEditable(false);
//				sellGoodsModifyBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				sellGoodsModifyBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				sellGoodsModifyBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				sellGoodsModifyBarcodeLabel.setBounds(12, 310, 74, 17);
//				sellGoodsModifyBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				sellGoodsModifyBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				sellGoodsModifyBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				sellGoodsModifyBarcodeValueText.setBounds(89, 310, 285, 20);
//				sellGoodsModifyBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				sellGoodsModifyBarcodeValueText.setEditable(false);
//				sellGoodsModifyBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				sellGoodsModifyCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				sellGoodsModifyCancelButton.setText("\ucde8 \uc18c");
				sellGoodsModifyCancelButton.setBounds(14, 449, 67, 37);
				sellGoodsModifyCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				sellGoodsModifyCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				sellGoodsModifyConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				sellGoodsModifyConfirmButton.setText("\uc704 \ub0b4\uc6a9\ub300\ub85c \uc0c1\ud488 \uc815\ubcf4 \uc218\uc815");
				sellGoodsModifyConfirmButton.setBounds(181, 449, 193, 37);
				sellGoodsModifyConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							sellGoodsModifyConfirmButtonMouseUp();
						}
					}
				});

				sellGoodsModifyConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						sellGoodsModifyConfirmButtonMouseUp();
					}
				});
//				sellGoodsModifyConfirmButton.setFocus();
			}
			{
				sellGoodsModifyInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
				sellGoodsModifyInfoLabel.setText("\ud310\ub9e4\ud55c \uc0c1\ud488\uc758 \uc815\ubcf4\uc785\ub2c8\ub2e4.\n\ud310\ub9e4\uac00\ub294 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				sellGoodsModifyInfoLabel.setBounds(9, 23, 345, 41);
			}
			{
				sellGoodsModify = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				sellGoodsModify.setText("\ud310\ub9e4\ucde8\uc18c");
				sellGoodsModify.setBounds(93, 456, 80, 24);
				sellGoodsModify.setToolTipText("\uc774 \ubc84\ud2bc\uc744 \ub204\ub974\uba74 \uc774 \uc0c1\ud488\uc744 \ubbf8\ud310\ub9e4 \uc0c1\ud488\uc73c\ub85c \ub418\ub3cc\ub9bd\ub2c8\ub2e4. \ubc18\ud488 \ub4f1\uc758 \uacbd\uc6b0 \uc0ac\uc6a9\ud558\uc2ed\uc2dc\uc624.");
				sellGoodsModify.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						int selected = util.showYesOrNoMsgBox(dialogShell, "이 판매상품을 판매 하기 전으로 되돌리시겠습니까?\n판매했던 상품이 판매하지 않았던 것으로 수정됩니다.\n반품시 등에 사용 가능합니다.");
						if (selected == SWT.YES) {
							try {
								sellGoodsModifyService.cancelSellGood(id);
								returnOk = true;
								dialogShell.dispose();
							} catch (SQLException e) {
								util.showErrorMsg(dialogShell, "상품정보를 삭제하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
							}
						}
					}
				});
			}
			{
				sellDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateDayLabel.setText("\uc77c");
				sellDateDayLabel.setBounds(308, 413, 24, 20);
				sellDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				sellDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellDateDayText.setTextLimit(2);
				sellDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateDayText.setText(util.applyDateFormat(dbData.getSellDate(), "dd"));
				sellDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateDayText.setBounds(269, 412, 33, 20);
				sellDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateMonthLabel.setText("\uc6d4");
				sellDateMonthLabel.setBounds(241, 413, 24, 20);
				sellDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				sellDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellDateMonthText.setTextLimit(2);
				sellDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateMonthText.setText(util.applyDateFormat(dbData.getSellDate(), "MM"));
				sellDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateMonthText.setBounds(200, 412, 37, 20);
				sellDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				sellDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				sellDateYearLabel.setText("\ub144");
				sellDateYearLabel.setBounds(177, 414, 23, 20);
				sellDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				sellDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				sellDateYearText.setTextLimit(4);
				sellDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				sellDateYearText.setText(util.applyDateFormat(dbData.getSellDate(), "yyyy"));
				sellDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				sellDateYearText.setBounds(113, 412, 60, 20);
				sellDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
		}
		dialogShell.setLocation(getParent().toDisplay(250, -20));
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
	private void sellGoodsModifyConfirmButtonMouseUp() {
		if (util.isEmpty(sellGoodsModifySellPriceValueText.getText())) {
			util.showMsg(dialogShell, "판매가를입력해주십시오.");
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

		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 판매상품 정보를 수정하시겠습니까?");

		if (yesOrNo != SWT.YES) {
			return;
		}

		try {
			bean.setId(this.id);
			String memo = sellGoodsModifyMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setSellPrice(Long.valueOf(sellGoodsModifySellPriceValueText.getText()));
			bean.setSellDate(util.getDateFromString(sellDateYearText.getText(), sellDateMonthText.getText(), sellDateDayText.getText()));

			try {
				sellGoodsModifyService.updateSellGoods(bean);
			} catch (SQLException e) {
				util.showErrorMsg(dialogShell, "상품정보를 갱신하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
			}
			returnOk = true;
			dialogShell.dispose();

		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
			sellGoodsModifySellPriceValueText.setText("");
		}
	}
}
