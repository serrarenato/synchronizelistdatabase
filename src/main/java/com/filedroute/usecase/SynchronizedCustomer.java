package com.filedroute.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;

import java.util.*;

public class SynchronizedCustomer {
    ObjectMapper oMapper = new ObjectMapper();

    public Map<String, List<Map<String, String>>> synchronizeCustomer(List<CustomerLocal> listCustomerLocal, List<CustomerRemote> listCustomerRemote) {
        Map<String, List<Map<String, String>>> result = new HashMap<>();
        List<Map<String, String>> localUpdates = new ArrayList<>();
        List<Map<String, String>> remoteUpdates = new ArrayList<>();
        for (CustomerLocal local : listCustomerLocal) {
            Long id = local.getCustomerID();
            boolean found = false;
            //Optional<U> remoteObjectOptional = remoteObjects.stream().filter(remoteObject -> remoteIdFunction.apply(remoteObject).equals(id)).findFirst();
            Optional<CustomerRemote> customerRemote = listCustomerRemote.stream().filter(x -> x.getCustomerNumber().equals(id)).findFirst();
            //  for (CustomerRemote remote : customerRemote) {
            if (customerRemote.isPresent()) {
                found = true;
                if (local.getDateUpdated().isAfter(customerRemote.get().getDateUpdated())) {
                    Map<String, String> remoteUpdate = new HashMap<>();
                    remoteUpdate = oMapper.convertValue(local, Map.class);
                    remoteUpdates.add(remoteUpdate);
                } else {
                    Map<String, String> localUpdate = new HashMap<>();
                    localUpdate = oMapper.convertValue(customerRemote.get(), Map.class);
                    localUpdates.add(localUpdate);
                }
            }
            //  }
            if (!found) {
                Map<String, String> remoteUpdate = new HashMap<>();
                remoteUpdate = oMapper.convertValue(local, Map.class);
                remoteUpdates.add(remoteUpdate);
            }
        }
        for (CustomerRemote remote : listCustomerRemote) {
            Long id = remote.getCustomerNumber();
            boolean found = false;
            Optional<CustomerLocal> local = listCustomerLocal.stream().filter(x -> x.getCustomerID().equals(id)).findFirst();
            //for (CustomerLocal local:listCustomerLocal) {
            if (local.isPresent()) {
                found = true;
            }
            //}
            if (!found) {
                Map<String, String> localUpdate = oMapper.convertValue(remote, Map.class);
                localUpdates.add(localUpdate);
            }
        }
        result.put("Local Updates", localUpdates);
        result.put("Remote Updates", remoteUpdates);

        return result;
    }
}
