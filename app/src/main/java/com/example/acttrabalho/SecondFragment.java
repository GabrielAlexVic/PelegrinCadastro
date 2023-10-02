package com.example.acttrabalho;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.acttrabalho.data.User;
import com.example.acttrabalho.data.Utils;
import com.example.acttrabalho.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private User user = new User();

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