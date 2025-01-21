package com.ansari.service;

import com.ansari.model.Seller;
import com.ansari.model.SellerReport;

public interface    SellerReportService {
    SellerReport getSellerReport(Seller seller);
    SellerReport updateSellerReport( SellerReport sellerReport);

}
