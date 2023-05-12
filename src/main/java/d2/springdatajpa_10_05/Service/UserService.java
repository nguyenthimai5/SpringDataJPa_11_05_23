package d2.springdatajpa_10_05.Service;

import d2.springdatajpa_10_05.Model.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface UserService {
    void save(UserEntity user);
    void update(UserEntity user);
    List<UserEntity> getAllUser();
    void deleteUser(int id);
    UserEntity findById(int id);
    Map<String,Object> pagingUser(String name,String sort,int page, int size);

    List<UserEntity> getAllAdrress(String address);

    List<UserEntity> findTop3ByAddress(String address);
    List<UserEntity> findFirst4ByUserName(String name);

}