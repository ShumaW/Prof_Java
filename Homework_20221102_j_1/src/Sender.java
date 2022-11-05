public class Sender {

    public void send(int mail){
        if (mail == 1) {
            MailDeliveryService m = new DHL();
            m.sendMail();
        } else if (mail == 2) {
            MailDeliveryService m = new Email();
            m.sendMail();
        } else if (mail == 3) {
            MailDeliveryService m = new Pigeon();
            m.sendMail();
        }
    };
}
