$(function() {
    $("table.parainfo thead").addClass("ui-widget-header");

    $(".parainfo .crud .ins span").addClass("ui-icon ui-icon-plusthick");
    $(".parainfo .crud .del span").addClass("ui-icon ui-icon-minusthick");
    $(".parainfo .crud .upd span").addClass("ui-icon ui-icon-check");

    $(".parainfo .crud").mouseover(function() {
        $(this).addClass("ui-state-hover");
    }).mouseout(function() {
        $(this).removeClass("ui-state-hover");
    });
});

