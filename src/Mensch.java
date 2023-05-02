import ledControl.BoardController;

public class Mensch implements AnimatedObjects{
	
	private final int[] oberkoerper = new int[]{3, 75, 75};
	private final int[]unterkoerper = new int[]{75, 69, 33};
	private final int[] kopf = new int []{127, 125, 127};
	private BoardController controller;
	
	public Mensch (BoardController controller) {
		this.controller = controller;
	}
	
	public void draw() {
		controller.maxColor(3, 18, unterkoerper);		//Anfang hose
		controller.maxColor(3, 17, unterkoerper);
		controller.maxColor(3, 16, unterkoerper);
		controller.maxColor(4, 16, unterkoerper);
		controller.maxColor(5, 16, unterkoerper);
		controller.maxColor(5, 17, unterkoerper);
		controller.maxColor(5, 18, unterkoerper);		//Ende Hose
		
		controller.maxColor(4, 15, oberkoerper);		//Anfang Oberkoerper
		controller.maxColor(4, 14, oberkoerper);
		controller.maxColor(3, 13, oberkoerper);
		controller.maxColor(2, 13, oberkoerper);
		controller.maxColor(5, 13, oberkoerper);
		controller.maxColor(6, 13, oberkoerper);
		controller.maxColor(4, 13, oberkoerper);
		controller.maxColor(4, 12, oberkoerper);		//Ende Oberkoerper
		
		controller.maxColor(4, 11, kopf); 				//Kopf
		controller.updateBoard();
	}
	
	public void update() {
		
	}
}