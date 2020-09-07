package com.example.MenuItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import com.toedter.calendar.JDateChooser;

public class TaskReport extends JPanel{
	
	JPanel panelNorth=new JPanel();
	JPanel panelSouth=new JPanel();
	
	JPanel panelNorthWest=new JPanel();
	JPanel panelNorthCenter=new JPanel();
	
	JPanel panelSouthWest=new JPanel();
	JPanel panelSouthCenter=new JPanel();
	
	JPanel panelNorthWestNorth=new JPanel();
	JPanel panelNorthWestWest=new JPanel();
	JPanel panelNorthWestCenter=new JPanel();
	
	JPanel panelNorthWestCenterNorth=new JPanel();
	JPanel panelNorthWestCenterSouth=new JPanel();
	
	JPanel panelNorthCenterNorth=new JPanel();
	JPanel panelNorthCenterWest=new JPanel();
	JPanel panelNorthCenterCenter=new JPanel();
	
	JPanel panelNorthCenterCenterNorth=new JPanel();
	JPanel panelNorthCenterCenterSouth=new JPanel();
	
	JPanel panelSouthWestNorth=new JPanel();
	JPanel panelSouthWestCenter=new JPanel();
	JPanel panelSouthWestSouth=new JPanel();

	JPanel panelSouthCenterNorth=new JPanel();
	JPanel panelSouthCenterWest=new JPanel();
	JPanel panelSouthCenterCenter=new JPanel();
	
	JPanel panelSouthCenterCenterNorth=new JPanel();
	JPanel panelSouthCenterCenterSouth=new JPanel();

	public TaskReport(){
		init();
		cmp();
	}

	private void cmp() {
        add(panelNorth,BorderLayout.NORTH);
        PanelNorthWork();
        add(panelSouth,BorderLayout.SOUTH);
        PanelSouthWork();
	}
	
	private void PanelSouthWork() {
        panelSouth.setPreferredSize(new Dimension(1120,360));
		panelSouth.setBorder(BorderFactory.createTitledBorder(""));
		panelSouth.setLayout(new BorderLayout());
		panelSouth.add(panelSouthWest,BorderLayout.WEST);
		PanelSouthWestWork();
		panelSouth.add(panelSouthCenter,BorderLayout.CENTER);
		PanelSouthCenterWork();
	}

	private void PanelSouthCenterWork() {                                                   //Stock Report
		panelSouthCenter.setPreferredSize(new Dimension(550,360));
		TitledBorder Title=BorderFactory.createTitledBorder("  Stock Report  ");
		Title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		Title.setTitleJustification(TitledBorder.CENTER);
		Title.setTitlePosition(TitledBorder.TOP);
		panelSouthCenter.setBorder(Title);
		
		panelSouthCenter.setLayout(new BorderLayout());
		panelSouthCenter.add(panelSouthCenterNorth,BorderLayout.NORTH);
		PanelSouthCenterNorthWork();
		panelSouthCenter.add(panelSouthCenterWest,BorderLayout.WEST);
		PanelSouthCenterWestWork();
		panelSouthCenter.add(panelSouthCenterCenter,BorderLayout.CENTER);
		PanelSouthCenterCenterWork();
	}

	private void PanelSouthCenterCenterWork() {
		
		panelSouthCenterCenter.setPreferredSize(new Dimension(400,300));
		panelSouthCenterCenter.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
	//	panelSouthCenterCenter.setBackground(Color.CYAN);
		panelSouthCenterCenter.setLayout(new BorderLayout());
		panelSouthCenterCenter.add(panelSouthCenterCenterNorth,BorderLayout.NORTH);
		PanelSouthCenterCenterNorthWork();
		panelSouthCenterCenter.add(panelSouthCenterCenterSouth,BorderLayout.SOUTH);
		PanelSouthCenterCenterSouthWork();
	}

	private void PanelSouthCenterCenterNorthWork() {
		panelSouthCenterCenterNorth.setPreferredSize(new Dimension(400,180));
	//	panelSouthCenterCenterNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthCenterCenterNorth.setBackground(Color.CYAN);
		
        String str[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",};
		
		JComboBox<String>cmbCatagory=new JComboBox<String>(str);
		JComboBox<String>cmbSubCatagory=new JComboBox<String>(str);
		JComboBox<String>cmbProductName=new JComboBox<String>(str);
		
        JDateChooser dcFromDate=new JDateChooser();
        JDateChooser dcToDate=new JDateChooser();

		JLabel lblCatagoryName=new JLabel("Catagory Name");
		JLabel lblSubCatagoryName=new JLabel("Subcatagory Name");
		JLabel lblProductName=new JLabel("Product Name");
		JLabel lblFromDate=new JLabel("From Date");
		JLabel lblToDate=new JLabel("To Date");
		
        JCheckBox ckAll=new JCheckBox("All");
        JCheckBox ckAll2=new JCheckBox("All");
        JCheckBox ckAll3=new JCheckBox("All");

        GridBagConstraints c=new GridBagConstraints();
        panelSouthCenterCenterNorth.setLayout(new GridBagLayout());
	    c.fill=GridBagConstraints.BOTH;
	    c.insets=new Insets(2,2,2,2);
	    c.gridx=0;
	    c.gridy=0;
	    panelSouthCenterCenterNorth.add(lblCatagoryName, c);
	    lblCatagoryName.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=0;
	    panelSouthCenterCenterNorth.add(cmbCatagory, c);
	    cmbCatagory.setPreferredSize(new Dimension(150,25));
	    c.gridx=2;
	    c.gridy=0;
	    panelSouthCenterCenterNorth.add(ckAll, c);
	    ckAll.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=0;
	    c.gridy=1;
	    panelSouthCenterCenterNorth.add(lblSubCatagoryName, c);
	    lblSubCatagoryName.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=1;
	    panelSouthCenterCenterNorth.add(cmbSubCatagory, c);
	    c.gridx=2;
	    c.gridy=1;
	    panelSouthCenterCenterNorth.add(ckAll2, c);
	    ckAll2.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=0;
	    c.gridy=2;
	    panelSouthCenterCenterNorth.add(lblProductName, c);
	    lblProductName.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=2;
	    panelSouthCenterCenterNorth.add(cmbProductName, c);
	    c.gridx=2;
	    c.gridy=2;
	    panelSouthCenterCenterNorth.add(ckAll3, c);
	    ckAll3.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=0;
	    c.gridy=3;
	    panelSouthCenterCenterNorth.add(lblFromDate, c);
	    lblFromDate.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=3;
	    panelSouthCenterCenterNorth.add(dcFromDate, c);
	    c.gridx=0;
	    c.gridy=4;
	    panelSouthCenterCenterNorth.add(lblToDate, c);
	    lblToDate.setFont(new Font("Serif",Font.BOLD,14));
	    c.gridx=1;
	    c.gridy=4;
	    panelSouthCenterCenterNorth.add(dcToDate, c);
	    
		
	}
	private void PanelSouthCenterCenterSouthWork() {
		panelSouthCenterCenterSouth.setPreferredSize(new Dimension(400,100));
	//	panelSouthCenterCenterSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelSouthCenterCenterSouth.setBackground(Color.CYAN);
		JButton btnRefresh=new JButton("Refresh");
		JButton btnPreview=new JButton("Preview");
		FlowLayout flow=new FlowLayout();
		panelSouthCenterCenterSouth.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(50);
		panelSouthCenterCenterSouth.add(btnRefresh);
		btnRefresh.setFont(new Font("Serif",Font.BOLD,14));
		panelSouthCenterCenterSouth.add(btnPreview);
		btnPreview.setFont(new Font("Serif",Font.BOLD,14));
	}

	private void PanelSouthCenterWestWork() {
		panelSouthCenterWest.setPreferredSize(new Dimension(150,300));
		panelSouthCenterWest.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		panelSouthCenterWest.setBackground(Color.LIGHT_GRAY);
		
		JCheckBox ckCatagoryWise=new JCheckBox("Catagory Wise");
		JCheckBox ckDateWise=new JCheckBox("Date Wise");
        ButtonGroup group=new ButtonGroup();
        
        GridBagConstraints c=new GridBagConstraints();
        panelSouthCenterWest.setLayout(new GridBagLayout());
	    c.fill=GridBagConstraints.BOTH;
	    c.insets=new Insets(2,2,2,2);                //TLBR
	    c.gridx=0;
	    c.gridy=0;
	    panelSouthCenterWest.add(ckCatagoryWise, c);
	    ckCatagoryWise.setFont(new Font("Serif",Font.BOLD,14));
	    c.insets=new Insets(20,2,2,2);
	    group.add(ckCatagoryWise);
	    c.gridx=0;
	    c.gridy=1;
	    panelSouthCenterWest.add(ckDateWise, c);
	    ckDateWise.setFont(new Font("Serif",Font.BOLD,14));
	    c.insets=new Insets(20,2,2,2);
	    group.add(ckDateWise);
	}

	private void PanelSouthCenterNorthWork() {
		panelSouthCenterNorth.setPreferredSize(new Dimension(550,60));
		panelSouthCenterNorth.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
		panelSouthCenterNorth.setBackground(Color.PINK);
		JLabel lblReportType=new JLabel("Report Type :");
		JRadioButton rdStockSummary=new JRadioButton("Stock Summary");
		JRadioButton rdStockDetails=new JRadioButton("Stock Details");
		ButtonGroup group=new ButtonGroup();
		
		FlowLayout flow=new FlowLayout();
		panelSouthCenterNorth.setLayout(flow);
		    flow.setVgap(15);
		    flow.setHgap(50);
		panelSouthCenterNorth.add(lblReportType);
		lblReportType.setFont(new Font("Serif",Font.BOLD,14));
		panelSouthCenterNorth.add(rdStockSummary);
		rdStockSummary.setFont(new Font("Serif",Font.BOLD,14));
		group.add(rdStockSummary);
		panelSouthCenterNorth.add(rdStockDetails);
		rdStockDetails.setFont(new Font("Serif",Font.BOLD,14));
		group.add(rdStockDetails);
	}

	private void PanelSouthWestWork() {                                                      //Product Report
		panelSouthWest.setPreferredSize(new Dimension(550,360));
		TitledBorder Title=BorderFactory.createTitledBorder("  Product Report  ");
		Title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		Title.setTitleJustification(TitledBorder.CENTER);
		Title.setTitlePosition(TitledBorder.TOP);
		panelSouthWest.setBorder(Title);
		
		panelSouthWest.setLayout(new BorderLayout());
		panelSouthWest.add(panelSouthWestNorth,BorderLayout.NORTH);
		PanelSouthWestNorthWork();
		panelSouthWest.add(panelSouthWestCenter,BorderLayout.CENTER);
		PanelSouthWestCenterWork();
		panelSouthWest.add(panelSouthWestSouth,BorderLayout.SOUTH);
		PanelSouthWestSouthWork();
	}

	private void PanelSouthWestSouthWork() {
		panelSouthWestSouth.setPreferredSize(new Dimension(550,60));
		panelSouthWestSouth.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		panelSouthWestSouth.setBackground(Color.LIGHT_GRAY);
		JButton btnRefresh=new JButton("Refresh");
		JButton btnPreview=new JButton("Preview");

	    FlowLayout flow=new FlowLayout();
	    panelSouthWestSouth.setLayout(flow);
	    flow.setVgap(10);
	    flow.setHgap(50);
	    panelSouthWestSouth.add(btnRefresh);
	    btnRefresh.setFont(new Font("Serif",Font.BOLD,14));
	    panelSouthWestSouth.add(btnPreview);
	    btnPreview.setFont(new Font("Serif",Font.BOLD,14));  
	}

	private void PanelSouthWestCenterWork() {
		panelSouthWestCenter.setPreferredSize(new Dimension(550,240));
		panelSouthWestCenter.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
		panelSouthWestCenter.setBackground(Color.CYAN);
		String str[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",};
		
		JComboBox<String>cmbCatagory=new JComboBox<String>(str);
		JComboBox<String>cmbSubCatagory=new JComboBox<String>(str);
		JComboBox<String>cmbProductName=new JComboBox<String>(str);
		
        JDateChooser dcFromDate=new JDateChooser();
        JDateChooser dcToDate=new JDateChooser();

		JLabel lblCatagoryName=new JLabel("Catagory Name");
		JLabel lblSubCatagoryName=new JLabel("Subcatagory Name");
		JLabel lblProductName=new JLabel("Product Name");
		JLabel lblFromDate=new JLabel("From Date");
		JLabel lblToDate=new JLabel("To Date");
		
        JCheckBox ckAll=new JCheckBox("All");
        JCheckBox ckAll2=new JCheckBox("All");
        JCheckBox ckAll3=new JCheckBox("All");

        GridBagConstraints c=new GridBagConstraints();
        panelSouthWestCenter.setLayout(new GridBagLayout());
	    c.fill=GridBagConstraints.BOTH;
	    c.insets=new Insets(2,2,2,2);
	    c.gridx=0;
	    c.gridy=0;
	    panelSouthWestCenter.add(lblCatagoryName, c);
	    lblCatagoryName.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=1;
	    c.gridy=0;
	    panelSouthWestCenter.add(cmbCatagory, c);
	    cmbCatagory.setPreferredSize(new Dimension(150,25));
	    c.gridx=2;
	    c.gridy=0;
	    panelSouthWestCenter.add(ckAll, c);
	    ckAll.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=0;
	    c.gridy=1;
	    panelSouthWestCenter.add(lblSubCatagoryName, c);
	    lblSubCatagoryName.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=1;
	    c.gridy=1;
	    panelSouthWestCenter.add(cmbSubCatagory, c);
	    c.gridx=2;
	    c.gridy=1;
	    panelSouthWestCenter.add(ckAll2, c);
	    ckAll2.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=0;
	    c.gridy=2;
	    panelSouthWestCenter.add(lblProductName, c);
	    lblProductName.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=1;
	    c.gridy=2;
	    panelSouthWestCenter.add(cmbProductName, c);
	    c.gridx=2;
	    c.gridy=2;
	    panelSouthWestCenter.add(ckAll3, c);
	    ckAll3.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=0;
	    c.gridy=3;
	    panelSouthWestCenter.add(lblFromDate, c);
	    lblFromDate.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=1;
	    c.gridy=3;
	    panelSouthWestCenter.add(dcFromDate, c);
	    c.gridx=0;
	    c.gridy=4;
	    panelSouthWestCenter.add(lblToDate, c);
	    lblToDate.setFont(new Font("Serif",Font.BOLD,14));  
	    c.gridx=1;
	    c.gridy=4;
	    panelSouthWestCenter.add(dcToDate, c);
	    
	}

	private void PanelSouthWestNorthWork() {
		panelSouthWestNorth.setPreferredSize(new Dimension(550,60));
		panelSouthWestNorth.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
		panelSouthWestNorth.setBackground(Color.PINK);
		
		JLabel lblReportType=new JLabel("Report Type :");
		JRadioButton rdOpeningStock=new JRadioButton("Opening Stock");
		JRadioButton rdWastage=new JRadioButton("Wastage");
        ButtonGroup group=new ButtonGroup(); 
        
        FlowLayout flow=new FlowLayout();
        panelSouthWestNorth.setLayout(flow);
        flow.setVgap(20);
        flow.setHgap(40);
        panelSouthWestNorth.add(lblReportType);
        lblReportType.setFont(new Font("Serif",Font.BOLD,14));  
        panelSouthWestNorth.add(rdOpeningStock);
        rdOpeningStock.setFont(new Font("Serif",Font.BOLD,14));  
        group.add(rdOpeningStock);
        panelSouthWestNorth.add(rdWastage);
        rdWastage.setFont(new Font("Serif",Font.BOLD,14));  
        group.add(rdWastage);
       
	}

	private void PanelNorthWork() {
		
		panelNorth.setPreferredSize(new Dimension(1120,350));
		panelNorth.setBorder(BorderFactory.createTitledBorder(""));
		panelNorth.setLayout(new BorderLayout());
		panelNorth.add(panelNorthWest,BorderLayout.WEST);
		PanelNorthWestWork();
		panelNorth.add(panelNorthCenter,BorderLayout.CENTER);
		PanelNorthCenterWork();
	}

	private void PanelNorthCenterWork() {                                                  //salse report
		panelNorthCenter.setPreferredSize(new Dimension(550,360));
		TitledBorder Title=BorderFactory.createTitledBorder("   Salse Peport  ");
		Title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		Title.setTitleJustification(TitledBorder.CENTER);
		Title.setTitlePosition(TitledBorder.TOP);
		panelNorthCenter.setBorder(Title);
		
		panelNorthCenter.setLayout(new BorderLayout());
		panelNorthCenter.add(panelNorthCenterNorth,BorderLayout.NORTH);
		PanelNorthCenterNorthWork();
		panelNorthCenter.add(panelNorthCenterWest,BorderLayout.WEST);
		PanelNorthCenterWestWork();
		panelNorthCenter.add(panelNorthCenterCenter,BorderLayout.CENTER);
		PanelNorthCenterCenterWork();
	}

	private void PanelNorthCenterCenterWork() {
		panelNorthCenterCenter.setPreferredSize(new Dimension(400,300));
		panelNorthCenterCenter.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
	//	panelNorthCenterCenter.setBackground(Color.CYAN);
		panelNorthCenterCenter.setLayout(new BorderLayout());
		panelNorthCenterCenter.add(panelNorthCenterCenterNorth,BorderLayout.NORTH);
		PanelNorthCenterCenterNorthWork();
		panelNorthCenterCenter.add(panelNorthCenterCenterSouth,BorderLayout.SOUTH);
		PanelNorthCenterCenterSouthWork();
	}

	private void PanelNorthCenterCenterSouthWork() {

		panelNorthCenterCenterSouth.setPreferredSize(new Dimension(200,100));
		panelNorthCenterCenterSouth.setBackground(Color.CYAN);
        JButton btnRefresh=new JButton("Refresh");
        JButton btnPreview=new JButton("Preview");
        FlowLayout flow=new FlowLayout();
        panelNorthCenterCenterSouth.setLayout(flow);
        flow.setVgap(60);
        flow.setHgap(40);
        panelNorthCenterCenterSouth.add(btnRefresh);
        btnRefresh.setFont(new Font("Serif",Font.BOLD,14));  
        panelNorthCenterCenterSouth.add(btnPreview);
        btnPreview.setFont(new Font("Serif",Font.BOLD,14));  
	}

	private void PanelNorthCenterCenterNorthWork() {

		panelNorthCenterCenterNorth.setPreferredSize(new Dimension(200,180));
		panelNorthCenterCenterNorth.setBackground(Color.CYAN);;
		String str[]={"","","","","","","","","","","","","","","","","","","","","","","","","","",};
		JComboBox<String>cmbProductName=new JComboBox<String>(str);
		JComboBox<String>cmbInvoiceNo=new JComboBox<String>(str);
		
        JDateChooser dcFromDate=new JDateChooser();
        JDateChooser dcToDate=new JDateChooser();
        
		JLabel lblProductName=new JLabel("Product Name");
		JLabel lblFromDate=new JLabel("From Date");
		JLabel lblToDate=new JLabel("To Date");
		JLabel lblInvoiceNo=new JLabel("Invoice No");
		
		GridBagConstraints c=new GridBagConstraints();
		panelNorthCenterCenterNorth.setLayout(new GridBagLayout());
	    c.fill=GridBagConstraints.BOTH;
	    c.insets=new Insets(2,2,2,2);
	    c.gridx=0;
	    c.gridy=0;
	    panelNorthCenterCenterNorth.add(lblProductName, c);
	    lblProductName.setFont(new Font("Serif",Font.BOLD,14));  
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=1;
	    c.gridy=0;
	    panelNorthCenterCenterNorth.add(cmbProductName, c);
	    c.insets=new Insets(10,2,2,2);
	    cmbProductName.setPreferredSize(new Dimension(150,25));
	    c.gridx=0;
	    c.gridy=1;
	    panelNorthCenterCenterNorth.add(lblFromDate, c);
	    lblFromDate.setFont(new Font("Serif",Font.BOLD,14));  
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=1;
	    c.gridy=1;
	    panelNorthCenterCenterNorth.add(dcFromDate, c);
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=0;
	    c.gridy=2;
	    panelNorthCenterCenterNorth.add(lblToDate, c);
	    lblToDate.setFont(new Font("Serif",Font.BOLD,14));  
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=1;
	    c.gridy=2;
	    panelNorthCenterCenterNorth.add(dcToDate, c);
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=0;
	    c.gridy=3;
	    panelNorthCenterCenterNorth.add(lblInvoiceNo, c);
	    lblInvoiceNo.setFont(new Font("Serif",Font.BOLD,14));  
	    c.insets=new Insets(10,2,2,2);
	    c.gridx=1;
	    c.gridy=3;
	    panelNorthCenterCenterNorth.add(cmbInvoiceNo, c);
	    c.insets=new Insets(10,2,2,2);
	}

	private void PanelNorthCenterWestWork() {
		panelNorthCenterWest.setPreferredSize(new Dimension(150,300));
		panelNorthCenterWest.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		panelNorthCenterWest.setBackground(Color.LIGHT_GRAY);
		
		JCheckBox ckProductWise=new JCheckBox("Product Wise");
		JCheckBox ckDateWise=new JCheckBox("Date Wise");
		JCheckBox ckReturnNoWise=new JCheckBox("Return No Wise");
		ButtonGroup group=new ButtonGroup();
		
		 GridBagConstraints c=new GridBagConstraints();
		 panelNorthCenterWest.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.insets=new Insets(2,2,2,2);
	     c.gridx=0;
	     c.gridy=0;
	     panelNorthCenterWest.add(ckProductWise, c);
	     ckProductWise.setFont(new Font("Serif",Font.BOLD,14));  
	     group.add(ckProductWise);
	     c.insets=new Insets(10,2,2,2);
	     c.gridx=0;
	     c.gridy=1;
	     panelNorthCenterWest.add(ckDateWise, c);
	     ckDateWise.setFont(new Font("Serif",Font.BOLD,14));  
	     group.add(ckDateWise);
	     c.insets=new Insets(10,2,2,2);
	     c.gridx=0;
	     c.gridy=2;
	     panelNorthCenterWest.add(ckReturnNoWise, c);
	     ckReturnNoWise.setFont(new Font("Serif",Font.BOLD,14));  
	     group.add(ckReturnNoWise);;
	     c.insets=new Insets(10,2,2,2);
	}

	private void PanelNorthCenterNorthWork() {
		panelNorthCenterNorth.setPreferredSize(new Dimension(550,60));
		panelNorthCenterNorth.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 5));
		panelNorthCenterNorth.setBackground(Color.PINK);
		
		JLabel lblReportType=new JLabel("Report Type :");
		JRadioButton rdSalse=new JRadioButton("Salse");
		JRadioButton rdSalseReturn=new JRadioButton("Salse Return");
		ButtonGroup group=new ButtonGroup();
		FlowLayout flow=new FlowLayout();
		panelNorthCenterNorth.setLayout(flow);
		flow.setVgap(20);
		flow.setHgap(50);
		panelNorthCenterNorth.add(lblReportType);
		lblReportType.setFont(new Font("Serif",Font.BOLD,14));  
		panelNorthCenterNorth.add(rdSalse);
		rdSalse.setFont(new Font("Serif",Font.BOLD,14));  
		group.add(rdSalse);
		panelNorthCenterNorth.add(rdSalseReturn);
		rdSalseReturn.setFont(new Font("Serif",Font.BOLD,14));  
		group.add(rdSalseReturn);
	}

	private void PanelNorthWestWork() {                                                  // Item Report //
		panelNorthWest.setPreferredSize(new Dimension(550,360));
		TitledBorder Title=BorderFactory.createTitledBorder("  Item Report  ");
		Title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,20));
		Title.setTitleJustification(TitledBorder.CENTER);
		Title.setTitlePosition(TitledBorder.TOP);
		panelNorthWest.setBorder(Title);
		
		panelNorthWest.setLayout(new BorderLayout());
		panelNorthWest.add(panelNorthWestNorth,BorderLayout.NORTH);
		PanelNorthWestNorthWork();
		panelNorthWest.add(panelNorthWestWest,BorderLayout.WEST);
		PanelNorthWestWestWork();
		panelNorthWest.add(panelNorthWestCenter,BorderLayout.CENTER);
		PanelNorthWestCenterWork();
	}

	private void PanelNorthWestCenterWork() {
		panelNorthWestCenter.setPreferredSize(new Dimension(400,300));
		panelNorthWestCenter.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 5));
	//	panelNorthWestCenter.setBackground(Color.BLUE);
		panelNorthWestCenter.setLayout(new BorderLayout());
		panelNorthWestCenter.add(panelNorthWestCenterNorth, BorderLayout.NORTH);
		PanelNorthWestCenterNorthWork();
		panelNorthWestCenter.add(panelNorthWestCenterSouth, BorderLayout.SOUTH);
		PanelNorthWestCenterSouthWork();
	}

	private void PanelNorthWestCenterSouthWork() {
		panelNorthWestCenterSouth.setPreferredSize(new Dimension(400,100));
	//	panelNorthWestCenterSouth.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,3));
		panelNorthWestCenterSouth.setBackground(Color.CYAN);
		JButton btnRefresh=new JButton("Refresh");
		JButton btnPreview=new JButton("Preview");
		FlowLayout flow=new FlowLayout();
		panelNorthWestCenterSouth.setLayout(flow);
		flow.setVgap(55);
		flow.setHgap(50);
		panelNorthWestCenterSouth.add(btnRefresh);
		btnRefresh.setFont(new Font("Serif",Font.BOLD,14));  
		panelNorthWestCenterSouth.add(btnPreview);	
		btnPreview.setFont(new Font("Serif",Font.BOLD,14));  
	}

	private void PanelNorthWestCenterNorthWork() {
		panelNorthWestCenterNorth.setPreferredSize(new Dimension(400,180));
	//	panelNorthWestCenterNorth.setBorder(BorderFactory.createLineBorder(Color.MAGENTA, 3));
		panelNorthWestCenterNorth.setBackground(Color.CYAN);
		String str[]={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",};
		JComboBox<String>cmbSupplierName=new JComboBox<String>(str);
		JComboBox<String>cmbProductName=new JComboBox<String>(str);
		JComboBox<String>cmbInvoiceNo=new JComboBox<String>(str);
		
		JCheckBox ckAll1=new JCheckBox("All");
		JCheckBox ckAll2=new JCheckBox("All");
		
		JDateChooser dcFromDate=new JDateChooser();
		JDateChooser dcToDate=new JDateChooser();

		JLabel lblSupplierName=new JLabel("Supplier Name");
		JLabel lblProductName=new JLabel("Product Name");
		JLabel lblFromDate=new JLabel("From Date");
		JLabel lblToDate=new JLabel("To Date");
		JLabel lblInvoiceNo=new JLabel("Invoice No");
		
		 GridBagConstraints c=new GridBagConstraints();
		 panelNorthWestCenterNorth.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.gridx=0;
	     c.gridy=0;
	     panelNorthWestCenterNorth.add(lblSupplierName, c);
	     lblSupplierName.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=1;
	     c.gridy=0;
	     panelNorthWestCenterNorth.add(cmbSupplierName, c);
	     c.insets=new Insets(5,2,2,2);
	     cmbSupplierName.setPreferredSize(new Dimension(150,25));
	     c.gridx=2;
	     c.gridy=0;
	     panelNorthWestCenterNorth.add(ckAll1, c);
	     ckAll1.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=0;
	     c.gridy=1;
	     panelNorthWestCenterNorth.add(lblProductName, c);
	     lblProductName.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=1;
	     c.gridy=1;
	     panelNorthWestCenterNorth.add(cmbProductName, c);
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=2;
	     c.gridy=1;
	     panelNorthWestCenterNorth.add(ckAll2, c);
	     ckAll2.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=0;
	     c.gridy=3;
	     panelNorthWestCenterNorth.add(lblFromDate, c);
	     lblFromDate.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=1;
	     c.gridy=3;
	     panelNorthWestCenterNorth.add(dcFromDate, c);
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=0;
	     c.gridy=4;
	     panelNorthWestCenterNorth.add(lblToDate, c);
	     lblToDate.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=1;
	     c.gridy=4;
	     panelNorthWestCenterNorth.add(dcToDate, c);
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=0;
	     c.gridy=5;
	     panelNorthWestCenterNorth.add(lblInvoiceNo, c);
	     lblInvoiceNo.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(5,2,2,2);
	     c.gridx=1;
	     c.gridy=5;
	     panelNorthWestCenterNorth.add(cmbInvoiceNo, c);
	     c.insets=new Insets(5,2,2,2);
	}

	private void PanelNorthWestWestWork() {
		panelNorthWestWest.setPreferredSize(new Dimension(150,300));
		panelNorthWestWest.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
		panelNorthWestWest.setBackground(Color.LIGHT_GRAY);
		JCheckBox cbSupplierWise=new JCheckBox("Supplier Wise");
		JCheckBox cbProductWise=new JCheckBox("Product Wise");
		JCheckBox cbDateWise=new JCheckBox("Date Wise");
		JCheckBox cbInvoicerWise=new JCheckBox("Invoice Wise");
		 ButtonGroup group=new ButtonGroup();

	     GridBagConstraints c=new GridBagConstraints();
	     panelNorthWestWest.setLayout(new GridBagLayout());
	     c.fill=GridBagConstraints.BOTH;
	     c.insets=new Insets(2,2,2,2);                //    TLBR
	     c.gridx=0;
		 c.gridy=0;
		 panelNorthWestWest.add(cbSupplierWise, c);
		 cbSupplierWise.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(15,2,2,2);
		 group.add(cbSupplierWise);
		 c.gridx=0;
		 c.gridy=1;
		 panelNorthWestWest.add(cbProductWise, c);
		 cbProductWise.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(15,2,2,2);
		 group.add(cbProductWise);
		 c.gridx=0;
		 c.gridy=2;
		 panelNorthWestWest.add(cbDateWise, c);
		 cbDateWise.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(15,2,2,2);
		 group.add(cbDateWise);
		 c.gridx=0;
		 c.gridy=3;
		 panelNorthWestWest.add(cbInvoicerWise, c);
		 cbInvoicerWise.setFont(new Font("Serif",Font.BOLD,14));  
	     c.insets=new Insets(15,2,2,2);
		 group.add(cbInvoicerWise);
		 
	}

	private void PanelNorthWestNorthWork() {
		panelNorthWestNorth.setPreferredSize(new Dimension(550,60));
     	panelNorthWestNorth.setBorder(BorderFactory.createLineBorder(Color.ORANGE,5));
     	panelNorthWestNorth.setBackground(Color.PINK);
		JLabel lblReportType=new JLabel("Report Type:");
	    JRadioButton rdItemRecipt=new JRadioButton("Item Recipt");
	    JRadioButton rdItemReciptReturn=new JRadioButton("Item Recipt Return");
	    ButtonGroup group=new ButtonGroup();
	    
        FlowLayout flow=new FlowLayout();
        panelNorthWestNorth.setLayout(flow);
        flow.setVgap(20);
        flow.setHgap(40);
        panelNorthWestNorth.add(lblReportType);
        lblReportType.setFont(new Font("Serif",Font.BOLD,14));  
        panelNorthWestNorth.add(rdItemRecipt);
        rdItemRecipt.setFont(new Font("Serif",Font.BOLD,14));  
        group.add(rdItemRecipt);
        panelNorthWestNorth.add(rdItemReciptReturn);
        rdItemReciptReturn.setFont(new Font("Serif",Font.BOLD,14));  
        group.add(rdItemReciptReturn);
	}
	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	//	setBackground(Color.BLACK);
	}
}