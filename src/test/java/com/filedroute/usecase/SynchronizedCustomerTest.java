package com.filedroute.usecase;

import com.filedroute.entity.CustomerLocal;
import com.filedroute.entity.CustomerRemote;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SynchronizedCustomerTest {
    SynchronizedCustomer sinc = new SynchronizedCustomer();
    @Test
    public void validSynchronized1(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<CustomerLocal> localList = new ArrayList<>();
        localList.add(new CustomerLocal(3L, "Ivan", "Rizvi", "plano", "TX", "75025", LocalDateTime.parse("2012-08-31 13:39:00", formatter)));
        localList.add(new CustomerLocal(5L, "richard", "Cortez", "McKinney", "TX", "75071", LocalDateTime.parse("2012-08-31 18:28:00", formatter)));
        localList.add(new CustomerLocal(6L, "Mark", "Granberry", "Sachse", "TX", "75048", LocalDateTime.parse("2012-08-31 17:30:00", formatter)));

        // Remote list
        List<CustomerRemote> remoteList = new ArrayList<>();
        remoteList.add(new CustomerRemote(7L, "Raul Whittington", "McKinney", "TX", "75069", LocalDateTime.parse("2012-08-31 13:25:00", formatter)));
        remoteList.add(new CustomerRemote(8L, "Antonio Fisher", "Dallas", "TX", "75252", LocalDateTime.parse("2020-02-01 00:00:00", formatter)));
        remoteList.add(new CustomerRemote(9L, "kim Flores", "Rowlett", "TX", "75089", LocalDateTime.parse("2012-08-31 18:09:00", formatter)));

        Map<String, List<Map<String, String>>> result = sinc.synchronizeCustomer(localList, remoteList);

        System.out.println(result);
        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());

        Assert.assertTrue(result.containsKey("Local Updates"));
        Assert.assertEquals(3, result.get("Local Updates").size());

        Assert.assertTrue(result.containsKey("Remote Updates"));
        Assert.assertEquals(3, result.get("Remote Updates").size());

    }
    @Test
    public void validSynchronized2(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<CustomerLocal> localList = new ArrayList<>();
        localList.add(new CustomerLocal(3L, "Ivan", "Rizvi", "plano", "TX", "75025", LocalDateTime.parse("2012-08-31 13:39:00", formatter)));
        localList.add(new CustomerLocal(5L, "richard", "Cortez", "McKinney", "TX", "75071", LocalDateTime.parse("2012-08-31 18:28:00", formatter)));
        localList.add(new CustomerLocal(6L, "Mark", "Granberry", "Sachse", "TX", "75048", LocalDateTime.parse("2012-08-31 17:30:00", formatter)));
        localList.add(new CustomerLocal(7L, "Raul", "Whittington", "McKinney", "TX", "75070", LocalDateTime.parse("2020-01-01 00:00:00", formatter)));
        localList.add(new CustomerLocal(8L, "Antonio", "Fisher", "Sachse", "TX", "75048", LocalDateTime.parse("2012-08-31 17:47:00", formatter)));
        localList.add(new CustomerLocal(9L, "kim", "Flores", "Rowlett", "TX", "75070", LocalDateTime.parse("2020-01-01 00:00:00", formatter)));

        // Remote list
        List<CustomerRemote> remoteList = new ArrayList<>();
        remoteList.add(new CustomerRemote(7L, "Raul Whittington", "McKinney", "TX", "75069", LocalDateTime.parse("2012-08-31 13:25:00", formatter)));
        remoteList.add(new CustomerRemote(8L, "Antonio Fisher", "Dallas", "TX", "75252", LocalDateTime.parse("2020-02-01 00:00:00", formatter)));
        remoteList.add(new CustomerRemote(9L, "kim Flores", "Rowlett", "TX", "75089", LocalDateTime.parse("2012-08-31 18:09:00", formatter)));

        Map<String, List<Map<String, String>>> result = sinc.synchronizeCustomer(localList, remoteList);

        System.out.println(result);
        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());

        Assert.assertTrue(result.containsKey("Local Updates"));
        Assert.assertEquals(1, result.get("Local Updates").size());

        Assert.assertTrue(result.containsKey("Remote Updates"));
        Assert.assertEquals(5, result.get("Remote Updates").size());

    }


}
