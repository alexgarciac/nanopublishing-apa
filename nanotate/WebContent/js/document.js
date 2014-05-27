var docViewer = undefined;
var simpleTip = undefined;
var uuid = undefined;
var data = undefined;
var doi= undefined;
var global = false;
var options = { 
        target:        '#notification',   // target element(s) to be updated with server response 
        beforeSubmit:  showRequest,  // pre-submit callback 
        success:       showResponse,  // post-submit callback 
 
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
 
    alert('About to submit: \n\n' + queryString); 
 
    // here we could return false to prevent the form from being submitted; 
    // returning anything other than false will allow the form submit to continue 
    return true; 
}
 
// post-submit callback 
function showResponse(responseText, statusText, xhr, $form)  { 
    // for normal html responses, the first argument to the success callback 
    // is the XMLHttpRequest object's responseText property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'xml' then the first argument to the success callback 
    // is the XMLHttpRequest object's responseXML property 
 
    // if the ajaxSubmit method was passed an Options Object with the dataType 
    // property set to 'json' then the first argument to the success callback 
    // is the json data object returned by the server 
 
    alert('status: ' + statusText + '\n\nresponseText: \n' + responseText + 
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

    var html = '<!--<textarea id="userComment"></textarea>-->'
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
		url="nanotate?action=list&doi=";
	else
		url="nanotate?action=personallist&doi=";
	
		$.getJSON( url + doi, function(result) {
				if ( result.code == 0 ) {
					$("#Nanotweets").html('');
					var ul = $('<ul style="display: initial;"></ul>').appendTo("#Nanotweets");
					if ( result.hasOwnProperty('data') && result.data.length > 0 ) {
						for ( var i in result.data ) {
//							console.log("Hi: "+ result.data[i].tags);
							if ( result.data[i].status == "COMPLETED" ) {
//								console.log('timestamp '+result.data[i].creation);
								var li = $("<li></li>").appendTo(ul);
								li.append('<span class="commentnumber">' + 
									result.data[i].creation + '</span>');
								
								li.append('<ul id="tagfield'+uuid+'_'+i+'"></ul>');
								
		//						li.append('<p>' + result.data[i].tags + "</p>");
								
		
								$("#tagfield"+uuid+"_"+i).tagHandler({
								    assignedTags: result.data[i].tags.split(","),
								    availableTags: result.data[i].tags.split(","),
								    autocomplete: false,
								    allowAdd: false,
								    allowEdit: false
								});
		
								
								li.append('<span class="icons"><form id="tofacebook_'+result.data[i].id+'" action="./facebookpost" method="post"><textarea name="message" style="display:none;">'+result.data[i].tags+'		'+result.data[i].doi+'</textarea><textarea name="doi" style="display:none;">'+result.data[i].doi+'</textarea><button class="zocial icon facebook" name="post">Button label here</button></form><form action="./twitterpost" method="post"><textarea name="message" style="display:none;">'+result.data[i].tags+'</textarea><textarea name="callback" style="display:none;">'+"document.jsp?uuid=" + uuid+'</textarea><button class="zocial icon twitter" name="post" type="submit">Button label here</button></form></span>');
								$("#tofacebook_"+result.data[i].id).submit(function() { 
							        // inside event callbacks 'this' is the DOM element so we first 
							        // wrap it in a jQuery object and then invoke ajaxSubmit 
							        $(this).ajaxSubmit(options); 
							        $().toastmessage('showSuccessToast', "Posted to facebook");
							        // !!! Important !!! 
							        // always return false to prevent standard browser submit and page navigation 
							        return false; 
							    }); 
					
							} else if ( result.data[i].status == "WORKING" ) {
								var li = $("<li></li>").appendTo(ul);
								li.append('<span class="commentnumber">'+
									(result.data[i].creation.match(/[A-Za-z]+ [0-9]+, 2[0-9][0-9][0-9]/)[0]) + '</span>');
								li.append("<p>Nanotweeting:</p>");
								li.append('<p class="blockquote" >' + result.data[i].original_text.substring(0,70) + "...</p>");
							}
							
					    } 	
					} else {
						ul.append("<li>Nanotweets not found.</li>");
					}
		
				}
		});	
	
	
}



function initViewer(iduuid){
	uuid=iduuid;
	$('#Nanotweets').empty();	
	$.getJSON( "document?action=session&uuid=" + uuid, function(result) {
		
		// 
		$('.nanotweets-feed-control').click(function(){ 
			$(this).children('.legend').toggle(); 
			$('.nanotweets-feed').toggle(); 
			
			if ( $('.nanotweets-feed').is(":visible") ) {
				$("#DocViewer").css('right','20%');
			} else {
				$("#DocViewer").css('right','0%');
			}
		});
		
		$.getScript( "//crocodoc.com/webservice/document.js?session=" + result.data.sessionKey, 
			function( data, textStatus, jqxhr ) {
			doi=result.data.doi;
		  	    //creates a document viewer using the "DocViewer" div
		  	    docViewer = new DocViewer({ "id": "DocViewer" });
	
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
				
				if ( (/iphone|ipad|ipod/i).test(navigator.userAgent) ){
	
			  	    simpleTip = new Biojs.Tooltip({
			    		targetSelector: '.page',
			    		position: Biojs.Tooltip.MANUAL_POSITION,
			    		arrowType: Biojs.Tooltip.ARROW_RIGHT_MIDDLE,
			    		cbRender: function( element ) {
			    			return getNanotweetLink();
			    		},
			    		showOnEvent: 'touchend',
			    		hideOnEvent: 'touchstart'
			  	  	});
	
				    function handleMouseMove(event) {
				       event = event || window.event; // IE-ism
				       // event.clientX and event.clientY contain the mouse position
				    }
			  	  
				  	
					/*
				  	$('document').bind( "touchstart touchend mouseup click", function (event) {	
				  		var touch = e.originalEvent.touches[0] || e.originalEvent.changedTouches[0];
				  		simpleTip._setPosition(
				  			{ left: touch.pageX - 10, top: touch.pageY - 10 }, 
				  			{ width: 20, height: 20 } 
				  	    );
			        });
					
					*/
			  	    
		      	  	$('.page').bind( "touchend mouseup", function (e) {  			
				  	  	var target = jQuery(e.target);
	
				        if (simpleTip.timer) { 
				            clearTimeout(simpleTip.timer); 
				        }
				        simpleTip.timer = 0;
	
				        simpleTip._body.html( getNanotweetLink() );
	      
				        // Show up
				        simpleTip._show();
						
					  	// Tooltip in a fixed position
						var pos = $("#Nanotweets").offset();
				  		simpleTip._setPosition(
				  			pos, { width: simpleTip._body.width(), height: 20 } 
				  	    );
				  	
	
		            }).bind( "touchstart click", function() {
		                simpleTip.timer = setTimeout( 
							'Biojs.getInstance(' + simpleTip.getId()  + ')._hide()' , simpleTip.opt.delay );
		            });
					
					simpleTip._body.bind( "touchstart click", function() {
						nanotweet();
					});
					
			  	    
				} else {
			  	    simpleTip = new Biojs.Tooltip({
			    		targetSelector: '.page',
			    		position: Biojs.Tooltip.MOUSE_POSITION,
			    		arrowType: Biojs.Tooltip.ARROW_TOP_MIDDLE,
			    		cbRender: function( element ) {
			    			return getNanotweetLink();
			    		},
			    		showOnEvent: 'mouseup',
			    		hideOnEvent: 'mousedown'
			  	  	});
				}
	
			}
		);
		
		feedNanotweets();
	});	  
	
}
	
	
