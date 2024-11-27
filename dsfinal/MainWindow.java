package dsfinal;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JSplitPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import java.awt.Component;

/** Java Swing window
 * 
 *    :IMPORTANT NOTE:
 *    
 *  A lot of code in this class is generated as I create and modify
 *  the GUI in the design window. For this reason, a lot of stuff
 *  doesn't have comments. Anything I wrote personally myself is commented,
 *  otherwise it was generated from the Design window. (I still made it all
 *  myself, none of this is stolen or AI generated, it was just done using
 *  a design window to have a visual version of the code.)
 *  
 *    :IMPORTANT NOTE:
 * 
 * @author Brendan Coleman 
 * @version 1.0
 * @since 1.0
*/
/*  
* OS: Windows x64
* IDE: Eclipse
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified, nor used generative AI as a final draft. 
* I have not given other fellow student(s) access to my program.
*/

public class MainWindow {

	// Layout and frame of window to be referenced later
	private CardLayout cardLayout;
	private JFrame frame;
	
	// Values for input made globally available so they can be cleared
	// Add pet values
	private JTextField BreedValue;
	private JTextField NameValue;
	private JComboBox TypeValue;
	private JComboBox GenderValue;
	private JSpinner AgeValue;
	
	// Appointment info values
	private JTextField AppointmentInfoValue;
	private JTextField AppointmentBreedValue;
	private JComboBox AppointmentTypeValue;
	
	// Appointment services values
	private JCheckBox Surgery;
	private JCheckBox Vaccination;
	private JCheckBox Xray;
	private JCheckBox Bloodwork;
	private JCheckBox Dentistry;
	private JCheckBox Checkup;
	
	// Local vetQueue and petList to be accessed in the GUI
	private VetQueue vetQueue = new VetQueue();
	private PetList petList = new PetList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		cardLayout = (CardLayout) frame.getContentPane().getLayout();
		
		JPanel Home = new JPanel();
		frame.getContentPane().add(Home, "name_305557830602900");
		Home.setLayout(new BorderLayout(0, 30));
		
		JLabel HomeTitle = new JLabel("Pet & Vet Tracker");
		HomeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		HomeTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Home.add(HomeTitle, BorderLayout.NORTH);
		
		JPanel HomeButtons = new JPanel();
		Home.add(HomeButtons, BorderLayout.CENTER);
		GridBagLayout gbl_HomeButtons = new GridBagLayout();
		gbl_HomeButtons.columnWidths = new int[] {250};
		gbl_HomeButtons.rowHeights = new int[] {25, 10};
		gbl_HomeButtons.columnWeights = new double[]{1.0};
		gbl_HomeButtons.rowWeights = new double[]{1.0, 1.0};
		HomeButtons.setLayout(gbl_HomeButtons);
		
		JPanel PetButtons = new JPanel();
		GridBagConstraints gbc_PetButtons = new GridBagConstraints();
		gbc_PetButtons.insets = new Insets(0, 0, 5, 0);
		gbc_PetButtons.fill = GridBagConstraints.BOTH;
		gbc_PetButtons.gridx = 0;
		gbc_PetButtons.gridy = 0;
		HomeButtons.add(PetButtons, gbc_PetButtons);
		
		JButton AddPet = new JButton("Add Pet");
		PetButtons.add(AddPet);
		
		JButton ViewPets = new JButton("View Pets");
		PetButtons.add(ViewPets);
		
		JButton ScheduleAppointment = new JButton("Schedule Appointment");
		GridBagConstraints gbc_ScheduleAppointment = new GridBagConstraints();
		gbc_ScheduleAppointment.gridx = 0;
		gbc_ScheduleAppointment.gridy = 1;
		HomeButtons.add(ScheduleAppointment, gbc_ScheduleAppointment);
		
		JPanel panel = new JPanel();
		Home.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton ExitQueue = new JButton("");
		panel.add(ExitQueue);
		
		JLabel waittime = new JLabel("Current Wait-time: " + vetQueue.getQueueTimeStyled());
		panel.add(waittime);
		waittime.setHorizontalAlignment(SwingConstants.CENTER);
		waittime.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel AddPetPage = new JPanel();
		frame.getContentPane().add(AddPetPage, "name_305582136396100");
		AddPetPage.setLayout(new BorderLayout(0, 10));
		
		JLabel AddPetTitle = new JLabel("Add New Pet");
		AddPetTitle.setHorizontalAlignment(SwingConstants.CENTER);
		AddPetTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AddPetPage.add(AddPetTitle, BorderLayout.NORTH);
		
		JPanel NewPetForm = new JPanel();
		AddPetPage.add(NewPetForm, BorderLayout.CENTER);
		GridBagLayout gbl_NewPetForm = new GridBagLayout();
		gbl_NewPetForm.columnWidths = new int[] {250};
		gbl_NewPetForm.rowHeights = new int[] {40, 40, 50, 40};
		gbl_NewPetForm.columnWeights = new double[]{1.0};
		gbl_NewPetForm.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0};
		NewPetForm.setLayout(gbl_NewPetForm);
		
		JPanel NameType = new JPanel();
		GridBagConstraints gbc_NameType = new GridBagConstraints();
		gbc_NameType.insets = new Insets(0, 0, 5, 0);
		gbc_NameType.fill = GridBagConstraints.BOTH;
		gbc_NameType.gridx = 0;
		gbc_NameType.gridy = 0;
		NewPetForm.add(NameType, gbc_NameType);
		
		JLabel NameLabel = new JLabel("Name");
		NameType.add(NameLabel);
		
		NameValue = new JTextField();
		NameType.add(NameValue);
		NameValue.setColumns(10);
		
		JLabel TypeLabel = new JLabel("Pet Type");
		NameType.add(TypeLabel);
		
		TypeValue = new JComboBox();
		TypeValue.setModel(new DefaultComboBoxModel(new String[] {"dog", "cat", "bird", "rodent"}));
		NameType.add(TypeValue);
		
		JPanel BreedGender = new JPanel();
		GridBagConstraints gbc_BreedGender = new GridBagConstraints();
		gbc_BreedGender.insets = new Insets(0, 0, 5, 0);
		gbc_BreedGender.fill = GridBagConstraints.BOTH;
		gbc_BreedGender.gridx = 0;
		gbc_BreedGender.gridy = 1;
		NewPetForm.add(BreedGender, gbc_BreedGender);
		
		JLabel BreedLabel = new JLabel("Breed");
		BreedGender.add(BreedLabel);
		
		BreedValue = new JTextField();
		BreedGender.add(BreedValue);
		BreedValue.setColumns(10);
		
		JLabel GenderLabel = new JLabel("Gender");
		BreedGender.add(GenderLabel);
		
		GenderValue = new JComboBox();
		GenderValue.setModel(new DefaultComboBoxModel(new String[] {"male", "female"}));
		BreedGender.add(GenderValue);
		
		JPanel Age = new JPanel();
		GridBagConstraints gbc_Age = new GridBagConstraints();
		gbc_Age.insets = new Insets(0, 0, 5, 0);
		gbc_Age.fill = GridBagConstraints.BOTH;
		gbc_Age.gridx = 0;
		gbc_Age.gridy = 2;
		NewPetForm.add(Age, gbc_Age);
		
		JLabel AgeLabel = new JLabel("Age");
		Age.add(AgeLabel);
		
		AgeValue = new JSpinner();
		AgeValue.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		Age.add(AgeValue);
		
		JButton PetSubmit = new JButton("Add Pet");
		GridBagConstraints gbc_PetSubmit = new GridBagConstraints();
		gbc_PetSubmit.insets = new Insets(0, 0, 5, 0);
		gbc_PetSubmit.gridx = 0;
		gbc_PetSubmit.gridy = 3;
		NewPetForm.add(PetSubmit, gbc_PetSubmit);
		
		JPanel AddPetHome = new JPanel();
		AddPetPage.add(AddPetHome, BorderLayout.SOUTH);
		
		JButton PetReturnHome = new JButton("Return Home");
		AddPetHome.add(PetReturnHome);
		
		JPanel ViewPetsPage = new JPanel();
		frame.getContentPane().add(ViewPetsPage, "name_308771670338200");
		ViewPetsPage.setLayout(new BorderLayout(0, 0));
		
		JLabel PetsListTitle = new JLabel("Pets");
		PetsListTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PetsListTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ViewPetsPage.add(PetsListTitle, BorderLayout.NORTH);
		
		JTextPane PetsListValue = new JTextPane();
		ViewPetsPage.add(PetsListValue, BorderLayout.CENTER);
		
		JPanel ViewPetsHome = new JPanel();
		ViewPetsPage.add(ViewPetsHome, BorderLayout.SOUTH);
		
		JButton PetsReturnHome = new JButton("Return Home");
		ViewPetsHome.add(PetsReturnHome);
		
		JPanel SortOptions = new JPanel();
		ViewPetsPage.add(SortOptions, BorderLayout.EAST);
		SortOptions.setLayout(new BoxLayout(SortOptions, BoxLayout.Y_AXIS));
		
		JLabel SortTitle = new JLabel("Sort By");
		SortTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		SortTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		SortTitle.setHorizontalAlignment(SwingConstants.CENTER);
		SortOptions.add(SortTitle);
		
		JButton SortAge = new JButton("Age");
		SortAge.setAlignmentX(Component.CENTER_ALIGNMENT);
		SortOptions.add(SortAge);
		
		JButton SortName = new JButton("Name");
		SortName.setAlignmentX(Component.CENTER_ALIGNMENT);
		SortOptions.add(SortName);
		
		JButton SortType = new JButton("Type");
		SortType.setAlignmentX(Component.CENTER_ALIGNMENT);
		SortOptions.add(SortType);
		
		JButton SortGender = new JButton("Gender");
		SortGender.setAlignmentX(Component.CENTER_ALIGNMENT);
		SortOptions.add(SortGender);
		
		JPanel AppointmentPage = new JPanel();
		frame.getContentPane().add(AppointmentPage, "name_315475275066900");
		AppointmentPage.setLayout(new BorderLayout(0, 10));
		
		JLabel AppointmentTitle = new JLabel("Schedule Appointment");
		AppointmentTitle.setHorizontalAlignment(SwingConstants.CENTER);
		AppointmentTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		AppointmentPage.add(AppointmentTitle, BorderLayout.NORTH);
		
		JPanel AppointmentForm = new JPanel();
		AppointmentPage.add(AppointmentForm, BorderLayout.CENTER);
		GridBagLayout gbl_AppointmentForm = new GridBagLayout();
		gbl_AppointmentForm.columnWidths = new int[] {100, 250};
		gbl_AppointmentForm.rowHeights = new int[] {30, 100};
		gbl_AppointmentForm.columnWeights = new double[]{0.0, 0.0};
		gbl_AppointmentForm.rowWeights = new double[]{0.0, 0.0};
		AppointmentForm.setLayout(gbl_AppointmentForm);
		
		JLabel ServicesTitle = new JLabel("Services");
		ServicesTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_ServicesTitle = new GridBagConstraints();
		gbc_ServicesTitle.insets = new Insets(0, 0, 5, 5);
		gbc_ServicesTitle.gridx = 0;
		gbc_ServicesTitle.gridy = 0;
		AppointmentForm.add(ServicesTitle, gbc_ServicesTitle);
		
		JLabel InfoTitle = new JLabel("Pet Information");
		InfoTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_InfoTitle = new GridBagConstraints();
		gbc_InfoTitle.insets = new Insets(0, 0, 5, 0);
		gbc_InfoTitle.gridx = 1;
		gbc_InfoTitle.gridy = 0;
		AppointmentForm.add(InfoTitle, gbc_InfoTitle);
		
		JPanel Services = new JPanel();
		GridBagConstraints gbc_Services = new GridBagConstraints();
		gbc_Services.insets = new Insets(0, 0, 0, 5);
		gbc_Services.gridx = 0;
		gbc_Services.gridy = 1;
		AppointmentForm.add(Services, gbc_Services);
		Services.setLayout(new BoxLayout(Services, BoxLayout.Y_AXIS));
		
		Surgery = new JCheckBox("Surgery");
		Services.add(Surgery);
		
		Vaccination = new JCheckBox("Vaccination");
		Services.add(Vaccination);
		
		Xray = new JCheckBox("X-Ray");
		Services.add(Xray);
		
		Bloodwork = new JCheckBox("Bloodwork");
		Services.add(Bloodwork);
		
		Dentistry = new JCheckBox("Dentistry");
		Services.add(Dentistry);
		
		Checkup = new JCheckBox("Check-up");
		Services.add(Checkup);
		
		JPanel PetInfo = new JPanel();
		GridBagConstraints gbc_PetInfo = new GridBagConstraints();
		gbc_PetInfo.fill = GridBagConstraints.BOTH;
		gbc_PetInfo.gridx = 1;
		gbc_PetInfo.gridy = 1;
		AppointmentForm.add(PetInfo, gbc_PetInfo);
		PetInfo.setLayout(new BoxLayout(PetInfo, BoxLayout.Y_AXIS));
		
		JPanel PetInfoTopSection = new JPanel();
		PetInfo.add(PetInfoTopSection);
		PetInfoTopSection.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel AppointmentType = new JLabel("Pet Type");
		PetInfoTopSection.add(AppointmentType);
		
		AppointmentTypeValue = new JComboBox();
		AppointmentTypeValue.setModel(new DefaultComboBoxModel(new String[] {"dog", "cat", "bird", "rodent"}));
		PetInfoTopSection.add(AppointmentTypeValue);
		
		JLabel AppointmentBreed = new JLabel("Breed");
		PetInfoTopSection.add(AppointmentBreed);
		
		AppointmentBreedValue = new JTextField();
		PetInfoTopSection.add(AppointmentBreedValue);
		AppointmentBreedValue.setColumns(8);
		
		JPanel PetInfoBottomSection = new JPanel();
		PetInfo.add(PetInfoBottomSection);
		PetInfoBottomSection.setLayout(new BoxLayout(PetInfoBottomSection, BoxLayout.Y_AXIS));
		
		JLabel AppointmentInfo = new JLabel("Other information");
		PetInfoBottomSection.add(AppointmentInfo);
		
		AppointmentInfoValue = new JTextField();
		PetInfoBottomSection.add(AppointmentInfoValue);
		AppointmentInfoValue.setColumns(10);
		
		JButton AppointmentSubmit = new JButton("Submit");
		PetInfoBottomSection.add(AppointmentSubmit);
		
		JPanel AppointmentHome = new JPanel();
		AppointmentPage.add(AppointmentHome, BorderLayout.SOUTH);
		
		JButton AppointmentReturnHome = new JButton("Return Home");
		AppointmentHome.add(AppointmentReturnHome);
		
		JPanel ThankyouPage = new JPanel();
		frame.getContentPane().add(ThankyouPage, "name_320585487611800");
		ThankyouPage.setLayout(new BorderLayout(0, 50));
		
		JLabel ThankyouTitle = new JLabel("Appointment Confirmed!");
		ThankyouTitle.setHorizontalAlignment(SwingConstants.CENTER);
		ThankyouTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ThankyouPage.add(ThankyouTitle, BorderLayout.NORTH);
		
		JPanel ThankyouHome = new JPanel();
		ThankyouPage.add(ThankyouHome, BorderLayout.CENTER);
		
		JButton ThankyouReturnHome = new JButton("Return Home");
		ThankyouHome.add(ThankyouReturnHome);
		
		// Home Buttons
			// Go to add new pet page
		AddPet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_305582136396100");
			}
		});
			// Go to view all pets page
		ViewPets.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Resets PetsListValue with petList's allPets method
				PetsListValue.setText(petList.allPets());
				cardLayout.show(frame.getContentPane(), "name_308771670338200");
			}
		});
			// Go to schedule appointment page
		ScheduleAppointment.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_315475275066900");
			}
		});
			// Test button for simulating queue removal
		ExitQueue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Uses vetQueue's removeFromQueue to remove item and updates waittime with vetQueue's new styled time
				vetQueue.removeFromQueue();
				waittime.setText("Current Wait-time: " + vetQueue.getQueueTimeStyled());
			}
		});
		
		
		
		// Add Pets Buttons
			// Adds new pet to petList
		PetSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Gets all of the values for new pet
				String petName = NameValue.getText();
				int petAge = (Integer) AgeValue.getValue();
				String petType = (String) TypeValue.getSelectedItem();
				String petBreed = BreedValue.getText();
				String petGender = (String) GenderValue.getSelectedItem();
				Pet tempPet = new Pet(petName, petAge, petType, petBreed, petGender);
				
				// Adds new pet to list and resets the GUI's input fields
				petList.add(tempPet);
				resetFields();
				cardLayout.show(frame.getContentPane(), "name_305557830602900");
			}
		});
			// Return to home button
		PetReturnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_305557830602900");
				waittime.setText("Current Wait-time: " + vetQueue.getQueueTimeStyled());
			}
		});
		
		
		
		// View Pets Buttons
			// Return to home button
		PetsReturnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_305557830602900");
				waittime.setText("Current Wait-time: " + vetQueue.getQueueTimeStyled());
			}
		});
			// Sorting algorithms - Sorts all pets by attributes and returns new string
		SortAge.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				petList.sortByAge();
				PetsListValue.setText(petList.allPets());
			}
		});
		SortName.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				petList.sortByName();
				PetsListValue.setText(petList.allPets());
			}
		});
		SortType.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				petList.sortByType();
				PetsListValue.setText(petList.allPets());
			}
		});
		SortGender.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				petList.sortByGender();
				PetsListValue.setText(petList.allPets());
			}
		});
		
		
		
		// Appointment Buttons
			// Submit new appointment
		AppointmentSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Gets pet type and creates new list of services
				String petType = (String) AppointmentTypeValue.getSelectedItem();
				List<String> services = new ArrayList<>();
				// Checks for each selected services and if selected, adds to services list
				if (Surgery.isSelected()) {
					services.add("surgery");
				}
				if (Vaccination.isSelected()) {
					services.add("vaccine");
				}
				if (Xray.isSelected()) {
					services.add("xray");
				}
				if (Bloodwork.isSelected()) {
					services.add("bloodwork");
				}
				if (Dentistry.isSelected()) {
					services.add("dentistry");
				}
				if (Checkup.isSelected()) {
					services.add("checkup");
				}
				// Adds new item to queue based on type and services
				vetQueue.addToQueue(petType, services);
				// Resets fields
				resetFields();
				cardLayout.show(frame.getContentPane(), "name_320585487611800");
			}
		});
			// Return to home button
		AppointmentReturnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_305557830602900");
				waittime.setText("Current Wait-time: " + vetQueue.getQueueTimeStyled());
			}
		});
		
		
		
		// Thank you Buttons
			// Displays confirmation after making appointment. Only returns to home
		ThankyouReturnHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(frame.getContentPane(), "name_305557830602900");
				waittime.setText("Current Wait-time: " + vetQueue.getQueueTimeStyled());
			}
		});
	}
	
	
	// Method to reset all values after submission
	private void resetFields() {
		BreedValue.setText(null);
		NameValue.setText(null);;
		TypeValue.setSelectedItem("dog");
		GenderValue.setSelectedItem("male");;
		AgeValue.setValue(1);
		
		AppointmentInfoValue.setText(null);;
		AppointmentBreedValue.setText(null);;
		AppointmentTypeValue.setSelectedItem("dog");
		
		Surgery.setSelected(false);
		Vaccination.setSelected(false);
		Xray.setSelected(false);
		Bloodwork.setSelected(false);
		Dentistry.setSelected(false);
		Checkup.setSelected(false);
	}
}
