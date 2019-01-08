package com.oracle.team.service;
import com.oracle.team.domain.Employee;

public class TeamService {//�����Ŷӳ�Ա��ʵ�ֳ�Ա����Ӻ�ɾ��
	int counter = 0;
	int i=0,j=0,k=0;
	final int MAX_MEMBER=6;
	Employee teams[] = new Employee[MAX_MEMBER];
	int total=0;
	public Employee[] getTeam() {
		Employee team[] = new Employee[total];
		for(int i=0;i<total;i++) {
			team[i] = teams[i];
		}
		return team;//���ص�ǰ�Ŷӵ����ж���
	}
	//1 Architect 2 Designer 3 Programmer
	public boolean addMember(Employee employee) throws TeamException{	
		boolean boolean_add = false;
		try{
		if(total>=MAX_MEMBER)
			throw new TeamException(1);
		else if(employee.status == Status.VOCATION)
			throw new TeamException(4);
		else if(employee.status == Status.BUSY)
			throw new TeamException(3);
		if (employee.job=="����Ա") 
			k++;
		else if (employee.job=="�ܹ�ʦ")
			i++;
		else if (employee.job=="���ʦ")
			j++;
		if(i>1) {
			i--;
			throw new TeamException(5);}
		else if(j>2) { 
			j--;
			throw new TeamException(6);}
		else if(k>3) {
			k--;
			throw new TeamException(7);}
		counter++;
		employee.memberId = counter;
		employee.status = Status.BUSY;
		teams[total] = employee;
		total++;
    	System.out.println("��ӳɹ�");
		}catch(TeamException e) {
			System.out.println(e.warnMess());
			}
		return boolean_add;
	}
	public int removeMember(int number)throws TeamException{
		int num= 0;
		int num_emp= -1;
		boolean bool= true;
		try{
			if (number>counter||number<1||total<=0)
				throw new TeamException(8);
			for(;num<total;num++)
				if(teams[num].memberId == number) {
					num_emp = teams[num].id;
					bool= false;
					break;}
			if(bool)
				throw new TeamException(9);
		if (teams[num].job=="����Ա") 
			k--;
		else if (teams[num].job=="�ܹ�ʦ")
			i--;
		else if (teams[num].job=="���ʦ")
			j--;
		for(;num<total;num++) {
			if(num==total-1) {
				teams[num]=null;
				break;
				}
			teams[num]=teams[num+1];
		}
		total--;
		}catch(TeamException e) {
			System.out.println(e.warnMess());
			}
		return num_emp;
	}
}
