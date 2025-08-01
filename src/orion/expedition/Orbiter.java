/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author wolfd
 * 
 * Represents Orbiter which controls the navigation and movement of the space shuttle between destinations.
 * Manages the current and next destinations, handles fuel consumption,
 */
public class Orbiter {
    private Destination nextDestination;
    private Destination currentDestination;
    private Shuttle shuttle;
    private Random random = new Random();
    
    /**
     * Constructs an Orbiter.
     * 
     * @param s the Shuttle instance this Orbiter will control (cannot be null)
     * @throws NullPointerException if the shuttle parameter is null
     * @throws IllegalStateException if you want to add shuttle which has different orbiter
     */
    public Orbiter(Shuttle s){
        if (s == null){
           throw new NullPointerException("Shuttle cannot be null"); 
        }      
        this.nextDestination = null;
        this.shuttle = s;
        this.currentDestination = new Destination("Earth", 0, 100, 10.0);
    }
    
  
    
    public Destination getCurrent(){
        return this.currentDestination;
    }
    
    public Destination getNext(){
        return this.nextDestination;
    }
    
    /**
     * Initiates a trip to the next destination, Starts the shuttle engine,
     * Continuously consumes fuel while moving, Handles low fuel situations,
     * Updates travel progress, Stops when destination is reached or fuel is low
     * 
     * @return true if trip was successful, false otherwise
     * @throws IllegalStateException if no next destination is available
     */
    public boolean startTrip(){
        System.out.println("Finding closest destination");
        nextDestination = shuttle.getNav().goToNextDestination();

        if (this.nextDestination == null) {
            throw new IllegalStateException("No next destination");
        }
        
        System.out.println("Start trip to the destination " + this.nextDestination.toString());
        nextDestination.setTravelProgress(currentDestination.getDistanceFromEarth());
        Engine e = this.shuttle.getEngine();
        e.startEngine();
        System.out.println("Starting the engine");        
        
        while(e.getEngineStatus()){
            this.shuttle.getTank().useFuel(nextDestination.getFuelConsumtion());
            int update = this.nextDestination.getDistanceFromEarth() - this.currentDestination.getDistanceFromEarth();
            this.nextDestination.updateProgress(update);
            
            if(this.shuttle.getTank().isLow()){
                System.out.println("Fuel level low");
                boolean r = random.nextBoolean();
                if (r) {//can it continue until the fuel is 0??
                    System.out.println("Refueling");
                    shuttle.getTank().refuel();
                } else {
                    System.out.println("Stoping engine");
                    e.stopEngine();
                    return false;
                }
            }
            
            if(this.nextDestination.isReached()){
                System.out.println("Reached " + this.nextDestination.getName());
                this.nextDestination.observeDestination(10);
                this.currentDestination = this.nextDestination;
                System.out.println("Removing destination from navigation system");
                this.shuttle.removeDestination(this.nextDestination);
                this.nextDestination = null;
                shuttle.getTank().refuel();//refuels reached??
                e.stopEngine();
            }
        }
        return true;
    }
}
