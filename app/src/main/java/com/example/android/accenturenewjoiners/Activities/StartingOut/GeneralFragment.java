package com.example.android.accenturenewjoiners.Activities.StartingOut;

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

    public class GeneralFragment extends Fragment {

        public GeneralFragment() {
            // Required empty public constructor
        }
        @Override
        public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_list_activity, container, false);

            final ArrayList<ArrayListFragments> general = new ArrayList<ArrayListFragments>();
            general.add(new ArrayListFragments("https://en.wikipedia.org/wiki/Ireland","Ireland's Wikipedia page", "http://pngimg.com/uploads/wikipedia/wikipedia_PNG33.png", "Find information about Irish history, economy, geography and more."));
            general.add(new ArrayListFragments("https://www.dublinairport.com/to-from-the-airport/by-bus/dublin-buses","Dublin Bus from the Airport", "https://www.dublinairport.com/images/default-source/to-and-from-airport/bus-airlink.png?sfvrsn=5f7a88c0_2", "If you travel light, you can take a bus from the airport for only 7€ or 12€ return."));
            general.add(new ArrayListFragments("https://play.google.com/store/apps/details?id=com.airbnb.android&hl=en","AirBNB App", "https://lh3.googleusercontent.com/BQnvuZR500pg2ulvv3FBmRI93ODz3AjNfbz92hCieuJLvmbGY36AKhETMTTfTDgpPQI=s180-rw", "The world's leading app for short term housing."));
            general.add(new ArrayListFragments("https://play.google.com/store/apps/details?id=com.booking","Booking.com App", "https://lh3.googleusercontent.com/A0QsKezU_em5H1IiwKUUluEDOK7VuGVNLii3FVL89NDVKVvRsOSHjS5AeLAUywYhArE3=s180-rw", "Hotels, apartments, hostels and vacation rentals."));
            general.add(new ArrayListFragments("https://aib.ie/our-products/current-accounts/online-bank-account-opening","AIB Bank", "https://aib.ie/etc/designs/aib/designtemplates/personal/_jcr_content/contentpage/header/primaryNavigation/logocomponent.img.png/1478874057518.png", "Online Account Opening."));
            general.add(new ArrayListFragments("https://www.bankofireland.com/help-centre/faq/identification-documents-need-open-current-account/","Bank of Ireland", "https://www.bitcni.org.uk/wp-content/uploads/2019/01/bank-of-ireland-copy.png", "Account opening, Branches locator and needed identification documents."));
            general.add(new ArrayListFragments("https://digital.ulsterbank.ie/personal/current-accounts.html", "Ulster Bank", "https://www.galwaychamber.com/wp-content/uploads/2016/01/Ulster-Bank-logo.jpg", "Account opening, compare accounts and needed identification documents.."));
            general.add(new ArrayListFragments("https://transferwise.com/us/blog/opening-a-bank-account-in-ireland","Account opening information", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/TransferWise_logo.svg/1280px-TransferWise_logo.svg.png", "How to open a bank account in Ireland blog by Transfer Wise."));
            general.add(new ArrayListFragments("http://www.moneyguideireland.com/credit-card-offers/credit-cards-with-the-lowest-interest-rates","Credit Card Rates", "http://www.pngall.com/wp-content/uploads/2018/05/Euro-Symbol-PNG-Clipart.png", "Find the interest rates on most of the credit cards available in Ireland."));
            general.add(new ArrayListFragments("https://www.citizensinformation.ie/en/employment/employment_rights_and_conditions/leave_and_holidays/public_holidays_in_ireland.html","Public Holidays", "https://www.ireland.ie/media/ireland/partnerlogos/Logo-Citizens-Information-500-x-175.png", "There are 9 public holidays in Ireland each year."));
            general.add(new ArrayListFragments("http://www.moneyguideireland.com/international-call-rates-from-irish-mobiles.html","International Phone Calls from Ireland", "http://www.pngall.com/wp-content/uploads/2018/05/Euro-Symbol-PNG-Clipart.png", "Find international calls rates from Irish mobile phone networks."));
            general.add(new ArrayListFragments("https://www.ndls.ie/holders-of-foreign-licences.html#to-apply-to-exchange-a-foreign-driving-licence-issued-by-a-member-state-of-the-european-union-european-economic-area","Holders of Foreign Driving Licences", "http://www.highlandradio.com/wp-content/uploads/2016/07/ndls.png", "Get information about foreign licences in Ireland ."));
            general.add(new ArrayListFragments("https://www.ndls.ie/how-to-apply.html","Driving Licence information", "http://www.highlandradio.com/wp-content/uploads/2016/07/ndls.png", "How to apply, fees, licence terms, documentation."));
            general.add(new ArrayListFragments("https://ndls.rsa.ie"," National Driver Licence Service (NDLS) Online", "http://www.highlandradio.com/wp-content/uploads/2016/07/ndls.png", "Apply online for your driving licence (myGovID required)."));
            general.add(new ArrayListFragments("https://in.accenture.com/aboutaccenture/","Book an appointment at the National Driver Licence Service", "http://www.highlandradio.com/wp-content/uploads/2016/07/ndls.png", "Online appointment for any of the 36 NDLS centres."));
            general.add(new ArrayListFragments("https://theorytest.ie/", "RSA Driver Theory Test", "https://theorytest.ie/wp-content/uploads/theory-test-ireland-dtt-logo-220.png", "Here you will find information on how to book your Theory Test, reschedule or cancel your test."));

            final ArrayListAdapter adapter = new ArrayListAdapter(getActivity(), general);

            final ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    ArrayListFragments general_information = general.get(position);
                    Uri siteURL = Uri.parse(general_information.getURL());
                    Intent intent = new Intent(Intent.ACTION_VIEW, siteURL);
                    getActivity().startActivity(intent);
                    Log.i("Test", "Test");

                }

            });
            return rootView;

        }
    }
