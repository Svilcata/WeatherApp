package com.example.svilenstrahilov.weatherapp.home.inputdialog;

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

public class InputDialog extends DialogFragment implements View.OnClickListener {
    @BindView(R.id.editText_city)
    EditText editText_city;
    @BindView(R.id.editText_days)
    EditText editText_days;
    @BindView(R.id.button_Go)
    Button button_Go;

    public interface UserInputListener {
        void onInputSubmitted(String cityName, int daysForecast);
    }

    public InputDialog() {

    }

    @Override
    public void onClick(View view) {
        UserInputListener userInput = (UserInputListener) getActivity();
        userInput.onInputSubmitted(editText_city.getText().toString(), Integer.valueOf(editText_days.getText().toString()));
        this.dismiss();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_user_input, container, false);
        ButterKnife.bind(this, view);
        button_Go.setOnClickListener(this);
        return view;
    }
}
