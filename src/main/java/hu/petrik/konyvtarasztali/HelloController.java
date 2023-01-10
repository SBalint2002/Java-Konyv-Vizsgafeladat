package hu.petrik.konyvtarasztali;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

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

    public void onDeleteClick(ActionEvent actionEvent) {
    }
}