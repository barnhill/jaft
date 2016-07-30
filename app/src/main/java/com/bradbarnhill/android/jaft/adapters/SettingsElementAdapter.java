package com.bradbarnhill.android.jaft.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bradbarnhill.android.jaft.R;
import com.bradbarnhill.android.jaft.models.TimeElement;

import java.util.ArrayList;

public class SettingsElementAdapter extends RecyclerView.Adapter<SettingsElementAdapter.SettingsElementViewHolder> {
    private ArrayList<TimeElement> mElements = new ArrayList<>();

    public SettingsElementAdapter(final ArrayList<TimeElement> elements) {
        mElements = elements;
    }

    @Override
    public SettingsElementViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_time_element_edit, parent, false);
        return new SettingsElementViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final SettingsElementViewHolder holder, final int position) {
        final TimeElement element = mElements.get(position);
        holder.time.setText(element.getHour() + ":" + element.getMinute() + ":" +element.getSeconds());
        holder.text.setText(element.getText());
    }

    @Override
    public int getItemCount() {
        return mElements.size();
    }

    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class SettingsElementViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView text;

        SettingsElementViewHolder(final View itemView) {
            super(itemView);
            time = (TextView)itemView.findViewById(R.id.elementTime);
            text = (TextView)itemView.findViewById(R.id.elementText);
        }
    }
}
