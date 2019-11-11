package com.example.android.accenturenewjoiners.Activities.EmergencyInformation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class EmergencyContactsFragment extends Fragment {

    public EmergencyContactsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> contacts = new ArrayList<ArrayListFragments>();
        contacts.add(new ArrayListFragments("https://www.tripsavvy.com/emergency-phone-numbers-in-ireland-1542785","Emergency numbers", "https://upload.wikimedia.org/wikipedia/commons/0/00/Logo_of_112_%28Georgia%29.png", "Dial 112 or 999 and ask the operator to put you through the Police (garda), Emergency Medical Services and Ambulance, Fire and Rescue Services, Marine and Coastal Emergencies or any other emergency you may have."));
        contacts.add(new ArrayListFragments("https://www.garda.ie/en/Contact-Us/","Contact An Garda Síochána (police)", "https://www.garda.ie/images/gardaLogoLarge.png", "Find numerous ways you can make contact with An Garda Síochána."));
        contacts.add(new ArrayListFragments("https://www.garda.ie/en/Victim-Services/Reporting-a-crime-FAQs/Is-there-an-emergency-SMS-option-.html","Emergency SMS option", "https://www.garda.ie/images/gardaLogoLarge.png", "The 112 SMS service lets deaf, hard of hearing and speech-impaired people contact the emergency services.\n Before you can use the 112 SMS service, you will need to register your mobile phone on www.112.ie."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), contacts);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = contacts.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
