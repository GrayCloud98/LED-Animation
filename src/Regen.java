import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ledControl.BoardController;

public class Regen implements AnimatedObjects{
	
	private final int[] rainDrop = new int[]{0, 0, 45};
	private BoardController controller;
	private List <Integer> xpos = new ArrayList<>();
	private List <Integer> ypos = new ArrayList<>();
	
	public Regen(BoardController controller){
		this.controller = controller;
	}
	
	private void Tropfen() {
		xpos.add(new Random().nextInt(controller.getWidth()));
		ypos.add(2);
	}
	
	public void draw() {
		for (int i=0; i<xpos.size(); i++) 
			controller.setColor(xpos.get(i), ypos.get(i), rainDrop);
		controller.updateBoard();
	}

	public void update() {
		int counter = 0;
		
		if (counter == 0) {
			counter = 1; 
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
			Tropfen();
		}
		
		for (int i =0; i< ypos.size(); i++) 
			ypos.set(i, ypos.get(i)+1);
		counter--;
	}
}