package com.example.sayed.fragmentdetail184;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MyItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        FragmentCountryList fragmentCountryList = new FragmentCountryList();
        ft.add(R.id.fragmentContainer, fragmentCountryList);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    @Override
    public void getItem(String item) {
        Bundle countryName = new Bundle();
        countryName.putString("country", item);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        CountryDetailFragment countryDetailFragment = new CountryDetailFragment();
        countryDetailFragment.setArguments(countryName);
        ft.replace(R.id.fragmentContainer, countryDetailFragment);
        ft.addToBackStack(null);
//        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
