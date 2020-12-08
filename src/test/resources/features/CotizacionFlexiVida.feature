@tag
Feature: Poder realizar cotizaciones para la línea de negocios VIDA

  @cotizacionFlexivida @Regresion
  Scenario Outline: 1-Validar la cotizacion del producto Flexivida de titular con varias coberturas
    Given accedo al servicio de cotizacion
    When ingreso los datos del plan "<ideProd>", "<idePlan>", "<idpMoneda>"
    And ingreso los datos del usuario "<ideVendedor>", "<ideCanal>", "<ideUsuario>"
    And ingreso los datos particulares "<codRamo>","<nombre>","<descripcion>"
    And ingreso los datos del parentesco "<ideTipoRelTer>"
    And ingreso los datos particulares de los asegurados "<nombreDPAseg>","<descripcionDPAseg>"
    And ingreso los datos de la cobertura "<ideComp>"
    And ingreso los datos particulares de la cobertura "<nombreDPCober>","<descripcionDPCober>"
    And ingreso los componentes de los asegurados
    And realizo la cotizacion del producto Flexivida
    Then se debe mostrar correctamente el cálculo de la prima para el titular

    ###DATOS###@DataPrueba|1@01-SimularCotizacion
    Examples: 
      |0|ideProd|idePlan|idpMoneda|ideVendedor|ideCanal|ideUsuario|codRamo|nombre|descripcion|ideTipoRelTer|nombreDPAseg|descripcionDPAseg|ideComp|nombreDPCober|descripcionDPCober|PrimaNeta|NumCotizacion|Moneda|Profesion|TipoRenta|idePlanFinanciamiento|NumFraccionamiento|PrimaNeta|PrimaAhorro|PRimaBruta|mtoGiro|fechaIni|fechaFin|
      |1|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891|COVSumaAsegurada,COVSumaAsegurada|60000,350|1181.7376601218973|774c685b-af36-4005-914d-da7b28af6db7|SOL|Estudiante|Baja|23774||||||||
      |2|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887|COVSumaAsegurada|60000|1181.7376601218973|c381eb7c-808f-437e-abce-c6cdcec63228|SOL|Estudiante|Baja|23774||||||||
      |3|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891|COVSumaAsegurada,COVSumaAsegurada|60000,350|1749.8645544964215|fed40dbf-a167-47fc-b878-3358ee3df788|SOL|Abogado|Baja|23774||||||||
      |4|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891,15893,15000|COVSumaAsegurada,COVSumaAsegurada,COVSumaAsegurada|60000,350,5000|2148.182870666058|0013f923-e113-4735-8a7d-c8455eee91ca|SOL|Abogado|Baja|23774||||||||

  @cotizacionFlexivida2 @Regresion
  Scenario Outline: 2-Validar la cotizacion del producto Flexivida de titular solo con fallecimiento
    Given accedo al servicio de cotizacion
    When ingreso los datos del plan "<ideProd>", "<idePlan>", "<idpMoneda>"
    And ingreso los datos del usuario "<ideVendedor>", "<ideCanal>", "<ideUsuario>"
    And ingreso los datos particulares "<codRamo>","<nombre>","<descripcion>"
    And ingreso los datos del parentesco "<ideTipoRelTer>"
    And ingreso los datos particulares de los asegurados "<nombreDPAseg>","<descripcionDPAseg>"
    And ingreso los componentes de los asegurados
    And realizo la cotizacion del producto Flexivida
    Then se debe mostrar correctamente el cálculo de la prima para el titular sin coberturas

    ###DATOS###@DataPrueba|1@02-SimularCotizacion
    Examples: 
      |0|ideProd|idePlan|idpMoneda|ideVendedor|ideCanal|ideUsuario|codRamo|nombre|descripcion|ideTipoRelTer|nombreDPAseg|descripcionDPAseg|PrimaNeta|NumCotizacion|Moneda|Profesion|TipoRenta|
      |1|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2000-01-11,F|1252.3972321636918|98d714a7-067f-41ce-be95-c007b04da3ae||||
      |2|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2000-01-11,F|1252.3972321636918|debe7030-8f81-4b91-9b1d-4fac28b9042b||||
      |3|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2000-01-11,F|1252.3972321636918|b37d5328-3562-42be-9750-ad1af71628a5||||
      |4|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2000-01-11,F|1252.3972321636918|3fd760ee-06bb-4ec0-b2ed-f756cfdbbf09||||

  @cotizacionFlexivida3 @Regresion
  Scenario Outline: 3-Validar la cotizacion del producto Flexivida con diferente tipo de asegurados
    Given accedo al servicio de cotizacion
    When ingreso los datos del plan "<ideProd>", "<idePlan>", "<idpMoneda>"
    And ingreso los datos del usuario "<ideVendedor>", "<ideCanal>", "<ideUsuario>"
    And ingreso los datos particulares "<codRamo>","<nombre>","<descripcion>"
    And ingreso los parentescos "<ideTipoRelTer>","<ideTipoRelTercony>"
    And ingreso los datos particulares varios asegurados "<nomDPAseg>","<desDPAseg>","<nomDPAsegCony>","<desDPAsegcony>"
    And ingreso los datos de la cobertura de varios asegurados "<ideComp>","<ideCompCony>"
    And ingreso los datos particulares de la cobertura de varios asegurados "<nombreDPCober>","<descripcionDPCober>","<nomDPCobercony>","<desDPCobercony>"
    And ingreso los componentes de varios asegurados
    And realizo la cotizacion del producto Flexivida
    Then se debe mostrar correctamente el cálculo de la prima para todos los asegurados

    ###DATOS###@DataPrueba|1@03-SimularCotizacion
    Examples: 
      |0|ideProd|idePlan|idpMoneda|ideVendedor|ideCanal|ideUsuario|codRamo|nombre|descripcion|ideTipoRelTer|nomDPAseg|desDPAseg|ideComp|nombreDPCober|descripcionDPCober|ideTipoRelTercony|nomDPAsegCony|desDPAsegcony|ideCompCony|nomDPCobercony|desDPCobercony|PrimaNeta|NumCotizacion|Moneda|Profesion|TipoRenta|
      |1|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891|COVSumaAsegurada,COVSumaAsegurada|60000,350|135|FechaNacimiento,Sexo|2000-01-11,F|15892,15887|COVSumaAsegurada,COVSumaAsegurada|10000,200000|1336.2689794623573|d101fbb8-4b5b-4d44-890e-e4fbf941921e||||
      |2|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Estudiante,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887|COVSumaAsegurada|60000|135|FechaNacimiento,Sexo|2000-01-11,F|15892|COVSumaAsegurada|10000|1181.7376601218973|5af3360f-ffbb-4d23-bd30-b5731106104e||||
      |3|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891|COVSumaAsegurada,COVSumaAsegurada|60000,350|135|FechaNacimiento,Sexo|2000-01-11,F|15892|COVSumaAsegurada|10000|1749.8645544964215|ce2a7fb5-140d-4ace-a5ff-d907cd41619b||||
      |4|106481|532603|SOL|768612805|449658888|VVIRTUAL|GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL,GENERAL|SumaAsegurada,IngresoMensual,SituacionLaboral,DuracionPoliza,DuracionInversionSC,TipoRiesgo,OcupacionInv,RequiereFactura|400000,5000,Independiente,39,39,Estándar,Abogado,NO|134|FechaNacimiento,Sexo|2002-01-11,M|15887,15891,15893,15000|COVSumaAsegurada,COVSumaAsegurada,COVSumaAsegurada|60000,350,5000|135|FechaNacimiento,Sexo|2000-01-11,F|15892,15887|COVSumaAsegurada,COVSumaAsegurada|10000,200000|2302.714190006518|2d8050dd-84a0-4ef9-bced-7150294b5951||||

  @cotizacionFlexivida4 @Regresion
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
