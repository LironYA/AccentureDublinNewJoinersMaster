package com.example.android.accenturenewjoiners.Activities.Kids;

import android.os.Bundle;

import com.example.android.accenturenewjoiners.R;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.Activities.ContactUs.ContactUsActivity;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class ToddlersFragment extends Fragment {
    public ToddlersFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);
        //Fab Actions
        final RelativeLayout rl = (RelativeLayout) rootView.findViewById(R.id.rl);
        final FloatingActionsMenu main = (FloatingActionsMenu) rootView.findViewById(R.id.main);
        final FloatingActionButton info = (FloatingActionButton) rootView.findViewById(R.id.info);
        //Pressing on the info icon
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(LAYOUT_INFLATER_SERVICE);
                // Inflate the custom layout/view
                final View customView = inflater.inflate(R.layout.popup_info, null);
                main.collapse();
                // Initialize a new instance of popup window
                final PopupWindow popupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                if (Build.VERSION.SDK_INT >= 21) {
                    popupWindow.setElevation(5.0f);
                }
                TextView info_text = (TextView) customView.findViewById(R.id.info_text);
                info_text.setText("Find Information for toddlers (0-4).");
                Button closeButton = (Button) customView.findViewById(R.id.close_button_popup);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        popupWindow.dismiss();
                    }

                });
                Button close = (Button) customView.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        popupWindow.dismiss();
                    }
                });
                popupWindow.showAtLocation(rl, Gravity.CENTER, 0, 0);
            }
        });

        final FloatingActionButton contact = (FloatingActionButton) rootView.findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactUsActivity.class);
                startActivity(intent);

            }
        });
        final FloatingActionButton home = (FloatingActionButton) rootView.findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainScreen.class);
                startActivity(intent);
            }
        });
        final ArrayList<ArrayListFragments> toddlers = new ArrayList<ArrayListFragments>();
        toddlers.add(new ArrayListFragments("https://www.citizensinformation.ie/en/education/pre_school_education_and_childcare/early_childhood_care_and_education_scheme.html", "Early Childhood Care and Education Scheme (ECCE)", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Learn more about the ECCE scheme"));
        toddlers.add(new ArrayListFragments("https://www.childcare.ie/dublin/creche", "A list of creches (playschools) in Dublin", "https://lh3.googleusercontent.com/proxy/38Qvew6JYroQWL_tvN3rsc8FL0nHUivRKYRTcFliog-1Ef5Yn_yS2jWcyIsv3A30Rb7PXuh1kREZV6BFFa5dTy_4HSIkfy8", "This is partial list of creches in Dublin with contacts and emails"));
        toddlers.add(new ArrayListFragments("https://www.google.com/maps/search/creches+dublin/@53.3457975,-6.2543577,14z/data=!3m1!4b1", "Creches (playschools) in Dublin via Google maps", "https://img.icons8.com/bubbles/2x/google-maps.png", "A complete list of creches in Dublin via Google maps"));
        toddlers.add(new ArrayListFragments("https://www.citizensinformation.ie/en/education/pre_school_education_and_childcare/national_childcare_scheme.html", "National Childcare Scheme (NCS)", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "The National Childcare Scheme provides 2 types of childcare subsidy for children over 6 months of age - a universal subsidy for children under 3 which is not means tested and an income assessed subsidy for children up to 15 which is means-tested"));
        toddlers.add(new ArrayListFragments("https://www2.hse.ie/services/gp-visit-cards/under-6s-gp-visit-card.html", "Under 6s GP visit card", "https://www2.hse.ie/imagelibrary/site-logo.png", "All children under 6 years of age living in Ireland can get a GP visit card"));
        toddlers.add(new ArrayListFragments("https://www.mindme.ie", "Mind Me", "https://lh3.googleusercontent.com/proxy/38Qvew6JYroQWL_tvN3rsc8FL0nHUivRKYRTcFliog-1Ef5Yn_yS2jWcyIsv3A30Rb7PXuh1kREZV6BFFa5dTy_4HSIkfy8", "Childcare, Babysitters, Childminders, Nannies & Senior Care Board (Fee might apply)."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), toddlers);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = toddlers.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}