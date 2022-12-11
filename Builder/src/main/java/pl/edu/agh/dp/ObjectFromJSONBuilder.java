package pl.edu.agh.dp;

public interface ObjectFromJSONBuilder {
    void addJsonObject(ObjectFromJSON jsonObject);
    void addFloatValue(String jsonProperty, Float floatObject);
    void addIntegerValue(String jsonProperty, Integer integerObject);
    void addStringValue(String jsonProperty, String stringObject);
    ObjectFromJSON getObjectFromJson();
}
