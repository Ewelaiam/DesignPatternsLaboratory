package pl.edu.agh.dp.Decorator.model;

import pl.edu.agh.dp.Decorator.model.Shapes.MyShape;
import javafx.beans.property.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class ColorDecorator extends BaseDecorator{
    private ObjectProperty<Paint> colour;
    private final Paint paint;

    public ColorDecorator(MyShape myShape, Paint paint) {
        this.myShape = myShape;
        this.paint = paint;
        colour = new SimpleObjectProperty<>(Color.BLACK);
    }

    public Paint getColour() {
        return colour.get();
    }
    public ObjectProperty<Paint> colourProperty() {
        return colour;
    }

    public void setColour(Paint colour) {
        this.colour.set(colour);
    }

    @Override
    public void draw() {
        setColour(paint);
        this.myShape.draw();
    }
}
