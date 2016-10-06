package game;

import java.util.ArrayList;
import game.players.Alien;
import game.players.Ninja;
import game.util.Statistics;

import java.util.SplittableRandom;

/**
 * Created by Letricia on 7/11/16.
 */

public class NVA {

    //Next 7 lines are what are called GLOBAL VARIABLES
    private String name = "";
    private String playerType = "";
    private String weapon = "";
    private String location = "";
    private String special = "";
    private Ninja n = new Ninja();
    private Alien a = new Alien();




    public void setName() {
        System.out.println("What is your name?");
        name = PlayNVA.scanner.nextLine();
        System.out.println("Welcome, " + name);
    }

    public void setPlayerType() {
        while (!(playerType.equalsIgnoreCase("ninja") || playerType.equalsIgnoreCase("alien"))) {
            System.out.println("Are you a Ninja or Alien? [ninja/alien]");
            playerType = PlayNVA.scanner.nextLine();

            if (playerType.equalsIgnoreCase("ninja")) {
                System.out.println("Noble choice, the Ninja is stealthy and fast");
            } else if (playerType.equalsIgnoreCase("alien")) {
                System.out.println("Powerful choice, the Alien is scary and strong.");
            } else {
                System.out.println("Invalid player type");
            }
        }
    }

    public void setWeapon() {  // weapon is one of the global variables
        while (!((playerType.equalsIgnoreCase("ninja") && ((weapon.equalsIgnoreCase("blade")) ||
                (weapon.equalsIgnoreCase("star")))) ||
                ((playerType.equalsIgnoreCase("alien") && ((weapon.equalsIgnoreCase("claw")) ||
                        (weapon.equalsIgnoreCase("laser"))))))) {
            if (playerType.equalsIgnoreCase("ninja")) {
                System.out.println("Okay ninja, choose your weapon [blade/star]");
            } else {
                System.out.println("Okay alien, choose your weapon [claw/laser]");
            }
            weapon = PlayNVA.scanner.nextLine();
            if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("blade")) {
                System.out.println("The ninja blade is close range, but deals more damage.");
            } else if (playerType.equalsIgnoreCase("ninja") && weapon.equalsIgnoreCase("star")) {
                System.out.println("The ninja star does less damage, but keeps you at a safer range.");
            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("claw")) {
                System.out.println("The alien claw is  close range, but deals more damage.");
            } else if (playerType.equalsIgnoreCase("alien") && weapon.equalsIgnoreCase("laser")) {
                System.out.println("The alien laser does less damage, but keeps you at a safer range.");

            } else {
                System.out.println("Invalid weapon.");
            }

        }

    }

    public void setLocation() {
        while (!(location.equalsIgnoreCase("forest") || location.equalsIgnoreCase("space"))) {
            System.out.println("Choose your location? [forest/space]");
            location = PlayNVA.scanner.nextLine();
            if (location.equalsIgnoreCase("forest")) {
                System.out.println("The forest gives the ninja a slight stealth advantage.");
            } else if (location.equalsIgnoreCase("space")) {
                System.out.println("Space gives the alien a slight strength advantage.");
            } else {
                System.out.println("Invalid location.");
            }

        }
    }

    public void setSpecial() {
        while (!(special.equalsIgnoreCase("speed") || special.equalsIgnoreCase("power") || special.equalsIgnoreCase("pain"))) {
            System.out.println("Choose your special attack? [speed/power/pain]");
            special = PlayNVA.scanner.nextLine();

            if (special.equalsIgnoreCase("speed")) {
                System.out.println("Speed gives the player a high chance of making a second hit at 20% damage of the first hit.");
            } else if (special.equalsIgnoreCase("power")) {
                System.out.println("Power gives the player a medium chance of doing an additional 50% damage on a hit.");
            } else if (special.equalsIgnoreCase("pain")) {
                System.out.println("Pain has a small chance of inflicting a permanent penalty on the opponent, " +
                        "decreasing their overall effectiveness by 10%.");
            } else {
                System.out.println("Invalid special");
            }
        }
    }
    public void startBattle(){
        Statistics stats = new Statistics();
        int wincount = 1;
        int count = 1;                      // added for P.8  *****REMOVE ME IF WRONG


            if(playerType.equalsIgnoreCase("ninja")) {
                n.setPlayerName(name);
                n.setPlayerWeapon(weapon);
                n.setBattleLocation(location);
                n.setSpecialGift(special);
                a.setPlayerName("Twinkle Toes");
                a.setPlayerWeapon("laser");
                a.setBattleLocation(location);
                a.setSpecialGift(special);
        }   else {
                a.setPlayerName(name);
                a.setPlayerWeapon(weapon);
                a.setBattleLocation(location);
                a.setBattleLocation(special);
                n.setPlayerName("Mr Fuzzy Jingles");


                n.setPlayerWeapon("star");
                n.setBattleLocation(location);
                n.setSpecialGift(special);
            }
        System.out.println(" ");
        System.out.println(" "); // added on 7-15 at 1133 am . might be wrong
        System.out.println("**********************************************");
        System.out.println("Time to play!");
        System.out.println(" ");
        while(a.getHealth() > 0 && n.getHealth() > 0) {


            int alienDamageReceived = a.alienDamageReceivedCalculator(n.ninjaDamageGivenCalculator());
            System.out.println(n.getPlayerName()+" attacks with the "+n.getPlayerWeapon()+" and deals "+alienDamageReceived+" points of damage.");
            int ninjaDamageReceived = n.ninjaDamageReceivedCalculator(a.alienDamageGivenCalculator());
            System.out.println(a.getPlayerName()+" attacks with the "+a.getPlayerWeapon()+" and deals "+ninjaDamageReceived+" points of damage.");
            System.out.println(n.getPlayerName()+" Heath: "+n.getHealth()+"  vs  "+a.getPlayerName()+" Health: "+a.getHealth());
            stats.recordAttack(alienDamageReceived, ninjaDamageReceived); // *******added for NVA.P9


            System.out.println("**********************************************");
            if(n.getHealth() > 0) {
                System.out.println(n.getPlayerName()+" Wins!!!");
                System.out.println("Health Remaining: "+n.getPlayerName());
            } else if(a.getHealth() > 0) {
                System.out.println(a.getPlayerName()+" Wins!!!");
                System.out.println("Health Remaining: "+a.getPlayerName());
            } else {
                System.out.println("Everyone Died!!!");
                System.out.println(n.getPlayerName()+" and "+a.getPlayerName()+" both lose.");
            }

            System.out.println("**********************************************");
            System.out.println(" ");
//            System.out.println("Press [enter] to take another turn.");
//            String getturn = PlayNVA.scanner.nextLine();                               //added get to turn on this line
            System.out.println("attacks in game>" + count);                            //added this is your on this line
            System.out.println("attacks won>" + wincount);
            count ++; //"points of damage.";                                            // added for P.8  *****REMOVE ME IF WRONG
            wincount ++;
            System.out.println("average damage ninja given>" + ninjaDamageReceived/count);
            System.out.println("average damage alien given>" + alienDamageReceived/count);

        }
        System.out.println("Total attacks: " + stats.getTotalAttacks());
        System.out.println("Total ties: " + stats.getTies());
        System.out.println("Total wins by ninja:" +stats.getNinjaWins());
        System.out.println("Ninja's attack average: " +stats.getNinjaAverageDamageDealt());
        System.out.println("Total wins by alien:" + stats.getAlienWins());
        System.out.println("Alien's attack average: "+stats.getAlienAverageDamageDealt());



//        System.out.println("**********************************************");
//        if(n.getHealth() > 0) {
//            System.out.println(n.getPlayerName()+" Wins!!!");
//            System.out.println("Health Remaining: "+n.getPlayerName());
//        } else if(a.getHealth() > 0) {
//            System.out.println(a.getPlayerName()+" Wins!!!");
//            System.out.println("Health Remaining: "+a.getPlayerName());
//        } else {
//            System.out.println("Everyone Died!!!");
//            System.out.println(n.getPlayerName()+" and "+a.getPlayerName()+" both lose.");
//        }
//        System.out.println("**********************************************");
    }
    }


