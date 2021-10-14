package part1.lesson08;

public class Some extends MegaSuperEntity2 {
    private String someString;
    private SuperSome superSome;

    public Some() {
    }

    public Some(String someString, SuperSome superSome) {
        this.someString = someString;
        this.superSome = superSome;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Some{");
        sb.append("megaSuperEntityField='").append(megaSuperEntityField).append('\'');
        sb.append(", someString='").append(someString).append('\'');
        sb.append(", superSome=").append(superSome);
        sb.append('}');
        return sb.toString();
    }

    public String getSomeString() {
        return someString;
    }

    public Some setSomeString(String someString) {
        this.someString = someString;
        return this;
    }

    public SuperSome getSuperSome() {
        return superSome;
    }

    public Some setSuperSome(SuperSome superSome) {
        this.superSome = superSome;
        return this;
    }
}
