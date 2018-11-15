$(document).ready(function(){

    /* Change color menu on pages */
   selectedMenu = function(){
       if($("span").hasClass("home")){
            $(".myHome").css({
                "color":"black"
            });
       }
       
       if($("span").hasClass("perfil")){
            $(".myPerfil").css({
                "color":"black"
            });
       }
       
       if($("span").hasClass("account")){
            $(".myAccount").css({
                "color":"black"
            });
       }
   }

   selectedMenu();

});