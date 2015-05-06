package models;

import at.ac.tuwien.big.we15.lab2.api.Avatar;
import at.ac.tuwien.big.we15.lab2.api.impl.SimpleUser;

import javax.persistence.Entity;
import javax.persistence.Id;


import play.data.validation.Constraints;
import play.data.validation.ValidationError;

@Entity
public class RealUser extends SimpleUser {

    @Id
    @Constraints.Required
    @Constraints.MinLength(4)
    @Constraints.MaxLength(8)
    public String username;

    @Constraints.Required
    @Constraints.MinLength(4)
    @Constraints.MaxLength(8)
    public String password;

    public String gender;
    public String firstname;
    public String lastname;
    /*TODO: Pattern Syntax*/
   // @Constraints.Pattern(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[012]).(19|20)))
    public String birthdate;
}
