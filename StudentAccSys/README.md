# Student Account Management System using Spring Boot Framework

These are the API endpoints for a simple student account management system built with the Spring Boot framework.

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


#### Update Student

```http
  PUT /api/v1/student/{studentId}?name={NewName}
```

```http
  PUT /api/v1/student/{studentId}?email={newEmail}
```

```http
  PUT /api/v1/student/{studentId}?name={NewName}&email={newEmail}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**  |
| `name`      | `String` | **Optional**   |
| `email`      | `String` | **Optional**   |

Examples:

```http
  PUT /api/v1/student/3?name=Noor
```

```http
  PUT /api/v1/student/3?email=nooooor@mail.com
```

```http
  PUT /api/v1/student/3?name=Noor&email=nooooor@mail.com
```

#### Delete Student

```http
  DELETE /api/v1/student/{studentId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required**  |

Example:
```http
  DELETE /api/v1/student/2
```

