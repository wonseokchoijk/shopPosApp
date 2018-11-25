package views;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.GoodsListBean;

import com.cloudgarden.resource.SWTResourceManager;

import common.Consts;
import common.Utilities;
import dao.GoodsListDao;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import service.AddGoodsService;

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
public class AddGoods extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Table addGoodsTable;
	private TableColumn addGoodsNoTableColumn;
	private TableColumn addGoodsNameTableColumn;
	private Label addGoodsTotalSellPriceLabel;
	private Label addGoodsTotalSellPriceValueLabel;
	private Label addGoodsTotalBuyPriceValueLabel;
	private Label addGoodsTotalBuyPriceLabel;
	private Label addGoodsTotalNumLabel;
	private Label addGoodsTotalNumValueLabel;
	private Button addGoodsConfirmButton;
	private Button addGoodsAddButton;
	private TableColumn addGoodsKindTableColumn;
	private TableColumn addGoodsColorTableColumn;
	private TableColumn addGoodsMemoTableColumn;
	private Button addGoodsCloseButton;
	private TableColumn addGoodsBuyPriceTableColumn;
	private TableColumn addGoodsSellHopePriceTableColumn;
	private TableColumn addGoodsPlaceTableColumn;
	private Label addGoodsTextLabel;
	private TableItem tableItem;

	Utilities util = new Utilities();

	boolean result = false;
	private TableColumn buyDateTableColumn;
	Long goodsListMaxId = null;
	Main main = null;

	AddGoodsService addGoodsService = new AddGoodsService();
	
	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			AddGoods inst = new AddGoods(shell, SWT.NULL);
//			inst.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public AddGoods(Shell parent, int style) {
		super(parent, style);
	}

	public boolean open(Main main) {
		this.main = main;
		
		try {
			GoodsListDao goodsListDao = new GoodsListDao();
			goodsListMaxId = goodsListDao.getMaxId();
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
			dialogShell.setSize(928, 380);
			dialogShell.setText("구입 상품 추가");
			{
				addGoodsTotalNumLabel = new Label(dialogShell, SWT.RIGHT);
				FormData addGoodsTotalNumLabelData = new FormData();
				addGoodsTotalNumLabelData.left =  new FormAttachment(0, 1000, 187);
				addGoodsTotalNumLabelData.top =  new FormAttachment(0, 1000, 305);
				addGoodsTotalNumLabelData.width = 87;
				addGoodsTotalNumLabelData.height = 19;
				addGoodsTotalNumLabel.setLayoutData(addGoodsTotalNumLabelData);
				addGoodsTotalNumLabel.setText("\ucd1d \uac2f\uc218 :");
			}
			{
				addGoodsTotalNumValueLabel = new Label(dialogShell, SWT.RIGHT);
				FormData addGoodsTotalNumValueLabelData = new FormData();
				addGoodsTotalNumValueLabelData.left =  new FormAttachment(0, 1000, 280);
				addGoodsTotalNumValueLabelData.top =  new FormAttachment(0, 1000, 305);
				addGoodsTotalNumValueLabelData.width = 123;
				addGoodsTotalNumValueLabelData.height = 19;
				addGoodsTotalNumValueLabel.setLayoutData(addGoodsTotalNumValueLabelData);
				addGoodsTotalNumValueLabel.setText("0 \uac1c");
			}
			{
				addGoodsTotalBuyPriceLabel = new Label(dialogShell, SWT.RIGHT);
				FormData addGoodsTotalBuyPriceLabelLData = new FormData();
				addGoodsTotalBuyPriceLabelLData.left =  new FormAttachment(0, 1000, 187);
				addGoodsTotalBuyPriceLabelLData.top =  new FormAttachment(0, 1000, 327);
				addGoodsTotalBuyPriceLabelLData.width = 87;
				addGoodsTotalBuyPriceLabelLData.height = 19;
				addGoodsTotalBuyPriceLabel.setLayoutData(addGoodsTotalBuyPriceLabelLData);
				addGoodsTotalBuyPriceLabel.setText("\ucd1d \uad6c\uc785\uac00 :");
			}
			{
				addGoodsTotalBuyPriceValueLabel = new Label(dialogShell, SWT.RIGHT);
				FormData addGoodsTotalBuyPriceValueLabelLData = new FormData();
				addGoodsTotalBuyPriceValueLabelLData.left =  new FormAttachment(0, 1000, 280);
				addGoodsTotalBuyPriceValueLabelLData.top =  new FormAttachment(0, 1000, 327);
				addGoodsTotalBuyPriceValueLabelLData.width = 123;
				addGoodsTotalBuyPriceValueLabelLData.height = 19;
				addGoodsTotalBuyPriceValueLabel.setLayoutData(addGoodsTotalBuyPriceValueLabelLData);
				addGoodsTotalBuyPriceValueLabel.setText("0 \uc6d0");
			}
			{
				addGoodsTotalSellPriceLabel = new Label(dialogShell, SWT.NONE);
				FormData addGoodsTotalSellPriceLabelLData = new FormData();
				addGoodsTotalSellPriceLabelLData.left =  new FormAttachment(0, 1000, 527);
				addGoodsTotalSellPriceLabelLData.top =  new FormAttachment(0, 1000, 327);
				addGoodsTotalSellPriceLabelLData.width = 87;
				addGoodsTotalSellPriceLabelLData.height = 19;
				addGoodsTotalSellPriceLabel.setLayoutData(addGoodsTotalSellPriceLabelLData);
				addGoodsTotalSellPriceLabel.setText("총 판매예정가 :");
			}
			{
				addGoodsTotalSellPriceValueLabel = new Label(dialogShell, SWT.RIGHT);
				FormData addGoodsTotalSellPriceValueLabelLData = new FormData();
				addGoodsTotalSellPriceValueLabelLData.left =  new FormAttachment(0, 1000, 613);
				addGoodsTotalSellPriceValueLabelLData.top =  new FormAttachment(0, 1000, 327);
				addGoodsTotalSellPriceValueLabelLData.width = 123;
				addGoodsTotalSellPriceValueLabelLData.height = 19;
				addGoodsTotalSellPriceValueLabel.setLayoutData(addGoodsTotalSellPriceValueLabelLData);
				addGoodsTotalSellPriceValueLabel.setText("0 \uc6d0");
			}
			{
				addGoodsConfirmButton = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData addGoodsConfirmButtonLData = new FormData();
				addGoodsConfirmButtonLData.left =  new FormAttachment(0, 1000, 793);
				addGoodsConfirmButtonLData.top =  new FormAttachment(0, 1000, 309);
				addGoodsConfirmButtonLData.width = 123;
				addGoodsConfirmButtonLData.height = 37;
				addGoodsConfirmButton.setLayoutData(addGoodsConfirmButtonLData);
				addGoodsConfirmButton.setText("\uad6c\uc785 \ud655\uc815");
				addGoodsConfirmButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						addGoodsConfirmButtonMouseUp(evt);
					}
				});
			}
			{
				addGoodsAddButton = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData addGoodsAddButtonLData = new FormData();
				addGoodsAddButtonLData.left =  new FormAttachment(0, 1000, 748);
				addGoodsAddButtonLData.top =  new FormAttachment(0, 1000, 7);
				addGoodsAddButtonLData.width = 167;
				addGoodsAddButtonLData.height = 34;
				addGoodsAddButton.setLayoutData(addGoodsAddButtonLData);
				addGoodsAddButton.setText("\uad6c\uc785 \uc0c1\ud488\uc815\ubcf4 \ucd94\uac00");
				addGoodsAddButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						try {
							addGoodsAddButtonMouseUp(evt);
						} catch (SQLException e) {
							util.showErrorMsg(dialogShell, e.getMessage());
						}
					}
				});
			}
			{
				addGoodsTextLabel = new Label(dialogShell, SWT.NONE);
				FormData addGoodsTextLabelLData = new FormData();
				addGoodsTextLabelLData.left =  new FormAttachment(0, 1000, 18);
				addGoodsTextLabelLData.top =  new FormAttachment(0, 1000, 12);
				addGoodsTextLabelLData.width = 580;
				addGoodsTextLabelLData.height = 25;
				addGoodsTextLabel.setLayoutData(addGoodsTextLabelLData);
				addGoodsTextLabel.setText("\uad6c\uc785\ud558\uc2e0 \uc0c1\ud488\uc815\ubcf4\ub97c \uc544\ub798 \ub9ac\uc2a4\ud2b8\uc5d0 \ucd94\uac00\ud558\uc2e0 \ud6c4 \uad6c\uc785 \ud655\uc815 \ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.");
				addGoodsTextLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 12, 0, false, false));
			}
			{
				addGoodsCloseButton = new Button(dialogShell, SWT.PUSH | SWT.CENTER);	// 취소 버튼.
				FormData addGoodsCloseButtonLData = new FormData();
				addGoodsCloseButtonLData.left =  new FormAttachment(0, 1000, 12);
				addGoodsCloseButtonLData.top =  new FormAttachment(0, 1000, 317);
				addGoodsCloseButtonLData.width = 117;
				addGoodsCloseButtonLData.height = 29;
				addGoodsCloseButton.setLayoutData(addGoodsCloseButtonLData);
				addGoodsCloseButton.setText("\ucde8\uc18c");
				addGoodsCloseButton.addMouseListener(new MouseAdapter() {
					public void mouseUp(MouseEvent evt) {
						dialogShell.dispose();
					}
				});
			}
			{
				FormData addGoodsTableLData = new FormData();
				addGoodsTableLData.left =  new FormAttachment(0, 1000, 6);
				addGoodsTableLData.top =  new FormAttachment(0, 1000, 49);
				addGoodsTableLData.width = 889;
				addGoodsTableLData.height = 235;
				addGoodsTable = new Table(dialogShell, SWT.NONE);
				addGoodsTable.setLayoutData(addGoodsTableLData);
				addGoodsTable.setLinesVisible(true);
				addGoodsTable.setHeaderVisible(true);
				{
					addGoodsNoTableColumn = new TableColumn(addGoodsTable, SWT.RIGHT);
					addGoodsNoTableColumn.setText("No.");
					addGoodsNoTableColumn.setWidth(60);
				}
				{
					addGoodsNameTableColumn = new TableColumn(addGoodsTable, SWT.LEFT);
					addGoodsNameTableColumn.setText("\uc0c1\ud488\uba85");
					addGoodsNameTableColumn.setWidth(154);
					addGoodsNameTableColumn.setMoveable(true);
				}
				{
					addGoodsKindTableColumn = new TableColumn(addGoodsTable, SWT.LEFT);
					addGoodsKindTableColumn.setText("\uc0c1\ud488\uc885\ub958");
					addGoodsKindTableColumn.setWidth(94);
				}
				{
					addGoodsColorTableColumn = new TableColumn(addGoodsTable, SWT.CENTER);
					addGoodsColorTableColumn.setText("\uc0c9\uc0c1");
					addGoodsColorTableColumn.setWidth(90);
				}
				{
					addGoodsMemoTableColumn = new TableColumn(addGoodsTable, SWT.NONE);
					addGoodsMemoTableColumn.setText("\uba54\ubaa8");
					addGoodsMemoTableColumn.setWidth(136);
				}
				{
					addGoodsBuyPriceTableColumn = new TableColumn(addGoodsTable, SWT.RIGHT);
					addGoodsBuyPriceTableColumn.setText("\uad6c\uc785\uac00");
					addGoodsBuyPriceTableColumn.setWidth(94);
				}
				{
					addGoodsSellHopePriceTableColumn = new TableColumn(addGoodsTable, SWT.RIGHT);
					addGoodsSellHopePriceTableColumn.setText("\ud310\ub9e4\uc608\uc815\uac00");
					addGoodsSellHopePriceTableColumn.setWidth(89);
				}
//				{
//					addGoodsSellPriceTableColumn = new TableColumn(addGoodsTable, SWT.RIGHT);
//					addGoodsSellPriceTableColumn.setText("\ud310\ub9e4\uac00");
//					addGoodsSellPriceTableColumn.setWidth(83);
//				}
				{
					addGoodsPlaceTableColumn = new TableColumn(addGoodsTable, SWT.NONE);
					addGoodsPlaceTableColumn.setText("\uad6c\uc785\ucc98");
					addGoodsPlaceTableColumn.setWidth(102);
				}
				{
					buyDateTableColumn = new TableColumn(addGoodsTable, SWT.NONE);
					buyDateTableColumn.setText("\uad6c\uc785\ub0a0\uc9dc");
					buyDateTableColumn.setWidth(87);
				}
//				{
//					addGoodsBuyDateTableColumn = new TableColumn(addGoodsTable, SWT.NONE);
//					addGoodsBuyDateTableColumn.setText("\uad6c\uc785\ub0a0\uc9dc");
//					addGoodsBuyDateTableColumn.setWidth(145);
//				}
//				{
//					sellGoodsSellDateTableColumn = new TableColumn(sellGoodsTable, SWT.NONE);
//					sellGoodsSellDateTableColumn.setText("\ud310\ub9e4\ub0a0\uc9dc");
//					sellGoodsSellDateTableColumn.setWidth(91);
//				}
//				{
//					addGoodsBarCodeTableColumn = new TableColumn(addGoodsTable, SWT.NONE);
//					addGoodsBarCodeTableColumn.setText("\ubc14\ucf54\ub4dc");
//					addGoodsBarCodeTableColumn.setWidth(65);
//				}
			}
			dialogShell.setLocation(getParent().toDisplay(50, 40));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 구입 상품정보 추가 버튼 눌렀을 때.
	private void addGoodsAddButtonMouseUp(MouseEvent evt) throws SQLException {
		AddGoodsDetail inst = new AddGoodsDetail(dialogShell, SWT.NONE);
		ArrayList<GoodsListBean> beanList = inst.open(main);
		if (beanList != null && beanList.size() > 0) {
			for (GoodsListBean addedBean : beanList) {
				this.goodsListMaxId++;
				addedBean.setId(this.goodsListMaxId);
				addGoodsService.add(addedBean);
			}

			this.addGoodsTable.removeAll();

			int totalNum = 0;
			long totalBuyPrice = 0;
			long totalSellHopePrice = 0;

			ArrayList<GoodsListBean> beanArrayList = addGoodsService.getList();

			for (int i = beanArrayList.size() - 1; i >= 0; i--) {
				GoodsListBean bean = beanArrayList.get(i);

				tableItem = new TableItem(addGoodsTable, SWT.NONE);
				tableItem.setText(new String[] {
							String.valueOf(bean.getId()),
							! util.isEmpty(bean.getName()) ? bean.getName().replace(SWT.LF, ' ') : "",
							! util.isEmpty(bean.getKind()) ? bean.getKind() : "",
							! util.isEmpty(bean.getColor()) ? bean.getColor() : "",
							! util.isEmpty(bean.getMemo()) ? bean.getMemo().replace(SWT.LF, ' ') : "",
							util.addCommaForPrice(bean.getBuyPrice()),
							util.addCommaForPrice(bean.getSellHopePrice()),
							! util.isEmpty(bean.getPlace()) ? bean.getPlace() : "",
							bean.getBuyDate() != null ? util.applyDateFormat(bean.getBuyDate(), Consts.SLASH_DATE_FORMAT) : "",
						});
				totalBuyPrice += bean.getBuyPrice();
				if (bean.getSellHopePrice() != null) {
					totalSellHopePrice += bean.getSellHopePrice();
				}
				totalNum++;
			}
			addGoodsTotalNumValueLabel.setText(String.valueOf(totalNum) + " 개");
			addGoodsTotalBuyPriceValueLabel.setText(util.addCommaForPrice(totalBuyPrice));
			addGoodsTotalSellPriceValueLabel.setText(util.addCommaForPrice(totalSellHopePrice));
		}
	}

	// 확인버튼 클릭시.
	private void addGoodsConfirmButtonMouseUp(MouseEvent evt) {

		try {
			addGoodsService.insertGoodsToDB();
			util.showMsg(dialogShell, "구입상품을 등록하였습니다.");
			result = true;
			dialogShell.dispose();
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, "DB에러 발생\n" + e.getMessage());
		}
		// TODO: 현재 보유상품 리스트 갱신.
		// TODO: 상품, 지출, 소득 등록 및 열람 갱신.
	}
}
