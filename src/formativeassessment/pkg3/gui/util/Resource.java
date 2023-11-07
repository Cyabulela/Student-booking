/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formativeassessment.pkg3.gui.util;

/**
 *
 * @author Cyabulela Shabalala
 * @param <T>
 */
public class Resource<T> {
    
    private final T success;
    private final String failure;

    public Resource(T success, String failure) {
        this.success = success;
        this.failure = failure;
    }
    
    public static class Success<T>{
        
        private final T result;
        
        private Success(T result){
            this.result = result;
        }

        public T getResult() {
            return result;
        }
    }
    
    public static class Failure {
        
        private final String reason;
        
        private Failure(String reason) {
            this.reason = reason;
        }

        public String getReason() {
            return reason;
        }
    }
    
    public boolean isSuccess() {
        return success != null;
    }
    
    public boolean isFailure() {
        return failure != null;
    }

    public Success<T> getSuccess() {
        if(!isSuccess()) throw new IllegalStateException("Result is not a success");
        return new Success<>(success);
    }

    public Failure getFailure() {
        if(!isFailure()) throw new IllegalStateException("Result is a success");
        return new Failure(failure);
    }
    
    public static <T> Resource<T> success(T result) {
        return new Resource<>(result , null);
    }
    
    public static <T> Resource<T> failure(String reason) {
        return new Resource<>(null , reason);
    }
}