package com.example.mexpense;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.databinding.ListItemBinding;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.BookViewHolder>{

    //Tạo interface cho Observer
    public interface ListItemListener{
        void onItemClick(String bookID);
    }

    //Create View holder
    public class BookViewHolder extends RecyclerView.ViewHolder {

        //Bind layout
        private final ListItemBinding itemViewBinding;
        public BookViewHolder(View itemView) {
            super(itemView);
            itemViewBinding = ListItemBinding.bind(itemView);
        }

        //Function Bind data
        public void bindData(BookEntity bData) {
            itemViewBinding.bookTitle.setText(bData.getTitle());
            itemViewBinding.getRoot().setOnClickListener(v -> listener.onItemClick(bData.getId()));
        }
    }

    private List<BookEntity> bookList;
    // Observer/listener
    private ListItemListener listener;

    //constructor BookListAdapter
    public BookListAdapter(List<BookEntity> bookList,
                           ListItemListener listener) {
        this.bookList = bookList;
        this.listener = listener;
    }

    //Thiết lập mỗi dòng (item) được hiển thị ntn
    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Thiết lập file xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new BookViewHolder(view);
    }

    //Thiết lập dữ liệu đưa vào
    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        BookEntity bData = bookList.get(position);
        holder.bindData(bData);
    }

    //Thông báo bao số lượng item
    @Override
    public int getItemCount() {
        return bookList.size();
    }
}