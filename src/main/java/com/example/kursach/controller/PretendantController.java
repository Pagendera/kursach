package com.example.kursach.controller;

import com.example.kursach.model.Pretendant;
import com.example.kursach.repository.VotingRepository;
import com.example.kursach.service.PretendantService;
import com.example.kursach.service.UserService;
import com.example.kursach.service.VotingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/pretendants")
@RequiredArgsConstructor
public class PretendantController {
    private final VotingService votingService;
    private final PretendantService pretendantService;


    @PostMapping
    public String createPretendant(@RequestParam Long votingId,
                                   @ModelAttribute Pretendant pretendant) {


        pretendant.setVoting(votingService.findById(votingId));

        pretendantService.save(pretendant);

        return "redirect:/votings/" + votingId;
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id,
                             HttpServletRequest request) {

        pretendantService.deleteById(id);
        return "redirect:" + request.getHeader("Referer");


    }
}
