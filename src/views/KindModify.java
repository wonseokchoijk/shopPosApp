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

import bean.KindMstBean;
import service.KindModifyService;
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
public class KindModify extends org.eclipse.swt.widgets.Dialog {

	private Shell parent = null;
	private Shell dialogShell;
	private Composite addGoodsComponent;
	private Label kindModifyInfoLabel;
	private Button kindModifyConfirmButton;
	private Button kindModifyCancelButton;
	private Text kindModifyText;

	boolean result = false;
	private Button kindModifyDeleteButton;
	Utilities util = new Utilities();
	Main main = null;
	KindMstBean bean = null;

	public KindModify(Shell parent, int style) {
		super(parent, style);
	}

	public boolean open(Main main, KindMstBean bean) {
		this.main = main;
		this.bean = bean;
		try {
			parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);

			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(341, 153);
			dialogShell.setText("상품 종류 수정 및 삭제");
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
					kindModifyText = new Text(addGoodsComponent, SWT.NONE);
					kindModifyText.setBounds(18, 48, 303, 26);
					kindModifyText.setTextLimit(255);
					kindModifyText.setFocus();
					kindModifyText.setText(this.bean.getName());
					kindModifyText.addListener(SWT.DefaultSelection, new Listener() {
						public void handleEvent(Event e) {
							kindModifyConfirmButtonMouseUp();
						}
					});
				}
				{
					kindModifyInfoLabel = new Label(addGoodsComponent, SWT.NONE);
					kindModifyInfoLabel.setText("\uc0c8 \uc0c1\ud488\uc885\ub958\uba85\uc744 \uc801\uc73c\uc2e0 \ud6c4 \uc218\uc815\ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.\n\uc774 \uc0c1\ud488\uc885\ub958\ub97c \uc0ad\uc81c\ud558\uc2e4 \ub54c\uc5d0\ub294 \uc0ad\uc81c \ubc84\ud2bc\uc744 \ub20c\ub7ec\uc8fc\uc2ed\uc2dc\uc624.");
					kindModifyInfoLabel.setBounds(4, 4, 315, 35);
				}
				{
					kindModifyCancelButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					kindModifyCancelButton.setText("\ucde8\uc18c");
					kindModifyCancelButton.setBounds(12, 89, 80, 30);
					kindModifyCancelButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							kindModifyCancelButtonMouseUp(evt);
						}
					});
				}
				{
					kindModifyDeleteButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					kindModifyDeleteButton.setText("\uc0ad\uc81c");
					kindModifyDeleteButton.setBounds(128, 93, 77, 25);
					kindModifyDeleteButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							kindModifyDeleteButtonMouseUp(evt);
						}
					});
				}
				{
					kindModifyConfirmButton = new Button(addGoodsComponent, SWT.PUSH | SWT.CENTER);
					kindModifyConfirmButton.setText("\uc218\uc815");
					kindModifyConfirmButton.setBounds(243, 89, 84, 30);
					kindModifyConfirmButton.addMouseListener(new MouseAdapter() {
						public void mouseUp(MouseEvent evt) {
							kindModifyConfirmButtonMouseUp();
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

	private void kindModifyCancelButtonMouseUp(MouseEvent evt) {
		dialogShell.dispose();
	}

	private void kindModifyConfirmButtonMouseUp() {
		String text = kindModifyText.getText().trim();
		if (util.isEmpty(text)) {
			util.showMsg(dialogShell, "새 상품 종류명을 적으신 후 수정 버튼을 눌러주십시오.");
		} else {
			int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이대로 수정하시겠습니까?");
			if (yesOrNo == SWT.YES) {
				KindModifyService service = new KindModifyService();
				try {
					bean.setName(text);
					service.updateKind(this.bean);
					util.showMsg(dialogShell, "상품 종류를 '" + text + "'로 변경하였습니다.");
					main.updateKindCombo();
					main.showPreferenceKindCombos();
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
	private void kindModifyDeleteButtonMouseUp(MouseEvent evt) {
		int yesOrNo = util.showYesOrNoMsgBox(dialogShell, "이 상품종류를 정말로 삭제하시겠습니까?\n이 상품종류의 상품들이 전부 상품종류 미지정 상태로 변경됩니다.");
		if (yesOrNo != SWT.YES) {
			return;
		}
		KindModifyService service = new KindModifyService();
		try {
			service.deleteKind(bean.getId());
			util.showMsg(dialogShell, "상품 종류를 삭제하였습니다.");
			main.updateKindCombo();
			main.showPreferenceKindCombos();
			main.updateTableTopIndex();
			this.result = true;
			dialogShell.dispose();
		} catch (SQLException e) {
			util.showErrorMsg(dialogShell, e.getMessage());
		}
	}

}
