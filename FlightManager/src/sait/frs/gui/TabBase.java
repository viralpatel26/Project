package sait.frs.gui;

import javax.swing.*;

/**
 * Abstract class for a tab in the JFrame.
 * 
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */
public abstract class TabBase 
{
	protected JPanel panel;
	
	protected TabBase() {
		this.panel = new JPanel();
	}
	
	/**
	 * Gets the panel containing the tab components.
	 * @return JPanel with components.
	 */
	public JPanel getPanel() {
		return this.panel;
	}

	/**Clears value of fields in tabs*/
	protected abstract void emptyFields();

	/**Clears value in list in tabs*/
	protected abstract void clearList();

	/**Clears value of filters in tabs*/
	protected abstract void clearFilters();
}