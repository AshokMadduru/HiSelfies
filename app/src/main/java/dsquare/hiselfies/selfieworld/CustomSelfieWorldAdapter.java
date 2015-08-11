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
public class CustomSelfieWorldAdapter extends ArrayAdapter<CustomSelfieWorld> {
    Context context;
    int resource;
    List<CustomSelfieWorld> imageData=null;
    public CustomSelfieWorldAdapter(Context context,int resource,List<CustomSelfieWorld> ojbects){
        super(context,resource,ojbects);
        this.context=context;
        this.resource=resource;
        this.imageData=ojbects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomSelfieWorld customSelfie = getItem(position);
        LayoutInflater inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);
        ImageView image1 = (ImageView)view.findViewById(R.id.selfieworld1);
        ImageView image2 = (ImageView)view.findViewById(R.id.selfieworld2);
        if(customSelfie.getResId1()!=0){
            image1.setImageResource(customSelfie.getResId1());
        }
        if(customSelfie.getResId2()!=0){
            image2.setImageResource(customSelfie.getResId2());
        }

        return view;
    }
}
