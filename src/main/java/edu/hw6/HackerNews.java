package edu.hw6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("MultipleStringLiterals")
public final class HackerNews {
    private static final Logger LOGGER = LoggerFactory.getLogger(HackerNews.class);
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final String URI_ERROR = "Not valid uri";
    private static final String IO_AND_INTERRUPT_EXC = "IOException or Interrupted";

    private HackerNews() {
    }

    public static long[] hackerNewsTopStories() {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .GET()
                .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JsonNode jsonNode = MAPPER.readTree(httpResponse.body());
            return MAPPER.convertValue(jsonNode, long[].class);
        } catch (URISyntaxException ex) {
            LOGGER.error(URI_ERROR);
        } catch (IOException | InterruptedException e) {
            LOGGER.error(IO_AND_INTERRUPT_EXC);
        }
        return new long[0];
    }

    public static String news(long id) {
        try {
            HttpClient httpClient = HttpClient.newHttpClient();

            HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
                .GET()
                .build();

            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

            JsonNode jsonNode = MAPPER.readTree(httpResponse.body());

            if (jsonNode.has("title")) {
                return jsonNode.get("title").asText();
            }
        } catch (URISyntaxException ex) {
            LOGGER.error(URI_ERROR);
        } catch (IOException | InterruptedException e) {
            LOGGER.error(IO_AND_INTERRUPT_EXC);
        }
        return null;
    }
}
