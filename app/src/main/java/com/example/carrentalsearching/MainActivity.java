package com.example.carrentalsearching;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.carrentalsearching.adapters.CategoryAdapter;
import com.example.carrentalsearching.model.Category;
import com.example.carrentalsearching.model.Request;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView mCategoryListView;
    private CategoryAdapter mAdapter;

    // Get the current date
    private Calendar mCalendar = Calendar.getInstance();
    private DateFormat mDateFormater = new SimpleDateFormat("MM/dd/yyyy");
    private int mYear = mCalendar.get(Calendar.YEAR);
    private int mMonth = mCalendar.get(Calendar.MONTH);
    private int mDay = mCalendar.get(Calendar.DAY_OF_MONTH);

    static final int DATE_DIALOG_ID = 0;
    static final int CUSTOM_DIALOG = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(CUSTOM_DIALOG);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mCategoryListView = (ListView) findViewById(R.id.categoryLstView);
        mCategoryListView.setOnItemClickListener(mOnItemClickListener);

        mAdapter = new CategoryAdapter(Category.createDefaultCategoryList(), this);
        mCategoryListView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            // Handle the camera action
            Toast.makeText(this.getApplicationContext(), "Not supported yet", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_settings) {
            Toast.makeText(this.getApplicationContext(), "Not supported yet", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Category c = mAdapter.getItem(position);
            Request r = c.getRequest();
            searchCars(r);
        }
    };

    public void searchCars (Request r) {
        if (isNetworkConnected()) {
            Intent i = new Intent(MainActivity.this, ResultListActivity.class);
            i.putExtra(Request.REQUEST_EXTRA, r);
            startActivity(i);
        } else {
            Toast.makeText(this.getApplicationContext(), "No internet connection", Toast.LENGTH_LONG).show();
        }
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mYear = year;
            mMonth = monthOfYear;
            mDay = dayOfMonth;

        }
    };

    // Create and return DatePickerDialog
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this, mDateSetListener, mYear, mMonth,
                        mDay);
            case CUSTOM_DIALOG:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                // Get the layout inflater
                LayoutInflater inflater = this.getLayoutInflater();

                View view = inflater.inflate(R.layout.search_dialog, null);
                final EditText pickUpDate = (EditText) view.findViewById(R.id.pickUpDate);
                final EditText dropOffDate = (EditText) view.findViewById(R.id.dropOffDate);
                final EditText destination = (EditText) view.findViewById(R.id.destinationId);

                pickUpDate.setText(mDateFormater.format(mCalendar.getTime()));
                dropOffDate.setText(mDateFormater.format(mCalendar.getTime()));
                pickUpDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String date = getDateString(dayOfMonth, monthOfYear, year);
                                pickUpDate.setText(date);
                            }
                        }, mYear, mMonth,
                                mDay).show();
                    }
                });
                pickUpDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            v.performClick();
                        }
                    }
                });

                dropOffDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                String date = getDateString(dayOfMonth, monthOfYear, year);
                                dropOffDate.setText(date);
                            }
                        }, mYear, mMonth,
                                mDay).show();
                    }
                });
                dropOffDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            v.performClick();
                        }
                    }
                });

                builder.setView(view)
                        // Add action buttons
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                String destinationStr = destination.getText().toString();
                                String startDate = pickUpDate.getText().toString();
                                String endDate = dropOffDate.getText().toString();
                                Request r = new Request(destinationStr, startDate, endDate, "12:00", "12:00");
                                MainActivity.this.searchCars(r);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                            }
                        });
                return builder.create();
        }
        return null;
    }

    public static String getDateString(int day, int month, int year) {
        //adding one because it starts from 0
        month +=1;
        String dayStr = day < 10 ? "0" + day : ""+day;
        String monthStr = month < 10 ? "0" + month : ""+month;
        return monthStr+"/"+dayStr+"/"+year;

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
}
