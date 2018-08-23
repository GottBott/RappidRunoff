import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;


public class Triple implements Iterable {
	int[] triple = {1,2,3};
	
	public Iterator iterator() {
	    return new TripleIterator(triple);
	  }
	
	//Ben Gotthold
	//Mason rowe
	//Stefan Zimmerman
	//Mary doolen
	//Steve Noyes
	//Joe Illuminatti
	
	
	private class TripleIterator implements Iterator {


		  private boolean hasNextItem = false;
		  private int nextItem;
		  int[] array = {};
		 
		  TripleIterator(int[] triple){
			  	this.array = triple;
				nextItem = array[0];
			}
		  
		  
		  
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public Object next() {
			int sub = nextItem;
			calcNext();
			return sub;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
		public void calcNext() {
			if(nextItem == array[array.length-1]){
				nextItem = array[0];
			}
			else{
				nextItem = array[nextItem];
			}
		      
		  }
	
	}
	
	public static void main(String[] args) {
		Triple t = new Triple();
		Iterator ti = t.iterator();
		for(int i = 0; i < 10; i++)
		if (ti.hasNext())
		System.out.print(ti.next() + " ");
		System.out.println();
		}
	// prints 1 2 3 1 2 3 1 2 3 1

	
	

	

}
