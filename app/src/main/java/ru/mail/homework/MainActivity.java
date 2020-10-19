package ru.mail.homework;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.all_numbers_fragment, new AllNumbersFragment())
                    .commit();
        }
    }

    public void fromFragmentData(String number, int color) {
        Bundle bundle = new Bundle();
        bundle.putString("number", number);
        bundle.putInt("color", color);
        BigNumberFragment fragment = new BigNumberFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.all_numbers_fragment, fragment)
                .addToBackStack(null)
                .commit();
    }
}