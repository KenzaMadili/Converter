package com.example.convertertabsjava;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DistanceFragment extends Fragment {

    private RadioGroup rgDist;
    private RadioButton rbKmToMiles, rbMilesToKm;
    private EditText etDistInput;
    private Button btnConvertDist;
    private TextView tvDistResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_distance, container, false);

        initViews(view);
        setupListeners();

        return view;
    }

    private void initViews(View view) {
        rgDist = view.findViewById(R.id.rgDist);
        rbKmToMiles = view.findViewById(R.id.rbKmToMiles);
        rbMilesToKm = view.findViewById(R.id.rbMilesToKm);
        etDistInput = view.findViewById(R.id.etDistInput);
        btnConvertDist = view.findViewById(R.id.btnConvertDist);
        tvDistResult = view.findViewById(R.id.tvDistResult);
    }

    private void setupListeners() {
        btnConvertDist.setOnClickListener(v -> convertDistance());
    }

    private void convertDistance() {
        String input = etDistInput.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double val = Double.parseDouble(input);
            double result;

            if (rbKmToMiles.isChecked()) {
                result = val * 0.6214;
            } else {
                result = val / 0.6214;
            }

            tvDistResult.setText("Résultat : " + String.format("%.2f", result));

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Valeur invalide", Toast.LENGTH_SHORT).show();
        }
    }
}