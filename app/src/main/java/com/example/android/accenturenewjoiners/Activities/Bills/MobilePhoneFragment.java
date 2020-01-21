package com.example.android.accenturenewjoiners.Activities.Bills;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import com.example.android.accenturenewjoiners.Activities.ContactUs;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class MobilePhoneFragment extends Fragment {

    public MobilePhoneFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);
        //Fab Actions
        final RelativeLayout rl = (RelativeLayout)rootView.findViewById(R.id.rl);
        final FloatingActionsMenu main = (FloatingActionsMenu)rootView.findViewById(R.id.main);
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
                info_text.setText("Find the best deal for mobile phone plans.");
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
                popupWindow.showAtLocation(rl, Gravity.CENTER,0,0);
            }
        });

        final FloatingActionButton contact = (FloatingActionButton) rootView.findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactUs.class);
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
        final ArrayList<ArrayListFragments> mobile = new ArrayList<ArrayListFragments>();
        mobile.add(new ArrayListFragments("https://www.eir.ie/mobile/simonly/","eir mobile", "https://upload.wikimedia.org/wikipedia/en/6/63/Eir-telecom-logo.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://www.virginmedia.ie/mobile/","Virgin Media mobile", "https://www.virginmedia.ie/etc/designs/virginmedia-ie/media/logos/virgin_media.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://n.vodafone.ie/shop/bill-pay-plans.html","Vodafone mobile", "https://www.vodafone.ie/images/vf-logo.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://www.lycamobile.ie/en/bundles/#/nationalbundles","lycamobile", "https://d126cmlf10qkes.cloudfront.net/wp-content/themes/Divi-child/img/logo-lm.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://www.tescomobile.ie/sim-only-plans.aspx","tesco mobile", "https://www.tescomobile.ie/img/cached/logo_tesco-mobile.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://shop.gomo.ie","gomo mobile", "https://shop.gomo.ie/img/GoMoLogo.png", "Get the latest SIM only Plans."));
        mobile.add(new ArrayListFragments("https://europa.eu/youreurope/citizens/consumers/internet-telecoms/mobile-roaming-costs/index_en.htm","EU Roaming", "https://www.sparcs.info/sites/default/files/2019-11/EU%20logo_transparent_0.png", "Information about roaming in the EU."));


        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), mobile);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments mobile_phones = mobile.get(position);
                Uri siteURL = Uri.parse(mobile_phones.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}



