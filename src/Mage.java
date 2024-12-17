public class Mage extends Avatar {
    Boolean lowMana;
    double

    public Mage(String name, double health, String ability, String vl){
        this.name = name;
        this.health = health;
        this.type = "mage";
        this.ability = ability;
        this.vl = vl;
        this.dm = 1.25;
        this.rm = .9;
        lowMana = false;
    }

    public void voiceLine(){
        System.out.println(name + " screams" + vl + " as they use their ability " + ability);;
    }

    public void setLowMana(Boolean isLow) {
        lowMana = isLow;
    }

}
