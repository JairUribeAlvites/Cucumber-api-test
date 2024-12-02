@Airlines
Feature: Obtener todas las aerolíneas
  Como un usuario de la API de aerolíneas
  Quiero obtener la lista de todas las aerolíneas
  Para poder verificar los detalles de las aerolíneas disponibles

  @CP01
  Scenario: Obtener todas las aerolíneas exitosamente
    Given el actor establece el endpoint GET para obtener las aerolineas
    When el actor envia una solicitud HTTP GET
    Then el codigo de respuesta HTTP deberia ser 200
  @CP02
  Scenario Outline: Crear una aerolinea exitosamente
    Given el actor establece el endpoint POST para crear una aerolinea
    When el envia una solicitud HTTP POST con el "<_id>" "<name>" "<country>" "<logo>" "<slogan>" "<head_quaters>" "<website>" "<established>"
    Then el codigo de respuesta HTTP deberia ser 200
    Examples:
      | _id | name            | country | logo    | slogan                   | head_quaters | website     | established |
      | 1   | Ramon Castilla  | Lima    | lima.png| Miraflores ciudad amable | Miraflores   | flowers.com | 1857        |
      | 3   | Alfredo Parodi  | Lima    | lima.png| Centro financiero        | San Isidro   | isidro.pe   | 1931        |
  @CP03
  Scenario: Obtener una aerolínea por ID exitosamente
    Given el actor establece el endpoint GET para obtener la aerolinea con id
    When el actor envia una solicitud HTTP GET para obtener la aerolinea por id "73dd5420-3bf9-48f3-a0b6-17cf7aa61b19"
    Then el codigo de respuesta HTTP deberia ser 200
