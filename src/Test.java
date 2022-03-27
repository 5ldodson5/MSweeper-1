public class Test{
	public static void main(String[] args) throws Exception {
		ControllerMap testMap = new ControllerMap(5,5);
		testMap.placeBombs();
		testMap.printMap();
		System.out.println("\n\n");
		testMap.placeNumbers();
		testMap.printMap();
        
	}
}