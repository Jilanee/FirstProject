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
import javax.swing.table.DefaultTableModel;

import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;
import com.toedter.calendar.JDateChooser;

public class SalseReturn extends JPanel{
	
	JPanel panelNorth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelSouth=new JPanel();

	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JPanel panelCenterNorthWest=new JPanel();
	JPanel panelCenterNorthCenter=new JPanel();
	
	JPanel panelCenterNorthWestUpper=new JPanel();
	JPanel panelCenterNorthwestLower=new JPanel();
	
	JPanel panelCenterNorthCenterUpper=new JPanel();
	JPanel panelCenterNorthCenterLower=new JPanel();

	JTextField txttotalstock=new JTextField(15);
	JTextField txtsalseqty=new JTextField(15);
	JTextField txtreceiveqty=new JTextField(15);

	JTextField txttotalamount=new JTextField(15);
	JTextField txtsalsereturn=new JTextField(15);
	JTextField txtusername=new JTextField(15);
	
	JDateChooser dcDate=new JDateChooser();
	JDateChooser dcReturnDate=new JDateChooser();
	
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Subcatagory");
	JLabel lblproductid=new JLabel("Product ID");
	JLabel lbltotalstock=new JLabel("Total Stock");
	JLabel lblsalseqty=new JLabel("Salse Quantity");
	JLabel lblreceiveqty=new JLabel("Receive Quantity");
	JLabel lblremarks=new JLabel("Remarks");

	SuggestText stcatagory=new SuggestText();
	SuggestText stsubcatagory=new SuggestText();
	SuggestText stProductid=new SuggestText();
	JTextArea  txtArea=new JTextArea(3,4);
    JScrollPane scrollRemarks=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
	public SalseReturn(){
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
			stProductid.vector.clear();
			stProductid.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stProductid.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
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
		add(panelNorth,BorderLayout.NORTH);
		PanelNorthWork();
		add(panelCenter,BorderLayout.CENTER);
		PanelCenterWork();
		add(panelSouth,BorderLayout.SOUTH);
		PanelSouthWork();
	}

	private void PanelSouthWork() {
		 panelSouth.setPreferredSize(new Dimension(1150,40));
	    // panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
	        
	}

	private void PanelCenterWork() {
		 panelCenter.setPreferredSize(new Dimension(1150,620));
		 panelCenter.setBorder(BorderFactory.createTitledBorder(""));
	     panelCenter.setLayout(new BorderLayout());
		 panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
	     PanelCenterNorthWork();
		 panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		 PanelCenterCenterWork();
		 panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		 PanelCenterSouthWork();
	}

	private void PanelCenterSouthWork() {
		panelCenterSouth.setPreferredSize(new Dimension(1150,60));	
		//panelcentersouth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		JButton btnconfirm=new JButton("Confirm");
		JButton btndone=new JButton("Done");
		JLabel lbltotalamount=new JLabel("Total Amount");
		
		 GridBagConstraints c=new GridBagConstraints();
		 panelCenterSouth.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.insets=new Insets(2,2,2,2);
		 c.gridx=0;
		 c.gridy=0;
		 panelCenterSouth.add(btnconfirm, c);
		 btnconfirm.setFont(new Font("Sherif",Font.BOLD,14));
		 c.insets=new Insets(0,0,0,50);
		 c.gridx=1;
		 c.gridy=0;
		 panelCenterSouth.add(btndone, c);
		 btndone.setFont(new Font("Sherif",Font.BOLD,14));
		 c.insets=new Insets(0,0,0,50);
		 c.gridx=2;
		 c.gridy=0;
		 panelCenterSouth.add(lbltotalamount, c);
		 lbltotalamount.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=3;
		 c.gridy=0;
		 panelCenterSouth.add(txttotalamount, c);
	}

	private void PanelCenterCenterWork() {
		panelCenterCenter.setPreferredSize(new Dimension(1150,210));	
		panelCenterCenter.setBorder(BorderFactory.createTitledBorder(""));
		
		Object row[][]={};
		String col []={"Return No","Product Name","Supplier Name","Total Stock","Return Qty","Remarks","Find",};
		DefaultTableModel model=new DefaultTableModel(row,col);
		JTable table=new JTable(model);
		JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		FlowLayout flow=new FlowLayout();
		panelCenterCenter.setLayout(flow);
		flow.setVgap(0);
		panelCenterCenter.add(scroll);
		scroll.setPreferredSize(new Dimension(1100,150));		
	}

	private void PanelCenterNorthWork() {
		panelCenterNorth.setPreferredSize(new Dimension(1150,350));	
		panelCenterNorth.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorth.setLayout(new BorderLayout());
		panelCenterNorth.add(panelCenterNorthWest,BorderLayout.WEST);
		PanelCenterNorthWestWork();
		panelCenterNorth.add(panelCenterNorthCenter,BorderLayout.CENTER);
		PanelCenterNorthCenterWork();
	}

	private void PanelCenterNorthCenterWork() {
		panelCenterNorthCenter.setPreferredSize(new Dimension(560,340));
		panelCenterNorthCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorthCenter.setLayout(new BorderLayout());
		panelCenterNorthCenter.add(panelCenterNorthCenterUpper,BorderLayout.NORTH);
		PanelCenterNorthCenterUpperWork();
		panelCenterNorthCenter.add(panelCenterNorthCenterLower,BorderLayout.SOUTH);
		PanelCenterNorthCenterLowerWork();
	}

	private void PanelCenterNorthCenterLowerWork() {
		panelCenterNorthCenterLower.setPreferredSize(new Dimension(560,250));
		
		Object row[][]={};
		String col[]={"Return No","Product Name","Supplier Name","Total Stock","Remarks","Find",};
		DefaultTableModel model=new DefaultTableModel(row,col);
		JTable table=new JTable(model);
		JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		FlowLayout flow=new FlowLayout();
		panelCenterNorthCenterLower.setLayout(flow);
		flow.setVgap(40);
		panelCenterNorthCenterLower.add(scroll);
		scroll.setPreferredSize(new Dimension(500,200));
	}

	private void PanelCenterNorthCenterUpperWork() {
		panelCenterNorthCenterUpper.setPreferredSize(new Dimension(560,90));
		
		JButton btnfind=new JButton("Find");
		JLabel lblfromdate=new JLabel("From Date");
		JLabel lbltodate=new JLabel("To Date");

		JDateChooser dcfromdate=new JDateChooser();
		JDateChooser dctodate=new JDateChooser();
		 
        GridBagConstraints c=new GridBagConstraints();
        panelCenterNorthCenterUpper.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.insets=new Insets(2,2,2,2);
	     c.gridx=0;
	     c.gridy=0;
	     panelCenterNorthCenterUpper.add(lblfromdate,c);
	     lblfromdate.setFont(new Font("Sherif",Font.BOLD,14));
	     c.gridx=1;
	     c.gridy=0;
	     panelCenterNorthCenterUpper.add(dcfromdate,c);
	     dcfromdate.setPreferredSize(new Dimension(150,30));
	     c.gridx=2;
	     c.gridy=0;
	     panelCenterNorthCenterUpper.add(lbltodate,c);
	     lbltodate.setFont(new Font("Sherif",Font.BOLD,14));
	     c.gridx=3;
	     c.gridy=0;
	     panelCenterNorthCenterUpper.add(dctodate,c);
	     dctodate.setPreferredSize(new Dimension(150,30));
	     c.gridx=4;
	     c.gridy=0;
	     panelCenterNorthCenterUpper.add(btnfind,c);
	     btnfind.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void PanelCenterNorthWestWork() {
		panelCenterNorthWest.setPreferredSize(new Dimension(560,340));
		panelCenterNorthWest.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorthWest.setLayout(new BorderLayout());
		panelCenterNorthWest.add(panelCenterNorthWestUpper,BorderLayout.NORTH);
		PanelCenterNorthWestUpperWork();
		panelCenterNorthWest.add(panelCenterNorthwestLower,BorderLayout.SOUTH);
		PanelCenterNorthWestLowerWork();
	}

	private void PanelCenterNorthWestUpperWork() {
		panelCenterNorthWestUpper.setPreferredSize(new Dimension(560,260));
		
        GridBagConstraints c=new GridBagConstraints();
        panelCenterNorthWestUpper.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.insets=new Insets(2,2,2,2);
		 c.gridx=0;
		 c.gridy=0;
		 panelCenterNorthWestUpper.add(lblcatagory, c);
		 lblcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=0;
		 panelCenterNorthWestUpper.add(stcatagory.cmbSuggest, c);
		 c.gridx=0;
		 c.gridy=1;
		 panelCenterNorthWestUpper.add(lblsubcatagory, c);
		 lblsubcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=1;
		 panelCenterNorthWestUpper.add(stsubcatagory.cmbSuggest, c);
		 c.gridx=0;
		 c.gridy=2;
		 panelCenterNorthWestUpper.add(lblproductid, c);
		 lblproductid.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=2;
		 panelCenterNorthWestUpper.add(stProductid.cmbSuggest, c);
		 c.gridx=0;
		 c.gridy=3;
		 panelCenterNorthWestUpper.add(lbltotalstock, c);
		 lbltotalstock.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=3;
		 panelCenterNorthWestUpper.add(txttotalstock, c);
		 c.gridx=0;
		 c.gridy=4;
		 panelCenterNorthWestUpper.add(lblsalseqty, c);
		 lblsalseqty.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=4;
		 panelCenterNorthWestUpper.add(txtsalseqty, c);
		 c.gridx=0;
		 c.gridy=5;
		 panelCenterNorthWestUpper.add(lblreceiveqty, c);
		 lblreceiveqty.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=5;
		 panelCenterNorthWestUpper.add(txtreceiveqty, c);
		 c.gridx=0;
		 c.gridy=6;
		 panelCenterNorthWestUpper.add(lblremarks, c);
		 lblremarks.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
		 c.gridy=6;
		 panelCenterNorthWestUpper.add(scrollRemarks, c);
		 txtArea.setLineWrap(true);
	}

	private void PanelCenterNorthWestLowerWork() {
		panelCenterNorthwestLower.setPreferredSize(new Dimension(560,80));		
		JButton btnsubmit=new JButton("Submit");
		JButton btnedit=new JButton("Edit");
		JButton btnremarks=new JButton("Refresh");
		JButton btndelete=new JButton("Delete");
        FlowLayout flow=new FlowLayout();
        panelCenterNorthwestLower.setLayout(flow);
        
        flow.setVgap(40);
        flow.setHgap(30);
        
        panelCenterNorthwestLower.add(btnsubmit);
        btnsubmit.setFont(new Font("Sherif",Font.BOLD,14));
        btnsubmit.setPreferredSize(new Dimension(90,40));
		
        panelCenterNorthwestLower.add(btnedit);
        btnedit.setFont(new Font("Sherif",Font.BOLD,14));
        btnedit.setPreferredSize(new Dimension(70,40));

        panelCenterNorthwestLower.add(btnremarks);
        btnremarks.setFont(new Font("Sherif",Font.BOLD,14));
        btnremarks.setPreferredSize(new Dimension(90,40));

        panelCenterNorthwestLower.add(btndelete);
        btndelete.setFont(new Font("Sherif",Font.BOLD,14));
        btndelete.setPreferredSize(new Dimension(90,40));
	}

	private void PanelNorthWork() {
		panelNorth.setPreferredSize(new Dimension(1150,80));
		panelNorth.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel lblsalsereturn=new JLabel("Salse Return No");
		JLabel lblusername=new JLabel("User Name");
		JLabel lbldate=new JLabel("Date");
		JLabel lblreturndate=new JLabel("Return Date");

		GridBagConstraints c=new GridBagConstraints();
		panelNorth.setLayout(new GridBagLayout());
	    c.fill=GridBagConstraints.BOTH;
	    c.insets=new Insets(2,2,2,2);                    //TLBR
	    c.gridx=0;
	    c.gridy=0;
	    panelNorth.add(lblsalsereturn,c);
	    c.insets=new Insets(2,10,2,2);
	    lblsalsereturn.setFont(new Font("Sherif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=0;
	    panelNorth.add(txtsalsereturn,c);
	    c.insets=new Insets(2,10,2,2);
	    c.gridx=2;
	    c.gridy=0;
	    panelNorth.add(lblusername,c);
	    c.insets=new Insets(2,10,2,2);
	    lblusername.setFont(new Font("Sherif",Font.BOLD,14));
	    c.gridx=3;
	    c.gridy=0;
	    panelNorth.add(txtusername,c);
	    c.insets=new Insets(2,10,2,2);
	    c.gridx=4;
	    c.gridy=0;
	    panelNorth.add(lbldate,c);
	    c.insets=new Insets(2,10,2,2);
	    lbldate.setFont(new Font("Sherif",Font.BOLD,14));
	    c.gridx=5;
	    c.gridy=0;
	    panelNorth.add(dcDate,c);
	    c.insets=new Insets(2,10,2,2);
	    dcDate.setPreferredSize(new Dimension(150,30));
	    c.gridx=6;
	    c.gridy=0;
	    panelNorth.add(lblreturndate,c);
	    c.insets=new Insets(2,10,2,2);
	    lblreturndate.setFont(new Font("Sherif",Font.BOLD,14));
	    c.gridx=7;
	    c.gridy=0;
	    panelNorth.add(dcReturnDate,c);
	    c.insets=new Insets(2,10,2,2);
	    dcReturnDate.setPreferredSize(new Dimension(150,30));	
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	}

}
