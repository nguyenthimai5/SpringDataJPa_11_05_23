package d2.springdatajpa_10_05.Controller;

import d2.springdatajpa_10_05.Model.UserEntity;
import d2.springdatajpa_10_05.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    private  final UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/")
    public  ResponseEntity<List<UserEntity>> getAllUser(){
        return ResponseEntity.ok(userService.getAllUser());
    }
    @PostMapping("/")
    public  void save(@RequestBody UserEntity user){
        userService.save(user);
    }
    @PutMapping("/")
    public  void update(@RequestBody UserEntity user){
         userService.update(user);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity<?> delete(@PathVariable int id){
        userService.deleteUser(id);
        return ResponseEntity.ok("Xoá thành công user");
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?> finfById(@PathVariable int id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @GetMapping("/sort")
    public  ResponseEntity<?> sort(@RequestParam String name,
                                   @RequestParam(defaultValue = "desc") String sort,
                                   @RequestParam (defaultValue = "0")int page,
                                   @RequestParam(defaultValue = "3") int size){
        return ResponseEntity.ok(userService.pagingUser(name,sort,page,size));
    }
    @GetMapping("/address")
    public  ResponseEntity<?> address(@RequestParam String address){
        return ResponseEntity.ok(userService.getAllAdrress(address));
    }

    @GetMapping("/addressTop3")
    public  ResponseEntity<?> addressTop3(@RequestParam String address){
        return ResponseEntity.ok(userService.findTop3ByAddress(address));
    }

    @GetMapping("/userNameFirst")
    public  ResponseEntity<?> userNameFirst(@RequestParam String name){
        return ResponseEntity.ok(userService.findFirst4ByUserName(name));
    }
}
