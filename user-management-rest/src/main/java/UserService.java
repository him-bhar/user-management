import java.util.List;

import com.himanshu.um.api.model.Privilege;
import com.himanshu.um.api.model.Role;
import com.himanshu.um.api.model.User;

public interface UserService {

	public User getUser(Integer id);
	public List<User> getAllUsers();
	public List<Role> getAllRoles();
	public List<Privilege> getAllPrivileges();


}
