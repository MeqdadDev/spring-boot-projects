# Pokemon API using Spring Boot Framework

These are the API endpoints for Pokemon API built with the Spring Boot framework.

### Technical Stack:

* Database: PostgreSQL
* Backend: Spring Boot using Java
* ORM: Hibernate
* Project Management Tool: Maven
* Features:
	- Basic CRUD Operations
	- Pagination
	- Exception Handling
	- Authentication and Authorization (Spring Security with JWT)

### Data Models:

* Pokemon:

| Field     | Data Type  |
| :-------- | :--------- |
| `id`    | `integer` (auto-generated) |
| `name`    | `String` |
| `type`   | `String` |



## API Reference

### CRUD Operations on Pokemon

#### Get All Pokemons

```http
  GET /api/v1/pokemon?pageNo={PageNumber}&pageSize={PageSize}
```
_Default Values:_ `pageNo=0, pageSize=10`

Request Example:

```http
  GET /api/v1/pokemon?pageNo=0&pageSize=5
```

Response Example:
```json
{
	"content": [
		{
			"id": 1,
			"name": "Bulbasaur",
			"type": "Grass"
		},
		{
			"id": 2,
			"name": "Squirtle",
			"type": "Water"
		},
		{
			"id": 3,
			"name": "Pidgey",
			"type": "Earth"
		},
		{
			"id": 5,
			"name": "Squirtle 2",
			"type": "Water"
		},
		{
			"id": 6,
			"name": "Squirtle 3",
			"type": "Water"
		}
	],
	"pageNo": 0,
	"pageSize": 5,
	"totalElements": 11,
	"totalPages": 3,
	"last": false
}
```

#### Add Pokemon


```http
  POST /api/v1/pokemon
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required** |
| `type`      | `String` | **Required** |

Body Example:

```json
{
	"name": "Pikachu",
	"type": "Electric"
}
```


#### Update Pokemon

```http
  PUT /api/v1/pokemon/{pokemonId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `String` | **Required**  |
| `type`      | `integer` | **Required** |

Request Example:

```http
  PUT /api/v1/pokemon/3
```

Body Example:
```json
{
	"name": "Pidgey",
	"type": "Earth"
}
```

#### Delete Pokemon

```http
  DELETE /api/v1/pokemon/{pokemonId}
```

Request Example:

```http
  DELETE /api/v1/pokemon/4
```

---------------------

### CRUD Operations on Review


#### Get Reviews for a Pokemon

```http
  GET /api/v1/pokemon/{pokemonId}/review
```

Request Example:

```http
  GET /api/v1/pokemon/2/reviews
```

Response Example:
```json
[
	{
		"id": 3,
		"title": "best review",
		"content": "it is the best pokemon ever",
		"stars": 5
	}
]
```

#### Add Review

```http
  POST /api/v1/pokemon/{pokemonId}/review
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `title`      | `String`  | **Required**  |
| `content`    | `String`  | **Required** |
| `stars`      | `integer` | **Required** |


Body Example:
```json
{
	"title": "bad review",
	"content": "worst pokemon ever",
	"stars": 1
}
```

Request Example:

```http
  POST /api/v1/pokemon/1/review
```


#### Get a Specific Review

```http
  GET /api/v1/pokemon/{pokemonId}/reviews/{reviewId}
```

Request Example:

```http
  GET /api/v1/pokemon/1/reviews/1
```

Response Example:

```json
{
	"id": 1,
	"title": "normal review",
	"content": "it is a normal pokemon, overrated",
	"stars": 3
}
```

#### Update Review

```http
  PUT /api/v1/pokemon/{pokemonId}/reviews/{reviewId}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `title`      | `String`  | **Required** |
| `content`    | `String`  | **Required** |
| `stars`      | `integer` | **Required** |


Body Example:

```json
{
	"title": "best review",
	"content": "best pokemon ever",
	"stars": 5
}
```

Request Example:

```http
  PUT /api/v1/pokemon/1/reviews/2
```

#### Delete Review

```http
  DELETE /api/v1/pokemon/{pokemonId}/reviews/{reviewId}
```

Request Example:
```http
  DELETE /api/v1/pokemon/2/reviews/3
```

---------------------

### Authentication and JWT

#### Register User

```http
  POST /api/v1/auth/register
```
