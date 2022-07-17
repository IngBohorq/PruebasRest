Feature: Ingreso de empleados
  Con el fin de poder administrar el ingreso de usuarios
  Yo como usuario querio poder ingresar usuarios
  Para saber si el ingreso fue exitosa

  Scenario: Registro de usuarios
    Given Usuario invoca la consulta de la api
    When el envia la informacion requerida por el servicio
    Then se registra ingreso exitoso en el sistema