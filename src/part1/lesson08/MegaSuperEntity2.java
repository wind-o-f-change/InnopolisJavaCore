package part1.lesson08;


public class MegaSuperEntity2 {
    public String megaSuperEntityField = "I'm a god! -_ MegaSuperEntity _- ";

    public String getMegaSuperEntityField() {
        return megaSuperEntityField;
    }

    public MegaSuperEntity2 setMegaSuperEntityField(String megaSuperEntityField) {
        this.megaSuperEntityField = megaSuperEntityField;
        return this;
    }

    public MegaSuperEntity2() {
    }

    public MegaSuperEntity2(String megaSuperEntityField) {
        this.megaSuperEntityField = megaSuperEntityField;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MegaSuperEntity2{");
        sb.append("megaSuperEntityField='").append(megaSuperEntityField).append('\'');
        sb.append('}');
        return sb.toString();
    }
}