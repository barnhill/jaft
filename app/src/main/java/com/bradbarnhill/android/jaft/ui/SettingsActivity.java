package com.bradbarnhill.android.jaft.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bradbarnhill.android.jaft.R;
import com.bradbarnhill.android.jaft.adapters.SettingsElementAdapter;
import com.bradbarnhill.android.jaft.models.TimeElement;

import java.util.ArrayList;

public class SettingsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mRecyclerView = (RecyclerView) findViewById(R.id.cardList);
        createCardArrayAdapter(mRecyclerView);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private ArrayList<TimeElement> createCards() {
        final ArrayList<TimeElement> cards = new ArrayList<>();

        final TimeElement element = new TimeElement(8, 35, 25, "Test Text");
        cards.add(element);

        return cards;
    }

    private void createCardArrayAdapter(final RecyclerView recyclerView) {
        final SettingsElementAdapter cardArrayAdapter = new SettingsElementAdapter(createCards());

        if (recyclerView != null) {
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            recyclerView.setAdapter(cardArrayAdapter);
        }
    }
}
