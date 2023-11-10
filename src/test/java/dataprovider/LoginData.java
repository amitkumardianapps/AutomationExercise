package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginData {

  @DataProvider(name = "LoginCredentials")
  public Object[][] loginCreds() {
      return new Object[][]{
      {"standard_user", "secret_sauce"},
    };
  }
}
