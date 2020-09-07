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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import com.example.Admin.DBConnection;
import com.example.Admin.SuggestText;

public class SetupReport extends JPanel{
	//ClientInfo client=new ClientInfo();
	
	JPanel PanelNorth=new JPanel();
	JPanel PanelSouth=new JPanel();
	
	JPanel PanelNorthWest=new JPanel();
	JPanel PanelNorthWestUpper=new JPanel();
	JPanel PanelNorthWestLower=new JPanel();

	JPanel PanelNorthCenter=new JPanel();
	JPanel PanelNorthCenterUpper=new JPanel();
	JPanel PanelNorthCenterLower=new JPanel();

	JPanel PanelNorthEast=new JPanel();
	JPanel PanelNorthEastUpper=new JPanel();
	JPanel PanelNorthEastLower=new JPanel();

	JPanel PanelSouthWest=new JPanel();
	JPanel PanelSouthWestUpper=new JPanel();
	JPanel PanelSouthWestLower=new JPanel();

	JPanel PanelSouthCenter=new JPanel();
	JPanel PanelSouthCenterUpper=new JPanel();
	JPanel PanelSouthCenterLower=new JPanel();
	
	JPanel PanelSouthEast=new JPanel();
	JPanel PanelSouthEastUpper=new JPanel();
	JPanel PanelSouthEastLower=new JPanel();
    
	SuggestText stPartyReport=new SuggestText();
	SuggestText stSupplierReport=new SuggestText();
	SuggestText stUserReport=new SuggestText();
	SuggestText stProduct=new SuggestText();
	SuggestText stStock=new SuggestText();
	SuggestText stOthers=new SuggestText();
	
	JButton btnPartyPreview=new JButton("Preview");
	JButton btnPartyPrint=new JButton("Print");
	
	JButton btnSupplierPreview=new JButton("Preview");
	JButton btnSupplierPrint=new JButton("Print");
	
	JButton btnUserPreview=new JButton("Preview");
	JButton btnUserPrint=new JButton("Print");
	
	JButton btnProductPreview=new JButton("Preview");
	JButton btnProductPrint=new JButton("Print");
	
	JButton btnStockPreview=new JButton("Preview");
	JButton btnStockPrint=new JButton("Print");
	
	JButton btnOthersPreview=new JButton("Preview");
	JButton btnOthersPrint=new JButton("Print");
	
    JCheckBox ckAll=new JCheckBox("All");
	JCheckBox ckSuplierReport=new JCheckBox("All");
    JCheckBox ckUserReport=new JCheckBox("All");
    JCheckBox ckProduct=new JCheckBox("All");
    JCheckBox ckStock=new JCheckBox("All");
    JCheckBox ckOthers=new JCheckBox("All");

	public SetupReport(){
		init();
		cmp();
		btnAction();
	}
    
	public void ClientDataLoad(){
		try{
			String sql="select ClientID,ClientName from tbclientinfo";
			stPartyReport.vector.removeAllElements();
			stPartyReport.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stPartyReport.vector.add(rs.getString("ClientID")+" # "+rs.getString("ClientName"));
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
			stSupplierReport.vector.removeAllElements();
			stSupplierReport.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stSupplierReport.vector.add(rs.getString("SupplierID")+" # "+rs.getString("SupplierName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null,exp);
		}
	}
	
	public void UserDataLoad(){
		try{
			String sql="select UserID,UserName from tbnewuser";
			stUserReport.vector.removeAllElements();
			stUserReport.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stUserReport.vector.add(rs.getString("UserID")+" # "+rs.getString("UserName"));
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
			stProduct.vector.removeAllElements();
			stProduct.vector.add("");
			DBConnection.Connection();
			ResultSet rs=DBConnection.sat.executeQuery(sql);
			while(rs.next()){
				stProduct.vector.add(rs.getString("ProductID")+" # "+rs.getString("ProductName"));
			}
			DBConnection.con.close();
		}
		catch(Exception exp){
			JOptionPane.showMessageDialog(null, exp);
		}
	}
	private void btnAction() {
		btnPartyPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnSupplierPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnProductPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnUserPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnStockPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnOthersPreview.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}

	private void cmp() {
		add(PanelNorth,BorderLayout.NORTH);
		PanelWestWork();
		add(PanelSouth,BorderLayout.SOUTH);
		PanelSouthWork();
	}

	private void PanelWestWork() {
		PanelNorth.setPreferredSize(new Dimension(1140,360));
		//PanelNorth.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		PanelNorth.setLayout(new BorderLayout());
		PanelNorth.add(PanelNorthWest,BorderLayout.WEST);
		PanelNorthWestWork();
		PanelNorth.add(PanelNorthCenter, BorderLayout.CENTER);
		PanelNorthCenterWork();
		PanelNorth.add(PanelNorthEast, BorderLayout.EAST);
		PanelNorthEastWork();
	}

	private void PanelNorthWestWork() {                             //Party Report
		 
		PanelNorthWest.setPreferredSize(new Dimension(380,350));
		TitledBorder title=BorderFactory.createTitledBorder(" Party Report ");
		title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		PanelNorthWest.setBorder(title);
		PanelNorthWest.setLayout(new BorderLayout());
		PanelNorthWest.add(PanelNorthWestUpper, BorderLayout.NORTH);
		PanelNorthWestUpperWork();
		PanelNorthWest.add(PanelNorthWestLower, BorderLayout.SOUTH);
		PanelNorthWestLowerWork();
	}

	private void PanelNorthWestUpperWork() {
		PanelNorthWestUpper.setPreferredSize(new Dimension(370,170));
		//PanelNorthWestUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelNorthWestUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(20);
		PanelNorthWestUpper.add(stPartyReport.cmbSuggest);
		stPartyReport.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelNorthWestUpper.add(ckAll);
		ckAll.setFont(new Font("Serif",Font.BOLD,16));
	}

	private void PanelNorthWestLowerWork() {
		PanelNorthWestLower.setPreferredSize(new Dimension(370,170));
		//PanelNorthWestLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		flow.setVgap(50);
		flow.setHgap(30);
		PanelNorthWestLower.setLayout(flow);
		PanelNorthWestLower.add(btnPartyPreview);
		btnPartyPreview.setPreferredSize(new Dimension(100,40));
		btnPartyPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelNorthWestLower.add(btnPartyPrint);
		btnPartyPrint.setPreferredSize(new Dimension(70,40));
		btnPartyPrint.setFont(new Font("Serif",Font.BOLD,14));
	}

	private void PanelNorthCenterWork() {                           //Supplier Report
		PanelNorthCenter.setPreferredSize(new Dimension(340,350));
		TitledBorder title=BorderFactory.createTitledBorder(" Supplier Report ");
		title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		PanelNorthCenter.setBorder(title);
		PanelNorthCenter.setLayout(new BorderLayout());
		PanelNorthCenter.add(PanelNorthCenterUpper, BorderLayout.NORTH);
		PanelNorthCenterUpperWork();
		PanelNorthCenter.add(PanelNorthCenterLower, BorderLayout.SOUTH);
		PanelNorthCenterLowerWork();
	}

	private void PanelNorthCenterUpperWork() {
		PanelNorthCenterUpper.setPreferredSize(new Dimension(370,170));
		//PanelNorthCenterUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelNorthCenterUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(30);
		PanelNorthCenterUpper.add(stSupplierReport.cmbSuggest);
		stSupplierReport.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelNorthCenterUpper.add(ckSuplierReport);
		ckSuplierReport.setFont(new Font("Serif",Font.BOLD,16));
	}

	private void PanelNorthCenterLowerWork() {
		PanelNorthCenterLower.setPreferredSize(new Dimension(370,170));
		//PanelNorthCenterLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelNorthCenterLower.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(30);
		PanelNorthCenterLower.add(btnSupplierPreview);
		btnSupplierPreview.setPreferredSize(new Dimension(100,40));
		btnSupplierPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelNorthCenterLower.add(btnSupplierPrint);
		btnSupplierPrint.setPreferredSize(new Dimension(70,40));
		btnSupplierPrint.setFont(new Font("Serif",Font.BOLD,14));
	}

	private void PanelNorthEastWork() {
		PanelNorthEast.setPreferredSize(new Dimension(375,350));//User Report
        TitledBorder title=BorderFactory.createTitledBorder(" User Report ");
        title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitlePosition(TitledBorder.TOP);
        PanelNorthEast.setBorder(title);
        PanelNorthEast.setLayout(new BorderLayout());
        PanelNorthEast.add(PanelNorthEastUpper, BorderLayout.NORTH);
        PanelNorthEastUpperWork();
		PanelNorthEast.add(PanelNorthEastLower, BorderLayout.SOUTH);
		PanelNorthEastLowerWork();
	}
	
	private void PanelNorthEastUpperWork() {
		PanelNorthEastUpper.setPreferredSize(new Dimension(370,170));
		//PanelNorthEastUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelNorthEastUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(20);
		PanelNorthEastUpper.add(stUserReport.cmbSuggest);
		stUserReport.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelNorthEastUpper.add(ckUserReport);
		ckUserReport.setFont(new Font("Serif",Font.BOLD,16));
	}

	private void PanelNorthEastLowerWork() {
		PanelNorthEastLower.setPreferredSize(new Dimension(370,170));
		//PanelNorthEastLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelNorthEastLower.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(30);
		PanelNorthEastLower.add(btnUserPreview);
		btnUserPreview.setPreferredSize(new Dimension(100,40));
		btnUserPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelNorthEastLower.add(btnUserPrint);
		btnUserPrint.setPreferredSize(new Dimension(100,40));
		btnUserPrint.setFont(new Font("Serif",Font.BOLD,14));
	}

	private void PanelSouthWork() {
		PanelSouth.setPreferredSize(new Dimension(1140,370));
		//PanelSouth.setBorder(BorderFactory.createRaisedBevelBorder());
		PanelSouth.add(PanelSouthWest, BorderLayout.WEST);
		PanelSouthWestWork();
		PanelSouth.add(PanelSouthCenter, BorderLayout.CENTER);
		PanelSouthCenterWork();
		PanelSouth.add(PanelSouthEast, BorderLayout.EAST);
		PanelSouthEastWork();
	}
	
	private void PanelSouthWestWork() {
		PanelSouthWest.setPreferredSize(new Dimension(375,350));//   ProductInfo
        TitledBorder title=BorderFactory.createTitledBorder(" ProductInfo ");
        title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
        title.setTitleJustification(TitledBorder.CENTER);
        title.setTitlePosition(TitledBorder.TOP);
        PanelSouthWest.setBorder(title);
        PanelSouthWest.setLayout(new BorderLayout());
        PanelSouthWest.add(PanelSouthWestUpper, BorderLayout.NORTH);
        PanelSouthWestUpperWork();
        PanelSouthWest.add(PanelSouthWestLower, BorderLayout.SOUTH);
        PanelSouthWestLowerWork();
	}

	private void PanelSouthWestUpperWork() {
		PanelSouthWestUpper.setPreferredSize(new Dimension(370,170));
		//PanelSouthWestUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthWestUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(20);
		PanelSouthWestUpper.add(stProduct.cmbSuggest);
		stProduct.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelSouthWestUpper.add(ckProduct);
		ckProduct.setFont(new Font("Serif",Font.BOLD,16));		
	}

	private void PanelSouthWestLowerWork() {
		PanelSouthWestLower.setPreferredSize(new Dimension(370,170));
		//PanelSouthWestLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthWestLower.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(30);
		PanelSouthWestLower.add(btnProductPreview);
		btnProductPreview.setPreferredSize(new Dimension(100,40));
		btnProductPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelSouthWestLower.add(btnProductPrint);
		btnProductPrint.setPreferredSize(new Dimension(100,40));
		btnProductPrint.setFont(new Font("Serif",Font.BOLD,14));		
	}

	private void PanelSouthCenterWork() {                   //Stock Report              
		PanelSouthCenter.setPreferredSize(new Dimension(370,350));
		TitledBorder title=BorderFactory.createTitledBorder(" Stock Report");
		title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		PanelSouthCenter.setBorder(title);
		PanelSouthCenter.setLayout(new BorderLayout());
		PanelSouthCenter.add(PanelSouthCenterUpper, BorderLayout.NORTH);
		PanelSouthCenterUpperWork();
		PanelSouthCenter.add(PanelSouthCenterLower, BorderLayout.SOUTH);
		PanelSouthCenterLowerWork();
	}

	private void PanelSouthCenterUpperWork() {
		PanelSouthCenterUpper.setPreferredSize(new Dimension(370,170));
		//PanelSouthCenterUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthCenterUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(20);
		PanelSouthCenterUpper.add(stStock.cmbSuggest);
		stStock.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelSouthCenterUpper.add(ckStock);
		ckStock.setFont(new Font("Serif",Font.BOLD,16));			
	}

	private void PanelSouthCenterLowerWork() {
		PanelSouthCenterLower.setPreferredSize(new Dimension(370,170));
		//PanelSouthCenterLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthCenterLower.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(30);
		PanelSouthCenterLower.add(btnStockPreview);
		btnStockPreview.setPreferredSize(new Dimension(100,40));
		btnStockPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelSouthCenterLower.add(btnStockPrint);
		btnStockPrint.setPreferredSize(new Dimension(100,40));
		btnStockPrint.setFont(new Font("Serif",Font.BOLD,14));		
	}

	private void PanelSouthEastWork() {                           //others
		PanelSouthEast.setPreferredSize(new Dimension(375,350));
		TitledBorder title=BorderFactory.createTitledBorder(" Others ");
		title.setTitleFont(new Font("Serif",Font.BOLD+Font.ITALIC,18));
		title.setTitleJustification(TitledBorder.CENTER);
		title.setTitlePosition(TitledBorder.TOP);
		PanelSouthEast.setBorder(title);
		PanelSouthEast.setLayout(new BorderLayout());
		PanelSouthEast.add(PanelSouthEastUpper, BorderLayout.NORTH);
		PanelSouthEastUpperWork();
		PanelSouthEast.add(PanelSouthEastLower, BorderLayout.SOUTH);
		PanelSouthEastLowerWork();
	}

	private void PanelSouthEastUpperWork() {
		PanelSouthEastUpper.setPreferredSize(new Dimension(370,170));
		//PanelSouthEastUpper.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthEastUpper.setLayout(flow);
		flow.setVgap(70);
		flow.setHgap(20);
		PanelSouthEastUpper.add(stOthers.cmbSuggest);
		stOthers.cmbSuggest.setPreferredSize(new Dimension(250,50));
		PanelSouthEastUpper.add(ckOthers);
		ckOthers.setFont(new Font("Serif",Font.BOLD,16));		
	}

	private void PanelSouthEastLowerWork() {
		PanelSouthEastLower.setPreferredSize(new Dimension(370,170));
		//PanelSouthEastLower.setBorder(BorderFactory.createRaisedBevelBorder());
		FlowLayout flow=new FlowLayout();
		PanelSouthEastLower.setLayout(flow);
		flow.setVgap(50);
		flow.setHgap(30);
		PanelSouthEastLower.add(btnOthersPreview);
		btnOthersPreview.setPreferredSize(new Dimension(100,40));
		btnOthersPreview.setFont(new Font("Serif",Font.BOLD,14));
		PanelSouthEastLower.add(btnOthersPrint);
		btnOthersPrint.setPreferredSize(new Dimension(100,40));
		btnOthersPrint.setFont(new Font("Serif",Font.BOLD,14));		
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setLayout(new BorderLayout());
		//setBackground(Color.MAGENTA);			
	}

}