package com.oracle.team.service;

public class TeamException extends Exception {
	String message;
	public TeamException(int i) {
		switch(i) {
		case 1:
			message = "��Ա�������޷����";
			break;
		case 2:
			message = "��Ա�����ǿ�����Ա���޷����";
			break;
		case 3:
			message = "��Ա�������Ŷӳ�Ա";
			break;
		case 4:
			message = "��Ա�������ݼ٣��޷����";
			break;
		case 5:
			message = "�Ŷ���ֻ����һ���ܹ�ʦ";
			break;
		case 6:
			message = "�Ŷ���ֻ�����������ʦ";
			break;
		case 7:
			message = "�Ŷ���ֻ������������Ա";
			break;
		case 8:
			message = "�Ҳ���ָ��Ա��";
			break;
		case 9:
			message = "�������";
			break;
		}
	}
	public String warnMess() {
		return message;
	}
}
