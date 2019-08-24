package com.example.android.accenturenewjoiners.Activities.Transportation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.android.accenturenewjoiners.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BusFragment extends Fragment {


    public BusFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> shuttel = new ArrayList<ArrayListFragments>();
        shuttel.add(new ArrayListFragments("https://google.com","Gordon", "https://www.google.com/search?q=hayday&rlz=1C1CHBF_enIE847IE847&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiL1bqJ0JbkAhVnRBUIHea0DbYQ_AUIESgB&biw=1366&bih=657#imgrc=EdJdpm-uOwQZ3M:", "Gordon Beach boasts volleyball courts and a lovely saltwater swimming pool, surrounded by lawns to lounge on. On the boardwalk you’ll find a myriad of restaurants serving huge portions of classics like Israeli breakfast, fresh fish, sandwiches and a huge array of salads."));
        shuttel.add(new ArrayListFragments("https://google.com","Tel Aviv Port", "https://www.google.com/search?q=hayday&rlz=1C1CHBF_enIE847IE847&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiL1bqJ0JbkAhVnRBUIHea0DbYQ_AUIESgB&biw=1366&bih=657#imgrc=EdJdpm-uOwQZ3M:","It has a little bit of everything that is Tel Aviv - blue sea, serene mornings, bustling markets, shops and restaurants galore, kids stuff, outdoor happenings and a lively night scene with clubs and bars."));
        shuttel.add(new ArrayListFragments("https://google.com","Sarona", "https://www.google.com/search?q=hayday&rlz=1C1CHBF_enIE847IE847&source=lnms&tbm=isch&sa=X&ved=0ahUKEwiL1bqJ0JbkAhVnRBUIHea0DbYQ_AUIESgB&biw=1366&bih=657#imgrc=EdJdpm-uOwQZ3M:", "Sarona is popular for its namesake covered market, a trendy hub of gourmet food stores selling local cheeses and cured meats, with restaurants by big-name Israeli chefs known for creative cuisine emphasizing seasonal ingredients. The area is full of busy bars serving cocktails and craft beer, while nearby, 19th-century cellars built by Templar Christians have been transformed into chic subterranean wine bars."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), shuttel);
        //http://www.a-b.ie/cp3/XSLT_TRIP_REQUEST2?language=en -- that's a journey planner
        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);

        return rootView;

    }
}
