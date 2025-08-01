/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orion.expedition;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author wolfd
 * Represents the main spacecraft class that puts together all shuttle systems including
 * navigation, engine, fuel tank, and orbiter.
 */
public class Shuttle {
    private NavigationSystem navigation;
    private Engine engine;
    private Tank tank;
    private Orbiter orbiter;
    
    /**
     * Constructs a new Shuttle with the specified initial fuel capacity.
     * Initializes all shuttle systems (navigation, engine, tank, orbiter).
     * 
     * @param d the initial maximum fuel capacity (must be positive)
     * @throws IllegalArgumentException if fuel capacity is not positive
     */
    public Shuttle(int d){
        this.engine = new Engine();
        this.tank = new Tank(d);
        this.orbiter = new Orbiter(this);
    }
    
    /**
     * Adds a new destination to the shuttle's navigation system.
     * 
     * @param d the Destination object to add
     * @throws NullPointerException if the destination parameter is null
     */
    public void addDesintaion(Destination d){
        this.navigation.add(d);
    }
    
    /**
     * Reads planet destinations from a file and adds them to navigation system.
     * File format should contain planet names and distances.
     * 
     * @param fileName the path to the planets data file
     * @throws FileNotFoundException if the specified file cannot be found
     * @throws IllegalArgumentException if file data is improperly formatted
     */
    public void readPlanets(String fileName) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)))) {
            while (scanner.hasNext()) {
                String planetName = scanner.next();
                int n = scanner.nextInt();
                int s = scanner.nextInt();
                double f = scanner.nextDouble();
                Destination d = new Destination(planetName, n, s, f);
                addDesintaion(d);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error reading planets file: " + e.getMessage());
        }
    }
    
    
    
    /**
     * Removes a destination from the navigation system.
     * 
     * @param d the Destination object to remove
     * @return true if the destination was found and removed
     */
    public void removeDestination(Destination d){
        this.navigation.remove(d);
    }
    
    public Tank getTank(){
        return this.tank;
    }
    
    public Orbiter getOrbiter(){
        return this.orbiter;
    }
    
    public NavigationSystem getNav(){
        return this.navigation;
    }
    
    public Engine getEngine(){
        return this.engine;
    }
    
    public void setNav(NavigationSystem d){
        this.navigation = d;
    }
    
    /**
     * Asks user what type of navigation strategy would he like to use.
     * And sets navigation system to users preference.
     * 
     * @throws IllegalStateException is users choice is incorrect
     */
    public void chooseNav(){
        System.out.println("Enter number of what navigation strategy would you like");
        System.out.println("1. Standard");
        System.out.println("2. Efficient");
        System.out.println("3. Explore");
        
        Scanner scanner = new Scanner(System.in); 
        int d = scanner.nextInt();     
        
        switch(d){
            case 1: this.navigation = new Standard();
                    System.out.println("You chose standard navigation strategy");
                    break;
            case 2: this.navigation = new Efficient();
                    System.out.println("You chose efficient navigation strategy");                    
                    break;
            case 3: this.navigation = new Explore();
                    System.out.println("You chose explore navigation strategy");                   
                    break;
            default: throw new IllegalStateException("You need to chose between these options");          
        }
    }
    
    /**
     * Launches the shuttle, executing trips to all destinations
     * until all have been reached or mission cannot continue.
     * 
     * @return true if trip was successful, false otherwise.
     */
    public boolean launch(){
        if(navigation == null) throw new IllegalStateException("Navigation System needs to be set up before traveling");
        boolean l = true;
        while(l && this.navigation.size() > 0){
            l = this.orbiter.startTrip();
        }
        if(this.navigation.size() == 0){
            System.out.println("Space Trip Successful");
            return true;
        }
        else{
            System.out.println("Space Trip Unsuccessful");
            return false;
        }
    }
}
