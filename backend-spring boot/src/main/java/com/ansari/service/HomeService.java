package com.ansari.service;

import com.ansari.model.Home;
import com.ansari.model.HomeCategory;

import java.util.List;

public interface HomeService {

    Home creatHomePageData(List<HomeCategory> categories);

}
