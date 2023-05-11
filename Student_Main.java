package Student_Package;

import java.util.ArrayList;
import java.util.LinkedList;

public class Student_Main {
	static Student_Manager_AL  Manager = new Student_Manager_AL();
	static ArrayList<student> list = new ArrayList<student>();
	public static void main(String[] args) {
		int menu =1;
		while(menu!=0) {
			System.out.println("\n---FUNCTION LIST---");
			System.out.println("1/Enter student list");
			System.out.println("2/Print out the list of students");
			System.out.println("3/Find information about 1 student");
			System.out.println("4/Add 1 student to the list");
			System.out.println("5/Remove 1 student from the list");
			System.out.println("6/Update 1 student information");
			System.out.println("7/Sort student result");
			System.out.println("8/Thongke student list");
			System.out.println("9/save");
			System.out.println("10/read");
			System.out.println("11/Sort student name");
			System.out.println("0/Exit");
			System.out.print("Please enter options: ");
			menu = Student_Manager_AL.input.nextInt();	
			switch(menu) {
				case 1: { Manager.InputStudentList(list); break;	}
				case 2: { Manager.OutputStudentList(list); break;	}
				case 3: { Manager.SearchStudent(list); break;	}
//				case 4: { Manager.Add_1_Student(Student_Manager.list); break;	}
				case 5: { Manager.Delete_1_Std(list); break;	}
				case 6: { Manager.Update_1_Student(list); break;	}
				case 7: { Manager.SortStudentbyresult(list); break;		}
				case 8: { Manager.ThongKe_Student(list); break;		}
				case 9: { Manager.save(list); break;	}
				case 10: {list=Manager.read(); break;	}
				case 11: { Manager.SortStudentbyName(list); break;		}
			}
		}
	}
}
