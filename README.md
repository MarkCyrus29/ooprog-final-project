## 👥 Authors
**Mark Cyrus Serrano**  
**Alejandro Umila**  
**Section:** C2B  

> 🔗 **Live Demo:** *(Vercel link here)*

> 📈 **Flowchart:** *(link here)*


# 🏠 RoomEase — Smart Property & Tenant Management System

## 📘 Project Description

**RoomEase** is a lightweight yet scalable property management system designed to help **small landlords, dorm managers, or boarding house owners** track tenants, payments, and room availability efficiently. The system addresses a common real-world challenge: most small property owners still rely on **manual logs, spreadsheets, or chat messages** to handle tenant data — a process prone to delays, confusion, and record inconsistencies.

RoomEase bridges this gap through a **Java-based backend** and a **Next.js (TypeScript) web interface**, providing a clear and responsive way to manage properties, track balances, and process maintenance requests.  
The **Java backend** handles file I/O, business logic, and optional offline storage, while the **Next.js frontend** offers a modern, responsive dashboard accessible from any device.  

Data synchronization is managed via a **RESTful API** built with **Spring Boot (Java)**, connecting seamlessly with a **NoSQL** database for flexible schema design. Users can log in as landlords or tenants — landlords can register tenants, view payment history, and mark rooms as occupied, while tenants can check balances, submit maintenance requests, and upload proof of payment.  

Future improvements could include automated rent reminders, payment gateway integration (e.g., PayMongo or Stripe), and real-time dashboards using WebSockets for instant updates. The system remains achievable within 4–5 weeks, yet holds **strong scalability and real-world relevance**, ideal for a student-led project with professional-grade potential.

---

## ⚙️ Tech Stack

| **Technology** | **Purpose** | **Why Use It** |
|----------------|-------------|----------------|
| **Java (Spring Boot)** | Backend API and business logic | Reliable, scalable, and widely used for enterprise-level RESTful services |
| **Next.js (TypeScript)** | Frontend web application | Provides a modern, performant UI with strong typing for maintainability |
| **MongoDB** | NoSQL database | Flexible schema design ideal for managing tenant, payment, and room data; integrates easily with Spring Boot |
| **Spring Data MongoDB** | Database interaction from Java backend | Simplifies database access and CRUD operations using repository patterns |
| **Axios / Fetch API** | Communication between frontend and backend | Streamlined API requests and error handling |
| **Docker (optional)** | Containerization | Simplifies deployment and ensures consistent development environment |
| **JWT (JSON Web Tokens)** | Authentication | Secure and stateless user sessions between Java and Next.js |
| **Maven / Gradle** | Java build and dependency management | Reliable and widely supported for Java projects |
| **Vercel** | Web deployment | Simple and free-tier hosting for Next.js apps |
| **Render** | Backend hosting | Easy and cost-effective cloud platform for deploying Spring Boot applications with MongoDB connectivity |

---

### 🧩 Summary
## 🌟 Key Features

### 🧩 1. Login and User Roles
- Users can login as **Landlords**.  
- Landlords can manage their dorm and assign tenants to rooms.  

**Tech Stack:** Next.js forms, MongoDB user storage.  

---

### 🏠 2. Room Management
- Add, edit, or remove rooms dynamically.  
- Each room shows real-time status: *Available* or *Occupied*.  
- Auto-syncs with tenant assignments and reservations.  

**Tech Stack:** Java CRUD logic, MongoDB, Next.js for interactive UI.  

---

### 📊 3. Dashboard Overview
- Landlords get a snapshot of total tenants, rooms, and active payments.  
- Tenants see their rent status and request history.  
- Clean data visualization with tables and charts.  

**Tech Stack:** Java backend summaries, Next.js frontend, charting with Chart.js or Recharts.  

---

### 📥 4. Excel Import Feature (Optional)
- Landlords can **drag and drop Excel files** to auto-create a **Dorm Profile**.  
- The system reads tenant and room data from Excel and imports it into the database.  
- Each imported file generates structured entries for rooms and tenants automatically.  

**Tech Stack:** Java Excel parsing (Apache POI), MongoDB storage, Next.js file upload.  

---

### 🧠 (Optional Add-on) Smart Excel Interpretation (AI-Assisted)
- AI interprets Excel files even if column names vary.  
- Automatically maps columns like “Name”, “Room”, and “Rent” using pattern recognition or NLP.  
- Removes the need for strict Excel formatting.  

**Implementation Concept:**  
- Rule-based keyword detection (Java regex + Apache POI).  
- Optional AI enhancement via Python microservice (Pandas + small ML model) for column mapping.  

---

### 🔐 5. Secure Data Handling
- Encrypted passwords and validated input on all forms.  
- MongoDB ensures reliable, secure, and flexible data storage.  
- Prevents duplicates and maintains data consistency across users.  

---

### 🌐 6. Accessible Anywhere
- Web-based system, no installation required.  
- Responsive design for desktop, tablet, and mobile.  
- Cloud-deployable with minimal setup.  

---

## 💡 Note on GCash & PayMongo Integration
Both **GCash** and **PayMongo** provide **free developer API access**, allowing seamless integration for testing and demonstration.  
You can:  
- Use **PayMongo’s sandbox API** for transaction testing.  
- Simulate **GCash payments** via mock endpoints for demo purposes.  

No paid setup is needed — only developer registration for API credentials.  
This makes the online payment feature fully implementable within the project scope.  

---

## 🧭 Summary
**RoomEase** is a complete, web-based dorm management system powered by **Java (backend)**, **Next.js (frontend)**, and **MongoDB (database)**.  
Its features include role-based login, room and payment management, maintenance requests, integrated GCash/PayMongo payments, dashboard summaries, and an optional **AI-powered Excel importer** — all deployable using current tools and free-tier services.  

RoomEase is a **Java + Next.js (TypeScript)** property management platform that helps small landlords digitalize their tenant tracking and billing workflow. It’s simple enough for two students to build in weeks, yet robust enough to scale into a **commercial-grade management tool** with payment integration, real-time updates, and analytics in future iterations.


## References

https://chatgpt.com/share/68e507d4-5cf0-8009-8fef-b19bda6cd767
https://chatgpt.com/share/68e507d4-5cf0-8009-8fef-b19bda6cd767 <br>
https://chatgpt.com/share/68e79488-2968-8009-9b2c-8bf8d1b0cfbd