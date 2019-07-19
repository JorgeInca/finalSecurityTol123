
<!-- The Modal -->
<div class="modal" id="modalAfiliacion">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title"><div id="titleModalAfiliacion"></div></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>
      </div>

      <!-- Modal body -->
            <!-- Modal body -->
      <div class="modal-body">
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Nombre:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="nombre" name="nombre" maxlength="140">
		    </div>
		</div>
		<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Numero:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="numero" name="numero" maxlength="140">
		    </div>
		</div>
      	<div class="row" >
	    	<div class="col-md-4 form-group" >
		      <label class="control-label col-sm-2" for="pwd">Fecha creación:</label>
		    </div>
		    <div class="col-md-6 col-md-offset-2 form-group">          
		       <input type="text" class="form-control" id="fechaAlta" name="fechaAlta" maxlength="140" onlyread>
		    </div>
		</div>
		<input id="tipoOperacion" type="text"  hidden>
		<input id="idAfiliacion" type="text"  hidden>
		<div id="divError" class="alert alert-danger" role="alert" ></div>	
	  </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-warning" onClick="AfiliacionesJS.limpiaModalAfiliacion();">
      			<span style="color: white;">Limpiar</span>
		</button>
      	<button type="button" class="btn btn-success"  onClick="AfiliacionesJS.validaGuardaAfiliacion();"><div id="btnModalAfiliacion"></div></button>
        <button type="button" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
      </div>

    </div>
  </div>
</div>