package com.example.svilenstrahilov.weatherapp.home;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.svilenstrahilov.weatherapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInputFragment extends DialogFragment implements View.OnClickListener {

    @BindView(R.id.editText_city)
    EditText editText_city;
    @BindView(R.id.editText_days)
    EditText editText_days;
    @BindView(R.id.button_Go)
    Button button_Go;

    public UserInputFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View view) {
        this.dismiss();
        UserInputListener userInputListener = (UserInputListener) getActivity();
        userInputListener.getBackUserInput(editText_city.getText().toString(), Integer.valueOf(editText_days.getText().toString()));
    }

    public interface UserInputListener {
        void getBackUserInput(String city, int days);
    }

    public static UserInputFragment newInstance(String title) {
        UserInputFragment fragment = new UserInputFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_user_input, container, false);
        ButterKnife.bind(this, view);
        button_Go.setOnClickListener(this);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
