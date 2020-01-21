package com.example.android.accenturenewjoiners.Activities.Welfare;
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

public class WelfareHowToApplyFragment extends Fragment {
    public WelfareHowToApplyFragment() {
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
                info_text.setText("Find the ways to apply for welfare services in Ireland.");
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
        final ArrayList<ArrayListFragments> howToWelfare = new ArrayList<ArrayListFragments>();
        howToWelfare.add(new ArrayListFragments("https://account.mygovid.ie/e197ea9e-02e5-4cb6-96b2-5571cd645754/b2c_1a_register-live/oauth2/authorize?client_id=0bbc19d4-9d91-491a-84cd-2c5df1d9128a&redirect_uri=https%3A%2F%2Fwww.mygovid.ie%2Fen-IE%2FAuthResp%2FIndex&response_mode=form_post&response_type=id_token&scope=do_not_track&state=OpenIdConnect.AuthenticationProperties%3DOknRgDmiES1rhdxKIrZ4oOAGA7SmkY0ITiqpy2FZqb3OIG1RY9C12ejavSu2xnK5tdu4ipyDWxIOtAcPNfw2lOSjflu4OFs-OlUPjjsT3IypmOJozvC5P8OrQmUZN4GG1QXPpnHrd6d5wINm9hDAgwTPux0B0LHuhLwJWCUPFiRygkUqx2bhcL0EThvAXMPZBUMUIvm4PuVNfwSGc5YDw9FjuxxBEEKxX3cLFmcZrxpvgi369ZBKKCDYZcu5VGIN&nonce=637073388384883614.Nzc1NzA1YTUtZTRhMy00N2RkLTkxZTYtZGZiZjdmYTczYzNlNzU0NTA3ZDQtYjYzOS00MjZmLWIyMmMtMWE0ODEyZDk0Y2Uy&ui_locales=en-IE&x-client-SKU=ID_NET451&x-client-ver=5.2.1.0","MyGovID", "https://www.welfare.ie/SiteCollectionImages/MyGovId.png", "Sign up for MyGovID - this will allow you to apply online for all government’s services."));
        howToWelfare.add(new ArrayListFragments("https://services.mywelfare.ie/en/other-info-pages/contact-us/","Welfare contact information", "https://services.mywelfare.ie/icons/favicon-96x96.png", "For access, assistance or general questions:\n Email:support@MyWelfare.ie\nPhone: +353 76 628 5191\n(Mon - Fri: 9am - 5pm)"));

        final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), howToWelfare);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = howToWelfare.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getActivity().startActivity(intent);
                Log.i("Test", "Test");

            }

        });
        return rootView;

    }
}
