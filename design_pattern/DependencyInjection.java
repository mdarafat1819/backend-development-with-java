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
public class DependencyInjection {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService(new EmailService());
        notificationService.notifyUser();

        notificationService = new NotificationService(new SmsService());
        notificationService.notifyUser();

    }
}
