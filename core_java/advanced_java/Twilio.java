import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

class SmsApi {
    private final String baseUrl;
    private final String credentials;
    private final String authHeader;

    private final HttpClient client;

    public SmsApi() {
        String accountSid = System.getenv("TWILIO_ACCOUNT_SID");
        String authToken = System.getenv("TWILIO_AUTH_TOKEN");

        if(accountSid == null || authToken == null) {
            throw new RuntimeException("Environment variables not found");
        }

        baseUrl = "https://api.twilio.com/2010-04-01/Accounts/" + accountSid + "/Messages.json";
        credentials = Base64.getEncoder().encodeToString((accountSid + ":" + authToken).getBytes());
        client = HttpClient.newHttpClient();
        authHeader = "Basic " + credentials;
    }

    public void sendSms(String message) {
        HttpRequest request = HttpRequest.newBuilder()
                                .uri(URI.create(baseUrl))
                                .header("Content-Type", "application/x-www-form-urlencoded")
                                .header("Authorization", authHeader)
                                .POST(HttpRequest.BodyPublishers.ofString(message))
                                .build();
        sendAndPrint(request);
    }

    private void sendAndPrint(HttpRequest request) {
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:");
            System.out.println(response.body());
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}

public class Twilio {
    public static void main(String args[]) {
        SmsApi smsApi = new SmsApi();

        String body = 
                "To=+18777804236" +
                "&From=+17756182360" +
                "&Body=This is test3";

        smsApi.sendSms(body);
    }
}
