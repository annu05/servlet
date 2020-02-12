
package com.parse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataInput;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.parser.JSONParser;


public class ClientWithResponseHandler {

    public final static void main(String[] args) throws Exception {


        URL url = null;
        try {
            url = new URL("https://vpp.itunes.apple.com/WebObjects/MZFinance.woa/wa/VPPServiceConfigSrv");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Parser parser =new Parser();
        String b = parser.par(url);



        String stoken = "?sToken=eyJleHBEYXRlIjoiMjAyMC0wOS0xNVQyMzoxNToxNi0wNzAwIiwidG9rZW4iOiI5c3RtRTcvbWFuckxJZExqcU1DeXpjaXM2S1BxZ0p3blVha1JMditVN0swdlF1RTQvWDIwdkNYeXd2U3pwZXpZQk05d3B0M0Z0bVYrSExXYldlcVRWdUhmaWxzL050ajZ1OTgzdktPckFjbkNBOHlvN0VDV09IQ1o3bm1kSDFMK09zVzdJeThUVlZ5MkNWS0JXZGVOZEE9PSIsIm9yZ05hbWUiOiJOb3ZlbGwifQ==";



        CloseableHttpClient httpclient = HttpClients.createDefault();
        try {
            HttpGet httpget = new HttpGet(b+stoken);

            System.out.println("Executing request " + httpget.getRequestLine());



            ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

                @Override
                public String handleResponse(
                        final HttpResponse response) throws ClientProtocolException, IOException {
                    int status = response.getStatusLine().getStatusCode();
                    if (status >= 200 && status < 300) {
                        HttpEntity entity = response.getEntity();
                        return entity != null ? EntityUtils.toString(entity) : null;
                    } else {
                        throw new ClientProtocolException("Unexpected response status: " + status);
                    }
                }

            };
            String responseBody = httpclient.execute(httpget, responseHandler);
            System.out.println("----------------------------------------");
            System.out.println(responseBody);

            ObjectMapper objectMapper = new ObjectMapper();

           /* JsonNode jsonNode = objectMapper.readTree(responseBody);
            Iterator<String> fieldNames = jsonNode.fieldNames();
            JsonNode field =null;
            while(fieldNames.hasNext()) {
                String fieldName = fieldNames.next();

               field = jsonNode.get("assets");

            }
            String json = objectMapper.writeValueAsString(field);
            Asset[] asset = objectMapper.readValue(json,Asset[].class); */
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(new FileReader("src/main/resources/j.json"));
            JSONArray jsonArray = (JSONArray) jsonObject.get("assets");

            App app = new App();
            app.connect(jsonArray);
            //String a = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(asset);
            //System.out.println(a);
           // String json = objectMapper.writeValueAsString(jsonNode.get("assets"));
            //Asset asset = objectMapper.readValue(responseBody,Asset.class);
           // String a = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(asset);
            //



        } finally {
            httpclient.close();
        }

    }






}

