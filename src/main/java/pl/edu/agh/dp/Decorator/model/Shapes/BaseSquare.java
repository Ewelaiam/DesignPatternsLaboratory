package pl.edu.agh.dp.Decorator.model.Shapes;

import javafx.beans.property.*;

public class BaseSquare implements MyShape {
    private final DoubleProperty width;
    private final DoubleProperty height;
    private BooleanProperty visible;
    public BaseSquare() {
        width = new SimpleDoubleProperty(200);
        height = new SimpleDoubleProperty(200);
        visible = new SimpleBooleanProperty(false);
    }

    public double getWidth() {
        return width.get();
    }
    public DoubleProperty widthProperty() {
        return width;
    }

    public void setWidth(int width) {
        this.width.set(width);
    }


    public double getHeight() {
        return height.get();
    }
    public DoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(int height) {
        this.height.set(height);
    }

    public boolean isVisible() {
        return visible.get();
    }
    public BooleanProperty visibleProperty() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible.set(visible);
    }

    public void clean(){
        this.visible.set(false);
    }

    @Override
    public void draw() {
        setVisible(true);
    }
}
