package com.thestartup.startuplegalconnect.fragments;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.adapters.CyberLawStepsAdapter;
import com.thestartup.startuplegalconnect.viewmodels.IStepsViewModel;
import com.thestartup.startuplegalconnect.viewmodels.StepsViewModel;

import java.util.ArrayList;

/**
 * Created by sai on 8/31/16.
 */
public class StepsCheckFragment extends DialogFragment {

    private CyberLawStepsAdapter stepsAdapter;
    private RecyclerView recyclerView;
    private TextView textView;
    private int edit_position;
    private View view;
    private Paint p = new Paint();
    private ArrayList<IStepsViewModel> viewModels = new ArrayList<>();
    String[] stepsForStartups = {
            "Business plan - document describing the execution of an idea, can be protected as per law",
            "Logo protection",
            "Founders agreement - protecting the interests of founders and company",
            "Outsourcing agreement with third party firms",
            "Product based legal documentation like policies, terms of use, etc",
            "Cyber law compliance for start-ups",
            "Legal agreements & contracts with clients and users.",
            "Digital & social media marketing agreements",
            "Employee agreements",
            "Adviser/Consultant agreement",
            "Non-disclosure agreement",
            "Protecting data and source code as per law.",
            "Intellectual property related agreements",
            "Investor agreements",
            "Term sheets",
            "Share Holders agreement"
    };
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CheckFragment);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_check_steps, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.cyberLawRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        stepsAdapter = new CyberLawStepsAdapter(getContext(), getStepsViewModels());
        recyclerView.setAdapter(stepsAdapter);

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
                    stepsAdapter.setNonCompliantStatus(position);
                    edit_position = position;
                } else {
                    stepsAdapter.setCompliantStatus(position);
                    edit_position = position;
                }
                stepsAdapter.notifyDataSetChanged();
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

    private ArrayList<IStepsViewModel> getStepsViewModels() {
        ArrayList<IStepsViewModel> viewModels = new ArrayList<>();
        viewModels.add(new StepsViewModel(stepsForStartups[0], IStepsViewModel.CYBER_LAW_STEPS.PROTECT_IDEA));
        viewModels.add(new StepsViewModel(stepsForStartups[1], IStepsViewModel.CYBER_LAW_STEPS.PROTECT_LOGO));
        viewModels.add(new StepsViewModel(stepsForStartups[2], IStepsViewModel.CYBER_LAW_STEPS.FOUNDERS_AGREEMENT));
        viewModels.add(new StepsViewModel(stepsForStartups[3], IStepsViewModel.CYBER_LAW_STEPS.OUTSOURCING_AGREEMENT));
        viewModels.add(new StepsViewModel(stepsForStartups[4], IStepsViewModel.CYBER_LAW_STEPS.PRODUCT_DOCUMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[5], IStepsViewModel.CYBER_LAW_STEPS.CYBER_LAW_COMPLIANCE));
        viewModels.add(new StepsViewModel(stepsForStartups[6], IStepsViewModel.CYBER_LAW_STEPS.LEGAL_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[7], IStepsViewModel.CYBER_LAW_STEPS.DIGITAL_MARKETING));
        viewModels.add(new StepsViewModel(stepsForStartups[8], IStepsViewModel.CYBER_LAW_STEPS.EMPLOYEE_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[9], IStepsViewModel.CYBER_LAW_STEPS.ADVISOR_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[10], IStepsViewModel.CYBER_LAW_STEPS.NON_DISCLOSURE_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[11], IStepsViewModel.CYBER_LAW_STEPS.PROTECT_DATA));
        viewModels.add(new StepsViewModel(stepsForStartups[12], IStepsViewModel.CYBER_LAW_STEPS.IP_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[13], IStepsViewModel.CYBER_LAW_STEPS.INVESTOR_AGREEMENTS));
        viewModels.add(new StepsViewModel(stepsForStartups[14], IStepsViewModel.CYBER_LAW_STEPS.TERM_SHEETS));
        viewModels.add(new StepsViewModel(stepsForStartups[15], IStepsViewModel.CYBER_LAW_STEPS.SHAREHOLDER_AGREEMENTS));

        return viewModels;
    }
}
