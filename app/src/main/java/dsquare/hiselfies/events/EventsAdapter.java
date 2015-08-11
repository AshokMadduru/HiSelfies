package dsquare.hiselfies.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

import dsquare.hiselfies.R;

/**
 * Created by Dsquare-2 on 10-08-2015.
 */
public class EventsAdapter extends ArrayAdapter<Events> {

    Context context;
    int resource;
    List<Events> imageData=null;
    public EventsAdapter(Context context,int resource,List<Events> ojbects){
        super(context,resource,ojbects);
        this.context=context;
        this.resource=resource;
        this.imageData=ojbects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Events event = getItem(position);
        LayoutInflater inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);
        ImageView image1 = (ImageView)view.findViewById(R.id.eventimage1);
        ImageView image2 = (ImageView)view.findViewById(R.id.eventimage2);
        if(event.getResId1()!=0){
            image1.setImageResource(event.getResId1());
        }
        if(event.getResId2()!=0){
            image2.setImageResource(event.getResId2());
        }

        return view;
    }
}
