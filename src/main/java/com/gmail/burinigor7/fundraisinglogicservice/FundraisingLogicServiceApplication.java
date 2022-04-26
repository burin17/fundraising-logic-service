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

class A {

    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/dc21916a7b7640a6b89e544fe348e5fd"));
//        String walletPassword = "secr3t";
//        String walletDirectory = "/home/burin17/proj/diploma/concept-funder/fundraising-logic-service/wallets";
//        String seed = UUID.randomUUID().toString();
//
//        Credentials credentials = Credentials.create("0xbb105b4dba06537b8a2aad94a173908f86bbc7bdcc9539f7cc458db87a1f552e");
//        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount("0x89104d6def529799611cac7b1571a199b36d4032",
//                DefaultBlockParameterName.LATEST).send();
//        EthGetBalance balance = web3j.ethGetBalance("0x89104d6def529799611cac7b1571a199b36d4032", DefaultBlockParameterName.LATEST).send();
//        System.out.println(balance.getBalance());
        createProj2_0(web3j);
    }

    private static void createAcc(String seed) throws Exception {
            ECKeyPair ecKeyPair = Keys.createEcKeyPair();
            BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();

            String sPrivatekeyInHex = privateKeyInDec.toString(16);

            WalletFile aWallet = Wallet.createLight(seed, ecKeyPair);
            String sAddress = aWallet.getAddress();

            System.out.println("0x" + sAddress);
            System.out.println(sPrivatekeyInHex);
    }

//    0x89104d6def529799611cac7b1571a199b36d4032
//    bb105b4dba06537b8a2aad94a173908f86bbc7bdcc9539f7cc458db87a1f552e

    public static void createProj(Web3j web3j) throws Exception {
        System.out.println(web3j.ethGasPrice().send().getGasPrice());
        Credentials creds = Credentials.create("0xbb105b4dba06537b8a2aad94a173908f86bbc7bdcc9539f7cc458db87a1f552e");
        Crowdfunding crowdfunding = Crowdfunding.load("0x1De306aEc41307734ffeca5239b6e54Cc45a4548", web3j, creds, new StaticGasProvider(new BigInteger("300000000000"), new BigInteger("3000000")));
        //        EthGetBalance ethGetBalance = web3j
//                .ethGetBalance("0xAccountAddress", DefaultBlockParameterName.LATEST)
//                .sendAsync()
//                .get();
        RemoteFunctionCall<TransactionReceipt> remoteFunctionCall = crowdfunding.startProject("Hello from web3j lib", "Hello!", BigInteger.ONE, BigInteger.ONE);
        System.out.println("remoteFunctionCall.send()");
        remoteFunctionCall.send();
        System.out.println("DONE");

//        crowdfunding.returnAllProjects().send();
    }

    public static void createProj2_0(Web3j web3j) throws Exception {
        Credentials creds = Credentials.create("0xbb105b4dba06537b8a2aad94a173908f86bbc7bdcc9539f7cc458db87a1f552e");
        Function function = new Function("startProject",
                Arrays.<Type>asList(
                        new org.web3j.abi.datatypes.Utf8String("title"),
                        new org.web3j.abi.datatypes.Utf8String("description"),
                        new org.web3j.abi.datatypes.generated.Uint256(100000000L),
                        new org.web3j.abi.datatypes.generated.Uint256(100000000L)),
                Collections.emptyList());
        String encodedFunc = FunctionEncoder.encode(function);
        TransactionManager txManager = new FastRawTransactionManager(web3j, creds);
        String tHash = txManager.sendTransaction(new BigInteger("300000000000"), new BigInteger("1000000"), "0x1De306aEc41307734ffeca5239b6e54Cc45a4548",
                encodedFunc, BigInteger.ZERO).getTransactionHash();
        System.out.println(tHash);
    }
}

class B {
    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://mainnet.infura.io/v3/dc21916a7b7640a6b89e544fe348e5fd"));
        Request<?, EthGetTransactionReceipt> ethGetTransactionReceiptRequest = web3j.ethGetTransactionReceipt("0x6ded1cbb5a0fdd2088711f4c2c61d45fa78fbc77c0e5a945e2dd6a9bddce9b57");
        EthGetTransactionReceipt receipt = ethGetTransactionReceiptRequest.send();
    }
}