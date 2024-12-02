@Passengers
Feature: Obtener información de pasajeros
  Como un usuario de la API de pasajeros
  Quiero obtener la información de un pasajero por ID
  Para verificar los detalles de ese pasajero

  @CP04
  Scenario: Obtener pasajero por ID exitosamente
    Given el actor establece el endpoint GET para obtener pasajero con id "667ab7a47ad8fb3efa4343f2"
    When el actor envia una solicitud HTTP GET para obtener pasajero por id
    Then el codigo de respuesta HTTP deberia ser 200
  @CP05
  Scenario Outline: Crear una pasajero exitosamente
    Given el actor establece el endpoint POST para crear un pasajero
    When el envia una solicitud HTTP POST con el "<name>" "<trips>" "<airline>"
    Then el codigo de respuesta HTTP deberia ser 200
    Examples:
      | name           | trips | airline |
      | John Doe       | 5     | 1       |
      | Jane Smith     | 3     | 2       |
      | Alice Johnson  | 8     | 3       |
      | Bob Brown      | 2     | 4       |
      | Charlie Davis  | 10    | 5       |
      | Emily White    | 7     | 6       |
      | Frank Wilson   | 4     | 7       |
      | Grace Thomas   | 6     | 8       |
      | Henry Martinez | 9     | 9       |
      | Ivy Clark      | 1     | 10      |
  @CP06
  Scenario: Borrar pasajero por ID exitosamente
    Given el actor establece el endpoint GET para obtener pasajero
    When el actor envia una solicitud HTTP DELETE para obtener borrar con id "667ab79e7ad8fb6bef4343d4"
    Then el codigo de respuesta HTTP deberia ser 200