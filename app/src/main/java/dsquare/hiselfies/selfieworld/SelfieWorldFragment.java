package dsquare.hiselfies.selfieworld;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
public class SelfieWorldFragment extends Fragment {

    public SelfieWorldFragment(){}

    ListView listView;
    Context context;
    ArrayAdapter<CustomSelfieWorld> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_selfie, container,false);
        return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new CustomSelfieWorldAdapter(context, R.layout.custom_selfieworld,
                new ArrayList<CustomSelfieWorld>());
        listView = (ListView)getView().findViewById(R.id.selfie_list);
        listView.setAdapter(adapter);
        new SelfieWorldTask().execute();
    }


    public class SelfieWorldTask extends AsyncTask<Void,String,Void> {
        ArrayAdapter<CustomSelfieWorld> custom;
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("async", "in asnc");
            for(int i=0;i<9;i++){
                publishProgress(String.valueOf(R.drawable.selfie),String.valueOf(
                        R.drawable.selfie),String.valueOf(R.drawable.selfie));
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            custom = (ArrayAdapter<CustomSelfieWorld>) listView.getAdapter();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            custom.add(new CustomSelfieWorld(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1]),Integer.valueOf(values[2])));
        }
    }
}
