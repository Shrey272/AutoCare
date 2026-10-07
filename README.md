# AutoCare - Vehicle Service & Management System

AutoCare is a Java EE web application built with JSP, Servlets, and MySQL for managing vehicle service bookings, customer records, mechanic assignments, and billing.

---

## 🚀 Live Hosting Deployment (Railway / Render)

This repository includes a `Dockerfile` and `docker-compose.yml` for 1-click cloud deployment.

### Option 1: Railway (Recommended)

1. Sign up / Log in to [Railway.app](https://railway.app/).
2. Click **New Project** → **Provision MySQL**.
   - Note down the connection variables or use Railway's default MySQL service.
   - Run the SQL statements from [`database.sql`](./database.sql) in the Railway database Query Editor.
3. In the same project, click **New** → **GitHub Repo** → select this repo.
4. Go to the web service's **Variables** tab and set:
   - `DB_HOST`: `${{MySQL.MYSQLHOST}}`
   - `DB_PORT`: `${{MySQL.MYSQLPORT}}`
   - `DB_NAME`: `${{MySQL.MYSQLDATABASE}}`
   - `DB_USER`: `${{MySQL.MYSQLUSER}}`
   - `DB_PASSWORD`: `${{MySQL.MYSQLPASSWORD}}`
5. Railway will automatically build the `Dockerfile` and provide a public HTTPS URL.

### Option 2: Render

1. Create a free MySQL database on [Aiven](https://aiven.io/) or [Railway](https://railway.app/) and import [`database.sql`](./database.sql).
2. On [Render.com](https://render.com/), create a **New Web Service** connected to this GitHub repo.
3. Select **Docker** environment.
4. Add the environment variables:
   - `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD` (or `DB_URL`).
5. Render deploys your application on a live HTTPS URL.

---

## 🐳 Run Locally with Docker Compose

To start both the web application and MySQL database locally:

```bash
docker-compose up --build
```

Access the app at:
- `http://localhost:8080/AutoCare/` (or simply `http://localhost:8080/`)

---

## 🛠 Local Development (NetBeans & GlassFish)

- **IDE:** NetBeans 8.2+
- **Server:** GlassFish 4.1.1 (or Apache Tomcat 9)
- **Database:** MySQL 8.0 on port `3306` with database `autocare_db`

---

## 🔑 Default Admin Credentials

- **Username:** `admin`
- **Password:** `admin123`
