import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Outfit {
	private Dress dress;
	private Jacket jacket;
	private Pants pants;
	private Shirt shirt;
	private Skirt skirt;
	private String dateString;
	private static int counter;
	private static String saveString;
	
	public Outfit(Shirt sh, Pants p){
		dress = null;
		jacket = null;
		pants = p;
		shirt = sh;
		skirt = null;
		dateString = "Not yet worn";
	}
	
	public Outfit(Shirt sh, Pants p, Jacket j){
		dress = null;
		jacket = j;
		pants = p;
		shirt = sh;
		skirt = null;
		dateString = "Not yet worn";
	}
	
	public Outfit(Shirt sh, Skirt sk){
		dress = null;
		jacket = null;
		pants = null;
		shirt = sh;
		skirt = sk;
		dateString = "Not yet worn";
	}
	
	public Outfit(Shirt sh, Skirt sk, Jacket j){
		dress = null;
		jacket = j;
		pants = null;
		shirt = sh;
		skirt = sk;
		dateString = "Not yet worn";
	}
	
	public Outfit(Dress d){
		dress = d;
		jacket = null;
		pants = null;
		shirt = null;
		skirt = null;
		dateString = "Not yet worn";
	}
	
	public Outfit(Dress d, Jacket j){
		dress = d;
		jacket = j;
		pants = null;
		shirt = null;
		skirt = null;
		dateString = "Not yet worn";
	}
	
	public Dress getDress(){
		return dress;
	}
	
	public Jacket getJacket(){
		return jacket;
	}
	
	public Pants getPants(){
		return pants;
	}
	
	public Shirt getShirt(){
		return shirt;
	}
	
	public Skirt getSkirt(){
		return skirt;
	}
	
	public Boolean equals(Outfit o){
		if ((shirt != null && pants != null && jacket == null) && (o.getShirt() != null && o.getPants() != null  && o.getJacket() == null)){
			if ((shirt.getIndex() == o.getShirt().getIndex()) && (pants.getIndex() == o.getPants().getIndex()))
				return true;
		}
		if ((shirt != null && pants != null && jacket != null) && (o.getShirt() != null && o.getPants() != null && o.getJacket() != null)){
			if ((shirt.getIndex() == o.getShirt().getIndex()) && (pants.getIndex() == o.getPants().getIndex()) && (jacket.getIndex() == o.getJacket().getIndex()))
				return true;
		}
		if ((shirt != null && skirt != null && jacket == null) && (o.getShirt() != null && o.getSkirt() != null  && o.getJacket() == null)){
			if ((shirt.getIndex() == o.getShirt().getIndex()) && (pants.getIndex() == o.getSkirt().getIndex()))
				return true;
		}
		if ((shirt != null && skirt != null && jacket != null) && (o.getShirt() != null && o.getSkirt() != null && o.getJacket() != null)){
			if ((shirt.getIndex() == o.getShirt().getIndex()) && (skirt.getIndex() == o.getSkirt().getIndex()) && (jacket.getIndex() == o.getJacket().getIndex()))
				return true;
		}
		if ((dress != null && jacket == null) && (o.getDress() != null && o.getJacket() == null)){
			if (dress.getIndex() == o.getDress().getIndex())
				return true;
		}
		if ((dress != null && jacket != null) && (o.getDress() != null && o.getJacket() != null)){
			if ((dress.getIndex() == o.getDress().getIndex()) && (jacket.getIndex() == o.getJacket().getIndex()))
				return true;
		}
		return false;
	}
	
	public void setDate(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		dateString = dateFormat.format(date);
	}
	
	public void setDate(String date){
		dateString = date;
	}
	
	public String getDate(){
		return dateString;
	}
	
	public static void save(ArrayList<Outfit> outfits, String name){
		File oldFile = new File(name+".dat");
		if (oldFile.exists()){
			oldFile.delete();
			counter = outfits.size();
			saveString = "Counter: "+counter+"-";
			for (int i=0; i<outfits.size(); i++){
				if (outfits.get(i).getDress() == null)
					saveString += "*";
				else
					saveString += +outfits.get(i).getDress().getIndex();
				
				if (outfits.get(i).getJacket() == null)
					saveString += "*";
				else
					saveString += outfits.get(i).getJacket().getIndex();
				
				if (outfits.get(i).getPants() == null)
					saveString += "*";
				else
					saveString += outfits.get(i).getPants().getIndex();
				
				if (outfits.get(i).getShirt() == null)
					saveString += "*";
				else
					saveString += +outfits.get(i).getShirt().getIndex();
				
				if (outfits.get(i).getSkirt() == null)
					saveString += "*";
				else
					saveString += outfits.get(i).getSkirt().getIndex();
				saveString += outfits.get(i).getDate();
				if (i != outfits.size()-1)
					saveString += "-";
			}//end for
		}
		try {
			File newFile  = new File(name+".dat");
			FileWriter fw = new FileWriter (newFile);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter outFile = new PrintWriter (bw);
			outFile.println(saveString);
			outFile.close();
			}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			} 
		catch (IOException e) {
			System.err.println("FileCopy: " + e);
		}
	}
	
	public static String load(String name){
		String readString = null;
		try {
			File newFile  = new File(name+".dat");
			FileReader fr = new FileReader (newFile);
			BufferedReader br = new BufferedReader (fr);
			String str;
			while ((str = br.readLine()) != null){
				readString += str;
			}
			br.close();
			}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			}
		catch (IOException e) {
			System.err.println("FileCopy: " + e);
			}
		return readString;
	}
}
