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
 
import ch.softenvironment.util.*;
/**
 * Browser to walk through a List of Objects.
 * @author: Peter Hirzel <i>soft</i>Environment
 */
public class DataSelectorPanel extends javax.swing.JPanel {
	private static java.util.ResourceBundle resDataSelectorPanel = ch.ehi.basics.i18n.ResourceBundle.getBundle(DataSelectorPanel.class);
	private DataSelectorPanelListener listener = null;
	private java.util.List objects = null;
	private int currentIndex = -1;
	private javax.swing.JButton ivjTbbFirst = null;
	private javax.swing.JButton ivjTbbLast = null;
	private javax.swing.JButton ivjTbbNext = null;
	private javax.swing.JButton ivjTbbPrevious = null;
	private java.lang.Object fieldCurrentObject = null;
	IvjEventHandler ivjEventHandler = new IvjEventHandler();
	private javax.swing.JButton ivjTbbDelete = null;
	private javax.swing.JButton ivjTbbNew = null;
	private javax.swing.JTextField ivjTxtSelector = null;

class IvjEventHandler implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent e) {
			if (e.getSource() == DataSelectorPanel.this.getTbbFirst()) 
				connEtoC1(e);
			if (e.getSource() == DataSelectorPanel.this.getTbbPrevious()) 
				connEtoC2(e);
			if (e.getSource() == DataSelectorPanel.this.getTbbNext()) 
				connEtoC3(e);
			if (e.getSource() == DataSelectorPanel.this.getTbbLast()) 
				connEtoC4(e);
			if (e.getSource() == DataSelectorPanel.this.getTbbNew()) 
				connEtoC5(e);
			if (e.getSource() == DataSelectorPanel.this.getTbbDelete()) 
				connEtoC6(e);
		};
	};
/**
 * DataSelectorPanel constructor comment.
 */
public DataSelectorPanel() {
	super();
	initialize();
}
/**
 * Add a new Object to list at the very end.
 */
public void addObject() {
	saveChanges();
	
	if (listener != null) {
		objects.add(listener.createObject());
		// @see getLast()
		currentIndex = objects.size() - 1;
		setCurrentObject(objects.get(currentIndex));
	} else {
		Tracer.getInstance().developerError(this, "addObject()", "make sure to have a listener");//$NON-NLS-2$//$NON-NLS-1$
	}
}
/**
 * connEtoC1:  (TbbFirst.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.getFirst()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC1(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.getFirst();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC2:  (TbbPrevious.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.getPrevious()Ljava.lang.Object;)
 * @return java.lang.Object
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.lang.Object connEtoC2(java.awt.event.ActionEvent arg1) {
	Object connEtoC2Result = null;
	try {
		// user code begin {1}
		// user code end
		connEtoC2Result = this.getPrevious();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
	return connEtoC2Result;
}
/**
 * connEtoC3:  (TbbNext.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.getNext()Ljava.lang.Object;)
 * @return java.lang.Object
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private java.lang.Object connEtoC3(java.awt.event.ActionEvent arg1) {
	Object connEtoC3Result = null;
	try {
		// user code begin {1}
		// user code end
		connEtoC3Result = this.getNext();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
	return connEtoC3Result;
}
/**
 * connEtoC4:  (TbbLast.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.getLast()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC4(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.getLast();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC5:  (TbbNew.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.addObject()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC5(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.addObject();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * connEtoC6:  (TbbDelete.action.actionPerformed(java.awt.event.ActionEvent) --> DataSelectorPanel.removeObject()V)
 * @param arg1 java.awt.event.ActionEvent
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void connEtoC6(java.awt.event.ActionEvent arg1) {
	try {
		// user code begin {1}
		// user code end
		this.removeObject();
		// user code begin {2}
		// user code end
	} catch (java.lang.Throwable ivjExc) {
		// user code begin {3}
		// user code end
		handleException(ivjExc);
	}
}
/**
 * Return the currentObject's index in ObjectList.
 * This index starts at 0 for the very first Element.
 */
public int getCurrentIndex() {
	return currentIndex;
}
/**
 * Gets the currentObject property (java.lang.Object) value.
 * @return The currentObject property value.
 * @see #setCurrentObject
 */
public java.lang.Object getCurrentObject() {
	return fieldCurrentObject;
}
/**
 * Return the first of all objects.
 */
public Object getFirst() {
	saveChanges();
	
	if (currentIndex > 0) {
		currentIndex = 0;
		setCurrentObject(objects.get(currentIndex));
	}
	return getCurrentObject();
}
/**
 * Return the last of all Objects.
 */
public Object getLast() {
	saveChanges();
	
	if ((objects != null) && (currentIndex + 1 < objects.size())) {
		currentIndex = objects.size() - 1;
		setCurrentObject(objects.get(currentIndex));
	}

	return getCurrentObject();
}
/**
 * Set next Object as currentObject.
 */
public Object getNext() {	
	if ((objects != null) && (objects.size() > 0) && (currentIndex + 1 < objects.size())) {
		saveChanges();
		setCurrentObject(objects.get(++currentIndex));
	} else {
		setCurrentObject(null);
	}

	return getCurrentObject();
}
/**
 * Return the list of (manipulated) Objects.
 */
public java.util.List getObjects() {
	saveChanges();
	return objects;
}
/**
 * Set previous Object as currentObject.
 */
public Object getPrevious() {
	saveChanges();
	
	if (currentIndex > 0) {
		setCurrentObject(objects.get(--currentIndex));
	}
	
	return getCurrentObject();
}
/**
 * Return the TbbDelete property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbDelete() {
	if (ivjTbbDelete == null) {
		try {
			ivjTbbDelete = new javax.swing.JButton();
			ivjTbbDelete.setName("TbbDelete");
			ivjTbbDelete.setToolTipText(resDataSelectorPanel.getString("TbbDelete_toolTipText"));
			ivjTbbDelete.setText("");
			ivjTbbDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/delete.gif")));
			ivjTbbDelete.setPreferredSize(new java.awt.Dimension(23, 23));
			ivjTbbDelete.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbDelete.setEnabled(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbDelete;
}
/**
 * Return the TbbFirst property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbFirst() {
	if (ivjTbbFirst == null) {
		try {
			ivjTbbFirst = new javax.swing.JButton();
			ivjTbbFirst.setName("TbbFirst");
			ivjTbbFirst.setToolTipText(resDataSelectorPanel.getString("TbbFirst_toolTipText"));
			ivjTbbFirst.setText("");
			ivjTbbFirst.setMaximumSize(new java.awt.Dimension(23, 23));
			ivjTbbFirst.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbFirst.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/first_arrow.gif")));
			ivjTbbFirst.setPreferredSize(new java.awt.Dimension(23, 23));
			ivjTbbFirst.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbFirst.setEnabled(false);
			ivjTbbFirst.setMinimumSize(new java.awt.Dimension(23, 23));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbFirst;
}
/**
 * Return the TbbLast property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbLast() {
	if (ivjTbbLast == null) {
		try {
			ivjTbbLast = new javax.swing.JButton();
			ivjTbbLast.setName("TbbLast");
			ivjTbbLast.setToolTipText(resDataSelectorPanel.getString("TbbLast_toolTipText"));
			ivjTbbLast.setText("");
			ivjTbbLast.setMaximumSize(new java.awt.Dimension(23, 23));
			ivjTbbLast.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbLast.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/last_arrow.gif")));
			ivjTbbLast.setPreferredSize(new java.awt.Dimension(23, 23));
			ivjTbbLast.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbLast.setEnabled(false);
			ivjTbbLast.setMinimumSize(new java.awt.Dimension(23, 23));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbLast;
}
/**
 * Return the TbbNew property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbNew() {
	if (ivjTbbNew == null) {
		try {
			ivjTbbNew = new javax.swing.JButton();
			ivjTbbNew.setName("TbbNew");
			ivjTbbNew.setToolTipText(resDataSelectorPanel.getString("TbbNew_toolTipText"));
			ivjTbbNew.setText("");
			ivjTbbNew.setMaximumSize(new java.awt.Dimension(23, 23));
			ivjTbbNew.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbNew.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/new.gif")));
			ivjTbbNew.setPreferredSize(new java.awt.Dimension(23, 23));
			ivjTbbNew.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbNew.setEnabled(true);
			ivjTbbNew.setMinimumSize(new java.awt.Dimension(23, 23));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbNew;
}
/**
 * Return the TbbNext property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbNext() {
	if (ivjTbbNext == null) {
		try {
			ivjTbbNext = new javax.swing.JButton();
			ivjTbbNext.setName("TbbNext");
			ivjTbbNext.setToolTipText(resDataSelectorPanel.getString("TbbNext_toolTipText"));
			ivjTbbNext.setText("");
			ivjTbbNext.setMaximumSize(new java.awt.Dimension(23, 23));
			ivjTbbNext.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbNext.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/right_arrow.gif")));
			ivjTbbNext.setPreferredSize(new java.awt.Dimension(60, 23));
			ivjTbbNext.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbNext.setEnabled(false);
			ivjTbbNext.setMinimumSize(new java.awt.Dimension(23, 23));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbNext;
}
/**
 * Return the TbbPrevious property value.
 * @return javax.swing.JButton
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JButton getTbbPrevious() {
	if (ivjTbbPrevious == null) {
		try {
			ivjTbbPrevious = new javax.swing.JButton();
			ivjTbbPrevious.setName("TbbPrevious");
			ivjTbbPrevious.setToolTipText(resDataSelectorPanel.getString("TbbPrevious_toolTipText"));
			ivjTbbPrevious.setText("");
			ivjTbbPrevious.setMaximumSize(new java.awt.Dimension(23, 23));
			ivjTbbPrevious.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
			ivjTbbPrevious.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
			ivjTbbPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ch/softenvironment/images/left_arrow.gif")));
			ivjTbbPrevious.setPreferredSize(new java.awt.Dimension(60, 23));
			ivjTbbPrevious.setMargin(new java.awt.Insets(0, 0, 0, 0));
			ivjTbbPrevious.setEnabled(false);
			ivjTbbPrevious.setMinimumSize(new java.awt.Dimension(23, 23));
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTbbPrevious;
}
/**
 * Return the LblSelector property value.
 * @return javax.swing.JTextField
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private javax.swing.JTextField getTxtSelector() {
	if (ivjTxtSelector == null) {
		try {
			ivjTxtSelector = new javax.swing.JTextField();
			ivjTxtSelector.setName("TxtSelector");
			ivjTxtSelector.setText(" 0/0");
			ivjTxtSelector.setMaximumSize(new java.awt.Dimension(150, 20));
			ivjTxtSelector.setPreferredSize(new java.awt.Dimension(50, 20));
			ivjTxtSelector.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
			ivjTxtSelector.setMinimumSize(new java.awt.Dimension(50, 20));
			ivjTxtSelector.setEditable(false);
			// user code begin {1}
			// user code end
		} catch (java.lang.Throwable ivjExc) {
			// user code begin {2}
			// user code end
			handleException(ivjExc);
		}
	}
	return ivjTxtSelector;
}
/**
 * Called whenever the part throws an exception.
 * @param exception java.lang.Throwable
 */
private void handleException(java.lang.Throwable exception) {
	new ErrorDialog((javax.swing.JPanel)null, null, exception.toString(), exception);
}
/**
 * Initializes connections
 * @exception java.lang.Exception The exception description.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initConnections() throws java.lang.Exception {
	// user code begin {1}
	// user code end
	getTbbFirst().addActionListener(ivjEventHandler);
	getTbbPrevious().addActionListener(ivjEventHandler);
	getTbbNext().addActionListener(ivjEventHandler);
	getTbbLast().addActionListener(ivjEventHandler);
	getTbbNew().addActionListener(ivjEventHandler);
	getTbbDelete().addActionListener(ivjEventHandler);
}
/**
 * Initialize the class.
 */
/* WARNING: THIS METHOD WILL BE REGENERATED. */
private void initialize() {
	try {
		// user code begin {1}
		getTbbNew().setVisible(false);
		getTbbDelete().setVisible(false);
		if (objects == null) {
			// do not show CurrentObject relevant Widgets
			getTbbFirst().setEnabled(false);
			getTbbPrevious().setEnabled(false);
			getTbbNext().setEnabled(false);
			getTbbLast().setEnabled(false);
			getTxtSelector().setEnabled(false);
		}
		// user code end
		setName("DataSelectorPanel");
		setPreferredSize(new java.awt.Dimension(300, 23));
		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.X_AXIS));
		setSize(256, 24);
		setMaximumSize(new java.awt.Dimension(500, 23));
		setMinimumSize(new java.awt.Dimension(300, 23));
		add(getTbbFirst(), getTbbFirst().getName());
		add(getTbbPrevious(), getTbbPrevious().getName());
		add(getTxtSelector(), getTxtSelector().getName());
		add(getTbbNext(), getTbbNext().getName());
		add(getTbbLast(), getTbbLast().getName());
		add(getTbbNew(), getTbbNew().getName());
		add(getTbbDelete(), getTbbDelete().getName());
		initConnections();
	} catch (java.lang.Throwable ivjExc) {
		handleException(ivjExc);
	}
	// user code begin {2}
	// user code end
}
/**
 * main entrypoint - starts the part when it is run as an application
 * @param args java.lang.String[]
 */
public static void main(java.lang.String[] args) {
	try {
		javax.swing.JFrame frame = new javax.swing.JFrame();
		DataSelectorPanel aDataSelectorPanel;
		aDataSelectorPanel = new DataSelectorPanel();
		frame.setContentPane(aDataSelectorPanel);
		frame.setSize(aDataSelectorPanel.getSize());
		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.exit(0);
			};
		});
		frame.show();
		java.awt.Insets insets = frame.getInsets();
		frame.setSize(frame.getWidth() + insets.left + insets.right, frame.getHeight() + insets.top + insets.bottom);
		frame.setVisible(true);
	} catch (Throwable exception) {
		System.err.println("Exception occurred in main() of javax.swing.JPanel");
		exception.printStackTrace(System.out);
	}
}
/**
 * Remove the currentObject from list.
 */
public void removeObject() {
	if (listener != null) {
		// remove from context
		listener.removeObject(getCurrentObject());
		if (currentIndex > 0) {
			// remove from current list only
			objects.remove(getCurrentObject());
			// @see getPrevious()
			setCurrentObject(objects.get(--currentIndex));
		} else {
			// very first Object to be deleted in list
			objects.remove(currentIndex);
			if (objects.size() > 0) {
				setCurrentObject(objects.get(currentIndex));
			} else {
				setCurrentObject(null);
			}
		}
	} else {
		Tracer.getInstance().developerError(this, "removeObject()", "make sure to have a listener");//$NON-NLS-2$//$NON-NLS-1$
	}
}
/**
 * Allow Listener to save any changes.
 */
private void saveChanges() {
	if ((listener != null) && (getCurrentObject() != null)) {
		objects.set(currentIndex, listener.saveChanges(getCurrentObject()));
	}
}
/**
 * Sets the currentObject property (java.lang.Object) value.
 * @param currentObject The new value for the property.
 * @see #getCurrentObject
 */
public void setCurrentObject(java.lang.Object currentObject) {
	Object oldValue = fieldCurrentObject;
	fieldCurrentObject = currentObject;
	firePropertyChange("currentObject", oldValue, currentObject);//$NON-NLS-1$

	treatNextPreviousButtons();

	if (listener != null) {
		listener.setCurrentObject(currentObject);
	}
}
/**
 * Set the listener.
 * More than 1 Listener makes no sense here.
 */
public void setListener(DataSelectorPanelListener listener) {
	this.listener = listener;
	getTbbNew().setVisible(listener != null);
}
/**
 * Set the list of Objects to treat by Selector.
 * @param objects A list of Object's
 */
public void setObjects(java.util.List objects) {
	currentIndex = -1;
	this.objects = objects;	
	getNext();
}
/**
 *  Treat Next/Previous Buttons.
 */
private void treatNextPreviousButtons() {
	boolean prev = currentIndex > 0;
	getTbbFirst().setEnabled(prev);
	getTbbPrevious().setEnabled(prev);

	if ((objects != null) && (objects.size() > 0)) {
		boolean next = currentIndex + 1 < objects.size();
		getTbbNext().setEnabled(next);
		getTbbLast().setEnabled(next);
		getTbbDelete().setEnabled(true);
		getTxtSelector().setText(" " + (currentIndex + 1) + "/" + objects.size() + " ");//$NON-NLS-3$//$NON-NLS-2$//$NON-NLS-1$
		getTbbFirst().setEnabled(currentIndex > 0);
		getTbbLast().setEnabled(currentIndex + 1 < objects.size());
	} else {
		getTbbNext().setEnabled(false);
		getTbbLast().setEnabled(false);
		getTbbDelete().setEnabled(false);
		getTxtSelector().setText(" 0/0  ");//$NON-NLS-1$
		getTbbFirst().setEnabled(false);
		getTbbLast().setEnabled(false);
	}
}
}