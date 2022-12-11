package pl.edu.agh.dp;

public class ObjectFromJSONBuilderImplementation implements ObjectFromJSONBuilder{

    private final ObjectFromJSON objectFromJSON = new ObjectFromJSON();

    @Override
    public void addJsonObject(ObjectFromJSON jsonObject) {
        objectFromJSON.addJsonObject(jsonObject);
    }

    @Override
    public void addFloatValue(String jsonProperty, Float floatObject) {
        objectFromJSON.addSFloatObject(jsonProperty, floatObject);
    }

    @Override
    public void addIntegerValue(String jsonProperty, Integer integerObject) {
        objectFromJSON.addIntegerObject(jsonProperty, integerObject);
    }

    @Override
    public void addStringValue(String jsonProperty, String stringObject) {
        objectFromJSON.addStringObject(jsonProperty, stringObject);
    }

    @Override
    public ObjectFromJSON getObjectFromJson() {
        return objectFromJSON;
    }

}
