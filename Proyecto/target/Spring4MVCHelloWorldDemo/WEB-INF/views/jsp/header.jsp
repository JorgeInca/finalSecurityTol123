<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Bienvenido ${user} </a>

  <!-- Links -->
  <ul class="nav navbar-nav ml-auto">
  	<li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Resumen
      </a>
      <div class="dropdown-menu">        
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_REVOLVENTE.idTipoBandeja);" >Revolvente</a>
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANJDEJA_PERSONAS_TRABAJADORES.idTipoBandeja);">Gr�fico</a>
       </div>
     </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Personas
      </a>
      <div class="dropdown-menu">        
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANJDEJA_PERSONAS_CLIENTE.idTipoBandeja);" >Clientes</a>
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANJDEJA_PERSONAS_TRABAJADORES.idTipoBandeja);">Empleados</a>
        
       </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Veh�culos
      </a>
      <div class="dropdown-menu">        
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.idTipoBandeja);" >Registro combustible</a>
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_VEH_MANTENIMIENTO.idTipoBandeja);">Mantenimiento</a>
		<div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_VEH_VEHICULOS.idTipoBandeja);">Veh�culos</a>
        
       </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Operaciones
      </a>
      <div class="dropdown-menu">        
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_OP_OBRAS.idTipoBandeja);">Obras</a>
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_OP_RENTAS.idTipoBandeja);">Rentas</a>
		<div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_OP_INVENTARIOS.idTipoBandeja);">Inventarios</a>
       </div>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        Sesi�n
      </a>
      <div class="dropdown-menu">        
		<a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.idTipoBandeja);">Configuraci�n</a>
		<div class="dropdown-divider"></div>
        <a class="dropdown-item" href="#" onClick="GeneralJS.linkBandeja(TipoBandejaEnum.BANDEJA_VEH_COBUSTIBLE.idTipoBandeja);">Cerrar Sesi�n</a>
       </div>
    </li>
    <li>
    	 <a class="nav-link" href="#">&nbsp;</a>
    </li>
     <li>
    	 <a class="nav-link" href="#">&nbsp;</a>
    </li>
     <li>
    	 <a class="nav-link" href="#">&nbsp;</a>
    </li>
    
  </ul>
</nav>