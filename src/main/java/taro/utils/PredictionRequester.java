package taro.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;

@Component
public class PredictionRequester {

    private static SocketConfig config;
    @Autowired
    private void init(SocketConfig config) throws IOException {
        PredictionRequester.config = config;
    }

    public String request(String request) throws IOException {
        Socket client = new Socket(config.getHost(), config.getPort());

        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

        out.write(request);
        out.flush();

        String answer = in.readLine();
        in.close();

        return answer;
    }
}
