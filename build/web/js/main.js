function jsIns() {
    window.location = "notasIns.jsp";
}

function jsDel() {
    var ide = [];

    $("input[name='_del']:checked").each(function() {
        ide.push($(this).val());
    });

    if (ide.length === 0) {
        alert("Seleccione fila(s) a Retirar");
    } else {
        if (confirm("Retirar fila(s)?")) {
            window.location = "Personas?accion=DEL&ide=" + ide.toString();
        }
    }
}

function jsUpd() {
    var ide = $("input[name='_upd']:checked").val();

    if (isNaN(ide)) {
        alert("Seleccione Fila para Actualizar Datos");
    } else {
        window.location = "Personas?accion=GET&ide=" + ide;
    }
}

function cancelar() {
    window.location = "Personas?accion=QRY";
}