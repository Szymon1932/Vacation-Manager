package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class DatumStringProperty {


    @SerializedName("value")
    @Expose
    private SimpleIntegerProperty value;
    @SerializedName("depart_date")
    @Expose
    private SimpleStringProperty departDate;
    @SerializedName("return_date")
    @Expose
    private SimpleStringProperty returnDate;
    @SerializedName("found_at")
    @Expose
    private SimpleStringProperty foundAt;

    @SerializedName("gate")
    @Expose
    private SimpleStringProperty gate;

    public String getGate() {
        return gate.get();
    }

    public void setGate(String gate) {
        this.gate = new SimpleStringProperty(gate);
    }

    public int getValue() {
        return value.get();
    }

    public void setValue(int value) {
        this.value = new SimpleIntegerProperty(value);
    }

    public String getDepartDate() {
        return departDate.get();
    }

    public void setDepartDate(String departDate) {
        this.departDate = new SimpleStringProperty(departDate);
    }

    public String getReturnDate() {
        return returnDate.get();
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = new SimpleStringProperty(returnDate);
    }

    public String getFoundAt() {
        return foundAt.get();
    }

    public void setFoundAt(String foundAt) {
        this.foundAt = new SimpleStringProperty(foundAt);
    }

}