package ru.mail.homework;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class AllNumbersFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.all_numbers_layout, container, false);
        final List<Integer> numbers = DataSource.getInstance().getData();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), getResources().getInteger(R.integer.columns)));

        final MyAdapter adapter = new MyAdapter(getActivity(), numbers);
        recyclerView.setAdapter(adapter);

        Button addButton = view.findViewById(R.id.adder);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbers.add(numbers.size() + 1);
                adapter.notifyItemChanged(adapter.getItemCount() - 1);
            }
        });
        return view;
    }
}
