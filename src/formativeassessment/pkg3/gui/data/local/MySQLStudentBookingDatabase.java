/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formativeassessment.pkg3.gui.data.local;

import formativeassessment.pkg3.gui.domain.model.StudentBooking;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cyabulela Shabalala
 */
public class MySQLStudentBookingDatabase implements StudentBookingDatabase {
    
    private final String URL = "jdbc:mysql://localhost:3307/fa3_assessment";
    private final String USER_NAME = "root";
    private final String PASSWORD = "viresh@Ass3";
    private final Connection connection;

    public MySQLStudentBookingDatabase() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    @Override
    public boolean insertStudentBooking(StudentBooking booking) throws SQLException, Exception {
        String insertQuery = "INSERT INTO student_booking (FName, LName, Email, Phone, Subject) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        
        statement.setString(1, booking.fName());
        statement.setString(2, booking.lName());
        statement.setString(3, booking.email());
        statement.setString(4, booking.phone());
        statement.setString(5, booking.subject());
        
        int rowInsected = statement.executeUpdate();
        statement.close();
        return rowInsected > 0;
    }    

    @Override
    public List<StudentBooking> getStudentBookings() throws SQLException, Exception {
        ArrayList<StudentBooking> bookings = new ArrayList<>();
        String selectQuery = "SELECT * FROM student_booking";
        PreparedStatement statement = connection.prepareStatement(selectQuery);
        
        ResultSet result = statement.executeQuery();
        
        while(result.next()){
            String name = result.getString("FName");
            String surname = result.getString("LName");
            String email = result.getString("Email");
            String phone = result.getString("Phone");
            String subject = result.getString("Subject");
            
            StudentBooking booking = new StudentBooking(name, surname, email, phone, subject);
            bookings.add(booking);
        }
        
        statement.close();
        result.close();
        
        return bookings;
    }

    @Override
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
}
