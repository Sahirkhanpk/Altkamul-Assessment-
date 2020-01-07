package com.example.altkamulassesignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.altkamulassesignment.api.ApiClient;
import com.example.altkamulassesignment.api.IEndPoints;
import com.example.altkamulassesignment.model.Media;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    List<Media> ArticalsList = new ArrayList<Media>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
    }



    public void getArticals() {
        try {


            IEndPoints iEndPoints = ApiClient.getClient().create(IEndPoints.class);




            rx.Observable<List<Media>> observableUserdata = iEndPoints.getArticals()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread());
            observableUserdata.subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<List<Media>>() {
                        @Override
                        public void onCompleted() {



                        }

                        @Override
                        public void onError(Throwable e) {


                            Toast.makeText(MainActivity.this,
                                    "Network Error" + e, Toast.LENGTH_SHORT).show();
                            e.printStackTrace();

                        }

                        @Override
                        public void onNext(List<Media> userdataResponse) {
                            if (userdataResponse != null) {

                                for(int a =0;a<10;a++)
                                {
                                    Media media = new Media();
                                    media.setTitle(userdataResponse.get(a).getTitle());
                                    media.setAbstract(userdataResponse.get(a).getAbstract());
                                    media.setPublished_date(userdataResponse.get(a).getPublished_date());
                                    media.setUrl(userdataResponse.get(a).getUrl());
                                   ArticalsList.add(media);

                                }

                                mAdapter = new AdapterNyTimes(ArticalsList);
                                recyclerView.setAdapter(mAdapter);

                            }

                        }

                    });
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }
}
