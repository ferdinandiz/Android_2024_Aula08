package com.fer.aula08_fragmentsesensores;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment01 extends Fragment {
   Button btnFrag1, btnFrag2;

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view = inflater.inflate(R.layout.fragment_01, container, false);
      btnFrag1 = view.findViewById(R.id.btn_01);
      btnFrag2 = view.findViewById(R.id.btn_02);

      btnFrag1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Toast.makeText(getContext(), "Você está na Fragment 1", Toast.LENGTH_SHORT).show();
            ((MainActivity)getActivity()).setViewPager(0);
         }
      });

      btnFrag2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            ((MainActivity)getActivity()).setViewPager(1);
         }
      });

      return view;
   }
}
