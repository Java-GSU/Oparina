package by.gsu.pms;

public enum Materials {
    STEEL("steel", 7850), COOPER("cooper", 8500);

    private String name;
    private int density;


    Materials() {
        this(null,0);
    }

    Materials(String name, int density) {
        this.name = name;
        this.density = density;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getDensity() {
        return density;
    }

    public void setDensity(int density) {
        this.density = density;
    }

    public String toString() {

        return name + ";" + density;
    }
}
