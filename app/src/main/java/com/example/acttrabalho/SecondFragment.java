package com.example.acttrabalho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.acttrabalho.data.User;
import com.example.acttrabalho.data.Utils;
import com.example.acttrabalho.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    /**
     * A classe SecondFragment representa o segundo fragmento da aplicação.
     *
     * Ele contém uma referência ao binding do fragmento e a um usuário.
     *
     * Este fragmento pode ser usado para exibir informações sobre o usuário.
     */
    private FragmentSecondBinding binding;
    /**
     * O binding do fragmento.
     */
    private User user = new User();
    /**
     * O usuário.
     */

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity)getActivity()).getSupportActionBar().hide();
        String UserJsonString = null;
        if (getArguments() != null) {
            UserJsonString = getArguments().getString("user");
            user = Utils.getGsonParser().fromJson(UserJsonString, User.class);
            getData();
        }
        binding.buttonSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireContext(), "Cadastro confirmado!", Toast.LENGTH_SHORT).show();
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.sim);
            }
        });

        binding.buttonNao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                String userJsonString = Utils.getGsonParser().toJson(user);
                bundle.putString("user", userJsonString);
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.nao, bundle);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void getData(){
        binding.name.setText(user.getName());
        binding.age.setText(user.getAge());
        binding.address.setText(user.getAddress());
    }
}