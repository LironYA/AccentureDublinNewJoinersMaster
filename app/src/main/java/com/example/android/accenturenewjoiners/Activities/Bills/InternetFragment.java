package com.example.android.accenturenewjoiners.Activities.Bills;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class InternetFragment extends Fragment {

    public InternetFragment() {
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
                info_text.setText("Find the best deal for ISP services.");
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
        final ArrayList<ArrayListFragments> internet = new ArrayList<ArrayListFragments>();
        internet.add(new ArrayListFragments("https://www.eir.ie/broadband","eir broadband", "https://upload.wikimedia.org/wikipedia/en/6/63/Eir-telecom-logo.png", "Get the latest plan for Fiber Internet\n TV plans are also available."));
        internet.add(new ArrayListFragments("https://www.virginmedia.ie/broadband/buy-a-broadband-package","Virgin Media Broadband", "https://www.virginmedia.ie/etc/designs/virginmedia-ie/media/logos/virgin_media.png", "Get the latest plan for Fiber Internet\n TV plans are also available."));
        internet.add(new ArrayListFragments("https://n.vodafone.ie/shop/broadband.html","Vodafone Broadband", "https://www.vodafone.ie/images/vf-logo.png", "Get the latest plan for Fiber Internet\n TV plans are also available."));
        internet.add(new ArrayListFragments("https://www.sky.com/ireland/broadband-talk?OSPV=Wk25_ROI_BB_Homepage_Default&irct=ROIHomeDefault-BB","Sky", "https://www.stickpng.com/assets/images/5842ab6da6515b1e0ad75b0a.png", "Get the latest plan for Fiber Internet\n TV plans are also available."));
        internet.add(new ArrayListFragments("https://www.puretelecom.ie/fibre-broadband","Pure Telecom", "https://www.puretelecom.ie/assets/images/pure_logo.png", "Get the latest plan for Fiber Internet\n Phone plans are also available."));
        internet.add(new ArrayListFragments("https://www.magnet.ie/residential","Magnet Networks", "https://www.magnet.ie/residential/wp-content/themes/magnet-res/img/logo.png", "Get the latest plan for Fiber Internet."));
        internet.add(new ArrayListFragments("https://digiweb.ie/siro-powered-broadband","Digiweb", "https://6sfrgps5x4-flywheel.netdna-ssl.com/wp-content/uploads/2018/08/Digiweb-Logotype.png", "Get the latest plan for Fiber Internet."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), internet);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments general_information = internet.get(position);
                Uri siteURL = Uri.parse(general_information.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}

