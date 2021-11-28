package comp3350.got_apples.persistence;

import comp3350.got_apples.objects.CurrentUser;

public interface RegisterInterface {
   boolean addUser(CurrentUser currentUser);
   boolean checkUserExists(CurrentUser currentUser);
}
