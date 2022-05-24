package com.gmail.burinigor7.fundraisinglogicservice.service;

import com.gmail.burinigor7.fundraisinglogicservice.internallcalls.CrudServiceApiClient;
import com.gmail.burinigor7.fundraisinglogicservice.model.FundraisingProject;
import com.gmail.burinigor7.fundraisinglogicservice.model.FundraisingProjectStatus;
import com.gmail.burinigor7.fundraisinglogicservice.model.Investment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FundraisingProjectService {
    private final CrudServiceApiClient crudServiceApiClient;

    @Autowired
    public FundraisingProjectService(CrudServiceApiClient crudServiceApiClient) {
        this.crudServiceApiClient = crudServiceApiClient;
    }

    public FundraisingProject fundraisingProject(Long fundraisingProjectId) {
        return crudServiceApiClient.getFundraisingProjectById(fundraisingProjectId);
    }

    public List<FundraisingProject> fundraisingProjectsByTitlePiece(String pieceOfTitle) {
        return crudServiceApiClient.getFundraisingProjectByTitlePiece(pieceOfTitle);
    }

    public FundraisingProject createFundraisingProject(FundraisingProject fundraisingProject) {
        return crudServiceApiClient.createFundraisingProject(fundraisingProject);
    }

    public Map<String, String> validate(FundraisingProject fundraisingProject) {
        return crudServiceApiClient.validate(fundraisingProject);
    }

    public List<FundraisingProject> fundraisingProjectsByUsername(String username) {
        return crudServiceApiClient.fundraisingProjectsByUsername(username);
    }

    public List<FundraisingProject> all() {
        return crudServiceApiClient.allFundraisingProjects();
    }

    public List<FundraisingProject> getFundraisingProjectByStatus() {
        return crudServiceApiClient.getFundraisingProjectVisibleForUser();
    }

    public FundraisingProject startCompany(Long id, String contractAddress) {
        FundraisingProject fundraisingProject = crudServiceApiClient.getFundraisingProjectById(id);
        if (fundraisingProject.getStatus() == FundraisingProjectStatus.APPROVED) {
            LocalDate until = LocalDate.now().plusDays(fundraisingProject.getDays());
            Date duration = Date.from(until.atStartOfDay()
                    .atZone(ZoneId.systemDefault())
                    .toInstant());
            fundraisingProject.setDuration(duration);
            fundraisingProject.setStatus(FundraisingProjectStatus.IN_PROGRESS);
            fundraisingProject.setContractAddress(contractAddress);
            crudServiceApiClient.updateFundraisingProject(fundraisingProject);
        }
        return fundraisingProject;
    }

    public FundraisingProject invest(Long id, Float currentAmount, Float ethAmount, Long investor) {
        FundraisingProject fundraisingProject = crudServiceApiClient.getFundraisingProjectById(id);
        fundraisingProject.setCurrentAmount(currentAmount);
        Investment investment = new Investment();
        investment.setInvestor(crudServiceApiClient.user(investor));
        investment.setFundraisingProject(fundraisingProject);
        investment.setEthAmount(ethAmount);
        crudServiceApiClient.createInvestment(investment);
        if(currentAmount >= fundraisingProject.getAmountGoal()) {
            fundraisingProject.setStatus(FundraisingProjectStatus.FINANCED);
        }
        crudServiceApiClient.updateFundraisingProject(fundraisingProject);
        return fundraisingProject;
    }

    public FundraisingProject updateCurrentBalance(Long id, Float currentAmount) {
        FundraisingProject fundraisingProject = crudServiceApiClient.getFundraisingProjectById(id);
        fundraisingProject.setCurrentAmount(currentAmount);
        crudServiceApiClient.updateFundraisingProject(fundraisingProject);
        return fundraisingProject;
    }

    public FundraisingProject changeFundraisingProjectStatusToExpired(Long fpId) {
        FundraisingProject fundraisingProject = crudServiceApiClient.getFundraisingProjectById(fpId);
        fundraisingProject.setStatus(FundraisingProjectStatus.EXPIRED);
        return crudServiceApiClient.updateFundraisingProject(fundraisingProject);
    }

    public List<FundraisingProject> getInvestedFundraisingProjects(String username) {
        return crudServiceApiClient.invested(crudServiceApiClient.getUserByUsername(username).getId());
    }

    public List<String> getTags(Long projectId) {
        return crudServiceApiClient.getTags(projectId);
    }

    public List<FundraisingProject> search(String titlePiece, String[] tags) {
        return crudServiceApiClient.search(titlePiece, tags);
    }

    public List<FundraisingProject> search(String[] tags) {
        return crudServiceApiClient.search(tags);
    }


}
