package reflection;
/**
 * 
 * @author xinyu
 *
 */
public class student {
	private String name;
	protected int age;
	char sex;
	private String phoneNum;
	public student() {
		
	}
	public student(String name) {
		this.name = name;
	}
	protected student(String name, String PhoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
	}
	student(char sex) {
		this.sex = sex;
	}
	private student(String name, String phoneNum, char sex, int age) {
		this.phoneNum = phoneNum;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	@Override
	public String toString() {
		return "Stdudent name = " + name + "  age:" + age + " set: "  + sex + "   phone:" + phoneNum;
	}
	
	private void show(String name) {
		this.name = name;
		System.out.println("show" + name);
	}
}
