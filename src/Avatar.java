import java.util.Scanner;
public class Avatar {
    public double health;
    public double rm = 1.0;
    public String name;
    public String type;
    public double dm = 1.0;
    public String vl;
    public String ability;
    public double abDmg;
    public String deathSound;
    public boolean isAlive;
    public String powerUpName;
    public double powerUpDamage;
    public int mana;


    public Avatar( String name, double health, String type, String ability, String vl, double dm, double rm, boolean alive, double abDmg, String deathSound){
        this.name = name;
        this.health = health;
        this.type = type;
        this.ability = ability;
        this.vl = vl;
        this.dm = dm;
        this.isAlive = alive;
        this.abDmg = abDmg;
        this.deathSound = deathSound;
        this.type = type;

    }

    public Avatar(){
        this.name = "Chris";
        this.health = 150;
        this.type = "basic";
        this.ability = "Beg!";
        this.vl = "Don't hurt me! Please! Resort to peace!";
        this.dm = 1.2;
        this.abDmg = 45;
        this.powerUpName = "Default Power-up";
        this.powerUpDamage = 35;

    }

        public void customizePowerUp(String powerUpName){
            this.powerUpName = powerUpName;
            this.powerUpDamage = (Math.random()*(40))+60;
            System.out.println("Power-up activated! " + powerUpName + " deals " + powerUpDamage + " damage!");
        }
    public String getPowerUpName(){
        return powerUpName;
    }
    public double getPowerUpDamage(){
        return powerUpDamage;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getRm() {
        return rm;
    }

    public void setRm(double rm) {
        this.rm = rm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDm() {
        return dm;
    }

    public double getAbDmg() {
        return abDmg;
    }

    public void setAbDmg(double abDmg) {
        this.abDmg = abDmg;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public void setDm(double dm) {
        this.dm = dm;
    }

    public String getVl() {
        return vl;
    }

    public void setVl(String vl) {
        this.vl = vl;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }
    public String getDeathSound() {
        return deathSound;
    }

    public void voiceLine(){
        System.out.println(vl);

    }

    public boolean aliveCheck(){
        if(health <= 0){
            return false;
        }
     else{return true;}
    }
    public void gainResistance(){
        int decrease = (int) (Math.random()*11)+1;
        this.rm = this.rm - (int) (Math.random()/4);
        this.health = health - decrease;
    }
    public void gainHealth(){
        int increase = (int) (Math.random()*10)+1;
        this.health = health + increase;
        System.out.println("You healed yourself! " + "You now have " + health + " health!");

    }

    public void damageBuff(){
    }


    public void loseMana(){
        System.out.println("This character does not use mana! In an attempt to cast the spells of an other-worldly nature, you fell into a spiraling depression and died!");
        System.exit(0);

    }

    public void gainMana(){
        System.out.println("This character does not use mana! In an attempt to cast the spells of an other-worldly nature, you fell into a spiraling depression and died!");
        System.exit(0);

    }

    public double takeDamage(double damage){
        damage = damage * rm;
        health = Math.max(0, health - damage);
        System.out.println(name +" took " + damage + " points of damage!");
        System.out.println("Current HP: ");
        System.out.println(health);
        return health;
    }
    public void deathSound(){System.out.println(deathSound);

    }
public static void main(String[]args){
        Avatar Steve = new Avatar("Steve", 150.0,"C","Fruit Punch", "Ahahahaha! This fist is called 'fruit'! And this one is 'punch'! It's fruit punch, get it?!",1.1,1.1,true,100, "Oof");
        Steve.voiceLine();
        Avatar Chris = new Avatar();
        Chris.voiceLine();
        Chris.takeDamage(40.0);
}

}


