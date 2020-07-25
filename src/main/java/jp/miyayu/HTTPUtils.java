package jp.miyayu;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HTTPUtils {
    public static String getHTTP(String url) throws IOException{
        return getHTTP(url,"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.36");
    }
    public static String getHTTP(String url,String userAgent) throws IOException{
        URL tempUrl = new URL(url);
        URLConnection urlConnection = tempUrl.openConnection();
        urlConnection.setRequestProperty("User-Agent",userAgent);
        InputStream inputStream = tempUrl.openStream();
        try{
            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
            return readAll(rd);
        }finally {
            inputStream.close();
        }
    }
    private static String readAll(Reader rd) throws IOException{
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();

    }
}
