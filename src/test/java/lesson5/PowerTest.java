package lesson5;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class PowerTest {
    @Parameterized.Parameter
    public double number;

    @Parameterized.Parameter(1)
    public int power;

    @Parameterized.Parameter(2)
    public double expected;

    @Parameterized.Parameter(3)
    public Class<? extends Exception> expectedException;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {2, 3, 8, null},
                {3, 1, 3, null},
                {-3, 1, -3, null},
                {-3, 2, 9, null},
                {4, 0, 1, null},
                {0.5, 2, 0.25, null},
                {5, -1, 0.2, null},
                {0, 5, 0, null},
                {0, -1, 0, ArithmeticException.class}
        });
    }

    @Test
    public void powerTest() {
        if (expectedException != null)
            thrown.expect(expectedException);

        Assert.assertEquals(expected, Power.pow(number, power), 0.01);
    }
}
