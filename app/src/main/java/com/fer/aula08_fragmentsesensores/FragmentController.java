package com.fer.aula08_fragmentsesensores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentController extends FragmentStateAdapter {
   private final List<String> nomes = new ArrayList<>();
   private final List<Fragment> lista = new ArrayList<>();

   public FragmentController(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
      super(fragmentManager, lifecycle);
   }

   public void addFragment(Fragment f, String nome){
      lista.add(f);
      nomes.add(nome);
   }

   @NonNull
   @Override
   public Fragment createFragment(int position) {
      return lista.get(position);
   }

   @Override
   public int getItemCount() {
      return lista.size();
   }
}
