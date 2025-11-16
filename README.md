# 💱 Currency Converter (Java Console App)

A simple Java console program that converts currencies using the **ExchangeRate API** and saves every conversion in a log file.

---

## ✨ Features

- Real-time currency conversion  
- Interactive console menu  
- Logs every conversion with date, time, rate, and result  
- Logs stored in `/logs/conversion_history.txt`  
- Clean project structure  

---

## 📁 Project Structure
src/
└── alura.courses.com/
├── api/
│    └── CurrencyApi.java
├── dto/
│    └── Currency.java
├── helper/
│    └── PrintCurrency.java
├── logger/
│    └── Logger.java
└── Main.java
logs/
└── conversion_history.txt

---

## 🔧 Requirements

- Java **17+**
- Gson library

Add Gson (if using Maven):

```xml
<dependency>
    <groupId>com.google.code.gson</groupId>
    <artifactId>gson</artifactId>
    <version>2.10.1</version>
</dependency>
```


The app sends a request to:
```
https://v6.exchangerate-api.com/v6/{ApiKey}/pair/{BASE}/{TARGET}/{AMOUNT}
````

## 📝 Logging

Every conversion is stored in:
logs/conversion_history.txt

## ▶️ Running the App
	1.	Run Main.java
	2.	Select base currency
	3.	Select target currency
	4.	Enter amount
	5.	View conversion result
	6.	Conversion is logged in the history file

  Example output:
  200 USD are equals to: 184.53 EUR
