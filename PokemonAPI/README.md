# Pokemon API using Spring Boot Framework

These are the API endpoints for Pokemon API built with the Spring Boot framework.

### Technical Stack:

* Database: PostgreSQL
* Backend: Spring Boot using Java
* ORM: Hibernate
* Project Management Tool: Maven


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
  GET /api/v1/pokemon
```

Response Example:
```json
[
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
	}
]
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

Examples:

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

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `integer` | **Required** |

Example:
```http
  DELETE /api/v1/pokemon/4
```

