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
import java.sql.SQLException;
import java.util.StringTokenizer;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;

public class Catagory extends JPanel{
	JPanel panelWest=new JPanel();
	JPanel panelCenter=new JPanel();
	
	JPanel panelWestNorth=new JPanel();
	JPanel panelWestCenter=new JPanel();
	JPanel panelWestSouth=new JPanel();

	JPanel panelCenterNorth=new JPanel();
	JPanel panelCenterCenter=new JPanel();
	JPanel panelCenterSouth=new JPanel();

	JPanel panelCenterUpper=new JPanel();
	JPanel panelCenterLower=new JPanel();

	JPanel panelWestCenterUpper=new JPanel();
	JPanel panelWestCenterLower=new JPanel();	

	//String arr[]={};               //panel west north
	SuggestText SuggestTextCatagory=new SuggestText();
	JButton btnCatSearch=new JButton("Search",new ImageIcon("Images/"));
	
	JLabel lblCatagoryID_panelwest=new JLabel("Catagory ID");  //panel west center upper
	JLabel lblCatagoryName_panelwest=new JLabel("Catagory Name");
	JLabel lblUserName_panelwest=new JLabel("User Name");
	
	JTextField txtCatagoryID=new JTextField(20);
	JTextField txtCatagoryName=new JTextField(20);
	JTextField txtUserName=new JTextField(20);

	JButton btnAddCat=new JButton("Add");                 //panel west center lower
	JButton btnEditCat=new JButton("Edit");
	JButton btnRefreshCat=new JButton("Refresh");
	JButton btnDeleteCat=new JButton("Delete");
	   
	String column[]={"Category ID","Category Name","User Name"};   //panel west south
	Object row[][]={};
    DefaultTableModel model=new DefaultTableModel(row,column);
    JTable  tableCatagory=new JTable(model);
    JScrollPane scrollCategory=new JScrollPane(tableCatagory,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
   
	//String subarr[]={"","","","","","","","","","","","","",};      //panel center north
	SuggestText SuggestTextSubCatagory=new SuggestText();
	JButton btnSubCatSearch=new JButton("Search",new ImageIcon("Images/"));
	
	
	JLabel lblCatagoryID_panelcenter=new JLabel("Catagory ID");   //panel center center upper 
	JLabel lblSubCatagoryID_panelcenter=new JLabel("SubCatagory ID");
	JLabel lblSubCatagoryName_panelcenter=new JLabel("Subcatagory Name");
	JLabel lblName_panelcenter=new JLabel("User Name");

	SuggestText SuggestTextCatagoryIDSub=new SuggestText();
	JTextField txtSubCatagoryID=new JTextField(20);
	JTextField txtSubCatagoryName=new JTextField(20);
	JTextField txtSubUserName=new JTextField(20);

	JButton btnAddSubCat=new JButton("Add");                //panel center lower
	JButton btnEditSubCat=new JButton("Edit");
	JButton btnRefreshSubCat=new JButton("Refresh");
	JButton btnDeleteSubCat=new JButton("Delete");
	
	String columnsubcat[]={"Category ID","SubCatagory ID","SubCategoryName","UserName"};//panel center south
	Object rowsubcat[][]={};
    DefaultTableModel modelsubcat=new DefaultTableModel(rowsubcat,columnsubcat){
    	private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
			return false;
		}
    };
    JTable  tableSubCatagory=new JTable(modelsubcat);
    JScrollPane scrollSubCategory=new JScrollPane(tableSubCatagory,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    
    Boolean isUpdate=false;
    Boolean isUpdateSubCat=false;
	public Catagory(){
		init();
		cmp();
		btnAction();
		btnInitCat(true);
		btnInitSubCat(true);
	}
	
	private void btnInitSubCat(boolean b) {
		    btnAddSubCat.setEnabled(b);
		    btnEditSubCat.setEnabled(!b);
	}

	private void btnInitCat(boolean b) {    	
    		btnAddCat.setEnabled(b);
    		btnEditCat.setEnabled(!b);
	}

	public void autoIdCat(){
		String sql="select ifnull(max(cast(subString(catId,locate('-',catId)+1,"+
     "length(catId)-locate('-',catId)) as unsigned)),0)+1 id from tbCatagoryinfo";
		
		try{
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				String id=rs.getString("id");
				txtCatagoryID.setText("Cat-"+id);
			}
	        DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		
	}
	
    private boolean CheckValidationCatagory(){
		if(!txtCatagoryID.getText().trim().isEmpty()){
			if(!txtCatagoryName.getText().trim().isEmpty()){
				if(!txtUserName.getText().trim().isEmpty()){
					return true;
				}
				else{
					JOptionPane.showMessageDialog(null, "Please Insert User Name");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please Insert Catagory Name");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Please Insert Catagory ID");
		}
		return false;
	}
    
    private boolean isExistCatagoryName(){
		try{
			String sql="select *from tbCatagoryInfo where catagoryName='"+txtCatagoryName.getText().trim()+"'";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "CatagoryName Already Exist");
				return false;
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
		return true;
	}
    
    private boolean isExistCatagoryID() {
		try{
			String sql="select *from tbCatagoryInfo where catId='"+txtCatagoryID.getText().trim()+"'";
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
		
		JOptionPane.showMessageDialog(null, "Id does not Exist");
		return false;
	}
    
	private boolean checkConfirmationCatagory(String caption){
		int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
	
	private boolean insertDataCatagory(){
		String sql="insert into tbcatagoryinfo (catid,catagoryName,userName,userIp,entryTime)values"+
           "('"+txtCatagoryID.getText().trim()+"'"
         	+ ",'"+txtCatagoryName.getText().trim()+"',"
         	+ "'"+txtUserName.getText().trim()+"',"
         	+ "'',now())";
		try {
			DBConnection.Connection();
			DBConnection.sat.executeUpdate(sql);
			DBConnection.con.close();
			return true;
		} 
		catch (Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
		return false;
	}
	
	private boolean deleteDataCatagory() {
		   try{
			   String sql="delete from tbcatagoryinfo where catid='"+txtCatagoryID.getText()+"'";
			   DBConnection.Connection();
			   DBConnection.sat.executeUpdate(sql);
			   return true;
		   }
		   catch(Exception exp){
			   JOptionPane.showMessageDialog(null, exp);
		   }
			return false;
		}
	
	public void tableDataLoadCatagory(){
		for(int a=model.getRowCount()-1;a>=0;a--){
			model.removeRow(a);
		}
		
		try {
			String sql="select catid,catagoryName,userName from tbcatagoryinfo";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				model.addRow(new Object[] {rs.getString("catid"),rs.getString("catagoryName"),
						rs.getString("userName")});
			}
	        DBConnection.con.close();	
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void txtClearCatagory(){
		txtCatagoryID.setText("");
		txtCatagoryName.setText("");
		txtUserName.setText("");
		SuggestTextCatagory.txtSuggest.setText("");
	}
	public  void cmbSearchCatagoryDataLoad(){
		
		try {
			String sql="select catid,catagoryName from tbcatagoryinfo";
			SuggestTextCatagory.vector.clear();
			SuggestTextCatagory.vector.add(" ");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				//System.out.println(rs.getString("catid")+ "#" +rs.getString("catagoryName"));
				SuggestTextCatagory.vector.add(rs.getString("catid")+ "#" +rs.getString("catagoryName"));
			}
	        DBConnection.con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
	private void findDataLoadCatagory(String id) {
		String sql="select catid,catagoryName,userName from "
				+ "tbcatagoryinfo where catid='"+id+"'";
		try{
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				txtCatagoryID.setText(rs.getString("catid"));
				txtCatagoryName.setText(rs.getString("catagoryName"));
				txtUserName.setText(rs.getString("userName"));
			}
			btnInitCat(false);
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	
   public  void cmbSubCatagoryDataLoad(){
		
		try {
			String sql="select catid,catagoryName from tbcatagoryinfo";
			SuggestTextCatagoryIDSub.vector.clear();
			SuggestTextCatagoryIDSub.vector.add(" ");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			System.out.println(sql);
			while(rs.next()){
				//System.out.println(rs.getString("catid")+ "#" +rs.getString("catagoryName"));
				SuggestTextCatagoryIDSub.vector.add(rs.getString("catid")+ "#" +rs.getString("catagoryName"));
			}
	        DBConnection.con.close();
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}

    public void autoIdSubCat(){      //subcatagory
    	String sql="select ifnull(max(cast(subString(subcatagoryid,locate('-',subcatagoryid)+1," +
        "length(subcatagoryid)-locate('-',subcatagoryid)) as unsigned)),0)+1 id from tbsubcatagoryinfo"; 
        
        try{
        	DBConnection.Connection();
        	ResultSet rs=DBConnection.sat.executeQuery(sql);
        	if(rs.next()){
        		String id=rs.getString("id");
        		txtSubCatagoryID.setText("SubCat-"+id);
        	}
            DBConnection.con.close();
        }
        
        catch(Exception exp ){
        	JOptionPane.showMessageDialog(null, exp);
        }
		
	}
	
   private boolean checkValidationSubCatagory(){
	   
		if(!SuggestTextCatagoryIDSub.txtSuggest.getText().trim().isEmpty()){
			if(!txtSubCatagoryID.getText().trim().isEmpty()){
				if(!txtSubCatagoryName.getText().trim().isEmpty()){
					if(!txtSubUserName.getText().trim().isEmpty()){
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "Please insert User Name");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please insert SubCatagory Name");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Please insert CatagoryID");
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "Please insert CatagoryID");
		}
		return false;
	}
   
	private boolean isExistSubCatagoryName(){
		String idName=SuggestTextCatagoryIDSub.txtSuggest.getText().trim();
		StringTokenizer token=new StringTokenizer(idName,"#");
		
		try{
			String sql="select * from tbsubcatagoryinfo "
					+ "where catagoryid='"+token.nextToken()+"' "
					+ "and subcatagoryName='"+txtSubCatagoryName.getText().trim()+"'";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "SubCatagoryName Already Exist");
				return false;
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	    return true;	
	}
	
	private boolean isExistSubCatagoryID(){
		try{
			String sql="select * from tbsubcatagoryinfo where subcatagoryid='"+txtSubCatagoryID.getText().trim()+"'";
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
		return false;
	}
	private boolean checkConfirmationSubCatagory(String caption){
		int a=JOptionPane.showConfirmDialog(null, caption,"Confirmation",JOptionPane.YES_NO_OPTION);
		if(a==JOptionPane.YES_OPTION){
			return true;
		}
		return false;
	}
   
   private boolean insertDataSubCatagory(){
	   String idName=SuggestTextCatagoryIDSub.txtSuggest.getText().trim();
	   StringTokenizer token=new StringTokenizer(idName,"#");
		
	   String sql="insert into tbsubcatagoryinfo (catagoryid,catagoryName,"
	   		+ "subcatagoryid,subcatagoryName,userName,userip,"
	   		+ "entrytime)"
	   		+ "values('"+token.nextToken()+"',"
	   		+ "'"+token.nextToken()+"',"
	   		+ "'"+txtSubCatagoryID.getText().trim()+"',"
	   		+ "'"+txtSubCatagoryName.getText().trim()+"',"
	   		+ "'"+txtSubUserName.getText().trim()+"',"
	   		+ "'127.0.0.2',"
	   		+ "now())";
	   System.out.println(sql);
	   try {
			DBConnection.Connection();
			DBConnection.sat.executeUpdate(sql);
			DBConnection.con.close();
			return true;
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	   return false;
   }
   
   public void tableDataLoadSubCatagory(){
		for(int a=modelsubcat.getRowCount()-1;a>=0;a--){
			modelsubcat.removeRow(a);
		}
		
		try {
			String sql="select catagoryid,subcatagoryid,subcatagoryName,userName from tbsubcatagoryinfo";
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				modelsubcat.addRow(new Object[] {rs.getString("catagoryid"),rs.getString("subcatagoryid"),
						rs.getString("subcatagoryName"),rs.getString("userName")});
			}
	        DBConnection.con.close();	
		}
		catch(Exception exp) {
			JOptionPane.showMessageDialog(null, exp);
		}
	}
   
   private boolean DeleteDataSubCatagory(){
	   try{
		   String sql="delete from tbsubcatagoryinfo where subcatagoryid='"+txtSubCatagoryID.getText()+"'";
		   DBConnection.Connection();
		   DBConnection.sat.executeUpdate(sql);
		   return true;
	   }
	   catch(Exception exp){
		   JOptionPane.showMessageDialog(null, exp);
	   }
	   return false;
   }
   private void txtClearSubCatagory(){
	   SuggestTextCatagoryIDSub.txtSuggest.setText("");
	   txtSubCatagoryID.setText("");
	   txtSubCatagoryName.setText("");
	   txtSubUserName.setText("");
	   SuggestTextSubCatagory.txtSuggest.setText("");
   }
   
   private void findDataLoadSubCatagory(String subcatid){
	   txtClearSubCatagory();
	   //String idName=SuggestTextCatagoryIDSub.txtSuggest.getText().trim();
	   //StringTokenizer token=new StringTokenizer(idName,"#"); 
	   try{
		   String sql="select catagoryid,catagoryName,subcatagoryid,subcatagoryName,"
			   		+ "userName from tbsubcatagoryinfo where subcatagoryid='"+subcatid+"'";
			  
		   DBConnection.Connection();
		   ResultSet rs=DBConnection.sat.executeQuery(sql);
		   while(rs.next()){
			   SuggestTextCatagoryIDSub.txtSuggest.setText(rs.getString("catagoryid")+"#"+rs.getString("catagoryName"));
			   txtSubCatagoryID.setText(rs.getString("subcatagoryid"));
			   txtSubCatagoryName.setText(rs.getString("subcatagoryName"));
			   txtSubUserName.setText(rs.getString("userName"));
		   }
		   btnInitSubCat(false);
		   DBConnection.con.close();
	   }
	   catch(Exception exp){
		   JOptionPane.showMessageDialog(null, exp);
	   }
   }
   
   public void cmbSearchSubCatagoryDataLoad(){
	   try{
		   String sql="select subcatagoryid,subcatagoryName from tbsubcatagoryinfo";
		   SuggestTextSubCatagory.vector.clear();
		   SuggestTextSubCatagory.vector.add("");
		   DBConnection.Connection();
		   ResultSet rs=DBConnection.sat.executeQuery(sql);
		   while(rs.next()){
			   SuggestTextSubCatagory.vector.add(rs.getString("subcatagoryid")+"#"+rs.getString("subcatagoryName"));
		   }
		   DBConnection.con.close();
	   }
	   catch(Exception exp){
		   JOptionPane.showMessageDialog(null, exp);
	   }
   }
   private void btnAction() {
	
		btnAddCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			    if(isUpdate){
			    	if(CheckValidationCatagory()){
			    		if(isExistCatagoryID()){
			    			if(checkConfirmationCatagory("sure to update?")){
			    				if(deleteDataCatagory()){
			    					if(insertDataCatagory()){
			    						JOptionPane.showMessageDialog(null,"Update successfull",
												"**Information**",JOptionPane.INFORMATION_MESSAGE);
			
			    						txtClearCatagory();
					    				autoIdCat();
					    				tableDataLoadCatagory();
					    				cmbSearchCatagoryDataLoad();
					    				cmbSubCatagoryDataLoad();
					    				isUpdate=false;
					    			}
			    				}
			    			}
			    		}
			    	}
			    }
			    else
			    {
			    	 if(CheckValidationCatagory()){
				    	  if(isExistCatagoryName()){
				    		 if(checkConfirmationCatagory("Sure to Save?")){
				    		    if(insertDataCatagory()){
				    				JOptionPane.showMessageDialog(null, "All Information save Successfully");
				    				txtClearCatagory();
				    				autoIdCat();
				    				tableDataLoadCatagory();
				    				cmbSearchCatagoryDataLoad();
				    				cmbSubCatagoryDataLoad();
				    			}
				    		}
				    	 }
				     }
			    }
			}

		});
		
		btnEditCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				btnInitCat(true);
                isUpdate=true;
			}
			
		});
		btnRefreshCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtClearCatagory();
				autoIdCat();
				btnInitCat(true);
                isUpdate=false;
			}
		});
		btnDeleteCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(CheckValidationCatagory()){
					if(isExistCatagoryID()){
                      if(checkConfirmationCatagory("Sure to delete")){
                    	  if(deleteDataCatagory()){
                    		  txtClearCatagory();
			    			  autoIdCat();
			    			  tableDataLoadCatagory();
			    			  cmbSearchCatagoryDataLoad();
			    			  cmbSubCatagoryDataLoad();
                    		  JOptionPane.showMessageDialog(null, "Delete Data successfully");
                    	  }
                      }
					}
				}
			}
			
		});
		
		btnAddSubCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				 if(isUpdateSubCat){
					if(checkValidationSubCatagory()){
					    if(isExistSubCatagoryID()){
					    	if(checkConfirmationSubCatagory("Sure to Update?")){
					    		if(DeleteDataSubCatagory()){
					    			if(insertDataSubCatagory()){
					    				txtClearSubCatagory();
					    				autoIdSubCat();
					    				DeleteDataSubCatagory();
					    				cmbSearchSubCatagoryDataLoad();
					    				isUpdateSubCat=false;
					    				JOptionPane.showMessageDialog(null, "All Information Update Successfully");
					    			}
					    		}
					    	}
					    }
					}
				 }
				 else
				 {
					 if(checkValidationSubCatagory()){
						   if(isExistSubCatagoryName()){
							 if(checkConfirmationSubCatagory("Sure to Save?")){
								if(insertDataSubCatagory()){
										txtClearSubCatagory();
										autoIdSubCat();
										tableDataLoadSubCatagory();
										cmbSearchSubCatagoryDataLoad();
										JOptionPane.showMessageDialog(null,"All Information Save Successfully");
									 }
								  }
							   }
						   }
				      }
			   }		
		});
		
		btnEditSubCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				btnInitSubCat(true);
				isUpdateSubCat=true;
			}	
		});
		
		btnRefreshSubCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				txtClearSubCatagory();
				autoIdSubCat();
				isUpdateSubCat=false;
				btnInitSubCat(true);
			}	
		});
		
		btnDeleteSubCat.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				if(checkValidationSubCatagory()){
					if(isExistSubCatagoryID()){
						if(checkConfirmationSubCatagory("Sure to Delete?")){
							if(DeleteDataSubCatagory()){
								txtClearSubCatagory();
								autoIdSubCat();
								tableDataLoadSubCatagory();
								cmbSearchSubCatagoryDataLoad();
							}
						}
					}
				}
			}	
		});
		
		tableCatagory.addMouseListener(new MouseListener(){

			public void mouseClicked(MouseEvent e) {
				findDataLoadCatagory(model.getValueAt(tableCatagory.getSelectedRow(),0).toString());
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
		SuggestTextCatagory.cmbSuggest.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
			  String id=SuggestTextCatagory.txtSuggest.getText().trim();
              StringTokenizer token=new StringTokenizer(id,"#");
              findDataLoadCatagory(token.nextToken());
			}
		});
       tableSubCatagory.addMouseListener(new MouseListener(){

		public void mouseClicked(MouseEvent e) {
			//System.out.println(modelsubcat.getValueAt(tableSubCatagory.getSelectedRow(), 0).toString());
			findDataLoadSubCatagory(modelsubcat.getValueAt(tableSubCatagory.getSelectedRow(), 1).toString());
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
       SuggestTextSubCatagory.cmbSuggest.addActionListener(new ActionListener(){
    	   
		public void actionPerformed(ActionEvent e) {
			String id=SuggestTextSubCatagory.txtSuggest.getText().trim();
			StringTokenizer token=new StringTokenizer(id,"#");
			findDataLoadSubCatagory(token.nextToken());
		}
    	   
       });
       
	}
   
	private void cmp() {
		add(panelWest,BorderLayout.WEST);
		PanelWestWork();
		add(panelCenter,BorderLayout.CENTER);
		PanelCenterWork();
	}

	private void PanelWestWork() {
        panelWest.setPreferredSize(new Dimension(575,740));	
        panelWest.setBorder(BorderFactory.createTitledBorder(""));
    	panelWest.setLayout(new BorderLayout());
		panelWest.add(panelWestNorth,BorderLayout.NORTH);
		panelWestNorthWork();
		panelWest.add(panelWestSouth,BorderLayout.SOUTH);
		panelWestSouthWork();
		panelWest.add(panelWestCenter,BorderLayout.CENTER);
		panelWestCenterWork();
	}

	private void panelWestNorthWork() {
		panelWestNorth.setPreferredSize(new Dimension(570,100));
		panelWestNorth.setBorder(BorderFactory.createTitledBorder(""));
		
		FlowLayout flow=new FlowLayout();
		panelWestNorth.setLayout(flow);
		flow.setVgap(20);
		flow.setHgap(10);
		panelWestNorth.add(SuggestTextCatagory.cmbSuggest);
		SuggestTextCatagory.cmbSuggest.setPreferredSize(new Dimension(300,40));
		panelWestNorth.add(btnCatSearch);
		btnCatSearch.setPreferredSize(new Dimension(100,40));
		btnCatSearch.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelWestCenterWork() {
		panelWestCenter.setPreferredSize(new Dimension(570,300));
		//panelWestCenter.setBorder(BorderFactory.createTitledBorder(""));		
		panelWestCenter.add(panelWestCenterUpper,BorderLayout.NORTH);
		panelWestCenterUpperWork();
		panelWestCenter.add(panelWestCenterLower,BorderLayout.SOUTH);
		panelWestCenterLowerWork();
	}

	private void panelWestCenterLowerWork() {
		panelWestCenterLower.setPreferredSize(new Dimension(570,80));
		//panelWestCenterLower.setBorder(BorderFactory.createTitledBorder(""));	
		FlowLayout flow=new FlowLayout();
		panelWestCenterLower.setLayout(flow);
		flow.setHgap(20);
		flow.setVgap(6);
		panelWestCenterLower.add(btnAddCat);
		btnAddCat.setPreferredSize(new Dimension(70,40));
		btnAddCat.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestCenterLower.add(btnEditCat);
		btnEditCat.setPreferredSize(new Dimension(70,40));
		btnEditCat.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestCenterLower.add(btnRefreshCat);
		btnRefreshCat.setPreferredSize(new Dimension(100,40));
		btnRefreshCat.setFont(new Font("Sherif",Font.BOLD,14));
		panelWestCenterLower.add(btnDeleteCat);
		btnDeleteCat.setPreferredSize(new Dimension(90,40));
		btnDeleteCat.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelWestCenterUpperWork() {
		panelWestCenterUpper.setPreferredSize(new Dimension(570,220));
		//	panelWestCenterUpper.setBorder(BorderFactory.createTitledBorder(""));
			
			GridBagConstraints c=new GridBagConstraints();
			panelWestCenterUpper.setLayout(new GridBagLayout());
			c.fill=GridBagConstraints.BOTH;
			c.insets=new Insets(2,2,2,2);
			c.gridx=0;
			c.gridy=0;
			panelWestCenterUpper.add(lblCatagoryID_panelwest,c);
			lblCatagoryID_panelwest.setFont(new Font("Sherif",Font.BOLD,14));
			c.gridx=1;
			c.gridy=0;
			panelWestCenterUpper.add(txtCatagoryID,c);
			c.gridx=0;
			c.gridy=1;
			panelWestCenterUpper.add(lblCatagoryName_panelwest,c);
			lblCatagoryName_panelwest.setFont(new Font("Sherif",Font.BOLD,14));
			c.gridx=1;
			c.gridy=1;
			panelWestCenterUpper.add(txtCatagoryName,c);
			c.gridx=0;
			c.gridy=2;
			panelWestCenterUpper.add(lblUserName_panelwest,c);
			lblUserName_panelwest.setFont(new Font("Sherif",Font.BOLD,14));
			c.gridx=1;
			c.gridy=2;
			panelWestCenterUpper.add(txtUserName,c);
	}

	private void panelWestSouthWork() {
		panelWestSouth.setPreferredSize(new Dimension(570,300));
	//	panelWestSouth.setBorder(BorderFactory.createTitledBorder(""));
		FlowLayout flow=new FlowLayout();
		panelWestSouth.setLayout(flow);
		panelWestSouth.add(scrollCategory);
		//tableCatagory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollCategory.setPreferredSize(new Dimension(520,260));
	}

	private void PanelCenterWork() {
		panelCenter.setPreferredSize(new Dimension(575,740));
		panelCenter.setBorder(BorderFactory.createTitledBorder(""));
		panelCenter.setLayout(new BorderLayout());
		panelCenter.add(panelCenterNorth,BorderLayout.NORTH);
		panelCenterNorthWork();
		panelCenter.add(panelCenterCenter,BorderLayout.CENTER);
		panelCenterOfCenterWork();
		panelCenter.add(panelCenterSouth,BorderLayout.SOUTH);
		panelCenterSouthWork();
	}

	private void panelCenterNorthWork() {
		panelCenterNorth.setPreferredSize(new Dimension(570,100));
		panelCenterNorth.setBorder(BorderFactory.createTitledBorder(""));
		FlowLayout flow=new FlowLayout();
		panelCenterNorth.setLayout(flow);
		flow.setVgap(20);
		flow.setHgap(10);
		panelCenterNorth.add(SuggestTextSubCatagory.cmbSuggest);
		SuggestTextSubCatagory.cmbSuggest.setPreferredSize(new Dimension(300,40));
		panelCenterNorth.add(btnSubCatSearch);
		btnSubCatSearch.setPreferredSize(new Dimension(100,40));
		btnSubCatSearch.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelCenterOfCenterWork() {
        panelCenterCenter.setPreferredSize(new Dimension(570,325));
		panelCenterCenter.setLayout(new BorderLayout());
		panelCenterCenter.add(panelCenterUpper,BorderLayout.NORTH);
		panelCenterUpperWork();
		panelCenterCenter.add(panelCenterLower,BorderLayout.CENTER);
		panelCenterLowerWork();
	}

	private void panelCenterLowerWork() {
		panelCenterLower.setPreferredSize(new Dimension(570,80));
		//	panelCenterLower.setBorder(BorderFactory.createTitledBorder(""));
			FlowLayout flow=new FlowLayout();
			panelCenterLower.setLayout(flow);
			flow.setHgap(20);
			flow.setVgap(10);
			panelCenterLower.add(btnAddSubCat);
			btnAddSubCat.setPreferredSize(new Dimension(70,40));
			btnAddSubCat.setFont(new Font("Sherif",Font.BOLD,14));
			panelCenterLower.add(btnEditSubCat);
			btnEditSubCat.setPreferredSize(new Dimension(70,40));
			btnEditSubCat.setFont(new Font("Sherif",Font.BOLD,14));
			panelCenterLower.add(btnRefreshSubCat);
			btnRefreshSubCat.setPreferredSize(new Dimension(100,40));
			btnRefreshSubCat.setFont(new Font("Sherif",Font.BOLD,14));
			panelCenterLower.add(btnDeleteSubCat);
			btnDeleteSubCat.setPreferredSize(new Dimension(90,40));
			btnDeleteSubCat.setFont(new Font("Sherif",Font.BOLD,14));
	}

	private void panelCenterUpperWork() {
		panelCenterUpper.setPreferredSize(new Dimension(570,220));
		//panelCenterUpper.setBorder(BorderFactory.createTitledBorder(""));
		GridBagConstraints c=new GridBagConstraints();
		panelCenterUpper.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelCenterUpper.add(lblCatagoryID_panelcenter,c);
		lblCatagoryID_panelcenter.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=0;
		panelCenterUpper.add(SuggestTextCatagoryIDSub.cmbSuggest,c);
		c.gridx=0;
		c.gridy=1;
		panelCenterUpper.add(lblSubCatagoryID_panelcenter,c);
		lblSubCatagoryID_panelcenter.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=1;
		panelCenterUpper.add(txtSubCatagoryID,c);
		c.gridx=0;
		c.gridy=2;
		panelCenterUpper.add(lblSubCatagoryName_panelcenter,c);
		lblSubCatagoryName_panelcenter.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=2;
		panelCenterUpper.add(txtSubCatagoryName,c);
		c.gridx=0;
		c.gridy=3;
		panelCenterUpper.add(lblName_panelcenter,c);
		lblName_panelcenter.setFont(new Font("Sherif",Font.BOLD,14));
		c.gridx=1;
		c.gridy=3;
		panelCenterUpper.add(txtSubUserName,c);
	}

	private void panelCenterSouthWork() {
		panelCenterSouth.setPreferredSize(new Dimension(570,300));
		//panelCenterSouth.setBorder(BorderFactory.createTitledBorder(""));	
	    FlowLayout flow=new FlowLayout();
        panelCenterSouth.setLayout(flow);
        panelCenterSouth.add(scrollSubCategory);
        scrollSubCategory.setPreferredSize(new Dimension(520,260));
	}
	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
		setLayout(new BorderLayout());
	}
}