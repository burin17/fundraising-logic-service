package com.gmail.burinigor7.fundraisinglogicservice;

import com.gmail.burinigor7.fundraisinglogicservice.wrapper.Crowdfunding;
import com.gmail.burinigor7.fundraisinglogicservice.wrapper.Project;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.Request;
import org.web3j.protocol.core.Response;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.*;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.FastRawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@ConfigurationProperties(prefix = "wallets")
public class FundraisingLogicServiceApplication {
    @Value("${infure.node.endpoint}")
    private String infureNodeEndpoint;

    public static void main(String[] args) {
        SpringApplication.run(FundraisingLogicServiceApplication.class, args);
    }

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(infureNodeEndpoint));
    }


}