/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

import java.util.List;

/**
 * Efficient Navigation System takes shuttle to the destinations to which it is
 * most reliable to come to
 * @author wolfd
 */
public class Efficient extends NavigationSystem{
    /**
     * Constructs new Navigation System of type Efficient
     */
    public Efficient(){
        super();
    }
    
    /**
     * Method that helps shuttle find next destination for space travel
     * In this cases chooses destination which is closest and to which it takes
     * least amount of fuel to come to
     * 
     * @throws IllegalStateException if size of destinations array is 0
     * @return Destination to which space travel is most reliable to
     */
    Destination goToNextDestination() {
        if(destinations.size()==0){
            throw new IllegalStateException("No destination in Navigation System");
        }
        Destination closest = null;
        double smallest = 0.0;
        for(Destination d : destinations){
            if (closest == null || (d.getFuelConsumtion()*d.getDistanceFromEarth())<smallest){
                closest = d;
                smallest = d.getFuelConsumtion()*d.getDistanceFromEarth();
            }
        }
        return closest;
    }
    @Override
    String getNavigationName() {
        return "efficient";
    }

    
}
