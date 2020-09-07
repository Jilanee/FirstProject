package com.example.Admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	JPanel mainpanel=new JPanel();
	JPanel panelwest=new JPanel();
	JPanel panelsouth=new JPanel();
	JPanel panelnorth=new JPanel();
    JPanel panelcenter=new JPanel();
    
	ImageIcon icon=new ImageIcon("Images/password.jpg");

	JButton btnLogin=new JButton("Login",new ImageIcon("Images/button_ok.png"));	
	JButton btncancel=new JButton("Cancel",new ImageIcon("Images/o31.png"));
	
	JTextField txtusername=new JTextField(15);
	JTextField txtpassword=new JTextField(15);

	Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();

	public Login(){
		init();
		cmp();
		Action();
	}
	private void Action() {
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				loginAction();
			}
		});
		
		btncancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Do you want to exit Login");
				dispose();
			}
		});
				
	}

 void loginAction()
	{
		mainpanel.setVisible(false);
		WorkingPanel wp=new WorkingPanel();
		add(wp);
		wp.setVisible(true);
		//Dimension screen = null;
		setSize(screen);
		setLocationRelativeTo(null);
		setTitle("SuperShop");
	}
	
	private void cmp() {
	  add(mainpanel);
	  mainpanel.setLayout(new BorderLayout());
	  mainpanel.add(panelnorth,BorderLayout.NORTH);
	  panelNorthWork();
	  mainpanel.add(panelsouth,BorderLayout.SOUTH);
	  panelSouthWork();
	  mainpanel.add(panelwest,BorderLayout.WEST);
	  panelWestWork();
	  mainpanel.add(panelcenter,BorderLayout.CENTER);
	  panelCenterWork();
	}

	private void panelCenterWork() {
		JLabel lblusername=new JLabel("Username");
		JLabel lblpassword=new JLabel("Password");
		
		panelcenter.setLayout(new GridBagLayout());
		GridBagConstraints c=new GridBagConstraints();
		
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(5, 5, 5,5); //TLBR
		
		c.gridx=0;
		c.gridy=0;
		panelcenter.add(lblusername,c);
	//	c.insets=new Insets(5, 5, 5,5); //TLBR

		c.gridx=1;
		c.gridy=0;
		panelcenter.add(txtusername,c);
	//	c.insets=new Insets(5, 5, 5,5); //TLBR

		c.gridx=0;
		c.gridy=1;
		panelcenter.add(lblpassword,c);
	//	c.insets=new Insets(5, 5, 5,5); //TLBR

		c.gridx=1;
		c.gridy=1;
		panelcenter.add(txtpassword,c);
		lblusername.setForeground(Color.BLUE);
		lblusername.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
		lblpassword.setForeground(Color.BLUE);
		lblpassword.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,14));
	}

	private void panelWestWork() {
		panelwest.setPreferredSize(new Dimension(130,0));
        panelwest.setBorder(BorderFactory.createRaisedBevelBorder());
		JLabel lblIcon=new JLabel(icon);
        FlowLayout flow=new FlowLayout();
        panelwest.setLayout(flow);
        panelwest.add(lblIcon);
        flow.setVgap(12);
	}

	private void panelSouthWork() {
		FlowLayout flow=new FlowLayout();
		flow.setVgap(10);
		flow.setHgap(30);
		panelsouth.setPreferredSize(new Dimension(0,70));
        panelsouth.setBorder(BorderFactory.createRaisedBevelBorder());
        panelsouth.setLayout(flow);
        panelsouth.add(btnLogin);
		btnLogin.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
		btnLogin.setForeground(Color.BLUE);

        panelsouth.add(btncancel);
        btncancel.setFont(new Font("Serif",Font.BOLD+Font.ITALIC,16));
        btncancel.setForeground(Color.BLUE);		
	}

	private void panelNorthWork() {
		ImageIcon icon1=new ImageIcon("Images/northsupershop.png");
		FlowLayout flow =new FlowLayout();
		JLabel lblIcon=new JLabel(icon1);

		panelnorth.setPreferredSize(new Dimension(0,80));
		panelnorth.setBorder(BorderFactory.createRaisedBevelBorder());
		panelnorth.setLayout(flow);
        panelnorth.add(lblIcon);
	}

	private void init() {
      setSize(450,300);
	  setVisible(true);
      setLocationRelativeTo(null);
      setResizable(false);
      setTitle("Login");
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}