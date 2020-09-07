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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;

public class ProductInfo extends JPanel{

	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();

	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
    JPanel panelWestSouth=new JPanel();
    
	SuggestText stcatagory=new SuggestText();
	SuggestText stsubcatagory=new SuggestText();
	SuggestText stsuppliername=new SuggestText();

	JLabel lblproductid=new JLabel("Product ID");
	JLabel lblcatagory=new JLabel("Catagory");
	JLabel lblsubcatagory=new JLabel("Subcatagory");
	JLabel lblproductname=new JLabel("Product Name");
	JLabel lblproductdescription=new JLabel("Product Description");
	JLabel lblunit=new JLabel("Unit");
	JLabel lblmrpprice=new JLabel("M.R.P Price");
	JLabel lblnetprice=new JLabel("Net Price");
	JLabel lblprofiteperunit=new JLabel("Profite Per Unit");
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblusername=new JLabel("User Name");
	
	JButton btnAdd=new JButton("Add");
	JButton btnEdit=new JButton("Edit");
	JButton btnRefresh=new JButton("Refresh");
	JButton btnDelete=new JButton("Delete");

	JLabel lblSearch=new JLabel("Search");
	//String[] araSearch={"","","","","","","","","","","","","","","","","","","","","","","","",};
	SuggestText stsearch=new SuggestText();
	
    JTextField txtproductid=new JTextField(20);
    JTextField txtproductname=new JTextField(20);
    JTextField txtproductdescription=new JTextField(20);
    JTextField txtunit=new JTextField(20);
    JTextField txtmrpprice=new JTextField(20);
    JTextField txtnetprice=new JTextField(20);
    JTextField txtprofiteperunit=new JTextField(20);
    JTextField txtusername=new JTextField(20);
    
	Object row[][]={};
	String col[]={"Product ID","Product Name","M.R.P Price","Net Price"};
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
    private boolean isUpdate=false;
	public ProductInfo(){
		init();
		cmp();
		btnAction();
		btnInit(true);
	}
    private void btnInit(boolean b) {
		btnAdd.setEnabled(b);
		btnEdit.setEnabled(!b);
	}
	public void AutoIDProductInfo(){
    	String sql="select ifnull(max(cast(subString(ProductID,locate('-',ProductID)+1,"+
  "length(ProductID)-locate('-',ProductID)) as unsigned)),0)+1 ProductID from tbproductinfo";
    	try{
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		if(rs.next()){
    			String ProductID=rs.getString("ProductID");
    			txtproductid.setText("PI-"+ProductID);
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    
    private boolean checkValidation(){
    	if(!txtproductid.getText().trim().isEmpty()){
    		if(!stcatagory.txtSuggest.getText().trim().isEmpty()){
    			if(!stsubcatagory.txtSuggest.getText().trim().isEmpty()){
    				if(!txtproductname.getText().trim().isEmpty()){
    					if(!txtproductdescription.getText().trim().isEmpty()){
    						if(!txtunit.getText().trim().isEmpty()){
    							if(!txtmrpprice.getText().trim().isEmpty()){
    								if(!txtnetprice.getText().trim().isEmpty()){
    									if(!txtprofiteperunit.getText().trim().isEmpty()){
    										if(!stsuppliername.txtSuggest.getText().trim().isEmpty()){
    											if(!txtusername.getText().trim().isEmpty()){
    												return true;
    											}
    											else{
    							            		JOptionPane.showMessageDialog(null, "Please Insert User Name");
    							            	}
    										}
    										else{
    						            		JOptionPane.showMessageDialog(null, "Please Insert Supplier Name");
    						            	}
    									}
    									else{
    					            		JOptionPane.showMessageDialog(null, "Please Insert Profit Per Unit");
    					            	}
    								}
    								else{
    				            		JOptionPane.showMessageDialog(null, "Please Insert Net Price");
    				            	}
    							}
    							else{
    			            		JOptionPane.showMessageDialog(null, "Please Insert MRP Price");
    			            	}
    						}
    						else{
    		            		JOptionPane.showMessageDialog(null, "Please Insert Unit");
    		            	}
    					}
    					else{
    	            		JOptionPane.showMessageDialog(null, "Please Insert Product Description");
    	            	}
    				}
    				else{
                		JOptionPane.showMessageDialog(null, "Please Insert Product Name");
                	}
    			}
    			else{
            		JOptionPane.showMessageDialog(null, "Please Insert Sub Catagory");
            	}
    		}
    		else{
        		JOptionPane.showMessageDialog(null, "Please Insert Catagory");
        	}
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Please Insert ProductID");
    	}
    	return false;
    }
    
    private boolean isExistProductName(){
    	try{
    		String sql="select * from tbproductinfo where ProductName='"+txtproductname.getText().trim()+"'";
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		if(rs.next()){
    			JOptionPane.showMessageDialog(null, "Product Name Already Exist");
    			return false;
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	return true;
    }
    
    private boolean isExistProductID(){
    	try{
    		String sql="select * from tbproductinfo where ProductID='"+txtproductid.getText().trim()+"'";
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		if(rs.next()){
    			return true;
    		}
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	JOptionPane.showMessageDialog(null, "ProductID does not exist");
    	return false;
    }
    
    private boolean checkConfirmation(String caption){
    	int a=JOptionPane.showConfirmDialog(null,caption,"Confirmation",JOptionPane.YES_NO_OPTION);
    	if(a==JOptionPane.YES_OPTION){
    		return true;
    	}
    	return false;
    }
    
    private boolean insertData(){
    	String catid=stcatagory.txtSuggest.getText().trim();
    	StringTokenizer tokencat=new StringTokenizer(catid,"#");
    	
    	String subcat=stsubcatagory.txtSuggest.getText().trim();
    	StringTokenizer tokensubcat=new StringTokenizer(subcat,"#");
    	
    	String supname=stsuppliername.txtSuggest.getText().trim();
    	StringTokenizer tokensupname=new StringTokenizer(supname,"#");
    	
    	String sql="insert into  tbproductinfo(ProductID,CatID,CatName"
    			+ ",SubCatID,SubCatName,ProductName,ProductDescription,Unit,"
    			+ "MRP_Price,NetPrice,ProfitPerUnit,SupplierID,SupplierName,"
    			+ "UserName,userip,entrytime)values"
    			+ "('"+txtproductid.getText().trim()+"',"
    			+ "'"+tokencat.nextToken()+"',"
    			+ "'"+tokencat.nextToken()+"',"
    			+ "'"+tokensubcat.nextToken()+"',"
    			+ "'"+tokensubcat.nextToken()+"',"
    			+ "'"+txtproductname.getText().trim()+"',"
    			+ "'"+txtproductdescription.getText().trim()+"',"
    			+ "'"+txtunit.getText().trim()+"',"
    			+ "'"+txtmrpprice.getText().trim()+"',"
    			+ "'"+txtnetprice.getText().trim()+"',"
    			+ "'"+txtprofiteperunit.getText().trim()+"',"
    			+ "'"+tokensupname.nextToken()+"',"
    			+ "'"+tokensupname.nextToken()+"',"
    			+ "'"+txtusername.getText().trim()+"',"
    			+ "'127.0.0.1',"
    			+ "now())";
    	
    	//System.out.println(sql);
    	try{
    		DBConnection.Connection();
    		DBConnection.sat.executeUpdate(sql);
    		DBConnection.con.close();
    		return true;
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	return false;
    }
    
    private boolean deleteData(){
    	try{
    		String sql="delete from tbproductinfo where ProductID='"+txtproductid.getText()+"'";
    		DBConnection.Connection();
    		DBConnection.sat.executeUpdate(sql);
    		return true;
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null,exp);
    	}
    	return false;
    }
    public void tableDataLoad(){
    	for(int a=model.getRowCount()-1;a>=0;a--){
    		model.removeRow(a);
    	}
    	try{
    		String sql="select ProductID,ProductName,MRP_Price,NetPrice from tbproductinfo";
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			model.addRow(new Object[]{rs.getString("ProductID"),
    					rs.getString("ProductName"),
    					rs.getString("MRP_Price"),
    					rs.getString("NetPrice")});
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    
    private void FindDataLoad(String ProductID){
    	txtClear();
    	String sql="select ProductID,CatID,CatName,SubCatID,"
    			+ "SubCatName,ProductName,ProductDescription,"
    			+ "Unit,MRP_Price,NetPrice,ProfitPerUnit,SupplierID,"
    			+ "SupplierName,UserName from tbproductinfo "
    			+ "where ProductID='"+ProductID+"'";
    	try{
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			txtproductid.setText(rs.getString("ProductID"));
    			stcatagory.txtSuggest.setText(rs.getString("CatID")+" # "+rs.getString("CatName"));
    			stsubcatagory.txtSuggest.setText(rs.getString("SubCatID")+" # "+rs.getString("SubCatName"));
    			txtproductname.setText(rs.getString("ProductName"));
    			txtproductdescription.setText(rs.getString("ProductDescription"));
    			txtunit.setText(rs.getString("Unit"));
    			txtmrpprice.setText(rs.getString("MRP_Price"));
    			txtnetprice.setText(rs.getString("NetPrice"));
    			txtprofiteperunit.setText(rs.getString("ProfitPerUnit"));
    			stsuppliername.txtSuggest.setText(rs.getString("SupplierID")+" # "+rs.getString("SupplierName"));
    			txtusername.setText(rs.getString("UserName"));
    		}
    		DBConnection.con.close();
    		btnInit(false);
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    
    public void cmbSearchDataLoad(){
    	try{
    		String sql="select ProductID,ProductName from tbproductinfo";
    		stsearch.vector.removeAllElements();
    		stsearch.vector.add("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			stsearch.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    private void txtClear(){
    	txtproductid.setText("");
        stcatagory.txtSuggest.setText("");
        stsubcatagory.txtSuggest.setText("");
        txtproductname.setText("");
        txtproductdescription.setText("");
        txtunit.setText("");
        txtmrpprice.setText("");
        txtnetprice.setText("");
        txtprofiteperunit.setText("");
        stsuppliername.txtSuggest.setText("");
        txtusername.setText("");
    }
    
    public void CatagoryDataload(){
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
            //String idName=SuggestTextCatagoryIDSub
            StringTokenizer token=new StringTokenizer(stcatagory.txtSuggest.getText(),"#");
    		
    		//String sql="select Subcatagoryid,subcatagoryName from "
    		//+ "tbsubcatagoryinfo where catagoryid='"+token.nextToken().trim()+"'";
    		String sql="select subcatagoryid,subcatagoryName from tbsubcatagoryinfo";
    		stsubcatagory.vector.removeAllElements();
    		stsubcatagory.vector.add("");
    		//stsubcatagory.txtSuggest.setText("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			stsubcatagory.vector.add(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryName"));
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
	private void btnAction() {
		btnAdd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(isUpdate){
					if(checkValidation()){
						if(isExistProductID()){
							if(checkConfirmation("Sure to Update?")){
								if(deleteData()){
									if(insertData()){
										txtClear();
										AutoIDProductInfo();
										tableDataLoad();
										cmbSearchDataLoad();
										JOptionPane.showMessageDialog(null, "All Information Update Successfully");
										isUpdate=false;
									}
								}
							}
						}
					}
				}
				else
				{
					if(checkValidation()){
						if(isExistProductName()){
							if(checkConfirmation("Sure to Save?")){
								if(insertData()){
									txtClear();
									AutoIDProductInfo();
									cmbSearchDataLoad();
									tableDataLoad();
									JOptionPane.showMessageDialog(null, "All Information Save Successfully");
									
								}
							}
						}
					}
				}
			}
		});
		
		btnEdit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				btnInit(true);
				isUpdate=true;
			}
		});
		
		btnRefresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClear();
				AutoIDProductInfo();
				btnInit(true);
				isUpdate=false;
				stsearch.txtSuggest.setText("");
			}
		});
		
		btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidation()){
					if(isExistProductID()){
						if(checkConfirmation("Sure to Delete?")){
							if(deleteData()){
								AutoIDProductInfo();
								txtClear();
								tableDataLoad();
								cmbSearchDataLoad();
								JOptionPane.showMessageDialog(null,"Delete Data Successfully");
							}
						}
					}
				}
			}
		});
		table.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				//System.out.println(model.getValueAt(table.getSelectedRow(), 0));
				FindDataLoad(model.getValueAt(table.getSelectedRow(),0).toString());
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
		});
		
		stsearch.cmbSuggest.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String productid=stsearch.txtSuggest.getText().trim();
				StringTokenizer token=new StringTokenizer(productid,"#");
				FindDataLoad(token.nextToken());
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
		scroll.setPreferredSize(new Dimension(530,700));
	}

	private void PanelWestWork() {
		panelWest.setPreferredSize(new Dimension(575,750));
		panelWest.setBorder(BorderFactory.createTitledBorder(""));
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		PanelWestNorthWork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		PanelWestCenterWork();
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		PanelWestSouthWork();
		
	}

	private void PanelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(560,540));
		panelWestCenter.setBorder(BorderFactory.createTitledBorder(""));
		
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenter.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestCenter.add(lblproductid,c);
		lblproductid.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelWestCenter.add(txtproductid, c);
		c.gridx=0;
		c.gridy=1;
		panelWestCenter.add(lblcatagory, c);
		lblcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelWestCenter.add(stcatagory.cmbSuggest, c);//
		c.gridx=0;
		c.gridy=2;
		panelWestCenter.add(lblsubcatagory, c);
		lblsubcatagory.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelWestCenter.add(stsubcatagory.cmbSuggest, c);
		c.gridx=0;
		c.gridy=3;
		panelWestCenter.add(lblproductname, c);
		lblproductname.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelWestCenter.add(txtproductname, c);
		c.gridx=0;
		c.gridy=4;
		panelWestCenter.add(lblproductdescription, c);
		lblproductdescription.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=4;
		panelWestCenter.add(txtproductdescription, c);
		c.gridx=0;
		c.gridy=5;
		panelWestCenter.add(lblunit, c);
		lblunit.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=5;
		panelWestCenter.add(txtunit, c);
		c.gridx=0;
		c.gridy=6;
		panelWestCenter.add(lblmrpprice, c);
		lblmrpprice.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=6;
		panelWestCenter.add(txtmrpprice, c);
		c.gridx=0;
		c.gridy=7;
		panelWestCenter.add(lblnetprice, c);
		lblnetprice.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=7;
		panelWestCenter.add(txtnetprice, c);
		c.gridx=0;
		c.gridy=8;
		panelWestCenter.add(lblprofiteperunit, c);
		lblprofiteperunit.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=8;
		panelWestCenter.add(txtprofiteperunit, c);
		c.gridx=0;
		c.gridy=9;
		panelWestCenter.add(lblsuppliername, c);
		lblsuppliername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=9;
		panelWestCenter.add(stsuppliername.cmbSuggest, c);
		c.gridx=0;
		c.gridy=10;
		panelWestCenter.add(lblusername, c);
		lblusername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=10;
		panelWestCenter.add(txtusername, c);	
	}
	
	private void PanelWestSouthWork() {
		panelWestSouth.setPreferredSize(new Dimension(560,100));
		//panelwestsouth.setBorder(BorderFactory.createRaisedBevelBorder());
			FlowLayout flow=new FlowLayout();
			
		panelWestSouth.setLayout(flow);
		flow.setVgap(30);
		flow.setHgap(20);
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

	private void PanelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(560,90));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		
     	FlowLayout flow=new FlowLayout();
		panelWestNorth.setLayout(flow);
		flow.setVgap(20);
		flow.setHgap(20);
		panelWestNorth.add(stsearch.cmbSuggest);
		stsearch.cmbSuggest.setPreferredSize(new Dimension(300,35));
		panelWestNorth.add(lblSearch);
		lblSearch.setPreferredSize(new Dimension(100,35));
		lblSearch.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
        setBorder(BorderFactory.createTitledBorder(""));
        setLayout(new BorderLayout());
	}

}