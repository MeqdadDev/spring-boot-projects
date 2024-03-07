# Todo API using Spring Boot Framework

These are the API endpoints for Todo API built with the Spring Boot framework.

### Technical Stack:

* Database: MongoDB
* Backend: Spring Boot using Java
* ORM: Spring JPA
* Project Management Tool: Maven
* Features:
	- Basic CRUD Operations
	- Exception Handling
	- Unit Testing

### Data Models:

* Todo:

| Field        | Data Type  |
| :------------| :--------- |
| `id`         | `String` (auto-generated) |
| `title`      | `String` |
| `description`| `String` |
| `timestamp`  | `long` (auto-generated)    |



## API Reference

### CRUD Operations on Todos

#### Get All Todos

```http
  GET {localhost:port}/api/v1/todos
```

Response Example:
```json
[
	{
		"id": "65cbcdb68531dd7db3fe4fa0",
		"title": "Read Daily Part of Quran",
		"description": "Surat Al-Kahf",
		"timestamp": 1707855286653
	},
	{
		"id": "65cbcde88531dd7db3fe4fa1",
		"title": "Problem Solving",
		"description": "Solve a problem about queues data structure",
		"timestamp": 1707855336956
	},
	{
		"id": "65d8aa62d6535f0ac5d86f49",
		"title": "Study Advanced Microservices Course",
		"description": "Learn how to migrate from Monolothic Arch. to Microservices",
		"timestamp": 1708698210321
	}
]
```

...:::Next details will be added ASAP:::...