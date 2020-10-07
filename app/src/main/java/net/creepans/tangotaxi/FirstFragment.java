package net.creepans.tangotaxi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import net.creepans.tangotaxi.mysql.MySQL;
import net.creepans.tangotaxi.mysql.SQLHandler;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.butttonNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MySQL.connect();
                MySQL.createTables();

                final EditText start = view.findViewById(R.id.inputTextStart);
                final EditText end = view.findViewById(R.id.inputTextZiel);


                // Check if User already in database
                SQLHandler handler = new SQLHandler();
                handler.createRoute("1", start.getText().toString(), end.getText().toString());


                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }
}