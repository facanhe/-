package daoIMP;
import bean.Student;
import dao.StudentDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.DataBaseConnection;

public class StudentDAOIMP implements StudentDAO{
	// ��Ӳ���
	    public void insert(Student s){
	      String sql = "INSERT INTO student (id, name) values (?,?)";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //������ݿ�ľ������
	    try{
	        conn = new DataBaseConnection();
	        
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1,s.getID());
	        //pstmt.setString(1,s.getID());
	        pstmt.setString(2,s.getName());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){  }
	      }

	    public void update(Student s){
	    String sql = "UPDATE student SET name =? Where id = ? ";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //������ݿ�ľ������
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setString(1,s.getName());
	        pstmt.setLong(2,s.getID());
	  
	        pstmt.executeUpdate();
	        pstmt.close();
	        conn.close();
	        }
	     catch(Exception e){ }
	    

	    }



	public void delete(long iD){
		String sql="DELETE FROM　student where　id = ? ";
		 PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    try{
		    conn=new DataBaseConnection();
		    pstmt=conn.getConnection().prepareStatement(sql);
		    pstmt.setLong(1,iD);
		    pstmt.executeUpdate();
		    pstmt.close();
	        conn.close();
		    }
		     catch(Exception e){ }
	}//��ҵ1
	    
	public List findAll(){
		
		 PreparedStatement pstmt = null;
		    DataBaseConnection conn = null;
		    List<Student> list=null;
		    String sql="select*from student";
		    
		    try {
		    conn=new DataBaseConnection();
		    pstmt=conn.getConnection().prepareStatement(sql);
		    rs=pstmt.executeQuery();
		    list=new ArrayList<Student>();
		    while(rs.next())
			{
				Student stu=new Student();
				
				stu.setID(rs.getLong("id"));
				stu.setName(rs.getString("name"));
				list.add(stu);
			}
		    rs.close();
			pstmt.close();
			conn.close();
			}
		    catch(Exception e){ }
		    return list;
	}//��ҵ2



	public Student findByID(long iD){ 
	Student student = null;
	String sql = "SELECT id, name FROM student Where id = ? ";
	    PreparedStatement pstmt = null;
	    DataBaseConnection conn = null;
	    //������ݿ�ľ������
	    try{
	        conn = new DataBaseConnection();
	        pstmt = conn.getConnection().prepareStatement(sql);
	        pstmt.setLong(1, iD);
	        ResultSet rs = pstmt.executeQuery();
	  
	        
	        if(rs.next()){
	student = new Student();
	student.setID(rs.getLong(1));
	student.setName(rs.getString(2));}
	rs.close();
	pstmt.close();
	conn.close();
	
	        }
	     catch(Exception e){ }
	
	     return student;
	}



	}
