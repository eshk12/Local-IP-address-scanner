import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTTP_Request {
    private final static int SECOND = 1000;

    public String isOnline(String serverAddress) {
        String title;
        try {
            URL url = new URL(serverAddress);
            URLConnection yc = url.openConnection();
            yc.setConnectTimeout(3 * 1000);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));

            String sourceCode;
            StringBuilder stringBuilder = new StringBuilder();
            while ((sourceCode = in.readLine()) != null) {
                stringBuilder.append(sourceCode);
            }
            sourceCode = stringBuilder.toString().toLowerCase();

            final Pattern pattern = Pattern.compile("<title>(.+?)</title>", Pattern.DOTALL);
            final Matcher matcher = pattern.matcher(sourceCode);
            matcher.find();
            try {
                title = matcher.group(1);
            } catch (IllegalStateException e) {
                title = "no-name-found";
            }
            in.close();
        } catch (ConnectException e) {
            return "not-found";
        } catch (SocketTimeoutException e) {
            return "not-found";
        } catch (IOException e) {
            return "not-found";
        }
        return serverAddress + " - " + title;
    }
}
