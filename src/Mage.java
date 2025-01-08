public class Mage extends Avatar {
    private boolean lowMana;
    //private int mana; horrible issue which causes it to refer to its own classes mana and not anothers
    private int manaCost;

    public Mage(String name, double health, String ability, String vl, int mana ){
        this.name = name;
        this.health = health;
        this.type = "mage";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.25;
        this.rm = .9;
        lowMana = false;
        this.mana = mana;
        this.deathSound = "How did you.... how did you win against my spells?!";
    }

    public void voiceLine(){
        System.out.println("Full Mana! \n" + vl);
    }
    public void deathSound(){ System.out.println(deathSound);}
    public void getMana(){
        System.out.println("Mana: " + mana);
    }
    public void setIsLowMana(Boolean isLow) {
        lowMana = isLow;
    }
    public void gainHealth(){
        int increase = (int) (Math.random()*35)+20;
        this.health = health + increase;
        System.out.println(" My fellow mage, your health is now: ");
        System.out.println(health);
    }

    @Override
    public void gainMana(){
        int increase = (int) (Math.random()*30)+10;
        this.mana = mana + increase;
        System.out.println(this.name + ",your mana is now: ");
        System.out.println(mana);
    }
    public void loseMana(){
        int decrease = (int) (Math.random()*20)+25;
        this.mana = Math.max(0, this.mana - decrease);
        System.out.println(this.name + ",your mana is now: ");
        System.out.println(mana);
    }

}
