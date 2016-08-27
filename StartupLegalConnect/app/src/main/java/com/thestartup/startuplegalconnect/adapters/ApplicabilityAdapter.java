package com.thestartup.startuplegalconnect.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
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

        CardView card = (CardView) rowView.findViewById(R.id.applicability_item);
        card.setCardBackgroundColor(getViewBackgroundColor(position));

        TextView tv = (TextView) rowView.findViewById(R.id.item_text);
        tv.setText(result[position]);
        ImageView img = (ImageView) rowView.findViewById(R.id.item_image);
        img.setImageResource(imageId[position]);

        return rowView;
    }

    private int getViewBackgroundColor(final int position) {
        int rem = position % 4;
        switch(rem)
        {
            case 0: return context.getResources().getColor(R.color.blue_50);
            case 1: return context.getResources().getColor(R.color.amber_50);
            case 2: return context.getResources().getColor(R.color.red_100);
            case 3: return context.getResources().getColor(R.color.green_100);
            default: return context.getResources().getColor(R.color.white);
        }
    }
}
