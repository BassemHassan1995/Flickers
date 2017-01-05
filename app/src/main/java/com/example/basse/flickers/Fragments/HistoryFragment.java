package com.example.basse.flickers.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.basse.flickers.Adapters.ExpandableListAdapter;
import com.example.basse.flickers.Event;
import com.example.basse.flickers.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//import com.example.basse.flickers.R;

/**
 * Created by basse on 1/26/2016.
 */
public class HistoryFragment extends Fragment {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
//    List<String> listDataChild;
    HashMap<String,Event> listDataChild = new HashMap<String ,Event>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        expListView = (ExpandableListView) view.findViewById(R.id.expandableListView);
        prepareListData();
        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);
//        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v,
//                                        int groupPosition, long id) {
//                //Toast.makeText(getContext(),
//                //"Group Clicked "LENGTH_SHORT + listDataHeader.get(groupPosition),
//                //Toast.).show();
//                return false;
//            }
//        });

        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            int previousItem = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if(groupPosition != previousItem )
                    expListView.collapseGroup(previousItem );
                previousItem = groupPosition;
            }        });

        // Listview Group collasped listener
//        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//                Toast.makeText(getContext(),
//                        listDataHeader.get(groupPosition) + " Collapsed",
//                        Toast.LENGTH_SHORT).show();
//
//            }
//        });

        // Listview on child click listener
/*        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getContext(),
                        listDataChild.get(
                                listDataHeader.get(groupPosition)).get(childPosition).companyBrief, Toast.LENGTH_LONG).show();
                return false;
            }
        });
*/
        return view;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String,Event>();

        // Adding Header data
        listDataHeader.add("Flickers Origin");
        listDataHeader.add("Flickers Seminars");
        listDataHeader.add("Flickers Spark");
        listDataHeader.add("Flickers Chain 2.0");
        listDataHeader.add("Flickers Chain 1.0");

        // Adding Child data
        Event origin = new Event("This year we had 11 national and multinational companies who helped us through their instructors and helped the students through technical and non-technical Tracks." , getString(R.string.origin_html));
        Event seminars = new Event("It was a group of sessions that address a certain topic and specialized in the human development of the students either technical or non-technical." , getString(R.string.seminars_html));
        Event spark = new Event("This year we had 4 companies who provided us with technical Tracks." , getString(R.string.spark_html));
        Event chain2 = new Event("This year we had 4 companies which are Schneider, Olympic group, Microsoft and Leoni also we had media coverage from Rose el Yossef and Rotana." , getString(R.string.chain2_html));
        Event chain1 = new Event("This was the first year for Flickers in 2011 and we had 2 sponsor companies which was ABB and Leoni." , getString(R.string.chain1_html));
        listDataChild.put(listDataHeader.get(0), origin);
        listDataChild.put(listDataHeader.get(1), seminars);
        listDataChild.put(listDataHeader.get(2), spark);
        listDataChild.put(listDataHeader.get(3), chain2);
        listDataChild.put(listDataHeader.get(4), chain1);
    }
}
