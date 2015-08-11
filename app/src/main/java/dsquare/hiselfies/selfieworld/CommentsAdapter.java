package dsquare.hiselfies.selfieworld;

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
public class CommentsAdapter extends ArrayAdapter<Comments> {

        Context context;
        int resource;
        List<Comments> imageData=null;
public CommentsAdapter(Context context,int resource,List<Comments> ojbects){
        super(context,resource,ojbects);
        this.context=context;
        this.resource=resource;
        this.imageData=ojbects;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        Comments customgroupfie = getItem(position);
        LayoutInflater inflater = (LayoutInflater)context.
        getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);
        ImageView image1 = (ImageView)view.findViewById(R.id.comments_image);


        return view;
        }
}
