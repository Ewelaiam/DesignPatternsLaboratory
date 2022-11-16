package pl.edu.agh.dp.Decorator.model.Shapes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class BaseTriangle implements MyShape {
    private BooleanProperty visible;

    public BaseTriangle() {
        visible = new SimpleBooleanProperty(false);
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
