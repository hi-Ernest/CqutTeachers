
var students = new Array();//创建一个学生数组
var counts=1;
var number=0;

var studentvalue;//序号
var namevalue;//名字
var collagevalue;//学院
var majorvalue;//专业
var gradevalue;//年级
var classvalue;//班级
var agevalue;//年龄

window.onload=function(){
	displaypage();
}

//添加判断
function judgevalue(){
	var judge = true;
	
	if(!isStudentNo(document.getElementById("addstudent").value)){
		alert("学生编号是11位数字");
		document.getElementById("addstudent").focus();
		judge=false;
		return;
	}
	if(!ischina(document.getElementById("addname").value)){
		alert("学生姓名必须填写中文");
		document.getElementById("addname").focus();
		judge=false;  
		return;
	}

	if(!ischinacollage(document.getElementById("addcollage").value)){
		alert("请填写学院中文名");
		document.getElementById("addcollage").focus();
		judge=false;  
		return;
	}
	if(!ischinamajor(document.getElementById("addmajor").value)){
		alert("请填写专业中文名");
		document.getElementById("addmajor").focus();
		judge=false;  
		return;
	}	
	if(!isStudentgrade(document.getElementById("addgrade").value)){
		alert("年级是4位数字");
		document.getElementById("addgrade").focus();
		judge=false;
		return;
	}
	if(!isStudentclass(document.getElementById("addclass").value)){
		alert("请正确填写班级");
		document.getElementById("addclass").focus();
		judge=false;
		return;
	}
	if(!isStudentage(document.getElementById("addage").value)){
		alert("请正确填写年龄");
		document.getElementById("addage").focus();
		judge=false;
		return;
	}
	ensure();	
}


//正则规范方法集合
function isStudentNo(str) {
	var reg=/^[0-9]{11}$/;  
	return reg.test(str);     
}
function ischina(str) {
	var reg=/^[\u4E00-\u9FA5]{2,4}$/;   
	return reg.test(str);   
}
function ischinacollage(str) {
	var reg=/^[\u4E00-\u9FA5]{2,20}$/;   
	return reg.test(str);   
}
function ischinamajor(str) {
	var reg=/^[\u4E00-\u9FA5]{2,4}$/;   
	return reg.test(str);   
}
function isStudentgrade(str) {
	var reg=/^[0-9]{4}$/;   
	return reg.test(str);    
}
function isStudentclass(str) {
	var reg=/^[0-9]{1,4}$/;   
	return reg.test(str);    
}
function isStudentage(str) {
	var reg=/^[0-9]{2,3}$/;   
	return reg.test(str);    
}


//显示页数
function displaypage(){
	var footerLeft = document.getElementById("footerLeft");
	footerLeft.innerHTML=("第 "+counts+" 页，共 "+ students.length+" 条，（每页显示10条）");

}
var ocheckbox = new Array();
for(var i=0;i<10;i++){
	ocheckbox[i]= document.createElement("input");
	ocheckbox[i].type="checkbox";	
}


function page(){
	// sort();

	var tab = document.getElementById("tab");

	var count = (counts-1)*10;

	for(var num=1;num<11 ;num++){

		var student=students[num+count-1];

		if(num + count < students.length+1){

			tab.rows[num].cells[0].appendChild(ocheckbox[num-1]);
			tab.rows[num].cells[1].innerHTML=count+num;
			tab.rows[num].cells[2].innerHTML=student.studentNum;
			tab.rows[num].cells[3].innerHTML=student.name;
			tab.rows[num].cells[4].innerHTML=student.collage;
			tab.rows[num].cells[5].innerHTML=student.major;
			tab.rows[num].cells[6].innerHTML=student.grade;
			tab.rows[num].cells[7].innerHTML=student.class;
			tab.rows[num].cells[8].innerHTML=student.age;	
			tab.rows[num].cells[9].innerHTML="<span>查看</span>";			
			tab.rows[num].cells[10].innerHTML="<span>修改</span>";

		}
		else{
			tab.rows[num].cells[0].innerHTML="";
			tab.rows[num].cells[3].innerHTML="";
			tab.rows[num].cells[1].innerHTML="";
			tab.rows[num].cells[2].innerHTML="";
			tab.rows[num].cells[4].innerHTML="";
			tab.rows[num].cells[5].innerHTML="";
			tab.rows[num].cells[6].innerHTML="";
			tab.rows[num].cells[7].innerHTML="";
			tab.rows[num].cells[8].innerHTML="";
			tab.rows[num].cells[9].innerHTML="";
			tab.rows[num].cells[10].innerHTML="";

		}
		displaypage();
	}
}

function empty(){

	var tab = document.getElementById("tab");

	for(var num=1;num<11 ;num++){	

		tab.rows[num].cells[0].innerHTML="";
		tab.rows[num].cells[1].innerHTML="";
		tab.rows[num].cells[2].innerHTML="";
		tab.rows[num].cells[3].innerHTML="";
		tab.rows[num].cells[4].innerHTML="";
		tab.rows[num].cells[5].innerHTML="";
		tab.rows[num].cells[6].innerHTML="";
		tab.rows[num].cells[7].innerHTML="";
		tab.rows[num].cells[8].innerHTML="";
		tab.rows[num].cells[9].innerHTML="";
		tab.rows[num].cells[10].innerHTML="";
	}
}


//往前翻页
function nextPageBegin(){

	var number = students.length/10;

	if(counts<number){
		counts++;
	  	page();
	}
	else{
		alert("不能再往后翻了 无任何信息");
	}

	for(var i=0;i<ocheckbox.length;i++){
		ocheckbox[i].checked=false;		
	}
	displaypage();
}


//往后翻页
function lastPageBegin(){

	if(counts>1){
		counts--;
	  	page();
	}
	else{
		alert("不能再往前翻了 无任何信息");
	}
	for(var i=0;i<ocheckbox.length;i++){
	ocheckbox[i].checked=false;		
	}
	displaypage();
}

function allclick(obj){

	if(obj){
		for(var i=0;i<ocheckbox.length;i++){
			ocheckbox[i].checked=true;	
		}
	}
	else{
		for(var i=0;i<ocheckbox.length;i++){
			ocheckbox[i].checked=false;	
		}
	}
}

function emptyvalue(){

	document.getElementById("addstudent").innerHTML="";
	document.getElementById("addname").innerHTML="";
	document.getElementById("addcollage").innerHTML="";
	document.getElementById("addmajor").innerHTML="";
	document.getElementById("addgrade").innerHTML="";
	document.getElementById("addclass").innerHTML="";
	document.getElementById("addage").innerHTML="";
	alert(document.getElementById("addstudent").value);

}



//增加学生信息
function addInterface(){
	//getElementById() 方法可返回对拥有指定 ID 的第一个对象的引用。
	var t1 =document.getElementById("inter");
	t1.style.display='block';//显示样式

	var t2 =document.getElementById("addinter");
	t2.style.display='block';
}

function ensure(){	

		studentvalue=document.getElementById("addstudent").value;
		namevalue=document.getElementById("addname").value;
		collagevalue=document.getElementById("addcollage").value;
		majorvalue=document.getElementById("addmajor").value;
		gradevalue=document.getElementById("addgrade").value;
		classvalue=document.getElementById("addclass").value;
		agevalue=document.getElementById("addage").value;	

		var student = new Object();	

		student.studentNum=studentvalue;	
		student.name=namevalue;
		student.collage=collagevalue;
		student.major=majorvalue;
		student.grade=gradevalue;
		student.class=classvalue;
		student.age=agevalue;

		students.push(student);
		CancelInterface();
		page();
}


function deleteInterface(){	

	var t1 =document.getElementById("inter");
	t1.style.display='block';
	var t2 =document.getElementById("deleteinter");
	t2.style.display='block';

}


//查看信息
function checkInterface(num){	

	var obj =(num-1)+(counts-1)*10;

	var t1 =document.getElementById("inter");
	t1.style.display='block';
	var t2 =document.getElementById("checkinter");
	t2.style.display='block';

	document.getElementById("checkstudent").value=students[obj].studentNum;
	document.getElementById("checkname").value=students[obj].name;
	document.getElementById("checkcollage").value=students[obj].collage;
	document.getElementById("checkmajor").value=students[obj].major;
	document.getElementById("checkgrade").value=students[obj].grade;
	document.getElementById("checkclass").value=students[obj].class;
	document.getElementById("checkage").value=students[obj].age;
	
}


//修改信息
function amendInterface(num){

	var t1 =document.getElementById("inter");
	t1.style.display='block';
	var t2 =document.getElementById("amendinter");
	t2.style.display='block';
	var obj =(num-1)+(counts-1)*10;
	
	document.getElementById("amendstudent").value=students[obj].studentNum;
	document.getElementById("amendname").value=students[obj].name;
	document.getElementById("amendcollage").value=students[obj].collage;
	document.getElementById("amendmajor").value=students[obj].major;
	document.getElementById("amendgrade").value=students[obj].grade;
	document.getElementById("amendclass").value=students[obj].class;
	document.getElementById("amendage").value=students[obj].age;
	a=obj;
}



//修改确定
function amendensure(){

	students[a].studentNum=document.getElementById("amendstudent").value;	
	students[a].name=document.getElementById("amendname").value;
	students[a].collage=document.getElementById("amendcollage").value;
	students[a].major=document.getElementById("amendmajor").value;
	students[a].grade=document.getElementById("amendgrade").value;
	students[a].class=document.getElementById("amendclass").value;
	students[a].age=document.getElementById("amendage").value;

	CancelInterface();
	page();
}


//取消界面显示
function CancelInterface(){
	var t1 =document.getElementById("inter");
	t1.style.display='none';

	var t2 =document.getElementById("addinter");
	t2.style.display='none';

	var t3 =document.getElementById("checkinter") 
	t3.style.display='none';

	var t4 =document.getElementById("amendinter") 
	t4.style.display='none';

	var t5 =document.getElementById("deleteinter") 
	t5.style.display='none';
}


//删除元素
function deleteElement(){
	if(document.getElementById("all").checked==true){
		students.length=0;
	}	
	else{
		for(var i=0;i<ocheckbox.length;i++){
			if(ocheckbox[i].checked)
				students.splice(i,1);
		}	
	}	
	for(var i=0;i<ocheckbox.length;i++){
		ocheckbox[i].checked=false;		
	}
	page();
	document.getElementById("all").checked=false;
	CancelInterface();
}


//修改判断
function amendjudgevalue(){
	var judge = true;

	for (var i = students.length - 1; i >= 0; i--) {
		var j = 0;
		if(document.getElementById("amendstudent").value==students[i].studentNum){
			j++;
			if(j==2)
			{	
				alert("学生编号重复，请重新输入");	
				document.getElementById("amendstudent").focus();
				judge=false;
				return;
			}

		}
	}
	
	if(!isStudentNo(document.getElementById("amendstudent").value)){
		alert("学生编号是11位数字");
		document.getElementById("amendstudent").focus();
		judge=false;
		return;
	}
	if(!ischina(document.getElementById("amendname").value)){
		alert("学生姓名必须填写中文");
		document.getElementById("amendname").focus();
		judge=false;  
		return;
	}

	if(!ischinacollage(document.getElementById("amendcollage").value)){
		alert("请填写学院中文名");
		document.getElementById("amendcollage").focus();
		judge=false;  
		return;
	}
	if(!ischinamajor(document.getElementById("amendmajor").value)){
		alert("请填写专业中文名");
		document.getElementById("amendmajor").focus();
		judge=false;  
		return;
	}	
	if(!isStudentgrade(document.getElementById("amendgrade").value)){
		alert("年级是4位数字");
		document.getElementById("amendgrade").focus();
		judge=false;
		return;
	}
	if(!isStudentclass(document.getElementById("amendclass").value)){
		alert("请正确填写班级");
		document.getElementById("amendclass").focus();
		judge=false;
		return;
	}
	if(!isStudentage(document.getElementById("amendage").value)){
		alert("请正确填写年龄");
		document.getElementById("amendage").focus();
		judge=false;
		return;
	}
	amendensure();	
}