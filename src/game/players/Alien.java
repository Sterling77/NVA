package game.players;

import game.util.RandInt;

/**
 * Created by Letricia on 7/11/16.
 */
public class Alien extends Player {

    private int clawMaxDamage = 18;
    private int clawRangeProtection = 6;
    private int laserMaxDamage = 4;
    private int laserRangeProtection = 14;
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


        } return getSpecialDamage(damage);
    }




            //public String getPlayerWeapon() {
            // return null;  }

        public int alienDamageReceivedCalculator(int rawDamageDealt){
            int Damage = 1;
            int protetion = 0;

            if (getPlayerWeapon().equalsIgnoreCase("claw")) {
                Damage = rawDamageDealt - (getRandomClawRangeProtection() * getRandomAccuracy());
            } else {
                Damage = rawDamageDealt - (getRandomLaserProtection() * getRandomAccuracy());
            }
            if (rawDamageDealt > protetion) {
                Damage = rawDamageDealt - protetion;
            }
            this.removeHealth(Damage);
            return Damage;
        }

    }





