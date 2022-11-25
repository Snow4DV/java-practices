package ru.snow4dv;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.mirea.ru")).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Document body = Jsoup.parse(response.body());
        Elements images = body.select("img");
        for (Element image:
             images) {
            String src = image.attr("src");
            if(src.matches("^\\/[^\\/].*")) {
                src = "https://www.mirea.ru" + src;
            } else if(src.startsWith("//")) {
                src = src.replace("//", "https://www.");
            }

            String[] splittedUrl = src.split("/");

            if(!src.isEmpty()) {
                try(BufferedInputStream inputStream = new BufferedInputStream(new URL(src).openStream());
                    FileOutputStream fileOutputStream = new FileOutputStream(splittedUrl[splittedUrl.length-1])) {

                    byte data[] = new byte[1024];
                    int bytesRead;
                    while((bytesRead = inputStream.read(data, 0, 1024)) != -1) {
                        fileOutputStream.write(data, 0, bytesRead);
                    }
                } catch(IOException ex) {
                    System.err.printf("Error downloading %s\n", src);
                }
            }

        }

        System.out.println("Скачанные файлы:");
        File[] files = new File("./").listFiles();
        for (File file :
                files) {
            System.out.println(file.toString());
        }
    }
}