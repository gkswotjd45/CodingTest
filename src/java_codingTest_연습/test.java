package java_codingTest_연습;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class test {
	public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://openapi.price.go.kr/openApiImpl/ProductPriceInfoService/getProductInfoSvc.do"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=aZCNhsgSdP2hTnOyDbwgZtjJrmJAlu2Ni6acxNp5G3MtCcpzYwdhWgSy8oSDtqrWqAJXWSnBF4/9fBIXVMPxYg=="); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("goodId","UTF-8") + "=" + URLEncoder.encode("1182", "UTF-8")); /*상품 한 건 조회시 사용 (전체 조회 시 미사용)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
	
}
