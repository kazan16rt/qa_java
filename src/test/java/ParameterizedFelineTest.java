import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {
    private final int input;
    private final int expected;
    public ParameterizedFelineTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Spy
    Feline feline = new Feline();

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {0, 0},
                {1, 1},
                {10, 10},
        };
    }

    @Test
    public void getKittensReturnsNumberOfKitten() {
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(input);

        int actual = feline.getKittens();

        assertEquals("Number of kittens is wrong", expected, actual);
    }

    @Test
    public void getKittensReturnsCurrentNumberOfKittens() {
        Feline feline = new Feline();

        int actual = feline.getKittens(input);

        assertEquals("Number of kittens is wrong", expected, actual);
    }
}
