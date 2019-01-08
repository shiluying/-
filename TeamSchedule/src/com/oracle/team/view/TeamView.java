package com.oracle.team.view;
import java.util.Scanner;
import com.oracle.team.domain.*;
import com.oracle.team.service.*;

public class TeamView {
	static NameListService listSvc = new NameListService();
	static TeamService teamSvc = new TeamService();
	static Employee employee = new Employee();
	public static void main(String[] args) throws TeamException {
		enterMainMenu();
	}
	public static void enterMainMenu() throws TeamException {
		Scanner in = new Scanner(System.in);
 		int number=1;
 		while(number!=0) {
 			Employee[] employ = listSvc.getAllEmployees();
 	 		System.out.println("------------------------�����Ŷӵ������------------------------");
 	 		System.out.println("ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
 	 		for(int i=0;i<5;i++) {
 	 			System.out.println(employ[i].getEmployeeList()+employ[i].getList());
 	 		}
 	 		System.out.println("������������");
 	 		System.out.println("---------------------------------------------------------------");
 	 		System.out.print("1-�Ŷ��б�\t2-����Ŷӳ�Ա\t3-ɾ���Ŷӳ�Ա\t4-�˳�\t��ѡ��(1-4):");	
 	 		int num = in.nextInt();	
 			switch (num) {
 			case 1:
 				listAllEmployees();
 	 	 		break;
 	 	 	case 2:
 	 	 		addMember();
 	  			break;
 	  		case 3:
 	 	 		deleteMember();
 	 			break;
 	  		case 4:
 	  			number=0;
 	  			System.out.println("�����˳�ϵͳ��");
 	  			break;
 	  		default:
 	  			System.out.println("�������");
 	 		}
        }
	}
	public static void listAllEmployees() {//�Ա�����ʽ�г����г�Ա
		Employee[] employ = teamSvc.getTeam();
    	System.out.println("--------------------------�Ŷӳ�Ա�б�------------------------------");//��ӡ�ͻ��б�
    	System.out.println("TID/ID\t����\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");
    	for(int i=0;i<employ.length;i++) {//��һ��Ϊ
    		System.out.println(employ[i].getTeamList()+employ[i].getList());
    	}
    	System.out.println("-------------------------------------------------------------------");
	}
	public static void addMember() throws TeamException {//��ӳ�Ա����
		Scanner in = new Scanner(System.in);
    	System.out.println("----------��ӳ�Ա--------------");
    	System.out.print("��ѡ������Ա����ID:");
    	try {
    	String str_num = in.nextLine(); 
    	if (str_num.equals(""))
    		throw new TeamException(8);
    	int num = Integer.parseInt(str_num);
    	Employee add_emp = listSvc.getEmployee(num-1);
    	if (add_emp != null ) {
    	teamSvc.addMember(add_emp);
    	}else 
    		System.out.println("���ʧ��");
    	}catch(TeamException e) {
    		System.out.println(e.warnMess());
    	}
    	System.out.println("���س�������...");
    	String a = in.nextLine();
		if(a.equals("")) {
			enterMainMenu();
		}
    	}
	public static void deleteMember() throws TeamException {//ɾ����Ա����
		int do_num = -1;
		Scanner in = new Scanner(System.in);
    	System.out.println("----------ɾ����Ա--------------");
    	System.out.print("��ѡ���ɾ��Ա����TID:");
    	try{
    		String str_num = in.nextLine();
    		if (str_num.equals(""))
    			throw new TeamException(8);
    		int num = Integer.parseInt(str_num);
    		System.out.print("ȷ���Ƿ�ɾ��(Y/N):");
    		String b = in.nextLine();
    		if(b.equals("Y")) 
    			do_num = teamSvc.removeMember(num); 
    		if(do_num != -1) {
    			Employee delect_emp = listSvc.getEmployee(do_num-1);
    			delect_emp.status = Status.FREE;
    			System.out.println("ɾ���ɹ�");}
    		else
    			System.out.println("ɾ��ʧ��");
    	}catch(TeamException e) {
    		System.out.println(e.warnMess());
    	}
    	System.out.println("���س�������...");
    	String a = in.nextLine();
    	if(a.equals(""))
    			enterMainMenu();
	}
}