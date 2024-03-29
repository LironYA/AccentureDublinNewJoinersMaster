package com.example.android.accenturenewjoiners.Activities;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.android.accenturenewjoiners.Activities.ContactUs.ContactUsActivity;
import com.example.android.accenturenewjoiners.R;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import java.util.ArrayList;
import java.util.List;

public class Locations extends AppCompatActivity {
    private List<RecyclerViewItem> itemList = null;
    private CoordinatorLayout cLayout;
    private PopupWindow PopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        setTitle("Accenture's Locations");
       // final View actionB = findViewById(R.id.action_b);
        cLayout = (CoordinatorLayout) findViewById(R.id.cl);

        final Context context = getApplicationContext();
        final FloatingActionsMenu main = (FloatingActionsMenu)findViewById(R.id.main);
        final FloatingActionButton info = (FloatingActionButton) findViewById(R.id.info);
        //Pressing on the info icon
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
                // Inflate the custom layout/view
                final View customView = inflater.inflate(R.layout.popup_info, null);
                main.collapse();
                // Initialize a new instance of popup window
                PopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                if (Build.VERSION.SDK_INT >= 21) {
                    PopupWindow.setElevation(5.0f);
                }
                TextView info_text = (TextView) customView.findViewById(R.id.info_text);
                info_text.setText("Find Accenture's locations across Dublin.\n Get directions from your current location.");
                Button closeButton = (Button) customView.findViewById(R.id.close_button_popup);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        PopupWindow.dismiss();
                    }

                });
                Button close = (Button) customView.findViewById(R.id.close);
                close.setOnClickListener(new View.OnClickListener() {
                @Override
                 public void onClick(View view) {
                 // Dismiss the popup window
                 PopupWindow.dismiss();
                 }
                 });
                PopupWindow.showAtLocation(cLayout, Gravity.CENTER,0,0);
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
                final FloatingActionButton home = (FloatingActionButton) findViewById(R.id.home);
                home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, MainScreen.class);
                        startActivity(intent);
                    }
                });
                // Item list - card view
                initializeItemList();
                RecyclerView recyclerView = (RecyclerView) findViewById(R.id.card_view_recycler_list);
                recyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
                // Create the grid layout manager with 1 column.
                GridLayoutManager gridLayoutManager = new GridLayoutManager(context, 1);
                // Set layout manager.
                recyclerView.setLayoutManager(gridLayoutManager);
                // Create car recycler view data adapter with car item list.
                RecyclerViewDataAdapter DataAdapter = new RecyclerViewDataAdapter(itemList);
                // Set data adapter.
                recyclerView.setAdapter(DataAdapter);
                recyclerView.addOnItemTouchListener(
                        new RecyclerItemClickListener(context, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                if (position == 0) {
                                    //The Dock
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                            Uri.parse("https://www.google.com/maps?daddr=53.343981, -6.233636"));
                                    startActivity(intent);
                                }
                                //Grand Canal
                                if (position == 1) {
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                            Uri.parse("https://www.google.com/maps?daddr=53.343505, -6.239066"));
                                    startActivity(intent);
                                }
                                //Eastpoint
                                if (position == 2) {
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                                            Uri.parse("https://www.google.com/maps?daddr=53.357912, -6.225300"));
                                    startActivity(intent);
                                }
                                //Sandyford
                                if (position == 3) {
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                            Uri.parse("https://www.google.com/maps?daddr=53.267332, -6.197447"));
                                    startActivity(intent);
                                }
                                //The Academy
                                if (position == 4) {
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                            Uri.parse("https://www.google.com/maps?daddr=53.344569, -6.250235"));
                                    startActivity(intent);
                                }
                                //Grand Canal 3
                                if (position == 5) {
                                    Intent intent = new Intent(android.content.Intent.ACTION_VIEW,

                                            Uri.parse("https://www.google.com/maps?daddr=53.339275, -6.238778"));
                                    startActivity(intent);
                                }
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                        }));

            }

            /* Initialise items in list. */
            private void initializeItemList() {
                if (itemList == null) {
                    itemList = new ArrayList<RecyclerViewItem>();
                    itemList.add(new RecyclerViewItem("Accenture The Dock\n7 Hanover Quay, Grand Canal Dock, Dublin 4", R.drawable.thedock));
                    itemList.add(new RecyclerViewItem("Accenture Grand Canal\n 1 Grand Canal Square, Grand Canal Quay, Grand Canal Dock, Dublin 2", R.drawable.grandcanal));
                    itemList.add(new RecyclerViewItem("Accenture Eastpoint Business Park\n Alfie Byrne Rd, Dublin 3", R.drawable.eastpoint));
                    itemList.add(new RecyclerViewItem("Accenture South County Business Park (Sandyford)\n South County Business Park, Carmanhall and Leopardstown, Dublin 18", R.drawable.sandyford));
                    itemList.add(new RecyclerViewItem("Accenture The Academy\n Pearse Street, Dublin 2", R.drawable.academy));
                    itemList.add(new RecyclerViewItem("Accenture Grand Canal\n 3 Grand Canal Plaza, Grand Canal Street Upper, Dublin 4", R.drawable.plaza));
                }
            }
        }