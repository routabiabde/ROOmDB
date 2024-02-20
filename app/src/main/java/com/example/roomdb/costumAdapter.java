package com.example.roomdb;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.roomdb.entity.Perso;

import java.util.List;

public class costumAdapter extends BaseAdapter {

    private List<Perso> persoList;

    private Context context;

    public void setPersoList(List<Perso> persoList) {
        this.persoList = persoList;
        this.notifyDataSetChanged();
    }

    public costumAdapter(Context context, List<Perso> items) {
        this.context = context;
        this.persoList = items;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.perso_view,parent, false);
        }

        // Get the data item for this position
        Perso item = persoList.get(position);

        // Lookup view for data population
        TextView editText1 = convertView.findViewById(R.id.editText1);
        TextView editText2 = convertView.findViewById(R.id.editText2);
        TextView editText3 = convertView.findViewById(R.id.editText3);

        // Populate the data into the template view using the data object

            editText1.setText(item.firstName);
            editText2.setText(item.lastName);  // You can replace these with actual data
            editText3.setText(item.age);


        // Return the completed view to render on screen
        return convertView;

    }
}