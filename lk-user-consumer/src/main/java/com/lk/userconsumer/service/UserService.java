package com.lk.userconsumer.service;

import com.lk.userconsumer.dao.UserDao;
import com.lk.userconsumer.dao.UserFeignClient;
import com.lk.userconsumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    UserDao userDao;

//    public List<User> queryUserByIds(List<Long> ids) {
//        List<User> users = new ArrayList<>();
//        List<ServiceInstance> instances = discoveryClient.getInstances("lk-user-server");
//        ServiceInstance instance = instances.get(0);
//        String serviceUrl = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/";
//        ids.forEach(id -> {
//            users.add(restTemplate.getForObject(serviceUrl + id, User.class));
//        });
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return users;
//    }
//    public List<User> queryUserByIds(List<Long> ids){
//        List<User> users = new ArrayList<>();
//        // 地址直接写服务名称即可
//        String baseUrl = "http://lk-user-server/user/";
//        ids.forEach(id -> {
//            // 我们测试多次查询，
//            users.add(this.restTemplate.getForObject(baseUrl + id, User.class));
//            // 每次间隔500毫秒
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        return users;
//    }
//    public List<User> queryUserByIds(List<Long> ids){
//        List<User> users = new ArrayList<>();
//        ids.forEach(id->{
//            users.add(userDao.queryUserById(id));
//        });
//        return users;
//    }

    @Autowired
    private UserFeignClient userFeignClient;

    public List<User> queryUserByIds(List<Long> ids) {
        List<User> users = new ArrayList<>();
        ids.forEach(id -> {
            // 我们测试多次查询，
            users.add(this.userFeignClient.queryUserById(id));
        });
        return users;
    }
}
