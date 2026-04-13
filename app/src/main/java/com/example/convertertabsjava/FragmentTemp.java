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

public class FragmentTemp extends Fragment {

    private RadioGroup rgTemp;
    private RadioButton rbCtoF, rbFtoC;
    private EditText etTempInput;
    private Button btnConvertTemp;
    private TextView tvTempResult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_temp, container, false);

        initViews(view);
        setupListeners();

        return view;
    }

    private void initViews(View view) {
        rgTemp = view.findViewById(R.id.rgTemp);
        rbCtoF = view.findViewById(R.id.rbCtoF);
        rbFtoC = view.findViewById(R.id.rbFtoC);
        etTempInput = view.findViewById(R.id.etTempInput);
        btnConvertTemp = view.findViewById(R.id.btnConvertTemp);
        tvTempResult = view.findViewById(R.id.tvTempResult);
    }

    private void setupListeners() {
        btnConvertTemp.setOnClickListener(v -> convertTemperature());
    }

    private void convertTemperature() {
        String input = etTempInput.getText().toString().trim();

        if (TextUtils.isEmpty(input)) {
            Toast.makeText(getContext(), "Veuillez entrer une valeur", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double val = Double.parseDouble(input);
            double result;

            if (rbCtoF.isChecked()) {
                result = (1.8 * val) + 32;
            } else {
                result = (val - 32) / 1.8;
            }

            tvTempResult.setText("Résultat : " + String.format("%.2f", result));

        } catch (NumberFormatException e) {
            Toast.makeText(getContext(), "Valeur invalide", Toast.LENGTH_SHORT).show();
        }
    }
}