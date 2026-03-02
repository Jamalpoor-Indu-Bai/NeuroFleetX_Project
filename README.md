# 📋 **NeuroFleet - Intelligent Fleet Management System**

## 👥 **Group Project**

**NeuroFleet** is a collaborative group project developed as part of [Group D] initiative. This comprehensive full-stack application showcases modern software development practices with contributions from multiple team members working together on different components of the system.

---

## 🎯 **Project Overview**

**NeuroFleet** is a comprehensive intelligent fleet management and ride-sharing platform built with modern cloud-native technologies. It combines real-time vehicle tracking, AI-powered ETA predictions, automated maintenance scheduling, and role-based user management to deliver an enterprise-grade transportation solution.

The system is designed for 4 user roles (Admin, Manager, Driver, Customer) with specialized dashboards and features tailored to each role's responsibilities. This project demonstrates collaborative development with clear separation of concerns across backend services, frontend interfaces, and AI/ML components.

---

## 🏗️ **Architecture Overview**

This is a **full-stack microservices application** with three main components:

```
NeuroFleet/
├── neurofleetbackkendD/          # Spring Boot Backend (Java)
├── neurofleetfrontend/           # React Frontend (JavaScript)
└── ai_service/                   # Flask AI Service (Python)
```

---

## 🛠️ **Tech Stack**

### **Backend (Spring Boot 3.4.11)**
- **Framework**: Spring Boot 3.4.11
- **Language**: Java 17
- **Database**: MySQL 8.0
- **ORM**: JPA/Hibernate
- **Security**: Spring Security + JWT Authentication
- **Real-time**: WebSocket + STOMP
- **APIs**: RESTful with comprehensive error handling
- **Build Tool**: Maven

**Key Dependencies:**
- Spring Web, Data JPA, Security
- MySQL Connector
- JWT (jjwt 0.11.5)
- WebSocket Support
- iTextPDF for report generation
- Apache Commons Math

### **Frontend (React 18.3)**
- **Framework**: React 18.3.1 with React Router 7.9
- **Styling**: Tailwind CSS + PostCSS
- **HTTP Client**: Axios 1.13.1
- **Real-time**: STOMP.js + SockJS
- **Charts**: Chart.js + react-chartjs-2
- **Maps**: Leaflet + react-leaflet
- **Build Tool**: Create React App with react-scripts 5.0

**Responsive UI Pages:**
- Landing Page, Welcome Page
- Login/Signup Pages
- Role-specific Dashboards (Admin, Manager, Driver, Customer)

### **AI Service (Flask 3.0.3)**
- **Framework**: Flask with CORS
- **ML Libraries**: scikit-learn, numpy, pandas
- **Models**: 
  - Random Forest Regressor (ETA Prediction)
  - Gradient Boosting Classifier
- **Model Persistence**: joblib
- **HTTP Client**: requests

---

## 📁 **Project Structure**

```
neurofleetbackkendD/
├── src/main/java/com/example/neurofleetbackkendD/
│   ├── NeurofleetbackkendDApplication.java     # Main Spring Boot App
│   ├── config/                                  # Configuration classes
│   │   └── DataInitializer.java                # Seed database
│   ├── controllers/                             # REST Controllers
│   │   ├── AdminDashboardController.java
│   │   ├── AuthController.java
│   │   ├── BookingController.java
│   │   ├── CustomerController.java
│   │   ├── DriverController.java
│   │   ├── ManagerController.java
│   │   ├── MaintenanceController.java
│   │   └── AIController.java
│   ├── dto/                                     # Data Transfer Objects
│   ├── model/                                   # JPA Entity Models
│   ├── repository/                              # Spring Data Repositories
│   ├── service/                                 # Business Logic Layer
│   ├── security/                                # JWT & Auth Config
│   └── resources/
│       └── application.properties               # App Configuration
│
neurofleetfrontend/
├── src/
│   ├── App.js                                   # Root React Component
│   ├── index.js                                 # Entry Point
│   ├── pages/                                   # Page Components
│   │   ├── LandingPage.js
│   │   ├── LoginPage.js
│   │   ├── SignupPage.js
│   │   ├── PortalSelectionPage.js
│   │   ├── AdminDashboard.js
│   │   ├── ManagerDashboard.js
│   │   ├── DriverDashboard.js
│   │   └── CustomerDashboard.js
│   ├── components/                              # Reusable Components
│   │   ├── Icons.js
│   │   └── Logo.js
│   ├── services/                                # API Integrations
│   │   ├── api.js                              # Axios Instance
│   │   ├── aiService.js
│   │   └── WebSocketService.js
│   ├── config/
│   │   └── constants.js
│   └── utils/
│       ├── chartConfig.js
│       └── initializeGPS.js
│
ai_service/
├── app.py                                       # Flask Application
├── requirements.txt                             # Python Dependencies
└── models/                                      # Trained ML Models
    ├── eta_model.pkl
    └── eta_scaler.pkl
```

---

## ✨ **Core Features**

### **1. Authentication & Authorization (JWT-based)**
- Secure login/signup with JWT tokens
- 4 user roles: Admin, Manager, Driver, Customer
- Role-based access control
- Token expiration: 24 hours

### **2. Real-time Vehicle Tracking**
- Live GPS location updates via WebSocket
- Interactive Leaflet maps
- Real-time driver location broadcast to managers

### **3. AI-Powered ETA Prediction**
- Haversine distance calculation
- Traffic pattern analysis (time-based)
- Vehicle health scoring impact
- Electric vehicle optimization
- Realistic speed calculations (Indian cities: 15-60 km/h based on traffic)

### **4. Smart Booking Management**
- Customer ride booking
- Automatic vehicle assignment
- Real-time booking status tracking
- Booking analytics

### **5. Maintenance Scheduling**
- Predictive maintenance using ML
- Health score tracking (0-100)
- Maintenance history & alerts
- Automated scheduling

### **6. Analytics & Reporting**
- Admin dashboard with KPIs
- Manager performance metrics
- Driver statistics
- Revenue tracking
- PDF report generation

### **7. Driver Management**
- Driver registration & verification
- City assignment logic
- Performance ratings
- Document storage

### **8. Customer Management**
- Profile management
- Booking history
- Payment tracking
- Rating & feedback system

---

## 🚀 **Getting Started**

### **Prerequisites**
- **Java 17** (JDK)
- **Node.js 16+** (npm)
- **Python 3.10+**
- **MySQL 8.0** (running on localhost:3306)
- **Git** for version control

### **Step 1: Clone the Repository**
```bash
git clone https://github.com/Jamalpoor-Indu-Bai/NeuroFleetX_Project.git
cd NeuroFleetX_Project
```

### **Step 2: Environment Variables Setup**
⚠️ **IMPORTANT**: Configure environment variables before running the project.

```bash
# Copy the example environment file
cp .env.example .env

# Edit .env with your actual credentials
# For Windows: notepad .env
# For Linux/Mac: nano .env
```

**Required Environment Variables in `.env`:**
```properties
# MySQL Database Configuration
DB_URL=jdbc:mysql://localhost:3306/fleetneuro?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
DB_USERNAME=your_mysql_username
DB_PASSWORD=your_mysql_password

# JWT Secret Key (change this for production)
JWT_SECRET=your_jwt_secret_key_minimum_32_characters

# Service Ports
BACKEND_PORT=8083
AI_SERVICE_URL=http://localhost:5000
```

### **Step 3: Database Setup**
```bash
# Create MySQL database
mysql -u your_username -p
> CREATE DATABASE fleetneuro;
> USE fleetneuro;
> exit;
```

### **Step 4: Backend Setup**
```bash
cd neurofleetbackkendD

# Build project
./mvnw clean install

# Start Spring Boot (uses environment variables from .env)
./mvnw spring-boot:run
# Server will start on Port: 8083
```

### **Step 5: Frontend Setup**
```bash
cd neurofleetfrontend

# Install dependencies
npm install

# Start React Dev Server (Port: 3000)
npm start
```

### **Step 6: AI Service Setup**
```bash
cd ai_service

# Install Python dependencies
pip install -r requirements.txt

# Start Flask (Port: 5000)
python app.py
```

### **✅ Verification**
After starting all services, verify they're running:
- **Frontend**: Open http://localhost:3000 in browser
- **Backend API**: Check http://localhost:8083/actuator/health
- **AI Service**: The terminal will show "Running on http://127.0.0.1:5000"

---

## 🌐 **Running the Project**

All services must run simultaneously in separate terminals:

```bash
# Terminal 1: Backend (Java Spring Boot)
cd neurofleetbackkendD
./mvnw spring-boot:run

# Terminal 2: Frontend (React)
cd neurofleetfrontend
npm start

# Terminal 3: AI Service (Python Flask)
cd ai_service
python app.py
```

**Access Points:**
- **Frontend**: http://localhost:3000
- **Backend API**: http://localhost:8083/api
- **AI Service**: http://localhost:5000

---

## 🔧 **Troubleshooting**

### **Issue: Backend fails to start - Database connection error**
**Solution:**
1. Ensure MySQL is running: `mysql -u your_username -p`
2. Verify `.env` file exists with correct `DB_USERNAME` and `DB_PASSWORD`
3. Check database exists: `CREATE DATABASE IF NOT EXISTS fleetneuro;`
4. Verify MySQL is on port 3306: `netstat -an | grep 3306`

### **Issue: "DB_USERNAME" or "DB_PASSWORD" not found**
**Solution:**
1. Create `.env` file in the root directory (copy from `.env.example`)
2. Fill in your actual MySQL credentials in `.env`
3. Do NOT commit `.env` to Git (it's in .gitignore)

### **Issue: Frontend can't connect to Backend**
**Solution:**
1. Ensure backend is running on port 8083
2. Check CORS configuration in Spring Boot
3. Verify `api.js` points to `http://localhost:8083/api`

### **Issue: AI Service fails to start**
**Solution:**
1. Install Python 3.10+: `python --version`
2. Install dependencies: `pip install -r requirements.txt`
3. If scikit-learn fails, try: `pip install --upgrade pip setuptools wheel`

### **Issue: Port already in use**
**Solution:**
```bash
# Windows - Kill process on port
netstat -ano | findstr :8083
taskkill /PID <process_id> /F

# Linux/Mac - Kill process on port
lsof -ti:8083 | xargs kill -9
```

### **Issue: Maven build fails**
**Solution:**
1. Ensure Java 17 is installed: `java -version`
2. Set JAVA_HOME environment variable
3. Try: `./mvnw clean install -U` (forces update)

---
- **AI Service**: http://localhost:5000

---

## 📡 **API Endpoints**

### **Authentication**
- `POST /api/auth/signup` - User registration
- `POST /api/auth/login` - User login (returns JWT)
- `POST /api/auth/validate-token` - Token validation

### **Admin Dashboard**
- `GET /api/admin/dashboard` - KPI metrics
- `GET /api/admin/bookings` - All bookings
- `GET /api/admin/users` - User management

### **Bookings**
- `POST /api/bookings/create` - Create new booking
- `GET /api/bookings/{id}` - Get booking details
- `PUT /api/bookings/{id}/status` - Update booking status
- `GET /api/bookings/user/{userId}` - User's bookings

### **Drivers**
- `POST /api/drivers/register` - Register driver
- `GET /api/drivers/{id}` - Driver details
- `PUT /api/drivers/{id}/location` - Update location (WebSocket)
- `GET /api/drivers/available` - Available drivers

### **Vehicles**
- `POST /api/vehicles/create` - Add vehicle
- `GET /api/vehicles/{id}` - Vehicle details
- `PUT /api/vehicles/{id}/health` - Update health score
- `GET /api/vehicles/available` - Available vehicles

### **Maintenance**
- `GET /api/maintenance/schedule` - Maintenance schedule
- `POST /api/maintenance/create` - Schedule maintenance
- `PUT /api/maintenance/{id}/complete` - Mark maintenance done

### **AI Service**
- `POST /api/ai/predict-eta` - Predict ETA for trip
- `POST /api/ai/recommend-vehicle` - Get vehicle recommendation
- `POST /api/ai/maintenance-predict` - Predict maintenance needs

---

## 🔐 **Security Features**

- **JWT Authentication** with 24-hour token expiration
- **CORS Configuration** for cross-origin requests
- **Spring Security** with role-based authorization
- **Password encryption** (Spring Security default)
- **API rate limiting**
- **Secure WebSocket** for real-time updates

---

## 📊 **Database Schema**

Key entities:
- **User**: Admin, Manager, Driver, Customer
- **Vehicle**: Fleet vehicles with health tracking
- **Booking**: Ride requests and completions
- **Driver**: Driver profiles with ratings
- **Maintenance**: Service history and schedules
- **Trip**: Trip details with coordinates

---

## ⚙️ **Configuration**

### **Backend Configuration (Environment Variables)**

The backend uses environment variables for sensitive data. Configure these in your `.env` file:

```properties
# Server Configuration
server.port=8083
ai.service.url=${AI_SERVICE_URL:http://localhost:5000}

# MySQL Database (from environment variables)
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JWT Configuration (from environment variables)
jwt.secret=${JWT_SECRET}
jwt.expiration=86400000  # 24 hours
```

**Security Note:** Never commit `.env` file with actual credentials to Git. Use `.env.example` as a template.

### **Frontend Environment Variables**

Create a `.env` file in the `neurofleetfrontend` directory:

```bash
REACT_APP_API_URL=http://localhost:8083/api
REACT_APP_WS_URL=ws://localhost:8083/ws
```

### **AI Service Configuration**

The AI service reads backend URL from environment:
```python
SPRING_BOOT_URL = os.getenv('BACKEND_URL', 'http://localhost:8083/api')
```

---

## 🤖 **AI Models**

### **ETA Predictor AI**
- Trained on historical booking data
- Features: distance, time, traffic, vehicle health, vehicle type
- Model: Random Forest Regressor (R² score tracking)
- Real-time predictions with confidence intervals

### **Vehicle Recommender AI**
- Gradient Boosting Classifier
- Recommends optimal vehicle based on trip requirements
- Considers: vehicle availability, health, location proximity

### **Maintenance Predictor AI**
- Predicts vehicle maintenance needs
- Based on usage patterns and health deterioration
- Proactive scheduling recommendations

---

## 📝 **State Management & Real-time Updates**

- **JWT** for authentication state
- **WebSocket (STOMP)** for:
  - Live driver location updates
  - Real-time booking status
  - Maintenance alerts
- **localStorage** for token persistence (frontend)
- **Spring Security Context** for server-side authorization

---

## 🐛 **Known Issues & Fixes**

- **JWT Secret**: Using hex-encoded key for compatibility (reverted from plaintext)
- **Deprecation Warnings**: MySQL8Dialect warnings (Hibernate 6.6) - can be suppressed
- **npm Vulnerabilities**: 30 packages with non-critical vulnerabilities (audit available)

---

## 👥 **User Roles & Permissions**

| Role | Access | Features |
|------|--------|----------|
| **Admin** | All | Dashboard, User Management, Analytics, Reports |
| **Manager** | Driver/Vehicle/Booking | Fleet Tracking, Analytics, Driver Performance |
| **Driver** | Own Profile | Ride Acceptance, Location Tracking, Earnings |
| **Customer** | Own Bookings | Book Rides, Track Driver, Rate Trips |

---

## 📄 **License**

MIT License © 2025 NeuroFleet Group D Development Team

---

## 🚀 **Deployment**

Ready for deployment to:
- **Docker** (containerization recommended)
- **AWS** (EC2, RDS, ECS)
- **Azure** (App Service, SQL Database)
- **GCP** (Compute Engine, CloudSQL)

---

## 📞 **Support & Documentation**

For detailed API documentation, run backend and visit:
- Swagger UI (if integrated)
- Developer logs at `logging.level.DEBUG`

For AI model training:
```bash
cd ai_service
python app.py --train  # Re-train models with latest data
```

---

## 👨‍💼 **Team & Contributors - Group D**

### **NeuroFleet Development Team**

This is a collaborative group project with contributions from multiple team members working together across different technology stacks:

#### **Backend Development (Java/Spring Boot)**
- Designing and implementing RESTful API architecture
- Database schema design and ORM integration with Hibernate
- Spring Security and JWT authentication system
- WebSocket configuration for real-time updates
- Business logic and service layer implementation

#### **Frontend Development (React/JavaScript)**
- Building responsive UI with Tailwind CSS
- Creating role-based dashboard interfaces (Admin, Manager, Driver, Customer)
- Real-time map integration with Leaflet
- Data visualization with Chart.js
- Authentication flow and state management

#### **AI/ML Service (Python/Flask)**
- Developing Machine Learning models (ETA prediction, vehicle recommendation)
- Model training pipeline with scikit-learn and Random Forest
- API integration for AI predictions
- Real-time inference service

#### **DevOps & Integration**
- MySQL database configuration and optimization
- Git workflow and version control management
- Cross-service communication setup
- Testing and debugging across all services

### **Collaborative Approach**
- Clear separation of concerns across microservices
- Full-stack development with modern technologies
- Real-time communication patterns (WebSocket)
- Machine learning integration with backend services
- Comprehensive testing and documentation

---

**Built with ❤️ by NeuroFleet Development Team - Group D**
