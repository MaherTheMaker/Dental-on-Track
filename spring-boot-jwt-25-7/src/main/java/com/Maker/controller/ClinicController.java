package com.Maker.controller;



import com.Maker.config.JwtTokenUtil;
import com.Maker.dao.ClinicRepo;
import com.Maker.dao.ExpensesRepo;
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
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.Date;
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

    @Autowired
    private ExpensesRepo expensesRepo;


    @Autowired
    private RestTemplate rest = new RestTemplate();

    // Annotation
    @Bean
// Method
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @PostMapping("/editClinicInfo")
    public ResponseEntity<Clinic> editClinicInfo(@RequestBody Clinic clinic){
        rest.postForEntity(
                "http://192.168.174.39:9090/clinic/editClinic/"+clinic.getUsername(), clinic,
                Clinic.class,"");
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

    @PostMapping("/changePassword")
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
       return ResponseEntity.accepted().body(illnessService.addIllness(illness));
    }


    @GetMapping("/GetIllness/{name}")
    public ResponseEntity<Illness> getIllness(@PathVariable String name){;
        return ResponseEntity.ok().body(illnessService.getIllness(name));
    }

    @GetMapping("/GetAllIllnesses")
    public ResponseEntity<List<Illness>> getAllIllnesses(){
        return ResponseEntity.ok(illnessService.getAllIllness());
    }


    @GetMapping("/getProfit")
    private ResponseEntity<Float> getProfit(@RequestBody fromToDate fromTo){
        return ResponseEntity.accepted().body(clinicService.getProfit(fromTo.getFrom(),fromTo.getTo()));
    }


    @PostMapping("/planRequest")
    public String  planRequest(@RequestBody pendingRequestFrom pendingRequestFrom)
    {
        System.out.println(pendingRequestFrom.getPlanId()+pendingRequestFrom.getUsername());
         rest.postForEntity(
                "http://192.168.174.39:9090/clinic/requestForPlan", pendingRequestFrom,
                String.class,"");
return "Done";
    }

    @GetMapping("/getAllPlans")
    private ResponseEntity<List<Plan>> getAllPlans(){
ResponseEntity<List<Plan>> listResponseEntity=       rest.exchange("http://192.168.174.39:9090/plan/all", HttpMethod.GET,null,new ParameterizedTypeReference<List<Plan>>(){});
return ResponseEntity.ok().body(listResponseEntity.getBody());
    }




}

@Data
class fromToDate{
    Date from;
    Date to;


}


@Data
class changePass{
    public String username;
    public String oldPassword;
    public String newPassword;
}

@Data
class ListOfPlans{
    List<Plan> planList;
}

@Data
class pendingRequestFrom
{
    private String username;
    private int  planId;
}