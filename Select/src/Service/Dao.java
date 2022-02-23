package Service;

import java.util.ArrayList;

import vo.member;
import vo.employee;
import vo.Professor;
import vo.Student;

public interface Dao {

	void con();

	void discon();

	void insert(member m);

	member selectMember(String id);

	void update(member m);

	void delete(String id);

	ArrayList selectAll(int type);

}
