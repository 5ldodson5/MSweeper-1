public class Tile{
	private int contains; // 0 is empty, 1-8 is amount of bombs nearby, 9 is bomb.
	private boolean hasFlag;
	private boolean isRevealed;
	
	public Tile(int x) {
		this.contains = x;
		this.hasFlag = false;
		this.isRevealed = false;
	}
	
	public int getContains() {
		return contains;
	}
	
	public void setContains(int x) {
		contains = x;
	}
	
	public void placeFlag() {
		hasFlag = true;
	}
	
	public void removeFlag() {
		hasFlag = false;
	}
	
	public boolean getFlag() {
		return hasFlag;
	}
	
	public void reveal() {
		isRevealed = true;
	}
	
	public boolean isRevealed() {
		return isRevealed;
	}
}