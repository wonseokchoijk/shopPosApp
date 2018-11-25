package views;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import bean.ColorMstBean;
import bean.GoodsListBean;
import bean.KindMstBean;
import com.cloudgarden.resource.SWTResourceManager;
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
public class AddGoodsDetail extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsComposite;
	private Button addGoodsDetailCancelButton;
	private Button addGoodsDetailConfirmButton;
	private Text addGoodsDetailNameValueText;
	private Text addGoodsDetailMemoValueText;
	private Text addGoodsDetailBuyPriceValueText;
	private Text addGoodsDetailSellHopePriceValueText;
	private Text addGoodsDetailPlaceValueText;
	private Text addGoodsDetailNumberValueText;
	private Label addGoodsDetailNameLabel;
	private Button addGoodsDetailAddKindButton;
	private Button addGoodsDetailAddColorButton;
	private Combo addGoodsDetailKindCombo;
	private Combo addGoodsDetailColorCombo;
	private Label addGoodsDetailKindLabel;
	private Label addGoodsDetailColorLabel;
	private Label addGoodsDetailMemoLabel;
	private Label addGoodsDetailBuyPriceLabel;
	private Label addGoodsDetailBuyPriceWonLabel;
	private Label addGoodsDetailSellHopePriceLabel;
	private Label addGoodsDetailSellHopePriceWonLabel;
	private Label addGoodsDetailPlaceLabel;
	private Label addGoodsDetailNumberLabel;
	private Label addGoodsDetailNumberGaeLabel;
	
	GoodsListService goodsListService = new GoodsListService();

	ArrayList<GoodsListBean> result = new ArrayList<GoodsListBean>();
	private Text buyDateDayText;
	private Text buyDateMonthText;
	private Text buyDateYearText;
	private Label buyDateDayLabel;
	private Label BuyDateMonthLabel;
	private Label buyDateYearLabel;
	private Label label1;
	private Label addGoodsDetailInfoLabel;
	boolean returnOk = false;

	Utilities util = new Utilities();
//	DecimalFormat df = new DecimalFormat("#,###");

	Main main = null;
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			addGoodsDetail inst = new addGoodsDetail(shell, SWT.NULL);
//			inst.open(1);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public AddGoodsDetail(Shell parent, int style) {
		super(parent, style);
	}

	public ArrayList<GoodsListBean> open(Main main) throws SQLException {
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
		dialogShell.setSize(386, 496);
		dialogShell.setText("구입상품 정보 입력");
		{
			sellGoodsComposite = new Composite(dialogShell, SWT.NONE);
			FormData composite1LData = new FormData();
			composite1LData.left =  new FormAttachment(0, 1000, 0);
			composite1LData.top =  new FormAttachment(0, 1000, 0);
			composite1LData.width = 383;
			composite1LData.height = 457;

			sellGoodsComposite.setLayoutData(composite1LData);
			sellGoodsComposite.setLayout(null);
			{
				addGoodsDetailNameLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailNameLabel.setText("\uc0c1\ud488\uba85 : ");
				addGoodsDetailNameLabel.setBounds(19, 49, 65, 19);
				addGoodsDetailNameLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailNameValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP);
				addGoodsDetailNameValueText.setBounds(92, 52, 281, 42);
				addGoodsDetailNameValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailNameValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailNameValueText.setTextLimit(255);
			}
			{
				addGoodsDetailKindLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailKindLabel.setText("\uc0c1\ud488\uc885\ub958 :");
				addGoodsDetailKindLabel.setBounds(7, 105, 73, 17);
				addGoodsDetailKindLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailKindCombo = new Combo(sellGoodsComposite, SWT.READ_ONLY);
				showKindCombo();
				addGoodsDetailKindCombo.select(0);
			}
			{
				addGoodsDetailAddKindButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				addGoodsDetailAddKindButton.setText("\uadf8\uc678\uc758 \uc885\ub958 \uc785\ub825");
				addGoodsDetailAddKindButton.setBounds(250, 102, 123, 26);
				addGoodsDetailAddKindButton.setToolTipText("\uc67c\ucabd \uc885\ub958 \ub9ac\uc2a4\ud2b8\uc5d0 \ub098\uc640\uc788\ub294 \uac83 \uc774\uc678\uc758 \uc885\ub958\ub97c \uc785\ub825\ud560 \ub54c\ub294 \uc774 \ubc84\ud2bc\uc744 \ub204\ub974\uace0 \uc0c8\ub85c\uc6b4 \uc885\ub958 \uc774\ub984\uc744 \uc785\ub825\ud574\uc8fc\uc2ed\uc2dc\uc624.");
				addGoodsDetailAddKindButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						addGoodsDetailAddKindButtonMouseUp(evt);
					}
				});
			}
			{
				addGoodsDetailColorLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailColorLabel.setText("\uc0c9\uc0c1 :");
				addGoodsDetailColorLabel.setBounds(17, 134, 63, 17);
				addGoodsDetailColorLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailColorCombo = new Combo(sellGoodsComposite, SWT.READ_ONLY);
				showColorCombo();
				addGoodsDetailColorCombo.select(0);
			}
			{
				addGoodsDetailAddColorButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				addGoodsDetailAddColorButton.setText("\uadf8\uc678\uc758 \uc0c9\uc0c1 \uc785\ub825");
				addGoodsDetailAddColorButton.setBounds(250, 130, 123, 26);
				addGoodsDetailAddColorButton.setToolTipText("\uc67c\ucabd \uc0c9\uc0c1 \ub9ac\uc2a4\ud2b8\uc5d0 \ub098\uc640\uc788\ub294 \uac83 \uc774\uc678\uc758 \uc0c9\uc0c1\uc744 \uc785\ub825\ud560 \ub54c\ub294 \uc774 \ubc84\ud2bc\uc744 \ub204\ub974\uace0 \uc0c8\ub85c\uc6b4 \uc885\ub958 \uc774\ub984\uc744 \uc785\ub825\ud574\uc8fc\uc2ed\uc2dc\uc624.");
				addGoodsDetailAddColorButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						addGoodsDetailAddColorButtonMouseUp(evt);
					}
				});
			}
			{
				addGoodsDetailMemoLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailMemoLabel.setText("\uba54\ubaa8 : ");
				addGoodsDetailMemoLabel.setBounds(33, 162, 51, 17);
				addGoodsDetailMemoLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailMemoValueText = new Text(sellGoodsComposite, SWT.MULTI | SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
				addGoodsDetailMemoValueText.setBounds(92, 163, 279, 57);
				addGoodsDetailMemoValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailMemoValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailMemoValueText.setTextLimit(500);
			}
			{
				addGoodsDetailBuyPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailBuyPriceLabel.setText("\uad6c\uc785\uac00 : ");
				addGoodsDetailBuyPriceLabel.setBounds(17, 232, 83, 17);
				addGoodsDetailBuyPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailBuyPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				addGoodsDetailBuyPriceValueText.setBounds(114, 233, 137, 20);
				addGoodsDetailBuyPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailBuyPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailBuyPriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				addGoodsDetailBuyPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				addGoodsDetailBuyPriceWonLabel.setText("\uc6d0");
				addGoodsDetailBuyPriceWonLabel.setBounds(256, 234, 51, 20);
				addGoodsDetailBuyPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
			{
				addGoodsDetailSellHopePriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailSellHopePriceLabel.setText("\ud310\ub9e4\uc608\uc815\uac00 : ");
				addGoodsDetailSellHopePriceLabel.setBounds(6, 266, 90, 18);
				addGoodsDetailSellHopePriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailSellHopePriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				addGoodsDetailSellHopePriceValueText.setBounds(114, 266, 137, 20);
				addGoodsDetailSellHopePriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailSellHopePriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailSellHopePriceValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				addGoodsDetailSellHopePriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
				addGoodsDetailSellHopePriceWonLabel.setText("\uc6d0");
				addGoodsDetailSellHopePriceWonLabel.setBounds(256, 268, 51, 20);
				addGoodsDetailSellHopePriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				addGoodsDetailSellPriceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				addGoodsDetailSellPriceLabel.setText("\ud310\ub9e4\uac00 : ");
//				addGoodsDetailSellPriceLabel.setBounds(15, 224, 83, 17);
//				addGoodsDetailSellPriceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				addGoodsDetailSellPriceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP | SWT.BORDER);
//				addGoodsDetailSellPriceValueText.setText(this.sellGoodsData.getSellHopePrice() != null ? String.valueOf(this.sellGoodsData.getSellHopePrice()) : "");
//				addGoodsDetailSellPriceValueText.setBounds(112, 222, 140, 22);
//				addGoodsDetailSellPriceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				addGoodsDetailSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//				addGoodsDetailSellPriceValueText.addVerifyListener(new VerifyListener() {
//					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
//							evt.doit = evt.text.matches("[0-9]*");
//						}
//					});
//}
//				{
//					addGoodsDetailSellPriceWonLabel = new Label(sellGoodsComposite, SWT.LEFT);
//					addGoodsDetailSellPriceWonLabel.setText("\uc6d0");
//				addGoodsDetailSellPriceWonLabel.setBounds(254, 225, 51, 20);
//				addGoodsDetailSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
			{
				addGoodsDetailPlaceLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailPlaceLabel.setText("\uad6c\uc785\ucc98 : ");
				addGoodsDetailPlaceLabel.setBounds(29, 301, 70, 17);
				addGoodsDetailPlaceLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailPlaceValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
				addGoodsDetailPlaceValueText.setBounds(113, 303, 261, 20);
				addGoodsDetailPlaceValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailPlaceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailPlaceValueText.setTextLimit(255);
			}
//			{
//				addGoodsDetailBuyDateLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				addGoodsDetailBuyDateLabel.setText("\uad6c\uc785\ub0a0\uc9dc : ");
//				addGoodsDetailBuyDateLabel.setBounds(18, 280, 74, 17);
//				addGoodsDetailBuyDateLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
//			}
//			{
//				addGoodsDetailBuyDateValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				addGoodsDetailBuyDateValueText.setBounds(110, 279, 261, 20);
//				addGoodsDetailBuyDateValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
//				addGoodsDetailBuyDateValueText.setEditable(false);
//				addGoodsDetailBuyDateValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
//			}
			{
				addGoodsDetailNumberLabel = new Label(sellGoodsComposite, SWT.RIGHT);
				addGoodsDetailNumberLabel.setText("\uad6c\uc785\uac2f\uc218 :");
				addGoodsDetailNumberLabel.setBounds(12, 336, 83, 17);
				addGoodsDetailNumberLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 1, false, false));
			}
			{
				addGoodsDetailNumberValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				addGoodsDetailNumberValueText.setBounds(113, 337, 60, 20);
				addGoodsDetailNumberValueText.setBackground(SWTResourceManager.getColor(255, 255, 255));
				addGoodsDetailNumberValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
				addGoodsDetailNumberValueText.setText("1");
				addGoodsDetailNumberValueText.setTextLimit(3);
				addGoodsDetailNumberValueText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				addGoodsDetailNumberGaeLabel = new Label(sellGoodsComposite, SWT.LEFT);
				addGoodsDetailNumberGaeLabel.setText("\uac1c");
				addGoodsDetailNumberGaeLabel.setBounds(180, 338, 51, 20);
				addGoodsDetailNumberGaeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 11, 0, false, false));
			}
//			{
//				addGoodsDetailBarcodeLabel = new Label(sellGoodsComposite, SWT.RIGHT);
//				addGoodsDetailBarcodeLabel.setText("\ubc14\ucf54\ub4dc : ");
//				addGoodsDetailBarcodeLabel.setBounds(12, 310, 74, 17);
//				addGoodsDetailBarcodeLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
//			{
//				addGoodsDetailBarcodeValueText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.WRAP);
//				addGoodsDetailBarcodeValueText.setText(util.isEmpty(this.sellGoodsData.getBarcode()) ? "" : this.sellGoodsData.getBarcode());
//				addGoodsDetailBarcodeValueText.setBounds(89, 310, 285, 20);
//				addGoodsDetailBarcodeValueText.setBackground(SWTResourceManager.getColor(232, 232, 232));
//				addGoodsDetailBarcodeValueText.setEditable(false);
//				addGoodsDetailBarcodeValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
//			}
			{
				addGoodsDetailCancelButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				addGoodsDetailCancelButton.setText("\ucde8 \uc18c");
				addGoodsDetailCancelButton.setBounds(14, 405, 67, 37);
				addGoodsDetailCancelButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
				addGoodsDetailCancelButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							dialogShell.dispose();
						}
					}
				});
			}
			{
				addGoodsDetailConfirmButton = new Button(sellGoodsComposite, SWT.PUSH | SWT.CENTER);
				addGoodsDetailConfirmButton.setText("\uc774 \uc0c1\ud488\uc744 \uad6c\uc785 \uc0c1\ud488\uc5d0 \ucd94\uac00");
				addGoodsDetailConfirmButton.setBounds(181, 406, 193, 37);
				addGoodsDetailConfirmButton.addTraverseListener(new TraverseListener() {
					public void keyTraversed(TraverseEvent evt) {
						if (evt.detail == SWT.TRAVERSE_RETURN) {
							addGoodsDetailConfirmButtonMouseUp();
						}
					}
				});

				addGoodsDetailConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						addGoodsDetailConfirmButtonMouseUp();
					}
				});
//				addGoodsDetailConfirmButton.setFocus();
			}
			{
				addGoodsDetailInfoLabel = new Label(sellGoodsComposite, SWT.NONE);
				addGoodsDetailInfoLabel.setText("\ubcf4\uc720\uc0c1\ud488\uc5d0 \ucd94\uac00\ud560 \uc0c8\ub85c \uad6c\uc785\ud55c \uc0c1\ud488 \uc815\ubcf4\ub97c \uc785\ub825\ud574\uc8fc\uc2ed\uc2dc\uc624.\n\uc0c1\ud488\uba85\uacfc \uad6c\uc785\uac00\ub294 \ud544\uc218 \uc785\ub825 \ud56d\ubaa9\uc785\ub2c8\ub2e4.");
				addGoodsDetailInfoLabel.setBounds(9, 5, 345, 41);
			}
			{
				label1 = new Label(sellGoodsComposite, SWT.RIGHT);
				label1.setText("\uad6c\uc785\ub0a0\uc9dc :");
				label1.setBounds(12, 372, 83, 17);
				label1.setFont(SWTResourceManager.getFont("Lucida Grande",11,1,false,false));
			}
			{
				buyDateYearLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateYearLabel.setText("\ub144");
				buyDateYearLabel.setBounds(177, 373, 23, 20);
				buyDateYearLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				BuyDateMonthLabel = new Label(sellGoodsComposite, SWT.LEFT);
				BuyDateMonthLabel.setText("\uc6d4");
				BuyDateMonthLabel.setBounds(241, 372, 24, 20);
				BuyDateMonthLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			{
				buyDateDayLabel = new Label(sellGoodsComposite, SWT.LEFT);
				buyDateDayLabel.setText("\uc77c");
				buyDateDayLabel.setBounds(308, 372, 24, 20);
				buyDateDayLabel.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
			}
			Calendar oCalendar = Calendar.getInstance( );
			{
				buyDateYearText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateYearText.setTextLimit(4);
				buyDateYearText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateYearText.setText(String.format("%02d", oCalendar.get(Calendar.YEAR)));
				buyDateYearText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateYearText.setBounds(113, 371, 60, 20);
				buyDateYearText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				buyDateMonthText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateMonthText.setTextLimit(2);
				buyDateMonthText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateMonthText.setText(String.valueOf(oCalendar.get(Calendar.MONTH) + 1));
				buyDateMonthText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateMonthText.setBounds(200, 371, 37, 20);
				buyDateMonthText.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
						evt.doit = evt.text.matches("[0-9]*");
					}
				});
			}
			{
				buyDateDayText = new Text(sellGoodsComposite, SWT.SINGLE | SWT.RIGHT | SWT.WRAP);
				buyDateDayText.setTextLimit(2);
				buyDateDayText.setFont(SWTResourceManager.getFont("Lucida Grande",11,0,false,false));
				buyDateDayText.setText(String.format("%02d", oCalendar.get(Calendar.DAY_OF_MONTH)));
				buyDateDayText.setBackground(SWTResourceManager.getColor(255,255,255));
				buyDateDayText.setBounds(269, 371, 33, 20);
				buyDateDayText.addVerifyListener(new VerifyListener() {
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
		if (this.returnOk) {
			return this.result;
		} else {
			return null;
		}
	}

	// 이 상품을 판매리스트에 추가 버튼 클릭시.
	private void addGoodsDetailConfirmButtonMouseUp() {
		if (util.isEmpty(addGoodsDetailNameValueText.getText())) {
			util.showMsg(dialogShell, "상품명을 입력해주십시오.");
			return;
		}
		if (util.isEmpty(addGoodsDetailBuyPriceValueText.getText())) {
			util.showMsg(dialogShell, "구입가를 입력해주십시오.");
			return;
		}
		if (util.isEmpty(addGoodsDetailNumberValueText.getText())) {
			util.showMsg(dialogShell, "구입갯수를 입력해주십시오.");
			return;
		}
		if (addGoodsDetailNumberValueText.getText().trim().equals("0")) {
			util.showMsg(dialogShell, "구입갯수에는 0보다 많은 숫자를 넣어주십시오.");
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
		

		GoodsListBean bean = new GoodsListBean();
		try {
			bean.setName(addGoodsDetailNameValueText.getText().trim());
			bean.setKind(addGoodsDetailKindCombo.getText());
			bean.setColor(addGoodsDetailColorCombo.getText());
			String memo = addGoodsDetailMemoValueText.getText().trim();
			bean.setMemo(! util.isEmpty(memo) ? memo : null);
			bean.setBuyPrice(Long.valueOf(addGoodsDetailBuyPriceValueText.getText()));
			bean.setSellHopePrice(! util.isEmpty(addGoodsDetailSellHopePriceValueText.getText()) ? Long.valueOf(addGoodsDetailSellHopePriceValueText.getText()) : null);
			bean.setBuyDate(util.getDateFromString(buyDateYearText.getText(), buyDateMonthText.getText(), buyDateDayText.getText()));
			String place = addGoodsDetailPlaceValueText.getText().trim();
			bean.setPlace(! util.isEmpty(place) ? place : null);
			for (int i = 0; i < Integer.valueOf(addGoodsDetailNumberValueText.getText()) ; i++) {
				GoodsListBean bean2 = new GoodsListBean();
				bean2.setName(bean.getName());
				bean2.setKind(bean.getKind());
				bean2.setColor(bean.getColor());
				bean2.setMemo(bean.getMemo());
				bean2.setBuyPrice(bean.getBuyPrice());
				bean2.setSellHopePrice(bean.getSellHopePrice());
				bean2.setPlace(bean.getPlace());
				bean2.setBuyDate(bean.getBuyDate());
				this.result.add(bean2);
			}
			this.returnOk = true;
			dialogShell.dispose();

		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "숫자 입력에 에러가 있습니다.");
		}
	}
	
	private void addGoodsDetailAddKindButtonMouseUp(MouseEvent evt) {
		AddKind addKind = new AddKind(dialogShell, SWT.NONE);
		String addedName = addKind.open(main);

		if (addedName != null && addGoodsDetailKindCombo.getItemCount() > 0) {
			showKindCombo();
			int count = addGoodsDetailKindCombo.getItemCount();
			for (int i = 0; i < count; i++) {
				if (addedName.equals(addGoodsDetailKindCombo.getItem(i))) {
					addGoodsDetailKindCombo.select(i);
					break;
				}
			}
		}
	}
	
	private void addGoodsDetailAddColorButtonMouseUp(MouseEvent evt) {
		AddColor addColor = new AddColor(dialogShell, SWT.NONE);
		String addedName = addColor.open(main);

		if (addedName != null && addGoodsDetailColorCombo.getItemCount() > 0) {
			showColorCombo();
			int count = addGoodsDetailColorCombo.getItemCount();
			for (int i = 0; i < count; i++) {
				if (addedName.equals(addGoodsDetailColorCombo.getItem(i))) {
					addGoodsDetailColorCombo.select(i);
					break;
				}
			}
		}
	}

	private void showKindCombo() {
		try {
			addGoodsDetailKindCombo.removeAll();
			addGoodsDetailKindCombo.setBounds(92, 102, 152, 22);
			List<KindMstBean> kindMstList = goodsListService.getKindMst();
			addGoodsDetailKindCombo.add("");
			for (KindMstBean kindMstBean : kindMstList) {
				addGoodsDetailKindCombo.add(kindMstBean.getName());
			}
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, "상품종류를 읽어들이는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
		}
	}

	private void showColorCombo() {
		try {
			addGoodsDetailColorCombo.removeAll();
			addGoodsDetailColorCombo.setBounds(92, 131, 152, 22);
			List<ColorMstBean> colorMstList = goodsListService.getColorMst();
			addGoodsDetailColorCombo.add("");
			for (ColorMstBean colorMstBean : colorMstList) {
				addGoodsDetailColorCombo.add(colorMstBean.getName());
			}
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, "상품색상을 읽어들이는 과정에서 에러가 발생했습니다.\n\n" + e.getMessage());
		}
	}
}
