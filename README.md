# 🔐 Spring Security OAuth2 Login

A Spring Boot application demonstrating **OAuth2 social login** with **Google** and **GitHub** as identity providers, using Spring Security's built-in OAuth2 client support.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [1. Clone the Repository](#1-clone-the-repository)
  - [2. Configure OAuth2 Credentials](#2-configure-oauth2-credentials)
  - [3. Build & Run](#3-build--run)
- [API Endpoints](#api-endpoints)
- [How It Works](#how-it-works)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

This project showcases how to integrate **OAuth2 login** into a Spring Boot application. Instead of managing usernames and passwords, users authenticate via their existing **Google** or **GitHub** accounts. Spring Security handles the entire OAuth2 authorization code flow under the hood.

---

## Tech Stack

| Technology | Version | Purpose |
|---|---|---|
| **Java** | 17 | Programming language |
| **Spring Boot** | 4.1.0 | Application framework |
| **Spring Security OAuth2 Client** | — | OAuth2 / social login |
| **Spring Web MVC** | — | REST controllers |
| **Gradle** | Wrapper | Build tool |
| **JUnit 5** | — | Testing framework |

---

## Project Structure

```
SpringSecurityOAuth/
├── src/
│   ├── main/
│   │   ├── java/com/jai/SpringSecurityOAuth/
│   │   │   ├── SpringSecurityOAuthApplication.java   # Main entry point
│   │   │   ├── Controller/
│   │   │   │   └── HelloController.java              # REST controller
│   │   │   └── Security/
│   │   │       └── SecurityConfig.java               # Security configuration
│   │   └── resources/
│   │       ├── application.properties                 # OAuth2 client config
│   │       ├── static/                                # Static assets
│   │       └── templates/                             # View templates
│   └── test/                                          # Unit & integration tests
├── build.gradle                                       # Gradle build config
├── settings.gradle
├── gradlew / gradlew.bat                              # Gradle wrapper scripts
└── README.md
```

---

## Prerequisites

- **Java 17** or higher
- **Google OAuth2 credentials** (Client ID & Client Secret)
- **GitHub OAuth2 credentials** (Client ID & Client Secret)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/jayakrishna9655/SpringSecurityOAuth2.git
cd SpringSecurityOAuth2
```

### 2. Configure OAuth2 Credentials

#### Google Setup

1. Go to the [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project (or select an existing one)
3. Navigate to **APIs & Services → Credentials**
4. Click **Create Credentials → OAuth 2.0 Client ID**
5. Set **Authorized redirect URI** to:
   ```
   http://localhost:8080/login/oauth2/code/google
   ```
6. Copy the **Client ID** and **Client Secret**

#### GitHub Setup

1. Go to [GitHub Developer Settings](https://github.com/settings/developers)
2. Click **New OAuth App**
3. Set **Authorization callback URL** to:
   ```
   http://localhost:8080/login/oauth2/code/github
   ```
4. Copy the **Client ID** and **Client Secret**

#### Update Configuration

Edit `src/main/resources/application.properties` and replace the placeholder values:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET

spring.security.oauth2.client.registration.github.client-id=YOUR_GITHUB_CLIENT_ID
spring.security.oauth2.client.registration.github.client-secret=YOUR_GITHUB_CLIENT_SECRET
```

> ⚠️ **Security Tip:** Never commit real credentials. Use environment variables or a `.env` file excluded via `.gitignore`.

### 3. Build & Run

#### Using Gradle Wrapper

```bash
# Build the project
./gradlew build

# Run the application
./gradlew bootRun
```

#### On Windows

```cmd
gradlew.bat build
gradlew.bat bootRun
```

The application will start at **http://localhost:8080**

---

## API Endpoints

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| `GET` | `/` | Welcome page — returns greeting message | ✅ Yes |
| `GET` | `/login` | Spring Security auto-generated login page with OAuth2 provider options | ❌ No |

---

## How It Works

```
┌──────────┐       ┌──────────────┐       ┌─────────────────┐
│  Browser  │──────▶│  Spring Boot  │──────▶│  Google/GitHub   │
│  (User)   │◀──────│  Application  │◀──────│  OAuth2 Server   │
└──────────┘       └──────────────┘       └─────────────────┘
```

1. **User** visits a protected endpoint (e.g., `/`)
2. **Spring Security** redirects to `/login`, showing available OAuth2 providers
3. **User** clicks "Google" or "GitHub"
4. **Browser** redirects to the provider's authorization page
5. **User** grants consent
6. **Provider** redirects back with an authorization code
7. **Spring Security** exchanges the code for an access token
8. **User** is authenticated and gains access to the protected resource

### Key Components

- **`SecurityConfig`** — Configures the `SecurityFilterChain` to require authentication on all requests and enables OAuth2 login with default settings
- **`HelloController`** — A simple REST controller that serves the root endpoint (`/`)
- **`application.properties`** — Holds the OAuth2 client registration details for Google and GitHub

---

## Screenshots

> 🖼️ _After running the app, visit `http://localhost:8080` — you'll be redirected to a login page with **Google** and **GitHub** options._

---

## Contributing

Contributions are welcome! To contribute:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

---

## License

This project is open source and available for educational purposes.

---

<p align="center">
  Made with ❤️ by <a href="https://github.com/jayakrishna9655">Jaya Krishna</a>
</p>
