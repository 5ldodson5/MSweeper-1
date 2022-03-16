public class Tile{
	private int contains;
	private boolean hasFlag;
	private boolean isRevealed;
	
	public Tile(int x) {
		contains = x;
		hasFlag = false;
		isRevealed = false;
	}
	
	public int getContains() {
		return contains;
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