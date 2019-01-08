package com.oracle.team.domain;
import com.oracle.team.service.Status;

public class Employee {
	public int memberId;
	public int id;
	int age;
	String name;
	Double salary;
	public String job;
	public Status status;
	public Employee[] emp = new Employee[10];
	PC pc1 = new PC("dell","三星16寸");
	PC pc2 = new PC("dell","三星17寸");
	NoteBook book1 = new NoteBook("联想小新",6000.0);
	NoteBook book2 = new NoteBook("戴尔成就",5700.0);
	NoteBook book3 = new NoteBook("飞行堡垒",7000.0);
	Printer printer1 = new Printer("佳能2900","激光");
	public Employee(int id,String name,int age,double salary,String job) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.job = job;
	}
	//1 Architect 2 Designer 3 Programmer
	public Employee() {	
		Status free = Status.FREE;
		Status busy = Status.BUSY;
		Status vocation = Status.VOCATION;
		emp[0] = new Programmer(1,"person1",23,3000.0,free,book1.getDescription());
		emp[1] = new Architect(2,"person2",30,5000.0,2000,250,free,printer1.getDescription());
		emp[2] = new Designer(3,"person3",29,7300.0,2000,free,pc1.getDescription());
		emp[3] = new Programmer(4,"person4",40,5000.0,free,book2.getDescription());
		emp[4] = new Designer(5,"person5",35,9000.0,1500,free,pc2.getDescription());
		emp[5] = new Programmer(6,"person6",26,10000.0,free,book3.getDescription());
		emp[6] = new Designer(7,"person7",45,7500.0,2000,free,pc1.getDescription());
		emp[7] = new Programmer(8,"person8",22,7600.0,free,book1.getDescription());
		emp[8] = new Programmer(9,"person9",27,8000.0,vocation,book2.getDescription());
		emp[9] = new Architect(10,"person0",23,8000.0,5000,300,free,printer1.getDescription());
	}
	public String getEmployeeList() {
		return id+"\t"+name+"\t"+age+"\t"+salary+"\t"+job+"\t";	
	}
	public String getTeamList() {
		return memberId+"/"+id+"\t"+name+"\t"+age+"\t"+salary+"\t"+job+"\t";	
	}
	public String getList() {
		return null;
	}
}
class Programmer extends Employee{//程序员
	String equipment;
	static String job="程序员";
	Programmer(int id,String name,int age,double salary,Status status,String equipment){
		super (id,name,age,salary,job);
		this.status = status;
		this.equipment = equipment;
	}
	public String getList() {	
		return status+"\t"+"\t"+"\t"+equipment+"\n";
	}
}
class Designer extends Employee{//设计师
	double bonus;
	String equipment;
	static String job="设计师";
	Designer(int id,String name,int age,double salary,double bonus,Status status,String equipment){
		super(id,name,age,salary,job);
		this.bonus = bonus;
		this.status = status;
		this.equipment = equipment;	
	}
	public String getList() {	
		return status+"\t"+bonus+"\t"+"\t"+equipment+"\n";
	}
}
class Architect extends Employee{//架构师
	int stock;
	double bonus;
	String equipment;
	static String job="架构师";
	Architect(int id,String name,int age,double salary,double bonus,int stock,Status status,String equipment){
		super(id,name,age,salary,job);
		this.bonus = bonus;
		this.stock = stock;
		this.status = status;
		this.equipment = equipment;	
	}
	public String getList() {	
		return status+"\t"+bonus+"\t"+stock+"\t"+equipment+"\n";
	}
}
class PC {
	String model,display;
	PC(String model,String display){
		this.model = model;
		this.display = display;
	}
	String getDescription(){
		return display+"("+model+")";
	}
}
class NoteBook {
	String model;
	double price;
	NoteBook(String model,double price){
		this.model = model;
		this.price = price;
	}
	String getDescription(){
		return model+"("+price+")";
	}
}
class Printer {
	String type,name;
	Printer(String type,String name){
		this.type = type;
		this.name = name;
	}
	String getDescription(){
		return name+"("+type+")";
	}
}
interface Equipment{
	String getDescription();
}
