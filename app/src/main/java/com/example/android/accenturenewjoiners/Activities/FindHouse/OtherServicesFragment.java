package com.example.android.accenturenewjoiners.Activities.FindHouse;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class OtherServicesFragment extends Fragment {
    public OtherServicesFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> other_services = new ArrayList<ArrayListFragments>();
        other_services.add(new ArrayListFragments("https://www.linkedin.com/in/ross-finnerty-95804689/?originalSubdomain=ie","Ross Finnerty - Relocation Services Dublin", "https://media.licdn.com/dms/image/C4D03AQFUZFQZc3v_sg/profile-displayphoto-shrink_200_200/0?e=1576108800&v=beta&t=hdNJXPeczL62A-DSaTZx7trXsisg6LCvuOFTkAlHIxc", "Ross is a relocation expert with a lot of experience in Dublin  \nPhone or text: +353-868-171-300\nEmail: RelocationServicesRoss@gmail.com \nMention Accenture's app referral."));
        other_services.add(new ArrayListFragments("https://www.sherryfitz.ie/","Sherry FitzGerald", "https://pbs.twimg.com/profile_images/936216021429555200/8l_Gsut2.jpg", "Real estate agency."));
        other_services.add(new ArrayListFragments("https://www.olivers.ie/?sfid=2482&_sf_s=dublin&_sfm_let_rent=1195+1985","olivers.ie", "https://www.olivers.ie/wp-content/themes/olivers-estates/images/icons/olivers-estate-agents-icon-76.png", "Real estate agency."));
        other_services.add(new ArrayListFragments("https://www.remax-ireland.com/","remax ireland", "https://remax-property-associates.ie/wp/wp-content/uploads/2018/08/REMAX-Ireland-1.png", "Real estate agency."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), other_services);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = other_services.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}

