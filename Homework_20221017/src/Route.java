public class Route {
    String number;
    String from;
    String destination;
    long distance;

    public Route(String number, String from, String destination, long distance) {
        this.number = number;
        this.from = from;
        this.destination = destination;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "number='" + number + '\'' +
                ", from='" + from + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public String getFrom() {
        return from;
    }

    public String getDestination() {
        return destination;
    }

    public long getDistance() {
        return distance;
    }
}
