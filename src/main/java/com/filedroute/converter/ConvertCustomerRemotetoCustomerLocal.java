package com.filedroute.converter;

import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;

public class ConvertCustomerRemotetoCustomerLocal {

    public static CustomerLocal convert(CustomerRemote customerRemote) {
        String[] names = customerRemote.getCustomerName().split(" ");
        CustomerLocal cl = new CustomerLocal(customerRemote.getCustomerNumber(), names[0] , names[1], customerRemote.getCustomerCity(), customerRemote.getCustomerState(),
        customerRemote.getCustomerZipCode(), customerRemote.getDateUpdated());

        return cl;
    }
}
