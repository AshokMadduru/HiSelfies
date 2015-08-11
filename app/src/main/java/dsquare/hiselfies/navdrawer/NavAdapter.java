package dsquare.hiselfies.navdrawer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import dsquare.hiselfies.R;

/**
 * Created by Dsquare-2 on 10-08-2015.
 */
public class NavAdapter extends RecyclerView.Adapter<NavAdapter.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private String mNavTitles[];
    private int mIcons[];

    private String name;
    private int profile;
    Context context;



    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        int Holderid;
        TextView textView;
        ImageView imageView;
        ImageView profile;
        TextView Name;
        Context context;

        public ViewHolder(View itemView,int ViewType) {
            super(itemView);

            if(ViewType == TYPE_ITEM) {
                textView = (TextView) itemView.findViewById(R.id.row_text);
                imageView = (ImageView) itemView.findViewById(R.id.row_icon);
                Holderid = 1;
            }
            else{
                Name = (TextView) itemView.findViewById(R.id.drawer_header_title);
                profile = (ImageView) itemView.findViewById(R.id.circleView);
                Holderid = 0;
            }
        }

        @Override
        public void onClick(View v) {
            Log.d("onclick","yes");
            Toast.makeText(context, "The Item Clicked is: " + getPosition(), Toast.LENGTH_SHORT).show();

        }
    }
    public  NavAdapter(String Titles[],int Icons[],String Name, int Profile,Context passedContext){

        mNavTitles = Titles;
        mIcons = Icons;
        name = Name;
        profile = Profile;
        this.context = passedContext;



    }

    @Override
    public NavAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.nav_drawer_list,parent,false);

            ViewHolder vhItem = new ViewHolder(v,viewType);

            return vhItem;

        } else if (viewType == TYPE_HEADER) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.nav_header,parent,false);

            ViewHolder vhHeader = new ViewHolder(v,viewType);

            return vhHeader;


        }
        return null;

    }


    @Override
    public void onBindViewHolder(NavAdapter.ViewHolder holder, int position) {
        if(holder.Holderid ==1) {

            holder.textView.setText(mNavTitles[position - 1]);
            holder.imageView.setImageResource(mIcons[position -1]);
        }
        else{

            holder.profile.setImageResource(profile);
            holder.Name.setText(name);

        }
    }
    @Override
    public int getItemCount() {
        return mNavTitles.length+1;
    }
    @Override
    public int getItemViewType(int position) {
        if (isPositionHeader(position))
            return TYPE_HEADER;

        return TYPE_ITEM;
    }

    private boolean isPositionHeader(int position) {
        return position == 0;
    }


}
