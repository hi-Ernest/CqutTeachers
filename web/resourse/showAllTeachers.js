 window.onload = function(){
	 deleteTeacher();
	 updateTeacher();
 }
 function deleteTeacher(){
	 document.getElementById("delete").onclick = function(){
		 document.getElementById("deleteTeacher").style.display = "block";
	 }
 }
 function updateTeacher(){
	 document.getElementById("update").onclick = function(){
		 document.getElementById("updateTeacher").style.display = "block";
	 }
 }
 