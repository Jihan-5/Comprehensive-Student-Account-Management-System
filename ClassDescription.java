/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jihanmankani
 */
public class ClassDescription {
    private String CourseCode;
    private String Description;
    private int Seats;
    
    public ClassDescription(String courseCode, String description, int seats){
        this.CourseCode= courseCode;
        this.Description= description;
        this.Seats= seats;
        
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public String getDescription() {
        return Description;
    }

    public int getSeats() {
        return Seats;
    }
    
    
}
