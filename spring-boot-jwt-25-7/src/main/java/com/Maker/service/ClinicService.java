package com.Maker.service;


import com.Maker.model.Clinic;
import com.Maker.model.DAOUser;
import com.Maker.model.PendingRequest;
import com.Maker.model.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicService {
    Clinic editInfo(Clinic clinic);
    DAOUser createUser(int role, UserDTO userDTO);
    DAOUser changePassword(String username, String newPass);
    DAOUser changeUserInfo(DAOUser daoUser);
}