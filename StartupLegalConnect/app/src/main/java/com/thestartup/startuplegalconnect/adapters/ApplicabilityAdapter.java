package com.thestartup.startuplegalconnect.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.HomeActivity;
import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.fragments.ApplicabilityFragment;

/**
 * Created by Gaurav on 8/27/2016.
 */
public class ApplicabilityAdapter extends BaseAdapter {

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater = null;

    public ApplicabilityAdapter(HomeActivity activity, String[] applicabilityList, int[] applicabilityImages)
    {
        result = applicabilityList;
        imageId = applicabilityImages;
        context = activity;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = inflater.inflate(R.layout.applicability_item_layout, null);
        TextView tv = (TextView) rowView.findViewById(R.id.item_text);
        tv.setText(result[position]);
        ImageView img = (ImageView) rowView.findViewById(R.id.item_image);
        img.setImageResource(imageId[position]);

        return rowView;
    }
}
