package com.example.saathi.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.saathi.Adapters.RecyclerAdapter;
import com.example.saathi.Models.ContentDetails;
import com.example.saathi.R;

import java.util.ArrayList;


public class SchemesFragment extends Fragment {


    public SchemesFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    ArrayList<ContentDetails> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schemes, container, false);

        recyclerView = view.findViewById(R.id.recyclerScheme);

        list.add(new ContentDetails("GRIHA AADHAR SCHEME", "The aim of the project is to provide requisite monetary help to homemakers from lower socioeconomic strata of the society inorder to maintain  acceptable living conditions for them and their families.", R.string.large_text));
        list.add(new ContentDetails("DEEN DAYAL SWASTH SEVA YOJANA", "Scheme to provide Universal Health Cover through Insaurance for the entire resident population of Goa", R.string.ddssy));
        list.add(new ContentDetails("PRADHAN MANTRI JAN AROGYA YOJANA", "Ayushman Bharat is a fundamental restructuring of the manner in which beneficiaries access healthcare services at the primary, secondary and tertiary care levels.", R.string.pmjay));
        list.add(new ContentDetails("MGNREGA", "It is the flagship programme of the Government to influence the life of poor masses positively and enhance their development. MGNREGA aims at enhancing livelihood security of households in rural areas of the country by providing at least one hundred days of guaranteed wage employment in a financial year to every household whose adult members volunteer to do unskilled manual work.", R.string.mgnrega));
        list.add(new ContentDetails("PRADHAN MANTRI UJJWALA YOJANA", "In order to provide clean cooking fuel to every poor households especially in rural areas, the Government had launched “Pradhan Mantri Ujjwala Yojana” on 01.05.2016 to provide deposit-free LPG connections to 5 crore women belonging to the Below Poverty Line (BPL) which has now been enhanced to 8 crore.", R.string.large_text));
        list.add(new ContentDetails("BETI BACHAO BETI PADHAO YOJANA", "Beti Bachao Beti Padhao (BBBP) Scheme was launched by the Hon’ble Prime Minister on 22nd January, 2015 in Panipat, Haryana to address the issue of decline in CSR and related issues of empowerment of girls and women over a life cycle continnum",R.string.large_text));

        RecyclerAdapter adapter = new RecyclerAdapter(list, getContext());
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);


        return view;
    }
}