package com.filedroute.converter;

import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;
import com.filedroute.usecase.SynchronizedCustomer;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertCustomerLocaltoCustomerRemoteTest {

    @Test
    public void validConvert(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        CustomerLocal customerLocal = new CustomerLocal(3L, "Ivan", "Rizvi", "plano", "TX", "75025", LocalDateTime.parse("2012-08-31 13:39:00", formatter));

        CustomerRemote customerRemote = ConvertCustomerLocaltoCustomerRemote.convert(customerLocal);
        System.out.println(customerLocal);
        System.out.println(customerRemote);
        // then
        Assert.assertNotNull(customerRemote);
        Assert.assertEquals("Ivan Rizvi", customerRemote.getCustomerName());

    }



}
