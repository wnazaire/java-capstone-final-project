import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Closet extends BasicGameState{
	private Image closet;
	private int state, count;
	private static ArrayList<Dress> dresses;
	private static ArrayList<Jacket> jackets;
	private static ArrayList<Pants> pants;
	private static ArrayList<Shirt> shirts;
	private static ArrayList<Skirt> skirts;
	private Boolean pant, shirt, skirt, dress, jacket;
	public static final int menuID = 1;
	public static final int roomID = 2;
	public static final int closetID = 3;
	
	public Closet (int state){
		this.state=state;
	}
	
	public void init (GameContainer gc, StateBasedGame sbg) throws SlickException{
		closet = new Image("Images/Closet.png");
		dresses = new ArrayList<Dress>();
		jackets = new ArrayList<Jacket>();
		pants = new ArrayList<Pants>();
		shirts = new ArrayList<Shirt>();
		skirts = new ArrayList<Skirt>();
		count = 0;
		pant = shirt = skirt = dress = jacket = false;
		try {
			loadDresses();
			loadJackets();
			loadPants();
			loadShirts();
			loadSkirts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(closet, 0, 0);
		Input input = gc.getInput();
		int xpos = input.getAbsoluteMouseX();
		int ypos = input.getAbsoluteMouseY();
		
		if (dress){
			if ((count*2)<=dresses.size()-1){
				g.drawImage(dresses.get(count*2).getImage(), 148, 146);
				if ((count*2+1)<=dresses.size()-1)
					g.drawImage(dresses.get(count*2+1).getImage(), 395, 146);
			}
			if ((xpos>148 && xpos<348) && (ypos>146 && ypos<446)){
				if ((count*2)<=dresses.size()-1)
					g.drawString(dresses.get(count*2).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(dresses.get(count*2));
					sbg.enterState(roomID);
				}
			}
			if ((xpos>395 && xpos<595) && (ypos>146 && ypos<446)){
				if ((count*2+1)<=dresses.size()-1)
					g.drawString(dresses.get(count*2+1).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(dresses.get(count*2+1));
					sbg.enterState(roomID);
				}
			}
		}
		if (jacket){
			if ((count*2)<=jackets.size()-1){
				g.drawImage(jackets.get(count*2).getImage(), 148, 146);
				if ((count*2+1)<=jackets.size()-1)
					g.drawImage(jackets.get(count*2+1).getImage(), 395, 146);
			}
			if ((xpos>148 && xpos<348) && (ypos>146 && ypos<446)){
				if ((count*2)<=jackets.size()-1)
					g.drawString(jackets.get(count*2).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(jackets.get(count*2));
					sbg.enterState(roomID);
				}
			}
			if ((xpos>395 && xpos<595) && (ypos>146 && ypos<446)){
				if ((count*2+1)<=jackets.size()-1)
					g.drawString(jackets.get(count*2+1).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(jackets.get(count*2+1));
					sbg.enterState(roomID);
				}
			}
		}
		if (pant){
			if ((count*2)<=pants.size()-1){
				g.drawImage(pants.get(count*2).getImage(), 148, 146);
				if ((count*2+1)<=pants.size()-1)
					g.drawImage(pants.get(count*2+1).getImage(), 395, 146);
			}
			if ((xpos>148 && xpos<348) && (ypos>146 && ypos<446)){
				if ((count*2)<=pants.size()-1)
					g.drawString(pants.get(count*2).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(pants.get(count*2));
					sbg.enterState(roomID);
				}
			}
			if ((xpos>395 && xpos<595) && (ypos>146 && ypos<446)){
				if ((count*2+1)<=pants.size()-1)
					g.drawString(pants.get(count*2+1).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(pants.get(count*2+1));
					sbg.enterState(roomID);
				}
			}
		}
		if (shirt){
			if ((count*2)<=shirts.size()-1){
				g.drawImage(shirts.get(count*2).getImage(), 148, 146);
				if ((count*2+1)<=shirts.size()-1)
					g.drawImage(shirts.get(count*2+1).getImage(), 395, 146);
			}
			if ((xpos>148 && xpos<348) && (ypos>146 && ypos<446)){
				if ((count*2)<=shirts.size()-1)
					g.drawString(shirts.get(count*2).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(shirts.get(count*2));
					sbg.enterState(roomID);
				}
			}
			if ((xpos>395 && xpos<595) && (ypos>146 && ypos<446)){
				if ((count*2+1)<=shirts.size()-1)
					g.drawString(shirts.get(count*2+1).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(shirts.get(count*2+1));
					sbg.enterState(roomID);
				}
			}
		}
		if (skirt){
			if ((count*2)<=skirts.size()-1){
				g.drawImage(skirts.get(count*2).getImage(), 148, 146);
				if ((count*2+1)<=skirts.size()-1)
					g.drawImage(skirts.get(count*2+1).getImage(), 395, 146);
			}
			if ((xpos>148 && xpos<348) && (ypos>146 && ypos<446)){
				if ((count*2)<=skirts.size()-1)
					g.drawString(skirts.get(count*2).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(skirts.get(count*2));
					sbg.enterState(roomID);
				}
			}
			if ((xpos>395 && xpos<595) && (ypos>146 && ypos<446)){
				if ((count*2+1)<=skirts.size()-1)
					g.drawString(skirts.get(count*2+1).toString(), 720, 165);
				if(input.isMousePressed(0)){
					DressingRoom.draw(skirts.get(count*2+1));
					sbg.enterState(roomID);
				}
			}
		}
	}

	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = input.getAbsoluteMouseX();
		int ypos = input.getAbsoluteMouseY();
		
		if(ypos>25 && ypos<88){
			//Pants button 90 x 53
			if (xpos>340 && xpos<430){
				if(input.isMousePressed(0)){
					pant = true;
					shirt = skirt = dress = jacket = false;
					count = 0;
				}
			}
			
			//Shirts button 90 x 53
			if (xpos>225 && xpos<315){
				if(input.isMousePressed(0)){
					shirt = true;
					pant = skirt = dress = jacket = false;
					count = 0;
				}
			}
			
			//Skirts button 90 x 53
			if (xpos>455 && xpos<545){
				if(input.isMousePressed(0)){
					skirt = true;
					pant = shirt = dress = jacket = false;
					count = 0;
				}
			}
			
			//Dresses button 90 x 53
			if (xpos>570 && xpos<660){
				if(input.isMousePressed(0)){
					dress = true;
					pant = shirt = skirt = jacket = false;
					count = 0;
				}
			}
			
			//Jackets button 90 x 53
			if (xpos>685 && xpos<775){
				if(input.isMousePressed(0)){	
					jacket = true;
					pant = shirt = skirt = dress = false;
					count = 0;
				}
			}
			
		}//end if y position is correct
		
		//Info button 34 x 34
		if((xpos>0 && xpos<34) && (ypos>0 && ypos<34)){
			if(input.isMousePressed(0)){
				JOptionPane.showMessageDialog(null, "Click on the clothing item buttons to select which type of clothing to view."+"\n"+
				"Hover over an item of clothing to view its details. To see an item on the mannequin, click on it."+"\n"+
				"To return to the Dressing Room, click on the \"Return to Dressing Room\" button.", "How to navigate the Closet", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		//Return button 309 x 41
		if((xpos>9 && xpos<318) && (ypos>548 && ypos<589)){
			if(input.isMousePressed(0)){
				sbg.enterState(roomID);
			}
		}
		
		//Forward button 34 x 38
		if((xpos>659 && xpos<693) && (ypos>299 && ypos<377)){
			if(input.isMousePressed(0)){
				if(dress && count>=dresses.size()) 
					count = dresses.size();
				else if (jacket && count>=jackets.size()) 
					count = jackets.size();
				else if (pant && count>=pants.size())
					count = pants.size();
				else if (shirt && count>=shirts.size())
					count = shirts.size();
				else if (skirt && count>=skirts.size())
					count = skirts.size();
				else
					count++;
			}
		}
		
		//Back button 34 x 38
		if((xpos>45 && xpos<79) && (ypos>299 && ypos<377)){
			if(input.isMousePressed(0)){
				if (count>0)
					count--;
				else
					count=0;
			}
		}
	}//end method
	
	public static Outfit createOutfit(int style, int definition){
		Outfit outfit = null;
		int a = (int)(Math.random()*dresses.size());
		int b = (int)(Math.random()*jackets.size());
		int c = (int)(Math.random()*pants.size());
		int d = (int)(Math.random()*shirts.size());
		int e = (int)(Math.random()*skirts.size());
		if (definition == 0)
			definition = (int)(Math.random()*5+1);
		switch (definition){
			case 1: //shirt, pants
				if (style == 0){
					while ((shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != 5)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else if (style == 1){
					while ((shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 2)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 2)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else if (style == 2){
					while ((shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 3)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 2) && (pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != 3)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else if (style == 3){
					while ((shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 3) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 2) && (pants.get(c).getStyle() != 4)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else if (style == 4){
					while ((shirts.get(d).getStyle() != 4) && (shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 4) && (pants.get(c).getStyle() != 3) && (pants.get(c).getStyle() != 5)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else if (style == 5){
					while ((shirts.get(d).getStyle() != 5) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 5) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 4)){
						c = (int)(Math.random()*pants.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c));
				}
				else
					outfit = new Outfit(shirts.get(d), pants.get(c));
				break;
			case 2: //shirt, pants, jacket
				 if (style == 0){
					while ((shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != 5)){
						c = (int)(Math.random()*pants.size());
					}
					while ((jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else if (style == 1){
						while ((shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 2)){
							d = (int)(Math.random()*shirts.size());
						}
						while ((pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 2)){
							c = (int)(Math.random()*pants.size());
						}
						while ((jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 2)){
							b = (int)(Math.random()*jackets.size());
						}
						outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else if (style == 2){
					while ((shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 3)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 2) && (pants.get(c).getStyle() != 1) && (pants.get(c).getStyle() != 3)){
						c = (int)(Math.random()*pants.size());
					}
					while ((jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 3)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else if (style == 3){
					while ((shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 3) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 2) && (pants.get(c).getStyle() != 4)){
						c = (int)(Math.random()*pants.size());
					}
					while ((jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else if (style == 4){
					while ((shirts.get(d).getStyle() != 4) && (shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 4) && (pants.get(c).getStyle() != 3) && (pants.get(c).getStyle() != 5)){
						c = (int)(Math.random()*pants.size());
					}
					while ((jackets.get(b).getStyle() != 4) && (jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else if (style == 5){
					while ((shirts.get(d).getStyle() != 5) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((pants.get(c).getStyle() != 5) && (pants.get(c).getStyle() != -1) && (pants.get(c).getStyle() != 0) && (pants.get(c).getStyle() != 4)){
						c = (int)(Math.random()*pants.size());
					}
					while ((jackets.get(b).getStyle() != 5) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				}
				else
					outfit = new Outfit(shirts.get(d), pants.get(c), jackets.get(b));
				break;
			case 3: //shirt, skirt
				if (style == 0){
					while ((shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != 5)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else if (style == 1){
					while ((shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 2)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 2)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else if (style == 2){
					while ((shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 3)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 2) && (skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != 3)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else if (style == 3){
					while ((shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 3) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 2) && (skirts.get(e).getStyle() != 4)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else if (style == 4){
					while ((shirts.get(d).getStyle() != 4) && (shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 4) && (skirts.get(e).getStyle() != 3) && (skirts.get(e).getStyle() != 5)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else if (style == 5){
					while ((shirts.get(d).getStyle() != 5) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 5) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 4)){
						e = (int)(Math.random()*skirts.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				}
				else
					outfit = new Outfit(shirts.get(d), skirts.get(e));
				break;
			case 4: //shirt, skirt, jacket
				if (style == 0){
					while ((shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != 5)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else if (style == 1){
					while ((shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 2)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 2)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 2)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else if (style == 2){
					while ((shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 1) && (shirts.get(d).getStyle() != 3)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 2) && (skirts.get(e).getStyle() != 1) && (skirts.get(e).getStyle() != 3)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 3)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else if (style == 3){
					while ((shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 2) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 3) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 2) && (skirts.get(e).getStyle() != 4)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else if (style == 4){
					while ((shirts.get(d).getStyle() != 4) && (shirts.get(d).getStyle() != 3) && (shirts.get(d).getStyle() != 5)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 4) && (skirts.get(e).getStyle() != 3) && (skirts.get(e).getStyle() != 5)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 4) && (jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else if (style == 5){
					while ((shirts.get(d).getStyle() != 5) && (shirts.get(d).getStyle() != -1) && (shirts.get(d).getStyle() != 0) && (shirts.get(d).getStyle() != 4)){
						d = (int)(Math.random()*shirts.size());
					}
					while ((skirts.get(e).getStyle() != 5) && (skirts.get(e).getStyle() != -1) && (skirts.get(e).getStyle() != 0) && (skirts.get(e).getStyle() != 4)){
						e = (int)(Math.random()*skirts.size());
					}
					while ((jackets.get(b).getStyle() != 5) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				}
				else
					outfit = new Outfit(shirts.get(d), skirts.get(e), jackets.get(b));
				break;
			case 5: //dress
				if (style == 0){
					while ((dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != 5)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else if (style == 1){
					while ((dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 2)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else if (style == 2){
					while ((dresses.get(a).getStyle() != 2) && (dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != 3)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else if (style == 3){
					while ((dresses.get(a).getStyle() != 3) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 2) && (dresses.get(a).getStyle() != 4)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else if (style == 4){
					while ((dresses.get(a).getStyle() != 4) && (dresses.get(a).getStyle() != 3) && (dresses.get(a).getStyle() != 5)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else if (style == 5){
					while ((dresses.get(a).getStyle() != 5) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 4)){
						a = (int)(Math.random()*dresses.size());
					}
					outfit = new Outfit(dresses.get(a));
				}
				else
					outfit = new Outfit(dresses.get(a));
				break;
			case 6: //dress, jacket
				if (style == 0){
					while ((dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != 5)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else if (style == 1){
					while ((dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 2)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 2)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else if (style == 2){
					while ((dresses.get(a).getStyle() != 2) && (dresses.get(a).getStyle() != 1) && (dresses.get(a).getStyle() != 3)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 1) && (jackets.get(b).getStyle() != 3)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else if (style == 3){
					while ((dresses.get(a).getStyle() != 3) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 2) && (dresses.get(a).getStyle() != 4)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 2) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else if (style == 4){
					while ((dresses.get(a).getStyle() != 4) && (dresses.get(a).getStyle() != 3) && (dresses.get(a).getStyle() != 5)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 4) && (jackets.get(b).getStyle() != 3) && (jackets.get(b).getStyle() != 5)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else if (style == 5){
					while ((dresses.get(a).getStyle() != 5) && (dresses.get(a).getStyle() != -1) && (dresses.get(a).getStyle() != 0) && (dresses.get(a).getStyle() != 4)){
						a = (int)(Math.random()*dresses.size());
					}
					while ((jackets.get(b).getStyle() != 5) && (jackets.get(b).getStyle() != -1) && (jackets.get(b).getStyle() != 0) && (jackets.get(b).getStyle() != 4)){
						b = (int)(Math.random()*jackets.size());
					}
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				}
				else
					outfit = new Outfit(dresses.get(a), jackets.get(b));
				break;
			default: 
				break;
		}//end switch
		return outfit;
	}
	
	public static void loadDresses() throws Exception{
		for (int i=0; i<=8; i++){
			dresses.add(new Dress("Dress"+i));
			dresses.get(i).addDetails(i);
		}//End for
	}
	
	public static void loadJackets() throws Exception{
		for (int i=0; i<=3; i++){
			jackets.add(new Jacket("Jacket"+i));
			jackets.get(i).addDetails(i);
		}//End for
	}
	
	public static void loadPants() throws Exception{
		for (int i=0; i<=9; i++){
			pants.add(new Pants("Pants"+i));
			pants.get(i).addDetails(i);
		}//End for
	}
	
	public static void loadShirts() throws Exception{
		for (int i=0; i<=13; i++){
			shirts.add(new Shirt("Shirt"+i));
			shirts.get(i).addDetails(i);
		}//End for
	}
	
	public static void loadSkirts() throws Exception{
		for (int i=0; i<=7; i++){
			skirts.add(new Skirt("Skirt"+i));
			skirts.get(i).addDetails(i);
		}//End for
	}
	
	public static ArrayList<Dress> getDresses() {
		return dresses;
	}
	
	public static ArrayList<Jacket> getJackets() {
		return jackets;
	}
	
	public static ArrayList<Pants> getPants() {
		return pants;
	}
	
	public static ArrayList<Shirt> getShirts() {
		return shirts;
	}
	
	public static ArrayList<Skirt> getSkirts() {
		return skirts;
	}

	public int getID(){
		return state;
	}
}