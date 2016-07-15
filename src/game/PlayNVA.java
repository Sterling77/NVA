package game;


import javax.print.DocFlavor;
import java.util.Scanner;


/**
 * Created by Letricia on 7/11/16.
 */
public class PlayNVA {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NVA nva = new NVA();


        System.out.println("Lets play a game.");
        nva.setName();
        nva.setPlayerType();
        nva.setWeapon();
        nva.setLocation();
        nva.setSpecial();
        nva.startBattle();
    }
}

//        System.out.println("What is your name?");
//        String name = PlayNVA.scanner.nextLine();  // added PlayNVA. ... to this line. 3rd instruction from Week 1 Day 4 - Refactoring
//        System.out.println("Welcome, " + name);
//
//        String playerType = "";
//        while (!(playerType.equalsIgnoreCase("ninja") || playerType.equalsIgnoreCase("alien"))) {
//            System.out.println("Are you a Ninja or Alien? [ninja/alien]");
//            playerType = scanner.nextLine();
//
//            if (playerType.equalsIgnoreCase("ninja")) {
//                System.out.println("Noble choice, the Ninja is stealthy and fast.");
//            } else if (playerType.equalsIgnoreCase("alien")) {
//                System.out.println("Powerful choice, the Alien is scary and strong.");
//            } else {
//                System.out.println("Invalid player type.");
//            }
//
//        }
//        String weapon = "";
//        while (!((playerType.equalsIgnoreCase("ninja") && ((weapon.equalsIgnoreCase("blade")) || (weapon.equalsIgnoreCase("star")))) ||
//                ((playerType.equalsIgnoreCase("alien") && ((weapon.equalsIgnoreCase("claw")) || (weapon.equalsIgnoreCase("laser"))))))) {
//
//            if (playerType.equalsIgnoreCase("ninja")) {
//                System.out.println("Okay ninja, choose your weapon [blade/star]");
//            } else {
//                System.out.println("Okay alien, choose your weapon [claw/laser]");
//            }
//            weapon = scanner.nextLine(); //
//
//            if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("blade")) {
//                System.out.println("The ninja blade is close range, but deals more damage");
//            } else if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("star")) {
//                System.out.println("The ninja star does less damage, but keeps you at a safer range");
//            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("claw")) {
//                System.out.println("The alien claw is  close range, but deals more damage");
//            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("laser")) {
//                System.out.println("The alien laser does less damage, but keeps you at a safer range");
//            } else {
//                System.out.println("Invalid weapon."); //
//            }
//        }           //System.out.println("Choose your location? [forest/space]");
//                    //String location = scanner.nextLine();
//        String location = "";
//        while (!(location.equalsIgnoreCase("forest") || location.equalsIgnoreCase("space"))) {
//            System.out.println("Choose your location? [forest/space]");
//            location = scanner.nextLine();
//
//            if (location.equalsIgnoreCase("forest")) {
//                System.out.println("The forest gives the ninja a slight stealth advantage.");
//            } else if (location.equalsIgnoreCase("space")) {
//                System.out.println("Space gives the alien a slight strength advantage.");
//            } else {
//                System.out.println("Invalid location type.");
//            }
//        }
//
//
//        //System.out.println("Choose your special attack? [speed/power/pain]");
//        String special = "";
//        while (!(special.equalsIgnoreCase("speed") || special.equalsIgnoreCase("power") || special.equalsIgnoreCase("pain"))) {
//            System.out.println("Choose your special attack? [speed/power/pain]");
//            special = scanner.nextLine();
//
//            if (special.equalsIgnoreCase("speed")) {
//                System.out.println("Speed gives the player a high chance of making a second hit at 20% damage of the first hit.");
//            } else if (special.equalsIgnoreCase("power")) {
//                System.out.println("Power gives the player a medium chance of doing an additional 50% damage on a hit.");
//            } else if (special.equalsIgnoreCase("pain")) {
//                System.out.println("Pain has a small chance of inflicting a permanent penalty on the opponent, decreasing their overall effectiveness by 10%.");
//            } else {
//                System.out.println("Invalid special attack");
//            }
//        }
//        String helmet = "";
//        while (!(helmet.equalsIgnoreCase("black") || helmet.equalsIgnoreCase("red"))) {
//            System.out.println("Choose your helmet? [red/black]" );
//            helmet = scanner.nextLine();
//
//            if (helmet.equalsIgnoreCase("black")) {
//                System.out.println("Your helmet is made of platinum.");
//            } else if (helmet.equalsIgnoreCase("red")) {
//                System.out.println("Your helmet is made of stainless steel.");
//            } else {
//                System.out.println("Your head is exposed.");
//            }
//
//        }
//
//    }
//}


















