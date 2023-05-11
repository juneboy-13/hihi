package Student_Package;

import java.io.Serializable;

public class student implements Serializable{
	private String ID;
	private String fullname;
	private double result;
	private String rank;
	private String name;
	public student() {
		this.ID = "";
		this.fullname = "";
		this.result = 0;
		this.rank = "";
		this.name = "";
	}
	public student(String Id,String fname,double result) {
		this.ID = Id;
		this.fullname = fname;
		this.result = result;
		if(result>=5) this.rank = "Pass";
		else this.rank = "Fail";
		this.name = fname.substring(fname.lastIndexOf(" ")+1,fname.length());
		//this.name = fname;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public double getResult() {
		return result;
		
	}
	public void setResult(double result) {
		this.result = result;
		if(this.result>=5) this.rank = "Pass";
		else this.rank = "Fail";
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getName() {

		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public void input1std() {
//		Student_Manager a = new Student_Manager();
//		System.out.println("Please enter student code: ");
//		this.ID = a.input.nextLine();
//		System.out.println("Please enter student's first and last name: ");
//		this.fullname = a.input.nextLine();
//		System.out.println("Please enter student's result score: ");
//		this.result = a.input.nextDouble();
//		if(this.result>=5) this.rank = "Pass";
//		else this.rank = "Fail";
//		this.name = this.fullname.substring(fullname.indexOf(" ")+1,fullname.length());
//	}
	public void output1std() {
		System.out.printf("\n|%-20s|%-20s|%-20f|%s",this.ID,this.fullname,this.result,this.rank);
	}
}
