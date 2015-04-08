/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showHideDiv(id,id2,id3,id4){
  var obj = document.getElementById(id);
  var obj2 = document.getElementById(id2);
  var obj3 = document.getElementById(id3);
  
  var obj4 = document.getElementById(id4);
    if (obj.style.display=="none"){
      obj.style.display='block';
      obj2.style.display='none';
      obj3.style.display='none';
      
      obj4.style.display='block';
    } else if(obj.style.display=="block"){
      obj.style.display='none';
      obj2.style.display='block';
      obj3.style.display='block';
      obj4.style.display='none';
        }
}
function showNewPassword(id,id2){
  var obj = document.getElementById(id);
  var obj2 = document.getElementById(id2);
    if (obj.style.display=="none"){
      obj.style.display='block';
      obj.style.height = '200px';
      obj2.style.display='none';
    } else if(obj.style.display=="block"){
      obj.style.display='none';
      obj2.style.display='block';
        }
}
