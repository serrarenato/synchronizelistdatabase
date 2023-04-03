package com.filedroute.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.filedroute.converter.ConvertCustomerLocaltoCustomerRemote;
import com.filedroute.converter.ConvertCustomerRemotetoCustomerLocal;
import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;

import java.util.*;

public class SynchronizedCustomer {
    private static ObjectMapper oMapper = new ObjectMapper();
    {
        oMapper.registerModule(new JavaTimeModule());
        oMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

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
                    remoteUpdate = oMapper.convertValue(ConvertCustomerLocaltoCustomerRemote.convert(local), Map.class);
                    remoteUpdates.add(remoteUpdate);
                } else {
                    Map<String, String> localUpdate = new HashMap<>();
                    localUpdate = oMapper.convertValue(ConvertCustomerRemotetoCustomerLocal.convert(customerRemote.get()), Map.class);
                    localUpdates.add(localUpdate);
                }
            }
            //  }
            if (!found) {
                Map<String, String> remoteUpdate = new HashMap<>();
                remoteUpdate = oMapper.convertValue(ConvertCustomerLocaltoCustomerRemote.convert(local), Map.class);

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
                Map<String, String> localUpdate = oMapper.convertValue(ConvertCustomerRemotetoCustomerLocal.convert(remote), Map.class);
                localUpdates.add(localUpdate);
            }
        }
        result.put("Local Updates", localUpdates);
        result.put("Remote Updates", remoteUpdates);

        return result;
    }
}
