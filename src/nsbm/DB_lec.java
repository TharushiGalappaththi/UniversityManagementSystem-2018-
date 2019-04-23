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

/**
 *
 * @author Asus
 */
public class DB_lec {

    
     
    String url="jdbc:mysql://localhost:3306/uninsbm";
        String username="root";
        String password="";
        Connection con=null;
        PreparedStatement pst=null;
        ResultSet rs=null;
   boolean Lecturedetail(Lecture_Details ld) {
       try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query = "INSERT INTO add_lecture VALUES (?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setString(1,ld.getLectureId()); //add values to the sql query
            pst.setString(2,ld.getName());
            pst.setInt(3,ld.getAge());
            pst.setString(4,ld.getNic());
            pst.setInt(5,ld.getContactNum());
            pst.setString(6,ld.getEmail());
            pst.setString(7,ld.getGender());
            pst.setString(8,ld.getFaculty());
            pst.setString(9,ld.getQualification());
            
        
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
    
       
boolean Instructor(InstructorDetail ins) {
       try{
           con=(Connection)DriverManager.getConnection(url,username,password);//get the connection
            String query = "INSERT INTO instructor_detail VALUES (?,?,?,?,?,?,?,?,?)";
            pst=(PreparedStatement)con.prepareStatement(query);
        
            pst.setString(1,ins.getInstructorId()); //add values to the sql query
            pst.setString(2,ins.getName());
            pst.setInt(3,ins.getAge());
            pst.setString(4,ins.getNic());
            pst.setInt(5,ins.getContactNum());
            pst.setString(6,ins.getEmail());
            pst.setString(7,ins.getGender());
            pst.setString(8,ins.getFaculty());
            pst.setString(9,ins.getQualification());
            
        
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
    }
       
