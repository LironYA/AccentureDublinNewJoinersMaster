package com.example.android.accenturenewjoiners.Activities.Welfare;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

public class GeneralWelfareFragment extends Fragment {
    public GeneralWelfareFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

        final ArrayList<ArrayListFragments> generalWelfare = new ArrayList<ArrayListFragments>();
        generalWelfare.add(new ArrayListFragments("https://services.mywelfare.ie/en/topics/appointments", "PPS number appointment", "https://services.mywelfare.ie/icons/favicon-96x96.png", "Make or amend appointments for a Personal Public Service Number (PPSN)."));
        generalWelfare.add(new ArrayListFragments("http://www.welfare.ie/en/pdf/CB1.pdf", "Child Benefit Form", "https://services.mywelfare.ie/icons/favicon-96x96.png", "You need a Personal Public Service Number (PPS No.) for yourself and your child(ren) before you apply.\nOnce done, send the application by mail to the address mentioned in the form."));
        generalWelfare.add(new ArrayListFragments("http://www.welfare.ie/en/pdf/mb1.pdf","Maternity Benefit Form", "https://services.mywelfare.ie/icons/favicon-96x96.png", "You need a Personal Public Service Number (PPS No.) before you apply."));
        generalWelfare.add(new ArrayListFragments("https://services.mywelfare.ie/en/topics/parents-children-family/paternity-benefit/","Apply Online for Paternity Benefit", "https://services.mywelfare.ie/icons/favicon-96x96.png", "You will need a MyGovID account ."));
        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), generalWelfare);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = generalWelfare.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
