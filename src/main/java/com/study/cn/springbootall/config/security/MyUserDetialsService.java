package com.study.cn.springbootall.config.security;

import com.study.cn.springbootall.entity.Permission;
import com.study.cn.springbootall.entity.Role;
import com.study.cn.springbootall.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class MyUserDetialsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //此处的user是entity包中的user
        com.study.cn.springbootall.entity.User user = userRepository.findByUsername(userName);
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            //获取用户的角色集合
            List<Role> roles = user.getRoles();
            //遍历角色集合，并获取每个角色拥有的权限
            for (Role role : roles) {
                List<Permission> permissions = role.getPermissions();
                for (Permission permission :permissions) {
                    //为每个授权中心对象写入权限名
                    grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
                }
            }
            /**此处的user是springsecurity中的一个实现了UserDetails接口的user类，因为我们没有将entity中的user去实现
             * UserDetails接口，所以只能在此处调用实现好的构造方法
             */
            return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
        return null;
    }
}

