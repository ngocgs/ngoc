
package end;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import end.Add;

public class StudentModel {
    private static ArrayList<Student> listStudent;
	
        Connection cnn = null;
        String url = "jdbc:mysql://localhost:3306/SV";    //datebase name
        String username = "root";
        String password = "";
        
	public ArrayList<Student> getList() throws ClassNotFoundException {
		ArrayList<Student> listStudent = new ArrayList<>();
		try {
			//Connection cnn = DAO.getConnection();
                        
                        Class.forName("com.mysql.jdbc.Driver");
                        cnn = DriverManager.getConnection(url, username, password);
                        
                        if(cnn!= null){
                            System.out.println("connec ok");
                        }
                        
			PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student");
			ResultSet rs = preStt.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setID(rs.getInt("id"));
				student.setName(rs.getString("Name"));
				student.setEmail(rs.getString("Email"));
				student.setPhone(rs.getString("Phone"));
				student.setAddress(rs.getString("Address"));
                                student.setBirthday(rs.getString("Birthday"));
			
				listStudent.add(student);  
			}
                        cnn.close();
		} catch (SQLException ex) {
			System.err.println("ERROR" + ex.getMessage());
		}
		return listStudent;
	}
        
        public void insert(Student student) {
		try {
                    
                        Class.forName("com.mysql.jdbc.Driver");
                        cnn = DriverManager.getConnection(url, username, password);
                        if(cnn!= null){
                            System.out.println("connec ok");
                        }
                        
			PreparedStatement preStt = cnn.prepareStatement(
					"INSERT INTO `student`(`ID`, `Name`, `Email`, `Phone`, `Address`, `Birthday`) VALUES (?,?,?,?,?,?)" );
			preStt.setInt(1, student.getID());
                        preStt.setString(2, student.getName());
			preStt.setString(3, student.getEmail());
			preStt.setString(4, student.getPhone());
			preStt.setString(5, student.getAddress());
                        preStt.setString(6, student.getBirthday());
			
			preStt.execute();
		} catch (SQLException e) {
			System.err.println("ERROR" + e.getMessage());
		} catch (ClassNotFoundException ex) {
                        Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
                    }
	}

/*	public void update(Student student) {
		try {
			//Connection conn = DAO.getConnection();
                        Class.forName("com.mysql.jdbc.Driver");
                        cnn = DriverManager.getConnection(url, username, password);
                        
			PreparedStatement preStt = cnn.prepareStatement(
					"UPDATE student SET name=?, email=?, roll_number=?, class_name=?, status=? where id=?");
			preStt.setString(1, student.getName());
			preStt.setString(2, student.getEmail());
			preStt.setString(3, student.getPhone());
			preStt.setString(4, student.getAddress());
                        preStt.setString(5, student.getBirthday());
			//preStt.setInt(5, (int) student.getStatus());
			preStt.setInt(6, (int) student.getID());
			preStt.executeUpdate();
			System.out.println("Update successful ^^!");
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}

	public void delete(Integer id) {
		try {
			//Connection conn = DAO.getConnection();
                        Class.forName("com.mysql.jdbc.Driver");
                        cnn = DriverManager.getConnection(url, username, password);
                        
			PreparedStatement preStt = cnn.prepareStatement("DELETE FROM student where id=?");
			preStt.setInt(1, id);
			if (preStt.executeUpdate() > 0) {
				System.out.println("Deleted ^^!");
			} else {
				System.out.println("No data!!!");
			}
		} catch (Exception e) {
			System.err.println("ERROR" + e.getMessage());
		}
	}

	public Student getById(int id) {
		try {
			//Connection cnn = DAO.getConnection();
                        Class.forName("com.mysql.jdbc.Driver");
                        cnn = DriverManager.getConnection(url, username, password);
                        
			PreparedStatement preStt = cnn.prepareStatement("SELECT * FROM student WHERE id=?");
			preStt.setInt(1, id);
			ResultSet rs = preStt.executeQuery();
			if (rs.next()) {
				Student stu = new Student();
				stu.setID(rs.getInt("id"));
				stu.setName(rs.getString("name"));
				stu.setEmail(rs.getString("email"));
				stu.setPhone(rs.getString("phone"));
				stu.setAddress(rs.getString("address"));
                                stu.setBirthday(rs.getString("birthday"));
			//	stu.setStatus(rs.getInt("status"));
				return stu;
			} else {
				System.out.println("No data!!!");
			}
		} catch (SQLException e) {
			System.err.println("ERROR" + e.getMessage());
		} catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentModel.class.getName()).log(Level.SEVERE, null, ex);
        }
		return null;
	}

	public static boolean saveFile(ArrayList<Student> listStudent, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(listStudent);
			oos.close();
			fos.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Student> readFile(String path) {
		ArrayList<Student> listStudent = new ArrayList<>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			listStudent = (ArrayList<Student>) data;
			ois.close();
			fis.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return listStudent;
	}*/
}
