package com.ikwala.resturantapp;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.ikwala.resturantapp.dao.SampleDataProvider;
import com.ikwala.resturantapp.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity
{
    private TextView tvName;
    private TextView tvPrice;
    private ImageView ivPhoto;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        String itemId = intent.getStringExtra(DataItemAdapter.EXTRA_ITEM_ID);
        DataItem item = SampleDataProvider.itemsMap.get(itemId);


        tvName = (TextView) findViewById(R.id.tvItemName);
        tvName.setText(item.getItemName());

        tvPrice = (TextView) findViewById(R.id.tvItemPrice);
        Locale locale = new Locale("en", "ae");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        tvPrice.setText(numberFormat.format(item.getPrice()));


        tvDesc = (TextView) findViewById(R.id.tvDesc);
        tvDesc.setText(item.getDescription());

        ivPhoto = (ImageView) findViewById(R.id.ivPhoto);

        InputStream is = null;
        try
        {
            String imageFile = item.getImage();
            is = getAssets().open(imageFile);
            Drawable d = Drawable.createFromStream(is,null);
            ivPhoto.setImageDrawable(d);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException | NullPointerException e)
            {
                e.printStackTrace();
            }
        }


    }
}
