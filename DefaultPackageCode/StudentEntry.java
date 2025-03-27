/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jihanmankani
 */
public class StudentEntry {
    public String StudentID;
    public String FirstName;
    public String LastName;

    public StudentEntry(String StudentID, String FirstName, String LastName) {
        this.StudentID = StudentID;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }
    public String getLastFirstName()
    {
        return this.LastName + ", " + this.FirstName;
    }
    public String fullID()
    {
        return getLastFirstName() + " " + this.StudentID;
    }
}
