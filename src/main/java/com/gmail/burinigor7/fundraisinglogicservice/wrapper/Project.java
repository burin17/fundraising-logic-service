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
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple7;
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
public class Project extends Contract {
    public static final String BINARY = "60806040526007805460ff191690553480156200001b57600080fd5b5060405162000bdf38038062000bdf8339810160408190526200003e916200020c565b600080546001600160a01b0319166001600160a01b03871617905583516200006e90600590602087019062000099565b5082516200008490600690602086019062000099565b506001556004555050600060035550620002e5565b828054620000a790620002a9565b90600052602060002090601f016020900481019282620000cb576000855562000116565b82601f10620000e657805160ff191683800117855562000116565b8280016001018555821562000116579182015b8281111562000116578251825591602001919060010190620000f9565b506200012492915062000128565b5090565b5b8082111562000124576000815560010162000129565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126200016757600080fd5b81516001600160401b03808211156200018457620001846200013f565b604051601f8301601f19908116603f01168101908282118183101715620001af57620001af6200013f565b81604052838152602092508683858801011115620001cc57600080fd5b600091505b83821015620001f05785820183015181830184015290820190620001d1565b83821115620002025760008385830101525b9695505050505050565b600080600080600060a086880312156200022557600080fd5b85516001600160a01b03811681146200023d57600080fd5b60208701519095506001600160401b03808211156200025b57600080fd5b6200026989838a0162000155565b955060408801519150808211156200028057600080fd5b506200028f8882890162000155565b606088015160809098015196999598509695949350505050565b600181811c90821680620002be57607f821691505b602082108103620002df57634e487b7160e01b600052602260045260246000fd5b50919050565b6108ea80620002f56000396000f3fe6080604052600436106100c25760003560e01c80637284e4161161007f578063c19d93fb11610059578063c19d93fb146101f4578063ce845d1d1461021b578063d7bb99ba14610231578063fbbf93a01461023957600080fd5b80637284e416146101a357806386f32586146101b8578063b2d5ae44146101cf57600080fd5b806302d05d3f146100c75780630785001c1461010457806337f944cc1461012857806342e94c901461013e5780634a79d50c1461016b5780634c4cea5a1461018d575b600080fd5b3480156100d357600080fd5b506000546100e7906001600160a01b031681565b6040516001600160a01b0390911681526020015b60405180910390f35b34801561011057600080fd5b5061011a60015481565b6040519081526020016100fb565b34801561013457600080fd5b5061011a60045481565b34801561014a57600080fd5b5061011a610159366004610705565b60086020526000908152604090205481565b34801561017757600080fd5b50610180610261565b6040516100fb919061077b565b34801561019957600080fd5b5061011a60025481565b3480156101af57600080fd5b506101806102ef565b3480156101c457600080fd5b506101cd6102fc565b005b3480156101db57600080fd5b506101e4610340565b60405190151581526020016100fb565b34801561020057600080fd5b5060075461020e9060ff1681565b6040516100fb91906107c6565b34801561022757600080fd5b5061011a60035481565b6101cd6103e5565b34801561024557600080fd5b5061024e6104a6565b6040516100fb97969594939291906107d4565b6005805461026e90610835565b80601f016020809104026020016040519081016040528092919081815260200182805461029a90610835565b80156102e75780601f106102bc576101008083540402835291602001916102e7565b820191906000526020600020905b8154815290600101906020018083116102ca57829003601f168201915b505050505081565b6006805461026e90610835565b60015460035410610322576007805460ff1916600217905561031c6105ff565b5061033a565b60045442111561033a576007805460ff191660011790555b42600255565b600060018060075460ff16600281111561035c5761035c61078e565b1461036657600080fd5b3360009081526008602052604090205461037f57600080fd5b33600081815260086020526040808220805490839055905190929183156108fc02918491818181858888f193505050506103cc573360009081526008602052604081209190915591505090565b6003546103d990826106bd565b60035560019250505090565b60008060075460ff1660028111156103ff576103ff61078e565b1461040957600080fd5b6000546001600160a01b0316330361042057600080fd5b3360009081526008602052604090205461043a90346106e2565b3360009081526008602052604090205560035461045790346106e2565b60038190556040805133815234602082015280820192909252517f5cdc4ab8d637538ead6cc1904d4160343656c8c82bd266635cfd31ac008fffe09181900360600190a16104a36102fc565b50565b60008054600580546001600160a01b039092169260609283928291829182916104ce90610835565b80601f01602080910402602001604051908101604052809291908181526020018280546104fa90610835565b80156105475780601f1061051c57610100808354040283529160200191610547565b820191906000526020600020905b81548152906001019060200180831161052a57829003601f168201915b505050505095506006805461055b90610835565b80601f016020809104026020016040519081016040528092919081815260200182805461058790610835565b80156105d45780601f106105a9576101008083540402835291602001916105d4565b820191906000526020600020905b8154815290600101906020018083116105b757829003601f168201915b50506004546007546003546001549d9e9c9d969c929b5060ff90911699509750939550929350505050565b600060028060075460ff16600281111561061b5761061b61078e565b1461062557600080fd5b60038054600091829055815460405191926001600160a01b039091169183156108fc0291849190818181858888f19350505050156106a6576000546040516001600160a01b0390911681527f2f256415efc8561af8db667cb242964b19be7380f379ccdafaa0e54a6f6b70699060200160405180910390a160019250505090565b60035550506007805460ff19166002179055600090565b6000828211156106cc57600080fd5b60006106d88385610885565b9150505b92915050565b6000806106ef838561089c565b9050838110156106fe57600080fd5b9392505050565b60006020828403121561071757600080fd5b81356001600160a01b03811681146106fe57600080fd5b6000815180845260005b8181101561075457602081850181015186830182015201610738565b81811115610766576000602083870101525b50601f01601f19169290920160200192915050565b6020815260006106fe602083018461072e565b634e487b7160e01b600052602160045260246000fd5b600381106107c257634e487b7160e01b600052602160045260246000fd5b9052565b602081016106dc82846107a4565b6001600160a01b038816815260e0602082018190526000906107f89083018961072e565b828103604084015261080a818961072e565b91505085606083015261082060808301866107a4565b60a082019390935260c0015295945050505050565b600181811c9082168061084957607f821691505b60208210810361086957634e487b7160e01b600052602260045260246000fd5b50919050565b634e487b7160e01b600052601160045260246000fd5b6000828210156108975761089761086f565b500390565b600082198211156108af576108af61086f565b50019056fea2646970667358221220910f90445e1da1704241265f537485b4571e7f36a0e054b1e5feea1312f9fb5064736f6c634300080d0033";

    public static final String FUNC_AMOUNTGOAL = "amountGoal";

    public static final String FUNC_CHECKIFFUNDINGCOMPLETEOREXPIRED = "checkIfFundingCompleteOrExpired";

    public static final String FUNC_COMPLETEAT = "completeAt";

    public static final String FUNC_CONTRIBUTE = "contribute";

    public static final String FUNC_CONTRIBUTIONS = "contributions";

    public static final String FUNC_CREATOR = "creator";

    public static final String FUNC_CURRENTBALANCE = "currentBalance";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_GETDETAILS = "getDetails";

    public static final String FUNC_GETREFUND = "getRefund";

    public static final String FUNC_RAISEBY = "raiseBy";

    public static final String FUNC_STATE = "state";

    public static final String FUNC_TITLE = "title";

    public static final Event CREATORPAID_EVENT = new Event("CreatorPaid",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event FUNDINGRECEIVED_EVENT = new Event("FundingReceived",
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected Project(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Project(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Project(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Project(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<CreatorPaidEventResponse> getCreatorPaidEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATORPAID_EVENT, transactionReceipt);
        ArrayList<CreatorPaidEventResponse> responses = new ArrayList<CreatorPaidEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreatorPaidEventResponse typedResponse = new CreatorPaidEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CreatorPaidEventResponse> creatorPaidEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, CreatorPaidEventResponse>() {
            @Override
            public CreatorPaidEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CREATORPAID_EVENT, log);
                CreatorPaidEventResponse typedResponse = new CreatorPaidEventResponse();
                typedResponse.log = log;
                typedResponse.recipient = (String) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CreatorPaidEventResponse> creatorPaidEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CREATORPAID_EVENT));
        return creatorPaidEventFlowable(filter);
    }

    public List<FundingReceivedEventResponse> getFundingReceivedEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(FUNDINGRECEIVED_EVENT, transactionReceipt);
        ArrayList<FundingReceivedEventResponse> responses = new ArrayList<FundingReceivedEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            FundingReceivedEventResponse typedResponse = new FundingReceivedEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.contributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.currentTotal = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<FundingReceivedEventResponse> fundingReceivedEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new Function<Log, FundingReceivedEventResponse>() {
            @Override
            public FundingReceivedEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(FUNDINGRECEIVED_EVENT, log);
                FundingReceivedEventResponse typedResponse = new FundingReceivedEventResponse();
                typedResponse.log = log;
                typedResponse.contributor = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.currentTotal = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<FundingReceivedEventResponse> fundingReceivedEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(FUNDINGRECEIVED_EVENT));
        return fundingReceivedEventFlowable(filter);
    }

    public RemoteFunctionCall<BigInteger> amountGoal() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_AMOUNTGOAL,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> checkIfFundingCompleteOrExpired() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CHECKIFFUNDINGCOMPLETEOREXPIRED,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> completeAt() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_COMPLETEAT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<TransactionReceipt> contribute() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_CONTRIBUTE,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> contributions(String param0) {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CONTRIBUTIONS,
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> creator() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CREATOR,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<BigInteger> currentBalance() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_CURRENTBALANCE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> description() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_DESCRIPTION,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<Tuple7<String, String, String, BigInteger, BigInteger, BigInteger, BigInteger>> getDetails() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETDETAILS,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint8>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple7<String, String, String, BigInteger, BigInteger, BigInteger, BigInteger>>(function,
                new Callable<Tuple7<String, String, String, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<String, String, String, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, String, String, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(),
                                (String) results.get(1).getValue(),
                                (String) results.get(2).getValue(),
                                (BigInteger) results.get(3).getValue(),
                                (BigInteger) results.get(4).getValue(),
                                (BigInteger) results.get(5).getValue(),
                                (BigInteger) results.get(6).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> getRefund() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(
                FUNC_GETREFUND,
                Arrays.<Type>asList(),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> raiseBy() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RAISEBY,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<BigInteger> state() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_STATE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint8>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> title() {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TITLE,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static Project load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Project(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Project load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Project(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Project load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Project(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Project load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Project(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Project> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String projectStarter, String projectTitle, String projectDesc, BigInteger fundRaisingDeadline, BigInteger goalAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, projectStarter),
                new org.web3j.abi.datatypes.Utf8String(projectTitle),
                new org.web3j.abi.datatypes.Utf8String(projectDesc),
                new org.web3j.abi.datatypes.generated.Uint256(fundRaisingDeadline),
                new org.web3j.abi.datatypes.generated.Uint256(goalAmount)));
        return deployRemoteCall(Project.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Project> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String projectStarter, String projectTitle, String projectDesc, BigInteger fundRaisingDeadline, BigInteger goalAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, projectStarter),
                new org.web3j.abi.datatypes.Utf8String(projectTitle),
                new org.web3j.abi.datatypes.Utf8String(projectDesc),
                new org.web3j.abi.datatypes.generated.Uint256(fundRaisingDeadline),
                new org.web3j.abi.datatypes.generated.Uint256(goalAmount)));
        return deployRemoteCall(Project.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Project> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String projectStarter, String projectTitle, String projectDesc, BigInteger fundRaisingDeadline, BigInteger goalAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, projectStarter),
                new org.web3j.abi.datatypes.Utf8String(projectTitle),
                new org.web3j.abi.datatypes.Utf8String(projectDesc),
                new org.web3j.abi.datatypes.generated.Uint256(fundRaisingDeadline),
                new org.web3j.abi.datatypes.generated.Uint256(goalAmount)));
        return deployRemoteCall(Project.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Project> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String projectStarter, String projectTitle, String projectDesc, BigInteger fundRaisingDeadline, BigInteger goalAmount) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, projectStarter),
                new org.web3j.abi.datatypes.Utf8String(projectTitle),
                new org.web3j.abi.datatypes.Utf8String(projectDesc),
                new org.web3j.abi.datatypes.generated.Uint256(fundRaisingDeadline),
                new org.web3j.abi.datatypes.generated.Uint256(goalAmount)));
        return deployRemoteCall(Project.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CreatorPaidEventResponse extends BaseEventResponse {
        public String recipient;
    }

    public static class FundingReceivedEventResponse extends BaseEventResponse {
        public String contributor;

        public BigInteger amount;

        public BigInteger currentTotal;
    }
}