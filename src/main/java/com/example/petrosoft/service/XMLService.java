package com.example.petrosoft.service;

import com.example.petrosoft.controller.LogController;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class XMLService {
    LogController logController;

    @Autowired
    public XMLService(LogController logController) {
        this.logController = logController;
    }

    public void readXML(HttpServletRequest request) throws IOException, InterruptedException {

        BufferedReader reader = request.getReader();
        int intValueOfChar;
        StringBuilder result = new StringBuilder();

        while ((intValueOfChar = reader.read()) != -1) {
            result.append((char) intValueOfChar);
        }

        String resultOut = "{\"xml\":\"" + result + "\"}";

        HttpRequest postRequest = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create("http://localhost:4040/postJson"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(resultOut))
                .build();
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .build();

        HttpResponse<String> response =
                client.send(postRequest, HttpResponse.BodyHandlers.ofString());
    }
}
