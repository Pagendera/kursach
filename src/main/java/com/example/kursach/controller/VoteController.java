package com.example.kursach.controller;

import com.example.kursach.model.Vote;
import com.example.kursach.service.PretendantService;
import com.example.kursach.service.UserService;
import com.example.kursach.service.VoteService;
import com.example.kursach.service.VotingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/votes")
@RequiredArgsConstructor
public class VoteController {
    private final VoteService voteService;
    private final PretendantService pretendantService;
    private final UserService userService;
    private final VotingService votingService;

    @PostMapping
    public String saveVote(@RequestParam Long pretendantId,
                           @RequestParam Long votingId,
                           HttpServletRequest request,
                           Principal principal){
        Vote vote = new Vote();
        vote.setPretendant(pretendantService.findById(pretendantId));
        vote.setUser(userService.findByUsername(principal.getName()));
        vote.setVoting(votingService.findById(votingId));

        voteService.save(vote);

        return "redirect:" + request.getHeader("Referer");
    }


}
