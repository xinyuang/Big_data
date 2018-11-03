package sort;

public class Student implements Comparable<Student>{
	private int stuID;
	private String stuName;
	private int age;
	public int getStuID() {
		return stuID;
	}
	

	
	@Override
	public String toString() {
		return "Student [stuID=" + stuID + ", stuName=" + stuName + ", age=" + age + "]";
	}

	public void setStuID(int stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		if (this.age >= o.getAge()) {
			return 1;
		} else {
			return -1;
		}
	}
	
}
