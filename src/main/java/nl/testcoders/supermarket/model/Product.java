package nl.testcoders.supermarket.model;

import lombok.*;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Product {

    @Getter
    private final String description;
    @Getter
    private final long barcode;
    @Getter
    private final double price;
    @Getter
    @Setter
    @NonNull
    private long amountInStock;
    @Getter @Setter
    private boolean isDiscountedBonus;
    @Getter @Setter
    private boolean isDiscountedExpiring;

    public double getPriceAfterDiscount() {
        return price - price * determineDiscount();
    }

    private double determineDiscount() {
        if (isDiscountedExpiring) {
            return .35d;
        }
        if (isDiscountedBonus) {
            return .20d;
        }
        return 0d;
    }

    public void removeDiscount() {
        this.isDiscountedBonus = false;
        this.isDiscountedExpiring = false;
    }

}
