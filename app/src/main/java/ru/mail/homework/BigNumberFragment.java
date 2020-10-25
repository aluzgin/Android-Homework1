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
    public final static String NUMBER_KEY = "number";
    public final static String COLOR_KEY = "color";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.big_number_layout, container, false);
        Bundle bundle = this.getArguments();
        String number = bundle.getString(NUMBER_KEY, "-1");
        TextView bigNumber = view.findViewById(R.id.big_number);
        bigNumber.setText(number);
        bigNumber.setTextColor(bundle.getInt(COLOR_KEY));
        return view;
    }

    public static BigNumberFragment newInstance(String number, int color) {
        BigNumberFragment fragment = new BigNumberFragment();
        Bundle bundle = new Bundle();
        bundle.putString(NUMBER_KEY, number);
        bundle.putInt(COLOR_KEY, color);
        fragment.setArguments(bundle);
        return fragment;
    }
}
