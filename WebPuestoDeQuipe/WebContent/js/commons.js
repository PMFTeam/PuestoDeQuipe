var X = 0;
var Y = 0;

function opennormalpopup(url, name, width, height)
{
		var win = window.open(url,name,'width='+width+',height='+height+',status=yes,location=no,menubar=no;toolbar=no,scrollbars=yes');
		return win;
}


function openLoginForm() {
	$( "#dialog-confirm" ).dialog({
		resizable: false,
		height:243,
		width:486,
		modal: true,
		buttons: {
			Cancelar: function() {
				$( this ).dialog( "close" );
			}
		}
	});

}

function backgroundFilter() {
	var div;
	if (document.getElementById) {
		// Standard way to get element
		div = document.getElementById('backgroundFilter');
	} else if (document.all) {
		// Get the element in old IE's
		div = document.all['backgroundFilter'];
	}
	// if the style.display value is blank we try to check it out here
	if (div.style.display == '' && div.offsetWidth != undefined && div.offsetHeight != undefined) {
		div.style.display = (div.offsetWidth != 0 && div.offsetHeight != 0) ? 'block' : 'none';
	}
	// If the background is hidden ('none') then it will display it ('block').
	// If the background is displayed ('block') then it will hide it ('none').
	div.style.display = (div.style.display == '' || div.style.display == 'block') ? 'none' : 'block';
}

function editView(id)
{
	var div;
	if (document.getElementById) {
		// Standard way to get element
		div = document.getElementById(id);
	} else if (document.all) {
		// Get the element in old IE's
		div = document.all[id];
	}
	// if the style.display value is blank we try to check it out here
	if (div.style.display == '' && div.offsetWidth != undefined && div.offsetHeight != undefined) {
		div.style.display = (div.offsetWidth != 0 && elem.offsetHeight != 0) ? 'block' : 'none';
	}
	// If the PopUp is hidden ('none') then it will display it ('block').
	// If the PopUp is displayed ('block') then it will hide it ('none').
	div.style.display = (div.style.display == '' || div.style.display == 'block') ? 'none' : 'block';
	// Off-sets the X position by 15px
	/*X = X + 15;
	div.style.left = X + 'px';
	div.style.top = Y + 'px';
	*/
}

function hideById(id) {
	//$('#'+id).fadeTo("slow", 0.0);
	$('#'+id).slideUp("slow");
	//$('#'+id).get(0).style.display='none';
}
function showById(id, display) {
	//$('#'+id).get(0).style.display=display;
	//$('#'+id).fadeTo("slow", 1.0);
	$('#'+id).slideDown("slow");
}

function updateElementId(id, value) {
	$('#'+id).html(value);
}

function enterKeyPress(e)
{
    code= (e.keyCode ? e.keyCode : e.which);
    if (code == 13) 
    	return true;
    return false;
    
}

function ask(id, question, callback) {
	$('#'+id+'Msg').html(question);
	$("#"+id).dialog({
		resizable: false,
		height:140,
		resizable: false,
		height:200,
		modal: true,
		position: 'center',
		closeOnEscape: true,
		modal: true,
		buttons: {
			'Si': function() {
				$(this).dialog('close');
				callback(true);
			},
			'No borrar': function() {
				$(this).dialog('close');
				callback(false);
			}
		}
	});
}

function deleteTr(object) {
	   //$(object).closest("tr").slideUp();fadeOut('slow'
	$(object).closest("tr").fadeOut('slow');
	   //$(object).closest("table").find("tr:eq(" + colnum + ")").remove();
}

function onlyNumbers(event) {
	if ( event.keyCode == 46 || event.keyCode == 8 ) {
		// let it happen, don't do anything
	}
	else {
		if (event.keyCode < 95) { 
			if (event.keyCode < 48 || event.keyCode > 57 ) {
				event.preventDefault();	
			}
		} else {
			if (event.keyCode < 96 || event.keyCode > 105 ) {
				event.preventDefault();
			}
		} 	
	}	
}