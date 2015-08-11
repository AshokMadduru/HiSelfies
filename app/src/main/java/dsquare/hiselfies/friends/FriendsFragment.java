package dsquare.hiselfies.friends;

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
public class FriendsFragment extends Fragment {

    ListView listView;
    Context context;
    ArrayAdapter<CustomFriends> adapter;
    public FriendsFragment(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_friends, container, false);

        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context=activity;
    }

    @Override public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new CustomFriendsAdapter(context, R.layout.custom_friends,
                new ArrayList<CustomFriends>());
        listView = (ListView)getActivity().findViewById(R.id.friends_list);
        listView.setAdapter(adapter);
        new FriendsWorldTask().execute();
    }

    public class FriendsWorldTask extends AsyncTask<Void,String,Void> {
        ArrayAdapter<CustomFriends> custom;
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("async", "in asnc");
            for(int i=0;i<9;i++){
                if(i==8){
                    publishProgress(String.valueOf(R.drawable.groupfie),String.valueOf(R.drawable.groupfie));
                }else{
                    publishProgress(String.valueOf(R.drawable.groupfie),String.valueOf(
                            R.drawable.groupfie));
                }

            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            custom = (ArrayAdapter<CustomFriends>) listView.getAdapter();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            custom.add(new CustomFriends(Integer.valueOf(values[0]),
                    Integer.valueOf(values[1])));
        }
    }
}
