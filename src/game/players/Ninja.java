package game.players;
//package game;
import game.util.RandInt;
/**
 * Created by Letricia on 7/11/16.
 */
public class Ninja extends Player {

    private int bladeMaxDamage = 5;
    private int bladeRangeProtection = 2;
    private int starMaxDamage = 3;
    private int starRangeProtection = 4;
    private int maxHitsPerRole = 4;
    private int accuracy = 4;
    private int forestProtection =6;

    private int getRandomBladeDamage (){
        int damage = RandInt.randomInt(1,bladeMaxDamage);
        return damage;
    }
    private int getRandomStarDamage (){
        int damage = RandInt.randomInt(1,starMaxDamage);
        return damage;}


    private int getRandomHitsPerRole (){
    int damage = RandInt.randomInt(1, maxHitsPerRole);
        return damage;
}
    private int getRandomAccuracy () {
        int damage = RandInt.randomInt(1, accuracy);
        return damage;
    }

    private int getRandomBladeProtection (){
        int damage = RandInt.randomInt(1, bladeRangeProtection);
        return damage;
    }

    private int getRandomStarProtection (){
        int damage = RandInt.randomInt(1, starRangeProtection);
        return damage;
    }
    private int getForestProtection() {
        int protection = 0;

        if (getBattleLocation().equalsIgnoreCase("forest")) {
            protection = RandInt.randomInt(0, forestProtection);
        }
        return protection;
    }
    private int getSpecialDamage (int Damage) {
        double extDamage = 1;
        int randNum = RandInt.randomInt(0,100);

        if(getSpecialGift().equalsIgnoreCase("speed") && randNum < 75) {
            extDamage = 1.2;

        } else if(getSpecialGift().equalsIgnoreCase("power") && randNum < 50) {
            extDamage = 1.5;
        } else if (getisPain() || getSpecialGift().equalsIgnoreCase("pain") && randNum < 10 ){
            setisSPain(true);
            Damage -= 3;
            if (Damage < 1); {
                Damage = 1;
            }
        }
        extDamage = extDamage * Damage;
        Double d = new Double(extDamage);
        return d.intValue() ;
    }

    public int ninjaDamageGivenCalculator() {
        int damage = 0;
        //bladeMaxDamage = getRandomBladeDamage();    // changing the reference of blademaxdamgage frm static to getrandombladedamgae
        //starMaxDamage = getRandomStarDamage(); // changed from static to random
        //maxHitsPerRole = getRandomHitsPerRole();
        //accuracy = getRandomAccuracy();

        if(getPlayerWeapon().equalsIgnoreCase("blade")) {
            damage = getRandomBladeDamage () * getRandomHitsPerRole () * getRandomAccuracy ();

        } else {
            damage = getRandomStarDamage () * getRandomHitsPerRole () * getRandomAccuracy ();
        }
        return getSpecialDamage(damage);
    }

    public int ninjaDamageReceivedCalculator(int rawDamageDealt) {
        int damage = 1;
        int protection = 0;

        if(getPlayerWeapon().equalsIgnoreCase("blade")) {
            damage = rawDamageDealt - (getRandomBladeProtection () * getRandomAccuracy ());
        } else {
            damage = rawDamageDealt - (getRandomStarProtection () * getRandomAccuracy ());
        }
        if (rawDamageDealt > protection + getForestProtection()) {   // missed  protection statement which subtracted damgae dlt protectroy
            damage = rawDamageDealt - (protection + getForestProtection());
        }
        this.removeHealth(damage);
        return damage;
    }

}


