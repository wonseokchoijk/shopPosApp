package views;
import com.cloudgarden.resource.SWTResourceManager;
import common.Utilities;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
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
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import service.SellGoodsService;


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
public class SellGoodsConfirm extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Composite sellGoodsConfirmComponent;
	private Label sellGoodsConfirmSellPriceTotalLabel;
	private Label sellGoodsConfirmCustomerBillLabel;
	private Button sellGoodsConfirmConfirmButton;
	private Label sellGoodsConfirmChangeTitleLabel;
	private Composite sellGoodsConfirmChangeAreaComponent;
	private Text sellGoodsConfirmChangeText;
	private Button sellGoodsConfirmCancelButton;
	private Text sellGoodsConfirmInfoText;
	private Label sellGoodsConfirmWonLabel;
	private Text sellGoodsConfirmCustomerBillValueText;
	private Label sellGoodConfirmSellPriceWonLabel;
	private Text sellGoodsConfirmSellPriceValueText;

	private int result = SWT.NO;
	Utilities util = new Utilities();

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			SellGoodsConfirm inst = new SellGoodsConfirm(shell, SWT.NULL);
//			inst.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public SellGoodsConfirm(Shell parent, int style) {
		super(parent, style);
	}

	public int open(SellGoodsService sellGoodsService) {
		try {
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
			dialogShell.setSize(496, 241);
			dialogShell.setText("손님 지불 금액 입력");
			{
				sellGoodsConfirmComponent = new Composite(dialogShell, SWT.NONE);
				FormData sellGoodsConfirmComponentLData = new FormData();
				sellGoodsConfirmComponentLData.left =  new FormAttachment(0, 1000, 0);
				sellGoodsConfirmComponentLData.top =  new FormAttachment(0, 1000, 0);
				sellGoodsConfirmComponentLData.width = 496;
				sellGoodsConfirmComponentLData.height = 225;
				sellGoodsConfirmComponent.setLayoutData(sellGoodsConfirmComponentLData);
				sellGoodsConfirmComponent.setLayout(null);
				{
					sellGoodsConfirmSellPriceTotalLabel = new Label(sellGoodsConfirmComponent, SWT.RIGHT);
					sellGoodsConfirmSellPriceTotalLabel.setText("\ud310\ub9e4\uac00\uaca9 \ud569\uacc4 :");
					sellGoodsConfirmSellPriceTotalLabel.setBounds(29, 24, 143, 28);
					sellGoodsConfirmSellPriceTotalLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
				}
				{
					sellGoodsConfirmSellPriceValueText = new Text(sellGoodsConfirmComponent, SWT.RIGHT);
					sellGoodsConfirmSellPriceValueText.setBounds(184, 24, 196, 20);
					sellGoodsConfirmSellPriceValueText.setEditable(false);
					sellGoodsConfirmSellPriceValueText.setBackground(dialogShell.getBackground());
					sellGoodsConfirmSellPriceValueText.setText(String.valueOf(sellGoodsService.getTotalPrice()));
					sellGoodsConfirmSellPriceValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
				}
				{
					sellGoodConfirmSellPriceWonLabel = new Label(sellGoodsConfirmComponent, SWT.NONE);
					sellGoodConfirmSellPriceWonLabel.setText("\uc6d0");
					sellGoodConfirmSellPriceWonLabel.setBounds(392, 24, 49, 25);
					sellGoodConfirmSellPriceWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
				}
				{
					sellGoodsConfirmCustomerBillLabel = new Label(sellGoodsConfirmComponent, SWT.RIGHT);
					sellGoodsConfirmCustomerBillLabel.setText("\uc190\ub2d8 \uc9c0\ubd88 \uae08\uc561 :");
					sellGoodsConfirmCustomerBillLabel.setBounds(12, 57, 160, 30);
					sellGoodsConfirmCustomerBillLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
				}
				{
					sellGoodsConfirmCustomerBillValueText = new Text(sellGoodsConfirmComponent, SWT.RIGHT);
					sellGoodsConfirmCustomerBillValueText.setBounds(184, 57, 196, 23);
					sellGoodsConfirmCustomerBillValueText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
					sellGoodsConfirmCustomerBillValueText.addKeyListener(new KeyAdapter() {
						public void keyReleased(KeyEvent evt) {
							sellGoodsConfirmCustomerBillValueTextKeyReleased(evt);
						}
					});
					sellGoodsConfirmCustomerBillValueText.setFocus();
					sellGoodsConfirmCustomerBillValueText.addVerifyListener(new VerifyListener() {
						public void verifyText(VerifyEvent evt) {	// 숫자만 입력 가능
							evt.doit = evt.text.matches("[0-9]*");
						}
					});
				}
				{
					sellGoodsConfirmWonLabel = new Label(sellGoodsConfirmComponent, SWT.NONE);
					sellGoodsConfirmWonLabel.setText("\uc6d0");
					sellGoodsConfirmWonLabel.setBounds(392, 57, 60, 30);
					sellGoodsConfirmWonLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
				}
				{
					sellGoodsConfirmInfoText = new Text(sellGoodsConfirmComponent, SWT.SINGLE | SWT.LEFT);
					sellGoodsConfirmInfoText.setBounds(20, 95, 458, 24);
					sellGoodsConfirmInfoText.setEditable(false);
					sellGoodsConfirmInfoText.setBackground(dialogShell.getBackground());
					sellGoodsConfirmInfoText.setText("잔액 계산을 하시려면 손님 지불 금액을 입력해주십시오.");
				}
				{
					sellGoodsConfirmCancelButton = new Button(sellGoodsConfirmComponent, SWT.PUSH | SWT.CENTER);
					sellGoodsConfirmCancelButton.setText("\ucde8 \uc18c");
					sellGoodsConfirmCancelButton.setBounds(17, 173, 86, 35);
					sellGoodsConfirmCancelButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							dialogShell.dispose();
						}
					});
				}
				{
					sellGoodsConfirmConfirmButton = new Button(sellGoodsConfirmComponent, SWT.PUSH | SWT.CENTER);
					sellGoodsConfirmConfirmButton.setText("\ud310\ub9e4\uc644\ub8cc");
					sellGoodsConfirmConfirmButton.setBounds(342, 173, 142, 35);
					sellGoodsConfirmConfirmButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							sellGoodsConfirmConfirmButtonMouseUp(evt);
						}
					});
				}
				{
					sellGoodsConfirmChangeAreaComponent = new Composite(sellGoodsConfirmComponent, SWT.BORDER);
					sellGoodsConfirmChangeAreaComponent.setLayout(null);
					sellGoodsConfirmChangeAreaComponent.setBounds(19, 124, 459, 34);
					sellGoodsConfirmChangeAreaComponent.setBackground(SWTResourceManager.getColor(238, 232, 183));
				}
				{
					sellGoodsConfirmChangeText = new Text(sellGoodsConfirmChangeAreaComponent, SWT.RIGHT);
					sellGoodsConfirmChangeText.setText("");
					sellGoodsConfirmChangeText.setBackground(sellGoodsConfirmChangeAreaComponent.getBackground());
					sellGoodsConfirmChangeText.setBounds(165, 5, 185, 24);
					sellGoodsConfirmChangeText.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
					sellGoodsConfirmChangeText.setEditable(false);
				}
				{
					sellGoodsConfirmChangeTitleLabel = new Label(sellGoodsConfirmChangeAreaComponent, SWT.LEFT);
					sellGoodsConfirmChangeTitleLabel.setText("\uc794    \uc561");
					sellGoodsConfirmChangeTitleLabel.setBounds(45, 5, 89, 24);
					sellGoodsConfirmChangeTitleLabel.setFont(SWTResourceManager.getFont("Lucida Grande", 14, 0, false, false));
					sellGoodsConfirmChangeTitleLabel.setBackground(sellGoodsConfirmChangeAreaComponent.getBackground());
				}

			}
			dialogShell.setLocation(getParent().toDisplay(250, 150));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.result;
	}
	
	private void sellGoodsConfirmCustomerBillValueTextKeyReleased(KeyEvent evt) {
		if (util.isEmpty(sellGoodsConfirmSellPriceValueText.getText()) || util.isEmpty(sellGoodsConfirmCustomerBillValueText.getText())) {
			sellGoodsConfirmInfoText.setBackground(dialogShell.getBackground());
			sellGoodsConfirmInfoText.setText("잔액 계산을 하시려면 손님 지불 금액을 입력해주십시오.");
			sellGoodsConfirmChangeText.setText("");
			return;
		}
		Long sellPriceTotal = Long.valueOf(sellGoodsConfirmSellPriceValueText.getText());
		Long customerBill = null;
		try {
			customerBill = Long.valueOf(sellGoodsConfirmCustomerBillValueText.getText());
		} catch (NumberFormatException e) {
			util.showMsg(dialogShell, "손님 지불 금액의 숫자가 올바르지 않습니다.");
			sellGoodsConfirmCustomerBillValueText.setText("");
			sellGoodsConfirmCustomerBillValueText.setFocus();
			return;
		}
		if (sellPriceTotal > customerBill) {
			sellGoodsConfirmInfoText.setBackground(SWTResourceManager.getColor(227, 178, 167));
			sellGoodsConfirmInfoText.setText("손님 지불 금액이 상품 금액보다 적습니다.");
			sellGoodsConfirmChangeText.setText(util.addCommaForPrice(customerBill - sellPriceTotal));
		} else if (sellPriceTotal == customerBill) {
			sellGoodsConfirmInfoText.setText("");
			sellGoodsConfirmInfoText.setBackground(dialogShell.getBackground());
			sellGoodsConfirmChangeText.setText(util.addCommaForPrice(0l));
		} else {
			long charge = customerBill - sellPriceTotal;
			sellGoodsConfirmInfoText.setText("");
			sellGoodsConfirmInfoText.setBackground(dialogShell.getBackground());
			sellGoodsConfirmChangeText.setText(util.addCommaForPrice(charge));
		}
	}
	
	private void sellGoodsConfirmConfirmButtonMouseUp(MouseEvent evt) {
		this.result = SWT.YES;
		dialogShell.dispose();
	}

}
