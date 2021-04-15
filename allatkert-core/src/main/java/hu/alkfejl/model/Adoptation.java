package hu.alkfejl.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Adoptation {

    private IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private IntegerProperty adoptiveId = new SimpleIntegerProperty(this, "adoptiveId");
    private IntegerProperty animalId = new SimpleIntegerProperty(this, "animalId");
    private StringProperty date = new SimpleStringProperty(this, "date");
    private StringProperty donationType = new SimpleStringProperty(this, "donationType");
    private IntegerProperty donationValue = new SimpleIntegerProperty(this, "donationValue");
    private StringProperty donationFreq = new SimpleStringProperty(this, "donationFreq");

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getAdoptiveId() {
        return adoptiveId.get();
    }

    public IntegerProperty adoptiveIdProperty() {
        return adoptiveId;
    }

    public void setAdoptiveId(int adoptiveId) {
        this.adoptiveId.set(adoptiveId);
    }

    public int getAnimalId() {
        return animalId.get();
    }

    public IntegerProperty animalIdProperty() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId.set(animalId);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getDonationType() {
        return donationType.get();
    }

    public StringProperty donationTypeProperty() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType.set(donationType);
    }

    public int getDonationValue() {
        return donationValue.get();
    }

    public IntegerProperty donationValueProperty() {
        return donationValue;
    }

    public void setDonationValue(int donationValue) {
        this.donationValue.set(donationValue);
    }

    public String getDonationFreq() {
        return donationFreq.get();
    }

    public StringProperty donationFreqProperty() {
        return donationFreq;
    }

    public void setDonationFreq(String donationFreq) {
        this.donationFreq.set(donationFreq);
    }

    public enum Frequency {
        Once("Once"),
        Daily("Daily"),
        Weekly("Weekly"),
        Monthly("Monthly"),
        Yearly("Yearly");

        private final StringProperty value = new SimpleStringProperty(this, "value");

        Frequency(String value) {
            this.value.set(value);
        }

        public String getValue() {
            return value.get();
        }

        public StringProperty valueProperty() {
            return value;
        }

        @Override
        public String toString() {
            return getValue();
        }
    }
}
