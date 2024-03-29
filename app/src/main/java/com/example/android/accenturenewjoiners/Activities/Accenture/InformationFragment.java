package com.example.android.accenturenewjoiners.Activities.Accenture;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.Fragment;
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

public class InformationFragment extends Fragment {
    public InformationFragment() {
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
                info_text.setText("Here you can find an easy way to find all of Accenture's important links.");
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
        final ArrayList<ArrayListFragments> generalInformation = new ArrayList<ArrayListFragments>();

       // generalInformation.add(new ArrayListFragments("https://in.accenture.com/aboutaccenture/","About Accenture", "https://www.accenture.com/t20190513t185056z__w__/us-en/_acnmedia/accenture/redesign-assets/dotcom/images/global/hero/4/accenture-digital-consulting-marquee-610x425.png", "Acenture's Vision and Businesses\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://portal.accenture.com","Personal Information", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Get your personal information at Accenture's Portal.\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://myid.accenture.com/","Accenture Password", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Accenture Password Change / Unlock at myID Portal.\n Log in required."));
        generalInformation.add(new ArrayListFragments("https://myte.accenture.com/OGTE/dashboard/DashboardPage.aspx","Time and Expenses", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Get your personal information in Accenture's Portal.\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://in.accenture.com/mymoney/ie/","Pay Slips", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Get your personal payslips.\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://livechat.boldchat.com/aid/619972462108365636/mobilechat/visitor.jsp?resize=true&cbdid=2993680843131824193&wdid=2628821680852161677&url=https%3A%2F%2Fvmss.boldchat.com%2Faid%2F619972462108365636%2Fgenerate%2Fgenerate_chat_html.jsp%3FaccountID%3D619972462108365636%26website%3D2628821680852161677%26security%3D0%26passCustom%3D1%26type%3Dbutton%26websiteName%3DAccenture%2BUKI%2BPeopleline%2BPRODUCTION%2B(Live)%26windowName%3DAccenture%2BUKI%2BPeopleline%2BPRODUCTION%2B(Live)%26departmentName%3DAccenture%2BUKI%2BPeopleline%2B-%2BPRODUCTION%2B(Live)%26buttonName%3DAccenture%2BUKI%2BPeopleline%2BPRODUCTION%2B(Live)%26button%3D2993680843131824193%26encodeAsHtml%3D0%26availableText%3DAccenture%2BPeopleLine%2BUKI%26broaderDomain%3D.boldchat.com&queueToken=1505823425463TDEF13C01DB1BA9409ABB3006382E02973FD41319EC29842AA47F0C4D906E045B3C5F4E032875D4E7EA1E2231C07FAA252FA7B786224145A8C0022A33FFEF5E7D&vr=&vi=&ve=&vp=&vn=&lc=&_bcvm_vrid_=true","Chat with HR Peopleline", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "The Peopleline team is available between 08:30 am to 05:30 pm Monday to Friday.\nLog in required."));
        generalInformation.add(new ArrayListFragments("https://pages.goview.accenture.com/page.aspx?QS=38dfbe491fab00eace450ee73709cb0d5e801954bd27905d757db40c3dea91fa","Subscribe to Accenture's Newsletter", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Get the latest insights and research\n" + "delivered straight to your inbox."));
        generalInformation.add(new ArrayListFragments("https://careersmarketplace.accenture.com/#/","Search internal Jobs at Accenture", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Find your next challenge.\n Log in required."));
        generalInformation.add(new ArrayListFragments("https://www.accenture.com/ie-en/careers/jobsearch","Search external Jobs at Accenture", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Open positions for potential employees.\n Find an open position and use the referral program below to recommend a friend."));
        generalInformation.add(new ArrayListFragments("https://employeereferralprogram.accenture.com/#/index","Employee Referral Program", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Help create the best team and earn rewards.\n Log in required."));
        generalInformation.add(new ArrayListFragments("https://support.accenture.com/support_portal","Support", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Site to get support and services for technology, human resources, internal operations, people mobility, workplace services, and project applications.\n Log in required."));
        generalInformation.add(new ArrayListFragments("https://in.accenture.com/globalwatch/asoc","Accenture Security Operations Center (ASOC)", "https://www.accenture.com/t20190226T034134Z__w__/us-en/_acnmedia/Accenture/Redesign-Assets/DotCom/Images/Global/General/3/Accenture-Strategy-Transparent-610x425.png", "Report for urgent security matters and lost or stolen devices\n ASOC is available 24 hours a day, seven days a week, 365 days a year at +1-202-728-0645.\n Log in required."));

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
