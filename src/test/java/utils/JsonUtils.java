package utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static Object[][] getLoginData(){

        try {

            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, String>> data = mapper.readValue(new File("src/resources/testdata/loginData.json"), List.class);
            Object[][] result = new Object[data.size()][2];

            for(int i = 0; i < data.size(); i++){
                result[i][0] = data.get(i).get("username");
                result[i][1] = data.get(i).get("password");
            }
            return result;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}

