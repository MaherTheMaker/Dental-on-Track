package com.Maker.controller;



import com.Maker.config.JwtTokenUtil;
import com.Maker.dao.ClinicRepo;
import com.Maker.dao.PatientToothRepo;
import com.Maker.dao.UserDao;
import com.Maker.model.*;

import com.Maker.service.ClinicService;
import com.Maker.service.IllnessService;
import com.Maker.service.JwtUserDetailsService;

import com.Maker.service.PatientToothService;
import lombok.Data;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/clinic")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private ClinicRepo clinicRepo;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder bcryptEncoder;


    @Autowired
    private IllnessService illnessService;

    @Autowired
    private PatientToothRepo patientToothRepo;

    @PostMapping("/editClinicInfo")
    public ResponseEntity<Clinic> editClinicInfo(@RequestBody Clinic clinic){
        return ResponseEntity.ok().body(clinicService.editInfo(clinic));
    }

    @PostMapping("/createUser/{role}") //todo limit user number in clinic
    public ResponseEntity<DAOUser> createUser(@PathVariable int role, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok().body(clinicService.createUser(role,userDTO));
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    @GetMapping("/getClinic")
    public ResponseEntity<Clinic> getClinicInfo(){
        return ResponseEntity.ok().body(clinicRepo.findById(1));
    }

    @PostMapping("/changePassword") //todo check for old password ...done
    public ResponseEntity<DAOUser> ChangePassword(@RequestBody changePass changePass) {
        DAOUser daoUser = userDao.findByUsername(changePass.username);
        if (bcryptEncoder.matches(changePass.oldPassword,daoUser.getPassword())) {
            return ResponseEntity.ok().body(clinicService.changePassword(changePass.username, changePass.newPassword));
        }else
            return null;
    }


    @PostMapping("/changeUserInfo")
    public ResponseEntity<DAOUser> ChangeUserInfo(@RequestBody DAOUser daoUser){
        return ResponseEntity.ok().body(clinicService.changeUserInfo(daoUser));
    }



//    @PostMapping("/requestForPlan")
//    public ResponseEntity<PendingRequest> requestPlan(@RequestBody pendingRequestFrom form){
//            return ResponseEntity.ok().body(clinicService.requestForPlan(form.getUsername(),form.getPlanName()));
//    }


//    @PostMapping("/getClinic/{username}")
//    public ResponseEntity<Clinic> getPlan(@PathVariable String username){
//       return ResponseEntity.ok().body(clinicService.getClinic(username));
//    }


    @PostMapping("/AddIllness")
    public ResponseEntity<Illness> addIllness(@RequestBody Illness illness){
        if(illnessService.getIllness(illness.getName()) == null){
            return ResponseEntity.accepted().body(illnessService.addIllness(illness));
        }else
            return ResponseEntity.noContent().build();
    }


    @GetMapping("/GetIllness/{name}")
    public ResponseEntity<Illness> getIllness(@PathVariable String name){
        Illness illness ;
        illness = illnessService.getIllness(name);
        if(illness != null){
            return ResponseEntity.ok().body(illness);
        }else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/GetAllIllnesses")
    public ResponseEntity<List<Illness>> getAllIllnesses(){
        List<Illness> illnessList;
        illnessList = illnessService.getAllIllness();
        if(illnessList.isEmpty()){
            return ResponseEntity.notFound().build();
        }else
            return ResponseEntity.ok(illnessList);
    }

    @GetMapping("/GetTooth/{pid}")
    public ResponseEntity<List<PatientTooth>> getTeeth(@PathVariable int pid){
        System.out.printf("before");
        List<PatientTooth> list= patientToothRepo.findAllByPatientId(pid);
        System.out.println("here");
        if(list != null){
            return ResponseEntity.ok().body(list);
        }else
            return ResponseEntity.notFound().build();
    }


//
//    @PostMapping("addTooth")
//    public ResponseEntity<Tooth> addTooth(@RequestBody Tooth tooth){
//        if(toothService.getTooth(tooth.getName())!=null){
//            return ResponseEntity.accepted().body(toothService.addTooth(tooth));
//        }
//        else return ResponseEntity.badRequest().build();
//    }
//
//    @GetMapping("/GetTooth/{name}")
//    public ResponseEntity<Tooth> getTooth(@PathVariable String name){
//        Tooth tooth ;
//        tooth = toothService.getTooth(name);
//        if(tooth!= null){
//            return ResponseEntity.ok().body(tooth);
//        }else
//            return ResponseEntity.notFound().build();
//    }
//
//    @GetMapping("/GetAllIllnesses")
//    public ResponseEntity<List<Tooth>> getAllTooth(){
//        List<Tooth> toothList;
//        toothList = toothService.getAllTooth();
//        if(toothList.isEmpty()){
//            return ResponseEntity.notFound().build();
//        }else
//            return ResponseEntity.ok(toothList);
//    }

}

@Data
class changePass{
    public String username;
    public String oldPassword;
    public String newPassword;
}



@Data
class pendingRequestFrom
{
    private String username;
    private String planName;
}