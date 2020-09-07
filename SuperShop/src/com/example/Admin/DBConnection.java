package com.example.Admin;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class DBConnection {
	
	public static  Connection con;
	public static  Statement sat;
  
	public static void Connection(){
		  		File f=new File("src/dbConnection.txt");
	    		String Server="",Port="",dbFile="",userName="",password="";
	    		
	    		try{
	    			int a=1;
	    			Scanner scan=new Scanner(f);
	    			while(scan.hasNextLine()){
	    				String s=scan.nextLine();
	                    StringTokenizer token=new StringTokenizer(s);
	                    token.nextToken();
	                    if(a==1){
	                    	Server=token.nextToken();
	                    }
	                    else if(a==2){
	                    	Port=token.nextToken();
	                    }
	                    else if(a==3){
	                    	dbFile=token.nextToken();
	                    }
	                    else if(a==4){
	                    	userName=token.nextToken();
	                    }
	                    else if(a==5){
	                    	password=token.nextToken();
	                    	break;
	                    }
	    				a++;
	    			       }
	    			String url="jdbc:mysql://"+Server+":"+Port+"/"+dbFile;
	    			Class.forName("com.mysql.jdbc.Driver").newInstance();
	    			con=DriverManager.getConnection(url,userName,password);
	    			sat=con.createStatement();
	    			//System.out.println ("Database connection established");
	    		      }
	    		
	    		catch(Exception exp){
	    			JOptionPane.showMessageDialog(null, exp);
	    		}
		      }
	    	
	       }