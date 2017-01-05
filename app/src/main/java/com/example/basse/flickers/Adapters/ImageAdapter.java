package com.example.basse.flickers.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.basse.flickers.R;

import java.util.ArrayList;

/**
 * Created by basse on 2/6/2016.
 */
public class ImageAdapter extends BaseAdapter {

    int choice;
    Context mContext;
    public ArrayList<Integer[]> arrays;
    Integer[] array;

    // Constructor
    public ImageAdapter(Context c, int choice) {
        mContext = c;
        this.choice = choice;
        array = getArray(choice);
    }

    private Integer[] getArray(int choice) {
        arrays = new ArrayList<Integer[]>();
        arrays.add(new Integer[]{
                R.drawable.ibm_logo, R.drawable.abb_logo, R.drawable.olympicgroup_logo, R.drawable.leoni_logo, R.drawable.abb_logo, R.drawable.schneiderelectric_logo, R.drawable.psp_logo
        });
        arrays.add(new Integer[]{
                R.drawable.abb_logo , R.drawable.ibm_logo
        });
        arrays.add(new Integer[]{
                R.drawable.intel_logo, R.drawable.leoni_logo, R.drawable.schneiderelectric_logo
        });
        arrays.add(new Integer[]{
                R.drawable.leoni_logo, R.drawable.olympicgroup_logo
        });
        arrays.add(new Integer[]{
                R.drawable.ibm_logo
        });
        return arrays.get(choice);
    }

    @Override
    public int getCount() {
        return array.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            //imageView.setLayoutParams(new GridView.LayoutParams(500, 500));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageResource(array[position]);
        return imageView;
    }
}
