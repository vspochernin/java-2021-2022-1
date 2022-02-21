package lab3;

public abstract class Chordata {

    protected String name = StringConstants.NO_NAME;

    public String getPhylum() {
        return StringConstants.PHYLUM_CHORDATA;
    }
    public String getName() {
        return name;
    }
    public abstract String getClassName();
    public abstract String getOrder();
    public abstract String getFamily();
    public abstract String getGenus();
    public abstract String getSpecies();

    @Override
    public String toString() {
        return getName() +
                ": " +
                getPhylum() +
                " -> " +
                getClassName() +
                " -> " +
                getOrder() +
                " -> " +
                getFamily() +
                " -> " +
                getGenus() +
                " -> " +
                getSpecies();
    }
}
