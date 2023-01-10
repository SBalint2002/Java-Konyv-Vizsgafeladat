package hu.petrik.konyvtarasztali;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KonyvController {

    private KonyvDB db;
    private final List<Konyv> lista= new ArrayList<Konyv>();
    @FXML
    private Button deleteButton;
    @FXML
    private TableColumn<Object, Object> cimCol;
    @FXML
    private TableColumn<Object, Object> szerzoCol;
    @FXML
    private TableColumn<Object, Object> kiadasCol;
    @FXML
    private TableColumn<Object, Object> oldalszamCol;
    @FXML
    public TableView<Konyv> bookTableView;

    @FXML
    private void initialize() {
        cimCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        szerzoCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        kiadasCol.setCellValueFactory(new PropertyValueFactory<>("publish_year"));
        oldalszamCol.setCellValueFactory(new PropertyValueFactory<>("page_count"));
        try {
            db = new KonyvDB();
            readKonyv();
        } catch (SQLException e) {
            Platform.runLater(() -> {
                alert(Alert.AlertType.WARNING, "Hiba történt az adatbázis kapcsolat kialakításakor!",
                        e.getMessage());
            });
        }
    }

    private void readKonyv() throws SQLException {
        List<Konyv> konyvek = db.getKonyvek();
        bookTableView.getItems().clear();
        bookTableView.getItems().addAll(konyvek);
        lista.addAll(konyvek);
    }

    private Optional<ButtonType> alert(Alert.AlertType alertType, String headerText, String contentText){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(headerText);
        alert.setContentText(contentText);
        return alert.showAndWait();
    }

    public void onDeleteClick(ActionEvent actionEvent) {

    }
}