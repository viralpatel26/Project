package sait.frs.gui;

import java.awt.*;
import java.awt.event.*; // Needed for ActionListener Interface

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

import sait.frs.exception.*;
import sait.frs.manager.*;
import sait.frs.problemdomain.Flight;

/**
 * @author Khushi Sunil Bhatt, Viral Patel
 * @version July 9, 2020
 */
public class FlightsTab extends TabBase 
{
	/**Instance of travel manager.*/
	
	private FlightManager FlightMan;
	private ReservationManager rm;
	
	/**List of flights.*/
	private JList<Flight> flightsList;
	private DefaultListModel<Flight> flightsModel;
	
	/**
	 * Fields and buttons for Find flights component
	 */
	private JButton findFlights;
	private JComboBox txtFrom;
	private JComboBox txtTo;
	private JComboBox txtDate;
	
	/**
	 * Fields and buttons for Make reservation component
	 */
	private JButton reserve;
	private JTextField txtFlight;
	private JTextField txtAirline;
	private JTextField txtDay;
	private JTextField txtTime;
	private JTextField txtCost;
	private JTextField txtName;
	private JTextField txtCitizenship;
	
	/**
	 * Creates the components for flights tab.
	 * 
	 * @param Flightman object is passed into in order to use back end in this tab
	 */
	public FlightsTab(FlightManager FlightMan, ReservationManager rm) 
	{
		this.FlightMan = FlightMan;
		this.rm = rm;
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
	 * Contains the title of the tab
	 * @return JPanel is in north.
	 */
	private JPanel createNorthPanel() 
	{
		JPanel panel = new JPanel();
		
		JLabel title = new JLabel("Flights", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title);
		
		return panel;
	}
	
	/**
	 * Contains the list of selected flights
	 * @return JPanel is in center.
	 */
	private JPanel createCenterPanel() 
	{
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(10,10));
		
		flightsModel = new DefaultListModel<>();
		flightsList = new JList<>(flightsModel);
		
		// User can only select one item at a time.
		flightsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		// Wrap JList in JScrollPane so it is scrollable.
		JScrollPane scrollPane = new JScrollPane(this.flightsList);
		
		flightsList.addListSelectionListener(new MyListSelectionListener());
		
		panel.add(scrollPane, BorderLayout.CENTER);
		
		return panel;
	}
	
	/**
	 * Contains make reservation component
	 * @return JPanel is in east
	 */
	private JPanel createEastPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(10,10));
		
		// Title for the component
		JLabel title = new JLabel("Reserve", SwingConstants.CENTER);
		title.setFont(new Font("san serif", Font.PLAIN, 25));
		panel.add(title, BorderLayout.NORTH);
		
		JPanel GridLayout = new JPanel();
		GridLayout.setLayout(new GridLayout(7,2));
		
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new FlowLayout());
		centerPanel.add(GridLayout);
		
		// Fields and their label in Make reservation component
		JLabel lFlight = new JLabel("Flight: ", SwingConstants.RIGHT);
		GridLayout.add(lFlight);
		txtFlight = new JTextField(10);
		txtFlight.setEditable(false);
		GridLayout.add(txtFlight);
		
		JLabel lAirline = new JLabel("Airline: ",SwingConstants.RIGHT);
		GridLayout.add(lAirline);
		txtAirline = new JTextField(10);
		txtAirline.setEditable(false);
		GridLayout.add(txtAirline);
		
		JLabel lDay = new JLabel("Day: ",SwingConstants.RIGHT);
		txtDay = new JTextField(10);
		txtDay.setEditable(false);
		GridLayout.add(lDay);
		GridLayout.add(txtDay);
		
		JLabel lTime = new JLabel("Time: ",SwingConstants.RIGHT);
		txtTime = new JTextField(10);
		txtTime.setEditable(false);
		GridLayout.add(lTime);
		GridLayout.add(txtTime);
		
		JLabel lCost = new JLabel("Cost: ",SwingConstants.RIGHT);
		txtCost = new JTextField(10);
		txtCost.setEditable(false);
		GridLayout.add(lCost);
		GridLayout.add(txtCost);
		
		JLabel lName = new JLabel("Name: ",SwingConstants.RIGHT);
		txtName = new JTextField(10);
		GridLayout.add(lName);
		GridLayout.add(txtName);
		
		JLabel lCitizenship = new JLabel("Citizenship: ",SwingConstants.RIGHT);
		txtCitizenship = new JTextField(10);
		GridLayout.add(lCitizenship);
		GridLayout.add(txtCitizenship);
		
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Reservation button
		reserve = new JButton("Reserve");
		panel.add(reserve, BorderLayout.SOUTH);
		reserve.addActionListener(new MyActionListener());
		
		return panel;
	}
	
	/**
	 * Create the west panel
	 * @return JPanel is in west
	 */
	private JPanel createWestPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		return panel;
	}
	
	/**
	 * Contains find flight component
	 * @return JPanel that goes in south
	 */
	private JPanel createSouthPanel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout());
		
		// Title for the component
		JLabel title = new JLabel("Flight Finder", SwingConstants.CENTER);
		title.setFont(new Font("serif", Font.PLAIN, 25));
		panel.add(title, BorderLayout.NORTH);
		
		// Label of Fields for the component
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(3,1));
		JLabel lFrom = new JLabel("From: ", SwingConstants.RIGHT);
		westPanel.add(lFrom);
		JLabel lTo = new JLabel("To: ", SwingConstants.RIGHT);
		westPanel.add(lTo);
		JLabel lDay = new JLabel("Day: ", SwingConstants.RIGHT);
		westPanel.add(lDay);

		panel.add(westPanel, BorderLayout.WEST);
		
		// Fields for the component
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3,1));
		txtFrom = new JComboBox(this.FlightMan.getAirports().toArray(new String[FlightMan.getAirports().size()]));
		centerPanel.add(txtFrom);
		txtTo = new JComboBox(FlightMan.getAirports().toArray(new String[FlightMan.getAirports().size()]));
		centerPanel.add(txtTo);
		String[] days = {this.FlightMan.WEEKDAY_ANY, this.FlightMan.WEEKDAY_MONDAY, this.FlightMan.WEEKDAY_TUESDAY, this.FlightMan.WEEKDAY_WEDNESDAY, this.FlightMan.WEEKDAY_THURSDAY, this.FlightMan.WEEKDAY_FRIDAY, this.FlightMan.WEEKDAY_SATURDAY, this.FlightMan.WEEKDAY_SUNDAY};
		txtDate = new JComboBox(days);
		centerPanel.add(txtDate);
		
		panel.add(centerPanel, BorderLayout.CENTER);
		
		// Find button
		findFlights = new JButton("Find Flights");
		findFlights.addActionListener(new MyActionListener());
		panel.add(findFlights, BorderLayout.SOUTH);
		
		return panel;
	}
	
	/**
	 * Clears the entered fields
	 */
	public void emptyFields () {
		txtFlight.setText("");
		txtAirline.setText("");
		txtDay.setText("");
		txtTime.setText("");
		txtCost.setText("");
		txtName.setText("");
		txtCitizenship.setText("");
	}
	
	/**
	 * Clears the list of selected flights
	 */
	public void clearList() {
		flightsModel.clear();
	}
	
	/**
	 * Clears fields in filter component
	 */
	public void clearFilters() {
		txtFrom.setSelectedIndex(0);
		txtTo.setSelectedIndex(0);
		txtDate.setSelectedIndex(0);
	}
	
	/**
	 * Fills the list with conditions in filter component
	 */
	private void fillList() {
		ArrayList<Flight> flights = FlightMan.findFlights((String) txtFrom.getSelectedItem(),(String) txtTo.getSelectedItem(),(String) txtDate.getSelectedItem());
		if ( flights.size() == 0 ) {
			JOptionPane.showMessageDialog(null, "No Flights found");
		}
		else {
			for ( Flight f : flights )
			{
				flightsModel.addElement(f);
			};
		}
	} 
	
	private class MyListSelectionListener implements ListSelectionListener 
	{
		/**
		 * Method called when user selects an item in the JList.
		 */
		@Override
		public void valueChanged(ListSelectionEvent event) {
			try {
				Flight f = flightsList.getSelectedValue();
				txtFlight.setText(f.getCode());
				txtAirline.setText(f.getAirlineName());
				txtDay.setText(f.getWeekday());
				txtTime.setText(f.getTime());
				txtCost.setText(f.getCostPerSeat()+"");
			} catch ( Exception e ) {}
			
		}
		
	}
	
	private class MyActionListener implements ActionListener
	{
		/**
		 * Action for buttons
		 */
		@Override
		public void actionPerformed(ActionEvent event) {
			
			// Action for finding flights
			if ( event.getSource() == findFlights ) {
				clearList();
				emptyFields();
				fillList();
			}
			
			// Action for making reservation
			if ( event.getSource() == reserve ) {
				try {
					JOptionPane.showMessageDialog(null, "Reversation created. Your code is " +
					rm.makeReservation(FlightMan.findFlightByCode(txtFlight.getText()),txtName.getText(),txtCitizenship.getText()).getCode());
					emptyFields();
					clearList();
					fillList();
				} catch (NullFlightException | NoMoreSeatsException | InvalidNameException
						| InvalidCitizenshipException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				rm.persist();
			}
		}
	}
}