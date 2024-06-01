/*
Title: Java console app
Name: Karanvir Kooner
Date: 2024-05-31
Purpose: To create a program that calculate the distance
in which a projectile is thrown vertically and horizontally
*/

//importing scanner library
import java.util.Scanner;

public class Assignment1 {
    public static void main(String[] args) {

        // Setting up scanner
        Scanner input = new Scanner(System.in);
        // Making constant for gravity
        double GRAVITY = -9.81;
        // Intialzing variable
        double angle, velocity, seconds, horizontalDistance, verticalDistance;

        // Asking user for the initial angle
        do {
            System.out.println("What is the initial angle of the projectile in degrees?: ");
            angle = input.nextDouble();
            if (angle <= 0) {
                System.out.println("Please enter a positive value for the angle.");
            }
        } while (angle <= 0);

        // Asking user for the initial velocity
        do {
            System.out.println("What is the initial velocity of the projectile in m/s?: ");
            velocity = input.nextDouble();
            if (velocity <= 0) {
                System.out.println("Please enter a positive value for the velocity.");
            }
        } while (velocity <= 0);

        // Asking user for the time
        do {
            System.out.println("How many seconds have passed?: ");
            seconds = input.nextDouble();
            if (seconds <= 0) {
                System.out.println("Please enter a positive value for the time.");
            }
        } while (seconds <= 0);

        // Calculating horizontal distance
        horizontalDistance = (velocity * Math.cos(Math.toRadians(angle))) * seconds;
        // Calculating vertical distance
        verticalDistance = (velocity * Math.sin(Math.toRadians(angle))) * seconds + 0.5 * GRAVITY * Math.pow(seconds, 2);

        // Print results
        System.out.println("---Horizontal Distance--- \n" + horizontalDistance);
        System.out.println("---Vertical Distance--- \n" + verticalDistance);
    }
}