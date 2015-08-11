package dsquare.hiselfies.events;

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
public class EventsFragment extends Fragment {
    ListView listView;
    Context context;
    ArrayAdapter<Events> adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_events, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new EventsAdapter(context, R.layout.custom_events,
                new ArrayList<Events>());
        listView = (ListView)getView().findViewById(R.id.event_list);
        listView.setAdapter(adapter);
        new EventsTask().execute();
    }

    public class EventsTask extends AsyncTask<Void,String,Void> {
        ArrayAdapter<Events> custom;
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
            custom = (ArrayAdapter<Events>) listView.getAdapter();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            custom.add(new Events(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1])));
        }
    }
}
