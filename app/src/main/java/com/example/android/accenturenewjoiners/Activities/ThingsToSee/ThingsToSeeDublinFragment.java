package com.example.android.accenturenewjoiners.Activities.ThingsToSee;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
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

public class ThingsToSeeDublinFragment extends DialogFragment {

        public ThingsToSeeDublinFragment () {
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
                    info_text.setText("Here you can find our recommendations for the best places to see in Dublin.");
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
            //Array
            final ArrayList<ArrayListFragments> ThingsToSeeDublin = new ArrayList<ArrayListFragments>();
            ThingsToSeeDublin.add(new ArrayListFragments("http://www.phoenixpark.ie","Phoenix Park", "pic", "Phoenix Park is the largest enclosed public park in any capital city in Europe\n Opening Hours: 8am – 5pm, Monday – Friday\n superintendent.park@opw.ie \n +353-87228-9688"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.dublinzoo.ie","Dublin Zoo", "pic", "Open daily from 9.30am - 5.30pm \n info@dublinzoo.ie \n +353-1-4748900"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.tcd.ie/visitors/book-of-kells","The book of kells", "pic", "Mon – Sat (May - Sept) 08:30 – 17:00 \n Sun (May - Sept) 09:30 – 17:00 \n Mon – Sat (Oct - April) 09:30 – 17:00 \n Sun (Oct - April) 12:00 – 16:30 \n +353-1-896-4477 \n events@tcd.ie"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.guinness-storehouse.com/en","Guinness Storehouse", "pic", "Dublin’s most popular tourist attraction is an interactive, seven-storey structure that showcases the history and process\nbehind Ireland’s most famous export.\n Opening hours are 9:30am - 7pm (last admission is at 5pm) \n Opening hours in July and August are 9.30am - 9pm (last admission is at 7pm)"));
            ThingsToSeeDublin.add(new ArrayListFragments("http://www.dublincity.ie/main-menu-services-recreation-culture-dublin-city-parks-visit-park/st-annes-park", "Saint Annes Park", "https://www.dublincity.ie/sites/default/files/content/RecreationandCulture/DublinCityParks/VisitaPark/PublishingImages/CrystalDepthClocktower.jpg", "customerservices@dublincity.ie \n +353-1-222-5278"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.malahidecastleandgardens.ie","Malahide Castle", "pic", "Magnificent medieval castle with a dramatic 800 year heritage \n reservations@shannonheritage.com \n +353-61-711222 \n Open daily from 9.30am"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.jamesonwhiskey.com/en-IE/visit-us/jameson-distillery-bow-st","Jameson Distillery", "pic", "Jameson Distillery Bow St. is an Irish whiskey tourist attraction.\n" + "The guided Bow St. Experience distillery tour starting at €20.00\n" + "* Check website for discounts and other attrections.\nBow Street, Smithfield Village Dublin 7."));
            ThingsToSeeDublin.add(new ArrayListFragments("http://www.dublincastle.ie","Dublin Castle", "https://i2-prod.dublinlive.ie/whats-on/arts-culture-news/article10978175.ece/ALTERNATES/s615/dublin-castlePNG.png", "Erected in the early thirteenth century on the site of a Viking settlement, Dublin Castle served for centuries as the headquarters of English, and later British,\nadministration in Ireland.\nCost: €8 for Self-guiding, €12 for Guided Tours.\n* Check website for students and seniors discounts.\nLocated at Dame Street, Dublin 2\n"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.tripadvisor.ie/Attraction_Review-g186605-d188828-Reviews-Grafton_Street-Dublin_County_Dublin.html","Grafton Street", "pic", "Grafton Street is one of the two principal shopping streets in Dublin city centre"));
            final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), ThingsToSeeDublin);

            final ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    ArrayListFragments general_information = ThingsToSeeDublin.get(position);
                    Uri siteURL = Uri.parse(general_information.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

            });
            return rootView;
        }
    }
