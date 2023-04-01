package com.filedroute.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SynchronizedCustomer {
    ObjectMapper oMapper = new ObjectMapper();
    public Map<String, List<Map<String, String>>> synchronizeCustomer(List<CustomerLocal> customerLocal, List<CustomerRemote> customerRemote){
        Map<String, List<Map<String, String>>>  result = new HashMap<>();
        List<Map<String, String>> localUpdates = new ArrayList<>();
        List<Map<String, String>> remoteUpdates = new ArrayList<>();
        for (CustomerLocal local:customerLocal) {
            Long id = local.getCustomerID();
            boolean found = false;
            for (CustomerRemote remote : customerRemote) {
                if (id.equals(remote.getCustomerNumber())) {
                    found = true;
                    if (local.getDateUpdated().isAfter(remote.getDateUpdated())) {
                        Map<String, String> remoteUpdate = new HashMap<>();
                        remoteUpdate = oMapper.convertValue(local, Map.class);
                        remoteUpdates.add(remoteUpdate);
                    } else {
                        Map<String, String> localUpdate = new HashMap<>();
                        localUpdate = oMapper.convertValue(remote, Map.class);
                        localUpdates.add(localUpdate);
                    }
                }
            }
            if (!found){
                Map<String, String> remoteUpdate = new HashMap<>();
                remoteUpdate = oMapper.convertValue(local, Map.class);
                remoteUpdates.add(remoteUpdate);
            }
        }
        for (CustomerRemote remote : customerRemote) {
            Long id = remote.getCustomerNumber();
            boolean found = false;
            for (CustomerLocal local:customerLocal) {
                if (id.equals(local.getCustomerID())) {
                    found=true;
                }
            }
            if (!found){
                Map<String, String> localUpdate = new HashMap<>();
                localUpdate = oMapper.convertValue(remote, Map.class);
                localUpdates.add(localUpdate);
            }
        }
        result.put("Local Updates",localUpdates);
        result.put("Remote Updates",remoteUpdates);

        return result;
    }
}
