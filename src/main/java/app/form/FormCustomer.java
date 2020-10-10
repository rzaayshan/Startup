package app.form;

import lombok.Data;

@Data
public class FormCustomer {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String password2;
}
