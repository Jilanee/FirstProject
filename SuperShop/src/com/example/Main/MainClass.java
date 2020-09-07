package com.example.Main;

import javax.swing.UIManager;

import com.example.Admin.Login;

public class MainClass {

	public static void main(String[] args) {
		
		try 
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e) {
	
		}
          Login lg=new Login();
	}

}