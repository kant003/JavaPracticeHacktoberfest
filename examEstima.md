Para hacer la estimación del **Sprint 1** del **proyecto de chat**, usaremos la técnica de **estimación en puntos de historia** (Story Points), que mide la complejidad y esfuerzo relativo de cada tarea.

---

### **Sprint Backlog del Proyecto de Chat - Estimación**

| **Historia de Usuario (User Story)**        | **Tarea**                                                                                           | **Puntos de Historia** |
|---------------------------------------------|-----------------------------------------------------------------------------------------------------|------------------------|
| **ID 001 - Registro de usuario con email y contraseña**   | Crear página de registro (UI).                                                                       | 3                      |
|                                             | Validar campos de email y contraseña.                                                               | 2                      |
|                                             | Crear lógica backend para registrar un nuevo usuario en la base de datos.                           | 3                      |
|                                             | Implementar seguridad (cifrado de contraseña).                                                      | 2                      |
| **Total estimado (Registro de usuario)**    |                                                                                                     | **10**                 |
| **ID 002 - Inicio de sesión con email y contraseña**       | Crear página de inicio de sesión (UI).                                                               | 2                      |
|                                             | Implementar lógica backend para autenticación.                                                      | 3                      |
|                                             | Gestión de tokens de sesión (JWT o similar).                                                        | 3                      |
|                                             | Redirigir al usuario al chat tras iniciar sesión correctamente.                                     | 2                      |
| **Total estimado (Inicio de sesión)**       |                                                                                                     | **10**                 |
| **ID 003 - Recuperación de contraseña**     | Crear página de recuperación de contraseña (UI).                                                    | 2                      |
|                                             | Validación de email en el backend.                                                                  | 2                      |
|                                             | Implementar lógica de envío de correo de recuperación.                                               | 3                      |
|                                             | Crear sistema de cambio de contraseña segura.                                                       | 3                      |
| **Total estimado (Recuperación de contraseña)** |                                                                                                     | **10**                 |
| **ID 004 - Edición de perfil**              | Crear página de edición de perfil (UI).                                                             | 3                      |
|                                             | Lógica para actualizar nombre de usuario y cargar/actualizar la imagen de perfil.                    | 3                      |
|                                             | Implementar API en el backend para la actualización de perfil en la base de datos.                   | 3                      |
| **Total estimado (Edición de perfil)**      |                                                                                                     | **9**                  |
| **ID 011 - Enviar y recibir mensajes en tiempo real** | Configurar WebSockets para la comunicación en tiempo real.                                           | 5                      |
|                                             | Implementar lógica backend para recibir y distribuir mensajes.                                       | 5                      |
|                                             | Crear la interfaz de chat básica (UI) con input para enviar mensajes.                                | 3                      |
|                                             | Verificar que los mensajes se muestran en tiempo real en ambas partes.                               | 3                      |
| **Total estimado (Mensajes en tiempo real)** |                                                                                                     | **16**                 |
| **ID 017 - Notificaciones push para nuevos mensajes** | Integrar servicio de notificaciones push.                                                           | 5                      |
|                                             | Implementar notificaciones para mensajes entrantes.                                                  | 3                      |
|                                             | Verificar que las notificaciones aparecen en el dispositivo del usuario.                             | 2                      |
| **Total estimado (Notificaciones push)**    |                                                                                                     | **10**                 |

---

### **Total estimado para el Sprint 1 del Chat**  
Sumando todos los puntos de historia:

- **ID 001**: 10 puntos.
- **ID 002**: 10 puntos.
- **ID 003**: 10 puntos.
- **ID 004**: 9 puntos.
- **ID 011**: 16 puntos.
- **ID 017**: 10 puntos.

---

### **Total del Sprint 1**:  
**65 puntos de historia**

---

### **Capacidad del equipo**:  
- **Estimación del sprint**: Un equipo de tamaño promedio con experiencia en proyectos similares puede completar entre 20 y 30 puntos de historia por sprint de dos semanas.
- **Recomendación**: Si el equipo es nuevo en el proyecto o las herramientas utilizadas, se recomienda reducir el alcance del sprint o aumentar la duración del mismo.
