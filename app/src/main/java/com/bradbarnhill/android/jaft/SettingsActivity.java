package com.bradbarnhill.android.jaft;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.recyclerview.internal.CardArrayRecyclerViewAdapter;
import it.gmariotti.cardslib.library.recyclerview.view.CardRecyclerView;

public class SettingsActivity extends AppCompatActivity {
    private CardRecyclerView mRecyclerView;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mRecyclerView = (CardRecyclerView) findViewById(R.id.cardList);
        mRecyclerView.setAdapter(createCardArrayAdapter());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private ArrayList<Card> createCards() {
        final ArrayList<Card> cards = new ArrayList<>();

        //Create a Card
        final Card card = new Card(this);

        //Create a CardHeader
        final CardHeader header = new CardHeader(this);

        //Add Header to card
        card.addCardHeader(header);

        cards.add(card);

        return cards;
    }

    private CardArrayRecyclerViewAdapter createCardArrayAdapter() {
        final CardArrayRecyclerViewAdapter mCardArrayAdapter = new CardArrayRecyclerViewAdapter(this, createCards());

        //Staggered grid view
        mRecyclerView.setHasFixedSize(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //Set the empty view
        if (mRecyclerView != null) {
            mRecyclerView.setAdapter(mCardArrayAdapter);
        }

        return mCardArrayAdapter;
    }
}
