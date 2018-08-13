package com.example.mostafaeisam.findstation3.classes;

public class Station {
    private String title;
    private String address;
    private int rating;
    private GetPositionOfStation position;
    private boolean isActive;
    private String createdOn;
    private boolean hasMasjid;
    private boolean hasRadio;
    private boolean hasATM;
    private boolean hasRest;
    private boolean hasCafe;
    private boolean hasMarket;
    private boolean hasRestaurant;
    private boolean hasHotel;
    private boolean hasLadiesWC;
    private boolean hasMensWC;
    private boolean isGas91Available;
    private boolean isGas95Available;
    private double gas91Price;
    private double gas95Price;
    private double dieselPrice;
    private boolean isDieselAvailable;
    private String id;
    private String gasCompanyId;
    private String currencyId;
    private int iid;
    private String title_ar;
    private String address_ar;
    private GetCompanyOfStation company;
    private GetCurrencyOfStation currency;


    public Station(String title, String address, int rating, GetPositionOfStation position) {
        this.title = title;
        this.address = address;
        this.rating = rating;
        this.position = position;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public GetPositionOfStation getPosition() {
        return position;
    }

    public void setPosition(GetPositionOfStation position) {
        this.position = position;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isHasMasjid() {
        return hasMasjid;
    }

    public void setHasMasjid(boolean hasMasjid) {
        this.hasMasjid = hasMasjid;
    }

    public boolean isHasRadio() {
        return hasRadio;
    }

    public void setHasRadio(boolean hasRadio) {
        this.hasRadio = hasRadio;
    }

    public boolean isHasATM() {
        return hasATM;
    }

    public void setHasATM(boolean hasATM) {
        this.hasATM = hasATM;
    }

    public boolean isHasRest() {
        return hasRest;
    }

    public void setHasRest(boolean hasRest) {
        this.hasRest = hasRest;
    }

    public boolean isHasCafe() {
        return hasCafe;
    }

    public void setHasCafe(boolean hasCafe) {
        this.hasCafe = hasCafe;
    }

    public boolean isHasMarket() {
        return hasMarket;
    }

    public void setHasMarket(boolean hasMarket) {
        this.hasMarket = hasMarket;
    }

    public boolean isHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(boolean hasRestaurant) {
        this.hasRestaurant = hasRestaurant;
    }

    public boolean isHasHotel() {
        return hasHotel;
    }

    public void setHasHotel(boolean hasHotel) {
        this.hasHotel = hasHotel;
    }

    public boolean isHasLadiesWC() {
        return hasLadiesWC;
    }

    public void setHasLadiesWC(boolean hasLadiesWC) {
        this.hasLadiesWC = hasLadiesWC;
    }

    public boolean isHasMensWC() {
        return hasMensWC;
    }

    public void setHasMensWC(boolean hasMensWC) {
        this.hasMensWC = hasMensWC;
    }

    public boolean isGas91Available() {
        return isGas91Available;
    }

    public void setGas91Available(boolean gas91Available) {
        isGas91Available = gas91Available;
    }

    public boolean isGas95Available() {
        return isGas95Available;
    }

    public void setGas95Available(boolean gas95Available) {
        isGas95Available = gas95Available;
    }

    public double getGas91Price() {
        return gas91Price;
    }

    public void setGas91Price(double gas91Price) {
        this.gas91Price = gas91Price;
    }

    public double getGas95Price() {
        return gas95Price;
    }

    public void setGas95Price(double gas95Price) {
        this.gas95Price = gas95Price;
    }

    public double getDieselPrice() {
        return dieselPrice;
    }

    public void setDieselPrice(double dieselPrice) {
        this.dieselPrice = dieselPrice;
    }

    public boolean isDieselAvailable() {
        return isDieselAvailable;
    }

    public void setDieselAvailable(boolean dieselAvailable) {
        isDieselAvailable = dieselAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGasCompanyId() {
        return gasCompanyId;
    }

    public void setGasCompanyId(String gasCompanyId) {
        this.gasCompanyId = gasCompanyId;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public int getIid() {
        return iid;
    }

    public void setIid(int iid) {
        this.iid = iid;
    }

    public String getTitle_ar() {
        return title_ar;
    }

    public void setTitle_ar(String title_ar) {
        this.title_ar = title_ar;
    }

    public String getAddress_ar() {
        return address_ar;
    }

    public void setAddress_ar(String address_ar) {
        this.address_ar = address_ar;
    }

    public GetCompanyOfStation getCompany() {
        return company;
    }

    public void setCompany(GetCompanyOfStation company) {
        this.company = company;
    }

    public GetCurrencyOfStation getCurrency() {
        return currency;
    }

    public void setCurrency(GetCurrencyOfStation currency) {
        this.currency = currency;
    }
}
