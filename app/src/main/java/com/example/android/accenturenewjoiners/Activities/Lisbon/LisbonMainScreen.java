package com.example.android.accenturenewjoiners.Activities.Lisbon;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.accenturenewjoiners.Activities.AboutUs.AboutUsActivity;
import com.example.android.accenturenewjoiners.Activities.MainScreen;
import com.example.android.accenturenewjoiners.Activities.PrivacyPolicyActivity;
import com.example.android.accenturenewjoiners.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;


public class LisbonMainScreen extends AppCompatActivity {

        private NavigationView navigationView;
        private DrawerLayout drawer;
        private View navHeader;
        private ImageView imgNavHeaderBg, imgProfile;
        private TextView txtName, txtWebsite;
        private Toolbar toolbar;
        private FloatingActionButton fab;

         SharedPreferences sp;

        // urls to load navigation header background image and profile image
        private static final String urlNavHeaderBg = "https://www.accenture.com/t20190226T023011Z__w__/ie-en/_acnmedia/Accenture/Conversion-Assets/MainPages/Images/Global_26/Accenture-Electric-Purple-Logo-marquee.png";
        private static final String urlProfileImg = "https://i.vimeocdn.com/video/724250319_780x439.jpg";

        // index to identify current nav menu item
        public static int navItemIndex = 0;

        // tags used to attach the fragments
        private static final String TAG_HOME = "home";
        private static final String TAG_PHOTOS = "photos";
        private static final String TAG_MOVIES = "movies";
        private static final String TAG_NOTIFICATIONS = "notifications";
        private static final String TAG_SETTINGS = "settings";
        public static String CURRENT_TAG = TAG_HOME;

        // toolbar titles respected to selected nav menu item
        private String[] activityTitles;
        // flag to load home fragment when user presses back key
        private boolean shouldLoadHomeFragOnBackPress = true;
        private Handler mHandler;

        GridView gridview;

        public static String[] osNameList = {
                "About Accenture",
                "Locations",
                "Breaking News",
                "Starting Out in Portugal",
                "Finding a House",
                "Transportation",
                "Bills",
                "Immigration",
                "Revenue",
                "Welfare",
                "Health Care",
                "Emergency Information",
                "Accenture Wellness",
                "HR Information",
                "Report an Incident",
                "Benefits",
                "Relocating with Kids",
                "Things to See",
                "Weather Forcast",
                "Contact Us",
        };
        public static int[] accentureHomeImages = {
                R.drawable.about,
                R.drawable.location,
                R.drawable.news,
                R.drawable.portugal,
                R.drawable.findhouse,
                R.drawable.train,
                R.drawable.euro,
                R.drawable.immigration,
                R.drawable.revenue,
                R.drawable.welfare,
                R.drawable.healthcare,
                R.drawable.emergency,
                R.drawable.wellness,
                R.drawable.hrinfo,
                R.drawable.report,
                R.drawable.benefits,
                R.drawable.abc,
                R.drawable.thingstosee,
                R.drawable.weather,
                R.drawable.contactus,};

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main_lisbon);
            gridview = (GridView) findViewById(R.id.customgrid);
            gridview.setAdapter(new GridViewCustomAdapterLisbon(this, osNameList, accentureHomeImages));
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            sp = getSharedPreferences("country",MODE_PRIVATE);

            setSupportActionBar(toolbar);

            mHandler = new Handler();

            drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            navigationView = (NavigationView) findViewById(R.id.nav_view);
            fab = (FloatingActionButton) findViewById(R.id.fab);
            // Navigation view header
            navHeader = navigationView.getHeaderView(0);
            txtName = (TextView) navHeader.findViewById(R.id.name);
            txtWebsite = (TextView) navHeader.findViewById(R.id.website);
            imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
            imgProfile = (ImageView) navHeader.findViewById(R.id.img_profile);

            // load toolbar titles from string resources
            activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);

            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Questions? We are here to help", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
                    emailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    emailIntent.setType("vnd.android.cursor.item/email");
                    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] {"question@accenture.com"});
                    //TODO: Edit email and subject and content
                    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject");
                    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Content");
                    startActivity(Intent.createChooser(emailIntent, "Please choose an Email app"));
                }
            });
            // load nav menu header data
            loadNavHeader();

            // initializing navigation menu
            setUpNavigationView();

            if (savedInstanceState == null) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_HOME;
                loadHomeFragment();
            }
        }
        /***
         * Load navigation menu header information
         * like background image, profile image
         * name, website, notifications action view (dot)
         */
        private void loadNavHeader() {
            // name, website
            txtName.setText("Welcome to Accenture!");
            txtWebsite.setText("https://www.accenture.com");

            // loading header background image
            Glide.with(this).load(urlNavHeaderBg)
                    //    .crossFade()
                    // .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .transition(withCrossFade())
                    .into(imgNavHeaderBg);

            // Loading profile image
            Glide.with(this).load(urlProfileImg)
                    // .crossFade()
                    .thumbnail(0.5f)
                    .transition(withCrossFade())
                    //  .bitmapTransform(new CircleTransform(this))
                    //   .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imgProfile);

            // showing dot next to notifications label
            navigationView.getMenu().getItem(3).setActionView(R.layout.menu_dot);
        }

        /***
         * Returns respected fragment that user
         * selected from navigation menu
         */
        private void loadHomeFragment() {
            // selecting appropriate nav menu item
            selectNavMenu();

            // set toolbar title
            setToolbarTitle();

            // if user select the current navigation menu again, don't do anything
            // just close the navigation drawer
            if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
                drawer.closeDrawers();

                // show or hide the fab button
                toggleFab();
                return;
            }


            // show or hide the fab button
            toggleFab();

            //Closing drawer on item click
            drawer.closeDrawers();

            // refresh toolbar menu
            invalidateOptionsMenu();
        }


        private void setToolbarTitle() {
            getSupportActionBar().setTitle(activityTitles[navItemIndex]);
        }

        private void selectNavMenu() {
            navigationView.getMenu().getItem(navItemIndex).setChecked(true);
        }

        private void setUpNavigationView() {
            //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

                // This method will trigger on item Click of navigation menu
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {

                    //Check to see which item was being clicked and perform appropriate action
                    switch (menuItem.getItemId()) {
                        //Replacing the main content with ContentFragment Which is our Inbox View;
                        case R.id.nav_home:
                            navItemIndex = 0;
                            //CURRENT_TAG = TAG_HOME;
                            startActivity(new Intent(com.example.android.accenturenewjoiners.Activities.Lisbon.LisbonMainScreen.this, AboutUsActivity.class));
                            break;
                        case R.id.nav_locations:
                            navItemIndex = 1;
                            CURRENT_TAG = TAG_PHOTOS;
                            break;
                        case R.id.nav_transport:
                            navItemIndex = 2;
                            CURRENT_TAG = TAG_MOVIES;
                            break;
                        case R.id.nav_news:
                            navItemIndex = 3;
                            CURRENT_TAG = TAG_NOTIFICATIONS;
                            break;
                        case R.id.nav_wellness:
                            navItemIndex = 4;
                            CURRENT_TAG = TAG_SETTINGS;
                            break;
                        case R.id.nav_about_us:
                            // launch new intent
                            startActivity(new Intent(com.example.android.accenturenewjoiners.Activities.Lisbon.LisbonMainScreen.this, AboutUsActivity.class));
                            drawer.closeDrawers();
                            return true;
                        case R.id.nav_current_weather:
                            // launch new intent
                            startActivity(new Intent(com.example.android.accenturenewjoiners.Activities.Lisbon.LisbonMainScreen.this, PrivacyPolicyActivity.class));
                            drawer.closeDrawers();
                            return true;
                        default:
                            navItemIndex = 0;
                    }

                    //Checking if the item is in checked state or not, if not make it in checked state
                    if (menuItem.isChecked()) {
                        menuItem.setChecked(false);
                    } else {
                        menuItem.setChecked(true);
                    }
                    menuItem.setChecked(true);

                    loadHomeFragment();

                    return true;
                }
            });


            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

                @Override
                public void onDrawerClosed(View drawerView) {
                    // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                    super.onDrawerOpened(drawerView);
                }
            };

            //Setting the actionbarToggle to drawer layout
            drawer.setDrawerListener(actionBarDrawerToggle);

            //calling sync state is necessary or else your hamburger icon wont show up
            actionBarDrawerToggle.syncState();
        }

        @Override
        public void onBackPressed() {
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawers();
                return;
            }

            // This code loads home fragment when back key is pressed
            // when user is in other fragment than home
            if (shouldLoadHomeFragOnBackPress) {
                // checking if user is on other navigation menu
                // rather than home
                if (navItemIndex != 0) {
                    navItemIndex = 0;
                    CURRENT_TAG = TAG_HOME;
                    loadHomeFragment();
                    return;
                }
            }

            super.onBackPressed();
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.

            // show menu only when home fragment is selected
            if (navItemIndex == 0) {
                getMenuInflater().inflate(R.menu.main, menu);
            }

            // when fragment is notifications, load the menu created for notifications
            if (navItemIndex == 3) {
                getMenuInflater().inflate(R.menu.notifications, menu);
            }
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.change_country) {
                sp.edit().remove("country").apply();

                Intent intent = new Intent(this, MainScreen.class);
                startActivity(intent);                return true;
            }

            // user is in notifications fragment
            // and selected 'Mark all as Read'
            if (id == R.id.action_mark_all_read) {
                Toast.makeText(getApplicationContext(), "All notifications marked as read!", Toast.LENGTH_LONG).show();
            }

            // user is in notifications fragment
            // and selected 'Clear All'
            if (id == R.id.action_clear_notifications) {
                Toast.makeText(getApplicationContext(), "Clear all notifications!", Toast.LENGTH_LONG).show();
            }

            return super.onOptionsItemSelected(item);
        }

        // show or hide the fab
        private void toggleFab() {
            if (navItemIndex == 0)
                fab.show();
            else
                fab.hide();
        }
    }





