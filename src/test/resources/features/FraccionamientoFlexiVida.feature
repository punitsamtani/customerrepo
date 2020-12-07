@tag
Feature: Poder realizar Fraccionamiento para la línea de Productos Vida

  @FraccionamientoFlexivida
  Scenario Outline: Validar el fraccionamiento del producto Flexivida
    Given accedo al servicio de fraccionamiento
    When ingreso los datos de la cotizacion "<NumCotizacion>"
    And ingreso el tipo de fraccionamiento "<idePlanFinanciamiento>"
    And ingreso los componentes del fraccionamiento
    And realizo el fraccionamiento del producto Flexivida
        
    Then el numero de fraccionamieno
   
    

    ###DATOS###@DataPrueba|1@01-SimularFraccionamiento
    Examples: 
      |0|PrimaNeta|NumCotizacion|idePlanFinanciamiento|NumFraccionamiento|PrimaNeta|PrimaAhorro|PRimaBruta|mtoGiro|fechaIni|fechaFin|
      |1|1181.7376601218973|1383ff1c-b6d1-48a1-805c-f647c6db1779|23774||||||||
