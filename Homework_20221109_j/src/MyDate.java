public class MyDate implements Comparable<MyDate> {
    private int day;
    private int month;
    private int year;


    @Override
    public String toString() {
        return day + "." + month + "." + year;
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    public void setDay(int dayOfArrival) {
        this.day = dayOfArrival;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getDay() {
        return day;
    }

    @Override
    public int compareTo(MyDate o) {
        if (this.year != o.year) {
            return this.year - o.year;
        }
        if (this.month != o.month) {
            return this.month - o.month;
        }
        if (this.day != o.day) {
            return this.day - o.day;
        }
        return 0;
    }


}