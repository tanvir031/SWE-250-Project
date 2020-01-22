package com.example.oneblood;

import org.json.JSONArray;

public class Dbcontract {
    public static JSONArray USER_INFO_JSONarry;

    public static JSONArray getUSER_INFO_JSONarry() {
        return USER_INFO_JSONarry;
    }

    public static void setUSER_INFO_JSONarry(JSONArray USER_INFO_JSONarry) {
        Dbcontract.USER_INFO_JSONarry = USER_INFO_JSONarry;
    }
}
