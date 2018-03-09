import java.io.*;
import java.util.*;

class stack{
	int length=5;
	int pos;
	int arr[];

	public stack(){
		arr = new int[length];
		pos=-1;
	}

	public int size(){
		return pos+1;
	}

	public boolean isEmpty(){
		return pos==-1;
	}

	public void push(int d){
		if(size()==length){
			int[] temp = new int[2*length];
			for(int i=0;i<length;i++)
				temp[i] = arr[i];

			arr = temp;
			length*=2;
		}

		arr[++pos] = d;
	}

	public int pop() /*throws EmptyStackException*/{
		/*if(isEmpty()==true)
			throw new EmptyStackException();

		else
		*/ return arr[pos--];
	}

	public int top() /*throws EmptyStackException*/ {
		/*if(isEmpty()==true)
			throw new EmptyStackException();

		else
		*/	return arr[pos];
	}
}

public class FabricBreakup{
	public static void main(String args[]){

		try{
			FileInputStream fstream = new FileInputStream(args[0]);
			Scanner s = new Scanner(fstream);
			/*while(s.hasNextInt())
				System.out.println(s.nextInt());
			*/

			int n = s.nextInt();
			int id,pref,ans;
			stack shirts = new stack();
			stack count = new stack();
	
			for(int i=0;i<n;i++){
				s.nextInt();
				id = s.nextInt();

				if(id==1){
					pref = s.nextInt();

					if( shirts.isEmpty()==true || pref>=shirts.top() ){
						shirts.push( pref );
						count.push(0);
						continue;
					}
	
					else
						count.push( count.pop() + 1 );
				}
			
				else{
					if(shirts.isEmpty()==true)
						ans=-1;
					else{
						ans=count.pop();
						shirts.pop();
					}

					System.out.println( (i+1) + " " + ans);
				}
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found");
		}

	}
}

