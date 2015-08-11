package dsquare.hiselfies.coupons;

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
public class CustomCouponsAdapter extends ArrayAdapter<CustomCoupons> {
    Context context;
    int resource;
    List<CustomCoupons> imageData=null;
    public CustomCouponsAdapter(Context context,int resource,List<CustomCoupons> ojbects){
        super(context,resource,ojbects);
        this.context=context;
        this.resource=resource;
        this.imageData=ojbects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CustomCoupons event = getItem(position);
        LayoutInflater inflater = (LayoutInflater)context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(resource, parent, false);
        ImageView image1 = (ImageView)view.findViewById(R.id.foodpanda);
        ImageView image2 = (ImageView)view.findViewById(R.id.gopaisa);
     /*   if(event.getResId1()!=0){
            image1.setImageResource(event.getResId1());
        }
        if(event.getResId2()!=0){
            image2.setImageResource(event.getResId2());
        }*/

        return view;
    }

}
