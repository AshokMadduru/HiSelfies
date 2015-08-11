package dsquare.hiselfies.home;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import dsquare.hiselfies.R;
import dsquare.hiselfies.coupons.CouponsFragment;
import dsquare.hiselfies.coupons.CreditsDialog;
import dsquare.hiselfies.findfriends.FindFriendsFragment;
import dsquare.hiselfies.friends.FriendsFragment;
import dsquare.hiselfies.navdrawer.NavAdapter;
import dsquare.hiselfies.selfieworld.SelfieComment;

public class HomeActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private  DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    // slide menu items
    private String[] navMenuTitles;
    private int[] navMenuIcons;

   // private ArrayList<NavDrawerItem> navDrawerItems;
    private NavAdapter adapter;

    CreditsDialog dialog;

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        String name = "Android User";
        int profileImage = R.drawable.selfie;
        mTitle = mDrawerTitle = getTitle();

        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);
        navMenuIcons = getResources().getIntArray(R.array.nav_drawer_icons);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new NavAdapter(navMenuTitles, navMenuIcons, name, profileImage,this);
        mRecyclerView.setAdapter(mAdapter);

        final GestureDetector mGestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {

            @Override public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });


        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(),motionEvent.getY());



                if(child!=null && mGestureDetector.onTouchEvent(motionEvent)){
                    mDrawerLayout.closeDrawers();
                    Fragment fragment = null;
                    Bundle bundle ;
                    int position=recyclerView.getChildPosition(child);

                    switch (position) {

                        case 1:
                            fragment = new HomeFragment();
                            break;
                        case 2:
                            break;
                        case 3:

                            break;
                        case 4:
                            fragment = new FriendsFragment();
                            break;
                        case 5:
                            fragment = new FindFriendsFragment();
                            break;
                        case 6:

                            break;
                        case 7:
                            fragment=new CouponsFragment();
                            break;
                        case 8:

                            break;
                        default:
                            break;
                    }
                    if (fragment != null) {
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.content_frame, fragment).commit();
                    }else{
                        Toast.makeText(getApplicationContext(),"null fragment",Toast.LENGTH_LONG).show();
                    }



                    return true;

                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }
        });
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar,
                R.string.app_name,
                R.string.app_name
        ) {
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);




//        mDrawerToggle.syncState();


       /* if (savedInstanceState == null) {
            // on first time display view for first nav item
            displayView(0);

        }*/
    }
       //toolbar.setNavigationIcon(R.mipmap.nav);
      /*  toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("NICK", "button button button..................");
            }
        });*/

//        mDrawerToggle.syncState();


       /*// mDrawerList = (ListView) findViewById(R.id.RecyclerView);



       // toolbar.setNavigationIcon(R.mipmap.nav);

        navDrawerItems = new ArrayList<NavDrawerItem>();
        navDrawerItems.add(new NavDrawerItem(null,0,"Android User",R.drawable.selfie,null));
        navDrawerItems.add(new NavDrawerItem(null,0,null,0,"categories"));

        for(int i=0;i<navMenuTitles.length;i++){
            navDrawerItems.add(new NavDrawerItem(navMenuTitles[i],
                    navMenuIcons.getResourceId(i, -1),null,0,null));
        }

        // Recycle the typed array
        navMenuIcons.recycle();

        // setting the nav drawer list adapter
        adapter = new NavDrawerAdapter(getApplicationContext(),R.layout.nav_drawer_list,navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_SHOW_HOME);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.nav);


        mDrawerToggle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());
*/


    public void selfieComment(View view){
        Intent intent=new Intent(this,SelfieComment.class);
        startActivity(intent);
    }


   /* public void gotoSelfieWorldActivity(View view){

        Bundle bundle = new Bundle();
        bundle.putBoolean("selfie", true);
        bundle.putBoolean("groupfie", false);
        bundle.putBoolean("event", false);
        Fragment fragment = new TabsFragment();
        fragment.setArguments(bundle);


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();


    }

    public void gotoGroupfieWorldActivity(View view){
        Bundle bundle = new Bundle();
        bundle.putBoolean("selfie", false);
        bundle.putBoolean("groupfie", true);
        bundle.putBoolean("event", false);
        Fragment fragment = new TabsFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
    }
    public void gotoEventsActivity(View view){

        Bundle bundle = new Bundle();
        bundle.putBoolean("selfie", false);
        bundle.putBoolean("groupfie", false);
        bundle.putBoolean("event", true);
        Fragment fragment = new TabsFragment();
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
    }*/
    public void gotoCouponsActivity(View view){

        Fragment fragment = new CouponsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
    }
    public void gotoFriendsActivity(View view){

        Fragment fragment = new FriendsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
    }
    public void gotoFindFriendsActivity(View view){

        Fragment fragment = new FindFriendsFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content_frame, fragment).commit();
    }

    public void openCatagories(View view){
        PopupMenu menu=new PopupMenu(this,(ImageView)findViewById(R.id.menu_coupons));
        menu.getMenuInflater()
                .inflate(R.menu.menu_coupons, menu.getMenu());
        menu.show();
    }

    public void openCredits(View view){
        dialog=new CreditsDialog();
        dialog.show(getFragmentManager(), "CreditsDialog");
    }
    public void closeCreditsDialog(View view){
        dialog.dismiss();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title

        // Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /***
     * Called when invalidateOptionsMenu() is triggered
     */
   /* @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        // if nav drawer is opened, hide the action items
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }*/

    /*@Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }*/

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
//       mDrawerToggle.syncState();
    }
/*
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
       // mDrawerToggle.onConfigurationChanged(newConfig);
    }*/

    }

