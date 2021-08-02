package kh.java.contoller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.StringTokenizer;
import kh.java.view.StudentView;
import kh.java.vo.Student;

public class StudentController {
	public ArrayList<Student> students;
	public StudentView view;

	public StudentController() {
		super();
		students = new ArrayList<Student>();
		view = new StudentView();
	}

	public void main() {
		while (true) {
			switch (view.showMainMenu()) {
			case 1:
				insertStudent();
				break;
			case 2:
				printAllStudents();
				break;
			case 3:
				printOneStudent();
				break;
			case 4:
				updateStudent();
				break;
			case 5:
				deleteStudent();
				break;
			case 0:
				System.out.println("");
				return;
			default:
				break;
			}
		}
	}

	public void insertStudent() {
		StringTokenizer token = view.insertStudnet();
		Student s = new Student(token.nextToken(), Integer.parseInt(token.nextToken()), token.nextToken());
		students.add(s);
	}

	public void printAllStudents() {
		view.printStudent(students);
	}

	public void printOneStudent() {
		view.printOneStudent(students ,searchStudnet(view.searchName()));
	}

	public void updateStudent() {
		int i = searchStudnet(view.updateStudent());
		if(i==-1) {
			view.fail();
		}else {
			StringTokenizer token =  view.add();
			Student s = new Student(token.nextToken(), Integer.parseInt(token.nextToken()), token.nextToken());
			students.add(s);
			students.remove(students.get(i));
			view.success();
		}
	}

	public void deleteStudent() {
		int i = searchStudnet(view.updateStudent());
		if(i==-1) {
			view.fail();
		}else {
			students.remove(students.get(i));
			view.success();
		}

	}

	public int searchStudnet(String name) {
		for (int i=0;i<students.size();i++) {
			if (students.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;

	}

}
