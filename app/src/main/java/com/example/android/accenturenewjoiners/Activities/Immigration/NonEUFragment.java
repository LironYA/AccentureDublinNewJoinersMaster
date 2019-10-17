package com.example.android.accenturenewjoiners.Activities.Immigration;

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

public class NonEUFragment extends Fragment {



    public NonEUFragment() {
        // Required empty public constructor
    }

        @Override
        public View onCreateView (LayoutInflater inflater,final ViewGroup container,
        Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> non_eu_citizen = new ArrayList<ArrayListFragments>();
        non_eu_citizen.add(new ArrayListFragments("https://www.citizensinformation.ie/en/employment/migrant_workers/employment_permits/overview_employment_permits.html","Employment permit", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Find out more about the types of employment permits."));
        non_eu_citizen.add(new ArrayListFragments("https://www.citizensinformation.ie/en/moving_country/moving_to_ireland/rights_of_residence_in_ireland/registration_of_non_eea_nationals_in_ireland.html","Registration of non-EEA nationals", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "If you are not a citizen of the European Economic Area (EEA) or Switzerland, you need to register at the The Garda National Immigration Bureau (GNIB)"));
            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/irish-residence-permit","Irish Residence Permit (IRP)", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "The Irish Residence Permit (IRP) is your registration certificate. You will be given an IRP whenever you register with immigration."));
            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/registration-stamps","Permission, stamps & conditions", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "There are several types of stamp with different names, eg Stamp 0, Stamp 1, etc. Each one indicates a type of permission"));
            non_eu_citizen.add(new ArrayListFragments("https://burghquayregistrationoffice.inis.gov.ie/","Book an appointment in Dublin", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Following your arrival in Ireland, you should go to your local immigration registration office to register.\n **The appointment system is opening daily at 10AM and 2PM, make sure you have the form ready at that time.\n Address: \n Burgh Quay Registration Office\nIrish Naturalisation and Immigration Service\nDepartment of Justice and Equality\n 13/14 Burgh Quay, Dublin 2\nEmail:burghquayregoffice@justice.ie"));
            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/registration-offices", "Book an appointment outside of Dublin", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png","Following your arrival in Ireland, you should go to your local immigration registration office to register.\nEmail: gnib_dv@garda.ie"));
            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/first-time-registration","First time registration", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Documents you need & how to register"));

            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/renew-registration","Renewal", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Before your Irish Residence Permit (IRP) or GNIB card expires you should go to your local immigration registration office to renew it\nYou should make an appointment for a date closest to the expiry of your card but generally not more than two weeks before that date."));

            non_eu_citizen.add(new ArrayListFragments("http://www.inis.gov.ie/en/INIS/Pages/registration-fees","Registration fee, payment & exemptions", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Irish Residence Permit (IRP) €300 per person each time"));


        non_eu_citizen.add(new ArrayListFragments("https://www.citizensinformation.ie/en/contact_us.html","Contact Information, stamps & conditions", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Phone: +353 761 07 4000\n Address: \n Burgh Quay Registration Office\nIrish Naturalisation and Immigration Service\nDepartment of Justice and Equality\n 13/14 Burgh Quay, Dublin 2\nEmail:burghquayregoffice@justice.ie"));

            final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), non_eu_citizen);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    ArrayListFragments general_information = non_eu_citizen.get(position);
                    Uri siteURL = Uri.parse(general_information.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

            });
            return rootView;

        }
}

