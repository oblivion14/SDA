package com.pineone.sda.service;


import com.pineone.sda.domain.ContextModel;
import com.pineone.sda.domain.DeviceControlMessage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

/**
 * Created by use on 2015-09-09.
 */
@Service
public class DataService {

    String AriconContext = "AIRCON";
    String CONTEXTMODELNAME = "ContextModelName";
    String DOMIANID = "DomianID";

    String DCMURI ="_uri";
    String DCMCOMMAND = "_command";
    String DCMCNF = "cnf";
    String DCMCON = "con";

    public JSONObject parsingData(ContextModel contextModel){
        JSONObject object = new JSONObject();
        object.put(CONTEXTMODELNAME,contextModel.getContextModelName());
        object.put(DOMIANID,contextModel.getDomianID());
        return object;
    }

    public JSONObject ContextAwareness(String name){

        ContextModel contextModel = new ContextModel();
        if(AriconContext.equals(name)){
            contextModel.setContextModelName("SO-CONTEXT-001");
            contextModel.setDomianID("SO-DOMAIN-001");
        } else {
            contextModel.setContextModelName("SO-CONTEXT-999");
            contextModel.setDomianID("SO-DOMAIN-989");
        }

        return parsingData(contextModel);
    }

    public void requestSDA(String context){
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost Request = new HttpPost("http://localhost:8090/sendobject");
            Request.setHeader("context",context);
            HttpResponse response = httpclient.execute(Request);
            BufferedReader br = new BufferedReader(
                    new InputStreamReader((response.getEntity().getContent())));
            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public JSONObject parsingDeviceControlMessageData(DeviceControlMessage deviceControlMessage) {
        JSONObject object = new JSONObject();
        object.put(DCMURI, deviceControlMessage.get_uri());
        object.put(DCMCOMMAND, deviceControlMessage.get_command());
        object.put(DCMCNF, deviceControlMessage.getCnf());
        object.put(DCMCON, deviceControlMessage.getCon());
        return object;
    }



}
