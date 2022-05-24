package com.gmail.burinigor7.fundraisinglogicservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayoutRequest {
    private Long id;
    private Float ethAmount;
    private String intention;
    private String reporting;
    private Integer days;
    private Date achieveBy;
    private Long fundraisingProjectId;
    private FundraisingProject fundraisingProject;
    private String requestIdx;
    private List<User> approvers;
    private Integer requiredAmountOfApproves;
    private Long countOfApproves;
    private String reportNotes;

    public String getReportNotes() {
        return reportNotes;
    }

    public void setReportNotes(String reportNotes) {
        this.reportNotes = reportNotes;
    }

    public Long getCountOfApproves() {
        return countOfApproves;
    }

    public void setCountOfApproves(Long countOfApproves) {
        this.countOfApproves = countOfApproves;
    }

    public Integer getRequiredAmountOfApproves() {
        return requiredAmountOfApproves;
    }

    public void setRequiredAmountOfApproves(Integer requiredAmountOfApproves) {
        this.requiredAmountOfApproves = requiredAmountOfApproves;
    }

    public List<User> getApprovers() {
        return approvers;
    }

    public void addApprover(User approver) {
        if (approvers == null) {
            approvers = new ArrayList<>();
        }
        approvers.add(approver);
    }

    public void setApprovers(List<User> approvers) {
        this.approvers = approvers;
    }

    public String getRequestIdx() {
        return requestIdx;
    }

    public void setRequestIdx(String requestIdx) {
        this.requestIdx = requestIdx;
    }

    public FundraisingProject getFundraisingProject() {
        return fundraisingProject;
    }

    public void setFundraisingProject(FundraisingProject fundraisingProject) {
        this.fundraisingProject = fundraisingProject;
    }

    public Long getFundraisingProjectId() {
        return fundraisingProjectId;
    }

    public void setFundraisingProjectId(Long fundraisingProjectId) {
        this.fundraisingProjectId = fundraisingProjectId;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getEthAmount() {
        return ethAmount;
    }

    public void setEthAmount(Float ethAmount) {
        this.ethAmount = ethAmount;
    }

    public String getIntention() {
        return intention;
    }

    public void setIntention(String intention) {
        this.intention = intention;
    }

    public String getReporting() {
        return reporting;
    }

    public void setReporting(String reporting) {
        this.reporting = reporting;
    }

    public Date getAchieveBy() {
        return achieveBy;
    }

    public void setAchieveBy(Date achieveBy) {
        this.achieveBy = achieveBy;
    }
}
