@tag
Feature: Realizar Consulta de Póliza Vehicular - nivel API

  @ConsultaPolizazzzzz
  Scenario Outline: Validar estado de consulta
    Given realizo la configuracion del request con los siguientes campos "<nombre>" y "<descripcion>"
    When envio mi request
    Then Valida el primer valor "<valorEsperado>" de la consulta

    ###DATOS###@DataPrueba|1@01-Escenario1
    Examples: 
      | 0 | descripcion | nombre               | valorEsperado |
      | 1 | YARIS       | MODELOS_DE_VEHICULOS |        403234 |
      | 2 | YARIS       | MODELOS_DE_VEHICULOS |        403234 |
      | 3 | YARIS       | MODELOS_DE_VEHICULOS |        403234 |
