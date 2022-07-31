package pro.sky.course2.calculator2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.course2.calculator2.Service.CalculatorServiceImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.course2.calculator2.CalculatorServiceImplTestConstants.*;


public class CalculatorServiceImplParameterTest {

    private final CalculatorServiceImpl out = new CalculatorServiceImpl();

    private static Stream<Arguments> provideArgumentsForCalculatorTests() {
        return Stream.of(
                Arguments.of(TWO, TWO),
                Arguments.of(FOUR, TWO),
                Arguments.of(FOUR, SIX),
                Arguments.of(EIGHT, FOUR),
                Arguments.of(SIX, TWO),
                Arguments.of(EIGHT, SIX)
        );
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectSummationResult(float num1, float num2) {
        assertEquals(num1+num2, out.getSum(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectSubtractionResult(float num1, float num2) {
        assertEquals(num1-num2, out.getMinus(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectMultiplicationResult(float num1, float num2) {
        assertEquals(num1*num2, out.getMultiply(num1, num2));
    }

    @MethodSource("provideArgumentsForCalculatorTests")
    @ParameterizedTest
    public void shouldReturnCorrectDivisionResult(float num1, float num2) {
        assertEquals(num1/num2, out.getDivide(num1, num2));
    }

}