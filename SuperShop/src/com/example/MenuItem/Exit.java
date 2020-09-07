package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class Exit extends JPanel
{
	JPanel panelCenter=new JPanel();
	JPanel panelSouth=new JPanel();
	JPanel panelItemReport=new JPanel();
	JPanel panelSalesReport=new JPanel();
	JPanel panelProductReport=new JPanel();
	JPanel panelStockReport=new JPanel();
	JPanel panelItemReportNorth=new JPanel();
	JPanel panelItemReportCenter=new JPanel();
	JPanel panelItemReportSouth=new JPanel();
	JPanel panelItemReportCenterWest=new JPanel();
	JPanel panelItemReportCenterCenter=new JPanel();
	JPanel panelSalesReportNorth=new JPanel();
	JPanel panelSalesReportCenter=new JPanel();
	JPanel panelSalesReportSouth=new JPanel();
	JPanel panelSalesReportCenterWest=new JPanel();
	JPanel panelSalesReportCenterCenter=new JPanel();
	JPanel panelProductReportNorth=new JPanel();
	JPanel panelProductReportCenter=new JPanel();
	JPanel panelProductReportSouth=new JPanel();
	JPanel panelProductReportCenterWest=new JPanel();
	JPanel panelProductReportCenterCenter=new JPanel();
	JPanel panelStockReportNorth=new JPanel();
	JPanel panelStockReportCenter=new JPanel();
	JPanel panelStockReportSouth=new JPanel();
	JPanel panelStockReportCenterWest=new JPanel();
	JPanel panelStockReportCenterCenter=new JPanel();

	JLabel lblReportTypeItemReport=new JLabel("Report Type:");
	JLabel lblReportTypeSalesReport=new JLabel("Report Type:");
	JLabel lblReportTypeProductReport=new JLabel("Report Type:");
	JLabel lblReportTypeStockReport=new JLabel("Report Type:");
	JLabel lblSupplierName=new JLabel("Supplier Name");

	JLabel lblProductNameItemReport=new JLabel("Product Name");
	JLabel lblProductNameSalesReport=new JLabel("Product Name");
	JLabel lblProductNameProductReport=new JLabel("Product Name");
	JLabel lblProductNameStockReport=new JLabel("Product Name");

	JLabel lblFromDateItemReport=new JLabel("From Date");
	JLabel lblFromDateSalesReport=new JLabel("From Date");
	JLabel lblFromDateProductReport=new JLabel("From Date");
	JLabel lblFromDateStockReport=new JLabel("From Date");

	JLabel lblToDateItemReport=new JLabel("To Date");
	JLabel lblToDateSalesReport=new JLabel("To Date");
	JLabel lblToDateProductReport=new JLabel("To Date");
	JLabel lblToDateStockReport=new JLabel("To Date");

	JLabel lblInvoicNoItemReport=new JLabel("Invoic No");
	JLabel lblInvoicNoSalesReport=new JLabel("Invoic No");

	JLabel lblCatagoryNameProductReport=new JLabel("Catagory Name");
	JLabel lblCatagoryNameStockReport=new JLabel("Catagory Name");

	JLabel lblSubcatagoryNameProductReport=new JLabel("Subcatagory Name");
	JLabel lblSubcatagoryNameStockReport=new JLabel("Subcatagory Name");

	JButton btnPreviewItemReport=new JButton("Preview",new ImageIcon("images2/preview-30.png"));
	JButton btnRefreshItemReport=new JButton("Refresh",new ImageIcon("images2/Refresh-reoprt-30.png"));
	JButton btnPreviewSalesReport=new JButton("Preview",new ImageIcon("images2/preview-30.png"));
	JButton btnRefreshSalesReport=new JButton("Refresh",new ImageIcon("images2/Refresh-reoprt-30.png"));
	JButton btnPreviewProductReport=new JButton("Preview",new ImageIcon("images2/preview-30.png"));
	JButton btnRefreshProductReport=new JButton("Refresh",new ImageIcon("images2/Refresh-reoprt-30.png"));
	JButton btnPreviewStockReport=new JButton("Preview",new ImageIcon("images2/preview-30.png"));
	JButton btnRefreshStockReport=new JButton("Refresh",new ImageIcon("images2/Refresh-reoprt-30.png"));

	JRadioButton rdoItemReport=new JRadioButton("Item Report");
	JRadioButton rdoItemReportReturn=new JRadioButton("Item Report Return");
	JRadioButton rdoSales=new JRadioButton("Sales");
	JRadioButton rdosalesReturn=new JRadioButton("sales Return");
	JRadioButton rdoOpeningStock=new JRadioButton("Opening Stock");
	JRadioButton rdoWastageBroken=new JRadioButton("Wastage Broken");
	JRadioButton rdoStockSummery=new JRadioButton("Stock Summery");
	JRadioButton rdoStockDetails=new JRadioButton("Stock Details");

	JCheckBox chkSupplierNameAll=new JCheckBox("All");
	JCheckBox chkProductNameItemReportAll=new JCheckBox("All");
	JCheckBox chkProductNameSalesReportAll=new JCheckBox("All");
	JCheckBox chkChatagoryNameProductReportAll=new JCheckBox("All");
	JCheckBox chkSubcatagoryNameProductReportAll=new JCheckBox("All");
	JCheckBox chkProductNameProductReportAll=new JCheckBox("All");
	JCheckBox chkCatagoryNameStockReportAll=new JCheckBox("All");
	JCheckBox chkSubCatagoryNameStockReportAll=new JCheckBox("All");
	JCheckBox chkProductNameStockReportAll=new JCheckBox("All");

	JCheckBox chkSupplierWise=new JCheckBox("Supplier Wise");
	JCheckBox chkProductWiseItemReport=new JCheckBox("Product Wise");
	JCheckBox chkDateWiseItemReport=new JCheckBox("Date Wise");
	JCheckBox chkInvoiceNowise=new JCheckBox("Invoice No");
	JCheckBox chkProductWiseSalesReport=new JCheckBox("Product Wise");
	JCheckBox chkDateWiseSalesReport=new JCheckBox("Date Wise");
	JCheckBox chkSalesReturnNoWise=new JCheckBox("Sales/Return No");
	JCheckBox chkCatagoryWise=new JCheckBox("Catagory");
	JCheckBox chkDateWiseStockReport=new JCheckBox("Date Wise");

	JComboBox<String> cmbSupplierNameItemReport=new JComboBox<String>();
	JComboBox<String> cmbProductNameItemReport=new JComboBox<String>();
	JComboBox<String> cmbInvoiceNoItemReport=new JComboBox<String>();
	JComboBox<String> cmbProductNameSalesReport=new JComboBox<String>();
	JComboBox<String> cmbInvoiceNoSalesReport=new JComboBox<String>();
	JComboBox<String> cmbCatagoryNameProductReport=new JComboBox<String>();
	JComboBox<String> cmbSubcatagoryNameProductReport=new JComboBox<String>();
	JComboBox<String> cmbProductNameProductReport=new JComboBox<String>();
	JComboBox<String> cmbCatagoryNameStockReport=new JComboBox<String>();
	JComboBox<String> cmbSubCatagoryNameStockReport=new JComboBox<String>();
	JComboBox<String> cmbProductNameStockReport=new JComboBox<String>();
	JDateChooser dateFromDateItemReport=new JDateChooser();
	JDateChooser dateToDateItemReport=new JDateChooser();
	JDateChooser dateFromDateSalesReport=new JDateChooser();
	JDateChooser dateToDateSalesReport=new JDateChooser();
	JDateChooser dateFromDateProductReport=new JDateChooser();
	JDateChooser dateToDateProductReport=new JDateChooser();
	JDateChooser dateFromDateStockReport=new JDateChooser();
	JDateChooser dateToDateStockReport=new JDateChooser();
	Font font=new Font("Baskerville O",Font.BOLD,17);
	Font font1=new Font("Baskerville O",Font.BOLD,15);
	JPanel panel=new JPanel();
	
	public Exit()
	{
		init();
		cmp();
		btnAction();
	}
	public void btnAction(){
		chkChatagoryNameProductReportAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkChatagoryNameProductReportAll.isSelected()){
					cmbCatagoryNameProductReport.setEnabled(false);
				}
				else{
					cmbCatagoryNameProductReport.setEnabled(true);
				}
			}
		});
		chkSubcatagoryNameProductReportAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkSubcatagoryNameProductReportAll.isSelected()){
					cmbSubcatagoryNameProductReport.setEnabled(false);
				}
				else{
					cmbSubcatagoryNameProductReport.setEnabled(true);
				}
			}
		});
		chkProductNameProductReportAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkProductNameProductReportAll.isSelected()){
					cmbProductNameProductReport.setEnabled(false);
				}
				else{
					cmbProductNameProductReport.setEnabled(true);
				}
			}
		});

		chkChatagoryNameProductReportAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chkChatagoryNameProductReportAll.isSelected()){
					cmbCatagoryNameProductReport.setEnabled(false);
				}
			}
		});
	}
	public void panelCenter(){
		BorderLayout border=new BorderLayout();
		panelCenter.setLayout(border);
		border.setHgap(5);
		panelCenter.add(panelItemReport,BorderLayout.WEST);
		panelItemReport();
		panelCenter.add(panelSalesReport,BorderLayout.CENTER);
		panelSalesReport();
	}
	public void panelItemReport(){
		panelItemReport.setPreferredSize(new Dimension(570,1));
		TitledBorder panelItemReportTitle=new TitledBorder("Item Report");
		panelItemReportTitle.setTitleFont(new Font("Cooper Black",Font.BOLD,20));
		panelItemReportTitle.setTitleColor(Color.LIGHT_GRAY);
		panelItemReportTitle.setTitleJustification(TitledBorder.CENTER);
		panelItemReport.setBorder(panelItemReportTitle);
		BorderLayout border=new BorderLayout();
		panelItemReport.setLayout(border);
		panelItemReport.add(panelItemReportNorth,BorderLayout.NORTH);
		panelItemReportNorth();
		panelItemReport.add(panelItemReportCenter,BorderLayout.CENTER);
		panelItemReportCenter();
		panelItemReport.add(panelItemReportSouth,BorderLayout.SOUTH);
		panelItemReportSouth();
	}
	public void panelItemReportNorth(){
		//panelItemReportNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelItemReportNorth.setPreferredSize(new Dimension(1,50));
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		flow.setHgap(15);
		panelItemReportNorth.setLayout(flow);
		lblReportTypeItemReport.setFont(font);
		panelItemReportNorth.add(lblReportTypeItemReport);
		rdoItemReport.setFont(font);
		panelItemReportNorth.add(rdoItemReport);
		rdoItemReportReturn.setFont(font);
		panelItemReportNorth.add(rdoItemReportReturn);
	}
	public void panelItemReportCenter(){
		//panelItemReportCenter.setOpaque(false);
		panelItemReportCenter.setLayout(new BorderLayout());
		panelItemReportCenter.add(panelItemReportCenterWest,BorderLayout.WEST);
		panelItemReportCenterWest();
		panelItemReportCenter.add(panelItemReportCenterCenter,BorderLayout.CENTER);
		panelItemReportCenterCenter();
	}
	public void panelItemReportCenterWest(){
		//panelItemReportCenterWest.setOpaque(false);
		panelItemReportCenterWest.setPreferredSize(new Dimension(200,1));
		GridBagLayout grid=new GridBagLayout();
		panelItemReportCenterWest.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		chkSupplierWise.setFont(font1);
		panelItemReportCenterWest.add(chkSupplierWise,cn);
		cn.gridx=0;
		cn.gridy=1;
		chkProductWiseItemReport.setFont(font1);
		panelItemReportCenterWest.add(chkProductWiseItemReport,cn);
		cn.gridx=0;
		cn.gridy=2;
		chkDateWiseItemReport.setFont(font1);
		panelItemReportCenterWest.add(chkDateWiseItemReport,cn);
		cn.gridx=0;
		cn.gridy=3;
		chkInvoiceNowise.setFont(font1);
		panelItemReportCenterWest.add(chkInvoiceNowise,cn);
	}
	public void panelItemReportCenterCenter(){
		//panelItemReportCenterCenter.setOpaque(false);
		GridBagLayout grid=new GridBagLayout();
		panelItemReportCenterCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(2,2,2,2);
		cn.gridx=0;
		cn.gridy=0;
		lblSupplierName.setFont(font1);
		panelItemReportCenterCenter.add(lblSupplierName,cn);
		cn.gridx=1;
		cn.gridy=0;
		cmbSupplierNameItemReport.setPreferredSize(new Dimension(150,25));
		panelItemReportCenterCenter.add(cmbSupplierNameItemReport,cn);
		cn.gridx=2;
		cn.gridy=0;
		chkSupplierNameAll.setFont(font1);
		panelItemReportCenterCenter.add(chkSupplierNameAll,cn);
		cn.gridx=0;
		cn.gridy=1;
		lblProductNameItemReport.setFont(font1);
		panelItemReportCenterCenter.add(lblProductNameItemReport,cn);
		cn.gridx=1;
		cn.gridy=1;
		cmbProductNameItemReport.setPreferredSize(new Dimension(170,25));
		panelItemReportCenterCenter.add(cmbProductNameItemReport,cn);
		cn.gridx=2;
		cn.gridy=1;
		chkProductNameItemReportAll.setFont(font1);
		panelItemReportCenterCenter.add(chkProductNameItemReportAll,cn);
		cn.gridx=0;
		cn.gridy=2;
		lblFromDateItemReport.setFont(font1);
		panelItemReportCenterCenter.add(lblFromDateItemReport,cn);
		cn.gridx=1;
		cn.gridy=2;
		panelItemReportCenterCenter.add(dateFromDateItemReport,cn);
		cn.gridx=0;
		cn.gridy=3;
		lblToDateItemReport.setFont(font1);
		panelItemReportCenterCenter.add(lblToDateItemReport,cn);
		cn.gridx=1;
		cn.gridy=3;
		panelItemReportCenterCenter.add(dateToDateItemReport,cn);
		cn.gridx=0;
		cn.gridy=4;
		lblInvoicNoItemReport.setFont(font1);
		panelItemReportCenterCenter.add(lblInvoicNoItemReport,cn);
		cn.gridx=1;
		cn.gridy=4;
		panelItemReportCenterCenter.add(cmbInvoiceNoItemReport,cn);
	}
	public void panelItemReportSouth(){
		//panelItemReportSouth.setOpaque(false);
		panelItemReportSouth.setPreferredSize(new Dimension(1,60));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(30);
		panelItemReportSouth.setLayout(flow);
		panelItemReportSouth.add(btnRefreshItemReport);
		panelItemReportSouth.add(btnPreviewItemReport);
	}
	////.......................................................
	public void panelSalesReport(){
		
		
		panelSalesReport.setPreferredSize(new Dimension(570,1));
		TitledBorder panelSalesReportTitle=new TitledBorder("Sales Report");
		panelSalesReportTitle.setTitleFont(new Font("Cooper Black",Font.BOLD,20));
		panelSalesReportTitle.setTitleColor(Color.LIGHT_GRAY);
		panelSalesReportTitle.setTitleJustification(TitledBorder.CENTER);
		panelSalesReport.setBorder(panelSalesReportTitle);
		BorderLayout border=new BorderLayout();
		panelSalesReport.setLayout(border);
		panelSalesReport.add(panelSalesReportNorth,BorderLayout.NORTH);
		panelSalesReportNorth();
		panelSalesReport.add(panelSalesReportCenter,BorderLayout.CENTER);
		panelSalesReportCenter();
		panelSalesReport.add(panelSalesReportSouth,BorderLayout.SOUTH);
		panelSalesReportSouth();
	}
	public void panelSalesReportNorth(){
		//panelSalesReportNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelSalesReportNorth.setPreferredSize(new Dimension(1,50));
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		flow.setHgap(15);
		panelSalesReportNorth.setLayout(flow);
		lblReportTypeSalesReport.setFont(font);
		panelSalesReportNorth.add(lblReportTypeSalesReport);
		rdoSales.setFont(font);
		panelSalesReportNorth.add(rdoSales);
		rdosalesReturn.setFont(font);
		panelSalesReportNorth.add(rdosalesReturn);
	}
	public void panelSalesReportCenter(){
		//panelItemReportCenter.setOpaque(false);
		panelSalesReportCenter.setLayout(new BorderLayout());
		panelSalesReportCenter.add(panelSalesReportCenterWest,BorderLayout.WEST);
		panelSalesReportCenterWest();
		panelSalesReportCenter.add(panelSalesReportCenterCenter,BorderLayout.CENTER);
		panelSalesReportCenterCenter();
	}
	public void panelSalesReportCenterWest(){
		//panelItemReportCenterWest.setOpaque(false);
		panelSalesReportCenterWest.setPreferredSize(new Dimension(200,1));
		GridBagLayout grid=new GridBagLayout();
		panelSalesReportCenterWest.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		chkProductWiseSalesReport.setFont(font1);
		panelSalesReportCenterWest.add(chkProductWiseSalesReport,cn);
		cn.gridx=0;
		cn.gridy=1;
		chkDateWiseSalesReport.setFont(font1);
		panelSalesReportCenterWest.add(chkDateWiseSalesReport,cn);
		cn.gridx=0;
		cn.gridy=2;
		chkSalesReturnNoWise.setFont(font1);
		panelSalesReportCenterWest.add(chkSalesReturnNoWise,cn);
	}
	public void panelSalesReportCenterCenter(){
		//panelItemReportCenterCenter.setOpaque(false);
		GridBagLayout grid=new GridBagLayout();
		panelSalesReportCenterCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(2,2,2,2);
		cn.gridx=0;
		cn.gridy=0;
		lblProductNameSalesReport.setFont(font1);
		panelSalesReportCenterCenter.add(lblProductNameSalesReport,cn);
		cn.gridx=1;
		cn.gridy=0;
		cmbProductNameSalesReport.setPreferredSize(new Dimension(150,25));
		panelSalesReportCenterCenter.add(cmbProductNameSalesReport,cn);
		cn.gridx=2;
		cn.gridy=0;
		chkProductNameSalesReportAll.setFont(font1);
		panelSalesReportCenterCenter.add(chkProductNameSalesReportAll,cn);
		cn.gridx=0;
		cn.gridy=1;
		lblFromDateSalesReport.setFont(font1);
		panelSalesReportCenterCenter.add(lblFromDateSalesReport,cn);
		cn.gridx=1;
		cn.gridy=1;
		panelSalesReportCenterCenter.add(dateFromDateSalesReport,cn);
		cn.gridx=0;
		cn.gridy=2;
		lblToDateSalesReport.setFont(font1);
		panelSalesReportCenterCenter.add(lblToDateSalesReport,cn);
		cn.gridx=1;
		cn.gridy=2;
		panelSalesReportCenterCenter.add(dateToDateSalesReport,cn);
		cn.gridx=0;
		cn.gridy=3;
		lblInvoicNoSalesReport.setFont(font1);
		panelSalesReportCenterCenter.add(lblInvoicNoSalesReport,cn);
		cn.gridx=1;
		cn.gridy=3;
		panelSalesReportCenterCenter.add(cmbInvoiceNoSalesReport,cn);
	}
	public void panelSalesReportSouth(){
		
		//panelItemReportSouth.setOpaque(false);
		panelSalesReportSouth.setPreferredSize(new Dimension(1,60));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(30);
		panelSalesReportSouth.setLayout(flow);
		panelSalesReportSouth.add(btnRefreshSalesReport);
		panelSalesReportSouth.add(btnPreviewSalesReport);
	}
	////..............................................................
	public void panelSouth(){
		panelSouth.setPreferredSize(new Dimension(1140,365));
		BorderLayout border=new BorderLayout();
		panelSouth.setLayout(border);
		border.setHgap(5);
		panelSouth.add(panelProductReport,BorderLayout.WEST);
		panelProductReport();
		panelSouth.add(panelStockReport,BorderLayout.CENTER);
		panelStockReport();
	}
	////...............................................................
	public void panelProductReport(){
		panelProductReport.setPreferredSize(new Dimension(570,1));
		TitledBorder panelproductReportTitle=new TitledBorder("Product Report");
		panelproductReportTitle.setTitleFont(new Font("Cooper Black",Font.BOLD,20));
		panelproductReportTitle.setTitleColor(Color.LIGHT_GRAY);
		panelproductReportTitle.setTitleJustification(TitledBorder.CENTER);
		panelProductReport.setBorder(panelproductReportTitle);
		BorderLayout border=new BorderLayout();
		panelProductReport.setLayout(border);
		panelProductReport.add(panelProductReportNorth,BorderLayout.NORTH);
		panelProductReportNorth();
		panelProductReport.add(panelProductReportCenter,BorderLayout.CENTER);
		panelProductReportCenter();
		panelProductReport.add(panelProductReportSouth,BorderLayout.SOUTH);
		panelProductReportSouth();
	}
	////....................................................................
	public void panelProductReportNorth(){
		//panelProductReportNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelProductReportNorth.setPreferredSize(new Dimension(1,50));
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		flow.setHgap(15);
		panelProductReportNorth.setLayout(flow);
		lblReportTypeProductReport.setFont(font);
		panelProductReportNorth.add(lblReportTypeProductReport);
		rdoOpeningStock.setFont(font);
		panelProductReportNorth.add(rdoOpeningStock);
		rdoWastageBroken.setFont(font);
		panelProductReportNorth.add(rdoWastageBroken);
	}
	public void panelProductReportCenter(){
		
		GridBagLayout grid=new GridBagLayout();
		panelProductReportCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(2,2,2,2);
		cn.gridx=0;
		cn.gridy=0;
		lblCatagoryNameProductReport.setFont(font1);
		panelProductReportCenter.add(lblCatagoryNameProductReport,cn);
		cn.gridx=1;
		cn.gridy=0;
		cmbCatagoryNameProductReport.setPreferredSize(new Dimension(250,25));
		panelProductReportCenter.add(cmbCatagoryNameProductReport,cn);
		cn.gridx=2;
		cn.gridy=0;
		chkChatagoryNameProductReportAll.setFont(font1);
		panelProductReportCenter.add(chkChatagoryNameProductReportAll,cn);//
		cn.gridx=0;
		cn.gridy=1;
		lblSubcatagoryNameProductReport.setFont(font1);
		panelProductReportCenter.add(lblSubcatagoryNameProductReport,cn);
		cn.gridx=1;
		cn.gridy=1;
		cmbSubcatagoryNameProductReport.setPreferredSize(new Dimension(250,25));
		panelProductReportCenter.add(cmbSubcatagoryNameProductReport,cn);
		cn.gridx=2;
		cn.gridy=1;
		chkSubcatagoryNameProductReportAll.setFont(font1);
		panelProductReportCenter.add(chkSubcatagoryNameProductReportAll,cn);//
		cn.gridx=0;
		cn.gridy=2;
		lblProductNameProductReport.setFont(font1);
		panelProductReportCenter.add(lblProductNameProductReport,cn);
		cn.gridx=1;
		cn.gridy=2;
		cmbProductNameProductReport.setPreferredSize(new Dimension(250,25));
		panelProductReportCenter.add(cmbProductNameProductReport,cn);
		cn.gridx=2;
		cn.gridy=2;
		chkProductNameProductReportAll.setFont(font1);
		panelProductReportCenter.add(chkProductNameProductReportAll,cn);//
		cn.gridx=0;
		cn.gridy=3;
		lblFromDateProductReport.setFont(font1);
		panelProductReportCenter.add(lblFromDateProductReport,cn);
		cn.gridx=1;
		cn.gridy=3;
		panelProductReportCenter.add(dateFromDateProductReport,cn);
		cn.gridx=0;
		cn.gridy=4;
		lblToDateProductReport.setFont(font1);
		panelProductReportCenter.add(lblToDateProductReport,cn);
		cn.gridx=1;
		cn.gridy=4;
		panelProductReportCenter.add(dateToDateProductReport,cn);
	}
	////...............................................................................
	public void panelProductReportSouth(){
		panelProductReportSouth.setPreferredSize(new Dimension(1,60));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(30);
		panelProductReportSouth.setLayout(flow);
		panelProductReportSouth.add(btnRefreshProductReport);
		panelProductReportSouth.add(btnPreviewProductReport);
	}
	////...............................................................................
	public void panelStockReport(){
		panelStockReport.setPreferredSize(new Dimension(570,1));
		TitledBorder panelStockReportTitle=new TitledBorder("Stock Report");
		panelStockReportTitle.setTitleFont(new Font("Cooper Black",Font.BOLD,20));
		panelStockReportTitle.setTitleColor(Color.LIGHT_GRAY);
		panelStockReportTitle.setTitleJustification(TitledBorder.CENTER);
		panelStockReport.setBorder(panelStockReportTitle);
		BorderLayout border=new BorderLayout();
		panelStockReport.setLayout(border);
		panelStockReport.add(panelStockReportNorth,BorderLayout.NORTH);
		panelStockReportNorth();
		panelStockReport.add(panelStockReportCenter,BorderLayout.CENTER);
		panelStockReportCenter();
		panelStockReport.add(panelStockReportSouth,BorderLayout.SOUTH);
		panelStockReportSouth();
	}
	public void panelStockReportNorth(){
		//panelStockReportNorth.setBorder(BorderFactory.createLoweredBevelBorder());
		panelStockReportNorth.setPreferredSize(new Dimension(1,50));
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		flow.setHgap(15);
		panelStockReportNorth.setLayout(flow);
		lblReportTypeStockReport.setFont(font);
		panelStockReportNorth.add(lblReportTypeStockReport);
		rdoStockSummery.setFont(font);
		panelStockReportNorth.add(rdoStockSummery);
		rdoStockDetails.setFont(font);
		panelStockReportNorth.add(rdoStockDetails);
	}
	public void panelStockReportCenter(){
		panelStockReportCenter.setLayout(new BorderLayout());
		panelStockReportCenter.add(panelStockReportCenterWest,BorderLayout.WEST);
		panelStockReportCenterWest();
		panelStockReportCenter.add(panelStockReportCenterCenter,BorderLayout.CENTER);
		panelStockReportCenterCenter();
	}
	public void panelStockReportCenterWest(){
		panelStockReportCenterWest.setPreferredSize(new Dimension(200,1));
		GridBagLayout grid=new GridBagLayout();
		panelStockReportCenterWest.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(5, 5, 5, 5);
		cn.gridx=0;
		cn.gridy=0;
		chkCatagoryWise.setFont(font1);
		panelStockReportCenterWest.add(chkCatagoryWise,cn);
		cn.gridx=0;
		cn.gridy=1;
		chkDateWiseStockReport.setFont(font1);
		panelStockReportCenterWest.add(chkDateWiseStockReport,cn);
		
	}
	public void panelStockReportCenterCenter(){
		GridBagLayout grid=new GridBagLayout();
		panelStockReportCenterCenter.setLayout(grid);
		GridBagConstraints cn=new GridBagConstraints();
		cn.fill=GridBagConstraints.BOTH;
		cn.insets=new Insets(2,2,2,2);
		cn.gridx=0;
		cn.gridy=0;
		lblCatagoryNameStockReport.setFont(font1);
		panelStockReportCenterCenter.add(lblCatagoryNameStockReport,cn);
		cn.gridx=1;
		cn.gridy=0;
		cmbCatagoryNameStockReport.setPreferredSize(new Dimension(150,25));
		panelStockReportCenterCenter.add(cmbCatagoryNameStockReport,cn);
		cn.gridx=2;
		cn.gridy=0;
		chkCatagoryNameStockReportAll.setFont(font1);
		panelStockReportCenterCenter.add(chkCatagoryNameStockReportAll,cn);//
		cn.gridx=0;
		cn.gridy=1;
		lblSubcatagoryNameStockReport.setFont(font1);
		panelStockReportCenterCenter.add(lblSubcatagoryNameStockReport,cn);
		cn.gridx=1;
		cn.gridy=1;
		panelStockReportCenterCenter.add(cmbSubCatagoryNameStockReport,cn);
		cn.gridx=2;
		cn.gridy=1;
		chkSubCatagoryNameStockReportAll.setFont(font1);
		panelStockReportCenterCenter.add(chkSubCatagoryNameStockReportAll,cn);//
		cn.gridx=0;
		cn.gridy=2;
		lblProductNameStockReport.setFont(font1);
		panelStockReportCenterCenter.add(lblProductNameStockReport,cn);
		cn.gridx=1;
		cn.gridy=2;
		panelStockReportCenterCenter.add(cmbProductNameStockReport,cn);
		cn.gridx=2;
		cn.gridy=2;
		chkProductNameStockReportAll.setFont(font1);
		panelStockReportCenterCenter.add(chkProductNameStockReportAll,cn);//
		cn.gridx=0;
		cn.gridy=3;
		lblFromDateStockReport.setFont(font1);
		panelStockReportCenterCenter.add(lblFromDateStockReport,cn);
		cn.gridx=1;
		cn.gridy=3;
		panelStockReportCenterCenter.add(dateFromDateStockReport,cn);
		cn.gridx=0;
		cn.gridy=4;
		lblToDateStockReport.setFont(font1);
		panelStockReportCenterCenter.add(lblToDateStockReport,cn);
		cn.gridx=1;
		cn.gridy=4;
		panelStockReportCenterCenter.add(dateToDateStockReport,cn);
	}
	////.................................................................................
	public void panelStockReportSouth(){
		panelStockReportSouth.setPreferredSize(new Dimension(1,60));
		FlowLayout flow=new FlowLayout();
		flow.setHgap(30);
		panelStockReportSouth.setLayout(flow);
		panelStockReportSouth.add(btnRefreshStockReport);
		panelStockReportSouth.add(btnPreviewStockReport);
	}
	////..................................................................................
	public void cmp(){
		add(panelCenter,BorderLayout.CENTER);
		panelCenter();
		add(panelSouth,BorderLayout.SOUTH);
		panelSouth();
	}
	public void init(){
		setPreferredSize(new Dimension(1140,740));
		BorderLayout border=new BorderLayout();
		border.setVgap(5);
		setLayout(border);
	}
}
