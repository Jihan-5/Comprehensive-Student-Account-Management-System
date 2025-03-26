
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jihanmankani
 */

public class MultiTableQueries {
    
    private static Connection connection;
    private static ArrayList<String> ClassDescription = new ArrayList<String>();
    private static PreparedStatement getAllClassDescription;
    private static PreparedStatement getScheduledStudentsByClass;
    private static PreparedStatement getWaitlistedStudentsByClass;
    private static ResultSet resultSet;
    
    
    public static ArrayList<ClassDescription> getAllClassDescriptions(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> rdesc = new ArrayList<ClassDescription>();
        try
        {
            getAllClassDescription = connection.prepareStatement("select app.class.courseCode, description, seats from app.course, app.class where semester = ? and app.class.courseCode = app.course.courseCode order by app.class.courseCode");
            getAllClassDescription.setString(1, semester);
            resultSet = getAllClassDescription.executeQuery();
            
            while(resultSet.next())
            {
                rdesc.add(new ClassDescription(resultSet.getString(1),resultSet.getString(2),resultSet.getInt(3)));
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return rdesc;
    
    
    }
    public static ArrayList<StudentEntry> getScheduledStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> retList = new ArrayList<StudentEntry>();
        try
        {
            getScheduledStudentsByClass = connection.prepareStatement("select app.student.studentid, firstname, lastname from app.student, app.schedule where semester = ? and courseCode = ? and status = ? and app.schedule.studentid = app.student.studentid order by app.schedule.timestamp");
            getScheduledStudentsByClass.setString(1, semester);
            getScheduledStudentsByClass.setString(2, courseCode);
            getScheduledStudentsByClass.setString(3, "s");
            resultSet = getScheduledStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                retList.add(new StudentEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return retList;
    }
    
    public static ArrayList<StudentEntry> getWaitlistedStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> retList = new ArrayList<StudentEntry>();
        try
        {
            getWaitlistedStudentsByClass = connection.prepareStatement("select app.student.studentid, firstname, lastname from app.student, app.schedule where semester = ? and courseCode = ? and status = ? and app.schedule.studentid = app.student.studentid order by app.schedule.timestamp");
            getWaitlistedStudentsByClass.setString(1, semester);
            getWaitlistedStudentsByClass.setString(2, courseCode);
            getWaitlistedStudentsByClass.setString(3, "w");
            resultSet = getWaitlistedStudentsByClass.executeQuery();
            
            while(resultSet.next())
            {
                retList.add(new StudentEntry(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
                
            }
            
        }
        catch(SQLException sqlException)  //sqlexceptions
        {
            sqlException.printStackTrace();
        }
        return retList;
    }    
}
