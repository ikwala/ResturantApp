package com.ikwala.resturantapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ikwala.resturantapp.model.DataItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by ikwala on 3/6/17.
 */

public class DataItemAdapter extends RecyclerView.Adapter<DataItemAdapter.DataItemHolder>
{
    public static final String EXTRA_ITEM_ID = "com.ikwala.resturantapp.item_Id";
    private Context context;
    private List<DataItem> items;

    public DataItemAdapter(Context context, List<DataItem> items)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public DataItemHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.list_data_item,parent,false);
        return new DataItemHolder(v);
    }

    @Override
    public void onBindViewHolder(DataItemHolder holder, int position)
    {
        DataItem item = items.get(position);
        holder.bind(item);

    }

    @Override
    public int getItemCount()
    {
        return items.size();
    }


    public class DataItemHolder extends RecyclerView.ViewHolder
    {
        private ImageView ivItemPhoto;
        private TextView tvItemName;

        public DataItemHolder(View itemView)
        {
            super(itemView);

            ivItemPhoto = (ImageView)itemView.findViewById(R.id.ivItemPhoto);
            tvItemName = (TextView) itemView.findViewById(R.id.tvItemPrice);

        }

        public void bind(final DataItem items)
        {

            //ivItemPhoto.setImageResource(R.drawable.apple_pie);
            tvItemName.setText(items.getItemName());

            InputStream is = null;
            try
            {
                String imageFile = items.getImage();
                is = context.getAssets().open(imageFile);
                Drawable d = Drawable.createFromStream(is,null);

                ivItemPhoto.setImageDrawable(d);

            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
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

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String itemId = items.getItemId();
                    Intent intent = new Intent(context,DetailsActivity.class);
                    intent.putExtra(EXTRA_ITEM_ID, itemId);
                    context.startActivity(intent);

                }
            });
        }


    }
}
