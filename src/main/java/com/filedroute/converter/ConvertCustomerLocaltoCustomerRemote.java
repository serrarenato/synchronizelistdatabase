package com.filedroute.converter;

import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;

public class ConvertCustomerLocaltoCustomerRemote {

    public static CustomerRemote convert(CustomerLocal customerLocal) {
        CustomerRemote cr = new CustomerRemote(customerLocal.getCustomerID(), customerLocal.getFname() + " " + customerLocal.getLname(), customerLocal.getCity(), customerLocal.getState(),
        customerLocal.getZipCode(), customerLocal.getDateUpdated());

        return cr;
    }
}
