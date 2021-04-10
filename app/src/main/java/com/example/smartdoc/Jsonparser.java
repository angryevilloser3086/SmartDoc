package com.example.smartdoc;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Jsonparser<HashMAP> {
    private HashMap<String,String>parseJsonObject(JSONObject object){
        HashMap<String,String> dataList = new HashMap<>();

        try{
            String name =   object.getString("String");
            String latitude =object.getJSONObject("geometry")
                    .getJSONObject("location").getString("lat");
            String Longitude = object.getJSONObject("geometry")
                    .getJSONObject("location").getString("long");
            dataList.put("name",name);
            dataList.put("lat",latitude);
            dataList.put("long",Longitude);
         }catch(JSONException e){
            e.printStackTrace();
        }
        return dataList;
    }

    private <HashMAP> List<HashMap<String, String>> parseJsonArray(JSONArray JsonArray){

        List<HashMap<String,String>> dataList = new ArrayList<>();
        for (int i= 0;i<JsonArray.length();i++){
            try {
                HashMap<String,String> data = parseJsonObject((JSONObject)  JsonArray.get(i));
                dataList.add(data);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return dataList;
    }

    public List<HashMap<String, String>> parseResult(JSONObject object){
            JSONArray jsonArray = null;
        try {
            jsonArray = object.getJSONArray("result");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parseJsonArray(jsonArray);
    }

}
