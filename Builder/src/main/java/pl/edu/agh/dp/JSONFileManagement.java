package pl.edu.agh.dp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONFileManagement {
    public static String getTextFromJSON(String filename) throws IOException {
        String fileContent = Files.readString(Paths.get(filename));

        try {
            new JSONObject(fileContent);
        } catch (JSONException e){
            e.printStackTrace();
            throw new RuntimeException("Invalid JSON format!!!");
        }

        return fileContent;
    }
}
