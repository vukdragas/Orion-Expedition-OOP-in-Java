/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

import java.util.List;

/**
 * Standard navigation system that is used to travel to closest destination
 * @author wolfd
 */
public class Standard extends NavigationSystem{
    
    /**
     * Constructs a new navigation system of Standard strategy
     */
    public Standard(){
        super();
    }
    
    /**
     * Method that helps shuttle find next destination for space travel
     * In this cases chooses destination that is closest to the shuttle
     * 
     * @throws IllegalStateException if size of destinations array is 0
     * @return Closest destination to the current location
     */
    @Override
    public Destination goToNextDestination() {
        if(destinations.size()==0){
            throw new IllegalStateException("No destination in Navigation System");
        }
        Destination closest = null;
        int smallest = 0;
        for(Destination d : destinations){
            if (closest == null || d.getDistanceFromEarth()<smallest){
                closest = d;
                smallest = d.getDistanceFromEarth();
            }
        }
        return closest;
    }
    @Override
    String getNavigationName() {
        return "standard";
    }
}
