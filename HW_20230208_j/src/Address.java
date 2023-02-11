public class Address {
    private String streetAndNum;
    private String city;
    private String country;

    public Address(String streetAndNum, String city, String country) {
        this.streetAndNum = streetAndNum;
        this.city = city;
        this.country = country;
    }

    public String getStreetAndNum() {
        return streetAndNum;
    }

    public void setStreetAndNum(String streetAndNum) {
        this.streetAndNum = streetAndNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address: " + streetAndNum + ", " + city + ", " + country ;
    }
}
