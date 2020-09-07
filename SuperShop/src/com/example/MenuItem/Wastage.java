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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.StringTokenizer;
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

public class Wastage extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	SuggestText stsearch=new SuggestText();
	
	JLabel lblwastageno=new JLabel("Wastage No");
	JLabel lblproduct=new JLabel("Product ID");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Subcatagory");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblproducttype=new JLabel("Product Type");
	JLabel lblunit=new JLabel("Unit");
	JLabel lbldate=new JLabel("Date");
	JLabel lblwastageorbrokenqty=new JLabel("Wastage/Broken Quantity");
	JLabel lbldealerprice=new JLabel("Dealer Price");
	JLabel lblamount=new JLabel("Amount");
	JLabel lblreason=new JLabel("Reason");
	JLabel lblusername=new JLabel("User Name");
	JLabel lblexecutive=new JLabel("Executive");

	SuggestText stproducttype=new SuggestText();
	SuggestText stcatagory=new SuggestText();
	SuggestText stsubcatagory=new SuggestText();
	SuggestText stproductID=new SuggestText();
	SuggestText stsuppliername=new SuggestText();

	JTextField txtwastageno=new JTextField(15);
	JTextField txttotalstock=new JTextField(15);
	JTextField txtwastageorbrokenqty=new JTextField(15);
	JTextField txtamount=new JTextField(15);
	JTextField txtcause=new JTextField(15);
	JTextField txtusername=new JTextField(15);
	JTextField txtunit=new JTextField(15);
	JTextField txtusertype=new JTextField(15);
	JTextField txtdealerprice=new JTextField(15);
    JTextArea txtarea=new JTextArea(3,6);
    JScrollPane scrolarea=new JScrollPane(txtarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	JDateChooser dDatechooer=new JDateChooser();
	
	JButton btnadd=new JButton("Add");
	JButton btnedit=new JButton("Edit");
	JButton btnrefresh=new JButton("Refresh");
	JButton btndelete=new JButton("Delete");

    Object row[][]={};	
    String col[]={"Wastage No","Product Name","Wastage Quantity","Date"};
    DefaultTableModel model=new DefaultTableModel(row,col);
    JTable table=new JTable(model);
    JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
    DecimalFormat df=new DecimalFormat("#0.00");

	public Wastage(){
		init();
		cmp();
		btnAction();
	}
    
	private boolean checkValidation(){
		if(!txtwastageno.getText().trim().isEmpty()){
			if(!stproducttype.txtSuggest.getText().trim().isEmpty()){
				if(!stcatagory.txtSuggest.getText().trim().isEmpty()){
					if(!stsubcatagory.txtSuggest.getText().trim().isEmpty()){
						if(!stproductID.txtSuggest.getText().trim().isEmpty()){
							if(!txttotalstock.getText().trim().isEmpty()){
								if(!dDatechooer.getDate().toString().trim().isEmpty()){
									if(!txtwastageorbrokenqty.getText().trim().isEmpty()){
										if(!txtdealerprice.getText().trim().isEmpty()){
											if(!txtamount.getText().trim().isEmpty()){
												if(!txtcause.getText().trim().isEmpty()){
													if(!txtusername.getText().trim().isEmpty()){
														if(!txtunit.getText().trim().isEmpty()){
															if(!stsuppliername.txtSuggest.getText().trim().isEmpty()){
																if(!txtusertype.getText().trim().isEmpty()){
																	return true;
																}
																else{
																	JOptionPane.showMessageDialog(null,"Please insert user type");
																}
															}
															else{
																JOptionPane.showMessageDialog(null,"Please insert Supplier Name");
															}
														}
														else{
															JOptionPane.showMessageDialog(null,"Please insert Unit");
														}
													}
													else{
														JOptionPane.showMessageDialog(null,"Please insert User Name");
													}
												}
												else{
													JOptionPane.showMessageDialog(null,"Please insert Cause");
												}
											}
											else{
												JOptionPane.showMessageDialog(null,"Please insert Amount");
											}
										}
										else{
											JOptionPane.showMessageDialog(null,"Please insert Dealer Price");
										}
									}
									else{
										JOptionPane.showMessageDialog(null,"Please insert Wastage or Broken Qty");
									}
								}
								else{
									JOptionPane.showMessageDialog(null,"Please insert Date");
								}
							}
							else{
								JOptionPane.showMessageDialog(null,"Please insert Total Stock");
							}
						}
						else{
							JOptionPane.showMessageDialog(null,"Please insert ProductID");
						}
					}
					else{
						JOptionPane.showMessageDialog(null,"Please insert Sub Catagory");
					}
				}
				else{
					JOptionPane.showMessageDialog(null,"Please insert Catagory");
				}
			}
			else{
				JOptionPane.showMessageDialog(null,"Please insert Product Type");
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"Please insert Wastage");
		}
		return false;
	}
	 
	private void txtClear(){
		txtwastageno.setText("");
		stproducttype.txtSuggest.setText("");
		stcatagory.txtSuggest.setText("");
		stsubcatagory.txtSuggest.setText("");
		stproductID.txtSuggest.setText("");
		txttotalstock.setText("");
		dDatechooer.setDate(new Date());
		txtwastageorbrokenqty.setText("");
		txtdealerprice.setText("");
		txtamount.setText("");
		txtcause.setText("");
		txtusername.setText("");
		txtunit.setText("");
		stsuppliername.txtSuggest.setText("");
		txtusertype.setText("");
		stsearch.txtSuggest.setText("");
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
			JOptionPane.showMessageDialog(null,exp);
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
	public void ProductDataLoad(){
		try{
			String sql="select ProductID,ProductName from tbproductinfo";
			stproductID.vector.removeAllElements();
			stproductID.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stproductID.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	public void SupplierDataLoad(){
		try{
			String sql="select SupplierID,SupplierName from tbsupplierinfo";
			stsuppliername.vector.removeAllElements();
			stsuppliername.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stsuppliername.vector.add(rs.getString("SupplierID")+" # "+rs.getString("SupplierName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	
	private void calAmount(){
		double Qty,rate,amount;
		Qty=Double.parseDouble(txtwastageorbrokenqty.getText().trim().isEmpty()?
				"0":txtwastageorbrokenqty.getText().trim());
		rate=Double.parseDouble(txtdealerprice.getText().trim().isEmpty()?
				"0":txtdealerprice.getText().trim());
		amount=Qty*rate;
		txtamount.setText(df.format(amount));
	}
	private void btnAction() {
		txtwastageorbrokenqty.addKeyListener(new KeyListener(){
			
			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
				calAmount();
			}
		});
		
		txtdealerprice.addKeyListener(new KeyListener(){

			public void keyTyped(KeyEvent e) {
				
			}
			public void keyPressed(KeyEvent e) {
				
			}
			public void keyReleased(KeyEvent e) {
				calAmount();
			}
		});
		
		btnadd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidation()){
					
				}
			}	
		});
		
		btnedit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}	
		});
		
		btnrefresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClear();
			}	
		});
		
		btndelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}	
		});

	}

	private void cmp() {
		add(panelWest,BorderLayout.WEST);
		PanelWestWork();
		add(panelCenter,BorderLayout.CENTER);
		PanelCenterWork();
	}

	private void PanelCenterWork() {
		
       panelCenter.setPreferredSize(new Dimension(575,750));
       panelCenter.setBorder(BorderFactory.createTitledBorder(""));
       FlowLayout flow=new FlowLayout();
       panelCenter.setLayout(flow);
       panelCenter.add(scroll);
       scroll.setPreferredSize(new Dimension(540,700));
    
	}

	private void PanelWestWork() {
	   panelWest.setPreferredSize(new Dimension(560,740));	
       panelWest.setBorder(BorderFactory.createTitledBorder(""));
       panelWest.setLayout(new BorderLayout());
	   panelWest.add(panelWestNorth,BorderLayout.NORTH);
	   PanelWestNorthWork();
	   panelWest.add(panelWestCenter,BorderLayout.CENTER);
	   PanelWestCenterWork();
	   panelWest.add(panelWestSouth,BorderLayout.SOUTH);
	   PanelWestSouthWork();
	}

	private void PanelWestSouthWork() {
		panelWestSouth.setPreferredSize(new Dimension(560,70));
		panelWestSouth.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		
		flow.setVgap(5);
		flow.setHgap(30);
		
		panelWestSouth.add(btnadd);
		panelWestSouth.add(btnedit);
		panelWestSouth.add(btnrefresh);
		panelWestSouth.add(btndelete);
		
		btnadd.setForeground(Color.MAGENTA);
		btnadd.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
		btnadd.setPreferredSize(new Dimension(70,40));
		
		btnedit.setForeground(Color.MAGENTA);
		btnedit.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
		btnedit.setPreferredSize(new Dimension(70,40));

		btnrefresh.setForeground(Color.MAGENTA);
		btnrefresh.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
		btnrefresh.setPreferredSize(new Dimension(80,40));

		btndelete.setForeground(Color.MAGENTA);
		btndelete.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
		btndelete.setPreferredSize(new Dimension(70,40));	
	}

	private void PanelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(550,520));
		//panelwestcenter.setBorder(BorderFactory.createTitledBorder(""));
		
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenter.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestCenter.add(lblwastageno,c);
		lblwastageno.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelWestCenter.add(txtwastageno,c);
		//txtwastageno.setPreferredSize(new Dimension(20,10));
		c.gridx=0;
		c.gridy=1;
		panelWestCenter.add(lblproduct,c);//lblproducttype
		lblproduct.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelWestCenter.add(stproductID.cmbSuggest,c);
		c.gridx=0;
		c.gridy=2;
		panelWestCenter.add(lblcatagory,c);
		lblcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelWestCenter.add(stcatagory.cmbSuggest,c);
		c.gridx=0;
		c.gridy=3;
		panelWestCenter.add(lblsubcatagory,c);
		lblsubcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelWestCenter.add(stsubcatagory.cmbSuggest,c);
		c.gridx=0;
		c.gridy=4;
		panelWestCenter.add(lblsuppliername,c);
		lblsuppliername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=4;
		panelWestCenter.add(stsuppliername.cmbSuggest,c);
		c.gridx=0;
		c.gridy=5;
		panelWestCenter.add(lblproducttype,c);
		lblproducttype.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=5;
		panelWestCenter.add(stproducttype.cmbSuggest,c);
		c.gridx=0;
		c.gridy=6;
		panelWestCenter.add(lblunit,c);
		lblunit.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=6;
		panelWestCenter.add(txtunit,c);
		c.gridx=0;
		c.gridy=7;
		panelWestCenter.add(lbldate,c);
		lbldate.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=7;
		panelWestCenter.add(dDatechooer,c);
		c.gridx=0;
		c.gridy=8;
		panelWestCenter.add(lblwastageorbrokenqty,c);
		lblwastageorbrokenqty.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=8;
		panelWestCenter.add(txtwastageorbrokenqty,c);
		c.gridx=0;
		c.gridy=9;
		panelWestCenter.add(lbldealerprice,c);
		lbldealerprice.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=9;
		panelWestCenter.add(txtdealerprice,c);
		c.gridx=0;
		c.gridy=10;
		panelWestCenter.add(lblamount,c);
		lblamount.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=10;
		panelWestCenter.add(txtamount,c);
		c.gridx=0;
		c.gridy=11;
		panelWestCenter.add(lblreason,c);
		lblreason.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=11;
		panelWestCenter.add(scrolarea,c);
		txtarea.setLineWrap(true);
		c.gridx=0;
		c.gridy=12;
		panelWestCenter.add(lblusername,c);
		lblusername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=12;
		panelWestCenter.add(txtusername,c);
		c.gridx=2;
		c.gridy=12;
		panelWestCenter.add(lblexecutive, c);
		lblexecutive.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void PanelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(575,120));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		JButton btnsearch=new JButton("Search");
		
		FlowLayout flow=new FlowLayout();
		flow.setVgap(30);
		flow.setHgap(30);
		panelWestNorth.setLayout(flow);
		panelWestNorth.add(stsearch.cmbSuggest);
		stsearch.cmbSuggest.setPreferredSize(new Dimension(300,40));
		panelWestNorth.add(btnsearch);
		btnsearch.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		btnsearch.setPreferredSize(new Dimension(100,40));
	}

	private void init() {
       setPreferredSize(new Dimension(1150,750));
       setBorder(BorderFactory.createTitledBorder(""));
       setLayout(new BorderLayout());
	}

}
