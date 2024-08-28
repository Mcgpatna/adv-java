/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  function toggleSidebar(e){
      e.classList.toggle("show");
      
      var elem = document.getElementById("navID"),
      Style = window.getComputedStyle(elem),
      right = Style.getPropertyValue("right");
              
    if(right == "0px")
    {
        elem.style.right = "-260px";
    }
    else
    {
        elem.style.right = "0px";
    }
  }


