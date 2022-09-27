package com.example.mexpense;

import androidx.lifecycle.ViewModelProvider;
import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import com.google.android.material.R.style;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mexpense.databinding.FragmentEditorBinding;

import java.util.Calendar;

public class EditorFragment extends Fragment {

    private EditorViewModel eViewModel;
    private FragmentEditorBinding binding;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;

    public static EditorFragment newInstance() {
        return new EditorFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        eViewModel = new ViewModelProvider(this).get(EditorViewModel.class);
        binding = FragmentEditorBinding.inflate(inflater, container, false);

        dateButton = binding.datePickerButton;
        dateButton.setText(showDateText());
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDatePicker();
                datePickerDialog.show();
            }
        });

        String bookId = getArguments().getString("bookId");
        binding.title.setText(bookId);

        return binding.getRoot();
    }

    private String showDateText() {
        String dateText = "Select date";
        return dateText;
    }

//    private String getTodayDate() {
//        Calendar cal = Calendar.getInstance();
//        int year = cal.get(Calendar.YEAR);
//        int month = cal.get(Calendar.MONTH);
//        int day = cal.get(Calendar.DAY_OF_MONTH);
//        month = month + 1;
//        return makeDateString(day, month, year);
//    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            month = month+1;
            String date = makeDateString(day, month, year);
            dateButton.setText(date);
        };

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        //get today date for date picker as default
        int style = com.google.android.material.R.style.Theme_Material3_Dark_Dialog_Alert;
        datePickerDialog = new DatePickerDialog( getActivity(), style, dateSetListener, year, month, day);
    }

    private String makeDateString(int day, int month, int year) {
        return getMonthFormat(month) + " " + day + " " + year;
    }

    private String getMonthFormat(int month) {
        String result;
        switch (month) {
            case 1:
                result = "JAN";
                break;
            case 2:
                result = "FEB";
                break;
            case 3:
                result = "MAR";
                break;
            case 4:
                result = "APR";
                break;
            case 5:
                 result = "MAY";
                break;
            case 6:
                 result = "JUN";
                break;
            case 7:
                 result = "JUL";
                break;
            case 8:
                 result = "AUG";
                break;
            case 9:
                 result = "SEB";
                break;
            case 10:
                 result = "OCT";
                break;
            case 11:
                 result = "NOV";
                break;
            case 12:
                 result = "DEC";
                break;
            default:
                result = "NON";
                break;
        }
        return result;
    }

}