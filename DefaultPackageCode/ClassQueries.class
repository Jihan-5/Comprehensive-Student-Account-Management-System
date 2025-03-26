/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author jihanmankani
 */
public class ClassQueries {
    
    private static Connection connection;
    
    private static PreparedStatement addCourse;
    private static PreparedStatement getCourseList;
    private static ResultSet resultSet;
    private static PreparedStatement deleteClassStatement = null;
    
    public static void addClass(ClassEntry course)
    {
        connection = DBConnection.getConnection();
        try
        { //sql command for inserting
            addCourse = connection.prepareStatement("insert into app.class (Semester, CourseCode, Seats) values (?, ?, ?)");
            addCourse.setString(1, course.getSemester());
            addCourse.setString(2, course.getCourseCode());
            addCourse.setInt(3, course.getSeats());

            addCourse.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getAllCourseCodes(String semester)
    {
        connection = DBConnection.getConnection();
        ArrayList<String> courseCodes = new ArrayList<String>();
        try
        {
            getCourseList = connection.prepareStatement("select coursecode from app.class where semester = ?");
            getCourseList.setString(1, semester);
            resultSet = getCourseList.executeQuery();
            
            while(resultSet.next())
            {
                courseCodes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return courseCodes;
    }
    
    public static int getClassSeats(String semester, String courseCode)
    {
        connection = DBConnection.getConnection();
        int count = 0;
        try
        {
            getCourseList = connection.prepareStatement("select seats from app.class where semester = ? and coursecode = ?");
            getCourseList.setString(1, semester);
            getCourseList.setString(2, courseCode);
            resultSet = getCourseList.executeQuery();
            
            while(resultSet.next())
                count = resultSet.getInt(1);
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return count;
    }
    public static void dropClass(String semester, String courseCode) {
        connection = DBConnection.getConnection();
        try {
            String deleteClassQuery = "DELETE FROM app.class WHERE semester = ? AND coursecode = ?";
            deleteClassStatement = connection.prepareStatement(deleteClassQuery);
            deleteClassStatement.setString(1, semester);
            deleteClassStatement.setString(2, courseCode);

            deleteClassStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}