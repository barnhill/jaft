package com.bradbarnhill.android.jaft.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bradbarnhill.android.jaft.R;
import com.bradbarnhill.android.jaft.models.TimeElement;

import java.util.ArrayList;

public class TimerElementAdapter extends RecyclerView.Adapter<TimerElementAdapter.TimerElementViewHolder> {
    private ArrayList<TimeElement> mElements = new ArrayList<>();

    public TimerElementAdapter(final ArrayList<TimeElement> elements) {
        mElements = elements;
    }

    @Override
    public TimerElementViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.timer_card, parent, false);
        return new TimerElementViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TimerElementViewHolder holder, final int position) {
        //TODO populate timer card
        holder.title.setText(mElements.get(position).getText());
        holder.time.setText(mElements.get(position).getMinute() + ":" + mElements.get(position).getSeconds());
        holder.nextAction.setText(mElements.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mElements.size();
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class TimerElementViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView nextAction;

        TimerElementViewHolder(final View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.timerTitle);
            time = (TextView) itemView.findViewById(R.id.elementTime);
            nextAction = (TextView) itemView.findViewById(R.id.nextAction);
        }
    }
}
