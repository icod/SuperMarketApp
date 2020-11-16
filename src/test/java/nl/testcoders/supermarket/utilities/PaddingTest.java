package nl.testcoders.supermarket.utilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaddingTest {

    @Test
    void right_string() {
    }

    @Test
    void right_int() {
        assertEquals("3  ", Padding.right(3, 3) );
    }

    @Test
    void right_double() {
        assertEquals("0.3 ", Padding.right(.3, 4) );
    }

    @Test
    void left_string() {
        assertEquals("  abc", Padding.left("abc", 5) );
    }
}