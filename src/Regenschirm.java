import ledControl.BoardController;

public class Regenschirm implements AnimatedObjects {

	private final int[] top = new int[]{99, 66, 88};
	private final int[] handle = new int[]{20, 21, 22};
	private BoardController controller;
	
	public Regenschirm(BoardController controller){
		this.controller = controller;
	}
	
	public void draw() {
		controller.maxColor(6, 10, handle);
		controller.maxColor(6, 11, handle);
		controller.maxColor(6, 12, handle);
		controller.maxColor(6, 9, top);
		controller.maxColor(7, 9, top);
		controller.maxColor(8, 9, top);
		controller.maxColor(9, 9, top);
		controller.maxColor(10, 10, top);
		controller.maxColor(5, 9, top);
		controller.maxColor(4, 9, top);
		controller.maxColor(3, 9, top);
		controller.maxColor(2, 10, top);
		controller.updateBoard();
	}

	public void update() {
		
	}
}