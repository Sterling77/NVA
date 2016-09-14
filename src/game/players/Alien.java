package game.players;

import game.util.RandInt;

/**
 * Created by Letricia on 7/11/16.
 */
public class Alien extends Player {

    private int clawMaxDamage = 2;
    private int clawRangeProtection = 2;
    private int laserMaxDamage = 4;
    private int laserRangeProtection = 2;
    private int maxHitsPerRole = 4;
    private int accuracy = 3;
    private int spaceRoids = 4;


    private int getRandomClawDamage() {
        int damage = RandInt.randomInt(1, clawMaxDamage);
        return damage;
    }

    private int getRandomClawRangeProtection() {
        int damage = RandInt.randomInt(1, clawRangeProtection);
        return damage;
    }

    private int getRandomLaserDamage() {
        int damage = RandInt.randomInt(1, laserMaxDamage);
        return damage;
    }

    private int getRandomLaserProtection() {
        int damage = RandInt.randomInt(1, laserRangeProtection);
        return damage;
    }

    private int getRandomHitsPerRole() {
        int damage = RandInt.randomInt(1, maxHitsPerRole);
        return damage;
    }

    private int getRandomAccuracy() {
        int damage = game.util.RandInt.randomInt(1, accuracy);
        return damage;
    }

    private int getSpaceRoids() {
        int damage = 0;

        if (getBattleLocation().equalsIgnoreCase("space")) {
            damage = RandInt.randomInt(0, spaceRoids);
        }
        return damage;
    }

    private int getSpecialDamage(int Damage) {
        double extDamage = 1;
        int randNum = RandInt.randomInt(0, 100);

        if (getSpecialGift().equalsIgnoreCase("speed") && randNum < 75) {
            extDamage = 1.2;

        } else if (getSpecialGift().equalsIgnoreCase("power") && randNum < 50) {
            extDamage = 1.5;

        }
        extDamage = extDamage * Damage;
        Double d = new Double(extDamage);
        return d.intValue();
    }

    public int correctAnswers() {
        int correctAnswer =0;
        if(getUser().equals("correct")) {
            for (i =0; i< correctAnswer; i++);
        } return correctAnswer;
    }


    public int alienDamageGivenCalculator() {
        int damage = 0;
        //clawMaxDamage = getRandomClawDamage();
        //clawRangeProtection = getRandomClawRangeProtection();
        //maxHitsPerRole = getRandomHitsPerRole();
        //accuracy = getRandomAccuracy();


        if (getPlayerWeapon().equalsIgnoreCase("claw")) {
            damage = getRandomClawDamage() * getRandomHitsPerRole() * getRandomAccuracy();
        } else {
            damage = getRandomLaserDamage() * getRandomHitsPerRole() * getRandomAccuracy();
             // <should a closing curly brace be here }
            // return damage + getSpaceRoids(); now is in player
        } return getSpecialDamage(damage);
    }





            //public String getPlayerWeapon() {
            // return null;  }

        public int alienDamageReceivedCalculator(int rawDamageDealt){
            int Damage = 0;
            int protetion = 1;

            if (getPlayerWeapon().equalsIgnoreCase("claw")) {
                Damage = rawDamageDealt - (getRandomClawRangeProtection() * getRandomAccuracy() * getSpaceRoids());
            } else {
                Damage = rawDamageDealt - (getRandomLaserProtection() * getRandomAccuracy() * getSpaceRoids());
            }
            rawDamageDealt += this.getSharkAttack();
            if (rawDamageDealt > protetion) {
                Damage = rawDamageDealt - protetion;
            }
            this.removeHealth(Damage);
            return Damage;
        }

    }





