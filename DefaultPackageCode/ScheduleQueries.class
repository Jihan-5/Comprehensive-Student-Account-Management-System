
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
 public class ScheduleQueries {
    private static Connection connection;
    private static ArrayList<String> faculty = new ArrayList<String>();
    private static PreparedStatement addScheduleEntry;
    private static PreparedStatement getScheduleByStudent;
    private static PreparedStatement getScheduleByStudentCount;
    private static ResultSet resultSet;

    public static void addScheduleEntry(ScheduleEntry entry)
    {
        connection = DBConnection.getConnection();
        try
        {
            addScheduleEntry = connection.prepareStatement("insert into app.schedule (semester, studentid, coursecode, status, timestamp) values (?, ?, ?, ?, ?)");
            addScheduleEntry.setString(1, entry.getSemester());
            addScheduleEntry.setString(2, entry.getStudentID());
            addScheduleEntry.setString(3, entry.getCourseCode());
            addScheduleEntry.setString(4, entry.getStatus());
            addScheduleEntry.setTimestamp(5, entry.getTimestamp());
            addScheduleEntry.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    public static ArrayList<ScheduleEntry> getScheduleByStudent(String semester, String studentID)
    {
        ArrayList<ScheduleEntry> faculty = new ArrayList<ScheduleEntry>();
        connection = DBConnection.getConnection();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select semester, coursecode, studentid, status, timestamp from app.schedule where studentid = ? and semester = ?");
            getScheduleByStudent.setString(1, studentID);
            getScheduleByStudent.setString(2, semester);
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next())
            {
                String getSem = resultSet.getString(1);
                String getCoursecode = resultSet.getString(2);
                String getID = resultSet.getString(3);
                String getStatus = resultSet.getString(4);
                faculty.add(new ScheduleEntry(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));
            }

        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
            
        }
        return faculty;
    }

    public static int getScheduledStudentCount(String currentSemester, String courseCode)
    {
        int count = 0;
        connection = DBConnection.getConnection();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select studentid from app.schedule where semester = ? and courseCode = ?");
            getScheduleByStudent.setString(1, currentSemester);
            getScheduleByStudent.setString(2, courseCode);
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next())
            {
                count++;
            }
            
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
    
     public static ArrayList<ScheduleEntry> getWaitlistedStudentsByClass(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> retList = new ArrayList<ScheduleEntry>();
        try
        {
            getScheduleByStudent = connection.prepareStatement("select studentid, timestamp from app.schedule where semester = ? and courseCode = ? and status = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, courseCode);
            getScheduleByStudent.setString(3, "w");
            resultSet = getScheduleByStudent.executeQuery();
            
            while(resultSet.next())
            {
                retList.add(new ScheduleEntry(semester, courseCode, resultSet.getString(1), "w", resultSet.getTimestamp(2)));
            }
            
        }
        catch(SQLException sqlException)  //sqlexceptions
        {
            sqlException.printStackTrace();
        }
        return retList;
    }

    public static void dropStudentScheduleByCourse(String semester, String studentID, String courseCode)
    {
        connection = DBConnection.getConnection();
        try
        { //sql command to delete as we are dropping
            getScheduleByStudent = connection.prepareStatement("DELETE FROM APP.SCHEDULE WHERE SEMESTER = ? AND STUDENTID = ? AND COURSECODE = ?");
            
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, studentID);
            getScheduleByStudent.setString(3, courseCode);
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException) //checking for SQL connection exception
        {
            sqlException.printStackTrace();
        }
    }

    public static void dropScheduleByCourse(String semester, String courseCode)
            //sql command to drop and delete course
    {
        connection = DBConnection.getConnection();
        try
        {
            getScheduleByStudent = connection.prepareStatement("delete from app.schedule where semester = ? and coursecode = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, courseCode);
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

    public static void updateScheduleEntry(String semester, ScheduleEntry entry)
    {
        connection = DBConnection.getConnection();
        try
        {
            getScheduleByStudent = connection.prepareStatement("update app.schedule set status = 's' where semester = ? and studentid = ? and coursecode = ?");
            getScheduleByStudent.setString(1, semester);
            getScheduleByStudent.setString(2, entry.getStudentID());
            getScheduleByStudent.setString(3, entry.getCourseCode());
            getScheduleByStudent.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }

}
