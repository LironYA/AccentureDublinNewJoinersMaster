package com.example.android.accenturenewjoiners.Activities.Accenture;
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

public class AboutAccentureFragment extends Fragment{
    public AboutAccentureFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> generalInformation = new ArrayList<ArrayListFragments>();

        // generalInformation.add(new ArrayListFragments("","About Accenture", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Acenture's Vision and Businesses\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://in.accenture.com/aboutaccenture/","About Accenture", "https://www.accenture.com/t20181129T040955Z__w__/in-en/_acnmedia/Accenture/Conversion-Assets/DotCom/Images/Global/Dualpub_124/Accenture-Fowardmark-Gradient-Public-Service-New.png", "Learn about Accenture from the company's site\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://ie.linkedin.com/showcase/accenture-operations","Accenture's Linkedin page", "https://www.accenture.com/t20181129T040955Z__w__/in-en/_acnmedia/Accenture/Conversion-Assets/DotCom/Images/Global/Dualpub_124/Accenture-Fowardmark-Gradient-Public-Service-New.png", "Sign in to follow Accenture Operations."));
        generalInformation.add(new ArrayListFragments("https://www.youtube.com/c/AccentureOperations","Accenture's YouTube page", "https://www.accenture.com/t20181129T040955Z__w__/in-en/_acnmedia/Accenture/Conversion-Assets/DotCom/Images/Global/Dualpub_124/Accenture-Fowardmark-Gradient-Public-Service-New.png", "Follow Accenture Operations on YouTube."));
        generalInformation.add(new ArrayListFragments("https://twitter.com/AccentureOps","Accenture's Twitter page", "https://www.accenture.com/t20181129T040955Z__w__/in-en/_acnmedia/Accenture/Conversion-Assets/DotCom/Images/Global/Dualpub_124/Accenture-Fowardmark-Gradient-Public-Service-New.png", "Follow Accenture Operations on Twitter."));
        generalInformation.add(new ArrayListFragments("https://en.wikipedia.org/wiki/Accenture","Accenture's Wikipedia's page", "https://www.accenture.com/t20181129T040955Z__w__/in-en/_acnmedia/Accenture/Conversion-Assets/DotCom/Images/Global/Dualpub_124/Accenture-Fowardmark-Gradient-Public-Service-New.png", "Learn about Accenture's history."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), generalInformation);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = generalInformation.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;
    }
}
