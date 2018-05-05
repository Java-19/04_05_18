package com.sheygam.java_19_04_05_18;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    private EditText inputEmail, inputPassword;
    private Button login;
    private List<LoginFragmentListener> listeners;

    public LoginFragment() {
        // Required empty public constructor
        listeners = new ArrayList<>();
    }


    public void addListener(LoginFragmentListener listener){
        listeners.add(listener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        inputEmail = view.findViewById(R.id.input_email);
        inputPassword = view.findViewById(R.id.input_password);
        login = view.findViewById(R.id.login_btn);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.login_btn){
            String email = inputEmail.getText().toString();
            String password = inputPassword.getText().toString();
            for(LoginFragmentListener listener : listeners){
                listener.onLogin(email,password);
            }
        }
    }

    interface LoginFragmentListener{
        void onLogin(String email, String password);
    }
}
