package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;

public class SupplierInfo extends JPanel{
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();

	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterOfCenter=new JPanel();
	
	SuggestText SuggestText=new SuggestText();
	JButton cmbsearch=new JButton();
	JButton btnSearch=new JButton("Search");
	
	JLabel lblsupplierid=new JLabel("Supplier ID");     //panel west center west
	JLabel lblsuppliername=new JLabel("Supplier Name");
	JLabel lblmailaddress=new JLabel("Mail Address");
	JLabel lblphonenumber=new JLabel("Phone Number");
	JLabel lbladdress=new JLabel("Address");
	JLabel lblusername=new JLabel("User Name");
	JTextField txtsupplierid=new JTextField(15);
	JTextField txtsuppliername=new JTextField(15);
	JTextField txtmailaddress=new JTextField(15);
	JTextField txtMobile=new JTextField(15);
	JTextField txtusername=new JTextField(15);
	JTextArea txtArea=new JTextArea(4,6);
	JScrollPane scroll=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JLabel lblUpload=new JLabel();             //panel west center of center  
	JButton btnUpload=new JButton("Upload");
	FlowLayout flow=new FlowLayout();
	
	JButton btnAdd=new JButton("Add");        //panel west south   
	JButton btnEdit=new JButton("Edit");
	JButton btnRefresh=new JButton("Refresh");
	JButton btnDelete=new JButton("Delete");

	String column[]={"Supplier ID","Supplier Name","Mobile"}; //panel center
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,column);
	JTable  table=new JTable(model);
	JScrollPane scrolltable=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
    JFileChooser filechooser=new JFileChooser();
    
    File file=null;
    boolean isUpdate=false;
    
	public SupplierInfo(){
		init();
		cmp();
		btnAction();
		Initial(true);
	}
	
	private void Initial(boolean b) {
		btnAdd.setEnabled(b);
		btnEdit.setEnabled(!b);
	}

	public void autoId(){
	  String sql="select ifnull(max(cast(subString(SupplierID,locate('-',SupplierID)+1,"+
         "length(SupplierID)-locate('-',SupplierID)) as unsigned)),0)+1 SupplierID from "
         + "tbSupplierInfo";
		
		try{
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				String SupplierID=rs.getString("SupplierID");
				txtsupplierid.setText("Sup-"+SupplierID);
			}
	        DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}		
	}
	
    private boolean checkValidation(){
    	if(!txtsupplierid.getText().trim().isEmpty()){
    		if(!txtsuppliername.getText().trim().isEmpty()){
    			if(!txtmailaddress.getText().trim().isEmpty()){
    				if(!txtMobile.getText().trim().isEmpty()){
    					if(!txtArea.getText().trim().isEmpty()){
    						if(!txtusername.getText().trim().isEmpty()){
    							return true;
    						}
    						else{
    	        	    		JOptionPane.showMessageDialog(null,"Please insrt user name");
    						}
    					}
    					else{
            	    		JOptionPane.showMessageDialog(null,"Please insrt Address");
    					}
    				}
    				else{
        	    		JOptionPane.showMessageDialog(null,"Please insrt phone number");
    				}
    			}
    			else{
    	    		JOptionPane.showMessageDialog(null,"Please insrt Mail Address");
    			}
    		}	
    		else{
        		JOptionPane.showMessageDialog(null,"Please insrt supplier name");
    		}
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null,"Please insrt supplier ID");
    	}
    	return false;  
    }
    
    private boolean isExistSupplierName(){
    	try{
    		String sql="select * from tbsupplierinfo where SupplierName='"+txtsuppliername.getText().trim()+"'";
    	    DBConnection.Connection();
    	    ResultSet rs=DBConnection.sat.executeQuery(sql);
    	    if(rs.next()){
    	    	JOptionPane.showMessageDialog(null, "SupplierName Already Exist");
    	    	return false;
    	    }
    	    DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	return true;
    }
    
    private boolean isExistSupplierID(){
    	try{
    		String sql="select * from tbsupplierinfo where "
    				+ "SupplierID='"+txtsupplierid.getText().trim()+"'";
    	    DBConnection.Connection();
    	    ResultSet rs=DBConnection.sat.executeQuery(sql);
    	    if(rs.next()){
    	    	return true;
    	    }
    	    DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	JOptionPane.showMessageDialog(null, "ID does not exist");
    	return false;
    } 
    
    private boolean checkConfirmation(String caption){
    	
    	int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation",JOptionPane.YES_NO_OPTION);
    	if(a==JOptionPane.YES_NO_OPTION){
    		return true;
    	}
    	return false;
    }
    
    private boolean DeleteData() {
    	try{
    		String sql="delete from tbsupplierinfo where SupplierID='"+txtsupplierid.getText()+"'";
    	    DBConnection.Connection();
    	    DBConnection.sat.executeUpdate(sql);
    	    return true;
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
		return false;
	}
    
    private void UploadImageSave(String SupplierID){
    	try{
    		File fileDirectory=new File("D:/Software/SaveImages/Supplierinfo");
    		if(!fileDirectory.isDirectory()){
    			fileDirectory.mkdirs();
    		}
    		File imagePath=new File(fileDirectory.getPath()+"/"+SupplierID+".jpg");
    		if(imagePath.exists()){
    			imagePath.delete();
    		}
    		if(file!=null){
    			BufferedImage img=ImageIO.read(file);
    			ImageIO.write(img, "jpg", imagePath);
    		}
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    
    private boolean insertData(){
    	String pic="";
    	UploadImageSave(txtsupplierid.getText().trim());
    	if(new File("D:/Software/SaveImages/Supplierinfo/"+txtsupplierid.getText().trim()+".jpg").exists())
    	  {
    		pic="D:/Software/SaveImages/Supplierinfo/"+txtsupplierid.getText().trim()+".jpg";
    	  }
    	String sql="insert into tbSupplierInfo(SupplierID,SupplierName,MailAddress,"
    			+ "Mobile,Address,UserName,Picture,UserIP,EntryTime)values"
    			+ "('"+txtsupplierid.getText().trim()+"'"
    			+ ",'"+txtsuppliername.getText().trim()+"'"
    			+ ",'"+txtmailaddress.getText().trim()+"'"
    			+ ",'"+txtMobile.getText().trim()+"'"
    			+ ",'"+txtArea.getText().trim()+"'"
    			+ ",'"+txtusername.getText().trim()+"'"
    			+ ",'"+pic+"'"
    			+ ",''"
    			+ ",now())";
    	
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
    private void txtClear(){
    	txtsupplierid.setText("");
    	txtsuppliername.setText("");
    	txtmailaddress.setText("");
    	txtMobile.setText("");
    	txtArea.setText("");
    	txtusername.setText("");
    	lblUpload.setIcon(new ImageIcon(""));
    	SuggestText.txtSuggest.setText("");
    }
    
 public void TableDataLoad(){
    	
    	for(int a=model.getRowCount()-1;a>=0;a--){
			model.removeRow(a);
		}
    	
    	try{   		
    	 String sql="select SupplierID,SupplierName,Mobile from tbsupplierinfo";
 		 DBConnection.Connection();
    	 ResultSet rs=DBConnection.sat.executeQuery(sql);
    	 while(rs.next()){
    	 model.addRow(new Object[]{rs.getString("SupplierID"),rs.getString("SupplierName"),
    				 rs.getString("Mobile")});
    	 }
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
   
    public void SuggestTextDataLoad(){
    	
    	try{
        	String sql="select SupplierID,SupplierName from tbsupplierinfo";
    		SuggestText.vector.removeAllElements();
    		SuggestText.vector.add("");
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    		   SuggestText.vector.add(rs.getString("SupplierID")+" # "+
    		rs.getString("SupplierName"));	
    		}
    		DBConnection.con.close();
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    	
    }
    private void FindDataLoad(String SupplierID){
        txtClear();
    	String sql="select SupplierID,SupplierName,MailAddress,Mobile,Address,UserName"
    			+ ",ifnull(Picture,'')pic from tbsupplierinfo "
    			+ "where SupplierID='"+SupplierID+"'";
    	try{
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			txtsupplierid.setText(rs.getString("SupplierID"));
    			txtsuppliername.setText(rs.getString("SupplierName"));
    			txtmailaddress.setText(rs.getString("MailAddress"));
    			txtMobile.setText(rs.getString("Mobile"));
    			txtArea.setText(rs.getString("Address"));
    			txtusername.setText(rs.getString("UserName"));
    			
    			if(!rs.getString("pic").toString().isEmpty())
    			{
    				File fileSearch=new File(rs.getString("pic"));
    				if(fileSearch.exists())
    				{
    					Image img=Toolkit.getDefaultToolkit().getImage(rs.getString("pic"));
    					Image resize=img.getScaledInstance(lblUpload.getWidth(),
    							lblUpload.getHeight(), Image.SCALE_DEFAULT);
    					lblUpload.setIcon(new ImageIcon(resize));
    				}
    			}
    		}
    		DBConnection.con.close();
    		Initial(false);
    	}
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
    }
    public void btnUploadAcation() {
       	try{
       		new JFileChooser();
       		FileNameExtensionFilter filter=new FileNameExtensionFilter("Images","JPG","PNG","gif","JPEG");
            filechooser.setFileFilter(filter);
            filechooser.showOpenDialog(null);
            file=filechooser.getSelectedFile();
          /*  String filePath=file.getPath();
            System.out.println(file.getPath());
            Image img=Toolkit.getDefaultToolkit().getImage(file.getPath()); 
            Image resize=img.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(),Image.SCALE_DEFAULT);
            ImageIcon icon=new ImageIcon(resize);
            lblUpload.setIcon(icon);
            */
            if(file!=null){
            	 Image img=Toolkit.getDefaultToolkit().getImage(file.getPath()); 
                 Image resize=img.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(),Image.SCALE_DEFAULT);
                 ImageIcon icon=new ImageIcon(resize);
                 lblUpload.setIcon(icon);
            }
       	}
       	catch(Exception exp){
       		JOptionPane.showMessageDialog(null, exp);
       	}
	}
 
	private void btnAction() {
		
       	btnAdd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) { 	
	 		    if(isUpdate){
	 		    	if(checkValidation()){
	 		    		if(isExistSupplierID()){
	 		    			if(checkConfirmation("Sure to Update?")){
	 		    				if(DeleteData()){
	 		    					if(insertData()){
	 	                    		   JOptionPane.showMessageDialog(null, "All Information Update Successfully");
	 	                    		   autoId();
	 	                    		   txtClear();
	 	                    		   TableDataLoad();
	 	                    		   SuggestTextDataLoad();
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
		 		    	if(isExistSupplierName()){
	                       if(checkConfirmation("Sure to Save?")){
	                    	   if(insertData()){
	                    		   JOptionPane.showMessageDialog(null, "All Information Save Successfully");
	                    		   autoId();
	                    		   txtClear();
	                    		   TableDataLoad();
	                    		   SuggestTextDataLoad();
	                    	   }
	                       }
		 		    	}
		 		    }
	 		    }
		    }
				
	  });	
       	
       
       	btnEdit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				Initial(true);
				isUpdate=true;
			}
       		
       	});
       	
       	btnRefresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClear();
				autoId();
	    		Initial(true);
	    		isUpdate=false;
			}
       		
       	});
       	
       	btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidation()){
					if(isExistSupplierID()){
						if(checkConfirmation("Sure to Delete?")){
							if(DeleteData()){
								txtClear();
								autoId();
								TableDataLoad();
								SuggestTextDataLoad();
								JOptionPane.showMessageDialog(null, "Delete Data Successfully");
							}
						}
					}
				}
			}
       		
       	});
       	
       	btnUpload.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				btnUploadAcation();
			}
       	});
       	
       	table.addMouseListener(new MouseListener(){
       		
			public void mouseClicked(MouseEvent e) {
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
       	
       	SuggestText.cmbSuggest.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String SupplierID=SuggestText.txtSuggest.getText().trim();
				StringTokenizer token=new StringTokenizer(SupplierID,"#");
				FindDataLoad(token.nextToken());
			}      		
       	});
       		
	}

	private void cmp() {
		add(panelWest,BorderLayout.WEST);
		panelWestWork();
		add(panelCenter,BorderLayout.CENTER);
		panelCentreWork();
	}

	private void panelCentreWork() {
		panelCenter.setPreferredSize(new Dimension(575,740));
		panelCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelCenter.add(scrolltable);
		scrolltable.setPreferredSize(new Dimension(530,700));		
	}

	private void panelWestWork() {	
		panelWest.setPreferredSize(new Dimension(575,740));
		panelWest.setBorder(BorderFactory.createTitledBorder(""));
		panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthWork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		PanelWestCenterWork();
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthWork();		
	}

	private void panelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(575,140));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		FlowLayout flow=new FlowLayout();
		panelWestNorth.setLayout(flow);
		flow.setVgap(40);
		panelWestNorth.add(SuggestText.cmbSuggest);
		SuggestText.cmbSuggest.setPreferredSize(new Dimension(300,40));
		panelWestNorth.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(100,40));
		btnSearch.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,18));	
	}

	private void PanelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(575,400));
		panelWestCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterWest,BorderLayout.WEST);
		panelWestCenterWestWork();
		panelWestCenter.add(panelWestCenterOfCenter,BorderLayout.CENTER);
		panelWestCenterOfCenterWork();
	}

	private void panelWestCenterWestWork() {
		panelWestCenterWest.setPreferredSize(new Dimension(350,400));
	//	panelWestCenterWest.setBorder(BorderFactory.createRaisedBevelBorder());
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenterWest.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestCenterWest.add(lblsupplierid,c);
		lblsupplierid.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelWestCenterWest.add(txtsupplierid,c);
		c.gridx=0;
		c.gridy=1;
		panelWestCenterWest.add(lblsuppliername,c);
		lblsuppliername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelWestCenterWest.add(txtsuppliername,c);
		c.gridx=0;
		c.gridy=2;
		panelWestCenterWest.add(lblmailaddress,c);
		lblmailaddress.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelWestCenterWest.add(txtmailaddress,c);
		c.gridx=0;
		c.gridy=3;
		panelWestCenterWest.add(lblphonenumber,c);
		lblphonenumber.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelWestCenterWest.add(txtMobile,c);
		c.gridx=0;
		c.gridy=4;
		panelWestCenterWest.add(lbladdress,c);
		lbladdress.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=4;
		panelWestCenterWest.add(scroll,c);
		txtArea.setLineWrap(true);
		c.gridx=0;
		c.gridy=5;
		panelWestCenterWest.add(lblusername,c);
		lblusername.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=5;
		panelWestCenterWest.add(txtusername,c);
	}

	private void panelWestCenterOfCenterWork() {
		panelWestCenterOfCenter.setPreferredSize(new Dimension(220,400));
	//	panelWestCenterOfCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		panelWestCenterOfCenter.setLayout(flow);
		flow.setVgap(45);
		panelWestCenterOfCenter.add(lblUpload);
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblUpload.setPreferredSize(new Dimension(150,160));
		panelWestCenterOfCenter.add(btnUpload);
		btnUpload.setPreferredSize(new Dimension(80,40));
		btnUpload.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelWestSouthWork() {
		panelWestSouth.setPreferredSize(new Dimension(575,200));
		panelWestSouth.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
    	FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setHgap(20);
		flow.setVgap(80);
		panelWestSouth.add(btnEdit);
		btnEdit.setPreferredSize(new Dimension(70,40));
		btnEdit.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestSouth.add(btnAdd);
		btnAdd.setPreferredSize(new Dimension(70,40));
		btnAdd.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestSouth.add(btnRefresh);
		btnRefresh.setPreferredSize(new Dimension(100,40));
		btnRefresh.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestSouth.add(btnDelete);
		btnDelete.setPreferredSize(new Dimension(90,40));
		btnDelete.setFont(new Font("Sherif",Font.BOLD,14));		
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());		
	}
}