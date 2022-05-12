package sait.frs.gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import sait.frs.exception.*;
import sait.frs.manager.*;
import sait.frs.problemdomain.Reservation;

/**
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */
public class ReservationsTab extends TabBase {
	/**Instance of travel manager.*/
	private ReservationManager manager;
	
	/**List of reservations.*/
	private JList<Reservation> reversationsList;
	private DefaultListModel<Reservation> reservationsModel;
	
	/**Fields and buttons for Find reservations component*/
	private JTextField txtCode;
	private JTextField txtAirline;
	private JTextField txtName;
	private JButton findReservations;
	
	/**Fields and buttons for Update reservation*/
	private JButton update;
	private JTextField txtCode1;
	private JTextField txtFlight;
	private JTextField txtAirline1;
	private JTextField txtCost;
	private JTextField txtName1;
	private JTextField txtCitizenship;
	private JComboBox txtStatus;
	
	/**
	 * Creates the components for reservations tab.
	 * 
	 * @param manager The Manager object is passed into in order to use back end in this tab
	 */
	public ReservationsTab(ReservationManager manager) {
		this.manager = manager;
		panel.setLayout(new BorderLayout(10,10));
		
		JPanel northPanel = createNorthPanel();
		panel.add(northPanel, BorderLayout.NORTH);
		
		JPanel centerPanel = createCenterPanel();
		panel.add(centerPanel, BorderLayout.CENTER);
		
		JPanel eastPanel = createEastPanel();
		panel.add(eastPanel, BorderLayout.EAST);
		
		JPanel westPanel = createWestPanel();
		panel.add(westPanel, BorderLayout.WEST);
		
		JPanel southPanel = createSouthPanel();
		panel.add(southPanel, BorderLayout.SOUTH);
	}
	
	/**
	 * Creates the north panel.
	 * Contains the title of the tab
	 * 
	 * @return JPanel that goes in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Reservations", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title);
		
		return panel;
	}
	
	/**
	 * Creates the center panel.
	 * Contains the list of selected reservations
	 * 
	 * @return JPanel that goes in center.
	 */
	private JPanel createCenterPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(10,10));
		
		reservationsModel = new DefaultListModel<>();
		reversationsList = new JList<>(reservationsModel);
		
		// User can only select one item at a time.
		reversationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.reversationsList);
		
		reversationsList.addListSelectionListener(new MyListSelectionListener());
		
		panel.add( scrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	/**
	 * Create the east panel
	 * Contains update reservation component
	 * 
	 * @return JPanel that goes in east
	 */
	private JPanel createEastPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(10,10));
		
		// Title for the component
		JLabel title = new JLabel("Reserve", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title, BorderLayout.NORTH);
		
		JPanel GridLayout = new JPanel();
		GridLayout.setLayout(new GridLayout(7,2));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(GridLayout);
		
		// Fields and their label in Update reservation component
		JLabel lCode = new JLabel("Code: ", SwingConstants.RIGHT);
		txtCode1 = new JTextField(10);
		txtCode1.setEditable(false);
		GridLayout.add(lCode);
		GridLayout.add(txtCode1);
		
		JLabel lFlight = new JLabel("Flight: ", SwingConstants.RIGHT);
		txtFlight = new JTextField(10);
		txtFlight.setEditable(false);
		GridLayout.add(lFlight);
		GridLayout.add(txtFlight);
		
		JLabel lAirline = new JLabel("Airline: ",SwingConstants.RIGHT);
		txtAirline1 = new JTextField(10);
		txtAirline1.setEditable(false);
		GridLayout.add(lAirline);
		GridLayout.add(txtAirline1);
		
		JLabel lCost = new JLabel("Cost: ",SwingConstants.RIGHT);
		txtCost = new JTextField(10);
		txtCost.setEditable(false);
		GridLayout.add(lCost);
		GridLayout.add(txtCost);
		
		JLabel lName = new JLabel("Name: ",SwingConstants.RIGHT);
		txtName1 = new JTextField(10);
		GridLayout.add(lName);
		GridLayout.add(txtName1);
		
		JLabel lCitizenship = new JLabel("Citizenship: ",SwingConstants.RIGHT);
		txtCitizenship = new JTextField(10);
		GridLayout.add(lCitizenship);
		GridLayout.add(txtCitizenship);
		
		JLabel lStatus = new JLabel("Status: ",SwingConstants.RIGHT);
		String[] status = {"Active", "Inactive"};
		txtStatus = new JComboBox(status);
		GridLayout.add(lStatus);
		GridLayout.add(txtStatus);
		
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Update button
		update = new JButton("Update");
		update.addActionListener(new MyActionListener());
		panel.add(update, BorderLayout.SOUTH);
		
		return panel;
	}
	
	/**
	 * Create the west panel
	 * @return JPanel that goes in west
	 */
	private JPanel createWestPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		return panel;
	}

	/**
	 * Create the south panel
	 * Contains find reservation component
	 * 
	 * @return JPanel that goes in south
	 */
	private JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		// Title for the component
		JLabel title = new JLabel("Search", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title, BorderLayout.NORTH);
		
		// Label of Fields for the component
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3,1));
		JLabel lCode = new JLabel("Code: ", SwingConstants.RIGHT);
		westPanel.add(lCode);
		JLabel lAirline = new JLabel("Airline: ", SwingConstants.RIGHT);
		westPanel.add(lAirline);
		JLabel lName = new JLabel("Name: ", SwingConstants.RIGHT);
		westPanel.add(lName);
	
		panel.add(westPanel, BorderLayout.WEST);
		
		// Fields for the component
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1));
		txtCode = new JTextField();
		centerPanel.add(txtCode);
		txtAirline = new JTextField();
		centerPanel.add(txtAirline);
		txtName = new JTextField();
		centerPanel.add(txtName);
		
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Find button
		findReservations = new JButton("Find Reservations");
		findReservations.addActionListener(new MyActionListener());
		panel.add(findReservations, BorderLayout.SOUTH);
		
		return panel;
	}
	
	/**
	 * Clear entered fields
	 */
	public void emptyFields () {
		txtCode1.setText("");
		txtFlight.setText("");
		txtAirline1.setText("");
		txtCost.setText("");
		txtName1.setText("");
		txtCitizenship.setText("");
		txtStatus.setSelectedIndex(0);
	}
	
	/**
	 * Clear list of selected flights
	 */
	public void clearList() {
		reservationsModel.clear();
	}
	
	/**
	 * Clear fields in filter component
	 */
	public void clearFilters() {
		txtCode.setText("");
		txtAirline.setText("");
		txtName.setText("");
	}
	
	/**
	 * Fill the list with conditions in filter component
	 */
	private void fillList() {
		ArrayList<Reservation> reservations = manager.findReservations(txtCode.getText(), txtAirline.getText(), txtName.getText());
		if ( reservations.size() == 0 ) {
			JOptionPane.showMessageDialog(null, "No Reservations found");
		} else {
			for ( Reservation r : reservations )
			{
				reservationsModel.addElement(r);
			};
		}
	}
	
	private class MyListSelectionListener implements ListSelectionListener 
	{
		@Override
		public void valueChanged(ListSelectionEvent event) {
			try {
				Reservation r = reversationsList.getSelectedValue();
				txtCode1.setText(r.getCode());
				txtFlight.setText(r.getFlightCode());
				txtAirline1.setText(r.getAirline());
				txtCost.setText(r.getCost()+"");
				txtName1.setText(r.getName());
				txtCitizenship.setText(r.getCitizenship());
				txtStatus.setSelectedIndex( (r.isActive()) ? 0 : 1 );
			} catch (Exception e) {}
		}
	}
	
	private class MyActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent event) {
			// Action for finding reservations
			if ( event.getSource() == findReservations ) {
				clearList();
				emptyFields();
				fillList();
			}
			
			// Action for updating reservation
			if ( event.getSource() == update ) {
				Reservation r = manager.findReservationByCode(txtCode1.getText());
				try {
					r.setName(txtName1.getText());
					r.setCitizenship(txtCitizenship.getText());
					r.setActive( (txtStatus.getSelectedIndex() == 0 ) ? true : false );
					JOptionPane.showMessageDialog(null, r.getCode() + " has been updated");
					clearList();
					emptyFields();
					fillList();
				} catch (InvalidNameException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
				} catch (InvalidCitizenshipException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
				manager.persist();
			}
		}
	}
}