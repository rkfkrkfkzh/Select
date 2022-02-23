package vo;

public class employee extends member {
	private String job;
	public employee(){}
	public employee(String id, String name, String tel, String addr, int type, String job) {
		super(id, name, tel, addr, type);
		this.job = job;
	}
	
	
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", addr=" + addr + ", type=" + type + "job=" + job + "]";
	}
}
