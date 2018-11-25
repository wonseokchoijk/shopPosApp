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

import bean.ColorMstBean;
import service.ColorModifyService;
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
public class ColorModify extends org.eclipse.swt.widgets.Dialog {

	private Shell parent = null;
	private Shell dialogShell;
	private Composite addGoodsComponent;
	private Label colorModifyInfoLabel;
	private Button colorModifyConfirmButton;
	private Button colorModifyCancelButton;
	private Text colorModifyText;

	boolean result = false;
	private Button colorModifyDeleteButton;
	Utilities util = new Utilities();
	Main main = null;
	ColorMstBean bean = null;

	public ColorModify(Shell parent, int style) {
		super(parent, style);
	}

	public boolean open(Main main, ColorMstBean bean) {
		this.main = main;
		this.bean = bean;
		try {
			parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(341, 153);
			dialogShell.setText("색상명 수정 및 삭제");
			{
				addGoodsComponent = new Composite(dialogShell, SWT.NONE);
				FormData addGoodsComponentLData = new FormData();
				addGoodsComponentLData.left =  new FormAttachment(0, 1000, 0);
				addGoodsComponentLData.top =  new FormAttachment(0, 1000, 0);
				addGoodsComponentLData.width = 341;
				addGoodsComponentLData.height = 126;
				addGoodsComponent.setLayoutData(addGoodsComponentLData);
				addGoodsComponent.setLayout(null);
				{
					colorModifyText = new Text(addGoodsComponent, SWT.NONE);
					colorModifyText.setBounds(18, 48, 303, 26);
					colorModifyText.setTextLimit(255);
					colorModifyText.setFocus();
					colorModifyText.setText(this.bean.getName());
					colorModifyText.addListener(SWT.DefaultSelection, new Listener() {
						public void handleEvent(Event e) {
							colorModifyConfirmButtonMouseUp();
						}
					});
				}
				{
					colorModifyInfoLabel = new Label(addGoodsComponent, SWT.NONE);
					colorModifyInfoLabel.setText("\uc0c8 \uc0c9\uc0c1\uba85\uc744 \uc801\uc73c\uc2e0 \ud6c4 \uc218\uc815\ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.\n\uc774 \uc0c9\uc0c1\uc744 \uc0ad\uc81c\ud558\uc2e4 \ub54c\uc5d0\ub294 \uc0ad\uc81c \ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.");
					colorModifyInfoLabel.setBounds(4, 4, 315, 35);
				}
				{
					colorModifyCancelButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					colorModifyCancelButton.setText("\ucde8\uc18c");
					colorModifyCancelButton.setBounds(12, 89, 80, 30);
					colorModifyCancelButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							colorModifyCancelButtonMouseUp(evt);
						}
					});
				}
				{
					colorModifyDeleteButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					colorModifyDeleteButton.setText("\uc0ad\uc81c");
					colorModifyDeleteButton.setBounds(128, 93, 77, 25);
					colorModifyDeleteButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							colorModifyDeleteButtonMouseUp(evt);
						}
					});
				}
				{
					colorModifyConfirmButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					colorModifyConfirmButton.setText("\uc218\uc815");
					colorModifyConfirmButton.setBounds(243, 89, 84, 30);
					colorModifyConfirmButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							colorModifyConfirmButtonMouseUp();
						}
					});
				}
			}
			dialogShell.setLocation(getParent().toDisplay(300, 150));
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

	private void colorModifyCancelButtonMouseUp(MouseEvent evt) {
		dialogShell.dispose();
	}

	private void colorModifyConfirmButtonMouseUp() {
		String text = colorModifyText.getText().trim();
		if (util.isEmpty(text)) {
			util.showMsg(dialogShell, "변경할 색상명을 적으신 후 수정 버튼을 눌러주십시오.");
		} else {
			int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이대로 수정하시겠습니까?");
			if (yesOrNo == SWT.YES) {
				ColorModifyService service = new ColorModifyService();
				try {
					bean.setName(text);
					service.updateColor(this.bean);
					util.showMsg(dialogShell, "색상명을 '" + text + "'로 변경하였습니다.");
					main.updateColorCombo();
					main.showPreferenceColorCombos();
					main.updateTableTopIndex();
					this.result = true;
					dialogShell.dispose();
				} catch (InvalidParameterException e) {
					util.showMsg(dialogShell, e.getMessage());
				} catch (SQLException e) {
					util.showErrorMsg(dialogShell, e.getMessage());
				}
			}
		}
	}

	// 삭제 버튼 클릭시.
	private void colorModifyDeleteButtonMouseUp(MouseEvent evt) {
		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 색상을 정말로 삭제하시겠습니까?\n이 색상의 상품들이 전부 색상 미지정 상태로 변경됩니다.");
		if (yesOrNo != SWT.YES) {
			return;
		}
		ColorModifyService service = new ColorModifyService();
		try {
			service.deleteColor(bean.getId());
			util.showMsg(dialogShell, "색상을 삭제하였습니다.");
			main.updateColorCombo();
			main.showPreferenceColorCombos();
			main.updateTableTopIndex();
			this.result = true;
			dialogShell.dispose();
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, e.getMessage());
		}
	}

}
