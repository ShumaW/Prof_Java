package Task1;

public class Good {
    private String name;
    private String way;

    public Good(String name, String way) {
        this.name = name;
        this.way = way;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    @Override
    public String toString() {
        return "Good: " + name + ", way: " + way;
    }
}
