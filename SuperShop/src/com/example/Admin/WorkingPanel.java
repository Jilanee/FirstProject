package com.example.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.example.MenuItem.Broken;
import com.example.MenuItem.Catagory;
import com.example.MenuItem.ChangePassword;
import com.example.MenuItem.ClientInfo;
import com.example.MenuItem.Exit;
import com.example.MenuItem.ItemReceipt;
import com.example.MenuItem.LogOff;
import com.example.MenuItem.NewUser;
import com.example.MenuItem.OpeningStock;
import com.example.MenuItem.ProductInfo;
//import com.example.MenuItem.ReceptReturn;
import com.example.MenuItem.Salse;
import com.example.MenuItem.SalseReturn;
import com.example.MenuItem.SetupReport;
import com.example.MenuItem.SupplierInfo;
import com.example.MenuItem.TaskReport;
import com.example.MenuItem.Update;
import com.example.MenuItem.Wastage;

public class WorkingPanel extends JPanel{

	Catagory catagory=new Catagory();
	SupplierInfo sup=new SupplierInfo();
	ProductInfo product=new ProductInfo();
	ClientInfo client=new ClientInfo();
	SetupReport setupReport=new SetupReport();
	TaskReport taskReport=new TaskReport();
	NewUser newUser=new NewUser();
	ChangePassword changePass=new ChangePassword();
	OpeningStock openingStock=new OpeningStock();
	ItemReceipt itemReceipt=new ItemReceipt();
	//ReceptReturn receiptReturn=new ReceptReturn();
	Broken broken=new Broken();
	Salse sales=new Salse();
	SalseReturn salesReturn=new SalseReturn();
	Wastage wastage=new Wastage();
	LogOff logOff=new LogOff();
	Update update=new Update();
	Exit exit=new Exit();

	JPanel panelWest=new JPanel();
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelCenter=new JPanel();

	JButton btnSetup=new JButton("Setup");
	JButton btnSecurity=new JButton("Security");
	JButton btnTask=new JButton("Task");
	JButton btnReport=new JButton("Report");
	JButton btnOthers=new JButton("Others");

	JPanel panelSetup=new JPanel();
	JPanel panelSecurity=new JPanel();
	JPanel panelTask=new JPanel();
	JPanel panelReport=new JPanel();
	JPanel panelOthers=new JPanel();

	JButton btnCatagory=new JButton(new ImageIcon("Images/catagory.png"));             //Setup
	JButton btnSupplierInfo=new JButton(new ImageIcon("Images/supplierInfo.png"));
	JButton btnProductInfo=new JButton(new ImageIcon("Images/ProductInfo.png"));
	JButton btnClientInfo=new JButton(new ImageIcon("Images/Client.png"));

	JButton btnNewUser=new JButton(new ImageIcon("Images/Newuser.png"));           //Security
	JButton btnChangePassword=new JButton(new ImageIcon("Images/change-password.png"));

	JButton btnOpeningStock=new JButton(new ImageIcon("Images/stock.png"));       //Task
	JButton btnItemReceipt=new JButton(new ImageIcon("Images/ItemRecipt.png"));  
	JButton btnSales=new JButton(new ImageIcon("Images/sales.png"));
	JButton btnSalesReturn=new JButton(new ImageIcon("Images/salesreturn.png"));
	JButton btnWastage=new JButton(new ImageIcon("Images/wastage.png"));
	JButton btnBroken=new JButton(new ImageIcon("Images/Broken.png"));

	JButton btnSetupReport=new JButton(new ImageIcon("Images/setup.png"));       //Report
	JButton btnTaskReport=new JButton(new ImageIcon("Images/taskReport.png"));

	JButton btnUpdate=new JButton(new ImageIcon("Images/update.png"));              //Others
	JButton btnLogOff=new JButton(new ImageIcon("Images/logoff.png"));
	JButton btnExit=new JButton(new ImageIcon("Images/exit.png"));

	JSplitPane split_task=new JSplitPane(JSplitPane.VERTICAL_SPLIT,btnTask,null);

	public WorkingPanel(){

		cmp();
		btnAction();
	}

	private void btnAction(){

		btnSetup.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sidePanelTrueFalse();
				panelSetup.setVisible(true);
			}
		});
		btnSecurity.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sidePanelTrueFalse();
				panelSecurity.setVisible(true);
			}
		});
		btnTask.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sidePanelTrueFalse();
				panelTask.setVisible(true);
			}
		});
		btnReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sidePanelTrueFalse();
				panelReport.setVisible(true);
			}
		});
		btnOthers.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				sidePanelTrueFalse();
				panelOthers.setVisible(true);
			}
		});

		btnCatagory.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				catagory.setVisible(true);
				catagory.autoIdCat();
				catagory.autoIdSubCat();
				catagory.tableDataLoadCatagory();
				catagory.tableDataLoadSubCatagory();
				catagory.cmbSearchCatagoryDataLoad();
				catagory.cmbSubCatagoryDataLoad();
				catagory.cmbSearchSubCatagoryDataLoad();
			}
		});

		btnSupplierInfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				sup.setVisible(true);
				sup.autoId();
				sup.TableDataLoad();
		        sup.SuggestTextDataLoad();
			}
		});

		btnProductInfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				product.setVisible(true);
				product.AutoIDProductInfo();
				product.tableDataLoad();
				product.cmbSearchDataLoad();
				product.CatagoryDataload();
				product.SubCatagoryDataLoad();
				product.SupplierDataLoad();
			}
		});

		btnClientInfo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				client.setVisible(true);
				client.AutoIdClient();
				client.tableDataLoad();
			    client.SuggestTextDataLoad();
			}
		});
		btnNewUser.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				newUser.setVisible(true);
				newUser.autoID();
				newUser.tableDataLoad();
				newUser.SuggestTextDataLoad();
				//newUser.TableDataLoad();
			}
		});
		btnChangePassword.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				changePass.setVisible(true);
			}
		});
		btnOpeningStock.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				openingStock.setVisible(true);
				openingStock.AutoID();
				openingStock.CatagoryDataLoad();
				openingStock.SubCatagoryDataLoad();
				openingStock.ProductDataLoad();
				openingStock.SupplierDataLoad();
				openingStock.tableDataLoad();
			}
		});
		btnItemReceipt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				itemReceipt.setVisible(true);
				itemReceipt.CatagoryDataLoad();
				itemReceipt.SubCatagoryDataLoad();
				itemReceipt.ProductIDDataLoad();
				itemReceipt.SupplierDataLoad();
			}
		});
		btnSales.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				sales.setVisible(true);
				sales.ClientDataLoad();
				sales.CatagoryDataLoad();
				sales.SubCatagoryDataLoad();
				sales.ProductIDDataLoad();
			}
		});
		btnSalesReturn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				salesReturn.setVisible(true);
				salesReturn.CatagoryDataLoad();
				salesReturn.SubCatagoryDataLoad();
				salesReturn.ProductIDDataLoad();
			}
		});
		btnWastage.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				wastage.setVisible(true);
				wastage.CatagoryDataLoad();
				wastage.SubCatagoryDataLoad();
				wastage.ProductDataLoad();
				wastage.SupplierDataLoad();
			}
		});
		
		btnBroken.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				broken.setVisible(true);
			}
		});
		
		btnSetupReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				setupReport.setVisible(true);
				setupReport.SupplierDataLoad();
				setupReport.UserDataLoad();
				setupReport.ProductDataLoad();
				setupReport.ClientDataLoad();
			}
		});
		btnTaskReport.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				taskReport.setVisible(true);
			}
		});
		btnUpdate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				update.setVisible(true);
			}
		});
		btnLogOff.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				logOff.setVisible(true);
			}
		});

		btnExit.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				panelCenterTrueFalse();
				exit.setVisible(true);
			}
		});
	}

	private void cmp(){
		setLayout(new BorderLayout());
		add(panelWest,BorderLayout.WEST);
		panelWestWork();
		add(panelCenter,BorderLayout.CENTER);
		panelCenterWork();
	}

	private void panelCenterWork() {

		FlowLayout flow=new FlowLayout();
		panelCenter.setLayout(flow);
		flow.setVgap(1);
		panelCenter.add(catagory);
		panelCenter.add(sup);
		panelCenter.add(product);
		panelCenter.add(client);
		panelCenter.add(setupReport);
		panelCenter.add(taskReport);
		panelCenter.add(newUser);
		panelCenter.add(changePass);
		panelCenter.add(openingStock);
		panelCenter.add(itemReceipt);
		//panelCenter.add(receiptReturn);
		panelCenter.add(sales);
		panelCenter.add(salesReturn);
		panelCenter.add(wastage);
		panelCenter.add(update);
		panelCenter.add(exit);
		panelCenter.add(logOff);
		
        panelCenterTrueFalse();
	}

	private void panelCenterTrueFalse() {
		catagory.setVisible(false);
		sup.setVisible(false);
		product.setVisible(false);
		client.setVisible(false);
		setupReport.setVisible(false);
		taskReport.setVisible(false);
		newUser.setVisible(false);
		changePass.setVisible(false);
		openingStock.setVisible(false);
		itemReceipt.setVisible(false);
		//receiptReturn.setVisible(false);
		sales.setVisible(false);
		salesReturn.setVisible(false);
		wastage.setVisible(false);
		update.setVisible(false);
		exit.setVisible(false);
		logOff.setVisible(false);
	}

	private void sidePanelTrueFalse(){
		panelSetup.setVisible(false);
		panelSecurity.setVisible(false);
		panelTask.setVisible(false);
		panelReport.setVisible(false);
		panelOthers.setVisible(false);
	}

	private void panelWestWork() {

		panelWest.setPreferredSize(new Dimension(220,0));
		panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthWork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterWork();
	}

	private void panelWestCenterWork() {
		panelWestCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		flow.setVgap(0);
		panelWestCenter.setLayout(flow);
		panelWestCenter.add(panelSetup);
		panelSetupWork();
		panelWestCenter.add(panelSecurity);
		panelSecurityWork();
		panelWestCenter.add(panelTask);
		panelTaskWork();
		panelWestCenter.add(panelReport);
		panelReportWork();
		panelWestCenter.add(panelOthers);
		panelOthersWork();
		sidePanelTrueFalse();
		panelSetup.setVisible(true);
	}

	private void panelOthersWork() {
		panelOthers.setBackground(Color.CYAN);
		panelOthers.setPreferredSize(new Dimension(220,610));

		JLabel lblUpdate=new JLabel("Update");
		JLabel lblLogOff=new JLabel("Log Off");
		JLabel lblExit=new JLabel("Exit");

		GridBagConstraints c=new GridBagConstraints();
		panelOthers.setLayout(new GridBagLayout());

		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=0;
		panelOthers.add(btnUpdate,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(5, 30, 5, 5);
		panelOthers.add(lblUpdate,c);
		lblUpdate.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblUpdate.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnLogOff,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(5, 30, 5, 5);
		panelOthers.add(lblLogOff,c);
		lblLogOff.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblLogOff.setForeground(Color.black);

		c.gridx=0;
		c.gridy=4;
		c.insets=new Insets(5, 5, 5, 5);
		panelOthers.add(btnExit,c);

		c.gridx=0;
		c.gridy=5;
		c.insets=new Insets(5, 40, 5, 5);
		panelOthers.add(lblExit,c); 
		lblExit.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblExit.setForeground(Color.black);
	}

	private void panelReportWork() {
		panelReport.setBackground(Color.GREEN);
		panelReport.setPreferredSize(new Dimension(220,610));

		JLabel lblSetupReport=new JLabel("Setup Report");
		JLabel lblTaskReport=new JLabel("Task Report");

		GridBagConstraints c=new GridBagConstraints();
		panelReport.setLayout(new GridBagLayout());

		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=0;
		panelReport.add(btnSetupReport,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(5, 15, 5, 5);
		panelReport.add(lblSetupReport,c);
		lblSetupReport.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblSetupReport.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(5, 5, 5, 5);
		panelReport.add(btnTaskReport,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(5, 20, 5, 5);
		panelReport.add(lblTaskReport,c);
		lblTaskReport.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblTaskReport.setForeground(Color.black);
	}

	private void panelTaskWork() {
		panelTask.setBackground(Color.MAGENTA);
		panelTask.setPreferredSize(new Dimension(220,610));

		JLabel lblOpeningStock=new JLabel("Opening Stock");
		JLabel lblItemReceipt=new JLabel("Item Receipt");
		JLabel lblSales=new JLabel("Sales");
		JLabel lblSalesReturn=new JLabel("Sales Return");
		JLabel lblWastage=new JLabel("Wastage");
		//JLabel lblBroken=new JLabel("Broken");

		GridBagConstraints c=new GridBagConstraints();
		panelTask.setLayout(new GridBagLayout());

		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=0;
		panelTask.add(btnOpeningStock,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(5, 20, 5, 5);
		panelTask.add(lblOpeningStock,c);
		lblOpeningStock.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblOpeningStock.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(5, 5, 5, 5);
		panelTask.add(btnItemReceipt,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(5, 30, 5, 5);
		panelTask.add(lblItemReceipt,c);
		lblItemReceipt.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblItemReceipt.setForeground(Color.black);

		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=4;
		panelTask.add(btnSales,c);

		c.gridx=0;
		c.gridy=5;
		c.insets=new Insets(5,50, 5, 5);
		panelTask.add(lblSales,c);
		lblSales.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblSales.setForeground(Color.black);

		c.gridx=0;
		c.gridy=6;
		c.insets=new Insets(5, 5, 5, 5);
		panelTask.add(btnSalesReturn,c);

		c.gridx=0;
		c.gridy=7;
		c.insets=new Insets(5, 25, 5, 5);
		panelTask.add(lblSalesReturn,c);
		lblSalesReturn.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblSalesReturn.setForeground(Color.black);

		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=8;
		panelTask.add(btnWastage,c);

		c.gridx=0;
		c.gridy=9;
	    c.insets=new Insets(5,45, 5, 5);
		panelTask.add(lblWastage,c);
		lblWastage.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblWastage.setForeground(Color.black);
	/*	c.gridx=0;
		c.gridy=10;
		c.insets=new Insets(5, 5, 5, 5);
		panelTask.add(btnBroken,c);

		c.gridx=0;
		c.gridy=11;
		c.insets=new Insets(5, 50, 5, 5);
		panelTask.add(lblBroken,c);
		lblBroken.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblBroken.setForeground(Color.BLACK);
		*/
	}

	private void panelSecurityWork() {
		panelSecurity.setBackground(Color.PINK);
		panelSecurity.setPreferredSize(new Dimension(220,610));

		JLabel lblNewUser=new JLabel("New User");
		JLabel lblChangePassword=new JLabel("Change Password");

		GridBagConstraints c=new GridBagConstraints();
		panelSecurity.setLayout(new GridBagLayout());

		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5, 5);
		c.gridx=0;
		c.gridy=0;
		panelSecurity.add(btnNewUser,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(5, 40, 5, 5);
		panelSecurity.add(lblNewUser,c);
		lblNewUser.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblNewUser.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(5, 5, 5, 5);
		panelSecurity.add(btnChangePassword,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(5, 12, 5, 5);
		panelSecurity.add(lblChangePassword,c);
		lblChangePassword.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblChangePassword.setForeground(Color.black);
	}

	private void panelSetupWork() {
		panelSetup.setBackground(Color.yellow);
		panelSetup.setPreferredSize(new Dimension(220,610));

		JLabel lblCatagory=new JLabel("Catagory");
		JLabel lblSupplierInfo=new JLabel("Supplier Info");
		JLabel lblProductInfo=new JLabel("ProductInfo");
		JLabel lblClientInfo=new JLabel("Client Info");

		GridBagConstraints c=new GridBagConstraints();
		panelSetup.setLayout(new GridBagLayout());

		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2, 2, 2, 2);
		c.gridx=0;
		c.gridy=0;
		panelSetup.add(btnCatagory,c);

		c.gridx=0;
		c.gridy=1;
		c.insets=new Insets(2, 35, 2, 2);
		panelSetup.add(lblCatagory,c);
		lblCatagory.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblCatagory.setForeground(Color.black);

		c.gridx=0;
		c.gridy=2;
		c.insets=new Insets(5,5,5,5);
		panelSetup.add(btnSupplierInfo,c);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(2, 35, 2, 2);
		panelSetup.add(lblSupplierInfo,c);
		lblSupplierInfo.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblSupplierInfo.setForeground(Color.BLACK);

		c.gridx=0;
		c.gridy=3;
		c.insets=new Insets(2,35,2,2);
		panelSetup.add(lblSupplierInfo,c);
		lblSupplierInfo.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblSupplierInfo.setForeground(Color.black);

		c.gridx=0;
		c.gridy=4;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnClientInfo,c);

		c.gridx=0;
		c.gridy=5;
		c.insets=new Insets(5, 38, 5, 5);
		panelSetup.add(lblClientInfo,c); 
		lblClientInfo.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblClientInfo.setForeground(Color.black);
		/*1*/
		c.gridx=0;
		c.gridy=6;
		c.insets=new Insets(5, 5, 5, 5);
		panelSetup.add(btnProductInfo,c);

		c.gridx=0;
		c.gridy=7;
		c.insets=new Insets(5, 25, 5, 5);
		panelSetup.add(lblProductInfo,c);
		lblProductInfo.setFont(new Font("Agency FB",Font.PLAIN,20));
		lblProductInfo.setForeground(Color.black);
	}

	private void panelWestNorthWork() {
		panelWestNorth.setLayout(new GridLayout(5,1));
		panelWestNorth.add(btnSetup);
		panelWestNorth.add(btnSecurity);
		panelWestNorth.add(btnTask);
		panelWestNorth.add(btnReport);
		panelWestNorth.add(btnOthers);
	}

}