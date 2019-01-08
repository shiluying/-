package com.oracle.team.service;
import com.oracle.team.domain.*;
import com.oracle.team.service.TeamException;

public class NameListService {//管理公司员工
	int total = 10;
	Employee employees = new Employee();
	Employee employee[] = new Employee[total];
	public Employee[] getAllEmployees() {
		for(int i=0;i<10;i++){
			employee[i] = employees.emp[i];
		}
		return employee;
	}
	public Employee getEmployee(int index) throws TeamException{
		try{
			if(index<0||index>total-1) {
				throw new TeamException(8);
			}
			return employee[index];
		}catch(TeamException e) {
			System.out.println(e.warnMess());
			}
		return null;
	}
}
