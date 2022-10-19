public class MyDateTime {
     int day;
     int month;
     int year;
     int hour;
     int min;

     public MyDateTime(int day, int month, int year, int hour, int min) {
          this.day = day;
          this.month = month;
          this.year = year;
          this.hour = hour;
          this.min = min;
     }

     @Override
     public String toString() {
          return "MyDateTime{" +
                  "day=" + day +
                  ", month=" + month +
                  ", year=" + year +
                  ", hour=" + hour +
                  ", min=" + min +
                  '}';
     }
}
