<jsp:directive.include file="head.jsp" />

<div style="display: none" id="test_shared_id">${sharedId}</div>
<script type="text/javascript" src="style/js/problemlist.js"></script>
<script type="text/javascript">
	function startTest() {
		$.get("test-starting", {
			
			test_shared_id:$("#test_shared_id").text()
		});
	}
</script>

<div class="container">

	<h2 id="problem_h2">Loading problems</h2>


	<div class="row">
		<table class="table">

			<thead>
				<tr>
					<td>Problem no</td>
					<td>Problem Name</td>
				</tr>
			</thead>
			<tbody id="problem_list_table"></tbody>

		</table>

		<button class="btn btn-success " type="button" name="Start"
			onclick="startTest()">Start test</button>
	</div>

</div>


<jsp:directive.include file="foot.jsp" />
