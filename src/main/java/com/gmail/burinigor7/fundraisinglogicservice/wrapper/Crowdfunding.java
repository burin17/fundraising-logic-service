package com.gmail.burinigor7.fundraisinglogicservice.wrapper;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Crowdfunding extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b50611097806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c806385b6e28e1461003b578063a24a2d1614610059575b600080fd5b61004361006e565b604051610050919061022f565b60405180910390f35b61006c6100673660046102c5565b6100d0565b005b606060008054806020026020016040519081016040528092919081815260200182805480156100c657602002820191906000526020600020905b81546001600160a01b031681526001909101906020018083116100a8575b5050505050905090565b60006100e96100e284620151806101c8565b4290610206565b905060003388888888868860405161010090610222565b610110979695949392919061036c565b604051809103906000f08015801561012c573d6000803e3d6000fd5b50600080546001810182559080527f290decd9548b62a8d60345a988386fc84ba6bc95484008f6362f93160ef3e5630180546001600160a01b0319166001600160a01b0383161790556040519091507f6218c120ad6d836da0bfe4d4c44c8375356514fce6ae39ecdcd483fad6056e66906101b690839033908c908c908c908c908a908c906103bb565b60405180910390a15050505050505050565b6000826000036101da57506000610200565b60006101e68385610429565b9050826101f38583610448565b146101fd57600080fd5b90505b92915050565b600080610213838561046a565b9050838110156101fd57600080fd5b610bdf8061048383390190565b6020808252825182820181905260009190848201906040850190845b818110156102705783516001600160a01b03168352928401929184019160010161024b565b50909695505050505050565b60008083601f84011261028e57600080fd5b50813567ffffffffffffffff8111156102a657600080fd5b6020830191508360208285010111156102be57600080fd5b9250929050565b600080600080600080608087890312156102de57600080fd5b863567ffffffffffffffff808211156102f657600080fd5b6103028a838b0161027c565b9098509650602089013591508082111561031b57600080fd5b5061032889828a0161027c565b979a9699509760408101359660609091013595509350505050565b81835281816020850137506000828201602090810191909152601f909101601f19169091010190565b6001600160a01b038816815260a060208201819052600090610391908301888a610343565b82810360408401526103a4818789610343565b606084019590955250506080015295945050505050565b6001600160a01b0389811682528816602082015260c0604082018190526000906103e8908301888a610343565b82810360608401526103fb818789610343565b6080840195909552505060a001529695505050505050565b634e487b7160e01b600052601160045260246000fd5b600081600019048311821515161561044357610443610413565b500290565b60008261046557634e487b7160e01b600052601260045260246000fd5b500490565b6000821982111561047d5761047d610413565b50019056fe60806040526007805460ff191690553480156200001b57600080fd5b5060405162000bdf38038062000bdf8339810160408190526200003e916200020c565b600080546001600160a01b0319166001600160a01b03871617905583516200006e90600590602087019062000099565b5082516200008490600690602086019062000099565b506001556004555050600060035550620002e5565b828054620000a790620002a9565b90600052602060002090601f016020900481019282620000cb576000855562000116565b82601f10620000e657805160ff191683800117855562000116565b8280016001018555821562000116579182015b8281111562000116578251825591602001919060010190620000f9565b506200012492915062000128565b5090565b5b8082111562000124576000815560010162000129565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126200016757600080fd5b81516001600160401b03808211156200018457620001846200013f565b604051601f8301601f19908116603f01168101908282118183101715620001af57620001af6200013f565b81604052838152602092508683858801011115620001cc57600080fd5b600091505b83821015620001f05785820183015181830184015290820190620001d1565b83821115620002025760008385830101525b9695505050505050565b600080600080600060a086880312156200022557600080fd5b85516001600160a01b03811681146200023d57600080fd5b60208701519095506001600160401b03808211156200025b57600080fd5b6200026989838a0162000155565b955060408801519150808211156200028057600080fd5b506200028f8882890162000155565b606088015160809098015196999598509695949350505050565b600181811c90821680620002be57607f821691505b602082108103620002df57634e487b7160e01b600052602260045260246000fd5b50919050565b6108ea80620002f56000396000f3fe6080604052600436106100c25760003560e01c80637284e4161161007f578063c19d93fb11610059578063c19d93fb146101f4578063ce845d1d1461021b578063d7bb99ba14610231578063fbbf93a01461023957600080fd5b80637284e416146101a357806386f32586146101b8578063b2d5ae44146101cf57600080fd5b806302d05d3f146100c75780630785001c1461010457806337f944cc1461012857806342e94c901461013e5780634a79d50c1461016b5780634c4cea5a1461018d575b600080fd5b3480156100d357600080fd5b506000546100e7906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b34801561011057600080fd5b5061011a60015481565b6040519081526020016100fb565b34801561013457600080fd5b5061011a60045481565b34801561014a57600080fd5b5061011a610159366004610705565b60086020526000908152604090205481565b34801561017757600080fd5b50610180610261565b6040516100fb919061077b565b34801561019957600080fd5b5061011a60025481565b3480156101af57600080fd5b506101806102ef565b3480156101c457600080fd5b506101cd6102fc565b005b3480156101db57600080fd5b506101e4610340565b60405190151581526020016100fb565b34801561020057600080fd5b5060075461020e9060ff1681565b6040516100fb91906107c6565b34801561022757600080fd5b5061011a60035481565b6101cd6103e5565b34801561024557600080fd5b5061024e6104a6565b6040516100fb97969594939291906107d4565b6005805461026e90610835565b80601f016020809104026020016040519081016040528092919081815260200182805461029a90610835565b80156102e75780601f106102bc576101008083540402835291602001916102e7565b820191906000526020600020905b8154815290600101906020018083116102ca57829003601f168201915b505050505081565b6006805461026e90610835565b60015460035410610322576007805460ff1916600217905561031c6105ff565b5061033a565b60045442111561033a576007805460ff191660011790555b42600255565b600060018060075460ff16600281111561035c5761035c61078e565b1461036657600080fd5b3360009081526008602052604090205461037f57600080fd5b33600081815260086020526040808220805490839055905190929183156108fc02918491818181858888f193505050506103cc573360009081526008602052604081209190915591505090565b6003546103d990826106bd565b60035560019250505090565b60008060075460ff1660028111156103ff576103ff61078e565b1461040957600080fd5b6000546001600160a01b0316330361042057600080fd5b3360009081526008602052604090205461043a90346106e2565b3360009081526008602052604090205560035461045790346106e2565b60038190556040805133815234602082015280820192909252517f5cdc4ab8d637538ead6cc1904d4160343656c8c82bd266635cfd31ac008fffe09181900360600190a16104a36102fc565b50565b60008054600580546001600160a01b039092169260609283928291829182916104ce90610835565b80601f01602080910402602001604051908101604052809291908181526020018280546104fa90610835565b80156105475780601f1061051c57610100808354040283529160200191610547565b820191906000526020600020905b81548152906001019060200180831161052a57829003601f168201915b505050505095506006805461055b90610835565b80601f016020809104026020016040519081016040528092919081815260200182805461058790610835565b80156105d45780601f106105a9576101008083540402835291602001916105d4565b820191906000526020600020905b8154815290600101906020018083116105b757829003601f168201915b50506004546007546003546001549d9e9c9d969c929b5060ff90911699509750939550929350505050565b600060028060075460ff16600281111561061b5761061b61078e565b1461062557600080fd5b60038054600091829055815460405191926001600160a01b039091169183156108fc0291849190818181858888f19350505050156106a6576000546040516001600160a01b0390911681527f2f256415efc8561af8db667cb242964b19be7380f379ccdafaa0e54a6f6b70699060200160405180910390a160019250505090565b60035550506007805460ff19166002179055600090565b6000828211156106cc57600080fd5b60006106d88385610885565b9150505b92915050565b6000806106ef838561089c565b9050838110156106fe57600080fd5b9392505050565b60006020828403121561071757600080fd5b81356001600160a01b03811681146106fe57600080fd5b6000815180845260005b8181101561075457602081850181015186830182015201610738565b81811115610766576000602083870101525b50601f01601f19169290920160200192915050565b6020815260006106fe602083018461072e565b634e487b7160e01b600052602160045260246000fd5b600381106107c257634e487b7160e01b600052602160045260246000fd5b9052565b602081016106dc82846107a4565b6001600160a01b038816815260e0602082018190526000906107f89083018961072e565b828103604084015261080a818961072e565b91505085606083015261082060808301866107a4565b60a082019390935260c0015295945050505050565b600181811c9082168061084957607f821691505b60208210810361086957634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b6000828210156108975761089761086f565b500390565b600082198211156108af576108af61086f565b50019056fea2646970667358221220910f90445e1da1704241265f537485b4571e7f36a0e054b1e5feea1312f9fb5064736f6c634300080d0033a26469706673582212207de2bffdc9ecb93608dce8a4b1c8b638fce4908176bb6fb83136587f31df19ab64736f6c634300080d0033";

    public static final String FUNC_RETURNALLPROJECTS = "returnAllProjects";

    public static final String FUNC_STARTPROJECT = "startProject";

    public static final Event PROJECTSTARTED_EVENT = new Event("ProjectStarted",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Crowdfunding(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Crowdfunding(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Crowdfunding(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Crowdfunding(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<ProjectStartedEventResponse> getProjectStartedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(PROJECTSTARTED_EVENT, transactionReceipt);
        ArrayList<ProjectStartedEventResponse> responses = new ArrayList<ProjectStartedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ProjectStartedEventResponse typedResponse = new ProjectStartedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.contractAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.projectStarter = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.projectTitle = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.projectDesc = (String) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.deadline = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.goalAmount = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<ProjectStartedEventResponse> projectStartedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, ProjectStartedEventResponse>() {
            @Override
            public ProjectStartedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(PROJECTSTARTED_EVENT, log);
                ProjectStartedEventResponse typedResponse = new ProjectStartedEventResponse();
                typedResponse.log = log;
                typedResponse.contractAddress = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.projectStarter = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.projectTitle = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.projectDesc = (String) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.deadline = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.goalAmount = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<ProjectStartedEventResponse> projectStartedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(PROJECTSTARTED_EVENT));
        return projectStartedEventFlowable(filter);
    }

    public RemoteFunctionCall<List> returnAllProjects() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RETURNALLPROJECTS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteFunctionCall<List>(function,
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> startProject(String title, String description, BigInteger durationInDays, BigInteger amountToRaise) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_STARTPROJECT,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(title),
                        new org.web3j.abi.datatypes.Utf8String(description),
                        new org.web3j.abi.datatypes.generated.Uint256(durationInDays),
                        new org.web3j.abi.datatypes.generated.Uint256(amountToRaise)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Crowdfunding load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Crowdfunding(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Crowdfunding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Crowdfunding(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Crowdfunding load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Crowdfunding(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Crowdfunding load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Crowdfunding(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Crowdfunding.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Crowdfunding.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Crowdfunding.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Crowdfunding> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Crowdfunding.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class ProjectStartedEventResponse extends BaseEventResponse {
        public String contractAddress;

        public String projectStarter;

        public String projectTitle;

        public String projectDesc;

        public BigInteger deadline;

        public BigInteger goalAmount;
    }
}
