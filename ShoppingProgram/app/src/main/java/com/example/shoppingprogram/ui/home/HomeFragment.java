package com.example.shoppingprogram.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.shoppingprogram.R;
import com.example.shoppingprogram.adapter.CategoryAdapter;
import com.example.shoppingprogram.databinding.FragmentHomeBinding;
import com.example.shoppingprogram.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private CategoryAdapter categoryAdapter;
    private FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;

    public HomeFragment() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        final RecyclerView rcvCategory = binding.rcvCategory;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        rcvCategory.setLayoutManager(gridLayoutManager);
        rcvCategory.setHasFixedSize(true);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(true);
        homeViewModel.getListCategoryLiveData().observe(getViewLifecycleOwner(), new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoryAdapter = new CategoryAdapter(getActivity(), categories);
                categoryAdapter.setData(categories);
                rcvCategory.setAdapter(categoryAdapter);
            }
        });
        View root = binding.getRoot();
        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        Toast.makeText(getActivity(), "onStart", Toast.LENGTH_LONG).show();
//    }
//    @Override
//    public void onStop() {
//        super.onStop();
//    }
}