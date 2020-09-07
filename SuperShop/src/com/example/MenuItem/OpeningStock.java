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
import java.text.SimpleDateFormat;
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

public class OpeningStock extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	SuggestText stCatagory=new SuggestText();
	SuggestText stSubCatagory=new SuggestText();
	SuggestText stProductID=new SuggestText();
	SuggestText stSupplierName=new SuggestText();
	SuggestText stsearch=new SuggestText();

	JDateChooser dcExpireDate=new JDateChooser();
	JDateChooser dcStockDate=new JDateChooser();

	JLabel lblstockid=new JLabel("Stock ID");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("SubCatagory");
	JLabel lblproductid=new JLabel("Product ID");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblstockqty=new JLabel("Stock Quantity");
	JLabel lblexpiredate=new JLabel("Expire Date");
	JLabel lblstockdate=new JLabel("Stock Date");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblusername=new JLabel("User Name");
		
	JTextField txtstockid=new JTextField(15);
	JTextField txtunit=new JTextField(15);
	JTextField txtstockqty=new JTextField(15);
	JTextField txtusername=new JTextField(15);

	JButton btnAdd=new JButton("Add");
	JButton btnEdit=new JButton("Edit");
	JButton btnRefresh=new JButton("Refresh");
	JButton btnDelete=new JButton("Delete");
	
	String column[]={"Stock ID","Stock Quentity","Stock Date",};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	SimpleDateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
	public OpeningStock(){	
		init();
		cmp();
		btnAction();
	}
	
	public void AutoID(){
		
			String sql="select ifnull(max(cast(subString(stockid,locate('-',stockid)+1,"
					+ "length(stockid)-locate('-',stockid)) as unsigned)),0)+1 stockid "
					+ "from tbopeningstock";
			try{
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				String stockid=rs.getString("stockid");
				txtstockid.setText("SI-"+stockid);
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, null);
		}
	}
	
	private boolean checkVlidation(){
		if(!txtstockid.getText().trim().isEmpty()){
			if(!stCatagory.txtSuggest.getText().trim().isEmpty()){
				if(!stSubCatagory.txtSuggest.getText().trim().isEmpty()){
					if(!stProductID.txtSuggest.getText().trim().isEmpty()){
						if(!txtunit.getText().trim().isEmpty()){
							if(!txtstockqty.getText().trim().isEmpty()){
								if(!dcExpireDate.getDate().toString().trim().isEmpty()){
									if(!dcStockDate.getDate().toString().trim().isEmpty()){
										if(!stSupplierName.txtSuggest.getText().trim().isEmpty()){
											if(!txtusername.getText().trim().isEmpty()){
												return true;
											}
											else{
												JOptionPane.showMessageDialog(null," Please Insert User Name");
											}
										}
										else{
											JOptionPane.showMessageDialog(null," Please Insert Supplier Name");
										}
									}
									else{
										JOptionPane.showMessageDialog(null," Please Insert Stock Date");
									}
								}
								else{
									JOptionPane.showMessageDialog(null," Please Insert Expaire Date");
								}
							}
							else{
								JOptionPane.showMessageDialog(null," Please Insert Stock Quantity");
							}
						}
						else{
							JOptionPane.showMessageDialog(null," Please Insert Unit");
						}
					}
					else{
						JOptionPane.showMessageDialog(null," Please Insert Product ID");
					}
				}
				else{
					JOptionPane.showMessageDialog(null," Please Insert SubCatagory");
				}
			}
			else{
				JOptionPane.showMessageDialog(null," Please Insert Catagory");
			}
		}
		else{
			JOptionPane.showMessageDialog(null," Please Insert Stock ID");
		}
		return false;
	}
	
	private boolean isExistOpeningStockID(){
		try{
			String sql="select * from tbopeningstock "
			+ "where stockid='"+txtstockid.getText().trim()+"'";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				return true;
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
		return false;
	}
	
	private boolean checkConfirmation(){
		int a=JOptionPane.showConfirmDialog(null,"Sure to Save?","Confirmation",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	private boolean insertData(){
		
		String catidname=stCatagory.txtSuggest.getText().trim();
		StringTokenizer tokencat=new StringTokenizer(catidname,"#");
		
		String subcatidname=stSubCatagory.txtSuggest.getText().trim();
		StringTokenizer tokensubcat=new StringTokenizer(subcatidname,"#");
		
		String productidname=stProductID.txtSuggest.getText().trim();
		StringTokenizer tokenproduct=new StringTokenizer(productidname,"");
		
		String supidname=stSupplierName.txtSuggest.getText().trim();
		StringTokenizer tokensup=new StringTokenizer(supidname,"#");
		
		String sql="insert into tbopeningstock(stockid,catid,catname,"
				+ "subcatid,subcatname,productid,productname,unit,"
				+ "stockquantity,Expiredate,Stockdate,supplierid,"
				+ "suppliername,username,userip,entrytime)values"
				+ "('"+txtstockid.getText().trim()+"',"
				+ "'"+tokencat.nextToken()+"',"
				+ "'"+tokencat.nextToken()+"',"
				+ "'"+tokensubcat.nextToken()+"',"
				+ "'"+tokensubcat.nextToken()+"',"
				+ "'"+tokenproduct.nextToken()+"',"
				+ "'"+tokenproduct.nextToken()+"',"
				+ "'"+txtunit.getText().trim()+"',"
				+ "'"+txtstockqty.getText().trim()+"',"
				+ "'"+dformat.format(dcExpireDate.getDate())+"',"
				+ "'"+dformat.format(dcStockDate.getDate())+"',"
				+ "'"+tokensup.nextToken()+"',"
				+ "'"+tokensup.nextToken()+"',"
				+ "'"+txtusername.getText().trim()+"',"
				+ "'127.0.0.2',"
				+ "now())";
		try{
			DBConnection.Connection();
			DBConnection.sat.executeUpdate(sql);
			DBConnection.con.close();
			return true;
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
		return false;
	}
	
	private boolean deletedata(){
		try{
			String sql="delete  from tbopeningstock where stockid='"+txtstockid.getText().trim()+"'";
			DBConnection.Connection();
			DBConnection.sat.executeUpdate(sql);
			return true;
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	
	public void tableDataLoad(){
		
		for(int a=model.getRowCount()-1;a>=0;a--){
			model.removeRow(a);
		}
		try{
			String sql="select stockid,stockquantity,Stockdate from tbopeningstock";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				model.addRow(new Object[]{
						rs.getString("stockid"),
						rs.getString("stockquantity"),
						rs.getString("Stockdate")
				});
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	private void txtClear(){
		txtstockid.setText("");
		stCatagory.txtSuggest.setText("");
		stSubCatagory.txtSuggest.setText("");
		stProductID.txtSuggest.setText("");
		txtunit.setText("");
		txtstockqty.setText("");
		dcExpireDate.setDate(new Date());
		dcStockDate.setDate(new Date());
		stSupplierName.txtSuggest.setText("");
		txtusername.setText("");
	}
	
    public void CatagoryDataLoad(){
    	try{
    		String sql="select catid,catagoryName from tbcatagoryinfo";
    		stCatagory.vector.removeAllElements();
    		stCatagory.vector.add("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			stCatagory.vector.add(rs.getString("catid")+" # "+rs.getString("catagoryName"));
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
    		stSubCatagory.vector.removeAllElements();//clear()
    		stSubCatagory.vector.add("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			stSubCatagory.vector.add(rs.getString("subcatagoryid")+" # "+rs.getString("subcatagoryName"));
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    public void ProductDataLoad(){
    	try{
    		String sql="select ProductID,ProductName from tbproductinfo";
    	    stProductID.vector.removeAllElements();
    	    stProductID.vector.add("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			stProductID.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
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
    		stSupplierName.vector.removeAllElements();
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
		btnAdd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkVlidation()){
					
				}
			}
		});
		
		btnEdit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnRefresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClear();
			}
		});
		
		btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkVlidation()){
					
				}
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
		panelCenter.setPreferredSize(new Dimension(560,730));
		panelCenter.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelCenter.setLayout(flow);
		panelCenter.add(scroll);
		scroll.setPreferredSize(new Dimension(520,680));
	}

	private void PanelWestWork() {
		panelWest.setPreferredSize(new Dimension(560,730));
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
		panelWestSouth.setPreferredSize(new Dimension(560,100));
		//panelWestSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(30);
		flow.setHgap(30);
		panelWestSouth.add(btnAdd);
		btnAdd.setPreferredSize(new Dimension(70,40));
		btnAdd.setFont(new Font("Sherif",Font.BOLD,14));		

		panelWestSouth.add(btnEdit);
		btnEdit.setPreferredSize(new Dimension(70,40));
		btnEdit.setFont(new Font("Sherif",Font.BOLD,14));		

		panelWestSouth.add(btnRefresh);
		btnRefresh.setPreferredSize(new Dimension(100,40));
		btnRefresh.setFont(new Font("Sherif",Font.BOLD,14));		

		panelWestSouth.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(90,40));
		btnDelete.setFont(new Font("Sherif",Font.BOLD,14));		
	}

	private void PanelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(560,500));
		//panelWestCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenter.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestCenter.add(lblstockid, c);
		lblstockid.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=0;
		panelWestCenter.add(txtstockid, c);
		c.gridx=0;
		c.gridy=1;
		panelWestCenter.add(lblcatagory, c);
		lblcatagory.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=1;
		panelWestCenter.add(stCatagory.cmbSuggest, c);
		c.gridx=0;
		c.gridy=2;
		panelWestCenter.add(lblsubcatagory, c);
		lblsubcatagory.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=2;
		panelWestCenter.add(stSubCatagory.cmbSuggest, c);
		c.gridx=0;
		c.gridy=3;
		panelWestCenter.add(lblproductid, c);
		lblproductid.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=3;
		panelWestCenter.add(stProductID.cmbSuggest, c);
		c.gridx=0;
		c.gridy=4;
		panelWestCenter.add(lblunit, c);
		lblunit.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=4;
		panelWestCenter.add(txtunit, c);
		c.gridx=0;
		c.gridy=5;
		panelWestCenter.add(lblstockqty, c);
		lblstockqty.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=5;
		panelWestCenter.add(txtstockqty, c);
		c.gridx=0;
		c.gridy=6;
		panelWestCenter.add(lblexpiredate, c);
		lblexpiredate.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=6;
		panelWestCenter.add(dcExpireDate, c);
		c.gridx=0;
		c.gridy=7;
		panelWestCenter.add(lblstockdate, c);
		lblstockdate.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=7;
		panelWestCenter.add(dcStockDate, c);
		c.gridx=0;
		c.gridy=8;
		panelWestCenter.add(lblsuppliername, c);
		lblsuppliername.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=8;
		panelWestCenter.add(stSupplierName.cmbSuggest, c);
		c.gridx=0;
		c.gridy=9;
		panelWestCenter.add(lblusername, c);
		lblusername.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=9;
		panelWestCenter.add(txtusername, c);
	}

	private void PanelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(560,130));
		//panelWestNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		JButton btnSearch=new JButton("Search");
		
		FlowLayout flow=new FlowLayout();
		flow.setVgap(40);
		flow.setHgap(20);
		panelWestNorth.setLayout(flow);
		panelWestNorth.add(stsearch.cmbSuggest);
		stsearch.cmbSuggest.setPreferredSize(new Dimension(250,40));
		panelWestNorth.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(100,40));
		btnSearch.setFont(new Font("Sherif",Font.BOLD,14));		
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
		//setBackground(Color.BLACK);			
	}

}
