package dataprovider;

import lombok.Getter;

@SuppressWarnings("FieldMayBeFinal")
@Getter
public class CartTestData {

    private String username;
    private String password;
    private String itemToAdd;
    private String firstName;
    private String lastName;
    private String zipCode;

    public CartTestData(String username, String password, String itemToAdd, String firstName, String lastName, String zipCode) {
        this.username = username;
        this.password = password;
        this.itemToAdd = itemToAdd;
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
    }
}
