package com.filedroute.converter;

import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConvertCustomerRemotetoCustomerLocalTest {

    @Test
    public void validConvert(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        CustomerRemote customerRemote = new CustomerRemote(3L, "Ivan Rizvi", "plano", "TX", "75025", LocalDateTime.parse("2012-08-31 13:39:00", formatter));

        CustomerLocal customerLocal = ConvertCustomerRemotetoCustomerLocal.convert(customerRemote);
        System.out.println(customerRemote);
        System.out.println(customerLocal);
        // then
        Assert.assertNotNull(customerLocal);
        Assert.assertEquals("Rizvi", customerLocal.getLname());
        Assert.assertEquals("Ivan", customerLocal.getFname());


    }



}
