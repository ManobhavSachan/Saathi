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

public class ConnectFragment extends Fragment {


    public ConnectFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerConnect;
    ArrayList<ContentDetails> list = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_connect, container, false);

        recyclerConnect = view.findViewById(R.id.recyclerConnect);

        list.add(new ContentDetails("Swadesh NGO", "Founded by Ronnie and Zarina Screwvala, the Swades Foundation operates with the single-minded focus of empowering rural India. Our vision is rural empowerment through best practices, modern technology and values.", R.string.swadesh));
        list.add(new ContentDetails("Shanti Sahyog Center for Women", "provides legal awareness/counselling/aid to victims of domestic violence/abuse, and their rehabilitation through vocational training in Computer Application, Beauty Culture and Cutting & Tailoring.",R.string.sscw));
        list.add(new ContentDetails("Shuddhi NGO", "‘To help individuals and communities break the cycle of poverty that prevents them from reaching their full potential.’", R.string.shuddhi));
        list.add(new ContentDetails("HelpAge India", "HelpAge conducts cataract eye surgeries in 21 states with medical support of credible and competent eye hospitals and organizations. Since 1980, under this program 45,000 cataract eye surgeries have been conducted annually", R.string.helpage));
        list.add(new ContentDetails(" Asha Kiran", "Asha Kiran runs an initiative to help elderly destitute women, below the poverty line, living alone in remote rural villages. It provides basic necessities to close to 200 elderly women . Asha Kiran also conducts monthly meetings apart from free medical camps and cultural programs, to improve their quality of life", R.string.ashakiran));
        list.add(new ContentDetails("Shraddhanand Mahilashram", "Mahilashram provides shelter to women above 60 years of age. While the old age home offers free stay for abandoned and poor women, it also provides paid services for women who can afford these. Their aim is to provide peace to these women in their last days", R.string.swadesh));

        RecyclerAdapter adapter = new RecyclerAdapter(list, getContext());
        recyclerConnect.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerConnect.setLayoutManager(layoutManager);


        return view;
    }
}