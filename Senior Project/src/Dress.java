import java.awt.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Dress {
	private Image dress;
	private Color color;
	private String length, sleeve, neckline;
	private int style, index;
	
	public Dress(String location) throws SlickException {
		dress = new Image("Images/Dresses/"+location+".png");
	}
	
	public void addDetails(int index){
		switch (index){
			case 0:
				color = new Color(170, 124, 120); //champagne
				length = "long";
				sleeve = "n/a";
				neckline = "sweetheart";
				style = 2;
				break;
			case 1:
				color = new Color(148, 110, 101); //champagne
				length = "long";
				sleeve = "n/a";
				neckline = "v-neck";
				style = 4;
				break;
			case 2:
				color = new Color(252, 203, 185); //pink
				length = "long";
				sleeve = "n/a";
				neckline = "sweetheart";
				style = 2;
				break;
			case 3:
				color = new Color(21, 161, 108); //green
				length = "long";
				sleeve = "n/a";
				neckline = "v-neck";
				style = 4;
				break;
			case 4:
				color = new Color(0, 64, 152); //blue
				length = "long";
				sleeve = "n/a";
				neckline = "sweetheart";
				style = 2;
				break;
			case 5:
				color = Color.BLACK;
				length = "short";
				sleeve = "n/a";
				neckline = "sweetheart";
				style = 2;
				break;
			case 6:
				color = Color.BLACK;
				length = "long";
				sleeve = "short";
				neckline = "scoop";
				style = 4;
				break;
			case 7:
				color = Color.BLACK;
				length = "long";
				sleeve = "n/a";
				neckline = "v-neck";
				style = 1;
				break;
			case 8:
				color = new Color(35, 46, 64); //navy blue
				length = "long";
				sleeve = "n/a";
				neckline = "sweetheart";
				style = -1;
				break;
			default:
				color = Color.BLACK;
				length = "short";
				sleeve = "short";
				neckline = "sweetheart";
				style = 1;
				break;
		}//end switch
		this.index = index;
	}
	
	public Image getImage(){
		return dress;
	}
	
	public String getNeckline(){
		return "Dress Neckline: "+neckline;
	}
	
	public int getStyle(){
		return style;
	}
	
	public int getIndex(){
		return index;
	}
	
	public String toString(){
		String styleString;
		switch (style){
			case -1: styleString = "semi-formal";
			case 0: styleString = "business casual";
			case 1: styleString = "casual";
			case 2: styleString = "semi-formal";
			case 3: styleString = "formal";
			case 4: styleString = "business formal";
			case 5: styleString = "business";
			default: styleString = "semi-casual";
		}
		return "Color: RGB("+color.getRed()+", "+color.getGreen()+", "+color.getBlue()+") "+"\n"
				+"Length: "+length+"\n"
				+"Sleeve length: "+sleeve+"\n"
				+"Neckline type: "+neckline+"\n"
				+"Style: "+styleString;
	}
}
