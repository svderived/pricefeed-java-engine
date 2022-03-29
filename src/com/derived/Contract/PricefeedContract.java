package com.derived.Contract;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.BaseEventResponse;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>
 * Auto generated code.
 * <p>
 * <strong>Do not modify!</strong>
 * <p>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or the
 * org.web3j.codegen.SolidityFunctionWrapperGenerator in the
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 * <p>
 * Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class PricefeedContract extends Contract
{
    public static final String BINARY = "0x608060405234801561001057600080fd5b5061002d61002261003260201b60201c565b61003a60201b60201c565b6100fe565b600033905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35050565b610f878061010d6000396000f3fe608060405234801561001057600080fd5b50600436106100935760003560e01c8063715018a611610066578063715018a6146101305780638da5cb5b1461013a578063ae88205414610158578063cf1c316a14610174578063f2fde38b1461019057610093565b8063485d7d94146100985780634a432a46146100b4578063524f3889146100d057806356ecdc9914610100575b600080fd5b6100b260048036038101906100ad91906109cb565b6101ac565b005b6100ce60048036038101906100c99190610aa1565b610283565b005b6100ea60048036038101906100e591906109f4565b610373565b6040516100f79190610c9a565b60405180910390f35b61011a600480360381019061011591906109f4565b61039b565b6040516101279190610c18565b60405180910390f35b61013861044b565b005b6101426104d3565b60405161014f9190610bfd565b60405180910390f35b610172600480360381019061016d9190610a35565b6104fc565b005b61018e600480360381019061018991906109cb565b6105fc565b005b6101aa60048036038101906101a591906109cb565b6106d2565b005b6101b46107ca565b73ffffffffffffffffffffffffffffffffffffffff166101d26104d3565b73ffffffffffffffffffffffffffffffffffffffff1614610228576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161021f90610c7a565b60405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff168061030d57503373ffffffffffffffffffffffffffffffffffffffff166102f56104d3565b73ffffffffffffffffffffffffffffffffffffffff16145b61034c576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161034390610c5a565b60405180910390fd5b8060028360405161035d9190610be6565b9081526020016040518091039020819055505050565b60006002826040516103859190610be6565b9081526020016040518091039020549050919050565b60606003826040516103ad9190610be6565b908152602001604051809103902080546103c690610db0565b80601f01602080910402602001604051908101604052809291908181526020018280546103f290610db0565b801561043f5780601f106104145761010080835404028352916020019161043f565b820191906000526020600020905b81548152906001019060200180831161042257829003601f168201915b50505050509050919050565b6104536107ca565b73ffffffffffffffffffffffffffffffffffffffff166104716104d3565b73ffffffffffffffffffffffffffffffffffffffff16146104c7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016104be90610c7a565b60405180910390fd5b6104d160006107d2565b565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff168061058657503373ffffffffffffffffffffffffffffffffffffffff1661056e6104d3565b73ffffffffffffffffffffffffffffffffffffffff16145b6105c5576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016105bc90610c5a565b60405180910390fd5b806003836040516105d69190610be6565b908152602001604051809103902090805190602001906105f7929190610896565b505050565b6106046107ca565b73ffffffffffffffffffffffffffffffffffffffff166106226104d3565b73ffffffffffffffffffffffffffffffffffffffff1614610678576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161066f90610c7a565b60405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6106da6107ca565b73ffffffffffffffffffffffffffffffffffffffff166106f86104d3565b73ffffffffffffffffffffffffffffffffffffffff161461074e576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040161074590610c7a565b60405180910390fd5b600073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff1614156107be576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004016107b590610c3a565b60405180910390fd5b6107c7816107d2565b50565b600033905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167f8be0079c531659141344cd1fd0a4f28419497f9722a3daafe3b4186f6b6457e060405160405180910390a35050565b8280546108a290610db0565b90600052602060002090601f0160209004810192826108c4576000855561090b565b82601f106108dd57805160ff191683800117855561090b565b8280016001018555821561090b579182015b8281111561090a5782518255916020019190600101906108ef565b5b509050610918919061091c565b5090565b5b8082111561093557600081600090555060010161091d565b5090565b600061094c61094784610cda565b610cb5565b90508281526020810184848401111561096457600080fd5b61096f848285610d6e565b509392505050565b60008135905061098681610f23565b92915050565b600082601f83011261099d57600080fd5b81356109ad848260208601610939565b91505092915050565b6000813590506109c581610f3a565b92915050565b6000602082840312156109dd57600080fd5b60006109eb84828501610977565b91505092915050565b600060208284031215610a0657600080fd5b600082013567ffffffffffffffff811115610a2057600080fd5b610a2c8482850161098c565b91505092915050565b60008060408385031215610a4857600080fd5b600083013567ffffffffffffffff811115610a6257600080fd5b610a6e8582860161098c565b925050602083013567ffffffffffffffff811115610a8b57600080fd5b610a978582860161098c565b9150509250929050565b60008060408385031215610ab457600080fd5b600083013567ffffffffffffffff811115610ace57600080fd5b610ada8582860161098c565b9250506020610aeb858286016109b6565b9150509250929050565b610afe81610d32565b82525050565b6000610b0f82610d0b565b610b198185610d16565b9350610b29818560208601610d7d565b610b3281610e71565b840191505092915050565b6000610b4882610d0b565b610b528185610d27565b9350610b62818560208601610d7d565b80840191505092915050565b6000610b7b602683610d16565b9150610b8682610e82565b604082019050919050565b6000610b9e601383610d16565b9150610ba982610ed1565b602082019050919050565b6000610bc1602083610d16565b9150610bcc82610efa565b602082019050919050565b610be081610d64565b82525050565b6000610bf28284610b3d565b915081905092915050565b6000602082019050610c126000830184610af5565b92915050565b60006020820190508181036000830152610c328184610b04565b905092915050565b60006020820190508181036000830152610c5381610b6e565b9050919050565b60006020820190508181036000830152610c7381610b91565b9050919050565b60006020820190508181036000830152610c9381610bb4565b9050919050565b6000602082019050610caf6000830184610bd7565b92915050565b6000610cbf610cd0565b9050610ccb8282610de2565b919050565b6000604051905090565b600067ffffffffffffffff821115610cf557610cf4610e42565b5b610cfe82610e71565b9050602081019050919050565b600081519050919050565b600082825260208201905092915050565b600081905092915050565b6000610d3d82610d44565b9050919050565b600073ffffffffffffffffffffffffffffffffffffffff82169050919050565b6000819050919050565b82818337600083830152505050565b60005b83811015610d9b578082015181840152602081019050610d80565b83811115610daa576000848401525b50505050565b60006002820490506001821680610dc857607f821691505b60208210811415610ddc57610ddb610e13565b5b50919050565b610deb82610e71565b810181811067ffffffffffffffff82111715610e0a57610e09610e42565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b6000601f19601f8301169050919050565b7f4f776e61626c653a206e6577206f776e657220697320746865207a65726f206160008201527f6464726573730000000000000000000000000000000000000000000000000000602082015250565b7f556e617574686f72697a65642041636365737300000000000000000000000000600082015250565b7f4f776e61626c653a2063616c6c6572206973206e6f7420746865206f776e6572600082015250565b610f2c81610d32565b8114610f3757600080fd5b50565b610f4381610d64565b8114610f4e57600080fd5b5056fea2646970667358221220bcef25e139e003dbb48241a09530415ffcb9aab72c43ee283fedce67cfc66b3f64736f6c63430008040033";

    public static final String FUNC_ADDAUTHORIZED = "addAuthorized";

    public static final String FUNC_GETPRICE = "getPrice";

    public static final String FUNC_GETPRICEV1 = "getPriceV1";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_REMOVEAUTHORIZED = "removeAuthorized";

    public static final String FUNC_RENOUNCEOWNERSHIP = "renounceOwnership";

    public static final String FUNC_TRANSFEROWNERSHIP = "transferOwnership";

    public static final String FUNC_UPDATEPRICE = "updatePrice";

    public static final String FUNC_UPDATEPRICEV1 = "updatePriceV1";

    public static final Event OWNERSHIPTRANSFERRED_EVENT =
        new Event("OwnershipTransferred", Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true)
        {
        }, new TypeReference<Address>(true)
        {
        }));;

    @Deprecated
    protected PricefeedContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
        BigInteger gasLimit)
    {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected PricefeedContract(String contractAddress, Web3j web3j, Credentials credentials,
        ContractGasProvider contractGasProvider)
    {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected PricefeedContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice,
        BigInteger gasLimit)
    {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected PricefeedContract(String contractAddress, Web3j web3j, TransactionManager transactionManager,
        ContractGasProvider contractGasProvider)
    {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public List<OwnershipTransferredEventResponse> getOwnershipTransferredEvents(TransactionReceipt transactionReceipt)
    {
        List<Contract.EventValuesWithLog> valueList =
            extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, transactionReceipt);
        ArrayList<OwnershipTransferredEventResponse> responses =
            new ArrayList<OwnershipTransferredEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList)
        {
            OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(EthFilter filter)
    {
        return web3j.ethLogFlowable(filter).map(new Function<Log, OwnershipTransferredEventResponse>()
        {
            @Override
            public OwnershipTransferredEventResponse apply(Log log)
            {
                Contract.EventValuesWithLog eventValues =
                    extractEventParametersWithLog(OWNERSHIPTRANSFERRED_EVENT, log);
                OwnershipTransferredEventResponse typedResponse = new OwnershipTransferredEventResponse();
                typedResponse.log = log;
                typedResponse.previousOwner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse.newOwner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OwnershipTransferredEventResponse> ownershipTransferredEventFlowable(
        DefaultBlockParameter startBlock, DefaultBlockParameter endBlock)
    {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(OWNERSHIPTRANSFERRED_EVENT));
        return ownershipTransferredEventFlowable(filter);
    }

    public RemoteFunctionCall<TransactionReceipt> addAuthorized(String _toAdd)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_ADDAUTHORIZED,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _toAdd)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<BigInteger> getPrice(String _asset)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRICE,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_asset)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>()
            {
            }));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<String> getPriceV1(String _asset)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_GETPRICEV1,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_asset)),
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>()
            {
            }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<String> owner()
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_OWNER,
            Arrays.<Type>asList(), Arrays.<TypeReference<?>>asList(new TypeReference<Address>()
            {
            }));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteFunctionCall<TransactionReceipt> removeAuthorized(String _toRemove)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_REMOVEAUTHORIZED,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, _toRemove)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> renounceOwnership()
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_RENOUNCEOWNERSHIP,
            Arrays.<Type>asList(), Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> transferOwnership(String newOwner)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_TRANSFEROWNERSHIP,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(160, newOwner)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePrice(String _asset, BigInteger _price)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UPDATEPRICE,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_asset),
                new org.web3j.abi.datatypes.generated.Uint256(_price)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<TransactionReceipt> updatePriceV1(String _asset, String _price)
    {
        final org.web3j.abi.datatypes.Function function = new org.web3j.abi.datatypes.Function(FUNC_UPDATEPRICEV1,
            Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_asset),
                new org.web3j.abi.datatypes.Utf8String(_price)),
            Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static PricefeedContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice,
        BigInteger gasLimit)
    {
        return new PricefeedContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static PricefeedContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
        BigInteger gasPrice, BigInteger gasLimit)
    {
        return new PricefeedContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static PricefeedContract load(String contractAddress, Web3j web3j, Credentials credentials,
        ContractGasProvider contractGasProvider)
    {
        return new PricefeedContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static PricefeedContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager,
        ContractGasProvider contractGasProvider)
    {
        return new PricefeedContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static class OwnershipTransferredEventResponse extends BaseEventResponse
    {
        public String previousOwner;

        public String newOwner;
    }
}
