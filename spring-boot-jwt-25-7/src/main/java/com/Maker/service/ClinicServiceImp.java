package com.Maker.service;



import com.Maker.dao.ClinicRepo;
import com.Maker.dao.UserDao;
import com.Maker.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClinicServiceImp implements ClinicService {

    @Autowired
    private ClinicRepo clinicRepo;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public Clinic editInfo(Clinic clinic) {
        Clinic old= clinicRepo.findById(clinic.getId());
        old.setClinicAddress(clinic.getClinicAddress());
        old.setClinicName(clinic.getClinicName());
        old.setClinicPhone(clinic.getClinicPhone());
        old.setMobilePhone(clinic.getMobilePhone());

        return  clinicRepo.save(old);


    }

    @Override
    public DAOUser createUser(int role,UserDTO user) {
        DAOUser daoUser=new DAOUser();
        daoUser.setUsername(user.getUsername());
        daoUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        if (role==1)
        {
            daoUser.setRole(Role.Assistant);
        }
        else if (role==2)
        {
            daoUser.setRole(Role.Secretary);
        }


        return   userDao.save(daoUser);

    }

    @Override
    public DAOUser changePassword(String username, String newPass) {

        DAOUser daoUser= userDao.findByUsername(username);
        daoUser.setPassword(bcryptEncoder.encode(newPass));
        return userDao.save(daoUser);
    }

    @Override
    public DAOUser changeUserInfo(DAOUser daoUser) {
        DAOUser daoUser1 = userDao.findById(daoUser.getId());
        daoUser1.setFullName(daoUser.getFullName());
        daoUser1.setAddress(daoUser.getAddress());
        daoUser1.setRole(daoUser.getRole());
        daoUser1.setNumber(daoUser.getNumber());
        daoUser1.setEmail(daoUser.getEmail());
        return userDao.save(daoUser1);
    }


}