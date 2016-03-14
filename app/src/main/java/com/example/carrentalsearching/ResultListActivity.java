package com.example.carrentalsearching;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.carrentalsearching.adapters.CarResultAdapter;
import com.example.carrentalsearching.tasks.CarResultTask;
import com.example.carrentalsearching.model.HotWireResult;
import com.example.carrentalsearching.model.Request;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class ResultListActivity extends Activity{

    CarResultAdapter mAdapter;
    ListView mListView;

    ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        mListView = (ListView) findViewById(R.id.categoryLstView);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressBar.setVisibility(View.VISIBLE);

        Intent i = getIntent();
        Request r = null;
        if (i != null) {
            r = (Request) i.getSerializableExtra(Request.REQUEST_EXTRA);
            Log.d("TAG", "Request:"+r);
        }

        mAdapter = new CarResultAdapter(this);

        mListView.setAdapter(mAdapter);
        new CarResultTask(this).execute(r);

    }

    public void onLoaded(HotWireResult r) {
        mProgressBar.setVisibility(View.GONE);
        if (r == null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Something went wrong")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            ResultListActivity.this.finish();
                        }
                    });
            builder.create().show();
        } else {
            mAdapter.setResult(r);
        }

    }
}
