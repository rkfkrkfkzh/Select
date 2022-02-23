package Service;

import java.util.ArrayList;

import vo.member;

public class MemberService implements Service {
	private Dao dao;

	public MemberService() {
		dao = new MemberDAO();
	}

	@Override
	public void addMember(member m) {
		// TODO Auto-generated method stub
		dao.insert(m);
	}

	@Override
	public member getMember(String id) {
		// TODO Auto-generated method stub
		return dao.selectMember(id);
	}

	@Override
	public void editMember(member m) {
		// TODO Auto-generated method stub
		dao.update(m);
	}

	@Override
	public void delMember(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public ArrayList getMembers(int type) {
		// TODO Auto-generated method stub
		return dao.selectAll(type);
	}

}
