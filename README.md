# 📧 Email Sender Application

A simple Spring Boot application that provides a web interface for sending emails through Gmail SMTP. This application features a clean, responsive frontend and a RESTful backend API.

## 🚀 Features

- **Web Interface**: Simple and intuitive HTML form for composing emails
- **REST API**: RESTful endpoints for programmatic email sending
- **Gmail Integration**: Configured to work with Gmail SMTP
- **Responsive Design**: Mobile-friendly interface
- **Real-time Feedback**: Success/error messages for user actions

## 🛠️ Technologies Used

- **Backend**: Spring Boot 3.5.5
- **Java Version**: 21
- **Email**: Spring Boot Mail Starter
- **Frontend**: HTML5, CSS3, JavaScript (Vanilla)
- **Build Tool**: Maven

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 21 or higher installed
- Maven 3.6+ installed
- A Gmail account with App Password enabled

## ⚙️ Gmail Setup

1. **Enable 2-Factor Authentication** on your Gmail account
2. **Generate an App Password**:
   - Go to Google Account settings
   - Security → 2-Step Verification → App passwords
   - Generate a new app password for "Mail"
3. **Update Configuration**:
   - Edit `src/main/resources/application.properties`
   - Replace the username and password with your credentials

## 🚦 Installation & Running

### 1. Clone the Repository
```bash
git clone <your-repository-url>
cd emailsender
```

### 2. Configure Email Settings
Edit `src/main/resources/application.properties`:
```properties
spring.application.name=emailsender
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

### 3. Build and Run
```bash
# Build the project
mvn clean compile

# Run the application
mvn spring-boot:run
```

### 4. Access the Application
- **Web Interface**: Open your browser and go to `http://localhost:8080`
- **API Health Check**: `http://localhost:8080/api/health`

## 🌐 API Endpoints

### Send Email
**POST** `/api/send-email`

**Request Body:**
```json
{
  "to": "recipient@example.com",
  "subject": "Your Subject",
  "body": "Your email message content"
}
```

**Response:**
- **200 OK**: "Email sent successfully!"
- **500 Error**: "Failed to send email: [error message]"

### Health Check
**GET** `/api/health`

**Response:**
- **200 OK**: "Email service is running!"

## 💻 Usage

### Web Interface
1. Open `http://localhost:8080` in your browser
2. Fill in the email form:
   - **To**: Recipient's email address
   - **Subject**: Email subject line
   - **Message**: Email content
3. Click "Send Email"
4. Wait for confirmation message

### API Usage (curl example)
```bash
curl -X POST http://localhost:8080/api/send-email \
  -H "Content-Type: application/json" \
  -d '{
    "to": "recipient@example.com",
    "subject": "Test Email",
    "body": "This is a test email sent via API"
  }'
```

## 📁 Project Structure

```
emailsender/
├── src/
│   ├── main/
│   │   ├── java/com/emailsender/emailsender/
│   │   │   ├── EmailsenderApplication.java    # Main application class
│   │   │   ├── EmailController.java           # REST controller
│   │   │   ├── EmailRequest.java              # DTO for email requests
│   │   │   └── EmailSender.java               # Email service
│   │   └── resources/
│   │       ├── application.properties         # Configuration
│   │       └── static/
│   │           └── index.html                 # Frontend interface
│   └── test/                                  # Test files
├── pom.xml                                    # Maven dependencies
└── README.md                                  # This file
```

## 🔧 Configuration

### Application Properties
| Property | Description | Default |
|----------|-------------|---------|
| `spring.mail.host` | SMTP server host | smtp.gmail.com |
| `spring.mail.port` | SMTP server port | 587 |
| `spring.mail.username` | Your email address | - |
| `spring.mail.password` | Your app password | - |
| `spring.mail.properties.mail.smtp.auth` | Enable SMTP authentication | true |
| `spring.mail.properties.mail.smtp.starttls.enable` | Enable TLS | true |

## 🚨 Security Notes

- **Never commit credentials** to version control
- Use environment variables for production:
  ```bash
  export SPRING_MAIL_USERNAME=your-email@gmail.com
  export SPRING_MAIL_PASSWORD=your-app-password
  ```
- Consider using Spring Profiles for different environments

## 🐛 Troubleshooting

### Common Issues

1. **"Authentication failed"**
   - Ensure 2FA is enabled on Gmail
   - Use App Password, not regular password
   - Check username/password in properties file

2. **"Connection refused"**
   - Check internet connection
   - Verify SMTP settings
   - Ensure port 587 is not blocked

3. **"Invalid recipient"**
   - Verify email address format
   - Check for typos in recipient address

### Logs
Check application logs for detailed error messages:
```bash
mvn spring-boot:run
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 📞 Support

If you encounter any issues or have questions, please:
1. Check the troubleshooting section above
2. Review the [Spring Boot Mail documentation](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.email)
3. Open an issue in this repository

## 🎯 Future Enhancements

- [ ] File attachment support
- [ ] HTML email templates
- [ ] Email queue management
- [ ] Multiple email providers support
- [ ] Email scheduling
- [ ] User authentication
- [ ] Email templates management

---

**Made with ❤️ using Spring Boot**
