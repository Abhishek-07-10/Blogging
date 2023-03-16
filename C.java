import java.io.*;
import java.net.*;

public class C {

   public static String getHTML() throws Exception {
      StringBuilder result = new StringBuilder();
      URL url = new URL("http://finalmcttestabhishek-env.eba-ebv3n6gt.us-east-1.elasticbeanstalk.com/get-all-posts");
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      try (BufferedReader reader = new BufferedReader(
                  new InputStreamReader(conn.getInputStream()))) {
          for (String line; (line = reader.readLine()) != null; ) {
              result.append(line);
          }
      }
      return result.toString();
   }

   public static void main(String[] args) throws Exception
   {
        System.out.println(getHTML());
   }
}