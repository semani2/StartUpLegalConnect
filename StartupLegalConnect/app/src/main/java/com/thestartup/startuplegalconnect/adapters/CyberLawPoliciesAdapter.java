package com.thestartup.startuplegalconnect.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.viewmodels.ICyberLawPolicyViewModel;

import java.util.ArrayList;

/**
 * Created by sai on 8/27/16.
 */
public class CyberLawPoliciesAdapter extends RecyclerView.Adapter<CyberLawPoliciesAdapter.PolicyViewHolder> {
    private final ArrayList<ICyberLawPolicyViewModel> viewModels;
    private final Context context;

    public CyberLawPoliciesAdapter(Context context, ArrayList<ICyberLawPolicyViewModel> viewModels) {
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
        holder.policyMessage.setText(viewModels.get(position).getPolicyMessage());
        holder.view.setBackgroundColor(viewModels.get(position).getStatusForPolicy() == ICyberLawPolicyViewModel.POLICY_STATUS.compliant ? context.getResources().getColor(R.color.green_200)
                : context.getResources().getColor(R.color.red_200));
    }

    @Override
    public int getItemCount() {
        return viewModels.size();
    }

    public void setCompliantStatus(int position) {
        viewModels.get(position).setPolicyStatus(ICyberLawPolicyViewModel.POLICY_STATUS.compliant);
    }

    public void setNonCompliantStatus(int position) {
        viewModels.get(position).setPolicyStatus(ICyberLawPolicyViewModel.POLICY_STATUS.noncompliant);
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
