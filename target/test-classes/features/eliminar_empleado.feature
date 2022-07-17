Feature: Eliminar un usuario
  Con el fin de poder administrar la eliminacion de un usuario
  Yo como usuario querio poder eliminar un usuario
  Para saber si la eliminacion fue exitosa

  Scenario: Eliminacion de un usuario
    Given Usuario invoca la consulta de la api
    When se envia el registro a eliminar servicio
      | registro   |
      | <registro> |
    Then se registra eliminacion existosa
      | registro |
      | 2        |