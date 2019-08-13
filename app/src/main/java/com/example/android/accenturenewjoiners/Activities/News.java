package com.example.android.accenturenewjoiners.Activities;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.accenturenewjoiners.R;

import java.util.ArrayList;
import java.util.List;

//TO-DO: add floating button of more country news (intent)
public class News extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<GetNews>>,
        SharedPreferences.OnSharedPreferenceChangeListener {


    private static final String COUNTRY_NEWS = "https://content.guardianapis.com/search";
    private ProgressBar progressBar;
    private int LOADER_ID = 1;
    // TextView that is displayed when the list is empty
    private TextView emptyStateTextView;
    private NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        ListView newsView = (ListView) findViewById(R.id.list);
        final SharedPreferences sharedPrefsButton = PreferenceManager.getDefaultSharedPreferences(this);
        final String initialButtonValue = sharedPrefsButton.getString(getString(R.string.settings_query_key),getString(R.string.setting_query_default_value));

        // Obtain a reference to the SharedPreferences file for this app
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // And register to be notified of preference changes
        // So we know when the user has adjusted the query settings

        prefs.registerOnSharedPreferenceChangeListener(this);
        // If there's no data to display, show the empty_view TextBox

        emptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsView.setEmptyView(emptyStateTextView);
        //Progress Bar
        progressBar = (ProgressBar) findViewById(R.id.loading_spinner);
        //Check if there is internet connection
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();
            // Initialize the loader.
            loaderManager.initLoader(LOADER_ID, null, this);
            // Find a reference to the {@link ListView} in the layout
        } else {
            progressBar.setVisibility(View.GONE);
            emptyStateTextView.setText("No internet connection");
        }
        adapter = new NewsAdapter(News.this, new ArrayList<GetNews>());
        newsView.setAdapter(adapter);
        newsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                GetNews currentNews = adapter.getItem(position);
                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri newsUri = Uri.parse(currentNews.getURL());

                // Create a new intent
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
        //Open local news sites
        final Button localNewsButton = (Button) findViewById(R.id.button_local_news);
       // localNewsButton.setText("Local news for " + initialButtonValue);

        localNewsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String queryButton = sharedPrefsButton.getString(getString(R.string.settings_query_key),getString(R.string.setting_query_default_value));
                //Open news site for England
                if(queryButton.equals("England")) {
                    String url = "https://www.mirror.co.uk";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Russia
                if(queryButton.equals("Russia")) {
                    String url = "https://www.themoscowtimes.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Germany
                if(queryButton.equals("Germany")) {
                    String url = "https://www.thelocal.de";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Portugal
                if(queryButton.equals("Portugal")) {
                    String url = "https://www.theportugalnews.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Romania
                if(queryButton.equals("Romania")) {
                    String url = "https://www.romania-insider.com";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Ireland
                if(queryButton.equals("Ireland")) {
                    String url = "https://www.breakingnews.ie";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for France
                if(queryButton.equals("France")) {
                    String url = "https://www.france24.com/en";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Italy
                if(queryButton.equals("Italy")) {
                    String url = "https://www.thelocal.it";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Canada
                if(queryButton.equals("Canada")) {
                    String url = "https://globalnews.ca/canada";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Japan
                if(queryButton.equals("Japan")) {
                    String url = "https://japantoday.com/";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Poland
                if(queryButton.equals("Poland")) {
                    String url = "https://www.tvn24.pl/tvn24-news-in-english,157,m";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Norway
                if(queryButton.equals("Norway")) {
                    String url = "https://www.thelocal.no";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                //Open news site for Greece
                if(queryButton.equals("Greece")) {
                    String url = "https://greece.greekreporter.com/category/greek-news";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                }
                Toast.makeText(getApplicationContext(), "Opening local country news for " + queryButton, Toast.LENGTH_LONG).show();
//                localNewsButton.setText("Local news for " + queryButton);
            }
        });
        }

    @Override
    public Loader<List<GetNews>> onCreateLoader(int i, Bundle bundle) {
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        // getString retrieves a String value from the preferences. The second parameter is the default value for this preference.
     //   String order_by = sharedPrefs.getString(getString(R.string.settings_order_by_key),getString(R.string.settings_order_by_newest_value));
        String query = sharedPrefs.getString(getString(R.string.settings_query_key),getString(R.string.setting_query_default_value));
        String section_news = sharedPrefs.getString(getString(R.string.settings_sections_key), getString(R.string.setting_section_default_value));
        // parse breaks apart the URI string that's passed into its parameter
        Uri baseUri = Uri.parse(COUNTRY_NEWS);

        // buildUpon prepares the baseUri that we just parsed so we can add query parameters to it
        Uri.Builder uriBuilder = baseUri.buildUpon();
        // Append query parameter and its value. For example, the `format=geojson`
        // https://content.guardianapis.com/search?section=games&from-date=2017-01-01
        // &to-date=2018-01-01&order-by=newest&use-date=published&q=%22final%20fantasy%22&api-key=c018038d-3e83-48f8-9208-c09dd8c08614
        // &show-tags=contributor&show-fields=thumbnail

        uriBuilder.appendQueryParameter("section", section_news);
       // uriBuilder.appendQueryParameter("from-date", "2019-05-01");
       // uriBuilder.appendQueryParameter("to-date", "2019-08-08");
        uriBuilder.appendQueryParameter("order-by", "newest");
        uriBuilder.appendQueryParameter("format", "json");
        uriBuilder.appendQueryParameter("use-date", "published");
       // uriBuilder.appendQueryParameter("type", "article");
        uriBuilder.appendQueryParameter("q", query);
        uriBuilder.appendQueryParameter("page-size", "50");
        uriBuilder.appendQueryParameter("api-key", "c018038d-3e83-48f8-9208-c09dd8c08614");
        uriBuilder.appendQueryParameter("show-tags", "contributor");
        uriBuilder.appendQueryParameter("show-fields", "thumbnail");
        return new NewsLoader(this, uriBuilder.toString());
    }
    @Override
    public void onLoadFinished(Loader<List<GetNews>> loader, List<GetNews> news) {
        progressBar.setVisibility(View.GONE);
        emptyStateTextView.setText("No news found, click on local news or try again later");
        adapter.clear();

        if (news != null && !news.isEmpty()) {
            adapter.addAll(news);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<GetNews>> loader) {
        adapter.clear();
    }

    @Override
    // This method initialize the contents of the Activity's options menu.
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_news, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
        if(key.equals(getString(R.string.settings_query_key)) || key.equals(getString(R.string.settings_sections_key)))
        {
            adapter.clear();
            // Hide the empty state text view as the loading indicator will be displayed
            emptyStateTextView.setVisibility(View.GONE);
            // Show the loading indicator while new data is being fetched
            View loadingIndicator = findViewById(R.id.loading_spinner);
            loadingIndicator.setVisibility(View.VISIBLE);

            // Restart the loader to requery the USGS as the query settings have been updated
            getLoaderManager().restartLoader(LOADER_ID, null, this);
        }
    }
}
