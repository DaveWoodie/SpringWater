package entityrepository;

import java.util.List;

//import org.springframework.data.repository.CrudRepository;
//import org.springframework.stereotype.Repository;

import entities.User;
/**
 * @author dwoodward
 * @date 07/10/2015
 */

public interface UserRepository {
	public User findByID(int i);
	public User findByForNam(String s);
	public List<User> findByForNams(String s);
	public User findBySurNam(String s);
	public List<User> findBySurNams(String s);
	public List<User> findByEmploy(boolean b);
}