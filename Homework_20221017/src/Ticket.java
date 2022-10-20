public class Ticket {
    private Route route;
    private MyDateTime time;
    private double price;

    public Ticket(Route route, MyDateTime time, double price) {
        this.route = route;
        this.time = time;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "route=" + route +
                ", time=" + time +
                ", price=" + price +
                '}';
    }

    public Route getRoute() {
        return route;
    }

    public MyDateTime getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public long getDistance1() {
        return route.getDistance();
    }

    public void setNewHours(int hour) {
        time.setHour(hour);
    }

    public void setNewMin (int min){
        time.setMin(min);
    }


}
