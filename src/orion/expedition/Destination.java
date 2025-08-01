/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

/**
 *
 * @author wolfd
 * Represents a celestial destination for the space shuttle to land.
 * 
 */
public class Destination {
    private String name;
    private int distanceFromEarth;
    private int travelProgress;
    private int scientificValue;
    private double observationCompletion;
    private double fuelConsumption;
    
    
    /**
     * Constructs a new Destination with the given name and distance from Earth.
     * @param n the name of the destination 
     * @param d the distance from Earth in arbitrary units 
     * @param s the scientific value of given destination
     * @param f the fuel consumption required to get to this destination
     * @throws IllegalArgumentException if name is null or distance is not positive
     */
    
    public Destination(String n, int d, int s, double f){
        if(n == null || d < 0){
            throw new IllegalArgumentException("Name or distance cannot be null or less then 0");
        }
        this.name = n;
        this.distanceFromEarth = d;
        this.travelProgress = 0;
        this.scientificValue = s;
        this.observationCompletion = 0.0;
        this.fuelConsumption = f;
    }
    
    public int getDistanceFromEarth(){
        return this.distanceFromEarth;
    }
    
    /**
     * Updates observation percentage.
     * @param o the observation percentage
     * @throws IllegalArgumentException if o is less then 0
     */
    
    public void observeDestination(double o){
        if(o<0) throw new IllegalArgumentException("Observation parameter cannot be less then 0");
        this.observationCompletion = Math.min(100, this.observationCompletion + o);
    }
    
    public double getFuelConsumtion(){
        return this.fuelConsumption;
    }
    
    public String getName(){
        return this.name;
    }
    
    public double getObservationCompletion(){
        return this.observationCompletion;
    }
    
    public int getTravelProgress(){
        return this.travelProgress;
    } 
    
    public int getScientificValue(){
        return this.scientificValue;
    } 
    
    public void setTravelProgress(int d){
        this.travelProgress = d;
    }
    
    /**
     * Updates the travel progress by 5% from current shuttle destination.
     * 
     * @throws IllegalStateException if the current progress is negative.
     */
    public void updateProgress(int c){
        if (travelProgress < 0) {
            throw new IllegalStateException("Progress cannot be negative");
        }
        this.travelProgress += c * 0.05;
    }
    
    /**
     * Checks whether this destination has been reached by the shuttle.
     * 
     * @return true if the progress equals distance from Earth, false otherwise.
     */
    public boolean isReached(){
        return this.travelProgress >= this.distanceFromEarth;
    }
    
    @Override
    public String toString(){
        return this.name;
    }
    
    
    
}
