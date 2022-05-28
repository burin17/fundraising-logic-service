package com.gmail.burinigor7.fundraisinglogicservice.model;

public class Investment {
    private Long id;

    private User investor;

    private FundraisingProject fundraisingProject;

    private Float ethAmount;

    private String fromEthereumAddress;

    public String getFromEthereumAddress() {
        return fromEthereumAddress;
    }

    public void setFromEthereumAddress(String fromEthereumAddress) {
        this.fromEthereumAddress = fromEthereumAddress;
    }

    public Float getEthAmount() {
        return ethAmount;
    }

    public void setEthAmount(Float ethAmount) {
        this.ethAmount = ethAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getInvestor() {
        return investor;
    }

    public void setInvestor(User investor) {
        this.investor = investor;
    }

    public FundraisingProject getFundraisingProject() {
        return fundraisingProject;
    }

    public void setFundraisingProject(FundraisingProject fundraisingProject) {
        this.fundraisingProject = fundraisingProject;
    }
}
