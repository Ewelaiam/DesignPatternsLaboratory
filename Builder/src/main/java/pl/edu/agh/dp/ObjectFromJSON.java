package pl.edu.agh.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ObjectFromJSON {
    private final Map<String, String> stringObjects = new HashMap<>();
    private final Map<String, Integer> integerObjects = new HashMap<>();
    private final Map<String, Float> floatObjects = new HashMap<>();
    private final Set<ObjectFromJSON> embeddedJSONObjects = new HashSet<>();

    public void addStringObject(String jsonProperty, String stringObject){
        stringObjects.put(jsonProperty, stringObject);
    }

    public void addIntegerObject(String jsonProperty, Integer integerObject){
        integerObjects.put(jsonProperty, integerObject);
    }

    public void addSFloatObject(String jsonProperty, Float floatObject){
        floatObjects.put(jsonProperty, floatObject);
    }

    public void addJsonObject(ObjectFromJSON jsonObject){
        embeddedJSONObjects.add(jsonObject);
    }

    public Map<String, String> getStringObjects() {
        return stringObjects;
    }

    public Map<String, Integer> getIntegerObjects() {
        return integerObjects;
    }

    public Map<String, Float> getFloatObjects() {
        return floatObjects;
    }

    public Set<ObjectFromJSON> getEmbeddedJSONObjects() {
        return embeddedJSONObjects;
    }
}
