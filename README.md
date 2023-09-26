# IntentsApp

IntentsApp es una aplicación Android desarrollada con Jetpack Compose y Kotlin que demuestra la implementación de intents y la navegación entre diferentes tipos de acciones, como hacer una llamada telefónica, enviar un mensaje SMS y enviar un correo electrónico.

## Funcionalidades

La aplicación ofrece las siguientes funcionalidades principales:

### Bottom Navigation

La aplicación utiliza un botón de navegación inferior (Bottom Navigation) para permitir a los usuarios navegar de manera rápida y sencilla entre las diferentes funciones de la aplicación.

### Pad Numérico

IntentsApp utiliza un pad numérico implementado con un grid que permite a los usuarios marcar un número de teléfono de manera intuitiva.

### Utilización de Intents

La aplicación demuestra el uso de intents para realizar las siguientes acciones:

- **Hacer una llamada telefónica:** Los usuarios pueden marcar un número de teléfono la cual al marcar manda al usuario a la aplicacion predeterminada del dispositivo para llamar.

- **Enviar un mensaje SMS:** IntentsApp permite a los usuarios ingresar un número de teléfono y un mensaje, y luego enviar al usuario a la aplicacion predeterminada del dispositivo para mandar un mensaje de texto SMS.

- **Enviar correo electrónico:** Los usuarios pueden escribir un correo electrónico con un destinatario, asunto y mensaje, y enviarlo utilizando la aplicación de correo electrónico predeterminada en el dispositivo (el usuario puede escoger entre todas las apps de mensajes que tenga en su dispositivo).

## Estructura del Proyecto

El proyecto se organiza de la siguiente manera:

- **components:** Contiene componentes reutilizables de Jetpack Compose, como el Bottom Navigation y el Pad Numérico (CircleNumber).

- **navigation:** Incluye las rutas de navegación definidas en una sealed class (Routes) y el gestor de navegación (NavManager) que configura la navegación de la aplicación.

- **views:** Contiene las vistas principales de la aplicación:

  - **HomeView:** Es la vista raíz que contiene el Bottom Navigation y gestiona la navegación entre las diferentes funcionalidades.

  - **PhoneView:** Permite a los usuarios marcar números de teléfono.

  - **SmsView:** Permite a los usuarios enviar mensajes SMS.

  - **EmailView:** Permite a los usuarios enviar correos electrónicos.

## /./

### BottomNav

```kotlin
@Composable
fun BottomNav(navHostController: NavHostController, routes: List<Routes>) {
    BottomAppBar {
        NavigationBar(
            containerColor = Color.White
        ) {
            val currentRoute = currentRoute(navHostController)
            routes.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    onClick = { navHostController.navigate(item.route) },
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            tint = Color.DarkGray
                        )
                    },
                    label = {
                        Text(text = item.title)
                    },
                    alwaysShowLabel = true
                )
            }
        }
    }
}
```

