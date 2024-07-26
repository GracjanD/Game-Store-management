# GAME STORE MANAGEMENT

## DESCRIPTION
GameStore management is a simple REST application. It connects to a **MySQL** database and performs operations on it. I have created two services, where one of them uses **JpaRepository** to perform basic **CRUD** operations. Second service uses **EntityManager** to allow for more custom operations. I have also added **global exception handling**, which shows specific server status and message after requests are completed. Additionally, I have added **unit tests** for findAll() and findById(long id) methods. Application also uses **Spring Security** to allow users with specific roles to use endpoints. For example: user with the EMPLOYEE role can perform GET operations to display games but can not perform DELETE operations.    

### Endpoints for methods using JpaRepository:
| Method | Endpoint | Description |
|------- | -------- | ----------- |
| GET    | /api/games   | Displays all games |
| GET    | /api/games/{id}   | Displays the game with the given id |
| POST   | /api/games   | Creates a new game based on the given object |
| PUT    | /api/games   | Updates the game based on the given object |
| DELETE | /api/games   | Deletes all games |
| DELETE | /api/games{id}   | Deletes game with the given id |

### Endpoints for methods using EntityManager:
| Method | Endpoint | Description |
|------- | -------- | ----------- |
| GET    | /dao/games   | Displays all games |
| GET    | /dao/games/platform/{platform}   | Displays all games based on the given platform |
| GET    | /dao/games/{id}   | Displays the game with the given id |
| POST   | /dao/games   | Creates a new game based on the given object |
| PUT    | /dao/games   | Updates the game based on the given object |
| DELETE | /dao/games   | Deletes all games |
| DELETE | /dao/games{id}   | Deletes game with the given id |

### Dependencies:
- Spring Data JPA
- MySQL Driver
- Spring Boot DevTools
- Spring Web
- Spring Security
