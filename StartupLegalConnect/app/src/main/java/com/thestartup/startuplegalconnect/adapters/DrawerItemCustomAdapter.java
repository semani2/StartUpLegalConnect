package com.thestartup.startuplegalconnect.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.models.NavigationDrawerDataModel;

/**
 * Created by sai on 8/26/16.
 */
public class DrawerItemCustomAdapter extends ArrayAdapter<NavigationDrawerDataModel> {
    Context mContext;
    int layoutResourceId;
    NavigationDrawerDataModel data[] = null;

    public DrawerItemCustomAdapter(Context mContext, int layoutResourceId, NavigationDrawerDataModel[] data) {

        super(mContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItem = convertView;

        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        ImageView imageViewIcon = (ImageView) listItem.findViewById(R.id.imageViewIcon);
        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        NavigationDrawerDataModel folder = data[position];

        imageViewIcon.setImageResource(folder.icon);
        textViewName.setText(folder.name);

        return listItem;
    }
}
