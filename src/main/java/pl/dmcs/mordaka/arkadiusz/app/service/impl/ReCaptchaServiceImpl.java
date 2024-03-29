package pl.dmcs.mordaka.arkadiusz.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import pl.dmcs.mordaka.arkadiusz.app.service.ReCaptchaService;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

@Service
public class ReCaptchaServiceImpl implements ReCaptchaService {

    private static final Logger logger = LoggerFactory.getLogger(ReCaptchaServiceImpl.class);

    private static final String URL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String GOOGLE_KEY = "6LebZ5gUAAAAAGBqePfT9EoQoBWYPhjxP64Rny1l";
    private static final String USER_AGENT = "Mozilla/5.0";

    @Override
    public boolean verify(String captcha) {
        if (captcha == null || "".equals(captcha)) {
            return false;
        }

        try{
            URL obj = new URL(URL);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String postParams = "secret=" + GOOGLE_KEY + "&response="
                    + captcha;

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();
            logger.info("\nSending 'POST' request to URL : " + URL);
            logger.info("Post parameters : " + postParams);
            logger.info("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            logger.info(response.toString());

            //parse JSON response and return 'success' value
            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();

            return jsonObject.getBoolean("success");
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
