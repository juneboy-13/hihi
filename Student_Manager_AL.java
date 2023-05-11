package Student_Package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Student_Manager_AL {
	static Scanner input = new Scanner(System.in);
	public void InputStudentList(ArrayList<student> list) {
		input.nextLine();
		String nhap = "a";
		while(nhap.compareTo("")!=0) {
			System.out.print("Enter student information: ");
			nhap = input.nextLine();
			if(nhap.compareTo("")!=0) {
				String xau[] = nhap.split("\\s");
				double Result = Double.parseDouble(xau[xau.length-1]);
				String FullName = "";
				if (xau.length>1)
				{
					for(int i=1;i<xau.length-1;i++) {
						FullName = FullName.concat(" ");
						FullName = FullName.concat(xau[i]);
					
				}
				}
				list.add(new student(xau[0],FullName,Result));
			}
		}
	}
	public void OutputStudentList(ArrayList<student> list) {
		System.out.println("\tSTUDENT LIST");
		System.out.printf("|%-20s|%-20s|%-20s|%s","Student ID","Full name","Result","Rank");
		for(int i=0;i<list.size();i++) {
			list.get(i).output1std();
		}
	}
	public void Update_1_Student(ArrayList<student> list) {
		System.out.println("1.Update student by code\n2.Update student by first and last name");
		System.out.println("Please enter options: ");
		int u = input.nextInt();
		input.nextLine();
		switch(u) {
			case 1: {
				System.out.println("Please enter the student code you need to update: ");
				String UpdateCode = input.nextLine();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getID().compareTo(UpdateCode)==0) {
						System.out.println("Please enter the option you want to update: 1.Student ID / 2.FullName / 3.Result");
						int a = input.nextInt();
						input.nextLine();
						if(a==1) {
							System.out.println("please enter new student code: ");
							list.get(i).setID(input.nextLine());
						}
						else if(a==2) {
							System.out.println("please enter new student full name: ");
							list.get(i).setFullname(input.nextLine());
						}
						else if(a==3) {
							System.out.println("please enter new student's result: ");
							list.get(i).setResult(input.nextDouble());
						}

					}
						
				}
				break;
			}
			case 2: {
				System.out.println("Please enter the student first and last name you need to update: ");
				String UpdateFullName = input.nextLine();
				for(int i=0;i<list.size();i++) {
					if(list.get(i).getFullname().compareTo(UpdateFullName)==0) {
						System.out.println("Please enter the option you want to update: 1.Student ID / 2.FullName / 3.Result");
						int b = input.nextInt();
						input.nextLine();
						if(b==1) {
							System.out.println("please enter new student code: ");
							list.get(i).setID(input.nextLine());
						}
						else if(b==2) {
							System.out.println("please enter new student full name: ");
							list.get(i).setFullname(input.nextLine());
						}
						else if(b==3) {
							System.out.println("please enter new student's result: ");
							list.get(i).setResult(input.nextDouble());
						}
					}	
				}
				break;
			}
		}
	}
	public void ThongKe_Student(ArrayList<student> list) {
		int dau=0;
		int rot=0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getRank().compareTo("Pass")==0) dau++;
			else rot++;
		}
		System.out.println("So sinh vien dau la: "+dau);
		System.out.println("So sinh vien rot la: "+rot);
	}
	public int SearchbyID(ArrayList<student> list,String id) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getID().compareTo(id)==0) 
				return i;
		}
		return -1;
	}
	public int SearchbyName(ArrayList<student> list,String fname) {
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getFullname().compareTo(fname)==0) 
				return i;
		}
		return -1;
	}
	public void SearchStudent(ArrayList<student> list) {
		input.nextLine();
		System.out.println("Search student by : id/name");
		String a = input.nextLine();
		if(a.compareTo("id")==0) {
			System.out.println("Nhap id student: ");
			String id = input.nextLine();
			if(SearchbyID(list,id) == -1) System.out.println("Khong tim thay!");
			else {
				System.out.printf("Thong tin sinh vien can tim: ");
				System.out.printf("\n|%-20s|%-20s|%-20s|%s","Student ID","Full name","Result","Rank");
				list.get(SearchbyID(list,id)).output1std();
			}
		}
		if(a.compareTo("name")==0) {
			System.out.println("Nhap ho ten student: ");
			String fname = input.nextLine();
			if(SearchbyName(list,fname) == -1) System.out.println("Khong tim thay!");
			else {
				System.out.printf("Thong tin sinh vien can tim: ");
				System.out.printf("\n|%-20s|%-20s|%-20s|%s","Student ID","Full name","Result","Rank");
				list.get(SearchbyName(list,fname)).output1std();
			}
		}

	}
	public void SortStudentbyresult(ArrayList<student> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				if(list.get(i).getResult()<list.get(j).getResult()) {
					student tg = list.get(i);
					list.set(i,list.get(j));
					list.set(j, tg);
				}
			}
		}
	}
	public void SortStudentbyName(ArrayList<student> list) {
		for(int i=0;i<list.size()-1;i++) {
			for(int j=i+1;j<list.size();j++) {
				if (list.get(i).getName().compareTo(list.get(j).getName())>0) {
					student a = list.get(i);
					list.set(i, list.get(j));
					list.set(j, a);
				}
			}
		}
	}
//	public void save(ArrayList<student> list) {
//		FileOutputStream fos = null;
//		ObjectOutputStream oos = null;
//		try {
//			fos = new FileOutputStream("text.DAT");
//			oos = new ObjectOutputStream(fos);	
//			oos.writeObject(list);
//			oos.close();
//			fos.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//	public ArrayList<student> read(){
//		ArrayList<student> s = null;
//		FileInputStream fis = null;
//		ObjectInputStream ois = null;
//		try {
//			fis = new FileInputStream("text.DAT");
//			ois = new ObjectInputStream(fis);
//			Object o = ois.readObject();
//			s = extracted(o);
//			ois.close();
//            fis.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//		return s;
//		
//		
//		
//		
//	}
//	private ArrayList<student> extracted(Object o) {
//		return (ArrayList<student>) o;
//	}
	public void save(ArrayList<student> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream("text.DAT");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<student> read(){
		ArrayList<student> s = null;
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("text.DAT");
			ois = new ObjectInputStream(fis);
			Object o = ois.readObject();
			s = extracted(o);
			ois.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}
	private ArrayList<student> extracted(Object o) {
		return (ArrayList<student>) o;
	}
	public void Delete_1_Std(ArrayList<student> list) {
		input.nextLine();
		System.out.println("Nhap ma sinh vien muon xoa");
		String maXoa = input.nextLine();
			if(SearchbyID(list,maXoa)==-1) System.out.println("Khong tim thay!");
			else
				list.remove(SearchbyID(list,maXoa));
	}
}
