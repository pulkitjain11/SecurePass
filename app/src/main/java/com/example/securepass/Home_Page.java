package com.example.securepass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Page extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listview;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        listview = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }
        });
        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,items);
        listview.setAdapter(itemsAdapter);
        setUplistViewListner();

    }

    private void setUplistViewListner() {
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

                items.remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;

            }
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.username);
        String itemText = input.getText().toString();

        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(),"Please enter text correctly ",Toast.LENGTH_LONG).show();
        }
    }
}