package com.ikwala.resturantapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ikwala.resturantapp.dao.SampleDataProvider;
import com.ikwala.resturantapp.model.DataItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rvDataItem;
    private List<DataItem> items;
    DataItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items = new ArrayList<>();
        rvDataItem = (RecyclerView)findViewById(R.id.rvDataItem);
        items = SampleDataProvider.itemsList;
        adapter = new DataItemAdapter(MainActivity.this, items);
        rvDataItem.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuSignin:
                Intent intent = new Intent(this,Signin2Activity.class);
                startActivity(intent);
                break;
            case R.id.menuSetting:

                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
