# Copilot Instructions for Course Management System

## Project Overview
This is a course management system for educational institutions. The project appears to be in early stages of development.

## Getting Started
Since this is a new project, consider the typical architecture for course management systems:

### Core Components (To Be Developed)
- **User Management**: Students, instructors, administrators with role-based access
- **Course Catalog**: Course creation, scheduling, and enrollment
- **Content Management**: Lessons, assignments, resources
- **Assessment System**: Quizzes, tests, grading workflows
- **Communication**: Announcements, messaging, discussions

## Development Guidelines

### Recommended Project Structure
```
/
├── backend/              # API server and business logic
├── frontend/            # User interface (web/mobile)
├── database/           # Schema, migrations, seeds
├── shared/             # Common types, utilities
├── docs/              # Documentation
└── tests/             # Test suites
```

### Technology Stack Considerations
- **Backend**: Consider Node.js/Express, Python/Django, or Java/Spring
- **Database**: PostgreSQL for relational data, Redis for caching
- **Frontend**: React, Vue, or Angular for web interface
- **Authentication**: JWT tokens or OAuth integration
- **File Storage**: Cloud storage for course materials

### Key Patterns to Establish
- **API Design**: RESTful endpoints with consistent naming
- **Database**: Normalized schema with proper foreign keys
- **Security**: Input validation, authentication middleware
- **Error Handling**: Consistent error response format
- **Logging**: Structured logging for monitoring

### Development Workflow
1. Set up development environment with Docker/docker-compose
2. Implement database schema and migrations
3. Create API endpoints with proper testing
4. Build frontend components with responsive design
5. Add authentication and authorization

## Best Practices for This Project
- Use TypeScript for better type safety
- Implement proper data validation on both client and server
- Follow accessibility guidelines for educational software
- Consider internationalization for multi-language support
- Implement proper backup and recovery procedures

## Testing Strategy
- Unit tests for business logic
- Integration tests for API endpoints
- End-to-end tests for critical user workflows
- Performance tests for enrollment periods

## Security Considerations
- Protect student data according to FERPA/GDPR requirements
- Implement role-based access control
- Secure file upload and storage
- Regular security audits and dependency updates

---

*This file should be updated as the project architecture and patterns emerge during development.*