import ledControl.BoardController;

public class Blitz implements AnimatedObjects {
	
	private final int[] stun = new int[]{98, 98, 0};
	private BoardController controller;
	
	public Blitz(BoardController controller) {
		this.controller=controller;
	}

	public void draw() {
		controller.maxColor(8, 2, stun);
		controller.maxColor(9, 2, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(7, 3, stun);
		controller.maxColor(8, 3, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(6, 4, stun);
		controller.maxColor(7, 4, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(5, 5, stun);
		controller.maxColor(6, 5, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(4, 6, stun);
		controller.maxColor(5, 6, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(6, 6, stun);
		controller.maxColor(7, 5, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(7, 6, stun);
		controller.maxColor(8, 5, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(8, 6, stun);
		controller.maxColor(9, 5, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(6, 7, stun);
		controller.maxColor(7, 7, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(5, 8, stun);
		controller.maxColor(6, 8, stun);
		controller.updateBoard();
		controller.sleep(75);
		controller.maxColor(4, 9, stun);
		controller.maxColor(5, 9, stun);
		controller.updateBoard();
		controller.sleep(75);
	}

	public void update() {
		
	}
}