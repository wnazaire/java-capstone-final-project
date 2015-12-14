import java.io.*;

import javax.swing.JOptionPane;

public class User {
private String name;
	public User (int state){
		
	}
	
	public User (){
			name = JOptionPane.showInputDialog(null, "Please enter your name:", "Create a new user", JOptionPane.INFORMATION_MESSAGE);
		if (name != null){
			createProfile();
			DressingRoom.setName(name);
		}
		else
			JOptionPane.showMessageDialog(null, "Error occured! Please click \"ok\" to try again.", "Error occurred", JOptionPane.ERROR_MESSAGE);
	}
	
	public String getName(){
		return name;
	}
	public void createProfile(){
		new File(name+".dat");
		try {
			File newFile  = new File(name+".dat");
			FileWriter fw = new FileWriter (newFile);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter outFile = new PrintWriter (bw);
			outFile.println("Counter: 0");
			outFile.close();
			}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			} 
		catch (IOException e) {
			System.err.println("FileCopy: " + e);
		}
	}
	public static Boolean load(String name){
		File f = new File (name+".dat");
		if(f.exists()){
			DressingRoom.setName(name);
			return true;
		}
		else{
			JOptionPane.showMessageDialog(null, "User not found! Please try a different name or create a new user.", "User not found", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
