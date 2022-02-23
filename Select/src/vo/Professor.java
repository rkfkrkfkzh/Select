package vo;

public class Professor extends member {
	private String dept;

	public Professor() {
	}

	public Professor(String id, String name, String tel, String addr, int type, String dept) {
		super(id, name, tel, addr, type);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", name=" + name + ", tel=" + tel + ", addr=" + addr + ", type=" + type + "dept="
				+ dept + "]";
	}

}
