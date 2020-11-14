package ui;
import java.util.Scanner;
import model.*;

public class Main{

	private  Scanner sc;
	public MathApp map;

	public  Main() {
		sc= new Scanner(System.in);
		map = new MathApp();
	}	

	 public static void main(String[] args) {
		Main ppal= new Main();

		int option=0;	
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);		
		}while (option!=0);
	}

	public int showMenu() {
		int option=0;

		System.out.println(
				"¡Bienvenido a MathApp\n"+
				"Selecciona una opcion\n" +
				"(1) Agregar un nuevo conjunto\n" +
				"(2) Eliminar un conjunto existente\n"+
				"(3) Agregar un elemento a un conjunto\n"+
				"(4) Eliminar un elemento de un conjunto\n"+
				"(5) Aplicar la union entre 2 conjuntos\n"+
				"(6) Aplicar la interseccion entre 2 conjuntos\n" +
				"(7) Aplicar la diferencia entre 2 conjuntos\n" +
				"(8) Aplicar la diferencia simetrica entre 2 conjuntos\n" +
				"(9) Mostrar los elementos de un conjunto\n" +
				"(10) Mostrar todos los conjuntos\n" +
				"(0) salir"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	public void executeOperation(int operation) {
		String message="";
			switch(operation) {
			case 1:
				readAddSet();
				break;
			case 2:
				readRemoveSet();
				break;
			case 3:
				readAddElementToSet();
				break;
			case 4:
				readRemoveElementFromSet();
				break;
			case 5:
				readUnion();
				break;
			case 6:
				readIntersection();
				break;
			case 7:
				readDifference();
				break;
			case 8:
				readSymmetricDifference();
				break;
			case 9:
				System.out.println(readShowInfoSet());
				break;
			case 10:
				System.out.println(map.showInfoSets());				
				break;
			case 0:
				break;
			default:
				System.out.println("Opcion invalida, repita nuevamente");
		}
	}



	
	public void readAddSet(){
		
		System.out.println("Ingrese el nombre del conjunto");
		String nameSet = sc.nextLine();
		System.out.println(map.addSet(nameSet));
	}
	public void readRemoveSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String nameSet = sc.nextLine();
		System.out.println(map.removeSet(nameSet));
	}
	public void readAddElementToSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String setName = sc.nextLine();
		System.out.println("Ingrese el elemento a agregar");
		int element = sc.nextInt();
		sc.nextLine();
		System.out.println(map.addElementToSet(setName, element));
	}
	public void readRemoveElementFromSet(){
		System.out.println("Ingrese el nombre del conjunto");
		String setName = sc.nextLine();
		System.out.println("Ingrese el elemento a eliminar");
		int element = sc.nextInt();
		sc.nextLine();
		System.out.println(map.removeElementFromSet(setName, element));
	}
	public void readUnion(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String setName1 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String setName2 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto union");
		String newName = sc.nextLine();
		System.out.println(map.union (setName1, setName2, newName));
	}
	public void readDifference(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String setName1 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String setName2 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto diferencia");
		String newName = sc.nextLine();
		map.difference (setName1, setName2, newName);
	}
	public void readIntersection(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String setName1 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String setName2 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto interseccion");
		String newName = sc.nextLine();
		map.intersection (setName1, setName2, newName);
	}
	public void readSymmetricDifference(){
		System.out.println("Ingrese el nombre del conjunto 1");
		String setName1 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto 2");
		String setName2 = sc.nextLine();
		System.out.println("Ingrese el nombre del conjunto diferencia simetrica");
		String newName = sc.nextLine();
		map.symmetricDifference(setName1, setName2, newName);
	}
	public String readShowInfoSet(){
		String message ="";
		System.out.println("Ingrese el nombre del conjunto");
		String name = sc.nextLine();
		message = map.showInfoSet(name);
		return message;
	}	
	
}