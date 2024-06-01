/*
Title: Java console app
Name: Karanvir Kooner
Date: 2024-05-31
Purpose: To create a program that calculate the distance
in which a projectile is thrown vertically and horizontally
*/

//importing scanner library
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Setting up scanner
        Scanner sc = new Scanner(System.in);
        // Making constant for gravity
        double GRAVITY = 9.81;

        // Asking user for the initial angle
        System.out.println("What is the initial angle of the projectile in degrees?: ");
        // Scanning and storing angle value
        double angle = sc.nextDouble();
        // Asking user for the initial velocity
        System.out.println("What is the initial velocity of the projectile in m/s?: ");
        // Scanning and storing velocity value
        double velocity = sc.nextDouble();
        // Asking user for the time
        System.out.println("How many seconds have passed?: ");
        // Scanning and storing time value
        int seconds = sc.nextInt();

        
    }
}