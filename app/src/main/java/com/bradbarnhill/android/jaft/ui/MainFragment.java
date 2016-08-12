package com.bradbarnhill.android.jaft.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bradbarnhill.android.jaft.R;
import com.bradbarnhill.android.jaft.adapters.TimerElementAdapter;
import com.bradbarnhill.android.jaft.models.TimeElement;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {
    private RecyclerView mTimerList;

    public MainFragment() {
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_main, container, false);
        mTimerList = (RecyclerView) view.findViewById(R.id.timerList);
        createCardArrayAdapter(mTimerList);

        return view;
    }

    private void createCardArrayAdapter(final RecyclerView recyclerView) {
        final TimerElementAdapter cardArrayAdapter = new TimerElementAdapter(createCards());

        if (recyclerView != null) {
            recyclerView.setHasFixedSize(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

            recyclerView.setAdapter(cardArrayAdapter);
        }
    }

    private ArrayList<TimeElement> createCards() {
        final ArrayList<TimeElement> cards = new ArrayList<>();

        cards.add(new TimeElement(8, 0, "Test Text 1"));
        cards.add(new TimeElement(9, 1, "Test Text 2"));
        cards.add(new TimeElement(10, 2, "Test Text 3"));
        cards.add(new TimeElement(11, 3, "Test Text 4"));
        cards.add(new TimeElement(12, 4, "Test Text 5"));

        return cards;
    }
}
