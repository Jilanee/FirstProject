package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.StringTokenizer;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class Broken extends JPanel {
	
	JPanel panelNorth=new JPanel();
	JPanel panelSouth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelNorthNorth=new JPanel();
	JPanel panelNorthSouth=new JPanel();
	JPanel panelNorthSouthWest=new JPanel();
	JPanel panelNorthSouthEast=new JPanel();
	JPanel panelNorthSouthWestNorth=new JPanel();
	JPanel panelNorthSouthWestCenter=new JPanel();
	JPanel panelNorthSouthEastNorth=new JPanel();
	JPanel panelNorthSouthEastCenter=new JPanel();

	JLabel lbl_user=new JLabel("User Name");
	JLabel lbl_date=new JLabel("Date");
	JLabel lbl_invoiceDate=new JLabel("Invoice Date");
	JLabel lbl_invoiceid=new JLabel("Invoice No");

	JTextField txt_userid=new JTextField(15);
	JTextField txt_invoiceid=new JTextField(15);
	JDateChooser date=new JDateChooser();
	JDateChooser date_invoice=new JDateChooser();

	JLabel lbl_catagory=new JLabel("Catagory");
	JLabel lbl_subcatagory=new JLabel("Sub Catagory");
	JLabel lbl_productid=new JLabel("Product ID");
	JLabel lbl_suppliername=new JLabel("Supplier Name");
	JLabel lblUnit=new JLabel("Unit");
	JLabel lblStock=new JLabel("Stock");
	JLabel lblRate=new JLabel("Rate");
	JLabel lblInvQty=new JLabel("Invoice Quantity");
	JLabel lblReciveQty=new JLabel("Recive Quantity");
	JLabel lblShortOverQty=new JLabel("Short/Over Quantity");
	JLabel lblPresentStock=new JLabel("Present Stock");
	JLabel lblRemarks=new JLabel("Remarks");
	JLabel lblTotal=new JLabel("Total Amount");

	JTextField txtUnit=new JTextField(15);
	JTextField txtStock=new JTextField();
	JTextField txtRate=new JTextField();
	JTextField txtInvQty=new JTextField();
	JTextField txtReceiveQty=new JTextField();
	JTextField txtShortOver=new JTextField(15);
	JTextField txtPresentstock=new JTextField();
	JTextArea txtRemarks=new JTextArea(1,2);
	JTextField txtTotal=new JTextField(20);

	JScrollPane scrollRemarks=new JScrollPane(txtRemarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JButton btn_submit=new JButton("Submit",new ImageIcon("Images/btnSubmit.png"));
	JButton btn_edit=new JButton("Edit",new ImageIcon("Images/btnEdit.png"));
	JButton btn_refresh=new JButton("Refresh",new ImageIcon("Images/btnRefresh.png"));
	JButton btn_delete=new JButton("Delete",new ImageIcon("Images/btnDelete.png"));

	JLabel lblDateFrom=new JLabel("From Date");
	JLabel lblDateTo=new JLabel("To Date");
	JDateChooser dateFrom=new JDateChooser();
	JDateChooser dateTo=new JDateChooser();
	JButton btnFind=new JButton("Find",new ImageIcon("Images/btnFind.png"));
	JButton btn_confirm=new JButton("Confirm",new ImageIcon("Images/confirm.png"));
	JButton btn_done=new JButton("Done",new ImageIcon("Images/btnDone.png"));
	String catagory[]={};
	JComboBox cmbCategory=new JComboBox(catagory);

	String subcatagory[]={};
	JComboBox cmbSubCategory=new JComboBox(subcatagory);

	String productid[]={};
	JComboBox cmbProduct=new JComboBox(productid);

	String suppliername[]={};
	JComboBox cmbSupplierName=new JComboBox(suppliername);


	String column[]={"P ID","Product Name","Unit","Stock Qnt","Rate","Invoice Qty","Receive Qty","Short/Over Qny","Present Stock","Supplier Name","Remarks","Find"};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table_main=new JTable(model);
	JScrollPane scroll_main=new JScrollPane(table_main,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

	String columnSearchTable[]={"Invoice No","Total Amount","Date"};
	Object rowSearchTable[][]={};
	DefaultTableModel modelSearchTable=new DefaultTableModel(rowSearchTable,columnSearchTable);
	JTable tableSearch=new JTable(modelSearchTable);
	JScrollPane scrollSearch=new JScrollPane(tableSearch,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	GridBagConstraints c=new GridBagConstraints();

	int temp=0;
	public Broken() 
	{
		cmp();
	}

	private void cmp() {
		setLayout(new BorderLayout());
		add(panelNorth,BorderLayout.NORTH);
		panelNorthWork();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouthWork();
		add(panelCenter,BorderLayout.CENTER);
		panelCenterWork();
	}
	private void panelNorthWork() {
		panelNorth.setPreferredSize(new Dimension(1,350));
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(panelNorthNorth,BorderLayout.NORTH);
		panelNorthNorthWork();
		panelNorth.add(panelNorthSouth,BorderLayout.SOUTH);
		panelNorthSouthWork();
	}
	private void panelNorthNorthWork() {
		panelNorthNorth.setPreferredSize(new Dimension(1,70));
		panelNorthNorth.setLayout(new GridBagLayout());
		panelNorthNorth.setBorder(BorderFactory.createRaisedBevelBorder());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5,5,5,5);
		panelNorthNorth.add(lbl_invoiceid,c);
		c.gridx=1;
		c.gridy=0;
		//c.insets=new Insets(2,2,2,200);
		panelNorthNorth.add(txt_invoiceid,c);
		txt_invoiceid.setEditable(false);

		c.gridx=2;
		c.gridy=0;
		//c.insets=new Insets(2,2,2,2);
		panelNorthNorth.add(lbl_user,c);
		c.gridx=3;
		c.gridy=0;
		//c.insets=new Insets(2,2,2,200);
		panelNorthNorth.add(txt_userid,c);
		txt_userid.setEditable(false);

		c.gridx=4;
		c.gridy=0;
		c.insets=new Insets(5,55,5,5);
		panelNorthNorth.add(lbl_date,c);
		c.gridx=5;
		c.gridy=0;
		c.insets=new Insets(5,5,5,5);
		panelNorthNorth.add(date,c);
		date.setDateFormatString("dd-MMM-yyyy");
		date.setDate(new java.util.Date());

		c.gridx=6;
		c.gridy=0;
		//c.insets=new Insets(2,2,2,2);
		panelNorthNorth.add(lbl_invoiceDate,c);
		c.gridx=7;
		c.gridy=0;
		//c.insets=new Insets(2,2,2,2);
		panelNorthNorth.add(date_invoice,c);
		date_invoice.setDateFormatString("dd-MMM-yyyy");
		date_invoice.setDate(new java.util.Date());
	}
	private void panelNorthSouthWork() {
		panelNorthSouth.setPreferredSize(new Dimension(1,275));
		panelNorthSouth.setLayout(new BorderLayout());
		panelNorthSouth.add(panelNorthSouthWest,BorderLayout.WEST);
		panelNorthSouthWestWork();
		panelNorthSouth.add(panelNorthSouthEast,BorderLayout.EAST);
		panelNorthSouthEastWork();
	}
	private void panelNorthSouthWestWork() {
		panelNorthSouthWest.setPreferredSize(new Dimension(600,600));
		panelNorthSouthWest.setBorder(BorderFactory.createTitledBorder(""));
		panelNorthSouthWest.setLayout(new BorderLayout());
		panelNorthSouthWest.add(panelNorthSouthWestNorth,BorderLayout.NORTH);
		panelNorthSouthWestNorthWork();
		panelNorthSouthWest.add(panelNorthSouthWestCenter,BorderLayout.CENTER);
		panelNorthSouthWestCenterWork();
	}
	private void panelNorthSouthWestNorthWork() {
		panelNorthSouthWestNorth.setPreferredSize(new Dimension(220,220));
		panelNorthSouthWestNorth.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lbl_catagory,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lbl_subcatagory,c);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lbl_productid,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblUnit,c);

		c.gridx=0;
		c.gridy=4;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblStock,c);

		c.gridx=0;
		c.gridy=5;
		c.insets=new Insets(1,1,30,5);
		panelNorthSouthWestNorth.add(lblRate,c);

		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(1,1,1,25);
		panelNorthSouthWestNorth.add(cmbCategory,c);

		c.gridx=1;
		c.gridy=1;
		c.insets=new Insets(1,1,1,25);
		panelNorthSouthWestNorth.add(cmbSubCategory,c);

		c.gridx=1;
		c.gridy=2;
		c.insets=new Insets(1,1,1,25);
		panelNorthSouthWestNorth.add(cmbProduct,c);

		c.gridx=1;
		c.gridy=3;
		c.insets=new Insets(1,1,1,25);
		panelNorthSouthWestNorth.add(txtUnit,c);

		c.gridx=1;
		c.gridy=4;
		c.insets=new Insets(1,1,1,25);
		panelNorthSouthWestNorth.add(txtStock,c);

		c.gridx=1;
		c.gridy=5;
		c.insets=new Insets(1,1,30,25);
		panelNorthSouthWestNorth.add(txtRate,c);

		c.gridx=2;
		c.gridy=0;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblInvQty,c);

		c.gridx=2;
		c.gridy=1;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblReciveQty,c);

		c.gridx=2;
		c.gridy=2;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblShortOverQty,c);

		c.gridx=2;
		c.gridy=3;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblPresentStock,c);

		c.gridx=2;
		c.gridy=4;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lbl_suppliername,c);

		c.gridx=2;
		c.gridy=5;
		c.insets=new Insets(1,1,1,5);
		panelNorthSouthWestNorth.add(lblRemarks,c);

		c.gridx=3;
		c.gridy=0;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(txtInvQty,c);

		c.gridx=3;
		c.gridy=1;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(txtReceiveQty,c);

		c.gridx=3;
		c.gridy=2;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(txtShortOver,c);

		c.gridx=3;
		c.gridy=3;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(txtPresentstock,c);

		c.gridx=3;
		c.gridy=4;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(cmbSupplierName,c);

		c.gridx=3;
		c.gridy=5;
		c.insets=new Insets(1,1,1,1);
		panelNorthSouthWestNorth.add(scrollRemarks,c);
	}

	private void panelNorthSouthWestCenterWork() {
		panelNorthSouthWestCenter.setLayout(new GridBagLayout());

		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0,0,0,10);
		panelNorthSouthWestCenter.add(btn_submit,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0,0,0,10);
		panelNorthSouthWestCenter.add(btn_edit,c);

		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0,0,0,10);
		panelNorthSouthWestCenter.add(btn_refresh,c);

		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(0,0,0,10);
		panelNorthSouthWestCenter.add(btn_delete,c);

	}
	private void panelNorthSouthEastWork() {
		TitledBorder titel=new TitledBorder("Existing Invoice");
		titel.setTitleJustification(titel.CENTER);
		titel.setTitlePosition(titel.TOP);
		panelNorthSouthEast.setBorder(titel);
		
		panelNorthSouthEast.setPreferredSize(new Dimension(530,1));
		panelNorthSouthEast.setLayout(new BorderLayout());
		panelNorthSouthEast.add(panelNorthSouthEastNorth,BorderLayout.NORTH);
		panelNorthSouthEestNorthWork();
		panelNorthSouthEast.add(panelNorthSouthEastCenter,BorderLayout.CENTER);
		panelNorthSouthEastCenterWork();
	}
	private void panelNorthSouthEestNorthWork() {
		panelNorthSouthEastNorth.setPreferredSize(new Dimension(35,35));
		panelNorthSouthEastNorth.setLayout(new GridBagLayout());
		
		c.gridx=0;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		panelNorthSouthEastNorth.add(lblDateFrom,c);

		c.gridx=1;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,5);
		panelNorthSouthEastNorth.add(dateFrom,c);

		c.gridx=2;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		panelNorthSouthEastNorth.add(lblDateTo,c);

		c.gridx=3;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,5);
		panelNorthSouthEastNorth.add(dateTo,c);

		c.gridx=4;
		c.gridy=0;
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		panelNorthSouthEastNorth.add(btnFind,c);
	}
	private void panelNorthSouthEastCenterWork() {
		scrollSearch.setPreferredSize(new Dimension(500,200));
		panelNorthSouthEastCenter.add(scrollSearch);
	}
	private void panelSouthWork() {
		panelSouth.setPreferredSize(new Dimension(1,40));
		panelSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouth.setLayout(new GridBagLayout());
		c.gridx=0;
		c.gridy=0;
		c.insets=new Insets(1,1,1,1);
		c.fill=GridBagConstraints.BOTH;
		panelSouth.add(btn_confirm,c);
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(1,11,1,1);
		panelSouth.add(btn_done,c);
		c.gridx=2;
		c.gridy=0;
		c.insets=new Insets(1,277,1,1);
		panelSouth.add(lblTotal,c);
		c.gridx=3;
		c.gridy=0;
		c.insets=new Insets(1,11, 1, 1);
		panelSouth.add(txtTotal,c);
	}
	private void panelCenterWork() {
		FlowLayout flow=new FlowLayout();
		panelCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelCenter.add(scroll_main);

		scroll_main.setPreferredSize(new Dimension(1120,280));
		table_main.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table_main.getColumnModel().getColumn(0).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(1).setPreferredWidth(200);
		table_main.getColumnModel().getColumn(2).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(3).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(4).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(5).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(6).setPreferredWidth(80);
		table_main.getColumnModel().getColumn(7).setPreferredWidth(90);
		table_main.getColumnModel().getColumn(8).setPreferredWidth(90);
		table_main.getColumnModel().getColumn(9).setPreferredWidth(100);
		table_main.getColumnModel().getColumn(10).setPreferredWidth(200);
		table_main.getColumnModel().getColumn(11).setPreferredWidth(100);
	}
}
