package views;

import java.security.InvalidParameterException;
import java.sql.SQLException;

import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import service.AddColorService;

import common.Utilities;

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
public class AddColor extends org.eclipse.swt.widgets.Dialog {

	private Shell parent = null;
	private Shell dialogShell;
	private Composite addColorComponent;
	private Label addColorInfoLabel;
	private Button addColorConfirmButton;
	private Button addColorCancelButton;
	private Text addColorText;

	String result = null;
	Utilities util = new Utilities();

	Main main = null;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
//	public static void main(String[] args) {
//		try {
//			Display display = Display.getDefault();
//			Shell shell = new Shell(display);
//			addColor inst = new addColor(shell, SWT.NULL);
//			inst.open();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	public AddColor(Shell parent, int style) {
		super(parent, style);
	}

	public String open(Main main) {
		this.main = main;
		try {
			parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(325, 153);
			dialogShell.setText("상품 색상 추가");
			{
				addColorComponent = new Composite(dialogShell, SWT.NONE);
				FormData addGoodsComponentLData = new FormData();
				addGoodsComponentLData.left =  new FormAttachment(0, 1000, 0);
				addGoodsComponentLData.top =  new FormAttachment(0, 1000, 0);
				addGoodsComponentLData.width = 325;
				addGoodsComponentLData.height = 126;
				addColorComponent.setLayoutData(addGoodsComponentLData);
				addColorComponent.setLayout(null);
				{
					addColorText = new Text(addColorComponent, SWT.NONE);
					addColorText.setBounds(18, 48, 289, 26);
					addColorText.setTextLimit(255);
					addColorText.setFocus();
					addColorText.addListener(SWT.DefaultSelection, new Listener() {
						public void handleEvent(Event e) {
							addColorConfirmButtonMouseUp();
						}
					});
				}
				{
					addColorInfoLabel = new Label(addColorComponent, SWT.NONE);
					addColorInfoLabel.setText("\ucd94\uac00\ud558\uace0 \uc2f6\uc740 \uc0c9\uc0c1\uc744 \uc801\uc740 \ud6c4 \ud655\uc778\ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.\n  \uc608) \ube68\uac15, \ud30c\ub791, \uc605\uc740 \ub178\ub791");
					addColorInfoLabel.setBounds(4, 4, 315, 35);
				}
				{
					addColorCancelButton = new Button(addColorComponent, SWT.PUSH | SWT.CENTER);
					addColorCancelButton.setText("\ucde8\uc18c");
					addColorCancelButton.setBounds(12, 89, 80, 30);
					addColorCancelButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							addColorCancelButtonMouseUp(evt);
						}
					});
				}
				{
					addColorConfirmButton = new Button(addColorComponent, SWT.PUSH | SWT.CENTER);
					addColorConfirmButton.setText("\ud655\uc778");
					addColorConfirmButton.setBounds(229, 89, 84, 30);
					addColorConfirmButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							addColorConfirmButtonMouseUp();
						}
					});
				}
			}
			dialogShell.setLocation(getParent().toDisplay(30, 100));
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

	private void addColorCancelButtonMouseUp(MouseEvent evt) {
		dialogShell.dispose();
	}

	private void addColorConfirmButtonMouseUp() {
		String text = addColorText.getText().trim();
		if (util.isEmpty(text)) {
			util.showMsg(dialogShell, "추가할 상품 색상을 적으신 후 확인 버튼을 눌러주십시오.");
		} else if (text.length() < 2) {
			util.showMsg(dialogShell, "상품 색상은 최소한 두 글자 이상을 넣어주십시오.");
		} else {
			int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 상품 색상을 추가하시겠습니까?");
			if (yesOrNo == SWT.YES) {
				AddColorService service = new AddColorService();
				try {
					service.addColor(text);
					util.showMsg(dialogShell, "상품 색상에 '" + text + "'를 추가하였습니다.");
					main.updateColorCombo();
					main.showPreferenceColorCombos();
					this.result = text;
					dialogShell.dispose();
				} catch (InvalidParameterException e) {
					util.showMsg(dialogShell, e.getMessage());
				} catch (SQLException e) {
					util.showErrorMsg(dialogShell, e.getMessage());
				}
			}
		}
	}

}
