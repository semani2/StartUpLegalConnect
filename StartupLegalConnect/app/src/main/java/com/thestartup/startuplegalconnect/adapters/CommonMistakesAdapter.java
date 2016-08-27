package com.thestartup.startuplegalconnect.adapters;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.viewmodels.ICommonMistakeViewModel;

import java.util.ArrayList;

/**
 * Created by sai on 8/27/16.
 */
public class CommonMistakesAdapter extends BaseAdapter {
    private final ArrayList<ICommonMistakeViewModel> viewModels;
    private final Context context;
    private final LayoutInflater inflater;

    public CommonMistakesAdapter(Context context, ArrayList<ICommonMistakeViewModel> mistakeViewModels) {
        this.viewModels = mistakeViewModels;
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return viewModels.size();
    }

    @Override
    public Object getItem(int i) {
        return viewModels.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        View mistakeRow = inflater.inflate(R.layout.common_mistakes_row, null);
        TextView textView = (TextView) mistakeRow.findViewById(R.id.mistakeMessage);
        CheckBox checkBox = (CheckBox) mistakeRow.findViewById(R.id.checkBoxMistake);

        textView.setText(viewModels.get(position).getMessage());

        checkBox.setChecked(viewModels.get(position).isChecked());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    Toast.makeText(context, "Awesome job! You have avoided potential legal problems.", Toast.LENGTH_SHORT).show();
                }
                viewModels.get(position).setIsChecked(b);
            }
        });

        return mistakeRow;
    }
}
