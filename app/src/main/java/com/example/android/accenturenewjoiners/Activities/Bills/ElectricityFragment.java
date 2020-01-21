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

public class ElectricityFragment extends Fragment {
    public ElectricityFragment() {
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
                info_text.setText("Find the best deal for gas and electricity.");
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
        final ArrayList<ArrayListFragments> electricity = new ArrayList<ArrayListFragments>();
        electricity.add(new ArrayListFragments("https://switcher.ie/gas-electricity","Compare Electricity Prices", "https://assets.switcher.ie/assets/logos/switcher-logo-4b69e03300762ed78bebbd28df2704511cec141dc3808f0c235bb14769eec2e3.png", "Compare the cheapest electricity prices."));
        electricity.add(new ArrayListFragments("https://beenergy.ie","BEenergy", "https://switcher-production.imgix.net/GLZUAXzkUrcjNPEJY4yEMt8x?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "BEenergy offer electricity plans for homes across Ireland."));
        electricity.add(new ArrayListFragments("https://www.bordgaisenergy.ie","Bord Gáis Energy", "https://switcher-production.imgix.net/7bUHnwCqbGydBCbi4cwzxYkA?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Bord Gáis Energy offer electricity, gas and dual fuel tariffs for both domestic and business users."));
        electricity.add(new ArrayListFragments("https://www.electricireland.ie","Electric Ireland", "https://switcher-production.imgix.net/GLZUAXzkUrcjNPEJY4yEMt8x?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Electric Ireland offers a variety of electricity-only, gas-only and dual fuel plans."));
        electricity.add(new ArrayListFragments("https://www.energia.ie/home","Energia", "https://switcher-production.imgix.net/92eEieUcz1B2i4xtHg7P69Y2?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Energia has been in operation in the residential market in Ireland since 2014. It offers electricity-only, gas-only and dual fuel plans."));
        electricity.add(new ArrayListFragments("https://www.flogas.ie","Flogas", "https://switcher-production.imgix.net/7WRZZ9arEwTc2zDuiDb9ceqo?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Flogas has been in operation in the residential market in Ireland since 2007. It offers gas-only plans."));
        electricity.add(new ArrayListFragments("https://www.iberdrola.es/en/home","Iberdrola", "https://switcher-production.imgix.net/HGkfGt1zeBYmWmSNvvuPcspk?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Iberdrola launched in Ireland in 2019 and provides a number of electricity-only, gas-only and dual fuel plans."));
        electricity.add(new ArrayListFragments("https://www.justenergy.ie","Just Energy", "https://switcher-production.imgix.net/6u4Psuy5BgAg2UppQ1xD2wmB?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Just Energy launched in Ireland in 2017 and provides a variety of electricity, gas and dual fuel plans - including fixed rate and unlimited tariffs."));
        electricity.add(new ArrayListFragments("https://www.pandapower.ie","Panda Power", "https://switcher-production.imgix.net/5YUBuMWymaWGjbtE6D4DT2Rn?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "Panda Power launched in Ireland in 2015 and is a green electricity provider, providing a variety of electricity-only plans."));
        electricity.add(new ArrayListFragments("https://pinergy.ie","Pinergy", "https://switcher-production.imgix.net/MtDs3NesqAXyWK87gfn8dTqE?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350 ", "Pinergy has been in operation in Ireland since 2013. It offers electricity-only pre-pay plans."));
        electricity.add(new ArrayListFragments("https://www.prepaypower.ie","PrePayPower", "https://switcher-production.imgix.net/7rpu6C9gByWG6s9SAakQHBGc?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "PrePayPower has been in operation in Ireland since 2011. It offers electricity-only pre-pay plans."));
        electricity.add(new ArrayListFragments("https://www.sseairtricity.com/ie/home","SSE Airtricity", "https://switcher-production.imgix.net/H9TV8h4w4F6qSTKeVk26bEtg?auto=format%2Ccompress&crop=faces%2Centropy&fit=crop&h=175&w=350", "SSE Airtricity has been in operation in the domestic market in Ireland since 2009. It offers a variety of electricity-only, gas-only and dual fuel plans."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), electricity);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = electricity.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
