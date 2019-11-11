package com.example.android.accenturenewjoiners.Activities.ThingsToSee;

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

    public class ThingsToSeeDublinFragment extends Fragment {

        public ThingsToSeeDublinFragment () {
            // Required empty public constructor
        }
        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

            final ArrayList<ArrayListFragments> ThingsToSeeDublin = new ArrayList<ArrayListFragments>();
            ThingsToSeeDublin.add(new ArrayListFragments("http://www.phoenixpark.ie","Phoenix Park", "pic", "Phoenix Park is the largest enclosed public park in any capital city in Europe\n Opening Hours: 8am – 5pm, Monday – Friday\n superintendent.park@opw.ie \n +353-87228-9688"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.dublinzoo.ie","Dublin Zoo", "pic", "Open daily from 9.30am - 5.30pm \n info@dublinzoo.ie \n +353-1-4748900"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.tcd.ie/visitors/book-of-kells","The book of kells", "pic", "Mon – Sat (May - Sept) 08:30 – 17:00 \n Sun (May - Sept) 09:30 – 17:00 \n Mon – Sat (Oct - April) 09:30 – 17:00 \n Sun (Oct - April) 12:00 – 16:30 \n +353-1-896-4477 \n events@tcd.ie"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.guinness-storehouse.com/en","Guinness Storehouse", "pic", "Open all year apart from Christmas Eve, Christmas Day, & St Stephens Day \n Opening hours are 9:30am - 7pm (last admission is at 5pm) \n Opening hours in July and August are 9.30am - 9pm (last admission is at 7pm)"));
            ThingsToSeeDublin.add(new ArrayListFragments("http://www.dublincity.ie/main-menu-services-recreation-culture-dublin-city-parks-visit-park/st-annes-park", "Saint Annes Park", "https://www.dublincity.ie/sites/default/files/content/RecreationandCulture/DublinCityParks/VisitaPark/PublishingImages/CrystalDepthClocktower.jpg", "customerservices@dublincity.ie \n +353-1-222-5278"));
            ThingsToSeeDublin.add(new ArrayListFragments("https://www.malahidecastleandgardens.ie","Malahide Castle", "pic", "magnificent medieval castle with a dramatic 800 year heritage \n reservations@shannonheritage.com \n +353-61-711222 \n Open daily from 9.30am"));
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
