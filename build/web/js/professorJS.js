/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showHideDiv(id){
    var obj = document.getElementById(id);
    if (obj.style.display=="none"){
        obj.style.display='block';
    } else if(obj.style.display=="block"){
        obj.style.display='none';
    }
}

