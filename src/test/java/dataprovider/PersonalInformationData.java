package dataprovider;

import org.testng.annotations.DataProvider;

public class PersonalInformationData {
    @DataProvider(name = "PersonalInformationData")
    public Object[][] personalInformationData() {
        return new Object[][] {
                {"firstName","LastName","10001"},
        };
    }
}
