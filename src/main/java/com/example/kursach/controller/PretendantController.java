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

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/pretendants")
@RequiredArgsConstructor
public class PretendantController {
    private final VotingService votingService;
    private final PretendantService pretendantService;

    private final UserService userService;


    @PostMapping
    public String createPretendant(@RequestParam Long votingId,
                                   @RequestParam String name,
                                   @RequestParam String description,
                                   Principal principal) {
        boolean isAuthor = userService.isVotingsAuthor(votingId, principal.getName());


        if (isAuthor) {
            Pretendant pretendant = new Pretendant();
            pretendant.setName(name);
            pretendant.setDescription(description);
            pretendant.setVoting(votingService.findById(votingId));

            pretendantService.save(pretendant);

            return "redirect:/votings/" + votingId;
        } else return "redirect:/error";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id,
                             @RequestParam Long votingId,
                             HttpServletRequest request,
                             Principal principal) {
        boolean isAuthor = userService.isVotingsAuthor(votingId, principal.getName());

        if (isAuthor) {
            pretendantService.deleteById(id);
            return "redirect:" + request.getHeader("Referer");
        }else return "redirect:/error";

    }
}
