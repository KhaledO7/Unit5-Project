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
    }

    public void voiceLine(){
        System.out.println("Low Mana!");
    }
    public void getMana(){
        System.out.println("Mana: " + mana);
    }
    public void setIsLowMana(Boolean isLow) {
        lowMana = isLow;
    }

}
