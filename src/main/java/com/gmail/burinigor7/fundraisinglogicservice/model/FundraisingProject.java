package com.gmail.burinigor7.fundraisinglogicservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundraisingProject {
    private Long fundraisingProjectId;
    private String title;
    private String description;
    private String story;
    private String moderationNotes;
    private User founder;
    private FundraisingProjectStatus status;
    private Integer days;
    private Date duration;
    private Float amountGoal;
    private String contractAddress;
    private Float currentAmount;
    private List<Investment> investments;
    private List<String> youtubeLinks;
    private List<String> tags;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public List<String> getYoutubeLinks() {
        return youtubeLinks;
    }

    public void setYoutubeLinks(List<String> youtubeLinks) {
        this.youtubeLinks = youtubeLinks;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public String getModerationNotes() {
        return moderationNotes;
    }

    public void setModerationNotes(String moderationNotes) {
        this.moderationNotes = moderationNotes;
    }

    public List<Investment> getInvestments() {
        return investments;
    }

    public void setInvestments(List<Investment> investments) {
        this.investments = investments;
    }

    public void addInvestment(Investment investment) {
        if(investments == null) {
            investments = new ArrayList<>();
            investments.add(investment);
        }
    }

    public Float getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Float currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public Float getAmountGoal() {
        return amountGoal;
    }

    public void setAmountGoal(Float amountGoal) {
        this.amountGoal = amountGoal;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Date getDuration() {
        return duration;
    }

    public void setDuration(Date duration) {
        this.duration = duration;
    }

    public FundraisingProjectStatus getStatus() {
        return status;
    }

    public void setStatus(FundraisingProjectStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getFundraisingProjectId() {
        return fundraisingProjectId;
    }

    public void setFundraisingProjectId(Long fundraisingProjectId) {
        this.fundraisingProjectId = fundraisingProjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getFounder() {
        return founder;
    }

    public void setFounder(User founder) {
        this.founder = founder;
    }


}
