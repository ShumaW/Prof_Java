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


    @Override
    public String toString() {
        return nameAndLastName +  ", telNumber: +" + telNumber + ", " + address + ", email: " + email + ", webSite: " + webSite + "\n";
    }
}
