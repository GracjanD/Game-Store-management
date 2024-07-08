# Game Store management application

## Opis projektu
GameStore management to prosta aplikacja REST. Łączy się ona z bazą danych **MySQL** i wykonuje na niej operacje. Utworzyłem dwa serwisy, z których jeden korzysta z **JpaRepository** do tworzenia prostych operacji **CRUD**. Drugi korzysta z **EntityManagera** który pozwala na bardziej dowolne operacje. Dodałem również **globalną obsługę wyjątków**, dzięki czemu po wykonaniu zapytań wyświetla się określony status serwera oraz komunikat. Dodałem również **testy jednostkowe** dla operacji findAll() i findById(long id).

### Endpointy dla metod korzystających z JpaRepository:
| Metoda | Endpoint | Opis |
|------- | -------- | ---- |
| GET    | /api/games   | Wyświetla wszystkie gry |
| GET    | /api/games/{id}   | Wyświetla grę o podanym id |
| POST   | /api/games   | Tworzy nową grę na podstawie przekazanego obiektu |
| PUT    | /api/games   | Aktualizuje grę na podstawie przekazanego obiektu |
| DELETE | /api/games   | Usuwa wszystkie gry |
| DELETE | /api/games{id}   | Usuwa grę o podanym id |

### Endpointy dla metod korzystających z EntityManagera:
| Metoda | Endpoint | Opis |
|------- | -------- | ---- |
| GET    | /dao/games   | Wyświetla wszystkie gry |
| GET    | /dao/games/platform/{platform}   | Wyświetla gry na podstawie podanej platformy |
| GET    | /dao/games/{id}   | Wyświetla grę o podanym id |
| POST   | /dao/games   | Tworzy nową grę na podstawie przekazanego obiektu |
| PUT    | /dao/games   | Aktualizuje grę na podstawie przekazanego obiektu |
| DELETE | /dao/games   | Usuwa wszystkie gry |
| DELETE | /dao/games{id}   | Usuwa grę o podanym id |

### Zależności:
- Spring Data JPA
- MySQL Driver
- Spring Boot DevTools
- Spring Web