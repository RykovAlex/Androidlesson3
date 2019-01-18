package com.nl.alex.simplelistchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, AbsListView.OnScrollListener {
    final String LOG_TAG = "myLogs";

    ListView lvMain;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView) findViewById(R.id.lvMain);
        // устанавливаем режим выбора пунктов списка
        //lvMain.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //lvMain.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        // Создаем адаптер, используя массив из файла ресурсов
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.names,
                //android.R.layout.simple_list_item_multiple_choice);
                android.R.layout.simple_list_item_1);
        lvMain.setAdapter(adapter);

        // получаем массив из файла ресурсов
        names = getResources().getStringArray(R.array.names);

        lvMain.setOnItemClickListener(this);
        lvMain.setOnItemSelectedListener(this);
        lvMain.setOnScrollListener(this);
    }

    @Override
    public void onClick(View v) {
        // пишем в лог выделенный элемент
        Log.d(LOG_TAG, "checked: " + names[lvMain.getCheckedItemPosition()]);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d(LOG_TAG, "onItemClick: ");

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Log.d(LOG_TAG, "onItemSelected: " );
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(LOG_TAG, "onNothingSelected: " );
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        Log.d(LOG_TAG, "onScrollStateChanged: " + scrollState);
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        Log.d(LOG_TAG, "onScroll: " + firstVisibleItem +" "+ visibleItemCount +" "+ totalItemCount);
    }
}
