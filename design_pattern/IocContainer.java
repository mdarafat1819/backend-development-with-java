interface MessageService {
    public void send();
}

class EmailService implements MessageService {
    @Override
    public void send() {
        System.out.println("Sending email message");
    }
}

class SmsService implements MessageService {
    @Override
    public void send() {
        System.out.println("Sending SMS message");
    }
}

class NotificationService {
    private final MessageService messageService;

    public NotificationService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser() {
        messageService.send();
    }
}
public class IocContainer {

    public MessageService getMessageService(String type) {
        if(type.equals("SMS")) return new SmsService();
        else if(type.equals("Email")) return new EmailService();
        return null;
    }

    public NotificationService getNotificationService(String type) {
        return new NotificationService(getMessageService(type));
    }
    public static void main(String[] args) {
        IocContainer container = new IocContainer();

        container.getNotificationService("SMS").notifyUser();
        container.getNotificationService("Email").notifyUser();

    }
}
