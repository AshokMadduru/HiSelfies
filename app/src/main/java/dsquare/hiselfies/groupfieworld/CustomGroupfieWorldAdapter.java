package dsquare.hiselfies.groupfieworld;

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
public class CustomGroupfieWorldAdapter extends ArrayAdapter<CustomGroupfieWorld> {

    Context context;
    int resource;
    List<CustomGroupfieWorld> imageData=null;
    public CustomGroupfieWorldAdapter(Context context,int resource,List<CustomGroupfieWorld> ojbects){
        super(context,resource,ojbects);
        this.context=context;
        this.resource=resource;
        this.imageData=ojbects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomGroupfieWorld customgroupfie = getItem(position);
        LayoutInflater inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);
        ImageView image1 = (ImageView)view.findViewById(R.id.groupfieworld1);
        ImageView image2 = (ImageView)view.findViewById(R.id.groupfieworld2);
        if(customgroupfie.getResId1()!=0){
            image1.setImageResource(customgroupfie.getResId1());
        }
        if(customgroupfie.getResId2()!=0){
            image2.setImageResource(customgroupfie.getResId2());
        }

        return view;
    }
}
