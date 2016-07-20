package game.players;

import game.util.RandInt;

/**
 * Created by Letricia on 7/11/16.
 */
public abstract class Player {


    private int health = 100;
    private String playerName;
    private String playerWeapon;
    private String battleLocation;
    private String specialGift;
    private boolean isPain=false;



    public int getHealth() {
        return health;
    }

    public void removeHealth(int hit) {
        health -= hit;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerWeapon() {
        return playerWeapon;
    }

    public void setPlayerWeapon(String playerWeapon) {
        this.playerWeapon = playerWeapon;
    }

    public String getBattleLocation() {
        return battleLocation;
    }

    public void setBattleLocation(String battleLocation) {
        this.battleLocation = battleLocation;
    }

    public String getSpecialGift() {
        return specialGift;

    }

    public void setSpecialGift(String specialGift) {
        this.specialGift = specialGift;

    }

    public boolean getisPain() {
        return isPain;

    }

    public void setisSPain(boolean isPain) {
        this.isPain = isPain;
    }

    private int getSpecialDamage(int Damage) {
        double extDamage = 1;
        int randNum = RandInt.randomInt(0, 100);


        if (getSpecialGift().equalsIgnoreCase("speed") && randNum < 75) {
            extDamage = 1.2;

        } else if (getSpecialGift().equalsIgnoreCase("power") && randNum < 50) {
            extDamage = 1.5;
        } else if (getisPain() || getSpecialGift().equalsIgnoreCase("pain") && randNum < 10) {
            setisSPain(true);
            Damage -= 3;
            if (Damage < 1) ;
            {
                Damage = 1;
            }
        }
        extDamage = extDamage * Damage;
        Double d = new Double(extDamage);
        return d.intValue();
    }

    public int getSharkAttack() {
        int biteDamage = 0;
        int randNum = RandInt.randomInt(0, 100);

        if (getBattleLocation().equalsIgnoreCase("ocean") && randNum < 25) {
            biteDamage = 100;
            System.out.println("shark attack");
        }

        if (randNum <= 5) {
            biteDamage = 100;
            System.out.println("bitten");
        }
        return biteDamage;
    }
    //public int getEasterAttack()


}



