$(document).ready(function() {  
  
  
    $(".cell").on('click', function(){
      
      alert('test');
      var id = this.id.slice(-1);
  


      function togglePlayerStatus(data){
        switch (data) {
          case 'X':
            $('#current-player').html('O');      
            break;
          case 'O':
            $('#current-player').html('X');        
            break;
          default:
            $('#status').html('Unknown error!').attr('class',
            'alert alert-warning');
            break;
        }
      }

      $.ajax({
        url: "/",
        dataType: 'text',
        type: "post", 
        data: "id=" + id,
        success: function(data) {        
          togglePlayerStatus(data);
          document.getElementById("cID"+id).innerHTML = data;
        },
         error: function(data) {
          $('#status').html('Error! Request failed.').attr('class',
          'alert alert-warning');
        }
      });
    });  
  });