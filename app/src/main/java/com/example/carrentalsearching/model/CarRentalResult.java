package com.example.carrentalsearching.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class CarRentalResult {
    @SerializedName("CurrencyCode")
    @Expose
    private String currencyCode;

    @SerializedName("DeepLink")
    @Expose
    private String DeepLink;

    @SerializedName("ResultId")
    @Expose
    private String resultId;

    @SerializedName("HWRefNumber")
    @Expose
    private String HWRefNumber;

    @SerializedName("SubTotal")
    @Expose
    private float subTotal;

    @SerializedName("TaxesAndFees")
    @Expose
    private float taxesAndFees;

    @SerializedName("TotalPrice")
    @Expose
    private float totalPrice;

    @SerializedName("CarTypeCode")
    @Expose
    private String carTypeCode;

    @SerializedName("DailyRate")
    @Expose
    private float dailyRate;

    @SerializedName("DropoffDay")
    @Expose
    private String dropoffDay;

    @SerializedName("DropoffTime")
    @Expose
    private String dropoffTime;

    @SerializedName("PickupDay")
    @Expose
    private String pickupDay;

    @SerializedName("PickupTime")
    @Expose
    private String pickupTime;

    @SerializedName("LocationDescription")
    @Expose
    private String locationDescription;

    @SerializedName("MileageDescription")
    @Expose
    private String mileageDescription;

    @SerializedName("PickupAirport")
    @Expose
    private String pickupAirport;

    @SerializedName("RentalDays")
    @Expose
    private int rentalDays;

    public CarRentalResult() {}
    //http://api.hotwire.com/v1/search/car?apikey=vhpmvxkk69775r9vgyzncj3x&dest=LAX&startdate=03/20/2016&enddate=03/23/2016&pickuptime=10:00&dropofftime=13:30&format=JSON


    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getDeepLink() {
        return DeepLink;
    }

    public void setDeepLink(String deepLink) {
        DeepLink = deepLink;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getHWRefNumber() {
        return HWRefNumber;
    }

    public void setHWRefNumber(String HWRefNumber) {
        this.HWRefNumber = HWRefNumber;
    }

    public float getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(float subTotal) {
        this.subTotal = subTotal;
    }

    public float getTaxesAndFees() {
        return taxesAndFees;
    }

    public void setTaxesAndFees(float taxesAndFees) {
        this.taxesAndFees = taxesAndFees;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public float getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(float dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getDropoffDay() {
        return dropoffDay;
    }

    public void setDropoffDay(String dropoffDay) {
        this.dropoffDay = dropoffDay;
    }

    public String getDropoffTime() {
        return dropoffTime;
    }

    public void setDropoffTime(String dropoffTime) {
        this.dropoffTime = dropoffTime;
    }

    public String getPickupDay() {
        return pickupDay;
    }

    public void setPickupDay(String pickupDay) {
        this.pickupDay = pickupDay;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public String getMileageDescription() {
        return mileageDescription;
    }

    public void setMileageDescription(String mileageDescription) {
        this.mileageDescription = mileageDescription;
    }

    public String getPickupAirport() {
        return pickupAirport;
    }

    public void setPickupAirport(String pickupAirport) {
        this.pickupAirport = pickupAirport;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarRentalResult that = (CarRentalResult) o;

        if (Float.compare(that.subTotal, subTotal) != 0) return false;
        if (Float.compare(that.taxesAndFees, taxesAndFees) != 0) return false;
        if (Float.compare(that.totalPrice, totalPrice) != 0) return false;
        if (Float.compare(that.dailyRate, dailyRate) != 0) return false;
        if (rentalDays != that.rentalDays) return false;
        if (currencyCode != null ? !currencyCode.equals(that.currencyCode) : that.currencyCode != null)
            return false;
        if (DeepLink != null ? !DeepLink.equals(that.DeepLink) : that.DeepLink != null)
            return false;
        if (resultId != null ? !resultId.equals(that.resultId) : that.resultId != null)
            return false;
        if (HWRefNumber != null ? !HWRefNumber.equals(that.HWRefNumber) : that.HWRefNumber != null)
            return false;
        if (carTypeCode != null ? !carTypeCode.equals(that.carTypeCode) : that.carTypeCode != null)
            return false;
        if (dropoffDay != null ? !dropoffDay.equals(that.dropoffDay) : that.dropoffDay != null)
            return false;
        if (dropoffTime != null ? !dropoffTime.equals(that.dropoffTime) : that.dropoffTime != null)
            return false;
        if (pickupDay != null ? !pickupDay.equals(that.pickupDay) : that.pickupDay != null)
            return false;
        if (pickupTime != null ? !pickupTime.equals(that.pickupTime) : that.pickupTime != null)
            return false;
        if (locationDescription != null ? !locationDescription.equals(that.locationDescription) : that.locationDescription != null)
            return false;
        if (mileageDescription != null ? !mileageDescription.equals(that.mileageDescription) : that.mileageDescription != null)
            return false;
        return !(pickupAirport != null ? !pickupAirport.equals(that.pickupAirport) : that.pickupAirport != null);

    }

    @Override
    public int hashCode() {
        int result = currencyCode != null ? currencyCode.hashCode() : 0;
        result = 31 * result + (DeepLink != null ? DeepLink.hashCode() : 0);
        result = 31 * result + (resultId != null ? resultId.hashCode() : 0);
        result = 31 * result + (HWRefNumber != null ? HWRefNumber.hashCode() : 0);
        result = 31 * result + (subTotal != +0.0f ? Float.floatToIntBits(subTotal) : 0);
        result = 31 * result + (taxesAndFees != +0.0f ? Float.floatToIntBits(taxesAndFees) : 0);
        result = 31 * result + (totalPrice != +0.0f ? Float.floatToIntBits(totalPrice) : 0);
        result = 31 * result + (carTypeCode != null ? carTypeCode.hashCode() : 0);
        result = 31 * result + (dailyRate != +0.0f ? Float.floatToIntBits(dailyRate) : 0);
        result = 31 * result + (dropoffDay != null ? dropoffDay.hashCode() : 0);
        result = 31 * result + (dropoffTime != null ? dropoffTime.hashCode() : 0);
        result = 31 * result + (pickupDay != null ? pickupDay.hashCode() : 0);
        result = 31 * result + (pickupTime != null ? pickupTime.hashCode() : 0);
        result = 31 * result + (locationDescription != null ? locationDescription.hashCode() : 0);
        result = 31 * result + (mileageDescription != null ? mileageDescription.hashCode() : 0);
        result = 31 * result + (pickupAirport != null ? pickupAirport.hashCode() : 0);
        result = 31 * result + rentalDays;
        return result;
    }

    @Override
    public String toString() {
        return "CarRentalResult{" +
                "currencyCode='" + currencyCode + '\'' +
                ", DeepLink='" + DeepLink + '\'' +
                ", resultId='" + resultId + '\'' +
                ", HWRefNumber='" + HWRefNumber + '\'' +
                ", subTotal=" + subTotal +
                ", taxesAndFees=" + taxesAndFees +
                ", totalPrice=" + totalPrice +
                ", carTypeCode='" + carTypeCode + '\'' +
                ", dailyRate=" + dailyRate +
                ", dropoffDay='" + dropoffDay + '\'' +
                ", dropoffTime='" + dropoffTime + '\'' +
                ", pickupDay='" + pickupDay + '\'' +
                ", pickupTime='" + pickupTime + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", mileageDescription='" + mileageDescription + '\'' +
                ", pickupAirport='" + pickupAirport + '\'' +
                ", rentalDays=" + rentalDays +
                '}';
    }
}
