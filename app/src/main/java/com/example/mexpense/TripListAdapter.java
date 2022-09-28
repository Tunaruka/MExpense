package com.example.mexpense;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.data.TripEntity;
import com.example.mexpense.databinding.ListItemBinding;

import java.util.List;

public class TripListAdapter extends RecyclerView.Adapter<TripListAdapter.TripViewHolder>{
    public interface ListItemListener{
        void onItemClick(String tripId);
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {
        private final ListItemBinding itemViewBinding;
        public TripViewHolder(View itemView){
            super(itemView);
            itemViewBinding = ListItemBinding.bind(itemView);
        }
        public void bindData(TripEntity bData) {
            itemViewBinding.bookTitle.setText(bData.getTitle());
            itemViewBinding.getRoot().setOnClickListener(v ->
                    listener.onItemClick(String.valueOf(bData.getId())));
        }
    }

    private List<TripEntity> tripList;
    private ListItemListener listener;

    public TripListAdapter(List<TripEntity> tripList, ListItemListener listener) {
        this.tripList = tripList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public TripListAdapter.TripViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Thiết lập file xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new TripListAdapter.TripViewHolder(view);
    }

    //Thiết lập dữ liệu đưa vào
    @Override
    public void onBindViewHolder(@NonNull TripListAdapter.TripViewHolder holder, int position) {
        TripEntity bData = tripList.get(position);
        holder.bindData(bData);
    }

    //Thông báo bao số lượng item
    @Override
    public int getItemCount() {
        return tripList.size();
    }

}
