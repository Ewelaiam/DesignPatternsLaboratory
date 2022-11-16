package pl.edu.agh.dp.Decorator.model;

import pl.edu.agh.dp.Decorator.model.Shapes.MyShape;

public abstract class BaseDecorator implements MyShape {
    protected MyShape myShape;

    @Override
    public abstract void draw();
}
