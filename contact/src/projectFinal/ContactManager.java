package projectFinal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class ContactManager implements ActionListener {

	File fileName = new File("contacts.txt");
	String[] columnNames = { "First Name", "Last Name", "Phone Number" };
	String[] FirstNames = {};
	LinkedList<Contact> details = new LinkedList<Contact>();
	JFrame frameEditAdd, frameListAll, frameMessageBox;
	JScrollPane scrollBar;
	JTextField tfName, tfMiddleName, tfLastName, tfStreet, tfCity, tfState, tfZIP, tfbd, tfphoneno;
	JButton bSaveContact, bCancel, bUpdateContact;
	JButton bAddOnemore, bEdit, bRemove, bLoadAll, bSaveToFile;
	JTable tableListOfContacts;
	DefaultTableModel model;
	JLabel jlabelheader, jlabelFirstName, jlabelMiddleName, jlabelLastName,	jlabelStreet, jlabelCity, jlabelState, jlabelZIP, jlabelbd,jlphoneno;
	
	public void JTableTest() {
		this.frameEditAdd = new JFrame();
		this.frameEditAdd.setTitle("My Contacts");
		this.frameListAll = new JFrame();
		this.frameListAll.setTitle("My Contacts");
		
		this.frameEditAdd.setLayout(null);
		this.frameListAll.setLayout(null);

		this.jlabelheader = new JLabel("List Of Contacts (Click on Column Names to Sort)");
		this.jlabelheader.setBounds(50, 30, 300, 20);

		this.jlabelFirstName = new JLabel("First Name");
		this.jlabelFirstName.setBounds(30, 20, 100, 20);
		this.jlabelMiddleName = new JLabel("Middle Name");
		this.jlabelMiddleName.setBounds(30, 50, 100, 20);
		this.jlabelLastName = new JLabel("Last Name");
		this.jlabelLastName.setBounds(30, 80, 100, 20);
		this.jlabelStreet = new JLabel("Street");
		this.jlabelStreet.setBounds(30, 110, 100, 20);
		this.jlabelCity = new JLabel("City");
		this.jlabelCity.setBounds(30, 140, 100, 20);
		this.jlabelState = new JLabel("State");
		this.jlabelState.setBounds(30, 170, 100, 20);
		this.jlabelZIP = new JLabel("ZIP");
		this.jlabelZIP.setBounds(30, 200, 100, 20);
		this.jlabelbd = new JLabel("Birthday");
		this.jlabelbd.setBounds(30, 230, 100, 20);
		this.jlphoneno = new JLabel("Phone Number");
		this.jlphoneno.setBounds(30, 260, 100, 20);

		this.tfName = new JTextField();
		this.tfName.setBounds(150, 20, 200, 20);
		this.tfMiddleName = new JTextField();
		this.tfMiddleName.setBounds(150, 50, 200, 20);
		this.tfLastName = new JTextField();
		this.tfLastName.setBounds(150, 80, 200, 20);
		this.tfStreet = new JTextField();
		this.tfStreet.setBounds(150, 110, 200, 20);
		this.tfCity = new JTextField();
		this.tfCity.setBounds(150, 140, 200, 20);
		this.tfState = new JTextField();
		this.tfState.setBounds(150, 170, 200, 20);
		this.tfZIP = new JTextField();
		this.tfZIP.setBounds(150, 200, 200, 20);
		this.tfbd = new JTextField();
		this.tfbd.setBounds(150, 230, 200, 20);
		this.tfphoneno = new JTextField();
		this.tfphoneno.setBounds(150, 260, 200, 20);

		this.bAddOnemore = new JButton("ADD More");
		this.bAddOnemore.setBounds(20, 270, 100, 20);
		this.bRemove = new JButton("Remove");
		this.bRemove.setBounds(145, 270, 100, 20);
		this.bEdit = new JButton("Edit");
		this.bEdit.setBounds(260, 270, 100, 20);
		this.bLoadAll = new JButton("Load File");
		this.bLoadAll.setBounds(30, 300, 150, 20);
		this.bSaveToFile = new JButton("Save To File");
		this.bSaveToFile.setBounds(200, 300, 150, 20);

		this.bSaveContact = new JButton("Save");
		this.bSaveContact.setBounds(150, 290, 90, 20);
		this.bUpdateContact = new JButton("Update");
		this.bUpdateContact.setBounds(150, 290, 90, 20);
		this.bCancel = new JButton("Cancel");
		this.bCancel.setBounds(260, 290, 90, 20);

		this.tableListOfContacts = new JTable();
		this.scrollBar = new JScrollPane(this.tableListOfContacts);
		this.scrollBar.setBounds(20, 60, 350, 200);

		this.frameListAll.add(this.bAddOnemore);
		this.frameListAll.add(this.bRemove);
		this.frameListAll.add(this.bEdit);
		this.frameListAll.add(this.bLoadAll);
		this.frameListAll.add(this.bSaveToFile);
		this.frameListAll.add(this.jlabelheader);
		this.frameListAll.add(this.scrollBar);

		this.frameEditAdd.add(this.tfName);
		this.frameEditAdd.add(this.tfMiddleName);
		this.frameEditAdd.add(this.tfLastName);
		this.frameEditAdd.add(this.tfStreet);
		this.frameEditAdd.add(this.tfCity);
		this.frameEditAdd.add(this.tfState);
		this.frameEditAdd.add(this.tfZIP);
		this.frameEditAdd.add(this.tfbd);
		this.frameEditAdd.add(this.tfphoneno);

		this.frameEditAdd.add(this.jlabelFirstName);
		this.frameEditAdd.add(this.jlabelMiddleName);
		this.frameEditAdd.add(this.jlabelLastName);
		this.frameEditAdd.add(this.jlabelStreet);
		this.frameEditAdd.add(this.jlabelCity);
		this.frameEditAdd.add(this.jlabelState);
		this.frameEditAdd.add(this.jlabelZIP);
		this.frameEditAdd.add(this.jlabelbd);
		this.frameEditAdd.add(this.jlphoneno);

		this.frameEditAdd.add(this.bSaveContact);
		this.frameEditAdd.add(this.bUpdateContact);
		this.frameEditAdd.add(this.bCancel);

		this.bAddOnemore.addActionListener(this);
		this.bRemove.addActionListener(this);
		this.bLoadAll.addActionListener(this);
		this.bSaveToFile.addActionListener(this);
		this.bEdit.addActionListener(this);

		this.bSaveContact.addActionListener(this);
		this.bUpdateContact.addActionListener(this);
		this.bCancel.addActionListener(this);

		this.frameEditAdd.setSize(400, 400);
		this.frameListAll.setSize(400, 400);
		this.frameListAll.setVisible(true);

		this.model = new DefaultTableModel();
		this.model.addColumn("First Name");
		this.model.addColumn("Middle Name");
		this.model.addColumn("Last Name");
		this.tableListOfContacts.setModel(this.model);
		this.tableListOfContacts.setAutoCreateRowSorter(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == this.bAddOnemore) {
			this.frameEditAdd.setVisible(true);
			this.frameListAll.setVisible(false);
			this.bUpdateContact.setVisible(false);
			this.bSaveContact.setVisible(true);
		}

		if (ae.getSource() == this.bRemove) {

			if (this.tableListOfContacts.getSelectedRow() != -1) {
				this.details.remove(this.tableListOfContacts.getSelectedRow());
				this.model.removeRow(this.tableListOfContacts.getSelectedRow());
			} else {
				JOptionPane.showMessageDialog(this.frameMessageBox,
						"Choose a row", "Warning!!!",
						JOptionPane.WARNING_MESSAGE);

			}
		}
		if (ae.getSource() == this.bEdit) {
			int selectedRow = this.tableListOfContacts.getSelectedRow();
			if (selectedRow != -1) {
				
				Contact contact = new Contact();
				contact.setFirstName((String)this.tableListOfContacts.getValueAt(selectedRow, 0));
				contact.setMidName((String)this.tableListOfContacts.getValueAt(selectedRow, 1));
				contact.setLastName((String)this.tableListOfContacts.getValueAt(selectedRow, 2));

				this.tfName.setText(this.details.get(this.details.indexOf(contact)).getFirstName());
				this.tfMiddleName.setText(this.details.get(this.details.indexOf(contact)).getMidName());
				this.tfLastName.setText(this.details.get(this.details.indexOf(contact)).getLastName());
				this.tfStreet.setText(this.details.get(this.details.indexOf(contact)).getStreet());
				this.tfCity.setText(this.details.get(this.details.indexOf(contact)).getCity());
				this.tfState.setText(this.details.get(this.details.indexOf(contact)).getState());
				this.tfZIP.setText(this.details.get(this.details.indexOf(contact)).getZIP());
				this.tfbd.setText(this.details.get(this.details.indexOf(contact)).getBirthDay());
				this.tfphoneno.setText(this.details.get(this.details.indexOf(contact)).getPhoneNumber());
				
				this.frameListAll.setVisible(false);
				this.frameEditAdd.setVisible(true);
				this.bSaveContact.setVisible(false);
				this.bUpdateContact.setVisible(true);

			} else {
				JOptionPane.showMessageDialog(this.frameMessageBox,
						"Choose a row", "Warning!!!",
						JOptionPane.WARNING_MESSAGE);

			}
		}

		if (ae.getSource() == this.bLoadAll) {
			try {
				loadContacts();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		if (ae.getSource() == this.bSaveToFile) {

			FileOutputStream outFileStream = null;
			try {
				outFileStream = new FileOutputStream(this.fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			PrintWriter outStream = new PrintWriter(outFileStream);
			for (Contact detail : this.details) {
				outStream.println(detail.getAllDetails());

			}
			outStream.close();
		}

		if (ae.getSource() == this.bSaveContact) {
			this.frameEditAdd.setVisible(true);
			Contact contactNew = new Contact();
			contactNew.setFirstName((String)this.tfName.getText());
			contactNew.setMidName((String)this.tfMiddleName.getText());
			contactNew.setLastName((String)this.tfLastName.getText());
			contactNew.setStreet((String)this.tfStreet.getText());
			contactNew.setCity((String)this.tfCity.getText());
			contactNew.setState((String)this.tfState.getText());
			contactNew.setZIP((String)this.tfZIP.getText());
			contactNew.setBirthDay((String)this.tfbd.getText());
			contactNew.setPhoneNumber((String)this.tfphoneno.getText());
			
			this.details.add(contactNew);
			this.model.addRow(new Object[] { contactNew.getFirstName(), contactNew.getMidName(), contactNew.getLastName()});

			setDefaultValues();
			this.frameListAll.setVisible(true);
			this.frameEditAdd.setVisible(false);
		}

		if (ae.getSource() == this.bUpdateContact) {

			this.frameEditAdd.setVisible(true);
			int selectedRow = this.tableListOfContacts.getSelectedRow();
			Contact contact = new Contact();
			contact.setFirstName((String)this.tableListOfContacts.getValueAt(selectedRow, 0));
			contact.setMidName((String)this.tableListOfContacts.getValueAt(selectedRow, 1));
			contact.setLastName((String)this.tableListOfContacts.getValueAt(selectedRow, 2));

			this.details.remove(this.details.indexOf(contact));
			
			Contact contactNew = new Contact();
			contactNew.setFirstName((String)this.tfName.getText());
			contactNew.setMidName((String)this.tfMiddleName.getText());
			contactNew.setLastName((String)this.tfLastName.getText());
			contactNew.setStreet((String)this.tfStreet.getText());
			contactNew.setCity((String)this.tfCity.getText());
			contactNew.setState((String)this.tfState.getText());
			contactNew.setZIP((String)this.tfZIP.getText());
			contactNew.setBirthDay((String)this.tfbd.getText());
			contactNew.setPhoneNumber((String)this.tfphoneno.getText());
			
			this.details.add(contactNew);
			this.model.removeRow(this.tableListOfContacts.convertRowIndexToModel(selectedRow));
			this.model.addRow(new Object[] { contactNew.getFirstName(), contactNew.getMidName(), contactNew.getLastName()});

			setDefaultValues();

			this.frameListAll.setVisible(true);
			this.frameEditAdd.setVisible(false);
		}

		if (ae.getSource() == this.bCancel) {
			this.frameListAll.setVisible(true);
			this.frameEditAdd.setVisible(false);
			setDefaultValues();
		}
	}

	public void loadContacts() throws FileNotFoundException {
		Scanner fileInput = new Scanner(this.fileName);
		while (fileInput.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(fileInput.nextLine(), "|");
			Contact contact = new Contact();
			contact.setFirstName(st.nextToken());
			contact.setMidName(st.nextToken());
			contact.setLastName(st.nextToken());
			contact.setStreet(st.nextToken());
			contact.setCity(st.nextToken());
			contact.setState(st.nextToken());
			contact.setZIP(st.nextToken());
			contact.setBirthDay(st.nextToken());
			contact.setPhoneNumber(st.nextToken());

			this.details.add(contact);
			this.model.addRow(new Object[] { contact.getFirstName(),  contact.getMidName(), contact.getLastName() });
		}
	}
	public void refreshTable(){
		//Contact contactS = new Contact();
		for ( Contact contactS : this.details){
			this.model.addRow(new Object[] { contactS.getFirstName(),  contactS.getMidName(), contactS.getLastName() });
		}
	}
	public void setDefaultValues() {
		this.tfName.setText("");
		this.tfMiddleName.setText("");
		this.tfLastName.setText("");
		this.tfStreet.setText("");
		this.tfCity.setText("");
		this.tfState.setText("");
		this.tfZIP.setText("");
		this.tfbd.setText("");
		this.tfphoneno.setText("");
	}

}
