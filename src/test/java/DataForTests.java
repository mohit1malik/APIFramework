import org.testng.annotations.DataProvider;

public class DataForTests {

    @DataProvider(name = "Data for Post")
    public Object[][] dataForPost(){
        return new Object[][]{
                {"mohit","Malik"},
                {"rahul","Singh"}
        };
    }

    @DataProvider(name = "Data for Delete")
    public Object[][] dataForDelete(){
        return new Object[][]{
                {"id",2},
                {"id",3}
        };
    }
}
