/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package formativeassessment.pkg3.gui;

import formativeassessment.pkg3.gui.data.local.MySQLStudentBookingDatabase;
import formativeassessment.pkg3.gui.data.local.StudentBookingDatabase;
import formativeassessment.pkg3.gui.data.repository.StudentBookingRepositoryImpl;
import formativeassessment.pkg3.gui.domain.repository.StudentBookingRepository;
import formativeassessment.pkg3.gui.presentation.StudentBookingUI;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cyabulela Shabalala
 */
public class FormativeAssessment3GUI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EventQueue.invokeLater(() -> {
            try {
                StudentBookingDatabase studentBookingDatabase = new MySQLStudentBookingDatabase();
                StudentBookingRepository studentBookingRepository = new StudentBookingRepositoryImpl(studentBookingDatabase);
                StudentBookingUI studentBookingUI = new StudentBookingUI(studentBookingRepository);
                studentBookingUI.setVisible(true);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(FormativeAssessment3GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), null , JOptionPane.ERROR_MESSAGE);
            }
        });
        
    }
    
}
