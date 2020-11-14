package model;
import java.util.ArrayList;
public class MathApp{
	private int amount;
	private ArrayList <IntegerSet> Sets;
	public MathApp() {
		this.amount=0;
		this.Sets= new ArrayList <IntegerSet>();
	}



   public IntegerSet buscar(String name){
	IntegerSet conjunto=null;
	boolean add=false;
	for(int i=0;i<this.Sets.size() && !add;i++){
		if(this.Sets.get(i).getName().equalsIgnoreCase(name)){
			conjunto=this.Sets.get(i);
			add=true;
		}
	}
	return conjunto;
}



	public String addSet (String name){
		String message ="";
		IntegerSet newSet =buscar(name);
			if (newSet!=null){
			message="El conjunto ya existe";
	}else{
		this.Sets.add(new IntegerSet(name));	
		amount++;		
			message="Se creo el conjunto";
	}
		return message;
	}

	public String removeSet(String name){
		String message="";
		IntegerSet conjunto=buscar(name);
		if (conjunto!=null){
	      this.Sets.remove(conjunto);
	      amount--;	
	      message= "Se elimino el conjunto";	
		}
		else {
			message="No existe ningun conjunto con ese nombre";
		}
		return message;
	}
		
	
	public String addElementToSet(String setName, int element){
		String message = "";
		IntegerSet conjunto=buscar(setName);
        	if(conjunto!=null){
		message=conjunto.addElement(element);

	}
		return message;
	}


	public String removeElementFromSet(String setName, int element){
		String message="";
		IntegerSet conjunto=buscar(setName);
		if(conjunto!=null){
			conjunto.removeElement(element);
			message="Se elimino el elemento";
		}
		return message;
	}



	public String union (String setName1, String setName2, String newName){
		String message ="";
		IntegerSet conj1=buscar(setName1);
	IntegerSet conj2=buscar(setName2);
	if (conj1!=null && conj2 !=null){
		this.Sets.add(conj1.union(conj2,newName));
		amount++;
		message = "Se unieron correctamente";
	}

		return message;
	}


	public String difference (String setName1, String setName2, String newName){
		String message = "";
		IntegerSet conj1=buscar(setName1);
	IntegerSet conj2=buscar(setName2);
	if (conj1 !=null && conj2 !=null){
		this.Sets.add(conj1.difference(conj2,newName));
		amount++;
		message="Se añadio el conjunto de diferencia";
	}

		
		return message;
	}


	public void intersection(String setName1, String setName2, String newName){
			IntegerSet conj1=buscar(setName1);
	IntegerSet conj2=buscar(setName2);
	if (conj1 !=null && conj2 !=null){
		this.Sets.add(conj1.intersection(conj2,newName));
		amount++;
	}
	}

	public void symmetricDifference(String setName1, String setName2, String newName){
				IntegerSet conj1=buscar(setName1);
	IntegerSet conj2=buscar(setName2);
	if (conj1 !=null && conj2 !=null){
		this.Sets.add(conj1.symmetricDifference(conj2,newName));
		amount++;
	}
	}
	
	public String showInfoSet (String name){
		boolean found = false;
		String msg= "";
		for(int i = 0;i<amount && !found; i++){
			if(this.Sets.get(i).getName().equalsIgnoreCase(name)){
				msg=this.Sets.get(i).showContents();
				found = true;				
			}
		}
		return msg;		
	}
	public String showInfoSets(){
		String msg= "**************Conjuntos existentes*************"+"\n";
		for(int i = 0;i<amount; i++){
			msg += this.Sets.get(i).showContents()+"\n";
		}
		return msg;
	}	
}