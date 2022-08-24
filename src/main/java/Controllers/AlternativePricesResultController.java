package Controllers;

import Models.DatumStringProperty;
import Models.Price;
import Models.PriceStringProperty;
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

public class AlternativePricesResultController implements Initializable {
    @FXML
    private TableView myTable;
    @FXML
    private Button cancelButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        List<Price> dataImport = AlternativePricesController.dataApi1;
        List<PriceStringProperty> dataAll = new ArrayList<PriceStringProperty>();


        TableColumn origin = new TableColumn("origin");
        TableColumn destination = new TableColumn("destination");
        TableColumn price = new TableColumn("price");
        TableColumn depart_date = new TableColumn("depart date");
        TableColumn transfers = new TableColumn("transfers");
        TableColumn duration = new TableColumn("duration");
        TableColumn gate = new TableColumn("gate");

        myTable.getColumns().addAll(origin, destination, price, depart_date, transfers, duration, gate);

        ObservableList<PriceStringProperty> data = FXCollections.observableArrayList();

        for (Price el : dataImport) {
            PriceStringProperty dataAdd = new PriceStringProperty();
            dataAdd.setOrigin(el.getOrigin());
            dataAdd.setDestination(el.getDestination());
            dataAdd.setPrice(el.getPrice());
            dataAdd.setDepartDate(el.getDepartDate());
            dataAdd.setTransfers(el.getTransfers());
            dataAdd.setDuration(el.getDuration());
            dataAdd.setGate(el.getGate());
            dataAll.add(dataAdd);

            data.add(dataAdd);
        }
        origin.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, Integer>("origin"));
        destination.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("destination"));
        price.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("price"));
        depart_date.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("departDate"));
        transfers.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("transfers"));
        duration.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("duration"));
        gate.setCellValueFactory(new PropertyValueFactory<DatumStringProperty, String>("gate"));

        myTable.setItems(data);
    }

    public void cancelButtonOnAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
