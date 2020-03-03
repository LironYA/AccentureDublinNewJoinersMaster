package com.example.android.accenturenewjoiners.Activities.HealthCare;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
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
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListAdapter;
import com.example.android.accenturenewjoiners.Activities.Transportation.ArrayListFragments;
import com.example.android.accenturenewjoiners.R;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import java.util.ArrayList;


public class HealthCareIreland extends AppCompatActivity {
    private RelativeLayout rLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_list_activity);
        setTitle("Accenture Locations");
        rLayout = (RelativeLayout) findViewById(R.id.rl);
        final Context context = getApplicationContext();
        final FloatingActionsMenu main = (FloatingActionsMenu)findViewById(R.id.main);
        final FloatingActionButton info = (FloatingActionButton) findViewById(R.id.info);
//Fab Actions
        //Pressing on the info icon
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
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
                info_text.setText("Find information about health care services in Ireland.");
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
                popupWindow.showAtLocation(rLayout, Gravity.CENTER,0,0);
            }
        });

        final FloatingActionButton contact = (FloatingActionButton) findViewById(R.id.contact);
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContactUsActivity.class);
                startActivity(intent);

            }
        });
        final ArrayList<ArrayListFragments> healthcare = new ArrayList<ArrayListFragments>();
        healthcare.add(new ArrayListFragments("https://en.wikipedia.org/wiki/Healthcare_in_the_Republic_of_Ireland","Healthcare in the Republic of Ireland", "https://upload.wikimedia.org/wikipedia/en/thumb/8/80/Wikipedia-logo-v2.svg/1200px-Wikipedia-logo-v2.svg.png", "Wikipedia page."));
        healthcare.add(new ArrayListFragments("https://www.vhi.ie/home","Vhi Healthcare", "https://www.vhi.ie/images/footer/vhi-logo.png", "Private health insurance."));
        healthcare.add(new ArrayListFragments("https://www.layahealthcare.ie","Laya Healthcare", "https://www.layahealthcare.ie/media/layahealthcare/desktopsite/newhomepage/images/laya-AIG-cmyk.png", "Private health insurance."));
        healthcare.add(new ArrayListFragments("https://www.aviva.ie","Aviva Group Ireland", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Aviva_Logo.svg/1200px-Aviva_Logo.svg.png", "Private health insurance."));
        healthcare.add(new ArrayListFragments("https://www.revenue.ie/en/personal-tax-credits-reliefs-and-exemptions/health-and-age/health-expenses/index.aspx","Health expenses (Tax relief)", "https://data.gov.ie/img/org_logos/revenue-commissioners.png", "You can claim relief on the cost of health expenses."));
        healthcare.add(new ArrayListFragments("https://www.hse.ie/eng/about/who/acute-hospitals-division/patient-care/emergency-care","List of Hospitals in Ireland", "https://www2.hse.ie/imagelibrary/site-logo.png", "There are currently 29 Emergency Departments (EDs) in Ireland."));
        healthcare.add(new ArrayListFragments("https://www.hse.ie/eng/about/who/acute-hospitals-division/patient-care/maternity-care","Maternity Care", "https://www2.hse.ie/imagelibrary/site-logo.png", "Every woman who is pregnant and ordinarily resident in Ireland is entitled to maternity care under the Maternity and Infant Scheme."));

        final ArrayListAdapter adapter = new ArrayListAdapter(getApplicationContext().getApplicationContext(), healthcare);

        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                ArrayListFragments luas_sites = healthcare.get(position);
                Uri siteURL = Uri.parse(luas_sites.getURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                getApplicationContext().getApplicationContext().startActivity(intent);
                Log.i("Test", "Test");

            }

        });


    }
}


