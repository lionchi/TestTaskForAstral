package com.gavrilov.common;

import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.util.Random;

@Component
public class LoadImage {
    private String[] VALUES = new String[]{"seed.svg", "lol.svg", "green.svg", "car.svg", "cat.svg", "rain.svg", "pain.svg"};


    public byte[] getImage() throws IOException {
        String stringUrl = String.format("https://avatars.dicebear.com/v2/identicon/%s", getValue());
        URL url = new URL(stringUrl);
        HttpsURLConnection content = (HttpsURLConnection) url.openConnection();
        content.setRequestMethod("GET");

        InputStream input = content.getInputStream();

        // Получаем ответ на запрос
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int len;
        byte[] data = new byte[1024];

        while ((len = input.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, len);
        }

        content.disconnect();
        buffer.flush();
        buffer.close();

        return buffer.toByteArray();
    }

    private String getValue() {
        int index = new Random().nextInt(VALUES.length);
        return VALUES[index];
    }
}
