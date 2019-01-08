package com.oracle.team.service;

public class TeamException extends Exception {
	String message;
	public TeamException(int i) {
		switch(i) {
		case 1:
			message = "成员已满，无法添加";
			break;
		case 2:
			message = "该员工不是开发人员，无法添加";
			break;
		case 3:
			message = "该员工已是团队成员";
			break;
		case 4:
			message = "该员工正在休假，无法添加";
			break;
		case 5:
			message = "团队中只能有一名架构师";
			break;
		case 6:
			message = "团队中只能有两名设计师";
			break;
		case 7:
			message = "团队中只能有三名程序员";
			break;
		case 8:
			message = "找不到指定员工";
			break;
		case 9:
			message = "输入错误";
			break;
		}
	}
	public String warnMess() {
		return message;
	}
}
