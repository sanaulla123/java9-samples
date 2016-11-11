import java.net.http.HttpRequest;
import java.net.http.HttpResponse; 
import java.net.URI;

public class Http2Feature{
  public static void main(String[] args) throws Exception{ 
    HttpResponse response = HttpRequest
      .create(new URI("http://jsonplaceholder.typicode.com/users"))
      .GET()
      .response();

    String responseBody = response.body(HttpResponse.asString());
    System.out.println("Status coe: " + response.statusCode());
    System.out.println("Response Body: " + responseBody);          
  }
}

