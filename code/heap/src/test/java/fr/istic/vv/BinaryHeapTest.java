package fr.istic.vv;
import net.jqwik.api.*;


public class BinaryHeapTest {
    @Property
    boolean absoluteValueOfAllNumbersIsPositive(@ForAll int anInteger) {
        return Math.abs(anInteger) >= 0;
    }

    /**
     * Generate random inputs for the heap and ensures the element returned
     * by pop every time it is invoked is the minimum of the remaning elements
     * in the heap
     */
}
