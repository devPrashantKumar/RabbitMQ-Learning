# RabbitMQ-Learning 🐇📩

This project demonstrates how to work with **RabbitMQ** using different types of exchanges:  
- **Direct Exchange**  
- **Fanout Exchange**  
- **Topic Exchange**  
- **Header Exchange**

It includes both **producer and consumer implementations** along with **cURL/Postman commands** for testing.  

---

## 🔹 About RabbitMQ
[RabbitMQ](https://www.rabbitmq.com/) is a lightweight, reliable, and widely used **message broker** that helps in building **event-driven, scalable, and decoupled systems**.  
It supports multiple messaging patterns and ensures reliable communication between distributed services, making it an essential tool in **microservices architecture**.

✅ Key features of RabbitMQ:  
- Supports **asynchronous communication** between services.  
- Ensures **message durability & reliability**.  
- Provides flexible **routing mechanisms** with exchanges.  
- Widely adopted in **microservices, real-time processing, and distributed systems**.  

---

## 🚀 Features of this Project
- Implemented **all exchange types** with practical examples.  
- Producers and consumers configured in the **same application**.  
- Ready-to-use **cURL/Postman commands** for testing.  
- Demonstrates **message routing** using keys, patterns, and headers.  

---

## 🛠️ Tech Stack
- **Java / Spring Boot**  
- **RabbitMQ**  
- **Maven** (for dependency management)  

---

## ▶️ Setup & Run

### 1️⃣ Start RabbitMQ
Using Docker:
```bash
docker run -d --hostname rabbitmq-host --name rabbitmq   -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```

👉 RabbitMQ Management UI: [http://localhost:15672](http://localhost:15672)  
(Default username/password: `guest` / `guest`)

### 2️⃣ Clone & Run the Project
```bash
git clone https://github.com/devPrashantKumar/RabbitMQ-Learning.git
cd RabbitMQ-Learning
mvn spring-boot:run
```

---

## 📡 cURL for Testing

### 🔹 Direct Exchange
```bash
curl -X POST "http://localhost:8080/api/send/direct/practice.key1" -H "Content-Type: text/plain" -d "Hello Direct practice.Key1"

curl -X POST "http://localhost:8080/api/send/direct/practice.key2" -H "Content-Type: text/plain" -d "Hello Direct practice.Key2"
```

### 🔹 Fanout Exchange
```bash
curl -X POST "http://localhost:8080/api/send/fanout" -H "Content-Type: application/json" -d '"Hello Fanout"'
```

### 🔹 Topic Exchange
```bash
curl -X POST "http://localhost:8080/api/send/topic/sports.football.bat" -H "Content-Type: application/json" -d "\"Hello Sports Football Bat\""

curl -X POST "http://localhost:8080/api/send/topic/sports.football" -H "Content-Type: application/json" -d "\"Hello Sports Football\""
```

### 🔹 Header Exchange
```bash
curl -X POST http://localhost:8080/api/send/header/1 -H "Content-Type: application/json" -d "\"Hello PDF Report\""

curl -X POST http://localhost:8080/api/send/header/2 -H "Content-Type: application/json" -d "\"Hello PDF Report\""
```

---

## 📖 References
- [RabbitMQ Official Docs](https://www.rabbitmq.com/tutorials/tutorial-one-java.html)  
- [Spring AMQP](https://spring.io/projects/spring-amqp)  

---

## 🤝 Contribution
Contributions, issues, and feature requests are welcome!  
Feel free to fork this repo and raise a PR. 🚀  

---

## 👨‍💻 Author
**Prashant Kumar**  
🔗 [LinkedIn](https://www.linkedin.com/in/devPrashantKumar/) | [GitHub](https://github.com/devPrashantKumar)  
