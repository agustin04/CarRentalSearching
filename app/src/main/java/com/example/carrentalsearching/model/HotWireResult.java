package com.example.carrentalsearching.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class HotWireResult {
    @SerializedName("Errors")
    @Expose
    private List<Error> errors = new ArrayList<>();
    @SerializedName("StatusCode")
    @Expose
    private int statusCode;
    @SerializedName("StatusDesc")
    @Expose
    private String statusDesc;
    @SerializedName("MetaData")
    @Expose
    private CarMetaData metaData;
    @SerializedName("Result")
    @Expose
    private List<CarRentalResult> result = new ArrayList<>();

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    public CarMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(CarMetaData metaData) {
        this.metaData = metaData;
    }

    public List<CarRentalResult> getResult() {
        return result;
    }

    public void setResult(List<CarRentalResult> result) {
        this.result = result;
    }

    class CarMetaData {

        @SerializedName("CarTypes")
        @Expose
        private List<CarType> carTypes = new ArrayList<>();
        public CarMetaData() {}

        public List<CarType> getCarTypes() {
            return carTypes;
        }

        public void setCarTypes(List<CarType> carTypes) {
            this.carTypes = carTypes;
        }
    }
}
