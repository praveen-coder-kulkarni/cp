import java.util.Stack;
import java.util.NoSuchElementException;

public class MinStack<Item extends Comparable<Item>>{

	private Stack<Pair<Item>> ds = new Stack<Pair<Item>>();
	private Item min;

	public boolean isEmpty(){
		return ds.isEmpty();
	}

	public int size(){
		return ds.size();
	}

	public void push(Item item){
		if(isEmpty())	min = item;
		else 			min = min.compareTo(item) < 0 ? min : item;
		Pair<Item> pair = new Pair(item, min);
		ds.push(pair);
	}

	public Item peek(){
		if(isEmpty())	throw new NoSuchElementException("MinStack is empty!!");
		return ds.peek().getFirst();
	}

	public Item pop(){
		if(isEmpty())	throw new NoSuchElementException("MinStack is empty!!");
		Item item = ds.pop().getFirst();
		min = isEmpty() ? null : ds.peek().getSecond();
		return item;
	}

	public Item getMin(){
		return min;
	}


	public static void main(String[] args) {
		MinStack<Integer> minStack = new MinStack<Integer>();
		minStack.push(5);
		minStack.push(-1);	
		minStack.pop();
		System.out.println(minStack.getMin());
		minStack.push(100);
		minStack.push(1);
		minStack.push(2);
		System.out.println(minStack.getMin());		
	}
}