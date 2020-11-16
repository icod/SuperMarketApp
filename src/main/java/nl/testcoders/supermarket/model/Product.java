package nl.testcoders.supermarket.model;

import lombok.*;
import nl.testcoders.supermarket.constants.DiscountValues;

@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Product {

    @Getter
    private final String description;

    @Getter
    @EqualsAndHashCode.Include
    private final long barcode;

    @Getter
    private final double priceBeforeDiscount;

    @Getter
    @Setter
    @NonNull
    private long amountInStock;

    @Getter
    @Setter
    private boolean isDiscountedBonus;

    public double getPrice() {
        return priceBeforeDiscount * (1 - determineDiscount());
    }

    private double determineDiscount() {
        if (isDiscountedBonus) {
            return DiscountValues.BONUS;
        }
        return DiscountValues.NO_DISCOUNT;
    }

    public void removeDiscount() {
        this.isDiscountedBonus = false;
    }

}
