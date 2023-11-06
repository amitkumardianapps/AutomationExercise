package dataprovider;

import org.testng.annotations.DataProvider;

public class LoginData {

  @DataProvider(name = "LoginCredentials")
  public Object[][] loginCreds() {
    Object[][] Data = {
      {"standard_user", "secret_sauce"},
    };
    return Data;
  }
}
