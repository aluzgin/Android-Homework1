package ru.mail.homework;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BigNumberFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.big_number_layout, container, false);
        Bundle bundle = this.getArguments();
        String number = bundle.getString("number", "-1");
        TextView bigNumber = view.findViewById(R.id.big_number);
        bigNumber.setText(number);
        bigNumber.setTextColor(bundle.getInt("color"));
        return view;
    }
}
