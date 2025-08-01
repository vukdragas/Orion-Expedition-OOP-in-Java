/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

/**
 *
 * @author wolfd
 * Represents the main engine system of a space shuttle.
 */
public class Engine {
    private boolean isRunning;
    
    /**
     * Constructs a new Engine instance.
     */
    public Engine(){
        this.isRunning = false;
    }
    
    /**
     * Gets the current running status of the engine.
     * 
     * @return true if the engine is running, false if it is not.
     */
    public boolean getEngineStatus(){
        return this.isRunning;
    }
    
    /**
     * Starts the engine, changing its isRunning state to true.
     */
    public void startEngine(){
        this.isRunning = true;
    }
    
    /**
     * Stops the engine, changing its isRunning state to false.
     */
    public void stopEngine(){
        this.isRunning = false;
    }
}
