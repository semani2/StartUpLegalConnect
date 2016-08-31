package com.thestartup.startuplegalconnect.fragments;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.adapters.CyberLawPoliciesAdapter;
import com.thestartup.startuplegalconnect.viewmodels.CyberLawPolicyViewModel;
import com.thestartup.startuplegalconnect.viewmodels.ICyberLawPolicyViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CyberLawEssentialsFragment extends Fragment {
    private CyberLawPoliciesAdapter policiesAdapter;
    private RecyclerView recyclerView;
    private TextView textView;
    private int edit_position;
    private View view;
    private Paint p = new Paint();
    private ArrayList<ICyberLawPolicyViewModel> viewModels = new ArrayList<>();
    public CyberLawEssentialsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cyber_law_essentials, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.cyberLawRecyclerView);
        //recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        policiesAdapter = new CyberLawPoliciesAdapter(getContext(), getPolicyViewModels());
        recyclerView.setAdapter(policiesAdapter);
        initSwipe();
        return view;
    }

    private void initSwipe() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT){
                    policiesAdapter.setNonCompliantStatus(position);
                    edit_position = position;
                } else {
                    policiesAdapter.setCompliantStatus(position);
                    edit_position = position;
                }
                policiesAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {

                Bitmap icon;
                if(actionState == ItemTouchHelper.ACTION_STATE_SWIPE){

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;

                    if(dX > 0){
                        p.setColor(getResources().getColor(R.color.green_100));
                        RectF background = new RectF((float) itemView.getLeft(), (float) itemView.getTop(), dX,(float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_done_white_24dp);
                        RectF icon_dest = new RectF((float) itemView.getLeft() + width ,(float) itemView.getTop() + width,(float) itemView.getLeft()+ 2*width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    } else {
                        p.setColor(getResources().getColor(R.color.red_100));
                        RectF background = new RectF((float) itemView.getRight() + dX, (float) itemView.getTop(),(float) itemView.getRight(), (float) itemView.getBottom());
                        c.drawRect(background,p);
                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_clear_white_24dp);
                        RectF icon_dest = new RectF((float) itemView.getRight() - 2*width ,(float) itemView.getTop() + width,(float) itemView.getRight() - width,(float)itemView.getBottom() - width);
                        c.drawBitmap(icon,null,icon_dest,p);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private ArrayList<ICyberLawPolicyViewModel> getPolicyViewModels() {
        ArrayList<ICyberLawPolicyViewModel> viewModels = new ArrayList<>();
        viewModels.add(new CyberLawPolicyViewModel(getContext().getResources().getString(R.string.strPrivacyPolicy), ICyberLawPolicyViewModel.CYBER_LAW_POLICIES.PRIVACY_POLICY));
        viewModels.add(new CyberLawPolicyViewModel(getContext().getResources().getString(R.string.strTOU), ICyberLawPolicyViewModel.CYBER_LAW_POLICIES.TERMS_OF_USE));
        viewModels.add(new CyberLawPolicyViewModel(getContext().getResources().getString(R.string.strGrievanceMechanism), ICyberLawPolicyViewModel.CYBER_LAW_POLICIES.GRIEVANCE_MECHANISM));
        viewModels.add(new CyberLawPolicyViewModel(getContext().getResources().getString(R.string.strComplianceAgreement), ICyberLawPolicyViewModel.CYBER_LAW_POLICIES.CYBER_LAW_COMPLIANCE_AGREEMENT));
        viewModels.add(new CyberLawPolicyViewModel(getContext().getResources().getString(R.string.strLegalDisclaimer), ICyberLawPolicyViewModel.CYBER_LAW_POLICIES.LEGAL_DISCLAIMER));

        return viewModels;
    }

}
