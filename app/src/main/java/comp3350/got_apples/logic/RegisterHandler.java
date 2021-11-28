package comp3350.got_apples.logic;

import comp3350.got_apples.application.Services;
import comp3350.got_apples.objects.CurrentUser;
import comp3350.got_apples.persistence.RecipeInterface;
import comp3350.got_apples.persistence.RegisterInterface;

public class RegisterHandler {

    RegisterInterface registerInterface;

    public RegisterHandler(boolean isHSQLDB) {
        this.registerInterface = Services.getRegisterInterface(isHSQLDB);
    }

    public RegisterHandler(final RegisterInterface registerInterface) {
        this.registerInterface = registerInterface;
    }

    public boolean isExistingUser(CurrentUser currentUser){
        boolean exists = false;
        if(registerInterface.checkUserExists(currentUser)){
            exists = true;
        }
        return exists;
    }

    //this method will add to hsqldb
    public boolean addUser(CurrentUser currentUser){
        if(currentUser!=null) {
            return registerInterface.addUser(currentUser);
        }
        return false;
    }
}
