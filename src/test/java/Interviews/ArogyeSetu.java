package Interviews;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class ArogyeSetu {

    String stateid,stateidnonTrimed = null;
    String var = null;
    @Test
    public void getStatesList() throws IOException {

        String maxCityName = null;
        int maxCityNameLength = 0;
        JSONObject stateObjectResponse =  readJsonFromUrl("https://cdn-api.co-vin.in/api/v2/admin/location/states");

        JSONArray array = stateObjectResponse.getJSONArray("states");

        Set<Integer> stateIds = new HashSet<>();
        for(int i = 0; i < array.length();i++){
            JSONObject obj = array.getJSONObject(i);
            stateIds.add(obj.getInt("state_id"));
        }
        System.out.println(stateIds.size());

        for(int stateId :stateIds){
            JSONObject districtObjectResponse = readJsonFromUrl("https://cdn-api.co-vin.in/api/v2/admin/location/districts/"+ stateId);
            JSONArray districtArray = districtObjectResponse.getJSONArray("districts");
            for(int i = 0; i < districtArray.length();i++){
                JSONObject obj = districtArray.getJSONObject(i);
                String districtName = obj.getString("district_name");
                if(districtName.length() > maxCityNameLength){
                    maxCityNameLength = districtName.length();
                    maxCityName = districtName;

                }
            }
        }
        System.out.println(maxCityName);

    }


    @Test
    public void Testget1() {


    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
