/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package formativeassessment.pkg3.gui.domain.repository;

import formativeassessment.pkg3.gui.domain.model.StudentBooking;
import formativeassessment.pkg3.gui.util.Resource;
import java.util.List;

/**
 *
 * @author Cyabulela Shabalala
 */
public interface StudentBookingRepository {
    
    public Resource<StudentBooking> insertStudentBooking(StudentBooking booking);
    
    public Resource<List<StudentBooking>> getAllSudentBooking();
    
    public void closeConnection();
    
}
