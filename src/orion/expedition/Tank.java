/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

/**
 *
 * @author wolfd
 * 
 * Represents shuttle's fuel system that manages the fuel system of the space shuttle, tracking current fuel levels,
 * maximum capacity.
 */
public class Tank {
    private double currentFuel;
    private double maxFuel;
    
    /**
     * Constructs a new Tank with the specified maximum fuel capacity.
     * 
     * @param m the maximum fuel capacity (must be greater than 0)
     * @throws IllegalArgumentException if the maximum capacity is 0 or negative
     */
    public Tank(double m){
        if (m <= 0){
            throw new IllegalArgumentException("Max capacity cannot be less then or equal to 0");
        }
        this.currentFuel = m;
        this.maxFuel = m;
    }
    
    /**
     * Refuels the tank to its maximum capacity.
     */
    public void refuel(){
        this.currentFuel = this.maxFuel;
    }
    
    /**
     * Checks if the current fuel level is low .
     * 
     * @return true if fuel level is low, false otherwise.
     */
    public boolean isLow(){
        if(this.currentFuel <= this.maxFuel/6){
            return true;
        }
        
        return false;
    }
    
    public double checkFuel(){
        return this.currentFuel;
    }
    
    /**
     * Consumes fuel by reducing the current level by parameter f.
     * The fuel level will never go below 0. Automatically checks for low fuel
     * condition after consumption.
     * @param f amount we change fuel by.
     * @throws IllegalArgumentExcaption if parameter is less then 0
     */
    public void useFuel(double f) {
        if(f<0) throw new IllegalArgumentException("Fuel change cannot be less then 0");
        currentFuel = Math.max(0, (int)(currentFuel - f)); //changed from 10 percent
    }
}
