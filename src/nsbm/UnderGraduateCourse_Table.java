/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Asus
 */
public class UnderGraduateCourse_Table extends AbstractTableModel{
    private static final String[] columnName={"faculty","regId","courseId","numofyrears"};
    private static ArrayList<UnderGraduate_CourseDetail> list;

    UnderGraduateCourse_Table(ArrayList<UnderGraduate_CourseDetail> stlist){
        list=stlist;
    }
    
    @Override
    public int getRowCount() {
       return list.size(); }

    @Override
    public int getColumnCount() {
       return columnName.length;  }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex){
            case 0:
                return list.get(rowIndex).getFaculty();
            case 1:
                return list.get(rowIndex).getRegId();
            case 2:
                return list.get(rowIndex).getCourseId();
            case 3:
                return list.get(rowIndex).getNumOfYears();   
            default:
                return "error";
         }
    
    
}
}
