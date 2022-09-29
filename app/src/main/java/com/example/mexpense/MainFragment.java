package com.example.mexpense;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mexpense.data.BookEntity;
import com.example.mexpense.data.SampleDataProvider;
import com.example.mexpense.data.TripEntity;
import com.example.mexpense.databinding.FragmentMainBinding;

import java.util.List;
import java.util.Optional;

public class MainFragment extends Fragment implements BookListAdapter.ListItemListener {

    private MainViewModel mViewModel;
    private FragmentMainBinding binding;
    private BookListAdapter bookListAdapter;
    private TripListAdapter tripListAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        getActivity().setTitle("Trips list");
//        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        binding = FragmentMainBinding.inflate(inflater, container, false);

        RecyclerView rv = binding.recyclerView;
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new DividerItemDecoration(
                getContext(),
                (new LinearLayoutManager(getContext())).getOrientation())
        );

        rv.setAdapter(tripListAdapter);
        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        rv.setHasFixedSize(true);

        //Show list of trip
        DatabaseHandler databaseHandler = new DatabaseHandler(this.getActivity());
        List<TripEntity> tripEntities = databaseHandler.getAllTrips();
        if (tripEntities.size() > 0){
            TripListAdapter tripListAdapter = new TripListAdapter(tripEntities, this::onItemClick);
        } else {
            Toast.makeText(this.getActivity(), "There is no data", Toast.LENGTH_SHORT).show();
        }
//        mViewModel.bookList.observe(
//                getViewLifecycleOwner(),
//                bookList -> {
//                    System.out.println("#books: " + bookList.size());
//                    //https://developer.android.com/topic/libraries/architecture/livedata
//                    //https://developer.android.com/topic/libraries/architecture/livedata#work_livedata
//                    //when bookList has changes, what to do?
//                    //define an Observer of <List<BookEntity>> using lambda to implement onChanged()
//                    //this observer will watch for any changes in List<BookEntity> then
//                    //create new adapter with new book list and display it on recyclerView
//                    //                    adapter = new BookListAdapter(bookList);
//                    bookListAdapter = new BookListAdapter(bookList, MainFragment.this);
//                    binding.recyclerView.setAdapter(bookListAdapter);
//                    binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//                }
//        );
        binding.btnAddTrip.setOnClickListener(v -> this.onItemClick(Constants.NEW_TRIP_ID));

        return binding.getRoot();

//        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onItemClick(String tripId) {
        //Tìm book trong mViewModel
//        Optional<BookEntity> be = mViewModel.bookList.getValue()
//                .stream().filter(b -> b.getId() == bookID).findFirst();
//        if (be.isPresent()){
            Bundle bundle = new Bundle();
            bundle.putString("tripId", tripId);
            Navigation.findNavController(getView())
                    .navigate(R.id.editorFragment, bundle);
//        }
    }
}