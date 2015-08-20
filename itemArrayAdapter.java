package com.example.aiuake4.atlascompass;

/**
 * Created by AIUAKE4 on 8/14/2015.
 */
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class ItemArrayAdapter extends ArrayAdapter {
    private ArrayList<String []> scoreList = new ArrayList();
    private String clickedDate;
    static class ItemViewHolder {
        TextView name;
        TextView dates;
    }

    public ItemArrayAdapter(Context context, int textViewResourceId, String OCDate) {
        super(context, textViewResourceId);
        clickedDate = OCDate;
    }

    //@Override
    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.scoreList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.name = (TextView) row.findViewById(R.id.cycles);
            viewHolder.dates = (TextView) row.findViewById(R.id.dates);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }

        String[] stat = getItem(position);
        String[] dog = clickedDate.split("-");
        String month = dog[1].substring(0,3);
        clickedDate = dog[0] + "-" + month + "-" + dog[2];
        Log.d("test", clickedDate);
        if(stat[0].contains(clickedDate)) {
            Log.d("stat", stat[0]);
            Log.d("stat1", stat[1]);
            //Flip flop the names
            viewHolder.name.setText(stat[0]);
            viewHolder.dates.setText(stat[1]);
        }else{
            Log.d("asdf", "you messed up");
        }
        return row;
    }
}
