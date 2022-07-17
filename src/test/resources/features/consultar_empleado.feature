Feature: Consulta de usuarios
  Con el fin de poder administrar la consulta de usuarios
  Yo como usuario querio poder consultar
  Para saber si la consulta fue exitosa

  Scenario Outline: Consulta de usuarios
    Given Usuario invoca la consulta de la api
    When el consulta los registro
      | page   |
      | <page> |
    Then el verifica el registro en el servicio
    Examples:
      | page |
      | 0    |
      | 1    |