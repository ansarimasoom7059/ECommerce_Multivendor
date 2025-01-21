package com.ansari.repository;

import com.ansari.domain.PayoutsStatus;
import com.ansari.model.Payouts;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayoutsRepository extends JpaRepository<Payouts,Long> {

    List<Payouts> findPayoutsBySellerId(Long sellerId);
    List<Payouts> findAllByStatus(PayoutsStatus status);
}
