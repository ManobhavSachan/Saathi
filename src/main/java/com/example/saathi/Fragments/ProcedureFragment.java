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

public class ProcedureFragment extends Fragment {

    public ProcedureFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerpro;
    ArrayList<ContentDetails> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_procedure, container, false);

        recyclerpro = view.findViewById(R.id.recyclerProcedure);

        list.add(new ContentDetails("About Driving Licence", "Click to Know more"));
        list.add(new ContentDetails("Types of Driving Licence", "Click to Know more"));

        list.add(new ContentDetails("Documents Need for Driving Licence Application", "At the time of applying for your driving licence, you will be asked to provide several documents. Read on below for the list of documents you may need for your driving licence application:\n" +
                "Proof of age can be in the form of a birth certificate, Permanent Account Number card (PAN), Class 10-mark sheet or passport.\n" +
                "Proof of current address can be an Aadhaar card, electricity bill issued in your name, Voter ID card, agreement of house ownership, passport, ration card. In case the house is rented, a rental agreement along with either an electricity bill or gas bill would work.\n" +
                "A duly filled application form (either online or in the RTO).\n" +
                "Passport-size photographs.\n" +
                "Medical certificate issued by a certified physician (for people aged 40 years or older).\n" +
                "Lastly but very importantly, practical knowledge of traffic rules.\n"));

        list.add(new ContentDetails("Procedure to Get a Driving Licence", "You will need to follow the given steps to apply for and get an official driving licence:\n" +
                "Initially, when you apply for a driving licence for the first time, you will get a learner’s licence.\n" +
                "You have the option to apply for your new driving licence online. Go to the official website of the Road Transport & Highways Ministry called Sarathi, and click on the option ‘New Driving licence’ under the column ‘Sarathi Services’. You will be taken to the form for applying for a driving licence online.\n" +
                "Once you get confirmation that your application has been processed, you can book a slot for your learner’s licence test.\n" +
                "Once you get your learner’s licence, you have six months to practice driving your vehicle.\n" +
                "You can apply for your permanent licence within six months of getting your learner’s licence.\n"));


        RecyclerAdapter adapter = new RecyclerAdapter(list, getContext());
        recyclerpro.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerpro.setLayoutManager(layoutManager);


        return view;
    }
}