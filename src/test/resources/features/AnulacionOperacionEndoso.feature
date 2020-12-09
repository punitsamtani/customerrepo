@tag
Feature: Anular operación de endoso

  @AnularOperacionEndoso @Regresion
  Scenario Outline: 4-Validar los tipos de renta vs la prima mostrada
    Given accedo al servicio de cotizacion
    When ingreso los datos del plan "<ideProd>", "<idePlan>", "<idpMoneda>"
    And ingreso los datos del usuario "<ideVendedor>", "<ideCanal>", "<ideUsuario>"
    And ingreso los datos particulares "<codRamo>","<nombre>","<descripcion>"
    And ingreso los datos del parentesco "<ideTipoRelTer>"
    And ingreso los datos particulares de los asegurados "<nombreDPAseg>","<descripcionDPAseg>"
    And ingreso los componentes de los asegurados
    And realizo la cotizacion del producto Flexivida
    Then se muestra la prima neta y el numero de cotizacion y el tipo de renta

    ###DATOS###@DataPrueba|1@04-SimularCotizacion
    Examples: 
      |0|ideProd|idePlan|idpMoneda|ideVendedor|ideCanal|ideUsuario|codRamo|nombre|descripcion|ideTipoRelTer|nombreDPAseg|descripcionDPAseg|PrimaNeta|NumCotizacion|TipoRenta|TipoRentaEsperado|
      |1|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|660001,50000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|1677.8087449687505|9ccf3c1e-d3f6-4f07-93e0-555af6aa5946|Alta|Alta|
      |2|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|200000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|706.1473917668941|1844df72-b165-4cb7-9180-c4a157ccdda7|Baja|Baja|
      |3|106481|532604|USD|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|254.21306103608188|3fe4ab1d-d128-4e1d-87e6-a522cc4d5337|Alta|Alta|
      |4|106481|532604|USD|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|100000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|353.07369588344704|4c1bdc5b-0819-4124-ac41-7e9566cbb2eb|Baja|Baja|
