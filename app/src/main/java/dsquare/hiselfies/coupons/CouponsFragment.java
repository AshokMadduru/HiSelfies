package dsquare.hiselfies.coupons;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import dsquare.hiselfies.R;

/**
 * Created by Dsquare-2 on 10-08-2015.
 */
public class CouponsFragment extends Fragment {
    ListView listView;
    Context context;
    ArrayAdapter<CustomCoupons> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coupons, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new CustomCouponsAdapter(context, R.layout.custom_coupons,
                new ArrayList<CustomCoupons>());
        listView = (ListView)getActivity().findViewById(R.id.couponsList);
        listView.setAdapter(adapter);
        new CouponsTask().execute();
    }

    public class CouponsTask extends AsyncTask<Void,String,Void> {
        ArrayAdapter<CustomCoupons> custom;
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("async", "in asnc");
            for(int i=0;i<9;i++){
                publishProgress(String.valueOf(R.drawable.selfie),String.valueOf(
                        R.drawable.selfie));
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            custom = (ArrayAdapter<CustomCoupons>) listView.getAdapter();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            custom.add(new CustomCoupons(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1])));
        }
    }
}
