package models;

import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;

import javax.persistence.Entity;
import javax.persistence.Id;


import play.data.validation.Constraints;

@Entity
public class RealUser extends SimpleUser {

    @Id
    @Constraints.Required(message = "Der Benutzername muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.")
   // @Constraints.MinLength(value=4, message="Der Benutzername muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.")
   // @Constraints.MaxLength(8)
    @Constraints.Pattern(value="\\w{4,8}", message = "Der Benutzername muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.")
    public String username;

    @Constraints.Required(message = "Das Passwort muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.")
  //  @Constraints.MinLength(4)
  //  @Constraints.MaxLength(8)
    @Constraints.Pattern(value="\\w{4,8}", message = "Das Passwort muss mindestens 4 Zeichen und darf maximal 8 Zeichen enthalten.")
    public String password;

    public String gender;
    public String firstname;
    public String lastname;

    @Constraints.Pattern(value="((([0-2][1-9]|3[01]).(0(1|[3-9])|1[0-2])|(([0-2][1-9]).(2))).(19[0-9][0-9]|20[0-9][0-9]))",
            message="Verwenden Sie bitte folgendes Datumsformat: dd.mm.yyyy (z.B. 24.12.2010).")
    public String birthdate;

    public String getName() {
        return username;
    }
}
