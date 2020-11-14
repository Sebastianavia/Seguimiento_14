package model;
import java.util.ArrayList;
public class IntegerSet{
	
	private String name;
	private int cardinality;
	private ArrayList<Integer> elements;
	
	public IntegerSet(String name){
		this.name = name;
		this.cardinality = 0;
		this.elements = new ArrayList<Integer>();
	}	
	public String getName(){
		return name;
	}	
	public int getCardinality(){
		return this.cardinality;
	}
	public ArrayList<Integer> getElements(){
		return elements;
	}	
	public String addElement(int element){
		String message="";
		boolean done = false;
		for(int i=0;i<cardinality&& !done;i++){
			if(elements.get(i)==element){
				done = true;
				message= "Ya existe un elemento igual";
			}
		}
		if(done == false){
			elements.add(element);
			cardinality++;
			message="Se añadio el elemento";
		}
		return message;
	}	
	public void removeElement(int element){
		boolean done = false;		
		for(int i=0;i<cardinality&& !done;i++){
			if(elements.get(i)==element){
				elements.remove(i);
				cardinality--;
				done = true;
			}
		}
	}
	public IntegerSet union(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> setElements = set.getElements();
		for(int i=0;i<cardinality;i++){
			newSet.addElement(elements.get(i));
		}
		for(int i=0;i<cardinality;i++){
			for(int j=0 ; j<set.getCardinality() ; j++){
				if(elements.get(i) != setElements.get(j)){
					newSet.addElement(setElements.get(j));
				}
			}
		}		
		return newSet;
	}	
	public IntegerSet difference(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0;i<cardinality;i++){
			newSet.addElement(elements.get(i));
		}
		ArrayList<Integer> setElements = set.getElements();
		for(int i=0;i<set.getCardinality();i++){
			newSet.removeElement(setElements.get(i));
		}
		return newSet;
	}	
	public IntegerSet intersection(IntegerSet set, String newName){
		IntegerSet newSet = new IntegerSet(newName);
		ArrayList<Integer> setElements = set.getElements();
		for(int i=0;i<cardinality;i++){
			for(int j=0 ; j<set.getCardinality() ; j++){
				if(elements.get(i) == setElements.get(j)){
					newSet.addElement(setElements.get(j));
				}
			}
		}
		return newSet;
	}	
	public IntegerSet symmetricDifference(IntegerSet set, String newName){
		IntegerSet set1 = union(set,newName);
		IntegerSet set2 = intersection(set,newName);
		IntegerSet newSet = new IntegerSet(newName);
		for(int i=0 ; i<set2.getCardinality() ; i++){
			set1.removeElement(set2.getElements().get(i));
		}
		for(int i=0 ; i<set1.getCardinality() ; i++){
			newSet.addElement(set1.getElements().get(i));
		}
		return newSet;
	}	
	public String showContents(){
		String msg = "****************Conjunto****************"+"\n";
		msg += "Nombre : "+getName()+"\n";
		msg += "Elementos : "+"\n";
		for(int i=0; i<cardinality; i++){
			msg += this.elements.get(i) + ", ";
		}
		msg += "\n"+"****************************************"+"\n";
		return msg;
	}	
}