package com.rohit.assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rohit.assignment.adapters.OfferItemAdapter;
import com.rohit.assignment.adapters.SocialMediaItemAdapter;
import com.rohit.assignment.models.ApiResponse;
import com.rohit.assignment.models.FeedItem;
import com.rohit.assignment.models.SocialMediaItem;
import com.rohit.assignment.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel ;

    private ImageView carImage;
    private TextView carName, carRegNo, carType;
    private RecyclerView socialMediaRecyclerView, offerRecycler;
    private SocialMediaItemAdapter socialMediaItemAdapter;
    private List<SocialMediaItem> socialMediaItemList;
    private OfferItemAdapter offerItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carImage = findViewById(R.id.carImage);
        carName = findViewById(R.id.carName);
        carRegNo = findViewById(R.id.carRegNo);
        carType = findViewById(R.id.carType);

        socialMediaRecyclerView = findViewById(R.id.socialMediaRecyclerView);
        socialMediaRecyclerView.setLayoutManager(new GridLayoutManager(this,4));
        socialMediaRecyclerView.setNestedScrollingEnabled(false);

        socialMediaItemList = new ArrayList<>();
        insertData(socialMediaItemList);

        socialMediaItemAdapter = new SocialMediaItemAdapter(this, socialMediaItemList);
        socialMediaRecyclerView.setAdapter(socialMediaItemAdapter);

        offerRecycler = findViewById(R.id.offerRecyclerView);
        offerRecycler.setLayoutManager(new LinearLayoutManager(this));
        offerRecycler.setNestedScrollingEnabled(false);

        offerItemAdapter = new OfferItemAdapter(this);
        offerRecycler.setAdapter(offerItemAdapter);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.init();
        viewModel.getApiResponseLiveData().observe(this, new Observer<ApiResponse>() {
            @Override
            public void onChanged(ApiResponse apiResponse) {
                if (apiResponse != null) {

                    FeedItem item = apiResponse.getFeedItems().get(0);

                    if (item.getCarImageUrl()!=null) {
                        Glide.with(MainActivity.this)
                                .load(item.getCarImageUrl())
                                .into(carImage);
                    }

                    carName.setText(item.getCarName());
                    carRegNo.setText(item.getCarRegNo());
                    carType.setText(item.getCarType()+" - "+item.getFuelType());

                    offerItemAdapter.setResults(apiResponse.getFeedItems().get(2).getBanners());
                }
            }
        });

        performSearch();
    }

    private void insertData(List<SocialMediaItem> socialMediaItemList) {

        socialMediaItemList.add(new SocialMediaItem(R.drawable.facebook,"facebook"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.twitter,"twitter"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.instagram,"instagram"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.youtube,"youtube"));

        socialMediaItemList.add(new SocialMediaItem(R.drawable.facebook,"facebook"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.twitter,"twitter"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.instagram,"instagram"));
        socialMediaItemList.add(new SocialMediaItem(R.drawable.youtube,"youtube"));
    }

    private void performSearch() {
        viewModel.searchCars();
    }
}
