import java.util.stream.Stream;

public class Contact {
    private String  nameAndLastName;
    private String  telNumber;
    private Address  address;
    private String  email;
    private String  webSite;

    public Contact(String nameAndLastName, String telNumber, Address address, String email, String webSite) {
        this.nameAndLastName = nameAndLastName;
        this.telNumber = telNumber;
        this.address = address;
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
        return nameAndLastName +  ", telNumber: +" + telNumber + ", " + address + ", email: " + email + ", webSite: " + webSite + "\n";
    }
}
