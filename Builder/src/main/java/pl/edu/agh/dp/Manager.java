package pl.edu.agh.dp;

import java.io.IOException;

public class Manager {
    private final String jsonContent;
    private Integer indexPosition;

    public Manager(String filePath) throws IOException {
        jsonContent = JSONFileManagement.getTextFromJSON(filePath).replaceAll("\\s+","");
        indexPosition = 1;
    }

    private boolean isCurrentValueEqualAGivenValue(char c){
        return c == getCurrentValue();
    }

    private boolean isCurrentValueADigit(){
        return Character.isDigit(getCurrentValue());
    }

    private boolean isEndOfLine(){
        return isCurrentValueEqualAGivenValue(',');
    }

    private char getCurrentValue(){
        return jsonContent.charAt(indexPosition);
    }

    private String getStringPropertyValue() {
        int leftQuotationMarkPosition = indexPosition;
        indexPosition++;
        while (!isCurrentValueEqualAGivenValue('"'))
            indexPosition++;

        indexPosition++;
        return jsonContent.substring(leftQuotationMarkPosition + 1, indexPosition - 1);
    }

    private String getNumberPropertyValue() {
        int firstDigitPosition = indexPosition;
        while (isCurrentValueADigit())
            indexPosition++;
        return jsonContent.substring(firstDigitPosition, indexPosition);
    }

    public void createNumberObject(ObjectFromJSONBuilder objectFromJSONBuilder, String jsonProperty){
        String number = getNumberPropertyValue();
        if (isCurrentValueEqualAGivenValue('.')){
            indexPosition++;
            objectFromJSONBuilder.addFloatValue(jsonProperty, Float.valueOf(number + '.' + getNumberPropertyValue()));
        }
        else{
            objectFromJSONBuilder.addIntegerValue(jsonProperty, Integer.valueOf(number));
        }
    }


    public ObjectFromJSON createObject(){
        ObjectFromJSONBuilder objectFromJSONBuilder = new ObjectFromJSONBuilderImplementation();

        while (!isCurrentValueEqualAGivenValue('}')){
            String jsonProperty = getStringPropertyValue();
            indexPosition++;

            if (isCurrentValueEqualAGivenValue('{')){
                indexPosition++;
                objectFromJSONBuilder.addJsonObject(createObject());
            }
            else if (isCurrentValueADigit()){
                createNumberObject(objectFromJSONBuilder, jsonProperty);
            }
            else if (isCurrentValueEqualAGivenValue('"')){
                objectFromJSONBuilder.addStringValue(jsonProperty, getStringPropertyValue());
            }

            if(isEndOfLine())
                indexPosition++;
        }

        indexPosition++;
        return objectFromJSONBuilder.getObjectFromJson();
    }
}
