package views;
import java.sql.SQLException;
import java.util.List;
import bean.ColorMstBean;
import bean.GoodsListBean;
import bean.KindMstBean;
import com.cloudgarden.resource.SWTResourceManager;
import common.Consts;
import common.Utilities;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
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
import service.GoodsListDetailService;
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
public class GoodsListDetail extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Button goodsListDetailCancelButton;
	private Button goodsListDetailConfirmButton;
	private Text goodsListDetailNameValueText;
	private Text goodsListDetailMemoValueText;
	private Text goodsListDetailBuyPriceValueText;
	private Text goodsListDetailSellHopePriceValueText;
	private Text goodsListDetailPlaceValueText;
	private Label goodsListDetailNameLabel;
	private Button goodsListDetailAddKindButton;
	private Button goodsListDetailAddColorButton;
	private Combo goodsListDetailKindCombo;
	private Combo goodsListDetailColorCombo;
	private Label goodsListDetailKindLabel;
	private Button goodsListDetail;
	private Label goodsListDetailColorLabel;
	private Label goodsListDetailMemoLabel;
	private Label goodsListDetailBuyPriceLabel;
	private Label goodsListDetailBuyPriceWonLabel;
	private Label goodsListDetailSellHopePriceLabel;
	private Label goodsListDetailSellHopePriceWonLabel;
	private Label goodsListDetailPlaceLabel;
	private Label goodsListDetailNoLabel;
	private Label goodsListDetailNoValueLabel;
	private Label goodsListDetailBuyDateLabel;
	GoodsListService goodsListService = new GoodsListService();
	GoodsListDetailService goodsListDetailService = new GoodsListDetailService();
	private Text buyDateYearText;
	private Label buyDateYearLabel;
	private Text buyDateMonthText;
	private Label BuyDateMonthLabel;
	private Text buyDateDayText;
	private Label buyDateDayLabel;

	Long id = null;
//	ArrayList<GoodsListBean> result = new ArrayList<GoodsListBean>();
	GoodsListBean bean = new GoodsListBean();
	private Label goodsListDetailInfoLabel;

	Utilities util = new Utilities();

	Main main = null;
	boolean returnOk = false;

	public GoodsListDetail(Shell parent, int style) {
		super(parent, style);
	}

	public GoodsListBean open(Main main, Long goodsId) throws SQLException {

		this.main = main;
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
		dialogShell.setSize(386, 487);
		dialogShell.setText("상품 정보 수정");

		this.id = goodsId; 
		GoodsListBean dbData = goodsListDetailService.getGoodsDetail(this.id);
		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, -20);
			composite1LData.width = 386;
			composite1LData.height = 468;
			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				goodsListDetailNoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailNoLabel.setText("\uc0c1\ud488No : ");
				goodsListDetailNoLabel.setBounds(19, 65, 65, 19);
				goodsListDetailNoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailNoValueLabel = new Label(sellGoodsComposite, SWT.LEFT);
				goodsListDetailNoValueLabel.setText(String.valueOf(this.id));
				goodsListDetailNoValueLabel.setBounds(92, 66, 106, 19);
			}
			{
				goodsListDetailNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailNameLabel.setText("\uc0c1\ud488\uba85 : ");
				goodsListDetailNameLabel.setBounds(19, 93, 65, 19);
				goodsListDetailNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				goodsListDetailNameValueText.setBounds(92, 96, 281, 42);
				goodsListDetailNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				goodsListDetailNameValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				goodsListDetailNameValueText.setText(dbData.getName() != null ? dbData.getName() : "");
				goodsListDetailNameValueText.setTextLimit(255);
			}
			{
				goodsListDetailKindLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailKindLabel.setText("\uc0c1\ud488\uc885\ub958 :");
				goodsListDetailKindLabel.setBounds(7, 149, 73, 17);
				goodsListDetailKindLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailKindCombo = new Combo(sellGoodsComposite, SWT.READ_ONLY);
				showKindCombo();
				if (! util.isEmpty(dbData.getKind())) {
					for (int i = 0; i < goodsListDetailKindCombo.getItemCount(); i++) {
						if (dbData.getKind().equals(goodsListDetailKindCombo.getItem(i))) {
							goodsListDetailKindCombo.select(i);
						}
					}
				} else {
					goodsListDetailKindCombo.select(0);
				}
			}
			{
				goodsListDetailAddKindButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				goodsListDetailAddKindButton.setText("\uadf8\uc678\uc758 \uc885\ub958 \uc785\ub825");
				goodsListDetailAddKindButton.setBounds(250, 146, 123, 26);
				goodsListDetailAddKindButton.setToolTipText("\uc67c\ucabd \uc885\ub958 \ub9ac\uc2a4\ud2b8\uc5d0 \ub098\uc640\uc788\ub294 \uac83 \uc774\uc678\uc758 \uc885\ub958\ub97c \uc785\ub825\ud560 \ub54c\ub294 \uc774 \ubc84\ud2bc\uc744 \ub204\ub974\uace0 \uc0c8\ub85c\uc6b4 \uc885\ub958 \uc774\ub984\uc744 \uc785\ub825\ud574\uc8fc\uc2ed\uc2dc\uc624.");
				goodsListDetailAddKindButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						goodsListDetailAddKindButtonMouseUp(evt);
					}
				});
			}
			{
				goodsListDetailColorLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailColorLabel.setText("\uc0c9\uc0c1 :");
				goodsListDetailColorLabel.setBounds(17, 178, 63, 17);
				goodsListDetailColorLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailColorCombo = new Combo(sellGoodsComposite, SWT.READ_ONLY);
				showColorCombo();
				if (! util.isEmpty(dbData.getKind())) {
					for (int i = 0; i < goodsListDetailColorCombo.getItemCount(); i++) {
						if (dbData.getColor() != null && dbData.getColor().equals(goodsListDetailColorCombo.getItem(i))) {
							goodsListDetailColorCombo.select(i);
						}
					}
				} else {
					goodsListDetailColorCombo.select(0);
				}
			}
			{
				goodsListDetailAddColorButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				goodsListDetailAddColorButton.setText("\uadf8\uc678\uc758 \uc0c9\uc0c1 \uc785\ub825");
				goodsListDetailAddColorButton.setBounds(250, 174, 123, 26);
				goodsListDetailAddColorButton.setToolTipText("\uc67c\ucabd \uc0c9\uc0c1 \ub9ac\uc2a4\ud2b8\uc5d0 \ub098\uc640\uc788\ub294 \uac83 \uc774\uc678\uc758 \uc0c9\uc0c1\uc744 \uc785\ub825\ud560 \ub54c\ub294 \uc774 \ubc84\ud2bc\uc744 \ub204\ub974\uace0 \uc0c8\ub85c\uc6b4 \uc885\ub958 \uc774\ub984\uc744 \uc785\ub825\ud574\uc8fc\uc2ed\uc2dc\uc624.");
				goodsListDetailAddColorButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						goodsListDetailAddColorButtonMouseUp(evt);
					}
				});
			}
			{
				goodsListDetailMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailMemoLabel.setText("\uba54\ubaa8 : ");
				goodsListDetailMemoLabel.setBounds(33, 206, 51, 17);
				goodsListDetailMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				goodsListDetailMemoValueText.setBounds(92, 207, 279, 57);
				goodsListDetailMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				goodsListDetailMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				goodsListDetailMemoValueText.setText(dbData.getMemo() != null ? dbData.getMemo() : "");
				goodsListDetailMemoValueText.setTextLimit(500);
			}
			{
				goodsListDetailBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailBuyPriceLabel.setText("\uad6c\uc785\uac00 : ");
				goodsListDetailBuyPriceLabel.setBounds(17, 276, 83, 17);
				goodsListDetailBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				goodsListDetailBuyPriceValueText.setBounds(114, 277, 137, 20);
				goodsListDetailBuyPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				goodsListDetailBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				goodsListDetailBuyPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
				goodsListDetailBuyPriceValueText.setText(dbData.getBuyPrice() != null ? String.valueOf(dbData.getBuyPrice()) : "");
			}
			{
				goodsListDetailBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				goodsListDetailBuyPriceWonLabel.setText("\uc6d0");
				goodsListDetailBuyPriceWonLabel.setBounds(256, 278, 51, 20);
				goodsListDetailBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				goodsListDetailSellHopePriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailSellHopePriceLabel.setText("\ud310\ub9e4\uc608\uc815\uac00 : ");
				goodsListDetailSellHopePriceLabel.setBounds(6, 310, 90, 18);
				goodsListDetailSellHopePriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailSellHopePriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				goodsListDetailSellHopePriceValueText.setBounds(114, 310, 137, 20);
				goodsListDetailSellHopePriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				goodsListDetailSellHopePriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				goodsListDetailSellHopePriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
				goodsListDetailSellHopePriceValueText.setText(dbData.getSellHopePrice() != null ? String.valueOf(dbData.getSellHopePrice()) : "");
			}
			{
				goodsListDetailSellHopePriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				goodsListDetailSellHopePriceWonLabel.setText("\uc6d0");
				goodsListDetailSellHopePriceWonLabel.setBounds(256, 312, 51, 20);
				goodsListDetailSellHopePriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				goodsListDetailSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				goodsListDetailSellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
//				goodsListDetailSellPriceLabel.setBounds(15, 224, 83, 17);
//				goodsListDetailSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				goodsListDetailSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
//				goodsListDetailSellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
//				goodsListDetailSellPriceValueText.setBounds(112, 222, 140, 22);
//				goodsListDetailSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				goodsListDetailSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//				goodsListDetailSellPriceValueText.addVerifyListener(new VerifyListener() {
//					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
//							evt.doit = evt.text.matches("[0-9]*");
//						}
//					});
//}
//				{
//					goodsListDetailSellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
//					goodsListDetailSellPriceWonLabel.setText("\uc6d0");
//				goodsListDetailSellPriceWonLabel.setBounds(254, 225, 51, 20);
//				goodsListDetailSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
			{
				goodsListDetailPlaceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailPlaceLabel.setText("\uad6c\uc785\ucc98 : ");
				goodsListDetailPlaceLabel.setBounds(29, 345, 70, 17);
				goodsListDetailPlaceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				goodsListDetailPlaceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				goodsListDetailPlaceValueText.setBounds(113, 347, 261, 20);
				goodsListDetailPlaceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				goodsListDetailPlaceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				goodsListDetailPlaceValueText.setText(dbData.getPlace() != null ? dbData.getPlace() : "");
				goodsListDetailPlaceValueText.setTextLimit(255);
			}
			{
				goodsListDetailBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				goodsListDetailBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
				goodsListDetailBuyDateLabel.setBounds(13, 380, 85, 17);
				goodsListDetailBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
//			{
//				goodsListDetailBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				goodsListDetailBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
//				goodsListDetailBuyDateLabel.setBounds(18, 280, 74, 17);
//				goodsListDetailBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				goodsListDetailBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				goodsListDetailBuyDateValueText.setBounds(110, 279, 261, 20);
//				goodsListDetailBuyDateValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				goodsListDetailBuyDateValueText.setEditable(false);
//				goodsListDetailBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
//			{
//				goodsListDetailBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				goodsListDetailBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				goodsListDetailBarcodeLabel.setBounds(12, 310, 74, 17);
//				goodsListDetailBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				goodsListDetailBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				goodsListDetailBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				goodsListDetailBarcodeValueText.setBounds(89, 310, 285, 20);
//				goodsListDetailBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				goodsListDetailBarcodeValueText.setEditable(false);
//				goodsListDetailBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				goodsListDetailCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				goodsListDetailCancelButton.setText("\ucde8 \uc18c");
				goodsListDetailCancelButton.setBounds(15, 422, 67, 37);
				goodsListDetailCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				goodsListDetailCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				goodsListDetailConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				goodsListDetailConfirmButton.setText("\uc704 \ub0b4\uc6a9\ub300\ub85c \uc0c1\ud488 \uc815\ubcf4 \uc218\uc815");
				goodsListDetailConfirmButton.setBounds(182, 422, 193, 37);
				goodsListDetailConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							goodsListDetailConfirmButtonMouseUp();
						}
					}
				});

				goodsListDetailConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						goodsListDetailConfirmButtonMouseUp();
					}
				});
//				goodsListDetailConfirmButton.setFocus();
			}
			{
				goodsListDetailInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
				goodsListDetailInfoLabel.setText("\ud604\uc7ac \ubcf4\uc720\uc911\uc778 \uc0c1\ud488\uc758 \uc815\ubcf4\uc785\ub2c8\ub2e4.\n\uc0c1\ud488\uba85\uacfc \uad6c\uc785\uac00\ub294 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				goodsListDetailInfoLabel.setBounds(9, 23, 345, 41);
			}
			{
				goodsListDetail = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				goodsListDetail.setText("\uc0ad\uc81c");
				goodsListDetail.setBounds(100, 429, 65, 24);
				goodsListDetail.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						int selected = util.showYesOrNoMsgBox(dialogShell, "이 구입상품 정보를 정말로 삭제하시겠습니까?\n구입했던 상품 정보가 삭제되어 구입하지 않았던 상태가 됩니다.");
						if (selected == SWT.YES) {
							try {
								goodsListDetailService.deleteGoods(id);
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
				buyDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateDayLabel.setText("\uc77c");
				buyDateDayLabel.setBounds(309, 381, 24, 20);
				buyDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateDayText.setTextLimit(2);
				buyDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateDayText.setText(util.applyDateFormat(dbData.getBuyDate(), "dd"));
				buyDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateDayText.setBounds(270, 380, 33, 20);
				buyDateDayText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				BuyDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				BuyDateMonthLabel.setText("\uc6d4");
				BuyDateMonthLabel.setBounds(242, 381, 24, 20);
				BuyDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateMonthText.setTextLimit(2);
				buyDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateMonthText.setText(util.applyDateFormat(dbData.getBuyDate(), "MM"));
				buyDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateMonthText.setBounds(201, 380, 37, 20);
				buyDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				buyDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateYearLabel.setText("\ub144");
				buyDateYearLabel.setBounds(178, 382, 23, 20);
				buyDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateYearText.setTextLimit(4);
				buyDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateYearText.setText(util.applyDateFormat(dbData.getBuyDate(), "yyyy"));
				buyDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateYearText.setBounds(114, 380, 60, 20);
				buyDateYearText.addVerifyListener(new VerifyListener() {
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
	private void goodsListDetailConfirmButtonMouseUp() {
		if (util.isEmpty(goodsListDetailNameValueText.getText())) {
			util.showMsg(dialogShell, "상품명을 입력해주십시오.");
			return;
		}
		if (util.isEmpty(goodsListDetailBuyPriceValueText.getText())) {
			util.showMsg(dialogShell, "구입가를 입력해주십시오.");
			return;
		}

		if (util.isEmpty(buyDateYearText.getText()) || util.isEmpty(buyDateMonthText.getText()) || util.isEmpty(buyDateDayText.getText())) {
			util.showMsg(dialogShell, "구입날짜의 연월일을 모두 입력해주십시오.");
			return;
		} else {
			if ( ! util.isCorrectDate(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText())) {
				util.showMsg(dialogShell, "구입날짜의 입력치가 올바른 날짜가 아닙니다.");
				return;
			}
		}

		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 상품 정보를 수정하시겠습니까?");

		if (yesOrNo != SWT.YES) {
			return;
		}
		
		try {
			bean.setId(this.id);
			bean.setName(goodsListDetailNameValueText.getText().trim());
			bean.setKind(goodsListDetailKindCombo.getText());
			bean.setColor(goodsListDetailColorCombo.getText());
			String memo = goodsListDetailMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setBuyPrice(Long.valueOf(goodsListDetailBuyPriceValueText.getText()));
			bean.setSellHopePrice(! util.isEmpty(goodsListDetailSellHopePriceValueText.getText()) ? Long.valueOf(goodsListDetailSellHopePriceValueText.getText()) : null);
			
			bean.setBuyDate(util.getDateFromString(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText()));
			
			String place = goodsListDetailPlaceValueText.getText().trim();
			bean.setPlace(! util.isEmpty(place) ? place : null);

			try {
				goodsListDetailService.updateGoods(bean);
			} catch (SQLException e) {
				util.showErrorMsg(dialogShell, "상품정보를 갱신하는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
			}
			returnOk = true;
			dialogShell.dispose();

		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
		}
	}
	
	private void goodsListDetailAddKindButtonMouseUp(MouseEvent evt) {
		AddKind addKind = new AddKind(dialogShell, SWT.NONE);
		String addedName = addKind.open(main);

		if (addedName != null && goodsListDetailKindCombo.getItemCount() > 0) {
			showKindCombo();
			int count = goodsListDetailKindCombo.getItemCount();
			for (int i = 0; i < count; i++) {
				if (addedName.equals(goodsListDetailKindCombo.getItem(i))) {
					goodsListDetailKindCombo.select(i);
					break;
				}
			}
		}
	}
	
	private void goodsListDetailAddColorButtonMouseUp(MouseEvent evt) {
		AddColor addColor = new AddColor(dialogShell, SWT.NONE);
		String addedName = addColor.open(main);

		if (addedName != null && goodsListDetailColorCombo.getItemCount() > 0) {
			showColorCombo();
			int count = goodsListDetailColorCombo.getItemCount();
			for (int i = 0; i < count; i++) {
				if (addedName.equals(goodsListDetailColorCombo.getItem(i))) {
					goodsListDetailColorCombo.select(i);
					break;
				}
			}
		}
	}

	private void showKindCombo() {
		try {
			goodsListDetailKindCombo.removeAll();
			goodsListDetailKindCombo.setBounds(92, 146, 152, 22);
			List<KindMstBean> kindMstList = goodsListService.getKindMst();
			goodsListDetailKindCombo.add("");
			for (KindMstBean kindMstBean : kindMstList) {
				goodsListDetailKindCombo.add(kindMstBean.getName());
			}
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, "상품종류를 읽어들이는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
		}
	}

	private void showColorCombo() {
		try {
			goodsListDetailColorCombo.removeAll();
			goodsListDetailColorCombo.setBounds(92, 175, 152, 22);
			List<ColorMstBean> colorMstList = goodsListService.getColorMst();
			goodsListDetailColorCombo.add("");
			for (ColorMstBean colorMstBean : colorMstList) {
				goodsListDetailColorCombo.add(colorMstBean.getName());
			}
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, "상품색상을 읽어들이는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
		}
	}
}
