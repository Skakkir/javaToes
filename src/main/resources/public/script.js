$(document).ready(function() {  
  
  
    $(".cell").on('click', function(){
      
      alert('test');
      var id = this.id.slice(-1);
  
      $.ajax({
        url: "/",
        dataType: 'text',
        type: "post", 
        data: "id=" + id,
        success: function(data) {        
            
         document.getElementById("cID"+id).innerHTML = data;
        },
        error: function(data) {
  
          
        }
      });
    });  
  });