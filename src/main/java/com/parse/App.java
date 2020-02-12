package com.parse;



import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author postgresqltutorial.com
 */
public class App{

    private final String url = "jdbc:postgresql://localhost:5434/postgres";
    private final String user = "postgres";
    private final String password = "123";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @param
     * @param asset

     */
    public Connection connect(JSONArray asset) {
        ObjectMapper mapper = new ObjectMapper();

        JsonParser parser;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            try {
                PreparedStatement pstmt = conn.prepareStatement("INSERT INTO assets values (?, ?, ?, ?,?,?)");
                for(Object object : asset) {
                    JSONObject record = (JSONObject) object;
                    String a = (String) record.get("productTypeName");
                    Long b = (Long) record.get("productTypeId");
                    String c = (String) record.get("pricingParam");
                    String d = (String) record.get("adamIdStr");
                    Boolean e = (Boolean) record.get("isIrrevocable");
                    Boolean f = (Boolean) record.get("deviceAssignable");
                    pstmt.setString(1, a);
                    pstmt.setLong(2, b);
                    pstmt.setString(3, c);
                    pstmt.setString(4, d );
                    pstmt.setBoolean(5,e);
                    pstmt.setBoolean(6,f);
                    pstmt.executeUpdate();
                }
                System.out.println("Records inserted.....");



            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }




}
