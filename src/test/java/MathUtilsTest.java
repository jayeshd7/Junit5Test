import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runners.Parameterized;

import static org.junit.jupiter.api.Assumptions.*;

import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS) //single Instance created for all TC
class MathUtilsTest {
    private MathUtils mathUtils;

    @BeforeAll
    void beforeAll(){
        System.out.println("Before run all TC ...");
    }

    @BeforeEach
    @DisplayName("init for each test cases")
    void initEach() {
        mathUtils = new MathUtils();
    }

    @Nested
    @DisplayName("Add method")
    class AddTest{
        @Test
        @DisplayName("adding the two positive digits")
        @EnabledOnOs(OS.MAC)
        void addPositive() {
            int actual = mathUtils.add(1, 1);
            assertEquals(2,actual ,
                    "Add method should return the sum of two numbers");

        }

        @Test
        @DisplayName("adding the two negative digits")
        @EnabledOnOs(OS.MAC)
        void addNegative() {
            int actual = mathUtils.add(-1, -1);
            assertEquals(-2,actual ,
                    "Add method should return the sum of two numbers");

        }
    }

    @Test
    @DisplayName("divide the two number")
    void divide(){
        boolean serverUp = true;
        assumeTrue(serverUp);
        assertThrows(ArithmeticException.class, () -> mathUtils.divide(1,0), "when second argument is provide zero");
    }


    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {

    }


    @AfterAll
    void tearEach(){
        System.out.println("TC run successded...");
    }
}