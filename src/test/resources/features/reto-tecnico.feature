#language: es

Característica: Reserva de una cita seleccionando una fecha en el calendario


  Antecedentes: El usuario ya ha iniciado sesión en el sistema.
    Dado Cambiar al iframe donde se encuentra el calendario.
    Cuando Hacer click en el campo de selección de fecha.

  @scenarioUno
  Escenario: Reserva de una cita
    Y Seleccionar el día quince del mes actual.
    Entonces Validar que la fecha seleccionada mes actual "09/15/2025" aparece en el campo de texto.

