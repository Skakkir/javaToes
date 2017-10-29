$(document).ready(function() {  

  $.ajax({
    url: "/",
    dataType: 'text',
    type: "post", 
    data: "id=" + id,
    success: function(data) {        
      $('#status').html('Request. Success. First route.').attr('class',
      'alert alert-success');
    },
    error: function(data) {
        $('#status').html('Error! Request failed.').attr('class',
        'alert alert-warning');
    }
  });
});