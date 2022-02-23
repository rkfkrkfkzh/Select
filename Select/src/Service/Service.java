package Service;

import java.util.ArrayList;

import vo.member;

public interface Service {
	void addMember(member m);

	member getMember(String id);

	void editMember(member m);

	void delMember(String id);

	ArrayList getMembers(int type);
}
