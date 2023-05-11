package com.example.kursach.controller;

import com.example.kursach.controller.payload.mapper.CreatedPretendantMapper;
import com.example.kursach.controller.payload.mapper.CreatedVotingMapper;
import com.example.kursach.model.Pretendant;
import com.example.kursach.model.Voting;
import com.example.kursach.service.PretendantService;
import com.example.kursach.service.UserService;
import com.example.kursach.service.VotingService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/votings")
@RequiredArgsConstructor
public class VotingController {

    private final VotingService votingService;
    private final CreatedVotingMapper createdVotingMapper;
    private final CreatedPretendantMapper createdPretendantMapper;

    private final UserService userService;

    @GetMapping
    public String findAll(Model model){
        model.addAttribute("votings",createdVotingMapper.doPayload(votingService.findAll()));
        return "index";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model){
        Voting voting = votingService.findById(id);
        model.addAttribute("voting",createdVotingMapper.doPayload(voting));
        model.addAttribute("pretendants", createdPretendantMapper.doPayload(voting.getPretendants()));
        return "voting";
    }

    @PostMapping
    public String save(@RequestParam String name,
                       @RequestParam String description,
                       Principal principal){


        Voting voting = new Voting();
        voting.setName(name);
        voting.setDescription(description);
        voting.setUser(userService.findByUsername(principal.getName()));

        votingService.save(voting);
        return "redirect:/votings";
    }



    @PostMapping ("/update/{id}")
    public String update(@PathVariable Long id,
                             @RequestParam String name,
                             @RequestParam String description,
                         Principal principal){
        boolean isAuthor = userService.isVotingsAuthor(id, principal.getName());
        if(isAuthor){
            Voting voting = new Voting();
            voting.setName(name);
            voting.setDescription(description);
            voting.setId(id);
            voting.setPretendants(votingService.findById(id).getPretendants());
            votingService.save(voting);

            return "redirect:/votings/{id}";
        }else return "redirect:/error";


    }

    @PostMapping ("/delete/{id}")
    public String deleteById(@PathVariable Long id, Principal principal){
        boolean isAuthor = userService.isVotingsAuthor(id, principal.getName());
        if(isAuthor){
            votingService.deleteById(id);
            return "redirect:/votings";
        }else return "redirect:/error";

    }
}
