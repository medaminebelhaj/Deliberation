
 //----------------------------------------------------------------------------------------------------
  $(function() {
        $("#links > a").click(function(e) {
            e.preventDefault(); //so the browser doesn't follow the link
             
            $.ajax({
                type:"get",
                url: 'login',
                asynch: false,
                success: function(data) {
                	$('#content').InnerHtml=data;
                	document.getElementById("content").innerHTML = data;
                   // alert(data);
                } 

            });
        });
    });
//----------------------------------------------------------------------------------------------------