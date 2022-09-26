package com.Book;

import javax.swing.JOptionPane;

import com.Book.service.ServiceLayer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	{
            do{
               ServiceLayer s = new ServiceLayer();	//calling dao functions using Dto Layer
         	   
         	   int a = Integer.parseInt(JOptionPane.showInputDialog("PRESS 1: for adding book \nPRESS 2: for displaying book \n"
         	   		+"PRESS 3: Exit"));
         	   switch(a){
         	   case 1: s.addBook();
         	   break;
         	   case 2: s.fetchBook();
         	   break;
         	   case 3: System.exit(0);
         	   default: System.out.println("Invalid Choice!");
         	   }
            }while(true);
         }
    }
}
