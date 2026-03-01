import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class Crud {

    private final String baseUrl = "https://jsonplaceholder.typicode.com/posts";
    private final HttpClient client;

    public Crud() {
        client = HttpClient.newHttpClient();
    }

    // GET
    public void simulateGetRequest(int id) {
        String url = baseUrl + "/" + id;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        sendAndPrint(request);
    }

    // POST
    public void simulatePostRequest(String jsonBody) {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        sendAndPrint(request);
    }

    // Common method to send request
    private void sendAndPrint(HttpRequest request) {
        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body:");
            System.out.println(response.body());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class ApiPractice {

    public static void main(String[] args) {

        Crud crud = new Crud();

        crud.simulateGetRequest(101);

        String jsonBody = """
                {
                    "title": "New Post",
                    "body": "Learning Java API",
                    "userId": 1
                }
                """;

        crud.simulatePostRequest(jsonBody);
    }
}