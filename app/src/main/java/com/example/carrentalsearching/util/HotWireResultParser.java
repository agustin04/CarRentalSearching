package com.example.carrentalsearching.util;

import android.app.ActivityManager;

import com.example.carrentalsearching.model.CarRentalResult;
import com.example.carrentalsearching.model.HotWireResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class HotWireResultParser {
    public static HotWireResult parseJson (String json) {
        if (json == null || json.isEmpty()) {
            return null;
        }

        HotWireResult hotWireResult = null;

        try {
            JSONObject jsonObj = new JSONObject(json);
            String status = jsonObj.getString("StatusCode");

            if (status == null || status.isEmpty() || !status.equals("0")) {
                return null;
            }

            hotWireResult = new HotWireResult();
            hotWireResult.setResult(getResultList(jsonObj));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return hotWireResult;
    }

    public static List<CarRentalResult> getResultList (JSONObject jsonObj) throws JSONException{
        if (jsonObj == null) {
            return null;
        }

        JSONArray array = jsonObj.getJSONArray("Result");
        List<CarRentalResult> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++) {
            CarRentalResult r = getResult(array.getJSONObject(i));
            if (r != null) {
                list.add(r);
            }
        }
        return list;
    }

    public static CarRentalResult getResult(JSONObject json) throws JSONException {
        if (json == null) {
            return null;
        }

        String currencyCode = json.getString("CurrencyCode");
        String deepLink = json.getString("DeepLink");
        String ResultId = json.getString("ResultId");
        String HWRefNumber = json.getString("HWRefNumber");
        String SubTotal = json.getString("SubTotal");
        String TaxesAndFees = json.getString("TaxesAndFees");
        String TotalPrice = json.getString("TotalPrice");
        String CarTypeCode = json.getString("CarTypeCode");
        String DailyRate = json.getString("DailyRate");
        String DropoffDay = json.getString("DropoffDay");
        String DropoffTime = json.getString("DropoffTime");
        String PickupDay = json.getString("PickupDay");
        String PickupTime = json.getString("PickupTime");
        String LocationDescription = json.getString("LocationDescription");
        String MileageDescription = json.getString("MileageDescription");
        String PickupAirport = json.getString("PickupAirport");
        String RentalDays = json.getString("RentalDays");

        CarRentalResult r = new CarRentalResult();
        r.setCurrencyCode(currencyCode);
        r.setDeepLink(deepLink);
        r.setResultId(ResultId);
        r.setHWRefNumber(HWRefNumber);
        r.setSubTotal(Float.parseFloat(SubTotal));
        r.setTaxesAndFees(Float.parseFloat(TaxesAndFees));
        r.setTotalPrice(Float.parseFloat(TotalPrice));
        r.setCarTypeCode(CarTypeCode);
        r.setDailyRate(Float.parseFloat(DailyRate));
        r.setDropoffDay(DropoffDay);
        r.setDropoffTime(DropoffTime);
        r.setPickupDay(PickupDay);
        r.setPickupTime(PickupTime);
        r.setLocationDescription(LocationDescription);
        r.setMileageDescription(MileageDescription);
        r.setPickupAirport(PickupAirport);
        r.setRentalDays(Integer.parseInt(RentalDays));

        return r;
    }
}
