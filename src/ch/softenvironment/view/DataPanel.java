package ch.softenvironment.view;

import ch.softenvironment.util.ResourceManager;

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
 
/**
 * Simple Panel to represent a certain Object which
 * allows changes to be saved.
 * @author: Peter Hirzel <i>soft</i>Environment
 * @version $Revision: 1.3 $ $Date: 2004-04-27 09:14:58 $
 */
public abstract class DataPanel extends javax.swing.JPanel {
/**
 * DataPanel constructor comment.
 */
public DataPanel() {
	super();
}
/**
 * Adapt the given PopupMenu before displaying it (for e.g. disable Items).
 * Overwrite this method.
 * @see #genericPopupDisplay()
 */
protected javax.swing.JPopupMenu adaptPopupMenu(javax.swing.JPopupMenu popupMenu) {
	// overwrite
	return null;
}
/**
 * @see BaseFrame
 */
protected void genericPopupDisplay(java.awt.event.MouseEvent event, javax.swing.JPopupMenu popupMenu) {
	if (event.isPopupTrigger()) {
		adaptPopupMenu(popupMenu);
		popupMenu.show(event.getComponent(), event.getX(), event.getY());
	}
}
/**
 * Return the changed object displayed.
 */
public abstract Object getObject();
/**
 * @see BaseFrame#getResourceString(String)
 */
protected String getResourceString(String propertyName) {
	return ResourceManager.getInstance().getResource(this.getClass(), propertyName);
}
/**
 * Popup an error Dialog.
 * @param exception java.lang.Throwable
 */
protected void handleException(java.lang.Throwable exception) {
	new ErrorDialog(this, null, exception.toString(), exception); //$NON-NLS-1$
}
/**
 * Set the Object to be displayed by panel.
 */
public abstract void setObject(Object object);
}
