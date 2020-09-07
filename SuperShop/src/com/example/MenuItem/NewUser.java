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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import com.toedter.calendar.JDateChooser;

public class NewUser extends JPanel{
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();
	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterCenter=new JPanel();
	
	SuggestText stSuggestText=new SuggestText();
	JTextField txtSearch=new JTextField(20);
	JButton btnSearch=new JButton("Search");
	
	JButton btnAdd=new JButton("Add");
	JButton btnEdit=new JButton("Edit");
	JButton btnRefresh=new JButton("Refresh");
	JButton btnDelete=new JButton("Delete");

	JLabel lblUpload=new JLabel();
	JButton btnUpload=new JButton("Upload");
	
	JLabel lblUserID=new JLabel("User ID");
	JLabel lblName=new JLabel("Name");
	JLabel lblUserName=new JLabel("User Name");
	JLabel lblDesignation=new JLabel("Designation");
	JLabel lblPassword=new JLabel("Password");
	JLabel lblDate=new JLabel("Date Of Join");
	JLabel lblActivation=new JLabel("Activation(Y for yes,N for No)");
	JLabel lblEmailAddress=new JLabel("Email Address");
	JLabel lblNationalID=new JLabel("National ID");
	JLabel lblAddress=new JLabel("Address");
	JLabel lblMobil=new JLabel("Mobil");

	JTextField txtUserID=new JTextField(15);
	JTextField txtName=new JTextField(15);
	JTextField txtUserName=new JTextField(15);
	JTextField txtDesignation=new JTextField(15);
	JTextField txtPassword=new JTextField(15);
	JTextField txtDate=new JTextField(15);
	JTextField txtActivation=new JTextField(15);
	JTextField txtEmailAddress=new JTextField(15);
	JTextField txtNationalID=new JTextField(15);
	JTextField txtMobile=new JTextField(15);
	JTextArea txtArea=new JTextArea(3,6);
	JScrollPane scrollArea=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JDateChooser dcDate=new JDateChooser();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
	
	String col[]={"User ID","User Name","Activation","Email",};
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JFileChooser filechooser=new JFileChooser();
    File file=null;
    boolean isUpdate=false;
	public NewUser(){
		init();
		cmp();
		btnAction();
		btnInit(true);
	}
     
	private void btnInit(boolean b) {
		btnAdd.setEnabled(b);
		btnEdit.setEnabled(!b);
	}

	public void autoID(){
    	String sql="select ifnull(max(cast(subString(UserID,locate('-',UserID)+1,"+
           "length(UserID)-locate('-',UserID)) as unsigned)),0)+1 UserID from tbNewUser";
    	try{	
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		if(rs.next()){
    			String UserID=rs.getString("UserID");
    			txtUserID.setText("NU-"+UserID);
    		}
    		DBConnection.con.close();
    	}
    
    	catch(Exception exp){
    		JOptionPane.showMessageDialog(null, exp);
    	}
     }
	 private boolean checkValidation(){
	    	if(!txtUserID.getText().trim().isEmpty()){
	    		if(!txtName.getText().trim().isEmpty()){
	    			if(!txtUserName.getText().trim().isEmpty()){
	            		if(!txtDesignation.getText().trim().isEmpty()){
	            			 if(!txtPassword.getText().trim().isEmpty()){
	            				 if(!dcDate.getDate().toString().trim().isEmpty()){
	            					 if(!txtActivation.getText().trim().isEmpty()){
	            						 if(!txtEmailAddress.getText().trim().isEmpty()){
	            							 if(!txtNationalID.getText().trim().isEmpty()){
	            								 if(!txtArea.getText().trim().isEmpty()){
	            									 if(!txtMobile.getText().trim().isEmpty()){
	            										 return true;
	            									 }
	            									 else{
	            										 JOptionPane.showMessageDialog(null, "please insert Mobile number");
	            									 }
	            								 }
	            								 else{
	            									 JOptionPane.showMessageDialog(null, "please insert Address");
	            								 }
	            							 }
	            							 else{
	            								 JOptionPane.showMessageDialog(null, "please insert National ID");
	            							 }
	            						 }
	            						 else{
	            							 JOptionPane.showMessageDialog(null, "please insert Email Address");
	            						 }
	            					 }
	            					 else{
	            						 JOptionPane.showMessageDialog(null, "please insert Activation");
	            					 }
	            		    	}
	            				 else{
	            					 JOptionPane.showMessageDialog(null, "Please insert Date");
	            				   } 
	            			 }
	            			else{
	            				JOptionPane.showMessageDialog(null, "Please insert password");
	            			}
	            		}
	            		else{
	            			JOptionPane.showMessageDialog(null, "please insert Designation");
	            		}
	            	}
	    			else{
	    				JOptionPane.showMessageDialog(null,"please inser User name");
	    			}
	        	}
	    		else{
	        		JOptionPane.showMessageDialog(null, "Please insert Name");
	    		}
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "Please insert UserID");
	    	}
	    	return false;
	    }
	    
	 private boolean isExistName(){
	    	try{
	    		String sql="select * from tbnewuser where Name='"+txtName.getText().trim()+"'";
	    		DBConnection.Connection();
	    		ResultSet rs=DBConnection.sat.executeQuery(sql);
	    		if(rs.next()){
	    			JOptionPane.showMessageDialog(null, "Name Already Exist");
	    			return false;
	    		}
	    		DBConnection.con.close();
	    	}
	    	catch(Exception exp){
	    		JOptionPane.showMessageDialog(null, exp);
	    	}
	    	return true;
	    }
	 private  boolean isExistUserID(){
		 try{
			 String sql="select * from tbnewuser where UserID='"+txtUserID.getText().trim()+"'";
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
		 JOptionPane.showMessageDialog(null, "User ID Does not Exist");
		 return false;
	 }
	 private boolean checkConfirmation(String caption){
	    	int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation",
	    			JOptionPane.YES_NO_OPTION);
	    	if(a==JOptionPane.YES_OPTION){
	    		return true;
	    	}
	    	return false;
	    }
	 private void UploadImageSave(String UserID){
		 try{
			 File fileDirectory=new File("D:/Software/SaveImages/NewUser");
			 if(!fileDirectory.isDirectory()){
				 fileDirectory.mkdirs();
			 }
			 File imagePath=new File(fileDirectory.getPath()+"/"+UserID+".jpg");
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
		    UploadImageSave(txtUserID.getText().trim());
		    
		    if(new File("D:/Software/SaveImages/NewUser/"+txtUserID.getText().trim()+".jpg").exists())
		    {		    	
		    	pic="D:/Software/SaveImages/NewUser/"+txtUserID.getText().trim()+".jpg";
		    }
		    String sql="insert into tbnewuser (UserID,Name,UserName,Designation,Password"
		    		+ ",DateOfJoin,Activation,EmailAddress,NationalID,Address,Mobile,"
		    		+ "Picture,UserIp)values("
		    		+ "'"+txtUserID.getText().trim()+"',"
		    		+ "'"+txtName.getText().trim()+"',"
		    		+ "'"+txtUserName.getText().trim()+"',"
		    		+ "'"+txtDesignation.getText().trim()+"',"
		    		+ "'"+txtPassword.getText().trim()+"'"
		    		+ ",'"+dateFormat.format(dcDate.getDate())+"',"
		    		+ "'"+txtActivation.getText().trim()+"',"
		    		+ "'"+txtEmailAddress.getText().trim()+"',"
		    		+ "'"+txtNationalID.getText().trim()+"',"
		    		+ "'"+txtArea.getText().trim()+"',"
		    		+ "'"+txtMobile.getText().trim()+"',"
		    		+ "'"+pic+"',"
		    		+ "'127.0.0.1')"; 	
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
	 
	 public void tableDataLoad(){
	    	for(int a=model.getRowCount()-1;a>=0;a--){
				model.removeRow(a);
			}
	    	try{
	    		String sql="select UserID,UserName,Activation,EmailAddress from tbnewuser";
	    		DBConnection.Connection();
	    		ResultSet rs=DBConnection.sat.executeQuery(sql);
	    		while(rs.next()){
	    		  model.addRow(new Object[]{rs.getString("UserID"),rs.getString("UserName"),
	    					rs.getString("Activation"),rs.getString("EmailAddress")});
	    		}
	    		DBConnection.con.close();
	    	}
	    	catch(Exception exp){
	    		JOptionPane.showMessageDialog(null, exp);
	    	}
	    }
	 
	 private void txtClear(){
		    txtUserID.setText("");
		    txtName.setText("");
		    txtUserName.setText("");
		    txtDesignation.setText("");
		    txtPassword.setText("");
		    dcDate.setDate(new Date());
		    txtActivation.setText("");
		    txtEmailAddress.setText("");
		    txtNationalID.setText("");
		    txtArea.setText("");
		    txtMobile.setText("");
		    lblUpload.setIcon(new ImageIcon(""));
		    stSuggestText.txtSuggest.setText("");
	    }
	 private boolean DeleteData(){
		 try{
			String sql="delete  from tbnewuser where UserID='"+txtUserID.getText()+"'";
			DBConnection.Connection();
			DBConnection.sat.executeUpdate(sql);
			return true;
		 }
		 catch(Exception exp){
			 JOptionPane.showMessageDialog(null, exp);
		 }
		 return false;
	 }
	 public void SuggestTextDataLoad(){
			try{
				String sql="select UserID,UserName from tbnewuser";
				stSuggestText.vector.removeAllElements();
				stSuggestText.vector.add("");
				DBConnection.Connection();
				ResultSet rs=DBConnection.sat.executeQuery(sql);
				while(rs.next()){
					stSuggestText.vector.add(rs.getString("UserID")+" # "+rs.getString("UserName"));
				}
				DBConnection.con.close();
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
    
    private void TableDataClickAction(String UserID){
    	txtClear();
    	String sql="select UserID,Name,UserName,Designation,Password,DateOfJoin,"
    			+ "Activation,EmailAddress,NationalID,Address,Mobile,"
    			+ "ifnull(Picture,'')pic from tbnewuser where UserID='"+UserID+"'";
    	try{
    		DBConnection.Connection();
            ResultSet rs=DBConnection.sat.executeQuery(sql);
    		while(rs.next()){
    			txtUserID.setText(rs.getString("UserID"));
    			txtName.setText(rs.getString("Name"));
    			txtUserName.setText(rs.getString("UserName"));
    			txtDesignation.setText(rs.getString("Designation"));
    			txtPassword.setText(rs.getString("Password"));
    			dcDate.setDate(rs.getDate("DateOfJoin"));
    			txtActivation.setText(rs.getString("Activation"));
    			txtEmailAddress.setText(rs.getString("EmailAddress"));
    			txtNationalID.setText(rs.getString("NationalID"));
    			txtArea.setText(rs.getString("Address"));
    			txtMobile.setText(rs.getString("Mobile"));
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
           btnInit(false);
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
						if(isExistUserID()){
							if(checkConfirmation("Sure to Update?")){
								if(DeleteData()){
									if(insertData()){
										txtClear();
										autoID();
										tableDataLoad();
										SuggestTextDataLoad();
										JOptionPane.showMessageDialog(null, "All Information Update Successfully");
									}
								}
							}
						}
					}
				}
				else
				{
					if(checkValidation()){
						if(isExistName()){
							if(checkConfirmation("Sure to Save?")){
								if(insertData()){
									txtClear();
									autoID();
									tableDataLoad();
									SuggestTextDataLoad();
									JOptionPane.showMessageDialog(null, "All Information Save Successflly");
								}
							}
						}
					}
				}
			}
        	
        });	
        
        table.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				TableDataClickAction(model.getValueAt(table.getSelectedRow(), 0).toString());
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
        
        stSuggestText.cmbSuggest.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				String UserID=stSuggestText.txtSuggest.getText().trim();
				StringTokenizer token=new StringTokenizer(UserID,"#");
				TableDataClickAction(token.nextToken());
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
				autoID();
				btnInit(true);
				isUpdate=false;
			}
        	
        });
        
        btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidation()){
					if(isExistUserID()){
						if(checkConfirmation("Sure to Delete?")){
							if(DeleteData()){
								txtClear();
								autoID();
								tableDataLoad();
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
	}

	private void cmp() {
        add(panelWest,BorderLayout.WEST);
        PanelWestWork();
        add(panelCenter,BorderLayout.CENTER);
        PanelCenterWork();
	}

	private void PanelCenterWork() {
		panelCenter.setPreferredSize(new Dimension(500,740));
		panelCenter.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelCenter.setLayout(flow);
		panelCenter.add(scroll);
		scroll.setPreferredSize(new Dimension(440,680));
	}

	private void PanelWestWork() {
		panelWest.setPreferredSize(new Dimension(650,740));
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
		panelWestSouth.setPreferredSize(new Dimension(650,100));
		panelWestSouth.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setVgap(25);
		flow.setHgap(25);
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
		panelWestCenter.setPreferredSize(new Dimension(650,540));
		panelWestCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterWest,BorderLayout.WEST);
		PanelWestCenterWestWork();
		panelWestCenter.add(panelWestCenterCenter,BorderLayout.CENTER);
		PanelWestCenterCenterWork();
	}

	private void PanelWestCenterCenterWork() {
		panelWestCenterCenter.setPreferredSize(new Dimension(220,540));
	//	panelWestCenterCenter.setBorder(BorderFactory.createRaisedBevelBorder());
		
		FlowLayout flow=new FlowLayout();
		panelWestCenterCenter.setLayout(flow);
		flow.setVgap(45);
		
		panelWestCenterCenter.add(lblUpload);
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		lblUpload.setPreferredSize(new Dimension(150,160));
		panelWestCenterCenter.add(btnUpload);
		btnUpload.setPreferredSize(new Dimension(80,40));
		btnUpload.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void PanelWestCenterWestWork() {
		panelWestCenterWest.setPreferredSize(new Dimension(430,540));
		//panelWestCenterWest.setBorder(BorderFactory.createRaisedBevelBorder());
			
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenterWest.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestCenterWest.add(lblUserID, c);
		lblUserID.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelWestCenterWest.add(txtUserID, c);
		c.gridx=0;
		c.gridy=1;
		panelWestCenterWest.add(lblName, c);
		lblName.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelWestCenterWest.add(txtName, c);
		c.gridx=0;
		c.gridy=2;
		panelWestCenterWest.add(lblUserName, c);
		lblUserName.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelWestCenterWest.add(txtUserName, c);
		c.gridx=0;
		c.gridy=3;
		panelWestCenterWest.add(lblDesignation, c);
		lblDesignation.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelWestCenterWest.add(txtDesignation, c);
		c.gridx=0;
		c.gridy=4;
		panelWestCenterWest.add(lblPassword, c);
		lblPassword.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=4;
		panelWestCenterWest.add(txtPassword, c);
		c.gridx=0;
		c.gridy=5;
		panelWestCenterWest.add(lblDate, c);
		lblDate.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=5;
		panelWestCenterWest.add(dcDate, c);
		dcDate.setDate(new Date());
		c.gridx=0;
		c.gridy=6;
		panelWestCenterWest.add(lblActivation, c);
		lblActivation.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=6;
		panelWestCenterWest.add(txtActivation, c);
		c.gridx=0;
		c.gridy=7;
		panelWestCenterWest.add(lblEmailAddress, c);
		lblEmailAddress.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=7;
		panelWestCenterWest.add(txtEmailAddress, c);
		c.gridx=0;
		c.gridy=8;
		panelWestCenterWest.add(lblNationalID, c);
		lblNationalID.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=8;
		panelWestCenterWest.add(txtNationalID, c);
		c.gridx=0;
		c.gridy=9;
		panelWestCenterWest.add(lblAddress, c);
		lblAddress.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=9;
		panelWestCenterWest.add(scrollArea, c);
		txtArea.setLineWrap(true);
		c.gridx=0;
		c.gridy=10;
		panelWestCenterWest.add(lblMobil, c);
		lblMobil.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=10;
		panelWestCenterWest.add(txtMobile, c);
	}

	private void PanelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(650,100));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelWestNorth.setLayout(flow);
		flow.setVgap(20);
		flow.setHgap(20);
		panelWestNorth.add(stSuggestText.cmbSuggest);
		stSuggestText.cmbSuggest.setPreferredSize(new Dimension(300,40));
		panelWestNorth.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(80,40));
		btnSearch.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	//	setBackground(Color.YELLOW);				
	}
}