# Student Account Management System using Spring Boot Framework

This is an API endpoints for a simple student account management system built with Spring Boot framework.

### Technical Stack:

* Database: PostgreSQL
* Backend: Spring Boot using Java
* ORM: Hibernate
* Project Management Tool: Maven


### Data Model:

* Student:

| Field     | Data Type  |
| :-------- | :--------- |
| `id`    | `integer` (auto-generated) |
| `name`    | `String` |
| `email`   | `String` |
| `dob`     | `LocalDate`|



## API Reference

### CRUD Operations on Student Account
#### Get All Students

```http
  GET /api/v1/student
```

Response Example:
```json
[
	{
		"id": 1,
		"name": "Meqdad",
		"email": "meqdad@mail.com",
		"dob": "2000-07-22",
		"age": 23
	},
	{
		"id": 2,
		"name": "Siwar",
		"email": "siwar@mail.com",
		"dob": "2005-06-07",
		"age": 18
	}
]
```

#### Add Student

```http
  POST /api/v1/student
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required** |
| `email`      | `String` | **Required** |
| `dob`      | `LocalDate` | **Required** |

Body Example:
```json
{
		"name": "Ahmad",
		"email": "ahmad@mail.com",
		"dob": "1998-05-13"
}
```


#### Delete Student

```http
  DELETE /api/v1/student/{studentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**. ID of student |

Example:
```http
  DELETE /api/v1/student/2
```

