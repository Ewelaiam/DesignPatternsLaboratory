package pl.edu.agh.dp.Decorator.controller;

import pl.edu.agh.dp.Decorator.model.LineDecorator;
import pl.edu.agh.dp.Decorator.model.Shapes.BaseCircle;
import pl.edu.agh.dp.Decorator.model.Shapes.BaseTriangle;
import pl.edu.agh.dp.Decorator.model.Shapes.MyShape;
import pl.edu.agh.dp.Decorator.model.Shapes.BaseSquare;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import pl.edu.agh.dp.Decorator.model.ColorDecorator;

import static javafx.application.Platform.exit;

public class AppController {

    @FXML
    private VBox endLayout;

    // shapes view
    @FXML
    private Rectangle rectangle;
    @FXML
    private Circle circle;
    @FXML
    private Polygon triangle;

    // buttons
    @FXML
    private Button squareBtn;
    @FXML
    private Button circleBtn;
    @FXML
    private Button triangleBtn;
    @FXML
    private Button redBtn;
    @FXML
    private Button blueBtn;
    @FXML
    private Button greenBtn;
    @FXML
    private Button solidBtn;
    @FXML
    private Button dottedBtn;
    @FXML
    private Button dashedBtn;
    @FXML
    private Button doneBtn;

    // shapes model
    private Shape shape;
    private MyShape myShape;

    private BaseSquare baseSquare;
    private BaseCircle baseCircle;
    private BaseTriangle baseTriangle;

    private ColorDecorator colorDecorator;
    private ColorDecorator redColorDecorator;
    private ColorDecorator blueColorDecorator;
    private ColorDecorator greenColorDecorator;

    private LineDecorator solidLineDecorator;
    private LineDecorator dottedLineDecorator;
    private LineDecorator dashedLineDecorator;

    private int clickedShape = -1;
    private boolean isShapeChosen = false;

    private int clickedColour = -1;
    private boolean isColourChosen = false;

    public void enableColourButtons(){
        redBtn.setDisable(false);
        blueBtn.setDisable(false);
        greenBtn.setDisable(false);
    }

    public void clearSurface(){
        baseSquare.clean();
        baseTriangle.clean();
        baseCircle.clean();
    }

    public void disableShapeButtons(){
        squareBtn.setDisable(true);
        circleBtn.setDisable(true);
        triangleBtn.setDisable(true);
    }

    public void enableLineButtons(){
        solidBtn.setDisable(false);
        dottedBtn.setDisable(false);
        dashedBtn.setDisable(false);
    }

    public void disableColourButtons(){
        redBtn.setDisable(true);
        blueBtn.setDisable(true);
        greenBtn.setDisable(true);
    }

    public void disableLineButtons(){
        solidBtn.setDisable(true);
        dottedBtn.setDisable(true);
        dashedBtn.setDisable(true);
    }

    public void chooseShape(){
        if (clickedShape == 0){
            myShape = baseSquare;
            shape = rectangle;
        } else if (clickedShape == 1) {
            myShape = baseCircle;
            shape = circle;
        } else if (clickedShape == 2) {
            myShape = baseTriangle;
            shape = triangle;
        }

        initColourDecorator();
    }

    public void chooseColour(){
        if (clickedColour == 0){
            colorDecorator = redColorDecorator;
        } else if (clickedColour == 1) {
            colorDecorator = blueColorDecorator;
        } else if (clickedColour == 2) {
            colorDecorator = greenColorDecorator;
        }

        initLineDecorator();
    }

    public void initColourDecorator(){
        // colour decorator
        redColorDecorator = new ColorDecorator(myShape, Color.RED);
        blueColorDecorator = new ColorDecorator(myShape, Color.BLUE);
        greenColorDecorator = new ColorDecorator(myShape, Color.GREEN);
    }

    public void initLineDecorator(){
        // line decorator
        solidLineDecorator = new LineDecorator(colorDecorator, "-fx-stroke-width: 7; -fx-stroke: pink;" );
        dottedLineDecorator = new LineDecorator(colorDecorator, "-fx-stroke-dash-array: 2 20; -fx-stroke-line-cap: round; -fx-stroke-width: 7;-fx-stroke: pink;" );
        dashedLineDecorator = new LineDecorator(colorDecorator, "-fx-stroke-dash-array: 12 20; -fx-stroke-width: 7;-fx-stroke: pink;" );
    }

    @FXML
    public void initialize() {
        redBtn.setText("RED");
        blueBtn.setText("BLUE");
        greenBtn.setText("GREEN");

        solidBtn.setText("SOLID");
        dottedBtn.setText("DOTTED");
        dashedBtn.setText("DASHED");

        redBtn.setDisable(true);
        blueBtn.setDisable(true);
        greenBtn.setDisable(true);

        solidBtn.setDisable(true);
        dottedBtn.setDisable(true);
        dashedBtn.setDisable(true);

        baseSquare = new BaseSquare();
        rectangle.widthProperty().bind(baseSquare.widthProperty());
        rectangle.heightProperty().bind(baseSquare.heightProperty());
        rectangle.visibleProperty().bind(baseSquare.visibleProperty());

        baseCircle = new BaseCircle();
        circle.radiusProperty().bind(baseCircle.radiusProperty());
        circle.visibleProperty().bind(baseCircle.visibleProperty());

        baseTriangle = new BaseTriangle();
        triangle.visibleProperty().bind(baseTriangle.visibleProperty());

    }

    @FXML
    public void handleSquareBtn(){
        if (clickedShape < 0){
            enableColourButtons();
        }
        clearSurface();
        baseSquare.draw();
        clickedShape = 0;
    }

    @FXML
    public void handleTriangleBtn(){
        if (clickedShape < 0){
            enableColourButtons();
        }
        clearSurface();
        triangle.getPoints().addAll(0.0, 100.0,
                200.0, 100.0,
                100.0, 0.0);

        baseTriangle.draw();
        clickedShape = 2;
    }

    @FXML
    public void handleCircleBtn(){
        if (clickedShape < 0){
            enableColourButtons();
        }
        clearSurface();
        baseCircle.draw();
        clickedShape = 1;
    }

    @FXML
    private void handleDoneBtn(){
        disableShapeButtons();
        disableColourButtons();
        disableLineButtons();
        doneBtn.setDisable(true);
        endLayout.setVisible(true);
    }

    @FXML
    public void handleRedBtn(){
        if (!isShapeChosen){
            chooseShape();
            disableShapeButtons();
            enableLineButtons();
            isShapeChosen = true;
        }

        shape.fillProperty().bind(redColorDecorator.colourProperty());

        redColorDecorator.draw();
        clickedColour = 0;
    }

    @FXML
    public void handleBlueBtn(){
        if (!isShapeChosen){
            chooseShape();
            disableShapeButtons();
            enableLineButtons();
            isShapeChosen = true;
        }
        shape.fillProperty().bind(blueColorDecorator.colourProperty());
        blueColorDecorator.draw();
        clickedColour = 1;
    }

    @FXML
    public void handleGreenBtn(){
        if (!isShapeChosen){
            chooseShape();
            disableShapeButtons();
            enableLineButtons();
            isShapeChosen = true;
        }
        shape.fillProperty().bind(greenColorDecorator.colourProperty());
        greenColorDecorator.draw();
        clickedColour = 2;
    }


    @FXML
    public void handleSolidBtn(){
        if(!isColourChosen){
            chooseColour();
            disableColourButtons();
            isColourChosen = true;
        }
        shape.styleProperty().bind(solidLineDecorator.lineStyleProperty());
        solidLineDecorator.draw();
    }

    @FXML
    public void handleDottedBtn(){
        if(!isColourChosen){
            chooseColour();
            disableColourButtons();
            isColourChosen = true;
        }
        shape.styleProperty().bind(dottedLineDecorator.lineStyleProperty());
        dottedLineDecorator.draw();
    }

    @FXML
    public void handleDashedBtn(){
        if(!isColourChosen){
            chooseColour();
            disableColourButtons();
            isColourChosen = true;
        }
        shape.styleProperty().bind(dashedLineDecorator.lineStyleProperty());
        dashedLineDecorator.draw();
    }

    @FXML
    private void handleExitBtn(){
        exit();
    }

}
