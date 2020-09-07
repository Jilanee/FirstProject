package com.example.MenuItem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import com.toedter.calendar.JDateChooser;

public class ClientInfo extends JPanel{
	//Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
	JPanel panelwest=new JPanel();
	JPanel panelcenter=new JPanel();
	
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterOfCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JPanel panelWestCenterWest=new JPanel();
	JPanel panelWestCenterCenter=new JPanel();
	
	JLabel lblUpload =new JLabel();          //panel west center
	JButton btnUpload=new JButton("Upload");
	
	JButton btnSearch=new JButton("Search");
	SuggestText stSuggestText=new SuggestText();  //panel west north


	String col[]={"Client ID","Name","Mobile No","Email"}; //panel center
	Object row[][]={};
	DefaultTableModel model=new DefaultTableModel(row,col);
	JTable table=new JTable(model);
	JScrollPane scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JLabel lblclientid=new JLabel("Client ID");        //  panel west west
	JLabel lblclientName=new JLabel("Client Name");
	JLabel lblgender=new JLabel("Gender");
	JLabel lblfathersname=new JLabel("Fathers Name");
	JLabel lblmothersname=new JLabel("Mothers Name");
	JLabel lblreligon=new JLabel("Religon");
	JLabel lbldateofbirth=new JLabel("Date Of Birth");
	JLabel lblDateofjoin=new JLabel("Date of Join");
	JLabel lblmobilno=new JLabel("Mobil No");
	JLabel lbladdress=new JLabel("Address");
	JLabel lblemail=new JLabel("Email");
	JLabel lblnationalid=new JLabel("National ID");
	JLabel lblnationality=new JLabel("Nationality");
	JLabel lblusername=new JLabel("User name");
	JLabel lblreference=new JLabel("Reference");
	
	JDateChooser dcdateofbirth=new JDateChooser();
	JDateChooser dcdateofjoin=new JDateChooser();
	
	SuggestText stGender=new SuggestText();
	SuggestText stReligon=new SuggestText();
	SuggestText stNationality=new SuggestText();
	SuggestText stReference=new SuggestText();

	String ara[]={"","Male","Female",};
    JComboBox<String>cmbgender=new JComboBox<String>(ara);
    
	JTextArea txtArea=new JTextArea(4,6);
	JScrollPane scrollArea=new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	JTextField txtclientid=new JTextField(15);
	JTextField txtclientName=new JTextField(15);
	JTextField txtfathersname=new JTextField(15);
	JTextField txtmothersname=new JTextField(15);
	JTextField txtmobileno=new JTextField(15);
	JTextField txtemail=new JTextField(15);
	JTextField txtnationalid=new JTextField(15);
	JTextField txtusername=new JTextField(15);

	JButton btnAdd=new JButton("Add");     //panel west south
	JButton btnEdit=new JButton("Edit");
	JButton btnRefresh=new JButton("Refresh");
	JButton btnDelete=new JButton("Delete");
	
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");

	JFileChooser filechooser=new JFileChooser();
    File file=null;
    boolean isUpdate=false;
    int flag=0;
	public ClientInfo()
	{
		init();
		cmp();
		btnAction();
		btnInit(true);
	}
    private void btnInit(boolean b) {
		btnAdd.setEnabled(b);
		btnEdit.setEnabled(!b);
	}
	public void AutoIdClient(){
    	String sql="select ifnull(max(cast(subString(ClientID,locate('-',ClientID)+1,"+
  "length(ClientID)-locate('-',ClientID)) as unsigned)),0)+1 ClientID from tbclientinfo";
        
    	try{
    		DBConnection.Connection();
    		ResultSet rs=DBConnection.sat.executeQuery(sql);
    		if(rs.next()){
    			String ClientID=rs.getString("ClientID");
    			txtclientid.setText("CI-"+ClientID);
    		}
    		DBConnection.con.close();
    	}
        catch(Exception exp){
        	JOptionPane.showMessageDialog(null, exp);
        }
    }
	private boolean checkValidation(){
	    if(!txtclientid.getText().trim().isEmpty()){
	    	if(!txtclientName.getText().trim().isEmpty()){
	    		if(cmbgender.getSelectedItem()!=null && cmbgender.getSelectedIndex()!=0){
	    			if(!txtfathersname.getText().trim().isEmpty()){
	    				if(!txtmothersname.getText().trim().isEmpty()){
	    					if(!stReligon.txtSuggest.getText().trim().isEmpty()){
	    						if(!dcdateofbirth.getDate().toString().trim().isEmpty()){
	    							if(!dcdateofjoin.getDate().toString().trim().isEmpty()){
	    								if(!txtmobileno.getText().trim().isEmpty()){
	    									if(!txtArea.getText().trim().isEmpty()){
	    										if(!txtemail.getText().trim().isEmpty()){
	    											if(!txtnationalid.getText().trim().isEmpty()){
	    												if(!stNationality.txtSuggest.getText().trim().isEmpty()){
	    													if(!txtusername.getText().trim().isEmpty()){
	    														if(!stReference.txtSuggest.getText().trim().isEmpty()){
	    															return true;
	    														}
	    														else{
	    															JOptionPane.showMessageDialog(null, "Please insert Reference");
	    														}
	    													}
	    													else{
	    														JOptionPane.showMessageDialog(null, "Please insert User Name");
	    													}
	    												}
	    												else{
	    													JOptionPane.showMessageDialog(null, "Please insert Nationality");
	    												}
	    											}
	    											else{
	    												JOptionPane.showMessageDialog(null, "Please insert National ID");
	    											}
	    										}
	    										else{
	    											JOptionPane.showMessageDialog(null, "Please insert E-mail");
	    										}
	    									}
	    									else{
	    										JOptionPane.showMessageDialog(null, "Please insert Address");
	    									}
	    								}
	    								else{
	    									JOptionPane.showMessageDialog(null, "Please insert Mobile No");
	    								}
	    							}
	    							else{
	    								JOptionPane.showMessageDialog(null, "Please insert Date of Join");
	    							}
	    						}
	    						else{
	    							JOptionPane.showMessageDialog(null, "Please insert Date of Birth");
	    						}
	    					}
	    					else{
	    						JOptionPane.showMessageDialog(null, "Please insert Religon");
	    					}
	    				}
	    				else{
	    					JOptionPane.showMessageDialog(null, "please insert Mother's Name");
	    				}
	    			}
	    			else{
	    				JOptionPane.showMessageDialog(null, "Please insert Father's Name");
	    			}
	    		}
	    		else{
	    			JOptionPane.showMessageDialog(null, "Please insert Gender");
	    		}
	    	}
	    	else{
	    		JOptionPane.showMessageDialog(null, "please insert Client Name");
	    	}
	    }
	    else{
	    	JOptionPane.showMessageDialog(null, "Please insert Client ID");
	    }
		return false;
	}
	
	private boolean isExistClientName(){
		try{
			String sql="select * from tbClientInfo "
					+ "where ClientName='"+txtclientName.getText().trim()+"'";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "Client name Already Exist");
				return false;
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		return true;
	}
	
	private boolean isExistClientID(){
		try{
			String sql="select * from tbclientinfo where "
					+ "ClientID='"+txtclientid.getText().trim()+"'";
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
		JOptionPane.showMessageDialog(null, "ID Does not Exist");
		return false;
	}
	
	private boolean checkConfirmation(String caption){
		int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	private void UploadImageSave(String ClientID){
		try{
			File fileDirectory=new File("D:/Software/SaveImages/ClientImages");
			if(!fileDirectory.isDirectory()){
				fileDirectory.mkdirs();
			}
			File imagePath=new File(fileDirectory.getPath()+"/"+ClientID+".jpg");
			if(imagePath.exists()&&flag==1){
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
		
		UploadImageSave(txtclientid.getText().trim());
		if(new File("D:/Software/SaveImages/ClientImages/"+txtclientid.getText().trim()+".jpg").exists())
		{
			pic="D:/Software/SaveImages/ClientImages/"+txtclientid.getText().trim()+".jpg";
		}
		 String sql="insert into tbclientinfo(ClientID,ClientName,Gender,FathersName,"
		 		+ "MothersName,Religion,DateOfBirth,DateOfJoin,MobileNo,Address,Email,"
		 		+ "NationalID,Nationality,UserName,Reference,Picture,entryTime,UserIp)"
		 		+ "values"		
		 		+ "('"+txtclientid.getText().trim()+"'"
		 		+ ",'"+txtclientName.getText().trim()+"'"
		 		+ ",'"+cmbgender.getSelectedItem().toString().trim()+"'"
		 		+ ",'"+txtfathersname.getText().trim()+"'"
		 		+ ",'"+txtmothersname.getText().trim()+"'"
		 		+ ",'"+stReligon.txtSuggest.getText().trim()+"'"
		 		+ ",'"+dateFormat.format(dcdateofbirth.getDate())+"'"
		 		+ ",'"+dateFormat.format(dcdateofjoin.getDate())+"'"
		 		+ ",'"+txtmobileno.getText().trim()+"'"
		 		+ ",'"+txtArea.getText().trim()+"',"
		 		+ "'"+txtemail.getText().trim()+"'"
		 		+ ",'"+txtnationalid.getText().trim()+"'"
		 		+ ",'"+stNationality.txtSuggest.getText().trim()+"',"
		 		+ "'"+txtusername.getText().trim()+"'"
		 		+ ",'"+stReference.txtSuggest.getText().trim()+"'"
		 		+ ",'"+pic+"'"
		 		+ ",now()"
		 		+ ",'127.0.0.2')";
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
		txtclientid.setText("");
		txtclientName.setText("");
		cmbgender.setSelectedItem("");
		txtfathersname.setText("");
		txtmothersname.setText("");
		stReligon.txtSuggest.setText("");
		dcdateofbirth.setDate(new Date());
		dcdateofjoin.setDate(new Date());
		txtmobileno.setText("");
		txtArea.setText("");
		txtemail.setText("");
		txtnationalid.setText("");
		stNationality.txtSuggest.setText("");
		txtusername.setText("");
		stReference.txtSuggest.setText("");
		lblUpload.setIcon(new ImageIcon(""));
		flag=0;
		stSuggestText.txtSuggest.setText("");
	}
	
	public void tableDataLoad(){
		
		for(int a=model.getRowCount()-1;a>=0;a--){
			model.removeRow(a);
		}
		
		try{
			String sql="select ClientID,ClientName,MobileNo,Email from tbclientinfo";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next())
			{
			  model.addRow(new Object[]{rs.getString("ClientID"),rs.getString("ClientName"),
					  rs.getString("MobileNo"),rs.getString("Email")});
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	public void SuggestTextDataLoad(){
		try{
			String sql="select ClientID,ClientName from tbclientinfo";
			stSuggestText.vector.clear();
			stSuggestText.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next())
			{
				stSuggestText.vector.add(rs.getString("ClientID")+" # "+rs.getString("ClientName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void FindDataLoad(String ClientID){
		txtClear();
		String sql="select ClientID,ClientName,Gender,FathersName,MothersName,Religion,"
				+ "DateOfJoin,DateOfBirth,MobileNo,Address,Email,NationalID,Nationality,"
				+ "UserName,Reference,ifnull(Picture,'')pic from tbclientinfo "
				+ "where ClientID='"+ClientID+"'";
		try{
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
            while(rs.next()){
            	txtclientid.setText(rs.getString("ClientID"));
            	txtclientName.setText(rs.getString("ClientName"));
            	cmbgender.setSelectedItem(rs.getString("Gender"));
            	txtfathersname.setText(rs.getString("FathersName"));
            	txtmothersname.setText(rs.getString("MothersName"));
            	stReligon.txtSuggest.setText(rs.getString("Religion"));
            	dcdateofjoin.setDate(rs.getDate("DateOfJoin"));
            	dcdateofbirth.setDate(rs.getDate("DateOfBirth"));            	
            	txtmobileno.setText(rs.getString("MobileNo"));
            	txtArea.setText(rs.getString("Address"));
            	txtemail.setText(rs.getString("Email"));
            	txtnationalid.setText(rs.getString("NationalID"));
            	stNationality.txtSuggest.setText(rs.getString("Nationality"));
            	txtusername.setText(rs.getString("UserName"));
            	stReference.txtSuggest.setText(rs.getString("Reference"));
            	
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
	
	public void btnUploadAction(){
		try{
       		new JFileChooser();
       		FileNameExtensionFilter filter=new FileNameExtensionFilter("Images","JPG","PNG","gif","JPEG");
            filechooser.setFileFilter(filter);
            filechooser.showOpenDialog(null);
            file=filechooser.getSelectedFile();
            if(file!=null){
           	 Image img=Toolkit.getDefaultToolkit().getImage(file.getPath()); 
                Image resize=img.getScaledInstance(lblUpload.getWidth(), lblUpload.getHeight(),Image.SCALE_DEFAULT);
                ImageIcon icon=new ImageIcon(resize);
                lblUpload.setIcon(icon);
                flag=1;
           }
      	}
      	catch(Exception exp){
      		JOptionPane.showMessageDialog(null, exp);
      	}       
	}
	
	private boolean DeleteData(){
		try{
			String sql="delete  from tbclientinfo where ClientID='"+txtclientid.getText()+"'";
		    DBConnection.Connection();
		    DBConnection.sat.executeUpdate(sql);
		    return true;
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	private void btnAction() {
        btnAdd.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(isUpdate){
					if(checkValidation()){
						if(isExistClientID()){
							if(checkConfirmation("Sure to Update ?")){
								if(DeleteData()){
									if(insertData()){
										JOptionPane.showMessageDialog(null, "All Information Update Successfully");
									    txtClear();
									    AutoIdClient();
									    tableDataLoad();
									    SuggestTextDataLoad();
									}
								}
							}
						}
					}
				}
				else					
				{
				    if(checkValidation()){
						if(isExistClientName()){
							if(checkConfirmation("Sure to Save ?")){
								if(insertData()){
									JOptionPane.showMessageDialog(null, "All Information save Successfully");
								    txtClear();
								    AutoIdClient();
								    tableDataLoad();
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
				btnInit(true);
				isUpdate=true;
			}
        	
        });
        
        btnRefresh.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClear();
				AutoIdClient();
				btnInit(true);
				isUpdate=false;
			}
        	
        });
        
        btnDelete.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidation()){
					if(isExistClientID()){
						if(checkConfirmation("Sure to Delete?")){
							if(DeleteData()){
								txtClear();
								AutoIdClient();
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
    			btnUploadAction();
    		}
        	});
        
    	table.addMouseListener(new MouseListener(){
      	    public void mouseClicked(MouseEvent e){
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
       stSuggestText.cmbSuggest.addActionListener(new ActionListener(){

		  public void actionPerformed(ActionEvent e) {
			  String ClientID=stSuggestText.txtSuggest.getText().trim();
			  StringTokenizer token=new StringTokenizer(ClientID,"#");
			  FindDataLoad(token.nextToken());
		}
     });
     
	}
   
	private void cmp(){
		add(panelwest,BorderLayout.WEST);
		panelwestwork();
		add(panelcenter,BorderLayout.CENTER);
		panelcentrework();
	}
	private void panelcentrework() {
		panelcenter.setPreferredSize(new Dimension(575,735));
		panelcenter.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelcenter.setLayout(flow);
		panelcenter.add(scroll);
		scroll.setPreferredSize(new Dimension(530,670));	
	}
  
	private void panelwestwork() {
		panelwest.setPreferredSize(new Dimension(575,750));
		panelwest.setBorder(BorderFactory.createTitledBorder(""));	
		
		panelwest.setLayout(new BorderLayout());
		panelwest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthWork();
		panelwest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterWork();
		panelwest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthWork();
	}

	private void panelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(575,80));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		
		GridBagConstraints c=new GridBagConstraints();
		panelWestNorth.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWestNorth.add(stSuggestText.cmbSuggest);
		stSuggestText.cmbSuggest.setPreferredSize(new Dimension(250,40));
		
		c.gridx=1;
		c.gridy=0;
		c.insets=new Insets(2,2,2,40);  //TLBR
		panelWestNorth.add(btnSearch);
		btnSearch.setPreferredSize(new Dimension(100,40));
		btnSearch.setFont(new Font("Arial Rounded MT Bold",Font.BOLD+Font.ITALIC,16));
	}

	private void panelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(575,570));
		panelWestCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelWestCenter.setLayout(new BorderLayout());
		panelWestCenter.add(panelWestCenterWest,BorderLayout.WEST);
		PanelWestCenterWestWork();
		panelWestCenter.add(panelWestCenterCenter);
		PanelWestCenterCenterWork();
	}

	private void PanelWestCenterWestWork() {
		panelWestCenterWest.setPreferredSize(new Dimension(350,570));
		//panelWestCenterWest.setBorder(BorderFactory.createTitledBorder(""));
		
		GridBagConstraints c=new GridBagConstraints();
		panelWestCenterWest.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
        c.gridx=0;
        c.gridy=0;
        panelWestCenterWest.add(lblclientid, c);
        lblclientid.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=0;
        panelWestCenterWest.add(txtclientid, c);
        c.gridx=0;
        c.gridy=1;
        panelWestCenterWest.add(lblclientName, c);
        lblclientName.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=1;
        panelWestCenterWest.add(txtclientName, c);
        c.gridx=0;
        c.gridy=2;
        panelWestCenterWest.add(lblgender, c);
        lblgender.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=2;
        panelWestCenterWest.add(cmbgender, c);
        c.gridx=0;
        c.gridy=3;
        panelWestCenterWest.add(lblfathersname, c);
        lblfathersname.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=3;
        panelWestCenterWest.add(txtfathersname, c);
        c.gridx=0;
        c.gridy=4;
        panelWestCenterWest.add(lblmothersname, c);
        lblmothersname.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=4;
        panelWestCenterWest.add(txtmothersname, c);
        c.gridx=0;
        c.gridy=5;
        panelWestCenterWest.add(lblreligon, c);
        lblreligon.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=5;
        panelWestCenterWest.add(stReligon.cmbSuggest, c);
        c.gridx=0;
        c.gridy=6;
        panelWestCenterWest.add(lbldateofbirth, c);
        lbldateofbirth.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=6;
        panelWestCenterWest.add(dcdateofbirth, c);
        dcdateofbirth.setDateFormatString("dd-MM-yyyy");
        dcdateofbirth.setDate(new Date());
        c.gridx=0;
        c.gridy=7;
        panelWestCenterWest.add(lblDateofjoin, c);
        lblDateofjoin.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=7;
        panelWestCenterWest.add(dcdateofjoin, c);
        dcdateofjoin.setDateFormatString("dd-MM-yyyy");
        dcdateofjoin.setDate(new Date());
        c.gridx=0;
        c.gridy=8;
        panelWestCenterWest.add(lblmobilno, c);
        lblmobilno.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=8;
        panelWestCenterWest.add(txtmobileno, c);
        c.gridx=0;
        c.gridy=9;
        panelWestCenterWest.add(lbladdress, c);
        lbladdress.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=9;
        panelWestCenterWest.add(scrollArea, c);
        txtArea.setLineWrap(true);
        c.gridx=0;
        c.gridy=10;
        panelWestCenterWest.add(lblemail, c);
        lblemail.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=10;
        panelWestCenterWest.add(txtemail, c);
        c.gridx=0;
        c.gridy=11;
        panelWestCenterWest.add(lblnationalid, c);
        lblnationalid.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=11;
        panelWestCenterWest.add(txtnationalid,c);
        c.gridx=0;
        c.gridy=12;
        panelWestCenterWest.add(lblnationality, c);
        lblnationality.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=12; 	
        panelWestCenterWest.add(stNationality.cmbSuggest,c);
        c.gridx=0;
        c.gridy=13;
        panelWestCenterWest.add(lblusername, c);
        lblusername.setFont(new Font("Sherif",Font.BOLD,14));
        c.gridx=1;
        c.gridy=13;
        panelWestCenterWest.add(txtusername, c);
        c.gridx=0;
        c.gridy=14;
		panelWestCenterWest.add(lblreference, c);
		lblreference.setFont(new Font("Sherif",Font.BOLD,14));
		 c.gridx=1;
	     c.gridy=14;
		panelWestCenterWest.add(stReference.cmbSuggest, c);
	}

	private void PanelWestCenterCenterWork() {
		panelWestCenterCenter.setPreferredSize(new Dimension(220,570));
		//panelWestCenterCenter.setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, Color.BLUE));
	//	panelWestCenterCenter.setBorder(BorderFactory.createLineBorder(Color.cyan));
		FlowLayout flow=new FlowLayout();
		panelWestCenterCenter.setLayout(flow);
		flow.setVgap(15);
		
		panelWestCenterCenter.add(lblUpload);
		lblUpload.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblUpload.setPreferredSize(new Dimension(150,160));
		panelWestCenterCenter.add(btnUpload);
		btnUpload.setPreferredSize(new Dimension(80,40));
		btnUpload.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelWestSouthWork() {
		panelWestSouth.setPreferredSize(new Dimension(575,50));
		//panelWestSouth.setBorder(BorderFactory.createTitledBorder(""));

		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		flow.setHgap(10);
		flow.setVgap(5);
		
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

	private void init(){
		setPreferredSize(new Dimension(1150,735));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	}

}