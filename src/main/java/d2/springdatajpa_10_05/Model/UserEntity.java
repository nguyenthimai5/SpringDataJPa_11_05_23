package d2.springdatajpa_10_05.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "UserEntity")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "userSex")
    private boolean userSex;

    @OneToMany(mappedBy = "userEntity",fetch = FetchType.LAZY)
    private List<CarEntity> carEntityList=new ArrayList<>();

    public UserEntity() {
    }

    public UserEntity(int userId, String userName, int age, String address, boolean userSex, List<CarEntity> carEntityList) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.address = address;
        this.userSex = userSex;
        this.carEntityList = carEntityList;
    }

    public List<CarEntity> getCarEntityList() {
        return carEntityList;
    }

    public void setCarEntityList(List<CarEntity> carEntityList) {
        this.carEntityList = carEntityList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isUserSex() {
        return userSex;
    }

    public void setUserSex(boolean userSex) {
        this.userSex = userSex;
    }
}
