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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class Salse extends JPanel{
	
	JPanel panelNorth=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelSouth=new JPanel();

	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JPanel panelCenterNorthWest=new JPanel();
	JPanel panelCenterNorthCenter=new JPanel();

	JPanel panelCenterNorthWestUpper=new JPanel();
	JPanel panelCenterNorthWestLower=new JPanel();
	
	JPanel panelCenterNorthCenterUpper=new JPanel();
	JPanel panelCenterNorthCenterLower=new JPanel();

	JTextField txtunit=new JTextField(15);
	JTextField txtstock=new JTextField(15);
	JTextField txtrate=new JTextField(15);
	JTextField txtsalseno=new JTextField(15);

	JTextField txtuUerName=new JTextField(15);
	JTextField txtSalseNo=new JTextField(15);

	JTextField txttotalamount=new JTextField(15);
	JTextField txtdue=new JTextField(15);

	JDateChooser chDate=new JDateChooser();
	
	JButton btnsubmit=new JButton("Submit");
	JButton btnedit=new JButton("Edit");
	JButton btnrefresh=new JButton("Refresh");
	JButton btndelete=new JButton("Delete");

	JLabel lbltotalamount=new JLabel("Total Amount");
	JLabel lbldue=new JLabel("Due");
	JLabel lblpaymentprotocal=new JLabel("Payment Protocal");
	
	SuggestText stpaymentprotocal=new SuggestText();
	JButton btnconfirm=new JButton("Confirm");
	JButton btndone=new JButton("Done");

	JLabel lblfromdate=new JLabel("From Date");
	JLabel lbltodate=new JLabel("To Date");
    JDateChooser chFromDate=new JDateChooser();
    JDateChooser chToDate=new JDateChooser();
   
    SuggestText stcatagory=new SuggestText();
	SuggestText stsubcatagory=new SuggestText();
	SuggestText stproductid=new SuggestText();
	JTextArea txtAreaRemarks=new JTextArea(3,4);
	JScrollPane scrollRemarks=new JScrollPane(txtAreaRemarks,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Subcatagory");
	JLabel lblproductid=new JLabel("Product ID");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstock=new JLabel("Stock");
	JLabel lblrate=new JLabel("Rate");
	JLabel lblsalseno=new JLabel("Salse No");
	JLabel lblremarks=new JLabel("Remarks");

	SuggestText stclientid=new SuggestText();
    
    JLabel lblclientid=new JLabel("Client ID");	    
    JLabel lblusername=new JLabel("User Name");
    JLabel lblsalseno_panelNorth=new JLabel("Salse No");
    JLabel lbldate=new JLabel("Date");

    JCheckBox ckregisterclient=new JCheckBox("Register Client");
    JCheckBox ckrunegisterclient=new JCheckBox("Unregister Client");
	 ButtonGroup group=new ButtonGroup();

	public Salse(){
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
	
	public void ClientDataLoad(){
		try{
			String sql="select ClientID,ClientName from tbclientinfo";
			stclientid.vector.clear();
			stclientid.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stclientid.vector.add(rs.getString("ClientID")+" # "+rs.getString("ClientName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
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
     //   panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
        
	}

	private void PanelCenterWork() {
		 panelCenter.setPreferredSize(new Dimension(1150,600));
	//     panelcenter.setBorder(BorderFactory.createRaisedBevelBorder());
	     panelCenter.setLayout(new BorderLayout());
	     panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
	     PanelCenterNorthWork();
	     panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
	     PanelCenterCenterWork();
	     panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
	     PanelCenterSouthWork();
	}

	private void PanelCenterSouthWork() {
		panelCenterSouth.setPreferredSize(new Dimension(1150,50));	
	//	panelcentersouth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		 GridBagConstraints c=new GridBagConstraints();
		 panelCenterSouth.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
		 c.gridx=0;
		 c.gridy=0;
		 panelCenterSouth.add(lbltotalamount,c);
		 lbltotalamount.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,0,2,2);
		 c.gridx=1;
		 c.gridy=0;
		 panelCenterSouth.add(txttotalamount,c);
		 c.gridx=2;
		 c.gridy=0;
		 panelCenterSouth.add(lbldue,c);
		 lbldue.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=3;
		 c.gridy=0;
		 panelCenterSouth.add(txtdue,c);
		 c.gridx=4;
		 c.gridy=0;
		 panelCenterSouth.add(lblpaymentprotocal,c);
		 lblpaymentprotocal.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=5;
		 c.gridy=0;
		 panelCenterSouth.add(stpaymentprotocal.cmbSuggest,c);
	     c.insets=new Insets(2,0,2,20);
		 stpaymentprotocal.cmbSuggest.setPreferredSize(new Dimension(150,20));
		 c.gridx=6;
		 c.gridy=0;
		 panelCenterSouth.add(btnconfirm,c);
		 btnconfirm.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,0,2,20);
		 c.gridx=7;
		 c.gridy=0;
		 panelCenterSouth.add(btndone,c);
		 btndone.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void PanelCenterCenterWork() {
		panelCenterCenter.setPreferredSize(new Dimension(1150,200));	
		panelCenterCenter.setBorder(BorderFactory.createTitledBorder(""));
		 Object row[][]={};	
		 String col[]={"Product ID","Product Name","Salse Quantity","Remarks","Find"};
		 DefaultTableModel model=new DefaultTableModel(row,col);
		 JTable table=new JTable(model);
		 JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		   
		FlowLayout flow=new FlowLayout();
		panelCenterCenter.setLayout(flow);
		flow.setVgap(5);
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
		panelCenterNorthCenter.setPreferredSize(new Dimension(565,340));	
		panelCenterNorthCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorthCenter.setLayout(new BorderLayout());
		panelCenterNorthCenter.add(panelCenterNorthCenterUpper,BorderLayout.NORTH);
		PanelCenterNorthCenterUpperWork();
		panelCenterNorthCenter.add(panelCenterNorthCenterLower,BorderLayout.SOUTH);
		PanelCenterNorthCenterLowerWork();
	}

	private void PanelCenterNorthCenterUpperWork(){
		panelCenterNorthCenterUpper.setPreferredSize(new Dimension(565,100));
	//	panelcenternorthcenterUpper.setBorder(BorderFactory.createTitledBorder(""));
		 
        FlowLayout flow=new FlowLayout();
        panelCenterNorthCenterUpper.setLayout(flow);
        flow.setVgap(20);
        panelCenterNorthCenterUpper.add(lblfromdate);
        lblfromdate.setFont(new Font("Sherif",Font.BOLD,14));
        panelCenterNorthCenterUpper.add(chFromDate);
        chFromDate.setPreferredSize(new Dimension(150,35));
        panelCenterNorthCenterUpper.add(lbltodate);
        lbltodate.setFont(new Font("Sherif",Font.BOLD,14));
        panelCenterNorthCenterUpper.add(chToDate);
        chToDate.setPreferredSize(new Dimension(150,35));
	}

	private void PanelCenterNorthCenterLowerWork(){
		panelCenterNorthCenterLower.setPreferredSize(new Dimension(565,230));
		//panelcenternorthcenterLower.setBorder(BorderFactory.createTitledBorder(""));

		 Object row[][]={};	
		 String col[]={"Invoice No","Total Amount","Date"};
		 DefaultTableModel model=new DefaultTableModel(row,col);
		 JTable table=new JTable(model);
		 JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
        FlowLayout flow=new FlowLayout();
        panelCenterNorthCenterLower.setLayout(flow);
        flow.setVgap(20);
        panelCenterNorthCenterLower.add(scroll);
        scroll.setPreferredSize(new Dimension(500,180));
	}
	
	private void PanelCenterNorthWestWork() {
		panelCenterNorthWest.setPreferredSize(new Dimension(565,340));	
		panelCenterNorthWest.setBorder(BorderFactory.createTitledBorder(""));
		panelCenterNorthWest.setLayout(new BorderLayout());
		panelCenterNorthWest.add(panelCenterNorthWestUpper,BorderLayout.NORTH);
		PanelCenterNorthWestUpperWork();
		panelCenterNorthWest.add(panelCenterNorthWestLower,BorderLayout.SOUTH);
		PanelCenterNorthWestlowerWork();		
	}

	private void PanelCenterNorthWestlowerWork() {
		panelCenterNorthWestLower.setPreferredSize(new Dimension(565,60));	
	//	panelcenternorthwestlower.setBorder(BorderFactory.createRaisedBevelBorder());
	
		FlowLayout flow=new FlowLayout();
		panelCenterNorthWestLower.setLayout(flow);
		flow.setVgap(30);
		flow.setHgap(25);
		panelCenterNorthWestLower.add(btnsubmit);
		btnsubmit.setPreferredSize(new Dimension(90,30));
		btnsubmit.setFont(new Font("Sherif",Font.BOLD,14));

		panelCenterNorthWestLower.add(btnedit);
		btnedit.setPreferredSize(new Dimension(70,30));
		btnedit.setFont(new Font("Sherif",Font.BOLD,14));

		panelCenterNorthWestLower.add(btnrefresh);
		btnrefresh.setPreferredSize(new Dimension(100,30));
		btnrefresh.setFont(new Font("Sherif",Font.BOLD,14));

		panelCenterNorthWestLower.add(btndelete);
		btndelete.setPreferredSize(new Dimension(90,30));
		btndelete.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void PanelCenterNorthWestUpperWork() {
		panelCenterNorthWestUpper.setPreferredSize(new Dimension(565,280));	
	//	panelcenternorthwestupper.setBorder(BorderFactory.createRaisedBevelBorder());
		
        GridBagConstraints c=new GridBagConstraints();
        panelCenterNorthWestUpper.setLayout(new GridBagLayout());
        c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelCenterNorthWestUpper.add(lblcatagory,c);
		lblcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelCenterNorthWestUpper.add(stcatagory.cmbSuggest,c);
		c.gridx=2;
		c.gridy=0;
		panelCenterNorthWestUpper.add(lblstock,c);
		lblstock.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=3;
		c.gridy=0;
		panelCenterNorthWestUpper.add(txtstock,c);
		c.gridx=0;
		c.gridy=1;
		panelCenterNorthWestUpper.add(lblsubcatagory,c);
		lblsubcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelCenterNorthWestUpper.add(stsubcatagory.cmbSuggest,c);
		c.gridx=2;
		c.gridy=1;
		panelCenterNorthWestUpper.add(lblrate,c);
		lblrate.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=3;
		c.gridy=1;
		panelCenterNorthWestUpper.add(txtrate,c);
		c.gridx=0;
		c.gridy=2;
		panelCenterNorthWestUpper.add(lblproductid,c);
		lblproductid.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelCenterNorthWestUpper.add(stproductid.cmbSuggest,c);
		c.gridx=2;
		c.gridy=2;
		panelCenterNorthWestUpper.add(lblsalseno,c);
		lblsalseno.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=3;
		c.gridy=2;
		panelCenterNorthWestUpper.add(txtsalseno,c);
		c.gridx=0;
		c.gridy=3;
		panelCenterNorthWestUpper.add(lblunit,c);
		lblunit.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelCenterNorthWestUpper.add(txtunit,c);
		c.gridx=2;
		c.gridy=3;
		panelCenterNorthWestUpper.add(lblremarks,c);
		lblremarks.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=3;
		c.gridy=3;
		panelCenterNorthWestUpper.add(scrollRemarks,c);
		txtAreaRemarks.setLineWrap(true);		
	}

	private void PanelNorthWork() {
		 panelNorth.setPreferredSize(new Dimension(1150,100));
	     panelNorth.setBorder(BorderFactory.createTitledBorder(""));
	     
	     GridBagConstraints c=new GridBagConstraints();
	     panelNorth.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
		 c.gridx=0;
		 c.gridy=0;
	     panelNorth.add(ckregisterclient,c); 
	     ckregisterclient.setFont(new Font("Sherif",Font.BOLD,14));
	     group.add(ckregisterclient);
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=1;
		 c.gridy=0;
	     panelNorth.add(lblclientid,c); 
	     lblclientid.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=2;
		 c.gridy=0;
	     panelNorth.add(stclientid.cmbSuggest,c); 
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=3;
		 c.gridy=0;
	     panelNorth.add(lblsalseno_panelNorth,c); 
	     lblsalseno_panelNorth.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=4;
		 c.gridy=0;
	     panelNorth.add(txtSalseNo,c); 
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=0;
		 c.gridy=1;
	     panelNorth.add(ckrunegisterclient,c);
	     ckrunegisterclient.setFont(new Font("Sherif",Font.BOLD,14));
	     group.add(ckrunegisterclient);
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=1;
		 c.gridy=1;
	     panelNorth.add(lblusername,c); 
	     lblusername.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=2;
		 c.gridy=1;
	     panelNorth.add(txtuUerName,c);  
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=3;
		 c.gridy=1;
	     panelNorth.add(lbldate,c); 
	     lbldate.setFont(new Font("Sherif",Font.BOLD,14));
	     c.insets=new Insets(2,2,2,50);
	     c.gridx=4;
		 c.gridy=1;
	     panelNorth.add(chDate,c); 
	     c.insets=new Insets(2,2,2,50);
	}
	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	}

}