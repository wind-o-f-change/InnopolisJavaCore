package part1.lesson08;

public class SuperSome extends MegaSuperEntity2 {
    private String someSuperString;

    public SuperSome() {
    }

    public SuperSome(String someSuperString) {
        this.someSuperString = someSuperString;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SuperSome{");
        sb.append("megaSuperEntityField='").append(megaSuperEntityField).append('\'');
        sb.append(", someSuperString='").append(someSuperString).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
