var docViewer = undefined;
var simpleTip = undefined;
var uuid = undefined;
var data = undefined;
var doi= undefined;
var global = false;
var viewerinit=false;
var data=[];

$().toastmessage({
    sticky   : false,
    position : 'middle-center',
    close    : function () {console.log("toast is closed ...");}
});

Array.prototype.equals = function (array) {
    // if the other array is a falsy value, return
    if (!array)
        return false;

    // compare lengths - can save a lot of time 
    if (this.length != array.length)
        return false;

    for (var i = 0, l=this.length; i < l; i++) {
        // Check if we have nested arrays
        if (this[i] instanceof Array && array[i] instanceof Array) {
            // recurse into the nested arrays
            if (!this[i].equals(array[i]))
                return false;       
        }
        
        else if (this[i] != array[i]) { 
            // Warning - two different object instances will never be equal: {x:20} != {x:20}
            return false;   
        }           
    }       
    return true;
}   ;



var twitteroptions = { 
        target:        '#notification',   // target element(s) to be updated with server response 
        beforeSubmit:  showRequest,  // pre-submit callback 
        complete:       showTwitterResponse,
        error: showTwitterError,// post-submit callback 
 
        // other available options: 
        //url:       url         // override for form's 'action' attribute 
        type:      'post'       // 'get' or 'post', override for form's 'method' attribute 
        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
        //clearForm: true        // clear all form fields after successful submit 
        //resetForm: true        // reset the form after successful submit 
 
        // $.ajax options can be used here too, for example: 
        //timeout:   3000 
        };

var facebookoptions = { 
        target:        '#notification',   // target element(s) to be updated with server response 
        beforeSubmit:  showRequest,  // pre-submit callback 
        complete:       showFacebookResponse,
        error: showFacebookError,// post-submit callback 
 
        // other available options: 
        //url:       url         // override for form's 'action' attribute 
        type:      'post'       // 'get' or 'post', override for form's 'method' attribute 
        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
        //clearForm: true        // clear all form fields after successful submit 
        //resetForm: true        // reset the form after successful submit 
 
        // $.ajax options can be used here too, for example: 
        //timeout:   3000 
        };

//pre-submit callback 
function showRequest(formData, jqForm, options) { 
    // formData is an array; here we use $.param to convert it to a string to display it 
    // but the form plugin does this for you automatically when it submits the data 
    var queryString = $.param(formData); 
 
    // jqForm is a jQuery object encapsulating the form element.  To access the 
    // DOM element for the form do this: 
    // var formElement = jqForm[0]; 
 
//    alert('About to submit: \n\n' + queryString); 
 
    // here we could return false to prevent the form from being submitted; 
    // returning anything other than false will allow the form submit to continue 
    return true; 
}
 
// post-submit callback 
function showTwitterResponse(responseText, statusText, xhr, $form)  { 
    // for normal html responses, the first argument to the success callback 
    // is the XMLHttpRequest object's responseText property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'xml' then the first argument to the success callback 
    // is the XMLHttpRequest object's responseXML property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'json' then the first argument to the success callback 
    // is the json data object returned by the server 
	if(typeof(JSON.parse(responseText.responseText).data)=="object")
	 $().toastmessage('showSuccessToast', "Posted to twitter");
	else
	 $().toastmessage('showErrorToast', JSON.parse(responseText.responseText).data);
    console.log('status: ' + statusText + '\n\nresponseText: \n' + JSON.parse(responseText.responseText).data+ 
        '\n\nThe output div should have already been updated with the responseText.'); 
}

function showTwitterError(responseText, statusText, xhr, $form)  { 
    // for normal html responses, the first argument to the success callback 
    // is the XMLHttpRequest object's responseText property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'xml' then the first argument to the success callback 
    // is the XMLHttpRequest object's responseXML property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'json' then the first argument to the success callback 
    // is the json data object returned by the server 
	 $().toastmessage('showErrorToast', responseText.message);
    console.log('status: ' + statusText + '\n\nresponseText: \n' + responseText + 
        '\n\nThe output div should have already been updated with the responseText.'); 
}

function showFacebookResponse(responseText, statusText, xhr, $form)  { 
	 // for normal html responses, the first argument to the success callback 
    // is the XMLHttpRequest object's responseText property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'xml' then the first argument to the success callback 
    // is the XMLHttpRequest object's responseXML property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'json' then the first argument to the success callback 
    // is the json data object returned by the server 
	if(typeof(JSON.parse(responseText.responseText).data)=="object")
	 $().toastmessage('showSuccessToast', "Posted to facebook");
	else
	 $().toastmessage('showErrorToast', JSON.parse(responseText.responseText).data);
    console.log('status: ' + statusText + '\n\nresponseText: \n' + JSON.parse(responseText.responseText).data+ 
        '\n\nThe output div should have already been updated with the responseText.'); 
}

function showFacebookError(responseText, statusText, xhr, $form)  { 
    // for normal html responses, the first argument to the success callback 
    // is the XMLHttpRequest object's responseText property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'xml' then the first argument to the success callback 
    // is the XMLHttpRequest object's responseXML property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'json' then the first argument to the success callback 
    // is the json data object returned by the server 
	 $().toastmessage('showErrorToast', responseText.message);
    console.log('status: ' + statusText + '\n\nresponseText: \n' + responseText + 
        '\n\nThe output div should have already been updated with the responseText.'); 
}


function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function formSubmit(){

	 $.ajax({
	     url:'./facebookpost',
	     data: $("#tofacebook").serialize(),
	     success: function (data) {
	           alert(data);
	    }
	});
}


function getSelectedText() {
    var text = "";
    if ( typeof window.getSelection == "function" ) {
        text = window.getSelection().toString();
    } else if (document.selection && document.selection.type != "Control") {
        text = document.selection.createRange().text;
    }
    return text;
}

function nanotweet() {

    var data = {
        text:  encodeURI(getSelectedText()),
        uuid: uuid,
        comment: $("#userComment").val()

    };

	$('body').addClass('loading');
	$.getJSON( "nanotate?", data,  function(result) {
		$('body').removeClass('loading');
		// TODO: show result message
	});
	simpleTip.hide();
	feedNanotweets();
}

function getNanotweetLink() {
    // TODO: text comment for social networks

    var html = '<textarea id="userComment" style="resize: none; display: inherit;"></textarea>'
        + '<a onclick="nanotweet()" class="sb circle no-shadow no-border blue twitter" href="#"></a>'+
          		   '<a onclick="nanotweet()" href="#">Send to Nanotweets</a>';
	return html;
}

function formatAnnotations(str) {
	var myRegexp = /<z:(.*?)<\/z:(.*?)>/g;
	var result = "", i=0, css;
	match = myRegexp.exec(str);
	while (match != null) {
		css = ( i++ % 2 == 0 ) ? "odd" : "even";
		result += ( match[0].length > 0 ) ? '<span class="' + css + '">' + match[0] + "</span> " : "" ;
	    // matched text: match[0]
	    // match start: match.index
	    // capturing group n: match[n]
	    match = myRegexp.exec(str);
	}
	
	return result;
}

function feedNanotweets(){
	
	// Get nanotweets feed
	
	
	var url="";
	if(global)
		url="annotations?action=list&doi=";
	else
		url="annotations?action=personallist&doi=";
	
		$.getJSON( url + doi, function(result) {
				if ( result.code == 0 ) {
					
					if ( result.hasOwnProperty('data') && result.data.length > 0 ) {
						
						
							if($("#nanoul span").size()/5<result.data.length)
						{
								console.log("doing some shit: "+$("#nanoul p").size()+" more shit: "+result.data.length);
								$("#Nanotweets").html('');
								

								
								var ul=$('<ul style="display: initial;" id="nanoul"></ul>').appendTo("#Nanotweets");	
						}
								
								
							
							
							
								
							for (var i = $("#nanoul span").size()/5; i < result.data.length; i++) {
//								console.log("Hi: "+ result.data[i].tags);
								if ( result.data[i].status == "COMPLETED" ) {
//									console.log('timestamp '+result.data[i].creation);
									var li = $("<li></li>").appendTo($("#nanoul"));
									li.append('<span class="commentnumber">' + 
										result.data[i].creation + '</span>');
									li.append('<p class="expandable" id="text'+uuid+'_'+i+'">' + result.data[i].original_text+"</p>");
									var comment='';
									if(result.data[i].comment=="")
										comment='No comment found';
									else
										comment=result.data[i].comment;
									
									li.append('<div class="tabGroup">'+
										   '<input type="radio" name="tabGroup'+i+'" id="rad1'+uuid+'_'+i+'" class="tab1" checked=true/>'+
										    '<label for="rad1'+uuid+'_'+i+'">tags</label>'+
										 
										    '<input type="radio" name="tabGroup'+i+'" id="rad2'+uuid+'_'+i+'" class="tab2"/>'+
										    '<label for="rad2'+uuid+'_'+i+'">comment</label>'+
										     
										     
										    '<br/>'+
										 
										    '<div class="tab1"><ul id="tagfield'+uuid+'_'+i+'"></ul></div>'+
										   ' <div class="tab2">'+comment+'</div>'+
										'</div>');
//									li.append('<ul id="tagfield'+uuid+'_'+i+'"></ul>');
									
			//						li.append('<p>' + result.data[i].tags + "</p>");
									
									$('#text'+uuid+'_'+i).expander();
									$("#tagfield"+uuid+"_"+i).tagHandler({
									    assignedTags: result.data[i].tags.split(","),
									    availableTags: result.data[i].tags.split(","),
									    autocomplete: false,
									    allowAdd: false,
									    allowEdit: false
									});
			
									var comment='';
									if(result.data[i].comment.length!=0)
										comment=result.data[i].comment;
									li.append('<span class="icons"><form id="tofacebook_'+result.data[i].id+'" action="./facebookpost" method="post"><textarea name="original_text" style="display:none;">"'+result.data[i].original_text+'"'+'</textarea><textarea name="comment" style="display:none;">'+comment+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><textarea name="id" style="display:none;">'+result.data[i].id+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><button class="zocial icon facebook" name="post">Button label here</button></form><form id="totwitter_'+result.data[i].id+'" action="./twitterpost" method="post"><textarea name="message" style="display:none;">"'+result.data[i].tags+'"'+' '+result.data[i].doi+'</textarea><textarea name="id" style="display:none;">'+result.data[i].id+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><button class="zocial icon twitter" name="post">Button label here</button></form></span>');
									$("#tofacebook_"+result.data[i].id).submit(function() { 
								        // inside event callbacks 'this' is the DOM element so we first 
								        // wrap it in a jQuery object and then invoke ajaxSubmit 
								        $(this).ajaxSubmit(facebookoptions); 
								
								        // !!! Important !!! 
								        // always return false to prevent standard browser submit and page navigation 
								        return false; 
								    }); 
									
									$("#totwitter_"+result.data[i].id).submit(function() { 
								        // inside event callbacks 'this' is the DOM element so we first 
								        // wrap it in a jQuery object and then invoke ajaxSubmit 
								        $(this).ajaxSubmit(twitteroptions); 
								      
								        // !!! Important !!! 
								        // always return false to prevent standard browser submit and page navigation 
								        return false; 
								    }); 

								} else if(result.data[i].status == "EMPTY") {
									

//									console.log('timestamp '+result.data[i].creation);
									var li = $("<li></li>").appendTo($("#nanoul"));
									li.append('<span class="commentnumber">' + 
										result.data[i].creation + '</span>');
									li.append('<p class="expandable" id="text'+uuid+'_'+i+'">' + result.data[i].original_text+"</p>");
									var comment='';
									if(result.data[i].comment=="")
										comment='No comment found';
									else
										comment=result.data[i].comment;
									
									li.append('<div class="tabGroup">'+
										   '<input type="radio" name="tabGroup'+i+'" id="rad1'+uuid+'_'+i+'" class="tab1" checked=true/>'+
										    '<label for="rad1'+uuid+'_'+i+'">tags</label>'+
										 
										    '<input type="radio" name="tabGroup'+i+'" id="rad2'+uuid+'_'+i+'" class="tab2"/>'+
										    '<label for="rad2'+uuid+'_'+i+'">comment</label>'+
										     
										     
										    '<br/>'+
										 
										    '<div class="tab1">No tags found.</div>'+
										   ' <div class="tab2">'+comment+'</div>'+
										'</div>');
//									li.append('<ul id="tagfield'+uuid+'_'+i+'"></ul>');
									
			//						li.append('<p>' + result.data[i].tags + "</p>");
									
									$('#text'+uuid+'_'+i).expander();
											
									var comment='';
									if(result.data[i].comment.length!=0)
										comment='"'+result.data[i].comment+'"';
									li.append('<span class="icons"><form id="tofacebook_'+result.data[i].id+'" action="./facebookpost" method="post"><textarea name="message" style="display:none;">"'+result.data[i].original_text+'"'+'\n'+comment+'\n'+result.data[i].doi+'</textarea><textarea name="id" style="display:none;">'+result.data[i].id+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><button class="zocial icon facebook" name="post">Button label here</button></form><form id="totwitter_'+result.data[i].id+'" action="./twitterpost" method="post"><textarea name="message" style="display:none;">"'+result.data[i].tags+'"'+' '+result.data[i].doi+'</textarea><textarea name="id" style="display:none;">'+result.data[i].id+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><button class="zocial icon twitter" name="post">Button label here</button></form></span>');
									$("#tofacebook_"+result.data[i].id).submit(function() { 
								        // inside event callbacks 'this' is the DOM element so we first 
								        // wrap it in a jQuery object and then invoke ajaxSubmit 
								        $(this).ajaxSubmit(facebookoptions); 
								        
								        // !!! Important !!! 
								        // always return false to prevent standard browser submit and page navigation 
								        return false; 
								    }); 
									
									$("#totwitter_"+result.data[i].id).submit(function() { 
								        // inside event callbacks 'this' is the DOM element so we first 
								        // wrap it in a jQuery object and then invoke ajaxSubmit 
								        $(this).ajaxSubmit(twitteroptions); 
								      
								        // !!! Important !!! 
								        // always return false to prevent standard browser submit and page navigation 
								        return false; 
								    }); 

								
								}
								else if ( result.data[i].status == "WORKING" ) {
									var li = $("<li></li>").appendTo(ul);
									li.append('<span class="commentnumber">'+
										(result.data[i].creation.match(/[A-Za-z]+ [0-9]+, 2[0-9][0-9][0-9]/)[0]) + '</span>');
									li.append("<p>Nanotweeting:</p>");
									li.append('<p class="blockquote" >' + result.data[i].original_text.substring(0,70) + "...</p>");
								}
								
						    }
							
						
							
						
						 	
					} else {
						$("#Nanotweets").html('');
						var ul = $('<ul style="display: initial;"></ul>').appendTo("#Nanotweets");
						ul.append("<li>Nanotweets not found.</li>");
					}
		
				}
		});	
	
	
}



function initViewer(iduuid, containerid){
	uuid=iduuid;
	
	
	$('#Nanotweets').empty();	
	$.getJSON( "document?action=session&uuid=" + uuid, function(result) {
		
		// 
		$('.nanotweets-feed-control').click(function(){ 
			$(this).children('.legend').toggle(); 
			$('.nanotweets-feed').toggle(); 
			
			if ( $('.nanotweets-feed').is(":visible") ) {
				$(containerid).css('right','20%');
			} else {
				$(containerid).css('right','0%');
			}
		});
		
		$.getScript( "//crocodoc.com/webservice/document.js?session=" + result.data.sessionKey, 
			function( data, textStatus, jqxhr ) {
			doi=result.data.doi;
		  	    //creates a document viewer using the "DocViewer" div
		  	    docViewer = new DocViewer({ "id": containerid });
	
		  	  	//on docviewer ready
		  	    docViewer.ready(function(e) {
		  	    
		  	     $('.numpages').text(e.numpages);

		  	 
		
		  		
		  	     
		  	  
		  	  });
		  	   
	
		  	    //docviewer events
		  	    docViewer.bind({
					'pagechange': function(e) {
		  	        	$('.num').text(e.page);
		  	    	}
				});
		  	
		  	    //toolbar events
		  	    $('.zoom-in').click(function() {
		  	        docViewer.zoom('in');
		  	    });
		  	    $('.zoom-out').click(function() {
		  	        docViewer.zoom('out');
		  	    });
		  	    $('.prev').click(function() {
		  	        docViewer.scrollTo('prev');
		  	    });
		  	    $('.next').click(function() {
		  	        docViewer.scrollTo('next');
			  	});
		  	    
		  	    // Text selection 
				
//				if ( (/iphone|ipad|ipod/i).test(navigator.userAgent) ){
//	
//			  	    simpleTip = new Biojs.Tooltip({
//			    		targetSelector: '.page',
//			    		position: Biojs.Tooltip.MANUAL_POSITION,
//			    		arrowType: Biojs.Tooltip.ARROW_RIGHT_MIDDLE,
//			    		cbRender: function( element ) {
//			    			return getNanotweetLink();
//			    		},
//			    		showOnEvent: 'touchend',
//			    		hideOnEvent: 'touchstart'
//			  	  	});
//	
//				    function handleMouseMove(event) {
//				       event = event || window.event; // IE-ism
//				       // event.clientX and event.clientY contain the mouse position
//				    }
//			  	  
//				  	
//					/*
//				  	$('document').bind( "touchstart touchend mouseup click", function (event) {	
//				  		var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
//				  		simpleTip._setPosition(
//				  			{ left: touch.pageX - 10, top: touch.pageY - 10 }, 
//				  			{ width: 20, height: 20 } 
//				  	    );
//			        });
//					
//					*/
//			  	    

		  	    
//		      	  	$('.page').bind( "touchend mouseup", function (e) {  			
//				  	  	var target = jQuery(e.target);
//	
//				        if (simpleTip.timer) { 
//				            clearTimeout(simpleTip.timer); 
//				        }
//				        simpleTip.timer = 0;
//	
//				        simpleTip._body.html( getNanotweetLink() );
//	      
//				        // Show up
//				        simpleTip._show();
//						
//					  	// Tooltip in a fixed position
//						var pos = $("#Nanotweets").offset();
//				  		simpleTip._setPosition(
//				  			pos, { width: simpleTip._body.width(), height: 20 } 
//				  	    );
//				  	
//	
//		            }).bind( "touchstart click", function() {
//		                simpleTip.timer = setTimeout( 
//							'Biojs.getInstance(' + simpleTip.getId()  + ')._hide()' , simpleTip.opt.delay );
//		            });
//					
//					simpleTip._body.bind( "touchstart click", function() {
//						nanotweet();
//					});
//					
//			  	    
//				} else {
//			  	    simpleTip = new Biojs.Tooltip({
//			    		targetSelector: '.page',
//			    		position: Biojs.Tooltip.MOUSE_POSITION,
//			    		arrowType: Biojs.Tooltip.ARROW_TOP_MIDDLE,
//			    		cbRender: function( element ) {
//			    			return getNanotweetLink();
//			    		},
//			    		showOnEvent: 'mouseup',
//			    		hideOnEvent: 'mousedown'
//			  	  	});
//				}
	
			}
		);
		

			
		   $("#viewer").annotator();
		  	$(".annotator-wrapper").attr('style', "position:inherit;");
		  	 $("#viewer").annotator('addPlugin', 'Store', {
		 	     // The endpoint of the store on your server.
		 	     prefix: '/nanotate',

		 	     // Attach the uri of the current page to all annotations to allow search.
		 	     annotationData: {
		 	       'uri': uuid
		 	     },

		 	     // This will perform a "search" action when the plugin loads. Will
		 	     // request the last 20 annotations for the current url.
		 	     // eg. /store/endpoint/search?limit=20&uri=http://this/document/only
		 	     loadFromSearch: {
		 	       'limit': 20,
		 	       'uri': uuid
		 	     }
		 	   });

		  	
		
		feedNanotweets();
	});	  
	
}

/* By http://jquery-manual.blogspot.com */

function set_cookie(nombre, valor, dias)
{
/* El parámetro dias es para la expiración de la cookie */
var fecha = new Date();
var parametro = nombre + "=" + valor;
//Creando la fecha de expiración
fecha.setTime(fecha.getTime() + (dias * 24 * 60 * 60 * 1000));
//Formato UTC para la fecha de expiración
var UTC = fecha.toUTCString();
//Creando la cookie
document.cookie = parametro + "; expires=" + UTC + "; path= /";
}

function get_cookie(nombre)
{
/* Obtenemos todas las cookies */
var cookies = document.cookie;
/* Las separamos a través del ; */
var parametros = cookies.split(";");
var valor="";
/*Recorremos una a una las cookies */
for (var x = 0; x < parametros.length; x++)
{
/* Separamos nombre valor de la cookie a través del signo = */
var parametro = parametros[x].split("=");

/* Buscamos el valor de la cookie a través de su nombre */
if (parametro[0].trim() == nombre)
{
 valor = parametro[1];
break;
}
}
/* Retornamos el valor de la cookie si es encontrada */

return valor;
}

/* Crear las cookies */




	
