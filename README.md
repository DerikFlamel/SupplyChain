# 🌾 Supply Chain Tracking

This project simulates an IoT-enabled agricultural supply chain. It tracks the movement of goods such as crops and produce through various logistics points — from farms to warehouses — in real time. The system provides a foundation for understanding how modern supply chain management integrates data collection, backend APIs, and responsive front-end visualization to support better decision-making in agricultural operations.

---

## 📝 Project Overview

Built with Spring Boot and PostgreSQL, it exposes a RESTful API for registering, updating, and deleting product movement records between locations, processing facilities, and warehouses. The frontend, developed using HTML, CSS, and JavaScript, provides a clean, modern dashboard where users can easily add new shipments, view current logistics data, and remove outdated entries. This data is synchronized in real-time with the backend through asynchronous API calls, ensuring a smooth user experience.
Architecturally, the project emphasizes modularity and scalability. The use of Spring Data JPA abstracts database operations, making it easy to extend the system with advanced analytics, IoT integrations (such as GPS trackers or temperature sensors), or cloud-based dashboards in future iterations. This setup provides a strong foundation for expanding into a fully connected, intelligent supply chain management platform.

---

## 🖼️ Preview

![Project Screenshot](./Images/Screenshot.png)

---

## 🖥️ Project Structure
```
SUPPLYCHAIN/
│── src/main/
│ ├── java/
│   ├── com/example/supplychain/
│     ├── dto/
│      ├── MovementCreateRequest.java — # Data Transfer Object
│     ├── HelloController.java — # Test controller
│     ├── Location.java — # Entity/model warehouse
│     ├── LocationController.java — # REST controller 
│     ├── LocationRepository.java — # Spring Data JPA repository interface 
│     ├── Product.java — # Entity/model product 
│     ├── ProductController.java — # REST controller managing API endpoints
│     ├── SupplychainDemoApplication.java — # Main Spring Boot application class
│    ├── Movement.java — # Entity/model movement
│    ├── MovementController.java — # REST controller managing endpoints related to product movements
│    ├── MovementRepository.java — # Repository interface to persist and query Movement data from the database.
│    ├── ProductRepository.java — # Repository interface for managing product persistence.
│
│ ├── resources/
│   ├── static/
│     ├── index.html — # Webpage
│   ├── application.properties — # Configuration file for Spring Boot 
│
│── target/ — #Compiled build output folder 
│
│── docker-compose.yml — # Containerizing and running the application’s services
│── pom.xml — # Dependencies, plugins, and build information.
│── Screenshot.png — # Project View
│── .gitignore — # Project documentation
│── LICENSE — # Project documentation
│── README.md # Project documentation
```
---

## 🛠️ Built With

- **Backend/Database** – Spring Boot (Java), PostgreSQL (via Docker)
- **Main Language** – Java
- **Frontend/Website** – HTML, CSS, JavaScript
- **Build & Dependency Management** – Maven
- **Deployment/Runtime Environment** – Docker Compose (Spring Boot + PostgreSQL containers)

---

## 🌐 Clone the repository
```bash
git clone https://github.com/DerikFlamel/SupplyChain.git
```
