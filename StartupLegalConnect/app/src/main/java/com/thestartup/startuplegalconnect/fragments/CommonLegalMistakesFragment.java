package com.thestartup.startuplegalconnect.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.thestartup.startuplegalconnect.R;
import com.thestartup.startuplegalconnect.adapters.CommonMistakesAdapter;
import com.thestartup.startuplegalconnect.viewmodels.CommonMistakeViewModel;
import com.thestartup.startuplegalconnect.viewmodels.ICommonMistakeViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonLegalMistakesFragment extends Fragment {
    private ListView listView;

    public CommonLegalMistakesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common_legal_mistakes, container, false);
        listView = (ListView) view.findViewById(R.id.mistakesListView);
        listView.setAdapter(new CommonMistakesAdapter(getContext(), getMistakesViewModelList()));

        return view;
    }

    private ArrayList<ICommonMistakeViewModel> getMistakesViewModelList() {
        ArrayList<ICommonMistakeViewModel> viewModels = new ArrayList<>();
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.logo_protection), CommonMistakeViewModel.MistakeType.LOGO_PROTECTION));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.poor_branding), CommonMistakeViewModel.MistakeType.POOR_BRANDING));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.ip_issues), CommonMistakeViewModel.MistakeType.IP_ISSUES));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.copyright_mistake), CommonMistakeViewModel.MistakeType.COPYRIGHT_ISSUES));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.hyperlinking_mistake), CommonMistakeViewModel.MistakeType.HYPERLINKING));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.no_legal_doc), CommonMistakeViewModel.MistakeType.NO_LEGAL_DOC));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.cut_and_paste), CommonMistakeViewModel.MistakeType.CUT_AND_PASTE));
        viewModels.add(new CommonMistakeViewModel(getContext().getResources().getString(R.string.diy_mistake), CommonMistakeViewModel.MistakeType.DIY_LEGAL));

        return viewModels;
    }

}
