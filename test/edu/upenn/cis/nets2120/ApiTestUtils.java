package edu.upenn.cis.nets2120;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import spark.utils.IOUtils;

/**
 * Very simple URL checker, based on a test case from StackOverflow, 
 * https://stackoverflow.com/questions/40036196/unit-testing-java-spark-microframework
 */
public class ApiTestUtils {
    public static TestResponse request(String method, String path, int port, String requestBody) {
        try {
            URL url = new URL("http://localhost:" + String.valueOf(port) + path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(method);
            connection.setDoOutput(true);
            connection.connect();
            String body = IOUtils.toString(connection.getInputStream());
            return new TestResponse(connection.getResponseCode(), body);
        } catch (IOException e) {
            e.printStackTrace();
            fail("Sending request failed: " + e.getMessage());
            return null;
        }
    }

    public static class TestResponse {

        public final String body;
        public final int status;

        public TestResponse(int status, String body) {
            this.status = status;
            this.body = body;
        }

        @SuppressWarnings("unchecked")
        public Map<String,String> json() {
            return new Gson().fromJson(body, HashMap.class);
        }
    }
}