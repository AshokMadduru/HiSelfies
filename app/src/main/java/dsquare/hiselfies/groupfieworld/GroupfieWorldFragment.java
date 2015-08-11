package dsquare.hiselfies.groupfieworld;

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
public class GroupfieWorldFragment extends Fragment {
    ListView listView;
    Context context;
    ArrayAdapter<CustomGroupfieWorld> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_groupfie_world,container,false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new CustomGroupfieWorldAdapter(context, R.layout.custom_groupfieworld,
                new ArrayList<CustomGroupfieWorld>());
        listView = (ListView)getView().findViewById(R.id.groupfie_list);
        listView.setAdapter(adapter);
        new GroupfieWorldTask().execute();
    }

    public class GroupfieWorldTask extends AsyncTask<Void,String,Void> {
        ArrayAdapter<CustomGroupfieWorld> custom;
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("async", "in asnc");
            for(int i=0;i<9;i++){
                if(i==8){
                    publishProgress(String.valueOf(R.drawable.groupfie),"0");
                }else{
                    publishProgress(String.valueOf(R.drawable.groupfie),String.valueOf(
                            R.drawable.groupfie));
                }

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            custom = (ArrayAdapter<CustomGroupfieWorld>) listView.getAdapter();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            custom.add(new CustomGroupfieWorld(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1])));
        }
    }
}
