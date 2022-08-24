package Controllers;

import Models.Datum;
import Models.DatumStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class CalendarPricesResultController implements Initializable {


    @FXML
    private TableView myTable;
    @FXML
    private Button cancelButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Datum> dataImport = CalendarPricesController.dataApi1;
        List<DatumStringProperty> dataAll = new ArrayList<DatumStringProperty>();


        TableColumn value = new TableColumn("value");
        TableColumn depart_date = new TableColumn("depart date");
        TableColumn found_at = new TableColumn("found at");
        TableColumn gate = new TableColumn("gate");
        myTable.getColumns().addAll(value, depart_date, found_at, gate);

        ObservableList<DatumStringProperty> data = FXCollections.observableArrayList();


        for (Datum el : dataImport) {
            DatumStringProperty dataAdd = new DatumStringProperty();
            dataAdd.setValue(el.getValue());
            dataAdd.setDepartDate(el.getDepartDate());
            dataAdd.setFoundAt(el.getFoundAt());
            dataAdd.setGate(el.getGate());
            dataAll.add(dataAdd);

            data.add(dataAdd);
        }
        value.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, Integer>("value"));
        depart_date.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("departDate"));
        found_at.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("foundAt"));
        gate.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("gate"));

        myTable.setItems(data);
    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
