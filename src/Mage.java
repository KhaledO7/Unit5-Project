public class Mage extends Avatar {
    private boolean lowMana;
    private int mana = 0;

    public Mage(String name, double health, String ability, String vl, int mana){
        this.name = name;
        this.health = health;
        this.type = "mage";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.25;
        this.rm = .9;
        lowMana = false;
        this.mana = mana;
        this.deathSound = "Goodbye";
    }

    public void voiceLine(){
        System.out.println("Full Mana! \n" + vl);
    }
    public void deathSound(){ System.out.println("Mana \n " + deathSound);}
    public void getMana(){
        System.out.println("Mana: " + mana);
    }
    public void setIsLowMana(Boolean isLow) {
        lowMana = isLow;
    }
    public void gainHealth(){
        int increase = (int) (Math.random()*15)+10;
        this.health = health + increase;
        System.out.println(" My fellow mage, your health is now: ");
        System.out.println(health);
    }

}
