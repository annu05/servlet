package com.parse;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Parser {
    public String par(URL url){

        ObjectMapper mapper = new ObjectMapper();
        ser ser = null;
        String prettyStaff = null;
        String a = null;
        JsonParser parser;
        try{
            ser =mapper.readValue(url,ser.class);
            prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ser);
            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);

            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();
                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("getVPPAssetsSrvUrl".equals(fieldName)){
                        a = parser.getValueAsString();
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return a;


    }

    public String par(File file){

        ObjectMapper mapper = new ObjectMapper();
        ser ser = null;
        String prettyStaff = null;
        String a = null;
        JsonParser parser;
        try{
            ser =mapper.readValue(file,ser.class);
            prettyStaff = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ser);
            JsonFactory factory = new JsonFactory();
            parser  = factory.createParser(prettyStaff);

            while(!parser.isClosed()){
                JsonToken jsonToken = parser.nextToken();
                if(JsonToken.FIELD_NAME.equals(jsonToken)){
                    String fieldName = parser.getCurrentName();


                    jsonToken = parser.nextToken();


                    if("getVPPAssetsSrvUrl".equals(fieldName)){
                        a = parser.getValueAsString();
                    }
                }
            }


        }catch (IOException e) {
            e.printStackTrace();
        }
        return a;


    }
}
