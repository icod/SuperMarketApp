package nl.testcoders.supermarket.model;

import lombok.*;
import nl.testcoders.supermarket.constants.DiscountValues;

import java.util.Objects;

@RequiredArgsConstructor(staticName = "of", access = AccessLevel.PROTECTED)
public class ShoppingCartProduct {

    @NonNull
    @Getter
    private final Product product;

    @Getter
    @Setter
    private boolean isDiscountedExpiring = false;

    @Getter
    @Setter(AccessLevel.PROTECTED)
    private int quantity = 1;

    public double getPrice() {
        return getPriceBeforeDiscount() - getCalculatedDiscount();
    }

    public double getPriceBeforeDiscount() {
        return quantity * product.getPriceBeforeDiscount();
    }

    public double getCalculatedDiscount() {
        if (isDiscountedExpiring) {
            return quantity * product.getPriceBeforeDiscount() * DiscountValues.EXPIRING;
        }
        return quantity * (product.getPriceBeforeDiscount() - product.getPrice());
    }

    public boolean increase() {
        return increaseBy(1);
    }

    public boolean decrease() {
        return increaseBy(-1);
    }

    private boolean increaseBy(int by) {
        if (quantity + by > 0) {
            quantity += by;
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartProduct that = (ShoppingCartProduct) o;
        return isDiscountedExpiring == that.isDiscountedExpiring &&
                product.equals(that.product);
    }

}
