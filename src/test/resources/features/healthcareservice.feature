Feature: Funcionalidad para reservar una cita medica
  Como usuario quiero programar una cita medica en la aplicacion CURA Healthcare service
  Rule: progragamar una cita medica
    Background: Ingresar a la aplicacion
    @regresion_happy
    Scenario Outline: programo la cita medica de manera correcta
      Given como usuario deseo programar un cita medica en la web
      When presiono el boton login del menu hamburguesa
      Then se autentifica para programar un cita medica con las credenciales de prueba <username> y <password>
      And valido que me muestre el formulario y programo mi cita medica
      And ingreso la ubicacion del centro medico <facility>, selecciono la opcion aplico para readmision <apply>, selecciono el programa de salud <healthcare_program>,  programo la fecha de visita <visit_date> y agrego un comentario <comment>
      Then vizualizo el mensaje de cita confirmada <message>
      And confirmo los datos ingresados <facility>, <apply>, <healthcare_program>, <visit_date>, <comment>
      Examples: Exitoso
        |username   | password               | facility                          |  apply    | healthcare_program | visit_date    | comment             |  message                      |
        | John Doe  |  ThisIsNotAPassword    | Tokyo CURA Healthcare Center      |  false   |  Medicare          |   19/03/2023  |  dolor de espalda    | Appointment Confirmation      |

    @regresion_unhappy
    Scenario Outline: programo la cita medica de manera incorrecta
      Given como usuario deseo programar un cita medica en la web
      When presiono el boton login del menu hamburguesa
      Then se autentifica para programar un cita medica con las credenciales de prueba <username> y <password>
      And valido que me muestre el formulario y programo mi cita medica
      And ingreso la ubicacion del centro medico <facility>, selecciono la opcion aplico para readmision <apply>, selecciono el programa de salud <healthcare_program>,  programo la fecha de visita <visit_date> y agrego un comentario <comment>
      Then vizualizo el mensaje de campo requerido <message>
      Examples: No Exitoso
        |username   | password               | facility                          |  apply    | healthcare_program | visit_date    | comment             |  message                    |
        | John Doe  |  ThisIsNotAPassword    | Tokyo CURA Healthcare Center      |  true   |  Medicare          |                |  dolor de espalda    | Please fill out this field. |






