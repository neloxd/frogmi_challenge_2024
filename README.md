# frogmi_challenge
technical challenge of the frogmi company
Para probar ubicar el objeto "Session" en el repositorio "core" cambiar los siguientes valores:

- session
- companyUid

Se agrego un interceptor de red para casos 401 o 403 (refresh or revoke session)
Se agrego wrapper de data y modelos
Se podría agregar un design system


Para las pruebas de manera local se adjunto un archivo stores.json en el modulo stores/assets
para ello activar los metodos local desde viewmodel y comentar los metodo que invocan al UseCase
se tiene variables locales para el uso estatico
- ASSET_STORES: nombre del archivo
- MAX_LOCAL_SHOW_MORE: maximos loaders que pueden aparecer en la lista
- DELAY_LOCAL: tiempo de espera que se mostrará el loader hasta procesar la nueva data

Para las pruebas con servicio, descomentar en el fragmento para llamar a getStores

Adicional a ello se agrego un interceptador de peticiones que se visualiza en la barra de notificaciones
