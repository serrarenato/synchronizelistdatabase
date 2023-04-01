# Solutions Synchronize Two Lists

Below, you will find two sets of data from different sources which need to be synced. The two sets share a common key field; ‘customerID’ in set A and ‘CustomerNumber’ in set B. Each set has a ‘dateUpdated’ which represents the last change time for the entity. Analyze both sets and prepare updates for each set from the rows in the other set that are missing or outdated. Solution should output the only the updated entities for both the local and remote set.
```json
var local = [
{
"customerID": "3",
"fname": "Ivan",
"lname": "Rizvi",
"city": "plano",
"state": "TX",
"zipCode": "75025",
"dateUpdated": "2012-08-31 13:39:00"
},
{
"customerID": "5",
"fname": "richard",
"lname": "Cortez",
"city": "McKinney",
"state": "TX",
"zipCode": "75071",
"dateUpdated": "2012-08-31 18:28:00"
},
{
"customerID": "6",
"fname": "Mark",
"lname": "Granberry",
"city": "Sachse",
"state": "TX",
"zipCode": "75048",
"dateUpdated": "2012-08-31 17:30:00"
},
{
"customerID": "7",
"fname": "Raul",
"lname": "Whittington",
"city": "McKinney",
"state": "TX",
"zipCode": "75070",
"dateUpdated": "2020-01-01 00:00:00"
},
{
"customerID": "8",
"fname": "Antonio",
"lname": "Fisher",
"city": "Sachse",
"state": "TX",
"zipCode": "75048",
"dateUpdated": "2012-08-31 17:47:00"
},
{
"customerID": "9",
"fname": "kim",
"lname": "Flores",
"city": "Rowlett",
"state": "TX",
"zipCode": "75070",
"dateUpdated": "2020-01-01 00:00:00"
},
{
"customerID": "10",
"fname": "Gina",
"lname": "Daskas",
"city": "plano",
"state": "TX",
"zipCode": "75025",
"dateUpdated": "2012-08-31 13:49:00"
},
{
"customerID": "11",
"fname": "Dustin",
"lname": "Esparza",
"city": "McKinney",
"state": "TX",
"zipCode": "75069",
"dateUpdated": "2012-08-31 15:18:00"
},
{
"customerID": "12",
"fname": "Beatrices",
"lname": "Dallahs",
"city": "McKinney",
"state": "TX",
"zipCode": "75069",
"dateUpdated": "2012-08-31 20:17:00"
},
{
"customerID": "13",
"fname": "lewis",
"lname": "Leatherman",
"city": "Garland",
"state": "TX",
"zipCode": "75044",
"dateUpdated": "2012-08-31 10:45:00"
}
];

var remote = [
{
"CustomerNumber": "7",
"CustomerName": "Raul Whittington",
"CustomerCity": "McKinney",
"CustomerState": "TX",
"CustomerZipCode": "75069",
"dateUpdated": "2012-08-31 13:25:00"
},
{
"CustomerNumber": "8",
"CustomerName": "Antonio Fisher",
"CustomerCity": "Dallas",
"CustomerState": "TX",
"CustomerZipCode": "75252",
"dateUpdated": "2020-02-01 00:00:00"
},
{
"CustomerNumber": "9",
"CustomerName": "kim Flores",
"CustomerCity": "Rowlett",
"CustomerState": "TX",
"CustomerZipCode": "75089",
"dateUpdated": "2012-08-31 18:09:00"
},
{
"CustomerNumber": "10",
"CustomerName": "Gina Daskas",
"CustomerCity": "plano",
"CustomerState": "TX",
"CustomerZipCode": "75025",
"dateUpdated": "2012-08-31 13:49:00"
},
{
"CustomerNumber": "11",
"CustomerName": "Dustin Esparza",
"CustomerCity": "McKinney",
"CustomerState": "TX",
"CustomerZipCode": "75069",
"dateUpdated": "2012-08-31 15:18:00"
},
{
"CustomerNumber": "12",
"CustomerName": "Beatrices Dallas",
"CustomerCity": "McKinney",
"CustomerState": "TX",
"CustomerZipCode": "75069",
"dateUpdated": "2012-08-31 20:17:00"
},
{
"CustomerNumber": "13",
"CustomerName": "lewis Leatherman",
"CustomerCity": "Garland",
"CustomerState": "TX",
"CustomerZipCode": "75044",
"dateUpdated": "2012-08-31 10:45:00"
},
{
"CustomerNumber": "14",
"CustomerName": "David Johnsons",
"CustomerCity": "wylie",
"CustomerState": "TX",
"CustomerZipCode": "75098",
"dateUpdated": "2012-08-31 20:16:00"
},
{
"CustomerNumber": "15",
"CustomerName": "Ken Salisbury",
"CustomerCity": "Garland",
"CustomerState": "TX",
"CustomerZipCode": "75044",
"dateUpdated": "2012-08-31 20:43:00"
}
];



Expected OutPut

Local Updates:[
{
"customerID": "8",
"fname": "Antonio",
"lname": "Fisher",
"city": "Dallas",
"state": "TX",
"zip": "75252",
"dateUpdated": "2020-02-01 00:00:00"
},
{
"customerID": "14",
"fname": "David",
"lname": "Johnsons",
"city": "wylie",
"state": "TX",
"zip": "75098",
"dateUpdated": "2012-08-31 20:16:00"
},
{
"customerID": "15",
"fname": "Ken",
"lname": "Salisbury",
"city": "Garland",
"state": "TX",
"zip": "75044",
"dateUpdated": "2012-08-31 20:43:00"
}
]Remote Updates:[
{
"CustomerNumber": "3",
"CustomerName": "Ivan Rizvi",
"CustomerCity": "plano",
"CustomerState": "TX",
"dateUpdated": "2012-08-31 13:39:00"
},
{
"CustomerNumber": "5",
"CustomerName": "richard Cortez",
"CustomerCity": "McKinney",
"CustomerState": "TX",
"dateUpdated": "2012-08-31 18:28:00"
},
{
"CustomerNumber": "6",
"CustomerName": "Mark Granberry",
"CustomerCity": "Sachse",
"CustomerState": "TX",
"dateUpdated": "2012-08-31 17:30:00"
},
{
"CustomerNumber": "7",
"CustomerName": "Raul Whittington",
"CustomerCity": "McKinney",
"CustomerState": "TX",
"dateUpdated": "2020-01-01 00:00:00"
},
{
"CustomerNumber": "9",
"CustomerName": "kim Flores",
"CustomerCity": "Rowlett",
"CustomerState": "TX",
"dateUpdated": "2020-01-01 00:00:00"
}
]
```

## Pré requisito
- Maven 3
- Java 8

## Preparando ambiente
- ```mvn clean package```