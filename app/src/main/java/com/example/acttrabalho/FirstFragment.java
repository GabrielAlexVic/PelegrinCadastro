package com.example.acttrabalho;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.acttrabalho.data.User;
import com.example.acttrabalho.data.Utils;
import com.example.acttrabalho.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    /**
     * A classe FirstFragment representa o primeiro fragmento da aplicação.
     *
     * Ela contém uma referência ao binding do fragmento e a um usuário.
     */
    private FragmentFirstBinding binding;
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
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();
        Bundle args = getArguments();
        String userJsonString = null;
        if (args != null) {
            userJsonString = args.getString("user");
            user = Utils.getGsonParser().fromJson(userJsonString, User.class);
            if(user.getName() != null && user.getAddress() != null && user.getAge() != null) {
                setData();
            }
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isComplete = checkData();
                if (isComplete){
                    Bundle bundle = new Bundle();
                    String userJsonString = Utils.getGsonParser().toJson(user);
                    bundle.putString("user", userJsonString);
                    NavHostFragment.findNavController(FirstFragment.this)
                            .navigate(R.id.cadastrar, bundle);
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setData(){
        binding.name.setText(user.getName());
        binding.age.setText(user.getAge());
        binding.address.setText(user.getAddress());
    }

    public boolean checkData(){
        String name = binding.name.getText().toString();
        String age = binding.age.getText().toString();
        String address = binding.address.getText().toString();
        if(TextUtils.isEmpty(name)){
            binding.name.setError("Campo Obrigatório");
            return false;
        } else if (TextUtils.isEmpty(age)) {
            binding.age.setError("Campo Obrigatório");
            return false;
        } else if (TextUtils.isEmpty(address)){
            binding.address.setError("Campo Obrigatório");
            return false;
        }
        else {
            user.setName(name);
            user.setAge(age);
            user.setAddress(address);
            return true;
        }
    }
}