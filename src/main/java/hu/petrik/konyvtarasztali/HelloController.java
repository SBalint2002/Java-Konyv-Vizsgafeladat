package hu.petrik.konyvtarasztali;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {

    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn cimCol;
    @FXML
    private TableColumn szerzoCol;
    @FXML
    private TableColumn kiadasCol;
    @FXML
    private TableColumn oldalszamCol;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}