package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class PriceStringProperty {

    @SerializedName("origin")
    @Expose
    private SimpleStringProperty origin;
    @SerializedName("destination")
    @Expose
    private SimpleStringProperty destination;
    @SerializedName("price")
    @Expose
    private SimpleIntegerProperty price;
    @SerializedName("depart_date")
    @Expose
    private SimpleStringProperty departDate;
    @SerializedName("transfers")
    @Expose
    private SimpleIntegerProperty transfers;
    @SerializedName("duration")
    @Expose
    private SimpleIntegerProperty duration;

    @SerializedName("gate")
    @Expose
    private SimpleStringProperty gate;

    public String getOrigin() {
        return origin.get();
    }

    public void setOrigin(String origin) {
        this.origin = new SimpleStringProperty(origin);
    }

    public String getDestination() {
        return destination.get();
    }

    public void setDestination(String destination) {
        this.destination = new SimpleStringProperty(destination);
    }

    public Integer getPrice() {
        return price.get();
    }

    public void setPrice(Integer price) {
        this.price = new SimpleIntegerProperty(price);
    }

    public String getDepartDate() {
        return departDate.get();
    }

    public void setDepartDate(String departDate) {
        this.departDate = new SimpleStringProperty(departDate);
    }

    public Integer getTransfers() {
        return transfers.get();
    }

    public void setTransfers(Integer transfers) {
        this.transfers = new SimpleIntegerProperty(transfers);
    }

    public Integer getDuration() {
        return duration.get();
    }

    public void setDuration(Integer duration) {
        this.duration = new SimpleIntegerProperty(duration);
    }

    public String getGate() {
        return gate.get();
    }

    public void setGate(String gate) {
        this.gate = new SimpleStringProperty(gate);
    }

}