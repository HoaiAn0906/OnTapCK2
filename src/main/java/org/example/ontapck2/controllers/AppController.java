package org.example.ontapck2.controllers;

import lombok.AllArgsConstructor;
import org.example.ontapck2.models.Candidate;
import org.example.ontapck2.models.Experience;
import org.example.ontapck2.service.CandidateService;
import org.example.ontapck2.service.ExperienceService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class AppController {
    private final CandidateService candidateService;
    private final ExperienceService experienceService;

    @GetMapping("/candidate")
    public String candidate(Model model) {
        List<Candidate> candidates = candidateService.getAll();

        model.addAttribute("candidates", candidates);
        return "candidate";
    }

    @GetMapping("candidate/{id}/details")
    public String candidateDetails(
            @PathVariable(name = "id") Long canId,
            Model model
    ) {
        List<Experience> experiences = experienceService.getExperienceByCandidateId(canId);
        System.out.println("Test" + experiences);

        model.addAttribute("experiences", experiences);
        return "can_details";
    }

    @GetMapping("/report1")
    public String report1(
            Model model,
            @RequestParam(name = "company", defaultValue = "") String company
    ) {
        List<Candidate> candidates;
        System.out.println("company: " + company);
        if(company.isEmpty()) {
            candidates = candidateService.getAll();
        } else {
            candidates = candidateService.getCandidateByCompany(company);
        }

        model.addAttribute("candidates", candidates);
        return "report1";
    }

    @GetMapping("/report2")
    public String report2() {
        return "report2";
    }
}
