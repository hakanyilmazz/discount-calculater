# Spring Rest API Example - Discount Calculater

## Requirements
---------------------------------------
1- Maven (3.8.5+)

2- Java JDK (17)

3- Postman

---------------------------------------

## How to build?
---------------------------------------
1- Set JAVA_HOME and MVN_HOME to Environment variables of your operating system.

2- Run this script on terminal
```
$mvn clean install
```

## How to run?
1- Run this script on terminal
```
$mvn spring-boot:run
```

## How to send POST request
1- Open Postman -> File -> New -> HTTP Request -> Select POST

2- Enter this url: ```localhost:8080/calculateDiscount```

3- Select Body -> ```Raw``` and Select ```JSON``` type

4- Paste this json body:
```
{
    "product": {
        "name": "Computer"
    },
    "discountType": 
        "GOLD_CARD"
}
```
### Available discount types:
```
GOLD_CARD,
SILVER_CARD,
AFFILIATE,
MORE_THAN_TWO_YEARS
```

### Available product types:
```
Name: Computer - Price: 5000,
Name: Phone - Price: 500,
Name: Book - Price: 50
```

## UML Diagram (Some class types not writed, because so long names 😢)
<img src="https://github.com/hakanyilmazz/discount-calculater/blob/main/screenshots/uml.jpg">