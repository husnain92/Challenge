package com.example.pk_eagle.challenge;

import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Dialog_Add.onSubmitListener {


    RecyclerView rView;
    LinearLayoutManager mLayoutManager;
    ArrayList<DataModel> myDataset = new ArrayList<>();
    JSONObject MyTestData = new JSONObject();
    FloatingActionButton fabAdd;
    FragmentManager fm = getSupportFragmentManager();
    AdapterNames arrayAdapter;

    Parcelable mListState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rView = (RecyclerView) findViewById(R.id.my_recycler_view);
        fabAdd = (FloatingActionButton) findViewById(R.id.fabAdd);


        MyTestData = PopDummydata();

        for (int x = 0; x < MyTestData.length(); x++) {
            try {
                JSONObject j = new JSONObject();

                j = MyTestData.getJSONObject(String.valueOf(x));
                DataModel data = new DataModel();
                data.setFirstName(j.getString("FirstName"));
                data.setLastName(j.getString("LastName"));
                myDataset.add(data);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        rView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(mLayoutManager);


        arrayAdapter = new AdapterNames(myDataset);
        rView.setAdapter(arrayAdapter);

        arrayAdapter.notifyDataSetChanged();


        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Dialog_Add dialog = new Dialog_Add();

                dialog.mListener = MainActivity.this;
                dialog.show(fm, "DataFragment");
            }
        });

            }


    public JSONObject PopDummydata() {
        JSONObject myJsondata = new JSONObject();

        JSONObject jj = new JSONObject();
        try {
            jj.put("FirstName", "Allison");
            jj.put("LastName", "Essary");
            myJsondata.put("0", jj);
            jj = new JSONObject();
            jj.put("FirstName", "Kellie");
            jj.put("LastName", "Wexler");
            myJsondata.put("1", jj);
            jj = new JSONObject();
            jj.put("FirstName", "Manual");
            jj.put("LastName", "Botello");
            myJsondata.put("2", jj);
            jj = new JSONObject();
            jj.put("FirstName", "Hung");
            jj.put("LastName", "Nilsson");
            myJsondata.put("3", jj);
            jj = new JSONObject();
            jj.put("FirstName", "Todd");
            jj.put("LastName", "Sterns");
            myJsondata.put("4", jj);


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return myJsondata;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mListState != null) {
            mLayoutManager.onRestoreInstanceState(mListState);
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null)
            myDataset = (ArrayList<DataModel>) savedInstanceState.getSerializable("DataStore");
        mLayoutManager = new LinearLayoutManager(this);
        rView.setLayoutManager(mLayoutManager);


        arrayAdapter = new AdapterNames(myDataset);
        rView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mListState = mLayoutManager.onSaveInstanceState();
        outState.putSerializable("DataStore", myDataset);
    }

    @Override
    public void setOnSubmitListener(DataModel dt) {
        myDataset.add(dt);
        arrayAdapter.notifyDataSetChanged();
    }
}

