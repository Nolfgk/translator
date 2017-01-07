package web2.model;

import com.jayway.jsonpath.JsonPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

//Этот класс отправляет текст и переводит его в яндексе, возвращает хэшмапу с синонимами.


public class YandexTranslator {
    private static final String YANDEX_KEY = "dict.1.1.20170103T192635Z.e256c4430a141a2a.21747761b8e671509b8d3108ac97819f9df87042";
    private String text;
    private String language;
    private String translation;
    URL url;

    public static HashMap<String, String> translateText(String text, String language) throws Exception {

        System.out.println("Send Http GET request");
        String response = sendGet(text, language);
        HashMap<String,String> result = parseJson(response);
        result.put("original", text);
        result.put("language", language);
        return result;
    }

    // HTTP GET request
    private static String sendGet(String text, String lang) throws Exception {

        String url = "https://dictionary.yandex.net/api/v1/dicservice.json/lookup?key=" + YANDEX_KEY + "&" + "lang=" + lang + "&" + "text=" + text;

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();

    }

    private static HashMap<String, String> parseJson(String input) {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("translation", JsonPath.read(input, "$.def[*].tr[*].text").toString());
        result.put("synonim", JsonPath.read(input, "$.def[*].tr[*].syn[*].text").toString());
        result.put("meaning", JsonPath.read(input, "$.def[*].tr[*].mean[*].text").toString());
        for (Map.Entry<String, String> pair : result.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        return result;
    }


}
