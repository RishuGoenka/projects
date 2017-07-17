<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Code</title>
<style type="text/css" media="screen">

#Header{
position: absolute;
	top: 0;
	bottom: 0;
	right: 0;
	left: 0;
	width: 100%;
	background: skyblue;
}
#editortext {
	position: absolute;
	top: 4%;
	bottom: 3%;
	right: 0;
	left: 0;
	width: 50%;
}
#editor {
	position: absolute;
	top: 4%;
	bottom: 6%;
	left: 50%;
	right: 0;
	width: 50%;
}
#java {
	position: absolute;
	top: 94%;
	right: 0;
	bottom: 0;
	left: 50%;
}
#completion {
	position: absolute;
	top: 94%;
	right: 0;
	bottom: 0;
	left: 52.6%;
	width: 44%;
	background: brown;
}
#submit {
	position: absolute;
	top: 94%;
	right: 0;
	bottom: 0;
	left: 96.5%;
}

#Footer{
position: absolute;
	top: 96.5%;
	bottom: 0;
	right: 0;
	left: 0;
	width: 100%;
	background: green;
}
</style>
</head>
<body>
	<form name="f1" action="code/onSubmit" method="post">
	<div id="Header">Header</div>
		<div id="editortext"></div>
		<div id="editor"><pre>public class Main{
		public static void main(String[] args){
		
		//Write your code.
		
		}
	}</pre></div>
		<input type="hidden" value="key" name="text" id="text">
		<div id="java"><button type="button">Java</button></div>
		<div id="completion"> </div>
		<div id="submit"><input type="submit" name="submit" value="Submit"onClick="divFunction()"></div>
	<div id="Footer">Footer</div>
	</form>
	<script src="ace-builds/src-noconflict/ace.js" type="text/javascript"
		charset="utf-8"></script>
	<script>
	var question = "Question Content";
		var editortext = ace.edit("editortext");
		editortext.setTheme("ace/theme/textmate");
		editortext.getSession().setMode("ace/mode/text");
		editortext.setReadOnly(true);
		editortext.renderer.setShowGutter(false);
		editortext.setShowPrintMargin(false);
		editortext.setHighlightActiveLine(false)
		editortext.setValue(question);

		var editor = ace.edit("editor");
		editor.setTheme("ace/theme/terminal");
		editor.getSession().setMode("ace/mode/java");
		editor.setShowPrintMargin(false);

		function divFunction() {
			var code = editor.getValue();
			document.getElementById("text").value = code;
		}
	</script>
</body>
</html>