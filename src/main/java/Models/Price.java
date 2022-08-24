package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Price {

    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("main_airline")
    @Expose
    private String mainAirline;
    @SerializedName("depart_date")
    @Expose
    private String departDate;
    @SerializedName("transfers")
    @Expose
    private Integer transfers;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("found_at")
    @Expose
    private String foundAt;
    @SerializedName("gate")
    @Expose
    private String gate;
    @SerializedName("trip_class")
    @Expose
    private Integer tripClass;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getMainAirline() {
        return mainAirline;
    }

    public void setMainAirline(String mainAirline) {
        this.mainAirline = mainAirline;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public Integer getTransfers() {
        return transfers;
    }

    public void setTransfers(Integer transfers) {
        this.transfers = transfers;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(String foundAt) {
        this.foundAt = foundAt;
    }

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public Integer getTripClass() {
        return tripClass;
    }

    public void setTripClass(Integer tripClass) {
        this.tripClass = tripClass;
    }

}