package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationAndDeserialization {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	//create object of class test
	Test objTest1 = new Test();	
		
	//Serialization
	FileOutputStream fos = new FileOutputStream("testobject.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(objTest1);
	
	
	//Deserialization
	FileInputStream fis = new FileInputStream("testobject.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);
	Test objTest2 = (Test) ois.readObject();
	objTest2.printStar(6);
		
  }
}

class Test implements Serializable{
	public void printStar(int n) {
	 for(int i=0; i<n; i++){  
	   for(int j=0; j<=i; j++){ 
	       System.out.print("* "); 
	    } 
	  System.out.println(); 
	  } 
	}
}