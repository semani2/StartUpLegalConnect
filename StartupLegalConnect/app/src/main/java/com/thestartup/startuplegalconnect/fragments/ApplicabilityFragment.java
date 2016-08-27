package com.thestartup.startuplegalconnect.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.thestartup.startuplegalconnect.HomeActivity;
import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.adapters.ApplicabilityAdapter;

public class ApplicabilityFragment extends Fragment {

    GridView gv;
    Context context;
    public static String [] applicabilityList;
    public static int [] applicabilityImages = {
            R.mipmap.ic_local_grocery_store_black_24dp,
            R.mipmap.ic_local_mall_black_24dp,
            R.mipmap.ic_local_hospital_black_24dp,
            R.mipmap.ic_gavel_black_24dp,
            R.mipmap.ic_web_black_24dp,
            R.mipmap.ic_smartphone_black_24dp,
            R.mipmap.ic_cloud_black_24dp,
            R.mipmap.ic_device_hub_black_24dp,
            R.mipmap.ic_important_devices_black_24dp,
            R.mipmap.ic_restaurant_black_24dp,
            R.mipmap.ic_show_chart_black_24dp,
            R.mipmap.ic_local_florist_black_24dp,
            R.mipmap.ic_location_on_black_24dp,
            R.mipmap.ic_storage_black_24dp,
            R.mipmap.ic_flight_black_24dp,
            R.mipmap.ic_account_balance_wallet_black_24dp,
            R.mipmap.ic_insert_comment_black_24dp,
            R.mipmap.ic_loyalty_black_24dp
    };

    public ApplicabilityFragment() {
        // Required empty public constructor
    }

    private void getItemStrings()
    {
        applicabilityList = new String[] {
                context.getResources().getString(R.string.commerce),
                context.getResources().getString(R.string.market_places),
                context.getResources().getString(R.string.health_care),
                context.getResources().getString(R.string.auction_portal),
                context.getResources().getString(R.string.websites),
                context.getResources().getString(R.string.mobile_apps),
                context.getResources().getString(R.string.cloud_based),
                context.getResources().getString(R.string.iot),
                context.getResources().getString(R.string.websites_mobile),
                context.getResources().getString(R.string.food_tech),
                context.getResources().getString(R.string.fin_tech),
                context.getResources().getString(R.string.agri_tech),
                context.getResources().getString(R.string.on_demand),
                context.getResources().getString(R.string.big_data),
                context.getResources().getString(R.string.online_travel),
                context.getResources().getString(R.string.online_wallets),
                context.getResources().getString(R.string.blog),
                context.getResources().getString(R.string.fashion)
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_applicability, container, false);
        context = getContext();
        getItemStrings();
        gv = (GridView) view.findViewById(R.id.applicabilityListGridView);
        gv.setAdapter(new ApplicabilityAdapter((HomeActivity) this.getActivity(), applicabilityList, applicabilityImages));
        return view;
    }
}
