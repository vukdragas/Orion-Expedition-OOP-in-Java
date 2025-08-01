/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author wolfd
 * Represents navigation system with list of destinations.
 */
public abstract class NavigationSystem {
    protected List<Destination> destinations;
    
    /**
     * Constructs a new NavigationSystem with an empty list of destinations.
     */
    protected NavigationSystem(){
        this.destinations = new ArrayList<>();
    }
    
    /**
     * Gets the number of destinations currently in the navigation system.
     * 
     * @return the current count of destinations
     */
    public int size(){
        return this.destinations.size();
    }
    
    /**
     * Adds a new destination to the navigation system.
     * 
     * @param d the Destination object to add
     * @throws IllegalArgumentException if destination is already in system.
     * @return true if the destination was successfully added
     */
    public boolean add(Destination d){
        if(destinations.contains(d)){
            throw new IllegalArgumentException("Destination is already in navigation system");
        }
        destinations.add(d);
        return true;
    }
    
    /**
     * Removes a destination from the navigation system.
     * 
     * @param d the Destination object to remove
     * @return true if the destination was found and removed
     */
    public boolean remove(Destination d){
        return destinations.remove(d);
    }
    
    public List<Destination> getDestinations(){
        return this.destinations;
    }
    /**
     * Abstract method that returns next Destination for space travel
     * @return next Destination shuttle travels to
     */
    abstract Destination goToNextDestination();
    /**
     * Abstract method that returns name of navigation system
     *
     * @return name of navigation system
     */
    abstract String getNavigationName();
}
