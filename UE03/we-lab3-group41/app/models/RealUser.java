package models;

import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;

import javax.persistence.Entity;
import javax.persistence.Id;


import play.data.validation.Constraints;

@Entity
public class RealUser extends SimpleUser {

    @Id
    @Constraints.Required
    @Constraints.MinLength(4)
    @Constraints.MaxLength(8)
    @Constraints.Pattern(value="\\w{4,8}", message = "Benutzername hat zwischen 4 und 8 Zeichen.")
    public String username;

    @Constraints.Required
    @Constraints.MinLength(4)
    @Constraints.MaxLength(8)
    public String password;

    public String gender;
    public String firstname;
    public String lastname;

    @Constraints.Pattern(value="((0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19|20))", message="Invalid date format!")
    public String birthdate;

    public String getField(String name){
     return name == "username" ? "Benutzername" : "Passwort";
    }
}
