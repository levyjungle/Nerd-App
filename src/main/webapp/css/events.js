$(document).ready(function () {
	var url = window.location.href;
	var url = url.replace("https://", "ws://");
	var url = url.replace("http://", "ws://");
	var url = url.replace("home", "");
	url = url+"/globalChatServer";
	var websocket = new WebSocket(url.toString());
    	
        websocket.onmessage = function processMessage(jsonObject){
        	
            var jsonData = JSON.parse(jsonObject.data);
        
            if(check){
            		$('#chat').val('')
                    var html = '<div class="boxMessageStyle userMessage" id="user"><p class="userName">'+Object.keys(jsonData).toString()+'</p><p class="message">'+Object.values(jsonData).toString()+'</p></div>';
                    $("#messageBox").append(html);
            } else {
                    var html = '<div class="boxMessageStyle peopleMessage" id="people"><p class="peopleName">'+Object.keys(jsonData).toString()+'</p><p class="message">'+Object.values(jsonData).toString()+'</p></div>';
                    $("#messageBox").append(html);
            }
            check = false;
        }
    
     sendMessage = function(){
    	if(chat.value != null){
    		websocket.send(chat.value);
    	}
    }
   
     
     $("#buttonChat").click(function () { 
         sendMessage();
         check = true;
     });
     

    $("#chat").keypress(function (e) { 
        var keycode = (e.keycode ? e.keyCode : e.which)
        if(keycode == '13'){
            sendMessage();
            check = true;
        }
    });
   
});