package com.example.android.accenturenewjoiners.Activities.Immigration;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.app.Fragment;


import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class EUFragment extends Fragment {

    public EUFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> eu_citizen = new ArrayList<ArrayListFragments>();
        eu_citizen.add(new ArrayListFragments("https://www.citizensinformation.ie/en/moving_country/moving_to_ireland/rights_of_residence_in_ireland/residence_rights_eu_national.html#l62fd2","Residence rights of EEA nationals in Ireland", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "If you are a national of the European Economic Area (EEA) or of Switzerland, you have the right to stay in Ireland\nFind out more about the registration process."));
        eu_citizen.add(new ArrayListFragments("https://ec.europa.eu/ireland/node/586_en","Frequently Asked Questions about Mobility in the EU", "https://ec.europa.eu/ireland/sites/ireland/themes/reps/reps/images/logos/logo_en.gif", "General information."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), eu_citizen);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = eu_citizen.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
