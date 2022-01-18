package ansarker.github.io.houserent.myutils;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import ansarker.github.io.houserent.model.Account;

public class MyUtils {
    public static List<Object> fromJSon(String jsonString){
        Gson gson = new Gson();
        try {
            List<Object> list = Arrays.asList(gson.fromJson(jsonString, Object[].class));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
         return null;
    }
}
