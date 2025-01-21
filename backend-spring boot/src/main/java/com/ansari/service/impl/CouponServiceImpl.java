package com.ansari.service.impl;

import com.ansari.exception.CouponNotValidException;
import com.ansari.model.Cart;
import com.ansari.model.Coupon;
import com.ansari.model.User;
import com.ansari.repository.CartRepository;
import com.ansari.repository.CouponRepository;
import com.ansari.repository.UserRepository;
import com.ansari.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;
    private final UserRepository userRepository;
    private final CartRepository cartRepository;

    @Override
    public Cart applyCoupon(String code,
                                 double orderValue,
                                 User user)
            throws Exception {
        Coupon coupon = couponRepository.findByCode(code);
        Cart cart = cartRepository.findByUserId(user.getId());


        if (coupon==null) {
            throw new CouponNotValidException("coupon not found");
        }
        if(user.getUsedCoupons().contains(coupon)){
            throw new CouponNotValidException("coupon already used");
        }
        if(orderValue <= coupon.getMinimumOrderValue()){
            throw new CouponNotValidException("valid for minimum order value "+coupon.getMinimumOrderValue() );
        }

            if (
                    coupon.isActive() &&
                    LocalDate.now().isAfter(coupon.getValidityStartDate()) &&
                    LocalDate.now().isBefore(coupon.getValidityEndDate())


            ) {

                user.getUsedCoupons().add(coupon);
                userRepository.save(user);

                double discountedPrice = Math.round((cart.getTotalSellingPrice() * coupon.getDiscountPercentage()) / 100);
                cart.setTotalSellingPrice(cart.getTotalSellingPrice() - discountedPrice);
                cart.setCouponCode(code);
                cart.setCouponPrice((int) discountedPrice);
                return cartRepository.save(cart);
//                return cart;
            }
            throw new CouponNotValidException("coupon not valid...");

    }

    @Override
    public Cart removeCoupon(String code, User user) throws Exception {
        Coupon coupon = couponRepository.findByCode(code);

        if(coupon==null){
            throw new Exception("coupon not found...");
        }
        user.getUsedCoupons().remove(coupon);

        Cart cart = cartRepository.findByUserId(user.getId());
//        double discountedPrice = (cart.getTotalSellingPrice() * coupon.getDiscountPercentage()) / 100;
//        cart.setTotalSellingPrice(cart.getTotalSellingPrice() + discountedPrice);
        cart.setTotalSellingPrice(cart.getTotalSellingPrice()+cart.getCouponPrice());
        cart.setCouponCode(null);
        cart.setCouponPrice(0);
        return cartRepository.save(cart);

    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCoupon(Long couponId) {
        couponRepository.deleteById(couponId);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Coupon getCouponById(Long couponId) {
//        return couponRepository.findById(couponId).orElseThrow(new Exception("coupon not found"));
    return null;
    }
}
