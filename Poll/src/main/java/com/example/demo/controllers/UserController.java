package com.example.demo.controllers;

import com.example.demo.dtos.CandidateDto;
import com.example.demo.dtos.RegisterUserDto;
import com.example.demo.dtos.VotingDto;
import com.example.demo.model.User;
import com.example.demo.model.Vote;
import com.example.demo.services.RoleServiceInterface;
import com.example.demo.services.UserServiceInterface;
import com.example.demo.services.VoteServiceInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    RoleServiceInterface roleServiceInterface;
    @Autowired
    UserServiceInterface userServiceInterface;
    @Autowired
    VoteServiceInterface voteServiceInterface;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/admin")
    public String allUsers(ModelMap mm) {
        List<User> allUsers = userServiceInterface.getAllUsers();
        mm.addAttribute("users", allUsers);
        return "adminpage";
    }

    @GetMapping("/preregister")
    public String preRegister(ModelMap mm) {
        RegisterUserDto registerUserDto = new RegisterUserDto();
        mm.addAttribute("registeruser", registerUserDto);
        mm.addAttribute("allroles", roleServiceInterface.getAllRoles());
        return "register"; //register.jsp
    }

    @PostMapping("/doregister")
    public String doRegister(@ModelAttribute("registeruser") RegisterUserDto dto,
            ModelMap mm, HttpSession session) {
        User u = new User();
        u.setUserfirstname(dto.getFirstname());
        u.setUserlastname(dto.getLastname());
        u.setUsername(dto.getUsername());
        u.setRoleid(dto.getRole());
        u.setUserpassword(passwordEncoder.encode(dto.getPassword()));
        userServiceInterface.insertUser(u);
        session.setAttribute("polluser", u);
        return "redirect:/afterRegistration";
    }

    @RequestMapping("/afterRegistration")
    public String afterRegistration(HttpSession session, ModelMap mm) {
        return "redirect:/voting";
    }

    @PostMapping("/dologin")
    public String login(@RequestParam("username") String username,
            @RequestParam("password") String password,
            ModelMap mm,
            HttpSession session) {
        User tempuser = userServiceInterface.getUserByUsername(username);
        if (tempuser == null) {// wrong username
            mm.addAttribute("wrongCredentials", "wrong username");
            return "index";
        } else {
            if (username.equals("admin") && password.equals("qwerty")) {
                return "forward:/admin";
            }
            // checks the plain-text password with .matches, since database's password is hashed.
            if (!passwordEncoder.matches(password, tempuser.getUserpassword())) {//wrong pass
                mm.addAttribute("wrongCredentials", "wrong password");
                return "index";
            }
        }
        session.setAttribute("polluser", tempuser);
        // The candidate must be able to see how many votes has got.
        // The voter must be returned in index
        if (voteServiceInterface.hasVoted(tempuser)) {
            if (tempuser.getRoleid().getRoleid().equals(1)) {// Voter
                mm.addAttribute("alreadyvoted", "You have already voted");
                return "index";
            } else { // Candidate
                return "redirect:/myvotes";
            }
        }
        return "redirect:/voting";
    }

    @RequestMapping("/voting")
    public String votingPage(ModelMap mm, HttpSession session) {
        User tempuser = (User) session.getAttribute("polluser");
        List<User> allcandidates = userServiceInterface.getAllCandidates();
        if (tempuser.getRoleid().getRoleid().equals(2)) { // Candidate
            // Candidate must not see himeself on the dropdown list
            allcandidates.remove(tempuser);
        }
        mm.addAttribute("allcandidates", allcandidates);
        List<CandidateDto> candidates = new ArrayList();
        for (User u : allcandidates) {
            CandidateDto candidateDto = new CandidateDto();
            candidateDto.setId(u.getUserid());
            candidateDto.setFirstName(u.getUserfirstname());
            candidateDto.setLastName(u.getUserlastname());
            candidateDto.setTotalVotes(voteServiceInterface.getNumberOfVotes(u.getUserid()));
            candidates.add(candidateDto);
        }
        mm.addAttribute("candidates", candidates);
        VotingDto votingDto = new VotingDto();
        mm.addAttribute("votingdto", votingDto);
        return "votepage";
    }

    @PostMapping(value = "/aftervoting")
    public String afterVoting(@ModelAttribute("votingdto") VotingDto votingDto,
            HttpSession session,
            ModelMap mm) {
        Vote v = new Vote();
        v.setVoterid((User) session.getAttribute("polluser"));
        v.setCandidateid(userServiceInterface.getUser(votingDto.getUserId()));
        v.setRating(votingDto.getRating());
        v.setDatetime(new Date());
        voteServiceInterface.insertVote(v);
        mm.addAttribute("voteComplete", "The vote has been placed. Thank you " + v.getVoterid().getUserfirstname() + " " + v.getVoterid().getUserlastname() + ".");
        mm.addAttribute("userRole", v.getVoterid().getRoleid().getRoleid());
        return "thankyou";
    }

    @RequestMapping("/myvotes")
    public String myVotes(ModelMap mm, HttpSession session) {
        User tempuser = (User) session.getAttribute("polluser");
        List<Vote> candidateVotes = voteServiceInterface.getVotes(tempuser);
        mm.addAttribute("candidateVotes", candidateVotes);
        mm.addAttribute("candidatefirstname", tempuser.getUserfirstname());
        mm.addAttribute("candidatelastname", tempuser.getUserlastname());
        mm.addAttribute("totalvotes", candidateVotes.size());
        return "candidatepage";
    }

    @ResponseBody
    @GetMapping("checkusername/{name}")
    public String checkUserame(@PathVariable("name") String name) {
        // check if name exists
        User user = new User();
        user = userServiceInterface.getUserByUsername(name);
        if (user == null) {
            return "ok";
        }
        return "Username already exists";
    }

    //TODO fix the style of the users table. Also add a ban button and a votes view
    //TODO add user status (banned-active)
    //TODO fix registration page
}
