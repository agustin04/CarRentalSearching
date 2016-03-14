package com.example.carrentalsearching.model;

import com.example.carrentalsearching.R;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class Category {
    private String name;
    private String imagePath;
    private int resourceId;
    private Request request;

    public Category() {}

    public Category(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
        this.request = createDefaultRequest();
    }

    public Category(String name, int resourceId) {
        this.resourceId = resourceId;
        this.name = name;
        this.imagePath = "android.resource://com.example.carrentalsearching/" + resourceId;
        this.request = createDefaultRequest();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Request getRequest() {
        if (request == null) {
            request = createDefaultRequest();
        }
        return request;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    //date = 03/23/2016 time=13:30
    private Request createDefaultRequest() {
        if (name == null)
            return null;

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        calendar.add(Calendar.DATE, 1);
        String startDate = dateFormat.format(calendar.getTime());

        calendar.add(Calendar.DATE, 5);
        String endDate = dateFormat.format(calendar.getTime());

        Request request = new Request(name, startDate, endDate, "12:00", "12:00");

        return request;
    }

    public static List<Category> createDefaultCategoryList() {
        List<Category> list = new ArrayList<Category>();
        list.add(new Category("Boston", R.drawable.boston_skyline));
        list.add(new Category("New York", R.drawable.newyork_skyline));
        list.add(new Category("San Francisco", R.drawable.san_francisco));
        list.add(new Category("Denver", R.drawable.denver_skyline));
        list.add(new Category("San Diego", R.drawable.san_diego_skyline));
        list.add(new Category("Seattle", R.drawable.seattle));

        return list;
    }
}
