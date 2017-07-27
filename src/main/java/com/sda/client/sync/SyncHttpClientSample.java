package com.sda.client.sync;


import com.sda.client.model.Currency;
import com.sda.client.model.Rate;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.apache.http.HttpHeaders.USER_AGENT;

public class SyncHttpClientSample {

    public static void main(String[] args) throws IOException {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/eur/2017-01-24/2017-07-25";

        HttpClient client = HttpClientBuilder.create().build();


        HttpGet request = new HttpGet(url);

        HttpResponse response = client.execute(request);


        String content = IOUtils.toString(response.getEntity().getContent(), "UTF-8");


        System.out.println("Response Code : "
                + response.getStatusLine().getStatusCode());
        System.out.println("Headers: "+ Arrays.toString(response.getAllHeaders()));
        System.out.println("content: "+content);

        ObjectMapper objectMapper = new ObjectMapper();
        Currency currency = objectMapper.readValue(content, Currency.class);
        System.out.println(currency);
        String valueAsString = objectMapper.writeValueAsString(currency);
        System.out.println("Min val is:");
        System.out.println(currency.getMin());
        System.out.println("Max val is:");
        System.out.println(currency.getMax());
        System.out.println("average");
        System.out.println(currency.getAverage());
        System.out.println(valueAsString);


    }

}
