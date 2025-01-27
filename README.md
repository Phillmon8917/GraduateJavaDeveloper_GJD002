# Waste Sorting Mobile Application Backend

This project provides a backend API for a waste sorting mobile application, enabling data exchange between the frontend and backend. The backend is designed to manage waste categories, disposal guidelines, and recycling tips, promoting sustainable waste management practices.

---

## Defined Resource URIs, Methods, and Error Handling

1. **Resource URIs and Request Methods**
    - The backend defines clear and meaningful resource URIs for managing waste categories, disposal guidelines, and recycling tips.
    - It uses RESTful principles, including `GET`, `POST`, `PUT`, and `DELETE` methods, to handle operations such as retrieving, creating, updating, and deleting resources.

2. **Request and Response Payloads**
    - Data exchanged between the client and server is structured in JSON format to ensure consistency and readability.
    - The payloads are validated to ensure data integrity before being processed by the backend.

3. ## Error Handling Mechanisms

The backend uses **custom error messages** to provide clear and user-friendly responses:
- **Validation Errors (400)**: Returns detailed messages for invalid input fields (e.g., `"name": "Category name is mandatory"`).
- **Resource Not Found (404)**: Sends specific messages like `"WasteCategory not found with ID: 5"`.

This ensures meaningful feedback for developers and users while adhering to RESTful standards.

