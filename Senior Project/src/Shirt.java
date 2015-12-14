import java.awt.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Shirt {
	private Image shirt;
	private Color color;
	private String length, sleeve, neckline;
	private int style, index;
	
	public Shirt(String location) throws SlickException {
		shirt = new Image("Images/Shirts/"+location+".png");
	}
	
	public void addDetails(int index){
		switch (index){
			case 0:
				color = Color.BLACK;
				length = "long";
				sleeve = "long sleeve";
				neckline = "jewel";
				style = 2;
				break;
			case 1:
				color = Color.WHITE;
				length = "long";
				sleeve = "short sleeve";
				neckline = "scoop";
				style = 1;
				break;
			case 2:
				color = new Color(127, 127, 129); //gray
				length = "short";
				sleeve = "short sleeve";
				neckline = "scoop";
				style = 1;
				break;
			case 3:
				color = Color.WHITE;
				length = "short";
				sleeve = "short";
				neckline = "scoop";
				style = 2;
				break;
			case 4:
				color = Color.WHITE;
				length = "short";
				sleeve = "short";
				neckline = "scoop";
				style = 1;
				break;
			case 5:
				color = Color.BLACK;
				length = "long";
				sleeve = "n/a";
				neckline = "straight across";
				style = 2;
				break;
			case 6:
				color = new Color(0, 150, 167); //blue
				length = "long";
				sleeve = "n/a";
				neckline = "high neck";
				style = 0;
				break;
			case 7:
				color = new Color(229, 67, 97); //pink
				length = "long";
				sleeve = "n/a";
				neckline = "high neck";
				style = 0;
				break;
			case 8:
				color = new Color(191, 176, 0); //yellow
				length = "long";
				sleeve = "n/a";
				neckline = "high neck";
				style = 0;
				break;
			case 9:
				color = new Color(53, 141, 78); //green
				length = "long";
				sleeve = "long";
				neckline = "high neck";
				style = -1;
				break;
			case 10:
				color = new Color(117, 117, 122); //gray
				length = "long";
				sleeve = "long";
				neckline = "high neck";
				style = -1;
				break;
			case 11:
				color = new Color(1, 76, 118); //blue
				length = "long";
				sleeve = "long";
				neckline = "high neck";
				style = -1;
				break;
			case 12:
				color = new Color(66, 189, 169); //green
				length = "short";
				sleeve = "short";
				neckline = "scoop";
				style = 1;
				break;
			case 13:
				color = Color.WHITE;
				length = "n/a";
				sleeve = "strap";
				neckline = "scoop";
				style = 1;
				break;
			default:
				color = Color.BLACK;
				length = "short";
				sleeve = "short";
				neckline = "crew cut";
				style = 1;
				break;
		}//end switch
		this.index = index;
	}
	
	public Image getImage(){
		return shirt;
	}
	
	public String getNeckline(){
		return "Shirt Neckline: "+neckline;
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
