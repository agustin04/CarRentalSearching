package com.example.carrentalsearching.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.carrentalsearching.R;
import com.example.carrentalsearching.model.CarRentalResult;
import com.example.carrentalsearching.model.HotWireResult;

import java.util.List;

/**
 * Created by agustinmartinez on 3/13/16.
 */
public class CarResultAdapter extends BaseAdapter {

    private List<CarRentalResult> mList;
    private Context mContext;

    public CarResultAdapter(Context context) {
        mContext = context;
    }

    public void setResult(HotWireResult r) {
        if (r != null) {
            mList = r.getResult();
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    @Override
    public Object getItem(int position) {
        if (mList == null) {
            return null;
        } else {
            return mList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        if (mList == null || position < 0 || position >= mList.size()) {
            return -1;
        } else {
            return position;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.car_result, parent, false);
            vh = new ViewHolder(convertView);

            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        if (mList != null) {
            CarRentalResult c = mList.get(position);

            vh.price.setText(c == null ? "$ --.-" : "$ "+c.getDailyRate()+ " per day");
        }

        return convertView;
    }

    public static class ViewHolder {
        TextView price;
        public ViewHolder(View v) {
            price = (TextView) v.findViewById(R.id.price);
        }
    }
}
