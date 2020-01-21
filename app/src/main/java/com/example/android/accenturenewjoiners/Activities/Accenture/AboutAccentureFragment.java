package com.example.android.accenturenewjoiners.Activities.Accenture;
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

public class AboutAccentureFragment extends Fragment{
    public AboutAccentureFragment() {
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
                info_text.setText("Here you can find out more about Accenture.");
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
        final ArrayList<ArrayListFragments> generalInformation = new ArrayList<ArrayListFragments>();

        // generalInformation.add(new ArrayListFragments("","About Accenture", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Acenture's Vision and Businesses\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://in.accenture.com/aboutaccenture/","About Accenture", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Learn about Accenture from the company's site\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://ie.linkedin.com/showcase/accenture-operations","Accenture's Linkedin page", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Sign in to follow Accenture Operations."));
        generalInformation.add(new ArrayListFragments("https://www.youtube.com/c/AccentureOperations","Accenture's YouTube page", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Follow Accenture Operations on YouTube."));
        generalInformation.add(new ArrayListFragments("https://twitter.com/AccentureOps","Accenture's Twitter page", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Follow Accenture Operations on Twitter."));
        generalInformation.add(new ArrayListFragments("https://en.wikipedia.org/wiki/Accenture","Accenture's Wikipedia's page", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.pngg", "Learn about Accenture's history."));

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
