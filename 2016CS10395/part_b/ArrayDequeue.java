
public class ArrayDequeue implements DequeInterface {
 	
	int first=-1,last=-1,length=1;
	//first = last = -1;
	//int length=1;
	Object arr[] = new Object[length];
 
 public void insertFirst(Object o){
    //you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  
	if(first == -1){
		first = last = 0;
		arr[first]=o;
	}

  	else{
		if(size()==length){
			Object temp[] = new Object[2*length];
			for(int i=0;i<length;i++){
				temp[i] = arr[ (i + first)%length ];
			}

			arr = temp;
			first=0;
			last=length-1;
			length *= 2;
		}

		first = (first - 1 + length) % length;
		arr[first]=o;
	}
  }
  
  public void insertLast(Object o){
//you need to implement this
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");

	if(first == -1){
		first = last = 0;
		arr[first] = o;
	}

	else{
    		 if(size()==length){
			Object temp[] = new Object[2*length];
			for(int i=0;i<length;i++){
				 temp[i] = arr[ (i + first) % length ];
		    	}
			arr = temp;
			first=0;
			last = length-1;
			length *= 2;
		}
	
		last = (last + 1) % length;
		arr[last] = o;
	}
  }
  
  public Object removeFirst() throws EmptyDequeException {
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
 
	if(isEmpty()==true)
		throw new EmptyDequeException("Cant remove from empty queue");
	
	else if(size()==1){
		int temp = first;
		first = last = -1;
		return arr[temp];
	}
	
	else{
		int temp = first;
		first = (first + 1) % length;
		return arr[temp];
	}
 }
  
  public Object removeLast() throws EmptyDequeException {
    //throw new  java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	if(isEmpty() == true)
		throw new EmptyDequeException("Cant remove from empty queue");
	
	else if(size()==1){
		int temp = last;
		first = last = -1;
		return arr[temp];
	}
	
	else{
		int temp = last;
		last = (last - 1 + length) % length;
		return arr[temp];
	}
  }
  public Object first() throws EmptyDequeException {
    //throw new  java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	if(isEmpty() == true)
		throw new EmptyDequeException("Cant remove from empty queue");
	else
		return arr[first];
  }
  
  public Object last() throws EmptyDequeException {
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	if(isEmpty() == true)
		throw new EmptyDequeException("Cant remove from empty queue");
	else
		return arr[last];
  }
  
  public int size(){
    //throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	if(first == -1)
		return 0;
	else
		return (last - first + length) % length + 1 ;
  }

  public boolean isEmpty(){
   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	if(first == -1)
		return true;
	else
		return false;
  }

  public String toString(){
   // throw new java.lang.UnsupportedOperationException("Not implemented yet.");
  
  	String s = new String();
	s = "[";

	if(isEmpty()==false){
	int i = first;
	for(; (last - i + length) % length > 0 ; i = (i+1)%length){
		s = s + arr[i] + ", ";
	}
	if( (last - i + length) % length + 1 > 0)
		s = s + arr[i];
	}

	s = s + "]";

	return s;
  }
  
  
  public static void main(String[] args){
    int  N = 10;
    DequeInterface myDeque = new ArrayDequeue();
    for(int i = 0; i < N; i++) {
      myDeque.insertFirst(i);
      myDeque.insertLast(-1*i);
    }
   
    int size1 = myDeque.size();
    System.out.println("Size: " + size1);
    System.out.println(myDeque.toString());
    
    if(size1 != 2*N){
      System.err.println("Incorrect size of the queue.");
    }
    
    //Test first() operation
    try{
      int first = (int)myDeque.first();
      int size2 = myDeque.size(); //Should be same as size1
      if(size1 != size2) {
        System.err.println("Error. Size modified after first()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //Remove first N elements
    for(int i = 0; i < N; i++) {
      try{
        int first = (Integer)myDeque.removeFirst();
      }
      catch (EmptyDequeException e) {
        System.out.println("Cant remove from empty queue");
      }
      
    }
    
    
    int size3 = myDeque.size();
    System.out.println("Size: " + myDeque.size());
    System.out.println(myDeque.toString());
   
    if(size3 != N){
      System.err.println("Incorrect size of the queue.");
    }
    
    try{
      int last = (int)myDeque.last();
      int size4 = myDeque.size(); //Should be same as size3
      if(size3 != size4) {
        System.err.println("Error. Size modified after last()");
      }
    }
    catch (EmptyDequeException e){
      System.out.println("Empty queue");
    }
    
    //empty the queue  - test removeLast() operation as well
    while(!myDeque.isEmpty()){
        try{
          int last = (int)myDeque.removeLast();
        }
        catch (EmptyDequeException e) {
          System.out.println("Cant remove from empty queue");
        }
    }
    
    int size5 = myDeque.size();
    if(size5 != 0){
      System.err.println("Incorrect size of the queue.");
    }
    
  }
  
}
