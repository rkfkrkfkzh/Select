package vo;

public class Student extends member {
	private String school;
	public Student(){}
	public Student(String id, String name, String tel, String addr, int type, String school) {
		super(id, name, tel, addr, type);
		this.school = school;
	}
	
	public String getschool() {
		return school;
	}
	public void setschool(String school) {
		this.school = school;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", addr=" + addr + ", type=" + type + "school=" + school + "]";
	}

	
}
