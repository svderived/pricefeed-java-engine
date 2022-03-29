package com.derived;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.StaticGasProvider;

import com.derived.Contract.PricefeedContract;

public class CoinGecko implements Job
{
    private String endpoint = "https://data-seed-prebsc-1-s1.binance.org:8545";

    private String privateKey = System.getenv("PRIVATE_KEY");

    private String contractAddress = System.getenv("CONTRACT_ADDRESS");

    private BigInteger GAS_LIMIT = BigInteger.valueOf(9_000_000);

    private BigInteger GAS_PRICE = BigInteger.valueOf(1_000_000_000_0L);

    private HashMap<String, String> assets = new HashMap<String, String>();

    private HashMap<String, String> assetPrices = new HashMap<String, String>();

    public CoinGecko()
    {
        assets.put("bitcoin", "btc_usd");
        assets.put("ethereum", "eth_usd");
        assets.put("derived", "dvdx_usd");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        Iterator<String> iterator = assets.keySet().iterator();
        while (iterator.hasNext())
        {
            String coin = iterator.next();
            String assetPair = assets.get(coin);
            try
            {
                String response =
                    callEndpoint("https://api.coingecko.com/api/v3/simple/price?ids=" + coin + "&vs_currencies=usd");
                if (response != null)
                {
                    JSONObject root = new JSONObject(response);
                    JSONObject rootJSON = root.getJSONObject(coin);
                    String price = Float.toString(rootJSON.getFloat("usd"));
                    updatePrice(assetPair, price);
                }
            }
            catch (IOException e)
            {
                System.out.println("error fetching price for: " + coin);
            }
        }

    }

    public String updatePrice(String _assetPair, String _price)
    {

        String txnHash = null;
        Web3j web3j = Web3j.build(new HttpService(endpoint));
        Credentials credentials = Credentials.create(privateKey);

        PricefeedContract contract =
            PricefeedContract.load(contractAddress, web3j, credentials, new StaticGasProvider(GAS_PRICE, GAS_LIMIT));
        try
        {
            if (contract.isValid())
            {
                // CompletableFuture<TransactionReceipt> future =
                // contract.updatePrice(_assetPair, BigInteger.valueOf(40000)).sendAsync();
                System.out.println("Updating " + _assetPair + " to " + _price);
                CompletableFuture<TransactionReceipt> future = contract.updatePriceV1(_assetPair, _price).sendAsync();
                txnHash = future.get().getTransactionHash();
            } else
                throw new Exception("Invalid Contract");
        }
        catch (IOException | InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return txnHash;
    }

    private String callEndpoint(String uri) throws ClientProtocolException, IOException
    {
        // System.out.println(uri);
        String content = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        if (entity != null)
            content = EntityUtils.toString(entity);
        httpClient.close();
        return content;
    }
}
