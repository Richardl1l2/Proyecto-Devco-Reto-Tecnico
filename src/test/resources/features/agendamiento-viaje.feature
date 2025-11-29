#language: es

Característica: Agendamiento de Viaje con Filtro de Precios
  Yo como PO quiero agendar un viaje en línea con el filtro de precios
  para entregar independencia a mis clientes.

  @agendamiento
  Esquema del escenario: Agendamiento de viaje exitoso con datos parametrizados
    Dado que el actor Usuario ha ingresado los datos de partida y regreso:
      | partida_mes   | partida_dia   | regreso_mes   | regreso_dia   | adultos   | ninos   |
      | <partida_mes> | <partida_dia> | <regreso_mes> | <regreso_dia> | <adultos> | <ninos> |
    Cuando el usuario filtra los destinos por el rango de precio:
      | precio   |
      | <precio> |
    Y elige el destino:
      | destino_elegido   |
      | <destino_elegido> |
    Y completa el formulario de reserva:
      | name     | email   | SSN   | phone      |
      | <nombre> | <email> | <ssn> | <telefono> |
    Y termina de completar los datos faltantes:
      | codigo_promocional   |
      | <codigo_promocional> |
    Entonces el sistema debe mostrar el mensaje de confirmacion "Destination Booked"

    Ejemplos:
      | partida_mes   | partida_dia | regreso_mes | regreso_dia | adultos | ninos | precio | destino_elegido | nombre | email          | ssn         | telefono     | codigo_promocional |
      | December 2025 | 2           | March 2026  | 10          | 2       | 4     | 1700   | Flagstaff       | Maria  | maria@test.com | 123-45-6789 | +17871234567 | PROMO1             |

  @validarTitulo
  Escenario: Verificar el título de la página principal
    Entonces el título de la página debe ser "SPACE & BEYOND"