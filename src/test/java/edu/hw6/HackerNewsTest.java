package edu.hw6;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import static org.junit.jupiter.api.Assertions.*;

class HackerNewsTest {
    private static ObjectMapper objectMapper = new ObjectMapper();
    private static long[] actualLongArray;

    @Test
    void testHackerNewsTopStories() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
            .GET()
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = objectMapper.readTree(httpResponse.body());
        long[] expectedLongArray = objectMapper.convertValue(jsonNode, long[].class);

        // Act
        actualLongArray = HackerNews.hackerNewsTopStories();

        // Assert
        assertArrayEquals(expectedLongArray, actualLongArray);
    }

    @Test
    void testNews() throws URISyntaxException, IOException, InterruptedException {
        // Arrange
        long id = 38276951;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("https://hacker-news.firebaseio.com/v0/item/" + id + ".json"))
            .GET()
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JsonNode jsonNode = objectMapper.readTree(httpResponse.body());
        String expectedTitle = jsonNode.get("title").asText();

        // Act
        String actualTitle = HackerNews.news(id);

        // Assert
        assertEquals(expectedTitle, actualTitle);
    }
}
