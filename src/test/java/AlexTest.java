import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Test
    public void getFriendsReturnsAlexsFriendList() throws Exception {
        Alex alex = new Alex(new Feline());
        List<String> expected = List.of("Марти", "Глории", "Мелман");

        List<String> actual = alex.getFriends();

        assertEquals("Returns incorrect Alex's friend list", expected, actual);
    }

    @Test
    public void getPlaceOfLivingReturnsCorrectPlace() throws Exception {
        Alex alex = new Alex(new Feline());
        String expected = "Нью-Йоркский зоопарк";

        String actual = alex.getPlaceOfLiving();

        assertEquals("Returns place is not equals expected", expected, actual);
    }

    @Spy
    Feline feline = new Feline();
    @Test
    public void getKittensReturnsNullValue() throws Exception {
        Alex alex = new Alex(feline);
        int expected = 0;
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(0);

        int actual = alex.getKittens();

        assertEquals("Returns number of kittens is not correct", expected, actual);
    }
}
