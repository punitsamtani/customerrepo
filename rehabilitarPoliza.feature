@tag
Feature: Rehabilitar poliza de Vida

  @cotizacionFlexivida @Regresion
  Scenario Outline: Validar que se pueda rehabilitar una póliza que antes fue anulada
    Given accedo al SAS
    When busco la póliza "<numpol>"
    And tiene el estado anulado
    And ingreso a modificar sus datos particulares
    And cambio su estado a rehabilitado
    And aparace un mensaje de confirmación
    Then al regresar a la póliza debe aparecer con su estado actualizado

    ###DATOS###@DataPrueba|1@01-SimularCotizacion
    Examples: 
      |0|ideProd|idePlan|
      |1|2011|532603|
      |2|2011|532604|
      