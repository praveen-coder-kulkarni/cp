public class Pair<Item>{
	private Item first;
	private Item second;

	public Pair(Item first, Item second){
		this.first = first;
		this.second = second;
	}

	public Item getFirst(){
		return first;
	}

	public Item getSecond(){
		return second;
	}

	public void setFirst(Item item){
		first = item;
	}

	public void setSecond(Item item){
		second = item;
	}

	@Override
	public String toString(){
		return "Pair: <" + first + ", " + second + ">";
	}
}