package com.thestartup.startuplegalconnect.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.viewmodels.IStepsViewModel;

import java.util.ArrayList;

/**
 * Created by sai on 8/27/16.
 */
public class CyberLawStepsAdapter extends RecyclerView.Adapter<CyberLawStepsAdapter.PolicyViewHolder> {
    private final ArrayList<IStepsViewModel> viewModels;
    private final Context context;

    public CyberLawStepsAdapter(Context context, ArrayList<IStepsViewModel> viewModels) {
        this.viewModels = viewModels;
        this.context = context;
    }

    @Override
    public PolicyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cyber_law_essentials_row, parent, false);
        return new PolicyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PolicyViewHolder holder, int position) {
        holder.policyMessage.setText(viewModels.get(position).getStepMessage());
        holder.view.setBackgroundColor(viewModels.get(position).getStatusForStep() == IStepsViewModel.POLICY_STATUS.complete ? context.getResources().getColor(R.color.green_200)
                : context.getResources().getColor(R.color.red_200));
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public void setCompliantStatus(int position) {
        viewModels.get(position).setPolicyStatus(IStepsViewModel.POLICY_STATUS.complete);
    }

    public void setNonCompliantStatus(int position) {
        viewModels.get(position).setPolicyStatus(IStepsViewModel.POLICY_STATUS.incomplete);
    }


    public class PolicyViewHolder extends RecyclerView.ViewHolder{
        TextView policyMessage;
        View view;
        public PolicyViewHolder(View view) {
            super(view);
            this.view = view;
            policyMessage = (TextView)view.findViewById(R.id.cyberLawPolicyTextView);
        }
    }
}
