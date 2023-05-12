package d2.springdatajpa_10_05.Service.ServiceImp;

import d2.springdatajpa_10_05.Model.UserEntity;
import d2.springdatajpa_10_05.Responsitory.UserRepository;
import d2.springdatajpa_10_05.Service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    public UserServiceImp(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public void save(UserEntity user) {
        userRepository.createUser(user);
    }

    @Override
    public void update(UserEntity user) {
         userRepository.updateUser(user);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(int id) {
       userRepository.deleteUser(id);
    }

    @Override
    public UserEntity findById(int id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public Map<String, Object> pagingUser(String name, String sort, int page, int size) {
        Pageable pageable ;
        if (sort.equals("desc")) {
             pageable = PageRequest.of(page, size, Sort.by("age").descending());
        }else {
            pageable = PageRequest.of(page, size, Sort.by("age").ascending());
        }
        Page<UserEntity> userEntities=userRepository.findAll(pageable);
        Map<String,Object> data=new HashMap<>();
        data.put("User in pages",userEntities.getContent());
        data.put("Total elements in page",userEntities.getTotalElements());
        data.put("Total in page",userEntities.getTotalPages());
        data.put("Size",userEntities.getSize());
        return data;
    }

    @Override
    public List<UserEntity> getAllAdrress(String address) {
        return userRepository.getAllAdrress(address);
    }

    @Override
    public List<UserEntity> findTop3ByAddress(String address) {
        return userRepository.findTop3ByAddress(address);
    }

    @Override
    public List<UserEntity> findFirst4ByUserName(String name) {
        return userRepository.findFirst4ByUserName(name);
    }
}
