/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

import java.util.List;

/**
 *
 * Explore navigation type which is used to travel to most important Destinations
 * by scientific value
 * @author wolfd
 */
public class Explore extends NavigationSystem{    
    /**
     * Constructs new Explore navigation system
     */
    public Explore(){
        super();
    }
        
    /**
     * Method that helps shuttle find next destination for space travel
     * In this cases chooses destination that is least most important to discover
     * 
     * @throws IllegalStateException if size of destinations array is 0
     * @return Most important destination to travel to
     */
    @Override
    Destination goToNextDestination() {
        if(destinations.size()==0){
            throw new IllegalStateException("No destination in Navigation System");
        }
        Destination closest = null;
        int biggest = 0;
        for(Destination d : destinations){
            if (closest == null || d.getScientificValue()>biggest){
                closest = d;
                biggest = d.getScientificValue();
            }
        }
        return closest;
    }
    @Override
    String getNavigationName() {
        return "explore";
    }
}
