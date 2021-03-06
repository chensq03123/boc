package com.hustunique.bocp.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.hustunique.bocp.Adapters.CardsExpandableListAdapter;
import com.hustunique.bocp.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chensq on 14-11-12.
 */
public class CardManagementFragment extends Fragment {

    private Context mcontext;
    private final String[] options={"删除卡片","编辑卡片","交易记录","查询余额"};

    public CardManagementFragment(){
        super();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mcontext=activity.getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<Map<String,String>> defaultlist=new ArrayList<Map<String, String>>();
        HashMap<String,String> map=new HashMap<String,String>();
        defaultlist.add(map);
        ArrayList<Map<String,String>> mlist=new ArrayList<Map<String, String>>();
        for (int i=0;i<8;i++){
            HashMap<String,String> map1=new HashMap<String,String>();
            mlist.add(map1);
        }


        View view=inflater.inflate(R.layout.fragment_cardsmanagement,null);
        ExpandableListView defaultcar=(ExpandableListView)view.findViewById(R.id.defaultcard);
        ExpandableListView cardslist=(ExpandableListView)view.findViewById(R.id.cardslist);
        CardsExpandableListAdapter defaultadapter=new CardsExpandableListAdapter(mcontext,defaultlist,options);
        CardsExpandableListAdapter cardsadapter=new CardsExpandableListAdapter(mcontext,mlist,options);
        defaultcar.setAdapter(defaultadapter);
        cardslist.setAdapter(cardsadapter);
        return view;
    }
}
