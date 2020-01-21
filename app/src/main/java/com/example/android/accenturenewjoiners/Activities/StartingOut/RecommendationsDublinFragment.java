package com.example.android.accenturenewjoiners.Activities.StartingOut;

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

public class RecommendationsDublinFragment extends Fragment {

        public RecommendationsDublinFragment() {
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
                    info_text.setText("Find the best value grocery stores in Ireland, marked by prices rates.");
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
            final ArrayList<ArrayListFragments> recommendationsDublin = new ArrayList<ArrayListFragments>();
            recommendationsDublin.add(new ArrayListFragments("https://www.lidl.ie","Lidl Ireland €", "https://seeklogo.net/wp-content/uploads/2013/03/lidl-vector-logo.png", "One of the best value grocery stores in Ireland."));
            recommendationsDublin.add(new ArrayListFragments("https://www.aldi.ie","Aldi €", "https://www.stickpng.com/assets/images/5a0c71ca9642de34b6b65ce0.png", "One of the best value grocery stores in Ireland."));
            recommendationsDublin.add(new ArrayListFragments("https://www.tesco.ie","Tesco €€", "https://www.stickpng.com/assets/images/584290c7a6515b1e0ad75ac4.png", "British multinational groceries and general merchandise retailer."));
            recommendationsDublin.add(new ArrayListFragments("https://supervalu.ie","SuperValu €€", "https://www.stickpng.com/assets/images/5a1c2e4ff65d84088faf13d8.png", "SuperValu is a supermarket chain that operates on the island of Ireland./n Visit their website to make an online order."));
            recommendationsDublin.add(new ArrayListFragments("https://www.dunnesstores.com","Dunnes Stores €€€", "https://scotchhall.ie/wp-content/uploads/2016/06/DUNNESLOGONEW.png", "Irish multinational retail chain that primarily sells food, clothes and household wares."));


            final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), recommendationsDublin);

            final ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    ArrayListFragments general_recommendations = recommendationsDublin.get(position);
                    Uri siteURL = Uri.parse(general_recommendations.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

            });
            return rootView;

        }
    }


