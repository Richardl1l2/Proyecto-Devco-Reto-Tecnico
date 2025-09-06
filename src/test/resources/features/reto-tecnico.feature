#language: es

Característica: Reto tecnico Automatizador

  Antecedentes: El usuario ya ha iniciado sesión en el sistema.
    Dado Cambiar al iframe donde se encuentra el calendario.
    Cuando Hacer click en el campo de selección de fecha.

  @scenarioUno
  Escenario: Reserva de una cita mes actual
    Y Seleccionar el día quince del mes actual.
    Entonces Validar que la fecha seleccionada mes actual "09/15/2025" aparece en el campo de texto.

  @scenarioDos
  Escenario: Reserva de una cita mes siguiente
    Y Seleccionar el día diez del mes siguiente.
    Entonces Validar que la fecha seleccionada mes siguiente "10/10/2025" aparece en el campo de texto.

  @scenarioTres
  Escenario: Modificar campo calendario manualmente
    Y Intentar ingresar una fecha "12/24/2025" manualmente en el campo de texto.
    Entonces Validar que no se permite la edición manual y que solo es posible seleccionar una fecha desde el calendario.

  @permiteSeleccionarDesdeCalendario
  Escenario: Seleccionar fecha calendario
    Y Seleccionar cualquier fecha del calendario.
    Entonces Validar que solo es posible seleccionar una fecha desde el calendario.