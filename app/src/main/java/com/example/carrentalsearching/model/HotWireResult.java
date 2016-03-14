package com.example.carrentalsearching.model;

import java.util.List;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class HotWireResult {
    private List<Error> error;
    private int statusCode;
    private String statusDesc;
    private CarMetaData metaData;
    private List<CarRentalResult> result;

    public List<Error> getError() {
        return error;
    }

    public void setError(List<Error> error) {
        this.error = error;
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
        private List<CarType> carTypes;
        public CarMetaData() {}

        public List<CarType> getCarTypes() {
            return carTypes;
        }

        public void setCarTypes(List<CarType> carTypes) {
            this.carTypes = carTypes;
        }
    }
}
