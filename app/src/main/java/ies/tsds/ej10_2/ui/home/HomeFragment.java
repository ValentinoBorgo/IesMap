package ies.tsds.ej10_2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.util.Calendar;

import ies.tsds.ej10_2.R;
import ies.tsds.ej10_2.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private boolean primeraVez = true;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        String fecha = obtenerFecha();
        final TextView tvFecha = root.findViewById(R.id.tvFecha);
        tvFecha.setText("Fecha:    " + fecha);
        final TextView tvUsuario = root.findViewById(R.id.tvUsuario);
        final TextView tvUsuarioGeneral =
                (TextView) getActivity().findViewById(R.id.tvUsuarioGeneral);
        String usuario = "";
        if (primeraVez) {
            primeraVez = false;
        } else {
            usuario = tvUsuarioGeneral.getText().toString();
        }
        tvUsuario.setText("Usuario: " + usuario);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private String obtenerFecha() {
        Calendar c = Calendar.getInstance();

        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String dia = "";
        if (day < 10) {
            dia = "0";
        }
        dia = dia + day;
        month = month + 1;
        String mes = "";
        if (month < 10) {
            mes = "0";
        }
        mes = mes + month;
        String date = dia + "/" + mes + "/" + year;
        return date;
    }

}