package com.example.carrentalsearching.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class CarType {
    @SerializedName("TypicalSeating")
    @Expose
    private String typicalSeating;

    @SerializedName("CarTypeName")
    @Expose
    private String carTypeName;

    @SerializedName("CarTypeCode")
    @Expose
    private String carTypeCode;

    @SerializedName("PossibleFeatures")
    @Expose
    private String possibleFeatures;

    @SerializedName("PossibleModels")
    @Expose
    private String possibleModels;

    public CarType() {}

    public CarType(String typicalSeating, String carTypeName, String carTypeCode, String possibleFeatures, String possibleModels) {
        this.typicalSeating = typicalSeating;
        this.carTypeName = carTypeName;
        this.carTypeCode = carTypeCode;
        this.possibleFeatures = possibleFeatures;
        this.possibleModels = possibleModels;
    }

    public String getTypicalSeating() {
        return typicalSeating;
    }

    public void setTypicalSeating(String typicalSeating) {
        this.typicalSeating = typicalSeating;
    }

    public String getCarTypeName() {
        return carTypeName;
    }

    public void setCarTypeName(String carTypeName) {
        this.carTypeName = carTypeName;
    }

    public String getCarTypeCode() {
        return carTypeCode;
    }

    public void setCarTypeCode(String carTypeCode) {
        this.carTypeCode = carTypeCode;
    }

    public String getPossibleFeatures() {
        return possibleFeatures;
    }

    public void setPossibleFeatures(String possibleFeatures) {
        this.possibleFeatures = possibleFeatures;
    }

    public String getPossibleModels() {
        return possibleModels;
    }

    public void setPossibleModels(String possibleModels) {
        this.possibleModels = possibleModels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarType carType = (CarType) o;

        if (typicalSeating != null ? !typicalSeating.equals(carType.typicalSeating) : carType.typicalSeating != null)
            return false;
        if (carTypeName != null ? !carTypeName.equals(carType.carTypeName) : carType.carTypeName != null)
            return false;
        if (carTypeCode != null ? !carTypeCode.equals(carType.carTypeCode) : carType.carTypeCode != null)
            return false;
        if (possibleFeatures != null ? !possibleFeatures.equals(carType.possibleFeatures) : carType.possibleFeatures != null)
            return false;
        return !(possibleModels != null ? !possibleModels.equals(carType.possibleModels) : carType.possibleModels != null);

    }

    @Override
    public int hashCode() {
        int result = typicalSeating != null ? typicalSeating.hashCode() : 0;
        result = 31 * result + (carTypeName != null ? carTypeName.hashCode() : 0);
        result = 31 * result + (carTypeCode != null ? carTypeCode.hashCode() : 0);
        result = 31 * result + (possibleFeatures != null ? possibleFeatures.hashCode() : 0);
        result = 31 * result + (possibleModels != null ? possibleModels.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CarType{" +
                "typicalSeating='" + typicalSeating + '\'' +
                ", carTypeName='" + carTypeName + '\'' +
                ", carTypeCode='" + carTypeCode + '\'' +
                ", possibleFeatures='" + possibleFeatures + '\'' +
                ", possibleModels='" + possibleModels + '\'' +
                '}';
    }
}
