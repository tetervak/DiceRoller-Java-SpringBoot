package ca.tetervak.diceroller.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    static Random random;

    @BeforeAll
    static void startAll() {
        out.println("--- Starting Die Tests ---");
        random = new Random(4);
    }

    @AfterAll
    static void endAll() {
        out.println("--- End of Die Tests ---");
    }

    @BeforeEach
    void setUp() {
        out.println("--- testing case ---");
    }

    @AfterEach
    void tearDown() {
        out.println("--- ------- ---- ---");
    }

    @Test
    void constructor_default() {
        out.println("constructor without parameters");
        Die die = new Die();
        out.println("die.value = " + die.getValue());
        assertEquals(Die.INIT_VALUE, die.getValue());
    }

    @Test
    void constructor_valueFive() {
        out.println("constructor with init value 5");
        Die die = new Die(5);
        out.println("die.value = " + die.getValue());
        assertEquals(5, die.getValue());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 6})
    void constructor_validValue(int value) {
        out.println("constructor with valid init value: " + value);
        Die die = new Die(value);
        out.println("die.value = " + die.getValue());
        assertEquals(value, die.getValue());
    }

    @Test
    void constructor_valueZero() {
        out.println("constructor with init value 0");
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new Die(0)
        );
        assertEquals("Illegal die value 0", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 6})
    void setValue_validValue(int value) {
        out.println("constructor with valid init value: " + value);
        Die die = new Die();
        die.setValue(value);
        out.println("die.value = " + die.getValue());
        assertEquals(value, die.getValue());
    }

    @Test
    void setValue_valueZero() {
        out.println("constructor with init value 0");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                    Die die = new Die();
                    die.setValue(0);
                    out.println("die.value = " + die.getValue());
                }
        );
        assertEquals("Illegal die value 0", exception.getMessage());
    }

    @Test
    void reset() {
        Die die = new Die(5);
        out.println("before reset: die.value = " + die.getValue());
        die.reset();
        out.println("after reset: die.value = " + die.getValue());
        assertEquals(Die.INIT_VALUE, die.getValue());
    }

    @RepeatedTest(5)
    void roll(RepetitionInfo info) {
        out.println("repetition: " + info.getCurrentRepetition());
        Die die = new Die();
        int value = die.roll();
        out.println("die.value = " + die.getValue());
        assertEquals(value, die.getValue());
        assertTrue(value > 0);
        assertTrue(value <= 6);
    }

    @RepeatedTest(5)
    void roll_reproducible(RepetitionInfo info) {
        out.println("repetition: " + info.getCurrentRepetition());
        Die die = new Die(random);
        int value = die.roll();
        out.println("die.value = " + die.getValue());
        assertEquals(value, die.getValue());
        assertTrue(value > 0);
        assertTrue(value <= 6);
    }

}
