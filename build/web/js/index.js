var dataAll = new Array();
var dataCurrent = new Array();

var markers = [];

var myOptions = {
    center: new google.maps.LatLng(-8.907032, -76.647413),
    zoom: 6,
    mapTypeId: google.maps.MapTypeId.ROADMAP
};

var map = new google.maps.Map(document.getElementById('container'), myOptions);
//pater del servelet
$.getJSON("getDirRegEsta", function (requestDataEstacion) {

    $.each(requestDataEstacion, function (key, val) {
        var strHtml = "";
        strHtml += "<a href=\"#\" onclick=\"jsFilterDirReg('" + val.c_cod_dreg + "')\">Dir. Reg. " + val.c_cod_dreg + "</a>";
        strHtml += "<ul>";
        $.each(val.direccionRegionalEstacion, function (k, v) {
            strHtml += "<li class=\"pushy-link\"><a href=\"#\" onclick=\"jsFilterEstacion('" + v.v_cod_esta + "')\">" + v.v_cod_esta + " - " + v.v_nom_esta + "</a></li>";
        });
        strHtml += "</ul>";
        var id = "#dr" + val.c_cod_dreg;
        $(id).append(strHtml);
    });
    jsFase00();

});

function jsFase00() {
    //servelet estaciones
    $.getJSON("getEstaciones", function (requestData) {
        dataAll = requestData;
        jsFase01("TODO");
    });
}

function jsFase01(filtro) {
    switch (filtro) {
        case "TODO":
            pintarTodo();
            break;
        case "01":
            pintarDirReg(filtro);
            break;
        case "02":
            pintarDirReg(filtro);
            break;
        case "03":
            pintarDirReg(filtro);
            break;
        case "04":
            pintarDirReg(filtro);
            break;
        case "05":
            pintarDirReg(filtro);
            break;
        case "06":
            pintarDirReg(filtro);
            break;
        case "07":
            pintarDirReg(filtro);
            break;
        case "08":
            pintarDirReg(filtro);
            break;
        case "09":
            pintarDirReg(filtro);
            break;
        case "10":
            pintarDirReg(filtro);
            break;
        case "11":
            pintarDirReg(filtro);
            break;
        case "12":
            pintarDirReg(filtro);
            break;
        case "13":
            pintarDirReg(filtro);
            break;
        default:
            pintarPorEstacion(filtro);
            break;
    }
}

function pintarTodo() {
    borrarData();
    dataCurrent = dataAll;
    mostrarMapa(false);
}

function borrarData() {
    dataCurrent = [];
}

function pintarDirReg(codDirReg) {
    borrarData();
    for (var i = 0; i < dataAll.length; i++) {
        if (dataAll[i].v_cod_dre === codDirReg) {
            dataCurrent.push({
                "v_cod_esta": dataAll[i].v_cod_esta,
                "v_nom_esta": dataAll[i].v_nom_esta,
                "v_cod_dre": dataAll[i].v_cod_dre,
                "n_lat_sig": dataAll[i].n_lat_sig,
                "n_lon_sig": dataAll[i].n_lon_sig,
                "n_alt_mts": dataAll[i].n_alt_mts,
                "v_cod_enti": dataAll[i].v_cod_enti,
                "v_cod_cond": dataAll[i].v_cod_cond,
                "v_cod_tipo": dataAll[i].v_cod_tipo,
                "v_sub_esta": dataAll[i].v_sub_esta
            });
        }
    }
    mostrarMapa(false);
}

function pintarPorEstacion(codEstacion) {

    borrarData();
    for (var i = 0; i < dataAll.length; i++) {
        if (dataAll[i].v_cod_esta === codEstacion) {
            dataCurrent.push({
                "v_cod_esta": dataAll[i].v_cod_esta,
                "v_nom_esta": dataAll[i].v_nom_esta,
                "v_cod_dre": dataAll[i].v_cod_dre,
                "n_lat_sig": dataAll[i].n_lat_sig,
                "n_lon_sig": dataAll[i].n_lon_sig,
                "n_alt_mts": dataAll[i].n_alt_mts,
                "v_cod_enti": dataAll[i].v_cod_enti,
                "v_cod_cond": dataAll[i].v_cod_cond,
                "v_cod_tipo": dataAll[i].v_cod_tipo,
                "v_sub_esta": dataAll[i].v_sub_esta
            });
        }
    }
    mostrarMapa(true);
}

function jsFilterDirReg(codDirReg) {
    jsFase01(codDirReg);
}

function jsFilterEstacion(codEstacion) {
    jsFase01(codEstacion);
}

function mostrarMapa(flagInfoWindow) {

    clearMarkers();

    function setMarkers() {

        var nombreEstacion = dataCurrent[i].v_nom_esta;
        var codigoEstacion = dataCurrent[i].v_cod_esta;
        var lat = dataCurrent[i].n_lat_sig;
        var lng = dataCurrent[i].n_lon_sig;

        var temp = dataCurrent[i].v_cod_enti;

        var colorEntidad;
        switch (dataCurrent[i].v_cod_enti) {
            case "SEN":
                colorEntidad = "#166796";
                break;
            case "IMP":
                colorEntidad = "#e47b21";
                break;
            case "ANA":
                colorEntidad = "#569b3e";
                break;
            case "MEM":
                colorEntidad = "#fcfcfc";
                break;
            case "CON":
                colorEntidad = "#d81c35";
                break;
            case "EDEG":
                colorEntidad = "#963f8e";
                break;
            case "SED":
                colorEntidad = "#fff7b2";
                break;
            case "MACH":
                colorEntidad = "#66e828";
                break;
        }

        var latlngset = new google.maps.LatLng(lat, lng);

        var marker = new google.maps.Marker({
            position: latlngset,
            map: map,
            icon: {
                path: google.maps.SymbolPath.CIRCLE,
                scale: 4, //tamanio
                strokeColor: '#0097dc', //color del borde   '#0097dc'
                strokeWeight: 2, //grosor del borde
                fillColor: colorEntidad, //color de relleno
                fillOpacity: 1// opacidad del relleno
            },
            title: nombreEstacion  //animation: google.maps.Animation.BOUNCE
        });

        var contentHtml = "<div style='width:210px;height:80px'>";
        contentHtml += "<div style=\"float: left; width: 30%;  color:brown; padding-left:  5px\">" + codigoEstacion + "</div>";
        contentHtml += "<div style=\"float: right; width: 70%; color:brown; padding-left: 10px\">" + nombreEstacion + "</div>";
        contentHtml += "<p style=\"padding-left: 35%\"><a href=\"precipitacion.jsp?codigoEstacion=" + codigoEstacion + "\">Precipitacion</a></p>";
        contentHtml += "</div>";

        infowindow = new google.maps.InfoWindow({
            content: contentHtml
        });

        google.maps.event.addListener(marker, 'click', function () {

            //alert(this.icon)
            map.panTo(marker.getPosition());
            //map.setCenter(marker.getPosition());
            infowindow.open(map, marker);

            /*
             if (marker.getAnimation() == null) {
             marker.setIcon('icons/home.png');
             //this.setAnimation(google.maps.Animation.BOUNCE);
             } else {
             marker.setAnimation(null);
             marker.setIcon('icons/images/marker.png');
             infowindow.close(map, marker);
             }
             */
        });



        marker.infowindow = infowindow;

        if (flagInfoWindow) {
            infowindow.open(map, marker);
        }
        markers.push(marker);

    }

    for (var i = 0; i <= dataCurrent.length - 1; i++) {
        setMarkers();
    }

}

function clearMarkers() {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(null);
    }
    markers = [];
}