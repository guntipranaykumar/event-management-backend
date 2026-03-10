package com.event.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.event.demo.entity.Event;
import com.event.demo.entity.Sponsor;
import com.event.demo.service.SponsorJpaService;

@CrossOrigin(origins = "https://d3ka0na2j1p42k.cloudfront.net")
@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {

    private final SponsorJpaService sponsorService;

    public SponsorController(SponsorJpaService sponsorService) {
        this.sponsorService = sponsorService;
    }

    // GET /api/sponsors
    @GetMapping
    public List<Sponsor> getAllSponsors() {
        return sponsorService.getAllSponsor();
    }

    // GET /api/sponsors/{sponsorId}
    @GetMapping("/{sponsorId}")
    public Sponsor getSponsorById(@PathVariable int sponsorId) {
        return sponsorService.getSponsorById(sponsorId);
    }

    // POST /api/sponsors
    @PostMapping
    public Sponsor createSponsor(@RequestBody Sponsor sponsor) {
        return sponsorService.createSponsor(sponsor);
    }

    // PUT /api/sponsors/{sponsorId}
    @PutMapping("/{sponsorId}")
    public Sponsor updateSponsor(@PathVariable int sponsorId,
                                 @RequestBody Sponsor sponsor) {
        return sponsorService.updateSponsor(sponsorId, sponsor);
    }

    // DELETE /api/sponsors/{sponsorId}
    @DeleteMapping("/{sponsorId}")
    public void deleteSponsor(@PathVariable int sponsorId) {
        sponsorService.deleteSponsor(sponsorId);
    }

    // GET /api/sponsors/{sponsorId}/events
    @GetMapping("/{sponsorId}/events")
    public List<Event> getEventsBySponsor(@PathVariable int sponsorId) {
        return sponsorService.getEventsBySponsor(sponsorId);
    }
}