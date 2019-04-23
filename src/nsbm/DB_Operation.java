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
public class DB_Operation {
    String url="jdbc:mysql://localhost:3306/uninsbm";
        String username="root";
        String password="";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
    boolean underGraduateStudent(UnderGraduate_Details ugd){
       System.out.println("tharu8");
       try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query = "INSERT INTO undergraduate_student VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
             pst.setInt(1,ugd.getRegId()); //add values to the sql query
            pst.setString(2,ugd.getFirstName());
            pst.setString(3,ugd.getLastName());
            pst.setString(4,ugd.getNamewithInitial());
            pst.setString(5,ugd.getNic());
            pst.setString(6,ugd.getBirthYear());
            pst.setString(7,ugd.getBirthMonth());
            pst.setString(8,ugd.getBIrthDate());
            pst.setInt(9,ugd.getAge());
            pst.setString(10,ugd.getAddress());
            pst.setString(11,ugd.getGender());
            pst.setString(12,ugd.getEmail());
            pst.setInt(13,ugd.getContactNo());
            pst.setString(14,ugd.getAlSubject1());
            pst.setString(15,ugd.getSubject_1());
            pst.setString(16,ugd.getAlSubject2());
            pst.setString(17,ugd.getSubject_2());
            pst.setString(18,ugd.getAlSubject3());
            pst.setString(19,ugd.getSubject_3());
            pst.setString(20,ugd.getZScore());
            pst.setString(21,ugd.getRegYear());
            pst.setString(22,ugd.getDegree());
            pst.setString(23,ugd.getFaculty());
            
        
            pst.executeUpdate();//execute the sql query and insert to values to the db table
           return true;
           
       }catch(SQLException e){
           System.out.println(e);
           return false;
       }
       finally{
            try{
                if(pst != null){
                        pst.close();
                }
                if(con !=null){
                con.close();
                }
            }catch(Exception e){
                System.out.println("AB");
            }
        }
        
    }
    void underGraduateCourse(UnderGraduate_CourseDetail ugd){
       System.out.println("tharu7");
       try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="INSERT INTO undergraduate_course VALUES(?,?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setString(1, ugd.getFaculty());
            pst.setInt(2,ugd.getRegId() );
            pst.setString(3, ugd.getCourseId());
            pst.setInt(4, ugd.getNumOfYears());
            pst.setString(5,ugd.getMainSubject1());
            pst.setString(6,ugd.getMainSubject2());
            pst.setString(7, ugd.getSubject1());
            pst.setString(8,ugd.getSubject2());
            pst.setString(9,ugd.getSubject3());
            pst.setString(10,ugd.getSubject4());
            
        
            pst.executeUpdate();//execute the sql query and insert to values to the db table
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
    }
    
    ArrayList<UnderGraduate_CourseDetail> getstudent(){   
        System.out.println("tharu6");
        try{
            ArrayList<UnderGraduate_CourseDetail> list= new ArrayList<UnderGraduate_CourseDetail>();
          
            
            con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="SELECT * FROM undergraduate_course";
            pst=(PreparedStatement)con.prepareStatement(query);
            
            rs=pst.executeQuery();
            
            while(rs.next()){
            UnderGraduate_CourseDetail sb=new UnderGraduate_CourseDetail();
                sb.setFaculty(rs.getString(1));
                sb.setRegId(rs.getInt(2));
                sb.setCourseId(rs.getString(3));
                sb.setNumOfYears(rs.getInt(4));
                sb.setMainSubject1(rs.getString(5));
                sb.setMainSubject2(rs.getString(6));
                sb.setSubject1(rs.getString(7));
                sb.setSubject2(rs.getString(8));
                sb.setSubject3(rs.getString(9));
                sb.setSubject4(rs.getString(10));
            
            list.add(sb);
            }
            return list;
        }catch(SQLException e){
        
            System.out.println(e);
            return null;
        }
    } 
    
    void underGraduateResult(UnderGraduate_Result em ){
         System.out.println("tharu1");
         try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="INSERT INTO undergraduate_result VALUES(?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setInt(1, em.getRegId());
            pst.setString(2,em.getMainSubject1Rus() );
            pst.setString(3, em.getMainSubject1Rus());
            pst.setString(4,em.getSubject1Rus());
            pst.setString(5, em.getSubject2Rus());
            pst.setString(6, em.getSubject3Rus());
            pst.setString(7, em.getSubject4Rus());
            pst.setString(8, em.getFaculty());
            
        
            pst.executeUpdate();//execute the sql query and insert to values to the db table
           
           
       }catch(SQLException e){
           System.out.println(e);
       }
    }
    
    public ResultSet find(String s){
        System.out.println("tharu2");
        try{
            con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query="SELECT * FROM undergraduate_result WHERE regId=?";
            pst=(PreparedStatement)con.prepareStatement(query);
            pst.setString(1, s);
           
            rs=pst.executeQuery();
            
        }catch(SQLException e){
            System.out.println(e);
        }
        return rs;
    }
    
    
    int checkRegId(String regId){
        System.out.println("tharu3");
        try{
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="SELECT RegId FROM undergraduate_student";
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
    
    int checkRegId2(String regId){
       //System.out.println("tharu4");
       try{
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="SELECT RegId FROM undergraduate_result";
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
    
    int checkRegId3(String regId,String CourseId){
        System.out.println("tharu5");
        try{
            con=(Connection)DriverManager.getConnection(url,username,password);
            String query="SELECT RegId,CourseId FROM undergraduate_course";
            pst=(PreparedStatement)con.prepareStatement(query);
            rs=pst.executeQuery();
            
            while(rs.next()){
                if(regId.equals(rs.getString(1))&& CourseId.equals(rs.getString(2))){
                    return 0;
                }
            }
            return 1;
            
        }catch(Exception e){
            System.out.println(e);
            return 2;
        }
        
}
}