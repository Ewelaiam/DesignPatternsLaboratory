package pl.edu.agh.dp.Decorator.model;

import pl.edu.agh.dp.Decorator.model.Shapes.MyShape;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LineDecorator extends BaseDecorator{
    private final String line;
    private StringProperty lineStyle;
    public LineDecorator(MyShape myShape, String line) {
        this.myShape = myShape;
        this.line = line;
        lineStyle = new SimpleStringProperty();
    }

    public String getLineStyle() {
        return lineStyle.get();
    }

    public StringProperty lineStyleProperty() {
        return lineStyle;
    }

    public void setLineStyle(String lineStyle) {
        this.lineStyle.set(lineStyle);
    }

    @Override
    public void draw() {
        setLineStyle(line);
        this.myShape.draw();
    }
}
