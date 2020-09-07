package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class ItemReceipt extends JPanel{
	
	JPanel panelnorth=new JPanel();
	JPanel panelcenter=new JPanel();
	JPanel panelsouth=new JPanel();
	
	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JPanel panelCenterNorthWest=new JPanel();
	JPanel panelCenterNorthCenter=new JPanel();
	
	JPanel panelCenterNorthWestLower=new JPanel();
	JPanel panelCenterNorthWestUpper=new JPanel();
	
	JPanel panelCenterNorthWestUpperWest=new JPanel();
	JPanel panelCenterNorthWestUpperCenter=new JPanel();

	JPanel panelCenterNorthCenterUpper=new JPanel();
	JPanel panelCenterNorthCenterLower=new JPanel();

	JTextField txttotalamount=new JTextField(20);
    
    //JTextArea txtArea=new JTextArea(2,4);
   // JScrollPane areaScoll=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    //		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
     JButton btnconfirm=new JButton("Confirm");
	 JButton btndone=new JButton("Done");
	 JLabel lbltotalamount=new JLabel("Total Amount");
	
	 JLabel lblFromDate=new JLabel("From Date");
	 JLabel lblToDate=new JLabel("To Date");
	 JButton btnFind=new JButton("Find");
		
	JDateChooser dcFromDate=new JDateChooser();		
	JDateChooser dcToDate=new JDateChooser();
		
	JDateChooser dCurdate=new JDateChooser();
	JDateChooser dCurinvoicedate=new JDateChooser();
	
	SuggestText stSupplierName=new SuggestText();

	JLabel lblmvoiceqtye=new JLabel("Mvoice Quantity");
	JLabel lblreceiveqty=new JLabel("Receive Quantity");
	JLabel lblshortoroverqty=new JLabel("Over/Short Quantity");
	JLabel lblpresentstock=new JLabel("Present Stock");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblremarks=new JLabel("Remarks");
	
	JTextField txtmvoiceqty=new JTextField(10);
	JTextField txtreceiveqty=new JTextField(10);
	JTextField txtshortoroverqty=new JTextField(10);
	JTextField txtpresentstock=new JTextField(10);

    JTextArea txtAreaRemarks=new JTextArea(3,3);
    JScrollPane scroll=new JScrollPane(txtAreaRemarks,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    Object row[][]={};
	String col[]={"PID","Product Name","Unit","Stock Unit","Rate","Invoice Qty",
			"Receive Qty","Short/Over Qty","Prisent Stock","Supplier Name","Remarks","Find"};
	
	DefaultTableModel modelCenterSouth=new DefaultTableModel(row,col);
	JTable tableCenterSouth=new JTable(modelCenterSouth);
	JScrollPane scrollCenterSouth=new JScrollPane(tableCenterSouth,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

	String colinvoice[]={"Invoice No","Total Amount","Date"};
	Object rowinvoice[][]={};
	DefaultTableModel modelinvoice=new DefaultTableModel(rowinvoice,colinvoice);
	JTable tableinvoice=new JTable(modelinvoice);
	JScrollPane scrollinvoice=new JScrollPane(tableinvoice,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	SuggestText stcatagory=new SuggestText();
	SuggestText stsubcatagory=new SuggestText();
	SuggestText stproductid=new SuggestText();
	
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Sub Catagory");
	JLabel lblproductid=new JLabel("Product ID");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstock=new JLabel("Stock");
	JLabel lblrate=new JLabel("Rate");

	JTextField txtunit=new JTextField(10);
	JTextField txtstock=new JTextField(10);
	JTextField txtrate=new JTextField(10);
	
	JLabel lblinvoiceno=new JLabel("Invoice No");
    JLabel lblusername=new JLabel("User Name");
	JLabel lbldate=new JLabel("Date");
	JLabel lblinvoicedate=new JLabel("Invoice Date");

	JTextField txtinvoiceno=new JTextField(15);
	JTextField txtusername=new JTextField(15);
	JTextField txtdate=new JTextField(15);
	JTextField txtinvoicedate=new JTextField(15);

	JButton btnsubmit=new JButton("Submit");
	JButton btnedit=new JButton("Edit");
	JButton btnrefresh=new JButton("Refresh");
	JButton btndelete=new JButton("Delete");
	
	public ItemReceipt(){
		init();
		cmp();
		btnAction();
	}
    
	public void CatagoryDataLoad(){
		try{
			String sql="select catid,catagoryName from tbcatagoryinfo";
			stcatagory.vector.removeAllElements();
			stcatagory.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stcatagory.vector.add(rs.getString("catid")+" # "+rs.getString("catagoryName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	public void SubCatagoryDataLoad(){
		try{
			String sql="select subcatagoryid,subcatagoryName from tbsubcatagoryinfo";
			stsubcatagory.vector.clear();
			stsubcatagory.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stsubcatagory.vector.add(rs.getString("subcatagoryid")+" # "+rs.getString("subcatagoryName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	
	public void ProductIDDataLoad(){
		try{
			String sql="select ProductID,ProductName from tbproductinfo";
			stproductid.vector.clear();
			stproductid.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stproductid.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	
	public void SupplierDataLoad(){
		try{
			String sql="select SupplierID,SupplierName from tbsupplierinfo";
			stSupplierName.vector.clear();
			stSupplierName.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stSupplierName.vector.add(rs.getString("SupplierID")+" # "+rs.getString("SupplierName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	private void btnAction() {
		
	}
    
	private void cmp() {
			add(panelnorth,BorderLayout.NORTH);
			PanelNorthWork();
			add(panelcenter,BorderLayout.CENTER);
			PanelCenterWork();
			add(panelsouth,BorderLayout.SOUTH);
			PanelSouthWork();
	}

	private void PanelSouthWork() {
		 panelsouth.setPreferredSize(new Dimension(1150,40));
		 panelsouth.setBorder(BorderFactory.createTitledBorder(""));
	      
		 GridBagConstraints c=new GridBagConstraints();
         panelsouth.setLayout(new GridBagLayout());
         c.fill=GridBagConstraints.BOTH;
 		 c.insets=new Insets(2,2,2,2);
 		 c.gridx=0;
 		 c.gridy=0;
 		 panelsouth.add(btnconfirm,c);
 		 btnconfirm.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,14));

 		 c.insets=new Insets(2,30,2,2);
 		 c.gridx=1;
 		 c.gridy=0;
 		 panelsouth.add(btndone,c);
 		 btndone.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,14));
 		 c.insets=new Insets(2,30,2,2);

 		 c.gridx=2;
 		 c.gridy=0;
 		 panelsouth.add(lbltotalamount,c);
 	     lbltotalamount.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,14));
 		 c.insets=new Insets(2,30,2,2);

 		 c.gridx=3;
 		 c.gridy=0;
 		 panelsouth.add(txttotalamount,c);
 		 c.insets=new Insets(2,30,2,2);
	}

	private void PanelCenterWork() {
		 panelcenter.setPreferredSize(new Dimension(1150,620));
		 panelcenter.setBorder(BorderFactory.createTitledBorder(""));
		 panelcenter.setLayout(new BorderLayout());
		 panelcenter.add(panelCenterNorth,BorderLayout.NORTH);
		 PanelCenterNorthWork();
		 panelcenter.add(panelCenterSouth,BorderLayout.SOUTH);
		 PanelCenterSouthWork();		
	}

	private void PanelCenterSouthWork() {
		panelCenterSouth.setPreferredSize(new Dimension(1150,270));
		//panelcentersouth.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelCenterSouth.setLayout(flow);
		flow.setVgap(70);
		panelCenterSouth.add(scrollCenterSouth);
		scrollCenterSouth.setPreferredSize(new Dimension(1100,200));
	}

	private void PanelCenterNorthWork() {
		panelCenterNorth.setPreferredSize(new Dimension(1150,350));
		//panelcenternorth.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorth.setLayout(new BorderLayout());
		panelCenterNorth.add(panelCenterNorthWest,BorderLayout.WEST);
		PanelCenterNorthWestWork();
		panelCenterNorth.add(panelCenterNorthCenter,BorderLayout.CENTER);
		PanelCenterNorthCenterWork();
	}

	private void PanelCenterNorthCenterWork() {
		panelCenterNorthCenter.setPreferredSize(new Dimension(575,300));
	//	panelCenterNorthCenter.setBorder(BorderFactory.createTitledBorder(""));
		TitledBorder Title=BorderFactory.createTitledBorder(" Existing Invoice ");
        Title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
        Title.setTitleJustification(TitledBorder.CENTER);
        Title.setTitlePosition(TitledBorder.TOP);
        panelCenterNorthCenter.setBorder(Title);
        panelCenterNorthCenter.setLayout(new BorderLayout());
        panelCenterNorthCenter.add(panelCenterNorthCenterUpper,BorderLayout.NORTH);
        PanelCenterNorthCenterUpperWork();
        panelCenterNorthCenter.add(panelCenterNorthCenterLower,BorderLayout.SOUTH);
        PanelCenterNorthCenterLowerWork();
	}

	private void PanelCenterNorthCenterLowerWork() {
		panelCenterNorthCenterLower.setPreferredSize(new Dimension(575,200));
	//	panelCenterNorthCenterLower.setBorder(BorderFactory.createRaisedBevelBorder());
		
		panelCenterNorthCenterLower.setLayout(new FlowLayout());
		panelCenterNorthCenterLower.add(scrollinvoice);
		scrollinvoice.setPreferredSize(new Dimension(475,180));
	}

	private void PanelCenterNorthCenterUpperWork() {
		panelCenterNorthCenterUpper.setPreferredSize(new Dimension(575,100));
	//	panelCenterNorthCenterUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		
        GridBagConstraints c=new GridBagConstraints();
        panelCenterNorthCenterUpper.setLayout(new GridBagLayout());
        c.fill=GridBagConstraints.BOTH;
        c.insets=new Insets(2,2,2,2);
        c.gridx=0;
        c.gridy=0;
        panelCenterNorthCenterUpper.add(lblFromDate, c);
        lblFromDate.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
        c.gridx=1;
        c.gridy=0;
        panelCenterNorthCenterUpper.add(dcFromDate, c);
        dcFromDate.setPreferredSize(new Dimension(130,30));
        c.gridx=2;
        c.gridy=0;
        panelCenterNorthCenterUpper.add(lblToDate, c);
        lblToDate.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
        c.gridx=3;
        c.gridy=0;
        panelCenterNorthCenterUpper.add(dcToDate, c);
        dcToDate.setPreferredSize(new Dimension(130,30));
        c.gridx=4;
        c.gridy=0;
        panelCenterNorthCenterUpper.add(btnFind, c);
        btnFind.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
	}

	private void PanelCenterNorthWestWork() {
		panelCenterNorthWest.setPreferredSize(new Dimension(575,300));
		panelCenterNorthWest.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorthWest.setLayout(new BorderLayout());
		panelCenterNorthWest.add(panelCenterNorthWestLower,BorderLayout.SOUTH);
		PanelCenterNorthWestLowerWork();
		panelCenterNorthWest.add(panelCenterNorthWestUpper,BorderLayout.NORTH);
		PanelCenterNorthWestUpperWork();		
	}

	private void PanelCenterNorthWestUpperWork() {
		panelCenterNorthWestUpper.setPreferredSize(new Dimension(575,250));		
		panelCenterNorthWestUpper.setBorder(BorderFactory.createEmptyBorder());
		panelCenterNorthWestUpper.setLayout(new BorderLayout());
		panelCenterNorthWestUpper.add(panelCenterNorthWestUpperWest,BorderLayout.WEST);
		PanelCenterNorthWestUpperWestWork();
		panelCenterNorthWestUpper.add(panelCenterNorthWestUpperCenter,BorderLayout.CENTER);
		PanelCenterNorthWestUpperCenterWork();
	}

	private void PanelCenterNorthWestUpperCenterWork() {
		panelCenterNorthWestUpperCenter.setPreferredSize(new Dimension(285,250));
	//	panelCenterNorthWestUpperCenter.setBorder(BorderFactory.createRaisedBevelBorder());
	
		GridBagConstraints c=new GridBagConstraints();
		panelCenterNorthWestUpperCenter.setLayout(new GridBagLayout());
        c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelCenterNorthWestUpperCenter.add(lblmvoiceqtye, c);
		lblmvoiceqtye.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=0;
		panelCenterNorthWestUpperCenter.add(txtmvoiceqty, c);
		c.gridx=0;
		c.gridy=1;
		panelCenterNorthWestUpperCenter.add(lblreceiveqty, c);
		lblreceiveqty.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=1;
		panelCenterNorthWestUpperCenter.add(txtreceiveqty, c);
		c.gridx=0;
		c.gridy=2;
		panelCenterNorthWestUpperCenter.add(lblshortoroverqty, c);
		lblshortoroverqty.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=2;
		panelCenterNorthWestUpperCenter.add(txtshortoroverqty, c);
		c.gridx=0;
		c.gridy=3;
		panelCenterNorthWestUpperCenter.add(lblpresentstock, c);
		lblpresentstock.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=3;
		panelCenterNorthWestUpperCenter.add(txtpresentstock, c);
		c.gridx=0;
		c.gridy=4;
		panelCenterNorthWestUpperCenter.add(lblsuppliername, c);
		lblsuppliername.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=4;
		panelCenterNorthWestUpperCenter.add(stSupplierName.cmbSuggest, c);
		c.gridx=0;
		c.gridy=5;
		panelCenterNorthWestUpperCenter.add(lblremarks, c);
		lblremarks.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=5;
		panelCenterNorthWestUpperCenter.add(scroll, c);
		txtAreaRemarks.setLineWrap(true);	
	}

	private void PanelCenterNorthWestUpperWestWork() {
		panelCenterNorthWestUpperWest.setPreferredSize(new Dimension(285,250));
	//	panelCenterNorthWestUpperWest.setBorder(BorderFactory.createRaisedBevelBorder());
		
		GridBagConstraints c=new GridBagConstraints();
		panelCenterNorthWestUpperWest.setLayout(new GridBagLayout());
        c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);//TLBR
		c.gridx=0;
		c.gridy=0;
		panelCenterNorthWestUpperWest.add(lblcatagory,c);
		lblcatagory.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=0;
		panelCenterNorthWestUpperWest.add(stcatagory.cmbSuggest,c);
		c.gridx=0;
		c.gridy=1;
		panelCenterNorthWestUpperWest.add(lblsubcatagory,c);
		lblsubcatagory.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=1;
		panelCenterNorthWestUpperWest.add(stsubcatagory.cmbSuggest,c);
		c.gridx=0;
		c.gridy=2;
		panelCenterNorthWestUpperWest.add(lblproductid,c);
		lblproductid.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=2;
		panelCenterNorthWestUpperWest.add(stproductid.cmbSuggest,c);
		c.gridx=0;
		c.gridy=3;
		panelCenterNorthWestUpperWest.add(lblunit,c);
		lblunit.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=3;
		panelCenterNorthWestUpperWest.add(txtunit,c);
		c.gridx=0;
		c.gridy=4;
		panelCenterNorthWestUpperWest.add(lblstock,c);
		lblstock.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=4;
		panelCenterNorthWestUpperWest.add(txtstock,c);
		c.gridx=0;
		c.gridy=5;
		panelCenterNorthWestUpperWest.add(lblrate,c);
		lblrate.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		c.gridx=1;
		c.gridy=5;
		panelCenterNorthWestUpperWest.add(txtrate,c);	
	}

	private void PanelCenterNorthWestLowerWork() {
		panelCenterNorthWestLower.setPreferredSize(new Dimension(575,50));	
		//panelcenternorthwestlower.setBorder(BorderFactory.createRaisedBevelBorder());
		
	//	FlowLayout flow=new FlowLayout();
		panelCenterNorthWestLower.setLayout(new FlowLayout());
		panelCenterNorthWestLower.add(btnsubmit);
		btnsubmit.setPreferredSize(new Dimension(100,40));
		btnsubmit.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		
		panelCenterNorthWestLower.add(btnedit);
		btnedit.setPreferredSize(new Dimension(70,40));
		btnedit.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		
		panelCenterNorthWestLower.add(btnrefresh);
		btnrefresh.setPreferredSize(new Dimension(100,40));
		btnrefresh.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));

		panelCenterNorthWestLower.add(btndelete);
		btndelete.setPreferredSize(new Dimension(90,40));
		btndelete.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
	}

	private void PanelNorthWork() {
        panelnorth.setPreferredSize(new Dimension(1150,100));
        panelnorth.setBorder(BorderFactory.createTitledBorder(""));
      
		GridBagConstraints c=new GridBagConstraints();
		panelnorth.setLayout(new GridBagLayout());
	
        c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelnorth.add(lblinvoiceno,c);
		c.insets=new Insets(2,10,2,2);
		//lblinvoiceno.setPreferredSize(new Dimension(80,20));
		lblinvoiceno.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,16));
        c.gridx=1;
        c.gridy=0;
        panelnorth.add(txtinvoiceno,c);
		c.insets=new Insets(2,10,2,2);
        c.gridx=2;
        c.gridy=0;
        panelnorth.add(lblusername,c);
		c.insets=new Insets(2,10,2,2);
        lblusername.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,16));

        c.gridx=3;
        c.gridy=0;
        panelnorth.add(txtusername,c);
		c.insets=new Insets(2,10,2,2);
        c.gridx=4;
        c.gridy=0;
        panelnorth.add(lbldate,c);
		c.insets=new Insets(2,10,2,2);
        lbldate.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,16));

        c.gridx=5;
        c.gridy=0;
        panelnorth.add(dCurdate,c);
        dCurdate.setPreferredSize(new Dimension(150,20));
		c.insets=new Insets(2,10,2,2);
        dCurdate.setDateFormatString("dd-MM-yyyy");
        dCurdate.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,12));

        c.gridx=6;
        c.gridy=0;
        panelnorth.add(lblinvoicedate,c);
		c.insets=new Insets(2,10,2,2);
        lblinvoicedate.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,16));

        c.gridx=7;
        c.gridy=0;
        panelnorth.add(dCurinvoicedate,c);
		c.insets=new Insets(2,10,2,2);
		dCurinvoicedate.setPreferredSize(new Dimension(150,20));
        dCurinvoicedate.setDateFormatString("dd-MM-yyyy");
        dCurinvoicedate.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,12));
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
        setLayout(new BorderLayout());		
	}
}