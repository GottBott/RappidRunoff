import java.util.HashSet;
//The idea for this came from Josh Bloch, "Effective Java" 

/** inheritance **/
class Node extends HashSet<Object> {
    Node left, right;   
    int stringCount = 0;
    public boolean add(Object o){ 
	if (o instanceof String) 
	    stringCount++; 
		System.out.println("add" + stringCount);
	return super.add(o); 
    }
    public boolean addAll( Node n ){ 
	stringCount += n.stringCount; 
	System.out.println("addALL" + stringCount);
	return super.addAll(n); 
    }

    public static void main(String[] args){
	String s1 = "a";
	String s2 = "b";
	String s3 = "c";
	Node n1 = new Node();
	n1.add(s1);
	n1.add(s2);
	n1.add(s3);
	System.out.println(n1);
	System.out.println(n1.stringCount);
	Node n2 = new Node();

	n2.addAll(n1); // 

	System.out.println(n2);
	System.out.println(n2.stringCount);
    }
}