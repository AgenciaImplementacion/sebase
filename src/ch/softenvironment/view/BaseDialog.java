package ch.softenvironment.view;
/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */

import java.awt.*;

import ch.softenvironment.client.ResourceManager;
import ch.softenvironment.util.Tracer;
/**
 * Template-Dialog defining minimal functionality.
 * @author Peter Hirzel <i>soft</i>Environment
 * @version $Revision: 1.15 $ $Date: 2007-05-30 09:05:31 $
 */
public abstract class BaseDialog extends javax.swing.JDialog {
	private javax.swing.JPanel ivjJDialogContentPane = null;
	private boolean saved = false;
	private ch.softenvironment.view.ViewOptions viewOptions = null;
/**
 * BaseDialog constructor comment.
 * @param owner java.awt.Component
 * @param modal boolean
 */
public BaseDialog(Component owner, boolean modal) {
	this(owner, modal, null);
}
/**
 * BaseDialog constructor comment.
 * @param owner java.awt.Component
 * @param modal boolean
 * @param viewOptions
 */
public BaseDialog(Component owner, boolean modal, ViewOptions viewOptions) {
	super(getOwner(owner), modal);
	this.viewOptions = viewOptions;
	setRelativeLocation(owner);
	initialize();
}
/**
 * Dialogs in Win32 do not generally have icons. Changed so that non-resizable dialogs never have icons, 
 * and resizable <b>dialogs inherit icons from their owner frame or dialog</b>
 * .
 * Calling #setIconImage() on a Frame will propagate the icon to all it's resizable dialogs 
 * (and in turn their Dialog's if in 1.2 where Dialogs can own other Dialogs). This works 
 * even if the Dialog is already created and visible.
 *
 * Windows apps, and almost none do this (since by default dialogs don't have icons).
 * @param owner
 * @return
 */
protected static javax.swing.JFrame getOwner(Component owner) {
    if (owner instanceof javax.swing.JFrame) {
        return (javax.swing.JFrame)owner;
    } else {        
        if (owner != null) {
            // in case of owning Dialog its Icon gets lost!
            Tracer.getInstance().developerWarning("Dialog-owner ignored");
        }
        return /*(javax.swing.JFrame)*/ null;
    }
}
/**
 * Typical Apply-Action.
 * 
 * @see #save()
 */
protected void applyPressed() {
	save();
}
/**
 * Undo changes and close Dialog.
 * @see #undo()
 */
protected void cancelPressed() {
	undo();
	dispose();
}
/**
 * @see BaseFrame#genericPopupDisplay(..)
 */
protected void genericPopupDisplay(java.awt.event.MouseEvent event, javax.swing.JPopupMenu popupMenu) {
    BaseFrame.popupDisplay(this, event, popupMenu);
}
/**
 * Overwrites.
 */
public void dispose() {
	if (getViewOptions() != null) {
	    getViewOptions().getViewManager().checkOut(this);
	}
	super.dispose();
}
/**
 * @see BaseFrame#getViewOptions()
 */
protected final ViewOptions getViewOptions() {
	return viewOptions;
}
/**
 * Return Apply-Button Label-String.
 */
protected static String getApplyString() {
	return ResourceManager.getResource(BaseDialog.class, "BtnApply_text");
}
/**
 * Return Button Label-String.
 */
protected static String getAssignString() {
	return ResourceManager.getResource(BaseDialog.class, "BtnAssign_text");
}
/**
 * Return Cancel-Button Label-String.
 */
protected static String getCancelString() {
	return ResourceManager.getResource(BaseDialog.class, "BtnCancel_text");
}
/**
 * @deprecated
 */
protected String getChangeWindowString() {
	return CommonUserAccess.getMniEditChangeWindowText(); //getResourceString(BaseDialog.class, "BtnChangeWindow_text");
}
/**
 * Return Description Label-String.
 */
protected String getDescriptionString() {
	return ResourceManager.getResource(BaseDialog.class, "CIDescription");
}
/**
 * Return Detail-String.
 */
protected String getDetailString() {
	return ResourceManager.getResource(BaseDialog.class, "CIDetail");
}
/**
 * Return the JDialogContentPane property value.
 * @return javax.swing.JPanel
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JPanel getJDialogContentPane() {
	if (ivjJDialogContentPane == null) {
		try {
			ivjJDialogContentPane = new javax.swing.JPanel();
			ivjJDialogContentPane.setName("JDialogContentPane");
			ivjJDialogContentPane.setLayout(null);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjJDialogContentPane;
}
/**
 * @deprecated
 */
protected String getNewString() {
	return CommonUserAccess.getMniFileNewText(); //getResourceString(BaseDialog.class, "BtnNew_text");
}
/**
 * Return OK-Button Label-String.
 */
protected static String getOKString() {
	return ResourceManager.getResource(BaseDialog.class, "BtnOK_text");
}
/**
 * Return Remove-Button Label-String.
 */
protected String getRemoveString() {
	return ResourceManager.getResource(BaseDialog.class, "BtnRemove_text");
}
/**
 * Convenience method.
 */
protected String getResourceString(String propertyName) {
	return ResourceManager.getResource(this.getClass(), propertyName);
}
/**
 * Popup an error Dialog.
 * @param exception java.lang.Throwable
 */
protected void handleException(java.lang.Throwable exception) {
	BaseFrame.showException(this, exception);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		// user code end
		setName("BaseDialog");
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setSize(426, 240);
//		setTitle("<Abstract/Template Dialog>");
		setContentPane(getJDialogContentPane());
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * Overwrite this method for other OK-Reasons.
 * @see #okPressed()
 * @see #applyPressed()
 * @return boolean whether saving was successful or not
 */
public boolean isSaved() {
	// do nothing by default
	return saved;
}
/**
 * Typical OK-Action. Save Contents and close Dialog.
 * Trigger an OK-Buttons actionPerformed-Event to this method.
 * @see #save()
 */
protected void okPressed() {
	if (save()) {
		dispose();
	}
}
/**
 * Overwrite this method for other OK-Reasons.
 * @see #okPressed()
 * @see #applyPressed()
 * @return boolean whether saving was successful or not
 */
protected boolean save() {
	// do nothing by default
	saved = true;
	return true;
}
/**
 * Show the Dialog in the center of the screen.
 */
public void setCenterLocation() {
	setCenterLocation(BaseFrame.getScreenSize());
}
/**
 * Show the Dialog in the center of the outerDimension.
 */
private void setCenterLocation(Dimension outerSize) {
	Dimension frameSize = getSize();

	if (frameSize.height > outerSize.height) {
		frameSize.height = outerSize.height;
	}
	if (frameSize.width > outerSize.width) {
		frameSize.width = outerSize.width;
	}

	setLocation(
		new Point(
			(outerSize.width - frameSize.width) / 2,
			(outerSize.height - frameSize.height) / 2));
}
/**
 * Trace the exception.
 * @param exception java.lang.Throwable
 */
protected void traceOnly(java.lang.Throwable exception) {
	Tracer.getInstance().uncaughtException(exception);//$NON-NLS-1$
}
/**
 * Overwrite this method for other Undo-Reasons.
 * @see #cancelPressed()
 */
protected void undo() {
	// do nothing by default
}

/**
 * BaseDialog constructor comment.
 * @param owner Component (for e.g. JPanel)
 * @param title java.lang.String
 * @param modal boolean
 * @deprecated
 */
public BaseDialog(java.awt.Component owner, String title, boolean modal) {
	super(getOwner(owner), title, modal);
//	this(owner, title, modal); -> does not relocate
	setRelativeLocation(owner);
	initialize();
}

/**
 * Set this Dialog relative to parent Window.
 * @see BaseFrame#setRelativeLocation()
 */
protected void setRelativeLocation(java.awt.Component parent) {
	if (parent != null) {
		setLocation(new Point(parent.getX() + BaseFrame.X_CHILD_OFFSET,
								parent.getY() + BaseFrame.Y_CHILD_OFFSET));

//		setCenterLocation(parent.getSize());
//		setLocationRelativeTo(parent);
	}
}

/**
 * Create and open a Confirmation-Dialog modally.
 * YES or a NO are possible options.
 * @see #showWarning()
 * @return true->YES was pressed; false->NO was pressed
 */
public static boolean showConfirm(java.awt.Component owner, String title, Object message) {
	Object[] options = { ResourceManager.getResource(BaseDialog.class, "BtnYes_text"), ResourceManager.getResource(BaseDialog.class, "BtnNo_text") };
	return (showOptionPane(owner,
		        (title == null ? ResourceManager.getResource(BaseDialog.class, "CTQuestion") : title),
		        message,
		        options,
		        "question-icon.gif") == 0);
}

/**
 * Create and open a Confirmation-Dialog modally.
 * YES, NO or CANCEL are possible options.
 * @see #showWarning()
 * @return Boolen.TRUE->YES was pressed; Boolean.FALSE->NO was pressed; null->CANCEL was pressed
 */
public static Boolean showConfirmCancel(java.awt.Component owner, String title, Object message) {
	Object[] options = { ResourceManager.getResource(BaseDialog.class, "BtnYes_text"), ResourceManager.getResource(BaseDialog.class, "BtnNo_text"), getCancelString() };
	int answer = showOptionPane(owner,
	        (title == null ? ResourceManager.getResource(BaseDialog.class, "CTQuestion") : title),
	        message,
	        options,
	        "question-icon.gif");
	switch (answer) {
		case 0: {
			return Boolean.TRUE;
		}
		case 1: {
			return Boolean.FALSE;
		}
	};
	
	return null;
}

/**
 * @see #showConfirmDeletion(Component, Object, String)
 */
public static boolean showConfirmDeletion(java.awt.Component owner) {
	return showConfirmDeletion(owner, ResourceManager.getResource(BaseDialog.class, "CTDeletion"), ResourceManager.getResource(BaseDialog.class, "CIQueryForDeletion"));
}

/**
 * Create and open Confirmation for Deletion Dialog modally.
 * @see #showWarning()
 * @return true->Deletion may proceed; false->otherwise
 */
public static boolean showConfirmDeletion(java.awt.Component owner, String title, Object message) {
	Object[] options = { ResourceManager.getResource(BaseDialog.class, "BtnYes_text"), ResourceManager.getResource(BaseDialog.class, "BtnNo_text") };
	return (showOptionPane(owner,
	        	(title == null ? ResourceManager.getResource(BaseDialog.class, "CTDeletion") : title),
	        	message,
	        	options,
	        	"dustbin.png") == 0);
}

/**
 * Create and open an Confirmation-Dialog for application termination.
 * @see #showConfirmCancel()
 */
public static Boolean showConfirmExit(java.awt.Component owner) {
	return showConfirmCancel(owner, CommonUserAccess.getTitleSaveChanges(), CommonUserAccess.getQuestionSaveChanges());
}

/**
 * Create and open Error-Dialog modally.
 * @param exception optional Exception which may be showed as Stacktrace
 * @see #showWarning()
 */
public static void showError(java.awt.Component owner, String title, Object message, Throwable exception) {
//TODO replace ErrorDialog by JOptionPane
	new ErrorDialog(owner, title, message==null? null: message.toString(), exception);
}

/**
 * Create and open a JOptionPane-Dialog modally.
 * 
 * @param options where first option is assumed as default
 * @return option index in options pressed (-1 for any unexpected failures)
 */
private static int showOptionPane(java.awt.Component owner, String title, Object message, Object[] options, String iconFile) {
	try {
		return javax.swing.JOptionPane.showOptionDialog(owner, message, title,
            javax.swing.JOptionPane.DEFAULT_OPTION, javax.swing.JOptionPane.PLAIN_MESSAGE,
            ch.ehi.basics.i18n.ResourceBundle.getImageIcon(BaseDialog.class, iconFile),
            options, options[0]);
	} catch(Throwable e) {
Tracer.getInstance().developerError(e.getLocalizedMessage());
		return -1;
	}
}

/**
 * Create and open Warning-Dialog modally.
 * @param owner
 * @param title of Dialog (null for default-Warning-Title)
 * @param message (formatting Symbols such as '\n' are allowed)
 */
public static void showWarning(java.awt.Component owner, String title, Object message) {
	Object[] options = { getCancelString() };
	showOptionPane(owner, 
	        		(title == null ? ResourceManager.getResource(BaseDialog.class, "CTWarning") : title), 
	        		message,
	        		options,
	        		"warning-icon.gif");
}
/**
 * @see WaitDialog#showBusy()
 */
protected final void showBusy(final Runnable block) {
	WaitDialog.showBusy(this, block);
}
/**
 * @see WaitDialog#updateProgress()
 */
protected final void showProgress(final int percentage, final String currentActivity) {
	WaitDialog.updateProgress(percentage, currentActivity);
}
}
