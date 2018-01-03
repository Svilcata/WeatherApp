package com.example.svilenstrahilov.weatherapp.home.inputdialog;

import android.content.Context;
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

public class InputDialog extends DialogFragment implements View.OnClickListener, InputDialogMvpView {
    @BindView(R.id.editText_city)
    EditText editText_city;
    @BindView(R.id.editText_days)
    EditText editText_days;
    @BindView(R.id.button_Go)
    Button button_Go;

    public interface DialogListener {
        void onFinishDialog(String cityName, int daysForecast);
    }

    InputDialogMvpPresenter dialogMvpPresenter;
    DialogListener dialogListener;

    public InputDialog() {

    }

    @Override
    public void onClick(View view) {
        dialogMvpPresenter.getBackUserInput(editText_city.getText().toString(), Integer.valueOf(editText_days.getText().toString()));
        this.dismiss();
    }

    @Override
    public void onAttach(Context context) {
        dialogListener = (DialogListener) context;
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        dialogMvpPresenter.detachDialog();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_user_input, container, false);
        ButterKnife.bind(this, view);
        button_Go.setOnClickListener(this);
        attachPresenter();
        return view;
    }

    private void attachPresenter() {
        if (dialogMvpPresenter == null) {
            dialogMvpPresenter = new InputDialogPresenter(this);
        }
        dialogMvpPresenter.attachDialog(this);
    }

    @Override
    public void inputListener(String cityName, int daysForecast) {
        dialogListener.onFinishDialog(cityName, daysForecast);
    }
}
