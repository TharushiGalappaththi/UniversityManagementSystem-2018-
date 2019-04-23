/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class DB_Post {
 String url = "jdbc:mysql://localhost:3306/uninsbm";
    String username = "root";
    String password = "";
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;  
    
    
    boolean addPoStudent(PostGradutae_Details sd) {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query5 = "INSERT INTO postgraduate_student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query5);
            // System.out.println("aaa");
            pst.setInt(1, sd.getRegId()); //add values to the sql query
            pst.setString(2, sd.getFirstName());
            pst.setString(3, sd.getLastName());
            pst.setString(4, sd.getNamewithInitial());
            pst.setString(5, sd.getNic());
            pst.setInt(6, sd.getAge());
            pst.setString(7, sd.getAddress());
            pst.setString(8, sd.getGender());
            pst.setString(9, sd.getEmail());
            pst.setInt(10, sd.getContactNo());
            pst.setString(11, sd.getBirthYear());
            pst.setString(12, sd.getBirthMonth());
            pst.setString(13, sd.getBIrthDate());
            pst.setString(14,sd.getDegree());
            pst.setString(15, sd.getGraduateInstitute());
            pst.setString(16, sd.getGetGraduateYear());
            pst.setString(17, sd.getRegYear());
            pst.setString(18, sd.getFaculty());
            
            
           
            System.out.println("correct add student1");

            pst.executeUpdate(); //execute the sql query and insert the values to the db table
            return true;

        } catch (Exception e) {
            System.out.print(e);
            return false;

        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("AB");
            }
        }

    }
   ArrayList<PostGraduate_CourseDetail> getstudent2(){   
        try{
            ArrayList<PostGraduate_CourseDetail> list1= new ArrayList<PostGraduate_CourseDetail>();
          
            
            con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="SELECT * FROM postgraduate_course";
            pst=(PreparedStatement)con.prepareStatement(query);
            
            rs=pst.executeQuery();
            
            while(rs.next()){
            PostGraduate_CourseDetail sb=new PostGraduate_CourseDetail();
                sb.setFaculty(rs.getString(1));
                sb.setRegId(rs.getInt(2));
                sb.setCourseId(rs.getString(3));
                sb.setNumOfYears(rs.getInt(4));
                sb.setMainSubject1(rs.getString(5));
                sb.setMainSubject2(rs.getString(6));
                sb.setSubject1(rs.getString(7));
                sb.setSubject2(rs.getString(8));
                sb.setSubject3(rs.getString(9));
                
            
            list1.add(sb);
            }
            return list1;
        }catch(SQLException e){
        
            System.out.println(e);
            return null;
        }
    } 
    
     void PostGraduateCourse(PostGraduate_CourseDetail ugd){
       try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="INSERT INTO postgraduate_course VALUES(?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setString(1, ugd.getFaculty());
            pst.setInt(2,ugd.getRegId () );
            pst.setString(3, ugd.getCourseId());
            pst.setInt(4, ugd.getNumOfYears());
            pst.setString(5,ugd.getMainSubject1());
            pst.setString(6,ugd.getMainSubject2());
            pst.setString(7, ugd.getSubject1());
            pst.setString(8,ugd.getSubject2());
            pst.setString(9,ugd.getSubject3());
            
            
        
            pst.executeUpdate();//execute the sql query and insert to values to the db table
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
    }
        
     
     int checkStudentId4(String regId,String courseid){
        try{
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="SELECT regId,courseid FROM postgraduate_course";
            pst=(PreparedStatement)con.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(regId.equals(rs.getString(1))&& courseid.equals(rs.getString(2))){
                    return 0;
                }
            }
            return 1;
            
        }catch(Exception e){
            System.out.println(e);
            return 2;
        }
        
        
    
    }
     
    void postGraduateResult(PostGraduate_Result em ){
         try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="INSERT INTO postgraduate_result VALUES(?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setInt(1, em.getRegId());
            pst.setString(2, em.getFaculty());
            pst.setString(3, em.getMainSubject1Rus());
            pst.setString(4,em.getMainSubject1Rus() );
            pst.setString(5, em.getSubject1Rus());
            pst.setString(6,em.getSubject2Rus());
            pst.setString(7, em.getSubject3Rus());
            
            
           
            
        
            pst.executeUpdate();//execute the sql query and insert to values to the db table
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
    }
    
    int checkRegId2(String regId){
       //System.out.println("tharu4");
       try{
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="SELECT RegId FROM postgraduate_result";
            pst=(PreparedStatement)con.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(regId.equals(rs.getString(1))){
                    return 0;
                }
            }
            return 1;
            
        }catch(Exception e){
            System.out.println(e);
            return 2;
        }
        
}
    public ResultSet find(String s){
        //System.out.println("tharu2");
        try{
            con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="SELECT * FROM postgraduate_result WHERE regId=?";
            pst=(PreparedStatement)con.prepareStatement(query);
            pst.setString(1, s);
           
            rs=pst.executeQuery();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return rs;
    }
    
}
     
    

  



