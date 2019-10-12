package com.example.android.accenturenewjoiners.Activities.StartingOut;

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

    public class GeneralFragment extends Fragment {
// Revenue office phone: 017023011

        public GeneralFragment() {
            // Required empty public constructor
        }
        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

            final ArrayList<ArrayListFragments> general = new ArrayList<ArrayListFragments>();
            general.add(new ArrayListFragments("https://www.dublinairport.com/to-from-the-airport/by-bus/dublin-buses","Dublin Bus from the Airport", "https://www.dublinairport.com/images/default-source/to-and-from-airport/bus-airlink.png?sfvrsn=5f7a88c0_2", "If you travel light, you can take a bus from the airport for only 7€ or 12€ return."));
            general.add(new ArrayListFragments("https://play.google.com/store/apps/details?id=com.airbnb.android&hl=en","AirBNB App", "https://lh3.googleusercontent.com/BQnvuZR500pg2ulvv3FBmRI93ODz3AjNfbz92hCieuJLvmbGY36AKhETMTTfTDgpPQI=s180-rw", "The world's leading app for short term housing."));
            general.add(new ArrayListFragments("https://play.google.com/store/apps/details?id=com.booking","Booking.com App", "https://lh3.googleusercontent.com/A0QsKezU_em5H1IiwKUUluEDOK7VuGVNLii3FVL89NDVKVvRsOSHjS5AeLAUywYhArE3=s180-rw", "Hotels, apartments, hostels and vacation rentals."));
            final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), general);

            final ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    ArrayListFragments general_information = general.get(position);
                    Uri siteURL = Uri.parse(general_information.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

            });
            return rootView;

        }
    }
