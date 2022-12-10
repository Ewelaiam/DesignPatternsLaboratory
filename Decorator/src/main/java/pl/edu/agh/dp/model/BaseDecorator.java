package pl.edu.agh.dp.model;

import pl.edu.agh.dp.model.Shapes.MyShape;

public abstract class BaseDecorator implements MyShape {
    protected MyShape myShape;

    @Override
    public abstract void draw();
}
