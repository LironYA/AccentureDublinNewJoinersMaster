package com.example.android.accenturenewjoiners.Activities.FindHouse;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;

public class HouseWebsitesFragments extends Fragment {
    public HouseWebsitesFragments() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> house_websites = new ArrayList<ArrayListFragments>();
        house_websites.add(new ArrayListFragments("https://google.com","Gordon", "https://lh3.googleusercontent.com/QlYEqI4n_7-K6rdb_FblHVpkjwz0qULaobeAhHhZnYXV5BcGB06TPX3un3oQUq3PagTa=w412-h220-rw", "Gordon Beach boasts volleyball courts and a lovely saltwater swimming pool, surrounded by lawns to lounge on. On the boardwalk you’ll find a myriad of restaurants serving huge portions of classics like Israeli breakfast, fresh fish, sandwiches and a huge array of salads."));
        house_websites.add(new ArrayListFragments("https://google.com","Tel Aviv Port", "https://lh3.googleusercontent.com/QlYEqI4n_7-K6rdb_FblHVpkjwz0qULaobeAhHhZnYXV5BcGB06TPX3un3oQUq3PagTa=w412-h220-rw", "It has a little bit of everything that is Tel Aviv - blue sea, serene mornings, bustling markets, shops and restaurants galore, kids stuff, outdoor happenings and a lively night scene with clubs and bars."));
        house_websites.add(new ArrayListFragments("https://google.com","Sarona", "https://lh3.googleusercontent.com/QlYEqI4n_7-K6rdb_FblHVpkjwz0qULaobeAhHhZnYXV5BcGB06TPX3un3oQUq3PagTa=w412-h220-rw", "Sarona is popular for its namesake covered market, a trendy hub of gourmet food stores selling local cheeses and cured meats, with restaurants by big-name Israeli chefs known for creative cuisine emphasizing seasonal ingredients. The area is full of busy bars serving cocktails and craft beer, while nearby, 19th-century cellars built by Templar Christians have been transformed into chic subterranean wine bars."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), house_websites);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;

    }
}
