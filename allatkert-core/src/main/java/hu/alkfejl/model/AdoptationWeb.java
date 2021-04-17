package hu.alkfejl.model;

public class AdoptationWeb {

    private int id;
    private int adoptiveId;
    private int animalId;
    private String date;
    private String donationType;
    private int donationValue;
    private String donationFreq;

    public AdoptationWeb(int id, int adoptiveId, int animalId, String date, String donationType, int donationValue, String donationFreq) {
        this.id = id;
        this.adoptiveId = adoptiveId;
        this.animalId = animalId;
        this.date = date;
        this.donationType = donationType;
        this.donationValue = donationValue;
        this.donationFreq = donationFreq;
    }

    public AdoptationWeb(int adoptiveId, int animalId, String date, String donationType, int donationValue, String donationFreq) {
        this.adoptiveId = adoptiveId;
        this.animalId = animalId;
        this.date = date;
        this.donationType = donationType;
        this.donationValue = donationValue;
        this.donationFreq = donationFreq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdoptiveId() {
        return adoptiveId;
    }

    public void setAdoptiveId(int adoptiveId) {
        this.adoptiveId = adoptiveId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public int getDonationValue() {
        return donationValue;
    }

    public void setDonationValue(int donationValue) {
        this.donationValue = donationValue;
    }

    public String getDonationFreq() {
        return donationFreq;
    }

    public void setDonationFreq(String donationFreq) {
        this.donationFreq = donationFreq;
    }
}
