$(document).ready(function(){

    /* Change color menu on pages */
   selectedMenu = function(){
       if($("span").hasClass("home")){
            $(".myHome").css({
                "color":"black"
            });
       }else if($("span").hasClass("perfil")){
            $(".myPerfil").css({
                "color":"black"
            });
       }else{
            $(".myAccount").css({
                "color":"black"
            });
       }
   }

   /* Change page */ {
        $(".myHome").click(function () { 
            if($("span").hasClass("home") == false)
                $(location).attr('href', 'home.html');
        });
    
        $(".myPerfil").click(function () { 
            if($("span").hasClass("perfil") == false)
                 $(location).attr('href', 'perfil.html');
        });

        $(".myAccount").click(function () { 
            if($("span").hasClass("userAccount") == false)
                $(location).attr('href', 'myAccount.html');
        });
        
   }

   selectedMenu();

});