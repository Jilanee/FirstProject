package com.example.MenuItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangePassword extends JPanel{
	
	JPanel panelWest=new JPanel();
	JPanel panelSouth=new JPanel();
	
	JTextField txtUserName=new JTextField(20);
	JTextField txtOldPassword=new JTextField(20);
	JTextField txtNewPassword=new JTextField(20);
	JTextField txtConfirmPassword=new JTextField(20);

	public ChangePassword(){
		init();
		cmp();
	}

	private void cmp() {
		add(panelWest,BorderLayout.WEST);
		PanelWestWork();
		add(panelSouth,BorderLayout.SOUTH);
		PanelCenterWork();
	}

	private void PanelCenterWork() {
	
		panelSouth.setPreferredSize(new Dimension(1150,240));
		panelSouth.setBorder(BorderFactory.createTitledBorder(""));
		panelSouth.setBackground(Color.BLACK);
		
		JButton btnChange=new JButton("Change");
		JButton btnRefresh=new JButton("Refresh");

		FlowLayout flow=new FlowLayout();
		panelSouth.setLayout(flow);
		flow.setHgap(50);
		panelSouth.add(btnChange);
		btnChange.setPreferredSize(new Dimension(100,40));
		btnChange.setFont(new Font("Sherif",Font.BOLD,14));

		panelSouth.add(btnRefresh);
		btnRefresh.setPreferredSize(new Dimension(100,40));
		btnRefresh.setFont(new Font("Sherif",Font.BOLD,14));		
	}

	private void PanelWestWork() {
		panelWest.setPreferredSize(new Dimension(1150,500));
		panelWest.setBorder(BorderFactory.createTitledBorder(""));
		
		JLabel lblUserName=new JLabel("User Name");
		JLabel lblOldPassword=new JLabel("Old Password");
		JLabel lblNewPassword=new JLabel("New Password");
		JLabel lblConfirmPassword=new JLabel("Confirm Password");
		
		GridBagConstraints c=new GridBagConstraints();
        panelWest.setLayout(new GridBagLayout());
		c.fill=GridBagConstraints.BOTH;
		c.insets=new Insets(2,2,2,2);
		c.gridx=0;
		c.gridy=0;
		panelWest.add(lblUserName, c);
		lblUserName.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=0;
		panelWest.add(txtUserName, c);
		c.gridx=0;
		c.gridy=1;
		panelWest.add(lblOldPassword, c);
		lblOldPassword.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=1;
		panelWest.add(txtOldPassword, c);
		c.gridx=0;
		c.gridy=2;
		panelWest.add(lblNewPassword, c);
		lblNewPassword.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=2;
		panelWest.add(txtNewPassword, c);
		c.gridx=0;
		c.gridy=3;
		panelWest.add(lblConfirmPassword, c);
		lblConfirmPassword.setFont(new Font("Sherif",Font.BOLD,14));		
		c.gridx=1;
		c.gridy=3;
		panelWest.add(txtConfirmPassword, c);
	}

	private void init() {
		setPreferredSize(new Dimension(1150,740));
		setBorder(BorderFactory.createTitledBorder(""));
	    setLayout(new BorderLayout());
	}
}