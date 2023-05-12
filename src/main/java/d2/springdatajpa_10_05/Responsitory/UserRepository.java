package d2.springdatajpa_10_05.Responsitory;

import d2.springdatajpa_10_05.Model.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    UserEntity findByUserId(int id);

    List<UserEntity> findTop3ByAddress(String address);

    List<UserEntity> findFirst4ByUserName(String name);
    @Modifying
    @Query( value = " INSERT INTO UserEntity( address, age, userName, userSex)\n" +
            "values (:#{#user.address}, :#{#user.age}, :#{#user.userName}, :#{#user.userSex})", nativeQuery= true)
    @Transactional
    void createUser(@Param("user") UserEntity user);

    @Query("from UserEntity u where u.address=:address")
    List<UserEntity> getAllAdrress(@Param("address") String address);

    @Modifying
    @Query(value =" update UserEntity u set u.address=:#{#user.address}," +
                                             "u.age=:#{#user.age},"+
                                             "u.userName=:#{#user.userName},"+
                                             "u.userSex=:#{#user.userSex} " +
                                             "where u.userId=:#{#user.userId}" )
    @Transactional
    void updateUser(@Param("user") UserEntity user);

    @Modifying
    @Query(value = "delete from UserEntity u where u.userId=:id")
    @Transactional
    void  deleteUser(@Param("id") int id);



}

