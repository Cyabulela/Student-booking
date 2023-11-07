/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package formativeassessment.pkg3.gui.data.local;

import java.sql.SQLException;
import formativeassessment.pkg3.gui.domain.model.StudentBooking;
import java.util.List;

/**
 *
 * @author Cyabulela Shabalala
 */
public interface StudentBookingDatabase {
    
    public boolean insertStudentBooking(StudentBooking booking) throws SQLException, Exception;
    
    public List<StudentBooking> getStudentBookings() throws SQLException, Exception;
    
    public void closeConnection() throws SQLException;
}
