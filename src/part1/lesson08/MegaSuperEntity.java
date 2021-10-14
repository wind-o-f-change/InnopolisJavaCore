package part1.lesson08;


public class MegaSuperEntity {
    public String megaSuperEntityField = "I'm a god! -_ MegaSuperEntity _- ";
    public Wheel superWheel = new Wheel(25123, "огого скока", new Some("что - то", new SuperSome("super что - то")));

    public String getMegaSuperEntityField() {
        return megaSuperEntityField;
    }

    public MegaSuperEntity setMegaSuperEntityField(String megaSuperEntityField) {
        this.megaSuperEntityField = megaSuperEntityField;
        return this;
    }

    public Wheel getSuperWheel() {
        return superWheel;
    }

    public MegaSuperEntity setSuperWheel(Wheel superWheel) {
        this.superWheel = superWheel;
        return this;
    }
}