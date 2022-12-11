import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("serial")
class paswd implements Serializable{
     
	int id;
    String AccountName;
	String Username;
	String Password;
	
	public paswd(int id, String AccountName, String Username, String Password)
	{

		this.id = id;
        this.AccountName = AccountName;
		this.Username = Username;
		this.Password = Password;

	}
	
	public String toString()
	{   
		return "\nAccount Details :" +"\nAccountName: " + this.AccountName +"\nUsername: " + this.Username + "\nPassword: " + this.Password;               
	}	
}

public class attempt5
{	
    
	static void display(ArrayList<paswd> al)
	{
		System.out.println("\n--------------Accounts and Password List---------------\n");
		System.out.println(String.format("%-15s%-15s%-15s%-10s", "Account ID","AccountName","Username","Password"));
		for(paswd e : al)
		{
			System.out.println(String.format("%-15s%-15s%-15s%-10s",e.id,e.AccountName,e.Username,e.Password));
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
		int id;
        String AccountName;
		String Username;
		String Password;
		
		Scanner sc = new Scanner(System.in);
		ArrayList<paswd> al = new ArrayList<paswd>();		
		File f = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		FileOutputStream fos = null;
		ObjectOutputStream oos =null;

        System.out.println("Enter Your password: ");
        int pas = sc.nextInt();

        // for(int x=0;x>0;x++){
            
        // }

        if(pas==23233){
            System.out.println("correct password.");
            
            try{
			
                f= new File("C:/Users/mayur dabade/Desktop/college 3rd sem/OOP lab/oops course project/accountd.txt");
                if(f.exists())
                {
                    fis = new FileInputStream(f);
                    ois = new ObjectInputStream(fis);
                    al = (ArrayList<paswd>)ois.readObject();
                }			
            }
    
            catch(Exception exp){
                System.out.println(exp);
            }
    
            do
            {
                // System.out.println("Enter Your password: ");
                // String pas = sc.next();
                
                System.out.println("\n********* Welcome to the Password Management System **********\n");
                System.out.println("1). Store password to the DataBase\n" +
                                    "2). Search password\n" +
                                    "3). Edit Account details\n" +
                                    "4). Delete Account Details\n" +
                                    "5). Generate random password\n"+
                                    "6). Display all account details with passwords\n" +
                                    "7). Save & EXIT\n");
                System.out.println("Enter your choice : ");
                int ch = sc.nextInt();
                
                switch(ch)
                {
                case 1:System.out.println("\nEnter the following details to ADD list:\n");
    
                    System.out.println("Enter ID :");
                    id = sc.nextInt();
                    System.out.println("Enter AccountName :");
                    AccountName = sc.next();
                    System.out.println("Enter Username :");
                    Username = sc.next();
                    System.out.println("Enter Password :");
                    Password = sc.next();
    
                    al.add(new paswd(id,AccountName, Username, Password));
                    display(al);
                    break;
                    
                case 2: 
                        System.out.println("\n**************************\n");
                        System.out.println(String.format("%-10s%-20s", "AccountID","AccountName"));
                        for(paswd e : al)
                        {
                            System.out.println(String.format("%-10s%-20s",e.id,e.AccountName));
                        }
                        System.out.println("\n**************************\n");
    
                        System.out.println("Enter the ID to search :");
                        id = sc.nextInt();
    
                        int i=0;
                        for(paswd e: al)
                        {
                            if(id == e.id)
                            {
                                System.out.println(e+"\n");
                                i++;
                            }
                        }
                        if(i == 0)
                        {
                            System.out.println("\nAccount Details are not available, Please enter a valid ID!!");
                        }
                        break;
                
                case 3: 
                    System.out.println("\n**************************\n");
                    System.out.println(String.format("%-10s%-20s", "AccountID", "AccountName"));
                    for (paswd e : al) {
                        System.out.println(String.format("%-10s%-20s", e.id, e.AccountName));
                    }
                    System.out.println("\n**************************\n");
                
                        System.out.println("Enter the Account ID to EDIT the details");
                        id = sc.nextInt();
                        int j=0;
                        for(paswd e: al)
                        {
                            if(id == e.id)
                            {	
                                j++;
                            do{
                                int ch1 =0;
                                System.out.println("\nEDIT Account Details :\n" +
                                                    "1). Account ID\n" +
                                                    "2). Account Name\n" +
                                                    "3). Username\n"+
                                                    "4). Password\n" +
                                                    "5). GO BACK\n");
                                System.out.println("Enter your choice : ");
                                ch1 = sc.nextInt();
                                switch(ch1)
                                {
                                case 1: System.out.println("\nEnter new paswd ID:");
                                        e.id =sc.nextInt();
                                        System.out.println(e+"\n");
                                        break;
    
                                case 2: System.out.println("Enter new Account Name:");
                                        e.AccountName =sc.next();
                                        System.out.println(e+"\n");
                                        break;
                                
                                case 3: System.out.println("Enter new Username:");
                                        e.Username =sc.next();
                                        System.out.println(e+"\n");
                                        break;
                                        
                                case 4: System.out.println("Enter new Password :");
                                        e.Password =sc.next();
                                        System.out.println(e+"\n");
                                        break;
                                        
                                case 5: j++;
                                        break;
                                        
                                default : System.out.println("\nEnter a correct choice from the List :");
                                            break;
    
                                }
                                }
                            while(j==1);
                            }
                        }
                        if(j == 0)
                        {
                            System.out.println("\nAccount Details are not available, Please enter a valid ID!!");
                        }
                        break;
                        
                case 4: 
                    System.out.println("\n**************************\n");
                    System.out.println(String.format("%-10s%-20s", "AccountID", "AccountName"));
                    for (paswd e : al) {
                        System.out.println(String.format("%-10s%-20s", e.id, e.AccountName));
                    }
                    System.out.println("\n**************************\n");
    
                        System.out.println("\nEnter Account ID to DELETE from the Databse :");
                        id = sc.nextInt();
                        int k=0;
                        try{
                        for(paswd e: al)
                        {
                            if(id == e.id)
                            {
                                    al.remove(e);
                                    display(al);
                                    k++;
                            }
                        }
                        if(k == 0)
                        {
                            System.out.println("\nAccount Details are not available, Please enter a valid ID!!");
                        }
                        }
                        catch(Exception ex){
                            System.out.println(ex);
                        }
                        break;
    
                case 5:
                        System.out.println("Enter password length:");
                        int len = sc.nextInt();
                        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
                        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
                        String specialCharacters = "!@#$";
                        String numbers = "1234567890";
                        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
                        Random random = new Random();
                        char[] password = new char[len];
                  
                        password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
                        password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
                        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
                        password[3] = numbers.charAt(random.nextInt(numbers.length()));
                     
                        for(int m = 4; m< len ; m++) {
                           password[m] = combinedChars.charAt(random.nextInt(combinedChars.length()));
                        }
    
                        System.out.println("Your random password is : ");
                        System.out.print(password);
                        break;
    
                case 6: try {
                            al = (ArrayList<paswd>)ois.readObject();
                        
                        } catch (ClassNotFoundException e2) {
                            
                            System.out.println(e2);
                        } catch (Exception e2) {
                            
                            System.out.println(e2);
                        }
                            display(al);
                            break;
    
                case 7: try {
                        fos = new FileOutputStream(f);
                        oos = new ObjectOutputStream(fos);
                        oos.writeObject(al);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    catch(Exception e2){
                        e2.printStackTrace();
                    }

                    finally{
                        try {
                            fis.close();
                            ois.close();
                            fos.close();
                            oos.close();
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                        
                    }
                        System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
                        sc.close();
                        System.exit(0);
                        break;
                        
                default : System.out.println("\nEnter a correct choice from the List :");
                            break;			
                }
            }
            while(true);    
        }

        else{
            System.out.println("Wrong Password.");
        }

	}   
}
