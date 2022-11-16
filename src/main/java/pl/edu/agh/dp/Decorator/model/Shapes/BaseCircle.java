package pl.edu.agh.dp.Decorator.model.Shapes;

import javafx.beans.property.*;

public class BaseCircle implements MyShape {
    private BooleanProperty visible;
    private final DoubleProperty radius;

    public BaseCircle() {
        this.radius = new SimpleDoubleProperty(100);
        this.visible = new SimpleBooleanProperty(false);
    }


    public double getRadius() {
        return radius.get();
    }
    public DoubleProperty radiusProperty() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius.set(radius);
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
