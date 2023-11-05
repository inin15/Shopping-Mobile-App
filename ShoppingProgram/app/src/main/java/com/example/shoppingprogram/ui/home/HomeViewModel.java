package com.example.shoppingprogram.ui.home;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.shoppingprogram.R;
import com.example.shoppingprogram.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {
    private MutableLiveData<List<Category>> listCategoryLiveData;
    private List<Category> lCategory;
    public HomeViewModel() {
        listCategoryLiveData = new MutableLiveData<>();
        initData();
    }
    public void initData(){
        lCategory = new ArrayList<>();
        lCategory.add(new Category(R.drawable.gemstone, "Gemstone"));
        lCategory.add(new Category(R.drawable.food, "Food"));
        lCategory.add(new Category(R.drawable.fast_food, "Fast Food"));
        lCategory.add(new Category(R.drawable.mobile, "Mobile"));
        lCategory.add(new Category(R.drawable.handbag, "Handbag"));
        lCategory.add(new Category(R.drawable.electronic, "Electronic"));
        lCategory.add(new Category(R.drawable.interior, "Interior"));
        lCategory.add(new Category(R.drawable.stationery, "Stationery"));
        lCategory.add(new Category(R.drawable.camera, "Camera"));
        listCategoryLiveData.setValue(lCategory);
    }
    public MutableLiveData<List<Category>> getListCategoryLiveData() {
        return listCategoryLiveData;
    }
}