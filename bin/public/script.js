$(document).ready(function() {  
  
  $("#ajax").on('click', function(){
    alert('success');
    $.ajax({
      url: "/",
      dataType: 'text',
      type: "post", 
      success: function(data) {        
        $('#status').html(data).attr('class',
        'alert alert-success');
      },
      error: function(data) {
          $('#status').html('Error! Request failed.').attr('class',
          'alert alert-warning');
      }
    });
  });
});