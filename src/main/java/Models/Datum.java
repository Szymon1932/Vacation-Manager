package Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("value")
    @Expose
    private Integer value;
    @SerializedName("trip_class")
    @Expose
    private Integer tripClass;
    @SerializedName("show_to_affiliates")
    @Expose
    private Boolean showToAffiliates;
    @SerializedName("origin")
    @Expose
    private String origin;
    @SerializedName("destination")
    @Expose
    private String destination;
    @SerializedName("gate")
    @Expose
    private String gate;
    @SerializedName("depart_date")
    @Expose
    private String departDate;
    @SerializedName("return_date")
    @Expose
    private String returnDate;
    @SerializedName("number_of_changes")
    @Expose
    private Integer numberOfChanges;
    @SerializedName("found_at")
    @Expose
    private String foundAt;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("distance")
    @Expose
    private Integer distance;
    @SerializedName("actual")
    @Expose
    private Boolean actual;

    public Datum() {
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getTripClass() {
        return tripClass;
    }

    public void setTripClass(Integer tripClass) {
        this.tripClass = tripClass;
    }

    public Boolean getShowToAffiliates() {
        return showToAffiliates;
    }

    public void setShowToAffiliates(Boolean showToAffiliates) {
        this.showToAffiliates = showToAffiliates;
    }

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

    public String getGate() {
        return gate;
    }

    public void setGate(String gate) {
        this.gate = gate;
    }

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getNumberOfChanges() {
        return numberOfChanges;
    }

    public void setNumberOfChanges(Integer numberOfChanges) {
        this.numberOfChanges = numberOfChanges;
    }

    public String getFoundAt() {
        return foundAt;
    }

    public void setFoundAt(String foundAt) {
        this.foundAt = foundAt;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Boolean getActual() {
        return actual;
    }

    public void setActual(Boolean actual) {
        this.actual = actual;
    }

}