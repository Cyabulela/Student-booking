/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formativeassessment.pkg3.gui.data.repository;

import java.sql.SQLException;
import formativeassessment.pkg3.gui.data.local.StudentBookingDatabase;
import formativeassessment.pkg3.gui.domain.model.StudentBooking;
import formativeassessment.pkg3.gui.domain.repository.StudentBookingRepository;
import formativeassessment.pkg3.gui.util.Resource;
import java.util.List;

/**
 *
 * @author Cyabulela Shabalala
 */
public class StudentBookingRepositoryImpl implements StudentBookingRepository {
    
    private final StudentBookingDatabase studentBookingDatabase;

    public StudentBookingRepositoryImpl(StudentBookingDatabase studentBookingDatabase) {
        this.studentBookingDatabase = studentBookingDatabase;
    }

    @Override
    public Resource<StudentBooking> insertStudentBooking(StudentBooking booking) {
        Resource<StudentBooking> result;
        try{
            boolean isInserted = studentBookingDatabase.insertStudentBooking(booking);
            if(isInserted){
                result = Resource.success(booking);
            }
            else{
                result = Resource.failure("Failed to insect");
            }
        } catch(SQLException error) {
            System.err.append(error.getLocalizedMessage());
            result = Resource.failure("Failed to connect\n" + error.getMessage());
        } catch(Exception error) {
            System.err.append(error.getLocalizedMessage());
            result = Resource.failure(error.getMessage());
        }
        
        return result;
    }

    @Override
    public Resource<List<StudentBooking>> getAllSudentBooking() {
        Resource<List<StudentBooking>> bookings;
        try{
            bookings = Resource.success(studentBookingDatabase.getStudentBookings());
        } catch(SQLException error) {
            System.err.append(error.getLocalizedMessage());
            bookings = Resource.failure("Failed to connect\n" + error.getMessage());
        } catch(Exception error) {
            System.err.append(error.getLocalizedMessage());
            bookings = Resource.failure(error.getMessage());
        }
        
        return bookings;
    }

    @Override
    public void closeConnection() {
        try {
            studentBookingDatabase.closeConnection();
        }
        catch(SQLException error) {
            System.out.append("Failed to close, " + error.getLocalizedMessage());
        }
    } 
}
