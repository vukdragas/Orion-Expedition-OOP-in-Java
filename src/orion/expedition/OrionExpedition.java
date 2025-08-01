/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package orion.expedition;

import java.util.Scanner;

/**
 *
 * @author wolfd
 */
public class OrionExpedition {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //IMPORTANT:
       
        //all messages regarding usage of program (following the use case diagram) 
        //are written in this class, 
        //and also in shuttle.startTrip and orbiter.launch methods, when exectuing program all
        //of them can be seen
        
        System.out.println("Creating shuttle");
        Shuttle s = new Shuttle(100);
        
        System.out.println("Choosing Navigation Strategy");       
        s.chooseNav();
        
        System.out.println("Creating destination and adding to the navigation");        
        Destination moon = new Destination("Moon",50, 75, 2.0);
        s.addDesintaion(moon);
        
        System.out.println("Reading from file");        
        s.readPlanets("planets.txt");
        
        System.out.println("Starting space trip");       
        boolean l = s.launch();
    }
    
}
