package com.example.android.accenturenewjoiners.Activities.Kids;

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

import com.example.android.accenturenewjoiners.Activities.ContactUs.ContactUsActivity;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

    public class KidsFourAndUpFragment extends Fragment {
        public KidsFourAndUpFragment() {
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
                    info_text.setText("Find Information and activities for kids ages 4 and up.");
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
            toddlers.add(new ArrayListFragments("https://www.google.com/maps/search/schools+dublin/@53.3458462,-6.2543577,14z/data=!3m1!4b1", "Schools in Dublin via Google maps", "https://img.icons8.com/bubbles/2x/google-maps.png", "A complete list of schools in Dublin via Google maps."));
            toddlers.add(new ArrayListFragments("https://www.citizensinformation.ie/en/education/primary_and_post_primary_education/attendance_and_discipline_in_schools/school_terms_in_primary_and_postprimary.html", "School Holidays", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "School terms in primary and post-primary schools."));
            toddlers.add(new ArrayListFragments("https://www.citizensinformation.ie/en/education/primary_and_post_primary_education/going_to_primary_school/primary_education_life_event.html", "Starting school", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "Information about school enrollment."));
            toddlers.add(new ArrayListFragments("https://www.google.com/search?tbm=lcl&sxsrf=ALeKk028M-S93ZSW-Xf4GsY7erSXppDg-g:1582215961559&q=Indoor+play+centres&rflfq=1&num=10&uule=w+CAQQCFISCS-sJ-qADmdIEaBxMZepxwAK&lsspp=CcTqYHBKlMNVCWKkrDS_OuPbCbOivGpOZUew&rlt=Indoor+play+centres&owsq=kids+activities+dublin&sa=X&ved=2ahUKEwiRzeLixeDnAhX1tHEKHQ9uARQQ9s8CMBt6BAgNEAU&cshid=1582216100684669&biw=1242&bih=1073#rlfi=hd:;si:;mv:[[54.06655714472918,-5.50323156858758],[52.543702635793316,-7.76092199827508],null,[53.31191998523434,-6.63207678343133],9]", "List of indoor play centres", "https://img.icons8.com/bubbles/2x/google-maps.png", "A list of indoor play centres in Dublin via Google maps."));
            toddlers.add(new ArrayListFragments("https://www.familyfun.ie", "Family Fun Website", "https://www.familyfun.ie/site-assets/themes/family-fun/img/family-fun-logo-sm.png", "Find activities for kids and family time."));

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

