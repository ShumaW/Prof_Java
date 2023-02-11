import java.util.stream.Stream;

public class Contact {
    private String  nameAndLastName;
    private String  telNumber;
    private String streetAndNum;
    private String city;
    private String country;
    private String  email;
    private String  webSite;

    public Contact(String nameAndLastName, String telNumber, String streetAndNum, String city, String country, String email, String webSite) {
        this.nameAndLastName = nameAndLastName;
        this.telNumber = telNumber;
        this.streetAndNum = streetAndNum;
        this.city = city;
        this.country = country;
        this.email = email;
        this.webSite = webSite;
    }

    public String getNameAndLastName() {
        return nameAndLastName;
    }

    public void setNameAndLastName(String nameAndLastName) {
        this.nameAndLastName = nameAndLastName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    @Override
    public String toString() {
        return nameAndLastName +  ", telNumber: +" + telNumber + ", address: " + streetAndNum + ", " + city + ", " + ", " + country + ", email: " + email + ", webSite: " + webSite + "\n";
    }
}
