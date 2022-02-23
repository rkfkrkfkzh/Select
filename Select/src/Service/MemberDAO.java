package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Professor;
import vo.Student;
import vo.employee;
import vo.member;

public class MemberDAO implements Dao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public void con() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버 로드
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@db202110262237_high?TNS_ADMIN=/Users/imhyojin/Wallet_DB202110262237", "ADMIN",
					"Dkfdktek36270113");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void discon() { // close메서드 insert,update을 사용하면 호출
		try {
			pstmt.close();
			conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(member m) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "insert into school values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getTel());
			pstmt.setString(4, m.getAddr());
			pstmt.setInt(5, m.getType());
			if (m instanceof Professor) {
				pstmt.setString(6, ((Professor) m).getDept());

			} else if (m instanceof Student) {
				pstmt.setString(6, ((Student) m).getschool());

			} else if (m instanceof employee) {
				pstmt.setString(6, ((employee) m).getJob());
			}
			// pstmt.setString(4, m.getAdd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public member selectMember(String id) {
		// TODO Auto-generated method stub
		con();
		member m = null;
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
		String sql = "select * from school where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // Query실행
			if (rs.next()) {
				if (rs.getInt("type") == 1) {
					m = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
				} else if (rs.getInt("type") == 2) {
					m = new Professor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
				} else if (rs.getInt("type") == 3) {
					m = new employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6));
				}
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;

	}

	@Override
	public void update(member m) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "update school set tel=?, addr=?, etc=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getTel());
			pstmt.setString(2, m.getAddr());
			if (m.getType() == 1) {
				pstmt.setString(3, ((Student) m).getschool());
			} else if (m.getType() == 2) {
				pstmt.setString(3, ((Professor) m).getDept());
			} else if (m.getType() == 3) {
				pstmt.setString(3, ((employee) m).getJob());
			}

			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		con();
		// PreparedStatement 변수 값을 편하게 쓰기 위해서(?,?,?,?,?)
		String sql = "delete school where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		discon();
	}

	@Override
	public ArrayList selectAll(int type) {
		// TODO Auto-generated method stub
		con();
		ArrayList<member> m = new ArrayList<member>();
		// MemberVO table에 있는 id 컬럼과 매서드파라메터 값이 동일한 행 검색
		String sql = "select * from school where type=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, type);
			rs = pstmt.executeQuery(); // Query실행
			if (type == 1) {
				while (rs.next()) {
					m.add(new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6)));
				}
			} else if (type == 2) {
				while (rs.next()) {
					m.add(new Professor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getInt(5), rs.getString(6)));
				}
			} else if (type == 3) {
				while (rs.next()) {
					m.add(new employee(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5),
							rs.getString(6)));
				}
			}
			rs.close();
		} catch (Exception e) {
			System.out.println(e);
		}

		discon();
		return m;
	}

}
