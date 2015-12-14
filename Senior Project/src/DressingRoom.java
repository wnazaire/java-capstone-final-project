import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class DressingRoom extends BasicGameState{
	private Image room, nextButton, backButton;
	private static String name;
	private int state, count;
	private Boolean view; //view determines whether or not the "View Saved Outfits" button has been clicked
	private static Boolean dress, jacket, pant, shirt, skirt;
	private static Dress dressObj;
	private static Jacket jacketObj;
	private static Pants pantsObj;
	private static Shirt shirtObj;
	private static Skirt skirtObj;
	private ArrayList<Outfit> outfits;
	public static final int menuID = 1;
	public static final int roomID = 2;
	public static final int closetID = 3;
	
	public DressingRoom (int state){
		this.state=state;
	}
	
	public void init (GameContainer gc, StateBasedGame sbg) throws SlickException{
		room = new Image("Images/RoomView.png");
		nextButton = new Image("Images/nextArrow.png");
		backButton = new Image("Images/backArrow.png");
		outfits = new ArrayList<Outfit>();
		count = -1;
		view = pant = shirt = skirt = dress = jacket = false;
	}
	
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException{
		g.drawImage(room, 0, 0);
		Input input = gc.getInput();
		int xpos = input.getAbsoluteMouseX();
		int ypos = input.getAbsoluteMouseY();
		
		if (view){
			if (!outfits.isEmpty()){
				g.drawImage(backButton, 312, 279); //Back arrow 38 x 42
				g.drawImage(nextButton, 650, 279); //Next arrow 38 x 42
				pant = shirt = skirt = dress = jacket = false;
				if (count>=0 && count<outfits.size()){
					g.drawString("Date last worn :"+outfits.get(count).getDate(), 725, 225);
					draw(outfits.get(count).getDress());
					draw(outfits.get(count).getJacket());
					draw(outfits.get(count).getPants());
					draw(outfits.get(count).getShirt());
					draw(outfits.get(count).getSkirt());
				}
				
				//deletes current outfit
				if ((xpos>350 && xpos<650) && (ypos>164 && ypos<550)){ //viewable area of outfit
					if(input.isMousePressed(0)){
						outfits.remove(count);
						Outfit.save(outfits, name);
						updateOutfits();
						count = 0;
						JOptionPane.showMessageDialog(null, "Outfit deleted!", "Outfit deleted", JOptionPane.INFORMATION_MESSAGE);
					 	view = pant = shirt = skirt = dress = jacket = false;
					}
				}
				
				
				if (ypos>279 && ypos<321){
					//backward button
					if (xpos>312 && xpos<350){
						if(input.isMousePressed(0)){
							if (count>0){
								count--;
								if (outfits.get(count).getDress() == null)
									dress = false;
								if (outfits.get(count).getJacket() == null)
									jacket = false;
								if (outfits.get(count).getPants() == null)
									pant = false;
								if (outfits.get(count).getShirt() == null)
									shirt = false;
								if (outfits.get(count).getSkirt() == null)
									skirt = false;
							}
							else{
								count = 0;
								if (outfits.get(count).getDress() == null)
									dress = false;
								if (outfits.get(count).getJacket() == null)
									jacket = false;
								if (outfits.get(count).getPants() == null)
									pant = false;
								if (outfits.get(count).getShirt() == null)
									shirt = false;
								if (outfits.get(count).getSkirt() == null)
									skirt = false;
							}
						}
					}
					
					//forward button
					if (xpos>650 && xpos<688){
						if(input.isMousePressed(0)){
							if (count<outfits.size()-1){
								count++;
								if (outfits.get(count).getDress() == null)
									dress = false;
								if (outfits.get(count).getJacket() == null)
									jacket = false;
								if (outfits.get(count).getPants() == null)
									pant = false;
								if (outfits.get(count).getShirt() == null)
									shirt = false;
								if (outfits.get(count).getSkirt() == null)
									skirt = false;
							}
							else{
								count = outfits.size()-1;
								if (outfits.get(count).getDress() == null)
									dress = false;
								if (outfits.get(count).getJacket() == null)
									jacket = false;
								if (outfits.get(count).getPants() == null)
									pant = false;
								if (outfits.get(count).getShirt() == null)
									shirt = false;
								if (outfits.get(count).getSkirt() == null)
									skirt = false;
							}
						}
					}
				}
			}
			else{
				view = false;
				JOptionPane.showMessageDialog(null, "There are no outfits to view. To save an outfit, click the \"Save\" button.", "No saved outfits", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
		if (pant){
			g.drawImage(pantsObj.getImage(), 400, 280);
			g.drawString(pantsObj.getType(), 725, 185);
		}
		
		if (skirt){
			g.drawImage(skirtObj.getImage(), 400, 280);
			g.drawString(skirtObj.getType(), 725, 185);
		}
		
		if (shirt){
			g.drawImage(shirtObj.getImage(), 400, 164);
			g.drawString(shirtObj.getNeckline(), 725, 165);
		}

		if (dress){
			g.drawImage(dressObj.getImage(), 400, 164);
			g.drawString(dressObj.getNeckline(), 725, 165);
		}
		
		if (jacket){
			g.drawImage(jacketObj.getImage(), 400, 164);
			g.drawString(jacketObj.getColor(), 725, 205);
		}

	}

	public void update (GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		Input input = gc.getInput();
		int xpos = input.getAbsoluteMouseX();
		int ypos = input.getAbsoluteMouseY();
		
		//To test return to menu
		if((xpos>950 && xpos<1000) && (ypos>0 && ypos<50)){
			if(input.isMousePressed(0)){
				sbg.enterState(menuID);
				view = false;
			}
		}
		
		//Enter closet button 263 x 402
		if((xpos>0 && xpos<263) && (ypos>98 && ypos<500)){
			if(input.isMousePressed(0)){
				sbg.enterState(closetID);
				view = false;
			}
		}
		
		//Info button 34 x 34
		if((xpos>0 && xpos<34) && (ypos>0 && ypos<34)){
			if(input.isMousePressed(0)){
				JOptionPane.showMessageDialog(null, "Click on the \"Save\" button to save the current outfit. Click on the \"Clear\" button to clear the mannequin."+"\n"+
				"Click on the \"Create Outfit\" button to have an outfit made for you. Click on the \"Wear\" button"+"\n"+
				"to change the date worn of the current outfit on the mannequin. To view all saved outfits, "+"\n"+
				"click on the \"View Saved Outfits\" button. Click on an outfit to delete it. To enter the Closet, click on the \"Enter Closet\" button."+"\n"+
				"Remember to save all changes before exiting the program, otherwise, any unsaved changes will not be saved.", "How to navigate the Dressing Room", JOptionPane.INFORMATION_MESSAGE);
				view = false;
			}
		}
		
		if (ypos>10 && ypos<73){
			//Clear button 110 x 63
			if(xpos>268 && xpos<378){
				if(input.isMousePressed(0)){
					view = pant = shirt = skirt = dress = jacket = false;
				}
			}
			
			//Create outfit button 225 x 63
			if(xpos>388 && xpos<613){
				if(input.isMousePressed(0)){
					view = pant = shirt = skirt = dress = jacket = false;
					String style, definition;
					style = JOptionPane.showInputDialog(null, "Enter the number that corresponds with the outfit syle you desire."+"\n"+
					"The options are as follows: "+"\n"+
					"Random: 0"         +"\n"+
					"Business casual: 1"+"\n"+
					"Casual: 2"         +"\n"+
					"Semi-formal: 3"    +"\n"+
					"Formal: 4"         +"\n"+
					"Business formal: 5"+"\n"+
					"Business: 6", "Select a style", JOptionPane.PLAIN_MESSAGE);
					if (style == null || Integer.parseInt(style)<0 || Integer.parseInt(style)>6){
						JOptionPane.showMessageDialog(null, "The value you have entered is invalid. Please try again.", "Invalid value", JOptionPane.ERROR_MESSAGE);
						sbg.enterState(roomID);
						style = null;
					}
					definition = JOptionPane.showInputDialog(null, "Enter the number that corresponds with the elements of clothing that you want in your outfit."+"\n"+
					"The options are as follows: "+"\n"+
					"Random: 0"              +"\n"+
					"Shirt, pants: 1"        +"\n"+
					"Shirt, pants, jacket: 2"+"\n"+
					"Shirt, skirt: 3"        +"\n"+
					"Shirt, skirt, jacket: 4"+"\n"+
					"Dress: 5"               +"\n"+
					"Dress, jacket: 6"       +"\n", "Select a composition", JOptionPane.PLAIN_MESSAGE);
					if (definition == null || Integer.parseInt(definition)<0 || Integer.parseInt(definition)>6){
						JOptionPane.showMessageDialog(null, "The value you have entered is invalid. Please try again.", "Invalid value", JOptionPane.ERROR_MESSAGE);
						sbg.enterState(roomID);
						definition = null;
					}
					if ((style != null) && (definition != null)){
						System.out.println(style);
						Outfit created = Closet.createOutfit(Integer.parseInt(style)-1, Integer.parseInt(definition));
						if (created != null){
							draw(created.getDress());
							draw(created.getJacket());
							draw(created.getPants());
							draw(created.getShirt());
							draw(created.getSkirt());
						}
						else{
							JOptionPane.showMessageDialog(null, "Your outfit could not be created based on that criteria. Please try again.", "Outfit creation failed", JOptionPane.ERROR_MESSAGE);
							sbg.enterState(roomID);
						}
					}
				}
			}
			
			//Save button 110 x 63
			if(xpos>623 && xpos<733){
				if(input.isMousePressed(0)){
					view = false;
					updateOutfits();
					if (outfits.size()<3){
						if (shirt && pant && !jacket){
							Outfit outfit = new Outfit(shirtObj, pantsObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						if (shirt && pant && jacket){
							Outfit outfit = new Outfit(shirtObj, pantsObj, jacketObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						if (shirt && skirt && !jacket){
							Outfit outfit = new Outfit(shirtObj, skirtObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						if (shirt && skirt && jacket){
							Outfit outfit = new Outfit(shirtObj, skirtObj, jacketObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						if (dress && !jacket){
							Outfit outfit = new Outfit(dressObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						if (dress && jacket){
							Outfit outfit = new Outfit(dressObj, jacketObj);
							if (already(outfit))
								JOptionPane.showMessageDialog(null, "Outfit already exists!", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
							else
								outfits.add(outfit);
						}
						Outfit.save(outfits, name);
						JOptionPane.showMessageDialog(null, "Your outfit has been saved!", "Outfit saved successfully", JOptionPane.INFORMATION_MESSAGE);
					}
					else
						JOptionPane.showMessageDialog(null, "Outfit limit reached! Unable to save outfit.", "Outfit saving unsuccessful", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		//Wear button 116 x 40
		if((xpos>810 && xpos<926) && (ypos>460 && ypos<500)){
			if(input.isMousePressed(0)){
				if (view){
					outfits.get(count).setDate();
					JOptionPane.showMessageDialog(null, "Date outfit worn changed!", "Date worn change successful", JOptionPane.INFORMATION_MESSAGE);
					Outfit.save(outfits, name);
				}
			}
		}
		
		//View button 279 x 59
		if((xpos>721 && xpos<1000) && (ypos>541 && ypos<600)){
			if(input.isMousePressed(0)){
				view = true;
				count = 0;
				updateOutfits();
			}
		}
	}
	
	public static void draw (Dress dressO){
		if (dressO != null){
			dressObj = dressO;
			dress = true;
			skirt = false;
			shirt = false;
			pant = false;
		}
	}
	
	public static void draw (Jacket jacketO){
		if (jacketO != null){
			jacketObj = jacketO;
			jacket = true;
		}
	}
	
	public static void draw (Pants pantsO){
		if (pantsO != null){
			pantsObj = pantsO;
			pant = true;
			skirt = false;
			dress = false;
		}
	}
	
	public static void draw (Shirt shirtO){
		if (shirtO != null){
			shirtObj = shirtO;
			shirt = true;
			dress = false;
		}
	}
	
	public static void draw (Skirt skirtO){
		if (skirtO != null){
			skirtObj = skirtO;
			skirt = true;
			pant = false;
			dress = false;
		}
	}
	
	public static void setName(String userName){
		name=userName;
	}
	
	private Boolean already(Outfit o){
		if (outfits.isEmpty())
			return false;
		for (int i=0; i<outfits.size(); i++){
			if (outfits.get(i).equals(o))
				return true;
		}
		return false;
	}
	
	private void updateOutfits(){
		outfits.clear();
		String str = Outfit.load(name);
		int size = Integer.parseInt(str.substring(13, 14));
		if (size>0){
			String[] strings = str.split("-");
			for (int i=1; i<strings.length; i++){ //doesn't check the first element (that holds the counter)		
				if(!(strings[i].substring(3,4).equals("*")) && !(strings[i].substring(2,3).equals("*")) && (strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getShirts().get(Integer.parseInt(strings[i].substring(3,4))), Closet.getPants().get(Integer.parseInt(strings[i].substring(2,3)))));
				
				if(!(strings[i].substring(3,4).equals("*")) && !(strings[i].substring(2,3).equals("*")) && !(strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getShirts().get(Integer.parseInt(strings[i].substring(3,4))), Closet.getPants().get(Integer.parseInt(strings[i].substring(2,3))), Closet.getJackets().get(Integer.parseInt(strings[i].substring(1,2)))));
				
				if(!(strings[i].substring(3,4).equals("*")) && !(strings[i].substring(4,5).equals("*")) && (strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getShirts().get(Integer.parseInt(strings[i].substring(3,4))), Closet.getSkirts().get(Integer.parseInt(strings[i].substring(4,5)))));
				
				if(!(strings[i].substring(3,4).equals("*")) && !(strings[i].substring(4,5).equals("*")) && !(strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getShirts().get(Integer.parseInt(strings[i].substring(3,4))), Closet.getSkirts().get(Integer.parseInt(strings[i].substring(4,5))), Closet.getJackets().get(Integer.parseInt(strings[i].substring(1,2)))));
				
				if(!(strings[i].substring(0,1).equals("*")) && (strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getDresses().get(Integer.parseInt(strings[i].substring(0,1)))));
				
				if(!(strings[i].substring(0,1).equals("*")) && !(strings[i].substring(1,2).equals("*")))
					outfits.add(new Outfit(Closet.getDresses().get(Integer.parseInt(strings[i].substring(0,1))), Closet.getJackets().get(Integer.parseInt(strings[i].substring(1,2)))));
				outfits.get(i-1).setDate(strings[i].substring(5));
			}
		}
	}

	public int getID(){
		return state;
	}

}
