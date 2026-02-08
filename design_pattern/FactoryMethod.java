interface Notification {
    void notifyUser();
}

class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS Notification");
    }
}

class NotificationFactory {
    public static Notification createNotification(String type) {
        if(type.equals("Email")) return new EmailNotification();
        else if(type.equals("SMS")) return new SMSNotification();
        return null;
    }
}
public class FactoryMethod {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification("Email");
        notification.notifyUser();

        notification = NotificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}
