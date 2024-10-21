Aquí tienes la estimación del **Sprint 1** para la **web de listado de profesores**. Usaré la técnica de **estimación en puntos de historia** para medir la complejidad y el esfuerzo relativo de cada tarea.

---

### **Sprint Backlog del Proyecto de Listado de Profesores - Estimación**

| **Historia de Usuario (User Story)**        | **Tarea**                                                                                           | **Puntos de Historia** |
|---------------------------------------------|-----------------------------------------------------------------------------------------------------|------------------------|
| **ID 001 - Registro de administrador con email y contraseña**   | Crear página de registro (UI).                                                                       | 3                      |
|                                             | Validar campos de email y contraseña.                                                               | 2                      |
|                                             | Crear lógica backend para registrar un administrador en la base de datos.                           | 3                      |
|                                             | Implementar seguridad (cifrado de contraseña).                                                      | 2                      |
| **Total estimado (Registro de administrador)**    |                                                                                                     | **10**                 |
| **ID 002 - Inicio de sesión del administrador**       | Crear página de inicio de sesión (UI).                                                               | 2                      |
|                                             | Implementar lógica backend para autenticación del administrador.                                    | 3                      |
|                                             | Gestionar tokens de sesión (JWT o similar).                                                         | 3                      |
|                                             | Redirigir al administrador al panel de control tras iniciar sesión.                                  | 2                      |
| **Total estimado (Inicio de sesión)**       |                                                                                                     | **10**                 |
| **ID 008 - Visualización de lista de profesores**     | Crear la interfaz básica para listar a los profesores.                                               | 3                      |
|                                             | Implementar lógica backend para obtener la lista de profesores desde la base de datos.               | 3                      |
|                                             | Crear el diseño responsivo para la lista de profesores.                                              | 2                      |
| **Total estimado (Listado de profesores)**  |                                                                                                     | **8**                  |
| **ID 009 - Búsqueda de profesores por nombre**   | Implementar barra de búsqueda en la página de listado de profesores.                                 | 2                      |
|                                             | Lógica para filtrar la lista de profesores por nombre.                                               | 3                      |
|                                             | Optimizar búsqueda para obtener resultados en tiempo real o al enviar el formulario.                 | 3                      |
| **Total estimado (Búsqueda de profesores)** |                                                                                                     | **8**                  |

---

### **Total estimado para el Sprint 1 de la web de profesores**  
Sumando todos los puntos de historia:

- **ID 001**: 10 puntos.
- **ID 002**: 10 puntos.
- **ID 008**: 8 puntos.
- **ID 009**: 8 puntos.

---

### **Total del Sprint 1**:  
**36 puntos de historia**

---

### **Capacidad del equipo**:  
- **Estimación del sprint**: Para un equipo con experiencia promedio, completar entre 20 y 30 puntos de historia por sprint de dos semanas es razonable.
- **Recomendación**: Si el equipo es nuevo en la tecnología o proyecto, podrían enfocarse en las historias más prioritarias (como la autenticación y la visualización de profesores) y ajustar los puntos en el siguiente sprint.
