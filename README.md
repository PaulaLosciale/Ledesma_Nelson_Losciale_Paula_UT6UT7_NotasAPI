API REST de Usuarios y Notas - UT6 y UT7 - Nelson Ledesma y Paula Losciale

API REST que permite gestionar usuarios y sus notas de forma persistente usando JPA.

Estructura del proyecto

```
com/appnelsonpaula/notasapi/
├── controller/
│   ├── v1/
│   │   ├── NotaController.java
│   │   └── UsuarioController.java
│   ├── v2/
│   │   └── UsuarioController.java
│   └── GlobalExceptionHandler.java
├── model/
│   ├── NotaModel.java
│   └── UsuarioModel.java
├── repository/
│   ├── NotaRepository.java
│   └── UsuarioRepository.java
├── service/
│   ├── AbstractCrudService.java
│   ├── CrudService.java
│   ├── NotaService.java
│   ├── NotaServiceImpl.java
│   ├── UsuarioService.java
│   └── UsuarioServiceImpl.java
└── NotasapiApplication.java
```

La API estará disponible en: `http://localhost:8080`

Endpoints de la API

Usuarios V1 (`/api/v1/usuarios`)
- `GET /usuarios` - Obtener todos los usuarios
- `GET /usuarios/{id}` - Obtener usuario por ID
- `POST /usuarios` - Crear nuevo usuario
- `PUT /usuarios/{id}` - Actualizar usuario
- `DELETE /usuarios/{id}` - Eliminar usuario (y sus notas)

Notas V1 (`/api/v1/notas`)
- `GET /notas` - Obtener todas las notas
- `GET /notas?usuarioId={id}` - Filtrar notas por usuario
- `GET /notas?usuarioId={id}&order=desc` - Notas ordenadas por fecha
- `GET /notas/{id}` - Obtener nota por ID
- `POST /notas?usuarioId={id}` - Crear nueva nota
- `PUT /notas/{id}` - Actualizar nota
- `DELETE /notas/{id}` - Eliminar nota

Usuarios V2 (`/api/v2`)
- `POST /sign-in` - Registro de usuario
