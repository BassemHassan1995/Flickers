package com.example.basse.flickers.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.basse.flickers.Adapters.ImageAdapter;
import com.example.basse.flickers.R;

/**
 * Created by basse on 2/4/2016.
 */
public class SponsorsFragment extends Fragment {
    GridView[] gridViews;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sponsors, container, false);
        gridViews = new GridView[5];
        for (int i = 0 ;i <5 ; i++)
        {
            switch (i){
                case 0:
                    gridViews[i] = (GridView) view.findViewById(R.id.academicGridView);
                    break;
                case 1:
                    gridViews[i] = (GridView) view.findViewById(R.id.cateringGridView);
                    break;
                case 2:
                    gridViews[i] = (GridView) view.findViewById(R.id.mediaGridView);
                    break;
                case 3:
                    gridViews[i] = (GridView) view.findViewById(R.id.universitiesGridView);
                    break;
                case 4:
                    gridViews[i] = (GridView) view.findViewById(R.id.nationalsGridView);
                break;
                default:
                    break;
            }
            gridViews[i].setAdapter(new ImageAdapter(getActivity(), i));
        }

        return view;
    }
}
