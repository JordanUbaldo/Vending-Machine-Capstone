package vendingmachine;

import com.vendingmachine.Menu;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MenuTest {

    private Menu objectUnderTest;

    @Before
    public void fresh_new_object() {
        objectUnderTest = new Menu();
    }
    @Test
    public void testMenu1() {
        String testInput = "5";
         String output = Menu.mainMenu(testInput);
        Assert.assertEquals("", output);
    }


}
